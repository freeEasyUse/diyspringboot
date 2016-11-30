package org.freeuse.spbt.jpa.dao;

import org.freeuse.spbt.jpa.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {
	
	SysUser findByUsername(String username);
	
}
