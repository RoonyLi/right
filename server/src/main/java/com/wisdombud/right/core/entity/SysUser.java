package com.wisdombud.right.core.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.wisdombud.right.core.common.entity.BaseEntity;
import com.wisdombud.right.core.common.entity.LogicDeleteable;

@Entity
public class SysUser extends BaseEntity<Long> implements LogicDeleteable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String userName;

	/**
	 * 使用md5(username + original password + salt)加密存储
	 */
	private String password;

	/**
	 * 加密密码时使用的种子
	 */
	private String salt;

	/**
	 * 创建时间
	 */
	private Date createAt;

	/**
	 * 更新时间
	 */
	private Date updateAt;

	private Integer createBy;
	private Integer updateBy;
	/**
	 * 系统用户的状态
	 */
	private final UserStatus status = UserStatus.normal;

	/**
	 * 逻辑删除flag
	 */
	private Boolean deleted = Boolean.FALSE;

	@ManyToMany(targetEntity = SysRole.class)
	@JoinTable(name = "sysUserRole", inverseJoinColumns = @JoinColumn(name = "userId"), joinColumns = @JoinColumn(name = "roleId"))
	private Set<SysRole> roles;
	@ManyToMany(targetEntity = SysRole.class)
	@JoinTable(name = "sysUserResource", inverseJoinColumns = @JoinColumn(name = "userId"), joinColumns = @JoinColumn(name = "resourceId"))
	private Set<SysResource> resources;

	public SysUser() {

	}

	public SysUser(Long id) {
		this.setId(id);
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Date getCreateAt() {
		return this.createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getUpdateAt() {
		return this.updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public Integer getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public Integer getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}

	public UserStatus getStatus() {
		return this.status;
	}

	@Override
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;

	}

	@Override
	public Boolean getDeleted() {
		return this.deleted;
	}

	@Override
	public void markDeleted() {
		this.deleted = true;
	}

	public Set<SysRole> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<SysRole> roles) {
		this.roles = roles;
	}

	public Set<SysResource> getResources() {
		return this.resources;
	}

	public void setResources(Set<SysResource> resources) {
		this.resources = resources;
	}

}
