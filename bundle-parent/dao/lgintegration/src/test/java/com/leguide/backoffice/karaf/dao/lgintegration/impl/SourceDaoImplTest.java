package com.leguide.backoffice.karaf.dao.lgintegration.impl;

import com.leguide.backoffice.karaf.models.lgintegration.catalog.SourceDTO;
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
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context-test.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class SourceDaoImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private SourceDaoImpl sourceDao;

    @Test
    public void testGetFeedInfos() throws Exception {
        assertThat(sourceDao.getFeedInfos(1l, 1l, true)
                .stream().map(FeedInfosDTO::getSourceId).collect(Collectors.toList()))
                .hasSize(1)
                .contains(35488l);
    }

    @Test
    public void testGetTextMappingForSourceId() throws Exception {
        assertThat(sourceDao.getTextMappingForSourceId(35488l).keySet())
                .contains("id");
    }

    @Test
    public void testGetXMLMappingForSourceId() throws Exception {
        assertThat(sourceDao.getXMLMappingForSourceId(35488l).keySet())
                .contains("id");
    }

    @Test
    public void testGetXSLForSourceId() throws Exception {
        assertEquals("xsl_content", sourceDao.getXSLForSourceId(35488l));
    }

    @Test
    public void testGetFeedInfosForShopsiteId() throws Exception {
        assertThat(sourceDao.getFeedInfosForShopsiteId(2094l)
                .stream().map(FeedInfosDTO::getSourceId).collect(Collectors.toList()))
                .hasSize(1)
                .contains(35488l);
    }

    @Test
    public void testGetSourcesForShopsiteId() throws Exception {
        assertThat(sourceDao.getSourcesForShopsiteId(2094l)
                .stream().map(SourceDTO::getSourceId).collect(Collectors.toList()))
                .hasSize(1)
                .contains(35488l);
    }
}