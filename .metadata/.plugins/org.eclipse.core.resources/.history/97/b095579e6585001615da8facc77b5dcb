package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.niit.model.Blog;
import com.niit.model.BlogComment;
import com.niit.model.Event;
import com.niit.model.Forum;
import com.niit.model.ForumPost;
import com.niit.model.ForumPostComment;
import com.niit.model.JobOpportunity;
import com.niit.model.User;
@EnableWebMvc
@Configuration
@EnableTransactionManagement
@ComponentScan("com.niit")
public class ApplicationContextConfig extends WebMvcConfigurerAdapter{
	
	@Bean(name = "datasource")
	public DataSource getOracleDatasource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		datasource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		datasource.setUsername("niituser");
		datasource.setPassword("oracle");
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");		
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		datasource.setConnectionProperties(properties);
		return datasource;
	}

	
	
	@Bean
	public SessionFactory getSessionFactory(DataSource datasource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(datasource);
		
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Blog.class);
		sessionBuilder.addAnnotatedClass(BlogComment.class);
		sessionBuilder.addAnnotatedClass(Event.class);
		sessionBuilder.addAnnotatedClass(Forum.class);
		sessionBuilder.addAnnotatedClass(ForumPost.class);
		sessionBuilder.addAnnotatedClass(ForumPostComment.class);
		sessionBuilder.addAnnotatedClass(JobOpportunity.class);
		return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransctionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;

	}


}
