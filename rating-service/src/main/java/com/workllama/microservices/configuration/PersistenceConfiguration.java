package com.workllama.microservices.configuration;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories({ "com.workllama" })
@PropertySources({
		@PropertySource(value = "file:${config.dir}/resourceconfig.properties", ignoreResourceNotFound = true),
		@PropertySource(value = "file:${config.dir}/workllama.properties", ignoreResourceNotFound = true), })
public class PersistenceConfiguration {

	@Autowired
	private Environment env;

	/**
	 * @return
	 */
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(Boolean.getBoolean(env.getProperty("wlserver.jdbc.showSql")));
		adapter.setDatabasePlatform(env.getProperty("wlserver.jdbc.databasePlatform"));
		return adapter;
	}

	/**
	 * @return
	 */
	@Bean
	public DataSource dataSource() {
		org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
		dataSource.setDriverClassName(env.getProperty("wlserver.jdbc.driver"));
		dataSource.setUrl(env.getProperty("wlserver.jdbc.url"));
		dataSource.setUsername(env.getProperty("wlserver.jdbc.username"));
		dataSource.setPassword(env.getProperty("wlserver.jdbc.password"));
		dataSource.setValidationQuery(env.getProperty("wlserver.jdbc.validationQuery"));
		dataSource.setValidationInterval(60000);
		// dataSource.setMaxActive(Integer.getInteger(env.getProperty("wlserver.jdbc.maxActive")));
		dataSource.setTestOnBorrow(true);
		return dataSource;
	}

	/**
	 * @param emf
	 * @return
	 */
	@Bean
	@Autowired
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(emf);
		return txManager;
	}

	/**
	 * @return
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan(new String[] { 
				"com.workllama" });
		emf.setJpaVendorAdapter(jpaVendorAdapter());
		emf.setJpaProperties(jpaProperties());
		return emf;
	}

	/**
	 * @return
	 */
	private Properties jpaProperties() {
		Properties prop = new Properties();
		prop.setProperty("hibernate.id.new_generator_mappings",
				env.getProperty("wlhibernate.id.new_generator_mappings"));
		prop.setProperty("hibernate.cache.use_second_level_cache", "false");
		return prop;
	}
}
