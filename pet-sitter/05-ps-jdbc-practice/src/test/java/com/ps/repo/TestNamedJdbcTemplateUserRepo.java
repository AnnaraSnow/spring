package com.ps.repo;

import com.ps.config.AppConfig;
import com.ps.config.TestDataConfig;
import com.ps.ents.User;
import com.ps.repos.UserRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by iuliana.cosmina on 6/4/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDataConfig.class, AppConfig.class})
@ActiveProfiles("dev")
// DONE 30. [BONUS] Write test methods to cover all methods in JdbcNamedTemplateUserRepo
public class TestNamedJdbcTemplateUserRepo {

    @Autowired
    @Qualifier("userNamedTemplateRepo")
    UserRepo userRepo;

    @Before
    public void setUp() {
        assertNotNull(userRepo);
    }

    @Test
    public void testFindById() {
        User user = userRepo.findById(1L);
        assertEquals("John", user.getUsername());
    }

    @Test(expected = DataAccessException.class)
    public void testNoFindById() {
        User user = userRepo.findById(99L);
        assertEquals("John", user.getUsername());
    }

    @Test
    public void testDeleteById(){
        User user = userRepo.findById(1L);
        assertEquals("John", user.getUsername());

        int rowsAffected = userRepo.deleteById(user.getId());

        assertEquals(1, rowsAffected);
    }

    @Test
    public void testNoDeleteById(){

        int rowsAffected = userRepo.deleteById(5L);
        assertEquals(0, rowsAffected);
    }
}
