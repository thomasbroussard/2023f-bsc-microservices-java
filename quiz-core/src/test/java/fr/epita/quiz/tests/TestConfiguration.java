package fr.epita.quiz.tests;

import fr.epita.quiz.services.DataAccessService;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class TestConfiguration {


    @Bean
    public String fakeComponent(){
        return "hello world";
    }

    @Bean
    public DataSource connectionProvider(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        driverManagerDataSource.setUsername("test");
        driverManagerDataSource.setPassword("test");
        driverManagerDataSource.setDriverClassName("org.h2.Driver");
        return driverManagerDataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource){
        LocalSessionFactoryBean sfBean = new LocalSessionFactoryBean();
        sfBean.setDataSource(dataSource);
        sfBean.setPackagesToScan("fr.epita.quiz.datamodel");

        // Configure Hibernate properties
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        hibernateProperties.setProperty("hibernate.show_sql", "true");
        hibernateProperties.setProperty("hibernate.format_sql", "true");

        sfBean.setHibernateProperties(hibernateProperties);

        return sfBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

    @Bean
    public DataAccessService dataAccessService(DataSource dataSource){
        return new DataAccessService(dataSource);
    }

}
