package com.wisdombud.right.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.wisdombud.right.core.entity.SysUserRole;

public interface SysUserRoleRepository extends CrudRepository<SysUserRole, Long> {
	public List<SysUserRole> findByUserId(Long userId);
}
