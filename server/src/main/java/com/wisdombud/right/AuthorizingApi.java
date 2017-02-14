package com.wisdombud.right;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wisdombud.right.common.RightCodeEnum;
import com.wisdombud.right.core.entity.SysMenu;
import com.wisdombud.right.core.entity.SysRole;
import com.wisdombud.right.core.entity.SysUser;
import com.wisdombud.right.core.entity.UserAuthenticInfo;
import com.wisdombud.right.core.entity.UserAuthenticInfoWrap;
import com.wisdombud.right.core.entity.UserStatus;
import com.wisdombud.right.domain.SysButtonRepository;
import com.wisdombud.right.domain.SysMenuRepository;
import com.wisdombud.right.domain.SysRoleRepository;
import com.wisdombud.right.domain.SysUserRepository;
import com.wisdombud.right.domain.SysUserRoleRepository;
import com.wisdombud.right.utils.UserPasswordUtil;

/**
 * This guy is lazy, nothing left.
 *
 * @author John Zhang
 */
@RestController
public class AuthorizingApi {

	@Autowired
	private SysUserRepository userRepo;
	@Autowired
	private SysMenuRepository menuRepo;

	@Autowired
	private SysButtonRepository buttonRepo;

	@Autowired
	private SysRoleRepository roleRepo;
	@Autowired
	private SysUserRoleRepository userRoleRepo;

	@RequestMapping("/test")
	public ResponseEntity test() {
		final SysUser user = this.userRepo.findAll().iterator().next();
		return ResponseEntity.ok(user);
	}

	@RequestMapping("/login")
	public ResponseEntity login(@RequestParam String userName, @RequestParam String password) {
		final SysUser user = this.userRepo.findByUserName(userName);
		final UserAuthenticInfoWrap wrap = new UserAuthenticInfoWrap();
		if (user == null || user.getDeleted()) {
			wrap.setCode(RightCodeEnum.UserNotExists.getCode());
			return ResponseEntity.ok(wrap);
		}
		if (user.getStatus() == UserStatus.blocked) {
			wrap.setCode(RightCodeEnum.UserBlocked.getCode());
			return ResponseEntity.ok(wrap);
		}
		if (!UserPasswordUtil.checkPassword(password, user)) {
			wrap.setCode(RightCodeEnum.UserPasswordNotMatch.getCode());
			return ResponseEntity.ok(wrap);
		}
		// TODO: 重试次数

		final Set<SysRole> roles = user.getRoles();
		final Set<SysMenu> menus = new HashSet<>();
		for (final SysRole sysRole : roles) {
			menus.addAll(sysRole.getMenus());
		}
		final UserAuthenticInfo userAuthenticInfo = new UserAuthenticInfo();
		userAuthenticInfo.setCurrentUser(user);
		userAuthenticInfo.setSysMenu(menus);
		userAuthenticInfo.setSysResources(user.getResources());
		wrap.setCode(200);
		wrap.setUserAuthenticInfo(userAuthenticInfo);
		return ResponseEntity.ok(wrap);
	}

}
