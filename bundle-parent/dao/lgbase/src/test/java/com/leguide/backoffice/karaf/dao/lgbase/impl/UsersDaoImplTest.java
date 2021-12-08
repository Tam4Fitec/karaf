package com.leguide.backoffice.karaf.dao.lgbase.impl;

import com.leguide.backoffice.karaf.dao.lgbase.UsersDao;
import com.leguide.backoffice.karaf.models.lgbase.users.Users;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context-test.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class UsersDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private UsersDao usersDao;

    @Test
    public void testCreate() throws Exception {
        Users user = new Users();
        user.setEmail("user2@leguide.com");

        assertNull(usersDao.findById(11l));
        usersDao.create(user);
        assertNotNull(usersDao.findById(11l));
    }

    @Test
    public void testUpdate() throws Exception {
        Users user = usersDao.findById(10l);
        assertEquals("first", user.getFirstname());
        user.setFirstname("first_2");
        usersDao.update(user);
        assertEquals("first_2", usersDao.findById(10l).getFirstname());
    }

    @Test
    public void testFindById() throws Exception {
        assertNotNull(usersDao.findById(10l));
    }

    @Test
    public void testDeleteById() throws Exception {
        assertNotNull(usersDao.findById(1l));
        usersDao.deleteById(1l);
        assertNull(usersDao.findById(1l));
    }

    @Test
    public void testFindByEmail() throws Exception {
        Optional<Users> usersOptional = usersDao.findByEmail("user@leguide.com");
        assertThat(usersOptional.map(Users::getEmail)).isPresent().contains("user@leguide.com");
    }

    @Test
    public void testFindUsersIdByShopsiteId() throws Exception {
        List<Long> res = usersDao.findUsersByShopsite(1000l);
        assertNotNull(res);
        assertTrue(res.size() == 1);
        assertEquals(Long.valueOf(10), res.get(0));
    }

    @Test
    @Ignore
    /**
     * Ignore because "binary" function doesn't exist in H2
     */
    public void testFindByEmailAndPassword() throws Exception {
        Optional<Users> usersOptional = usersDao.findByEmailAndPassword("user@leguide.com", "test");
        assertThat(usersOptional.map(Users::getEmail)).isPresent().contains("user@leguide.com");

        Optional<Users> usersOptional2 = usersDao.findByEmailAndPassword("user@leguide.com", "test2");
        assertThat(usersOptional2.map(Users::getEmail)).isEmpty();
    }

    @Test
    public void testFindFirstByShopsite() throws Exception {
        assertNotNull(usersDao.findFirstByShopsite(1000l));
    }

    @Test
    public void testFindAllByShopsiteAndRoles() throws Exception {
    	List<Users> users = usersDao.findAllByShopsiteAndRoles(1000l, Arrays.asList(1));
    	assertEquals(users.size(), 1);
    	
    	Long userId = users.get(0).getUserId();
    	assertEquals(userId, Long.valueOf(10L));

    }
}