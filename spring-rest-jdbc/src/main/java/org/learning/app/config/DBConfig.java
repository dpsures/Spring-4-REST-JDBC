package org.learning.app.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource(value = {"classpath:db.properties"})
public class DBConfig {

	@Autowired
	private Environment env;

	@Bean
	public DataSource getDataSource(){
		DriverManagerDataSource manager = new DriverManagerDataSource();
		manager.setUrl(env.getRequiredProperty("jdbc.url"));
		manager.setDriverClassName(env.getRequiredProperty("jdbc.driver"));
		manager.setUsername(env.getRequiredProperty("jdbc.username"));
		manager.setPassword(env.getRequiredProperty("jdbc.password"));
		return manager;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate(){
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(getDataSource());
		template.setResultsMapCaseInsensitive(true);
		return template;
	}
}
