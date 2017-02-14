package com.wisdombud.right;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wisdombud.right.core.entity.SysUser;
import com.wisdombud.right.domain.SysUserRepository;
import com.wisdombud.right.utils.UserPasswordUtil;

@RestController
public class UserApi {
	@Autowired
	private SysUserRepository userRepo;

	@RequestMapping(name = "/api/v1/user/save")
	public ResponseEntity insertUser(@RequestParam("userName") String userName,
			@RequestParam("password") String password) {
		if (this.userRepo.findByUserName(userName) != null) {
			return ResponseEntity.ok("用户名重复");
		}
		final SysUser user = new SysUser();
		user.setUserName(userName);
		user.setPassword(password);
		UserPasswordUtil.encodePassword(user);
		this.userRepo.save(user);
		return ResponseEntity.ok().build();
	}

}
