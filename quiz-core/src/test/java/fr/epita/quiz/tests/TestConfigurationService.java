package fr.epita.quiz.tests;

import fr.epita.quiz.services.ConfigurationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestConfigurationService {

    @Test
    public void test() {
        ConfigurationService cs = ConfigurationService.getInstance();

        String dbUrl = cs.getConfEntry("db.url", "");

        Assertions.assertNotNull(dbUrl);
        Assertions.assertEquals(dbUrl, "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
    }
}
