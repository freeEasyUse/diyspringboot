package org.freeuse.spbt.dao;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * spring boot 层配置
 * @author GeL
 *
 */

@Configuration
//jpa 扫描的包
@EnableJpaRepositories(basePackages = "org.freeuse.spbt.jpa")
//@EnableMongoRepositories  mongo扫描的包
public class DaoConfig {

}
