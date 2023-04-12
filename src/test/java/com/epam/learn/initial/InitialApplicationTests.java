package com.epam.learn.initial;

import com.epam.learn.initial.config.CustomDataSourceConfig;
import com.epam.learn.initial.config.ProfileConfig;
import com.epam.learn.initial.entity.Person;
import com.epam.learn.initial.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ActiveProfiles("DEV")
class InitialApplicationTests {

    @Autowired
    private PersonService personService;

    @Autowired
    ProfileConfig profileConfig;

    @Autowired
    private CustomDataSourceConfig dataSourceConfig;

    @Test
    public void testCustomDataSource() throws SQLException {
        assertNotNull(dataSourceConfig);
        try (var connection = dataSourceConfig.customDataSource().getConnection()) {
            assertNotNull(connection);
            assertTrue(connection.isValid(5));
        }
    }

    @Test
    void testSavePerson() {
        var person = new Person();
        person.setFirstName("Shon");
        person.setLastName("Pen");
        personService.savePerson(person);

        assertEquals(1, personService.getAllPersons().size());
    }

    @Test
    public void testActiveProfileConfig() {
        var port = profileConfig.tomcatFactory().getPort();
        assertEquals(port, 8090);
    }

}
