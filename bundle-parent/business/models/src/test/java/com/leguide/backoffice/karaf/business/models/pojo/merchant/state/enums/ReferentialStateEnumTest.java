package com.leguide.backoffice.karaf.business.models.pojo.merchant.state.enums;

import static com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.ReferentialStateEnum.NORMAL_CLIENT;
import static com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.ReferentialStateEnum.REFERENCED_FREE;
import static com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.ReferentialStateEnum.REFERENCED_FREE_PLUS;
import static org.junit.Assert.*;

import org.junit.Test;

import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.ReferentialStateEnum;

public class ReferentialStateEnumTest {

	@Test
	public void testGetReferentialStateById() {
		assertEquals(NORMAL_CLIENT, ReferentialStateEnum.getReferentialStateById(1L));
		assertEquals(REFERENCED_FREE, ReferentialStateEnum.getReferentialStateById(new Long(18)));
		assertEquals(REFERENCED_FREE_PLUS, ReferentialStateEnum.getReferentialStateById(17L));
	}

}
