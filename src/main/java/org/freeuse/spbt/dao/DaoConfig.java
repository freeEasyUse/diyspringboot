package org.freeuse.spbt.dao;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * spring boot dao层配置
 * @author GeL
 *
 */

@Configuration
//jpa 扫描的包
//@EnableJpaRepositories(basePackages = "org.freeuse.spbt.jpa")
//@EnableMongoRepositories  // mongo扫描的包
public class DaoConfig {

	
	/**
	 * 定义jpa事务管理
	 * @return
	 */
	@Bean(name="jpaTransaction",value = "jpaTransaction")
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new JpaTransactionManager();
	}
	
}
