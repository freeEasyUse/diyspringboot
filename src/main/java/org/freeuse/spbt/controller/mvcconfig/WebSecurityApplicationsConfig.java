package org.freeuse.spbt.controller.mvcconfig;

import javax.sql.DataSource;

import org.freeuse.spbt.service.imple.SysUserServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * spring security config
 * 
 * @author GeL
 *
 */
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityApplicationsConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private SysUserServiceImple sysUserServiceImple;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().fullyAuthenticated().and().formLogin().loginPage("/login")
				.failureUrl("/login?error").permitAll().and().logout().permitAll();
	}

	/*
	 * @Override public void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * auth.inMemoryAuthentication().withUser("admin").password("admin")
	 * .roles("ADMIN", "USER").and().withUser("user").password("user")
	 * .roles("USER"); }
	 */

	/**
	 * jdbc中的用户认证
	 */
	/*
	 * @Override public void configure(AuthenticationManagerBuilder auth) throws
	 * Exception{
	 * 
	 * auth.jdbcAuthentication().dataSource(dataSource);
	 * 
	 * }
	 */

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		//自定義的登陸控制
		auth.userDetailsService(sysUserServiceImple);

	}

}
