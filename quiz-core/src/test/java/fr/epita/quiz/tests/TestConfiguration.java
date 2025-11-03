package fr.epita.quiz.tests;

import fr.epita.quiz.services.DataAccessService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.sql.DriverManager;

@Configuration
public class TestConfiguration {


    @Bean
    public String fakeComponent(){
        return "hello world";
    }

    @Bean
    public DataSource connectionProvider(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        //password, user, etc...
        return driverManagerDataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(DataSource dataSource){
        LocalSessionFactoryBean sfBean = new LocalSessionFactoryBean();
        sfBean.setDataSource(dataSource);
        sfBean.setPackagesToScan("fr.epita.quiz.datamodel");

        return sfBean ;
    }


    @Bean
    public DataAccessService dataAccessService(DataSource dataSource){
        return new DataAccessService(dataSource);
    }

}
