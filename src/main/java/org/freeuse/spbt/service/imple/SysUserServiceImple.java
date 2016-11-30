package org.freeuse.spbt.service.imple;

import org.freeuse.spbt.jpa.dao.SysUserRepository;
import org.freeuse.spbt.jpa.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class SysUserServiceImple implements UserDetailsService {

	@Autowired
	private SysUserRepository sysUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		SysUser sysUser = sysUserRepository.findByUsername(username);
		if(sysUser==null){
			throw new UsernameNotFoundException("用户名不存在");
		}
		return sysUser;
	}

}
