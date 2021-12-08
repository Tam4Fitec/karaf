package com.leguide.backoffice.karaf.dao;

import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.BeforeTransaction;

/**
 * @author Oliver Gierke
 */
public abstract class AbstractDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    @BeforeTransaction
    public void setupData() throws Exception {
        if (countRowsInTable("brands") == 0) {
            executeSqlScript("classpath:data.sql", false);
        }
    }
}
