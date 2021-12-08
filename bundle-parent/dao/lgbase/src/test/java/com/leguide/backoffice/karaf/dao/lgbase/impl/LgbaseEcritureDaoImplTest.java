package com.leguide.backoffice.karaf.dao.lgbase.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.leguide.backoffice.karaf.dao.lgbase.LgbaseEcritureDao;
import com.leguide.backoffice.karaf.models.lgbase.billing.LgbaseEcriture;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context-test.xml")
public class LgbaseEcritureDaoImplTest {

	@Autowired
	private LgbaseEcritureDao ecritureDao;

	@Test
	public void testGetBalance() {
		assertEquals(200.0, ecritureDao.getBalance("1000BEBES"), 0.0);
	}

	@Test
	public void testGetEcritureForClient() {
		List<LgbaseEcriture> ecritures = ecritureDao.getEcritureForClient("1000BEBES");
		assertEquals(2, ecritures.size());
		assertEquals(400.0f, ecritures.get(1).getDebit(), 0.0);
		assertEquals(200.0f, ecritures.get(0).getCredit(), 0.0);
	}
}
