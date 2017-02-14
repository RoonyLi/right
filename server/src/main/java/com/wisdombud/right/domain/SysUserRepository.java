package com.wisdombud.right.domain;

import org.springframework.data.repository.CrudRepository;

import com.wisdombud.right.core.entity.SysUser;

public interface SysUserRepository extends CrudRepository<SysUser, Long> {
	public SysUser findByUserName(String userName);
}
