package fr.epita.spring.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.SQLException;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = ConfigurationDemo.class)
public class TestSpringDI {


    @Autowired
    private DataSource dataSource;

    @Test
    public void testDI() throws SQLException {
       Assertions.assertNotNull(dataSource);
       dataSource.getConnection();
    }
}
