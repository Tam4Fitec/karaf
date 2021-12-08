package com.leguide.backoffice.karaf.dao.lgbase.impl;

import com.leguide.backoffice.karaf.dao.lgbase.UsersRoleDao;
import com.leguide.backoffice.karaf.models.lgbase.users.UsersRole;
import com.leguide.backoffice.karaf.models.lgbase.users.UsersRoleKey;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context-test.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class UsersRoleDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private UsersRoleDao usersRoleDao;

    @Test
    public void testFindById() throws Exception {
        assertNotNull(usersRoleDao.findById(new UsersRoleKey(10l, 1l, 1000l)));
    }

    @Test
    public void testExistCoupleUserAccount() throws Exception {
        assertTrue(usersRoleDao.existCoupleUserAccount(1l, 100l));
    }

    @Test
    public void testCreate() throws Exception {
        UsersRoleKey urk = new UsersRoleKey(10l, 2l, 100l);
        UsersRole usersRole = new UsersRole();
        usersRole.setUsersRoleKey(urk);
        assertNull(usersRoleDao.findById(urk));
        usersRoleDao.create(usersRole);
        assertNotNull(usersRoleDao.findById(urk));
    }

    @Ignore
    @Test
    public void testUpdateAccountId() throws Exception {
        assertNotNull(usersRoleDao.findById(new UsersRoleKey(1l, 2l, 100l)));
        assertNull(usersRoleDao.findById(new UsersRoleKey(1l, 2l, 101l)));
        usersRoleDao.updateAccountId(101l, 100l, 10l);
        assertNotNull(usersRoleDao.findById(new UsersRoleKey(1l, 2l, 101l)));
        assertNull(usersRoleDao.findById(new UsersRoleKey(1l, 2l, 100l)));
    }

    @Test
    public void testDelete() throws Exception {
        UsersRole usersRole = usersRoleDao.findById(new UsersRoleKey(1l, 2l, 100l));
        assertNotNull(usersRole);
        usersRoleDao.delete(usersRole);
        assertNull(usersRoleDao.findById(new UsersRoleKey(1l, 2l, 100l)));
    }

    @Ignore
    @Test
    public void testDeleteByUserId() throws Exception {
        assertNotNull(usersRoleDao.findById(new UsersRoleKey(10l, 1l, 1000l)));
        usersRoleDao.deleteByUserId(10l);
        assertNull(usersRoleDao.findById(new UsersRoleKey(10l, 1l, 1000l)));
    }

    @Test
    public void testDeleteByPK() throws Exception {
        assertNotNull(usersRoleDao.findById(new UsersRoleKey(1l, 2l, 100l)));
        usersRoleDao.deleteByPK(1l, 2l, 100l);
        assertNull(usersRoleDao.findById(new UsersRoleKey(1l, 2l, 100l)));
    }

    @Test
    public void testIsUserLinkedToSeveralRoles() throws Exception {
        assertTrue(usersRoleDao.isUserLinkedToSeveralRoles(1l));
        assertFalse(usersRoleDao.isUserLinkedToSeveralRoles(10l));
    }
}