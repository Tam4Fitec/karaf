package com.leguide.backoffice.karaf.dao.lgintegration.impl;

import com.leguide.backoffice.karaf.models.lgintegration.custom.FeedFunctionDTO;
import com.leguide.backoffice.karaf.models.lgintegration.custom.FeedInfosDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context-test.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class SourceFunctionDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private SourceFunctionDaoImpl sourceFunctionDao;

    @Test
    public void testGetFeedfunctionForSourceId() throws Exception {
        assertThat(sourceFunctionDao.getFeedfunctionForSourceId(35488l)
                .stream().map(FeedFunctionDTO::getFunctionName).collect(Collectors.toList()))
                .hasSize(1)
                .contains("lg_force");
    }
}