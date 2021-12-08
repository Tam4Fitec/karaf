package com.leguide.backoffice.karaf.bundle.business.contact;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.leguide.backoffice.karaf.bundle.business.contact.routes.beans.SmartFocusBuilder;
import com.leguide.backoffice.karaf.bundle.business.contact.routes.pojo.SmartFocusUpdatePOJO;
import com.leguide.backoffice.karaf.bundle.dao.facade.ShopSiteDao;
import com.leguide.backoffice.karaf.business.models.pojo.contact.Contact;
import com.leguide.backoffice.karaf.business.models.pojo.contact.enums.ContactCivilityEnum;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.ShopSiteState;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.ReferentialStateEnum;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.enums.SegmentationEnum;
import com.leguide.backoffice.karaf.dao.lgbase.LgbaseAccountStoreDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:META-INF/spring/applicationContext.xml"})
public class SmartFocusBuilderTest {

    @Autowired
    private CamelContext context;
    private LgbaseAccountStoreDao lgAccountStoreDAO = mock(LgbaseAccountStoreDao.class);
    private ShopSiteDao shopSiteDao = mock(ShopSiteDao.class) ;

    private static List<Long> shopsiteIds= new ArrayList<Long>(2);
    static {
        shopsiteIds.add(1000l);
        shopsiteIds.add(1001l);
    }

    private static ShopSiteState state1000 =new ShopSiteState(ReferentialStateEnum.NORMAL_CLIENT, null, SegmentationEnum.D);
    private static ShopSiteState state1001 =new ShopSiteState(ReferentialStateEnum.CAPPED, null, SegmentationEnum.C);

    private SmartFocusBuilder builder = new SmartFocusBuilder();
    {
        when(lgAccountStoreDAO.getListIdShopsiteByAccountId(any(Long.class))).thenReturn(shopsiteIds);
        builder.setLgAccountStoreDAO(lgAccountStoreDAO);
        when(shopSiteDao.findStateOfShopSite(1000l)).thenReturn(state1000);
        when(shopSiteDao.findStateOfShopSite(1001l)).thenReturn(state1001);
        builder.setShopSiteDao(shopSiteDao);
    }

    private Contact contact = new Contact();
    {
        contact.setContactId(500l);
        contact.setCivility(ContactCivilityEnum.MR);
        contact.setFirstName("firstName");
        contact.setLastName("lastName");
        contact.setSelfcareAccountId(1500l);
        contact.setEmail("email");
        contact.setCountry("country");
        contact.setOptOutToken("optouttokenlg");
        contact.setOptOutTokenPartner("optouttokenpartner");
        contact.setIsOptInLG("Y");
        contact.setIsOptInPartner("N");
    }

    @Test
    public void testConvertContact() {
        SmartFocusUpdatePOJO pojo = builder.convert(contact);
        assertNotNull(pojo);
        assertEquals(contact.getContactId(), pojo.getContactId());
        assertEquals(contact.getSelfcareAccountId(), pojo.getAccountId());
        assertEquals(contact.getFirstName(), pojo.getFirstName());
        assertEquals(contact.getLastName(), pojo.getLastName());
        assertEquals(Integer.valueOf(contact.getCivility().getId()), pojo.getCivility());
        assertEquals(contact.getEmail(), pojo.getEmail());
        assertEquals(contact.getCountry(), pojo.getCountry());
        assertEquals(contact.getOptOutToken(), pojo.getOptOutToken());
        assertEquals(contact.getOptOutTokenPartner(), pojo.getOptOutTokenPartner());
        assertEquals(Integer.valueOf(1), pojo.getOptInLG());
        assertEquals(Integer.valueOf(0), pojo.getOptInPartner());
    }

    @Test
    public void testCreateBody() {
        assertNotNull(context);
        Exchange e = context.getEndpoint("direct:fake").createExchange();
        assertNotNull(e);

        builder.buildBody(builder.convert(contact), e);
        assertNotNull(e.getIn().getHeader("synchro.smartfocus.body"));
        Map<String, Object> body = e.getIn().getHeader("synchro.smartfocus.body", Map.class);

        assertEquals(contact.getFirstName(), body.get("FIRSTNAME"));
        assertEquals(contact.getLastName(), body.get("LASTNAME"));
        assertEquals(Integer.valueOf(contact.getCivility().getId()), body.get("TITLE"));
        assertEquals(contact.getEmail(),  body.get("EMAIL"));
        assertEquals(contact.getCountry(),  body.get("COUNTRY"));
        assertEquals(Integer.valueOf(1),  body.get("IS_OPTIN_NL"));
        assertEquals(Integer.valueOf(0),  body.get("IS_OPTIN_PART"));
        assertEquals(contact.getContactId(),  body.get("USER_ID"));
        assertEquals(contact.getOptOutToken(), body.get("OPT_OUT_TOKEN"));
        assertEquals(contact.getOptOutTokenPartner(), body.get("OPT_OUT_PART_TOKEN"));
    }

    @Test
    public void testCreateBodyDeleteContact() {
        assertNotNull(context);
        Exchange e = context.getEndpoint("direct:fake").createExchange();
        assertNotNull(e);

        builder.buildBodyOptOut(builder.convert(contact), e);
        assertNotNull(e.getIn().getHeader("synchro.smartfocus.body"));
        Map<String, Object> body = e.getIn().getHeader("synchro.smartfocus.body", Map.class);

        assertNull(body.get("FIRSTNAME"));
        assertNull(body.get("LASTNAME"));
        assertNull(body.get("TITLE"));
        assertNull(body.get("EMAIL"));
        assertNull(body.get("COUNTRY"));
        assertNull(body.get("USER_ID"));
        assertNull(body.get("OPT_OUT_TOKEN"));
        assertNull(body.get("OPT_OUT_PART_TOKEN"));
        assertEquals(Integer.valueOf(0), body.get("IS_OPTIN_NL"));
        assertEquals(Integer.valueOf(0), body.get("IS_OPTIN_PART"));
        
    }

    @Test
    public void testCreateShopIdList() {
        assertNotNull(context);
        Exchange e = context.getEndpoint("direct:fake").createExchange();
        assertNotNull(e);

        builder.buildUIDList(builder.convert(contact), e);
        assertNotNull(e.getIn().getHeader("synchro.smartfocus.shop_id.list"));
        assertNotNull(e.getIn().getHeader("synchro.smartfocus.user_id"));
        assertEquals(contact.getContactId(), e.getIn().getHeader("synchro.smartfocus.user_id", Long.class));
        List<Long> uids = e.getIn().getHeader("synchro.smartfocus.shop_id.list", List.class);
        assertEquals(2, uids.size());
        assertEquals(Long.valueOf(1000l), uids.get(0));
        assertEquals(Long.valueOf(1001l), uids.get(1));
        
    }

    @Test
    public void testAddMissingFields() {
        assertNotNull(context);
        Exchange e = context.getEndpoint("direct:fake").createExchange();
        assertNotNull(e);
        builder.buildBody(builder.convert(contact), e);
        Map<String, Object> oldBody = e.getIn().getHeader("synchro.smartfocus.body", Map.class);
        
        Map<String, Object> body = builder.addMissingFields(oldBody, 1000l);
        assertNotNull(body);
        assertNotEquals(body,oldBody);
        assertEquals(10, oldBody.size());
        assertEquals(14, body.size());
        assertEquals(oldBody.get("FIRSTNAME"), body.get("FIRSTNAME"));
        assertEquals(oldBody.get("LASTNAME"), body.get("LASTNAME"));
        assertEquals(oldBody.get("TITLE"), body.get("TITLE"));
        assertEquals(oldBody.get("EMAIL"), body.get("EMAIL"));
        assertEquals(oldBody.get("COUNTRY"), body.get("COUNTRY"));
        assertEquals(oldBody.get("IS_OPTIN_NL"), body.get("IS_OPTIN_NL"));
        assertEquals(oldBody.get("IS_OPTIN_PART"), body.get("IS_OPTIN_PART"));
        assertEquals(oldBody.get("USER_ID"), body.get("USER_ID"));
        assertEquals(oldBody.get("OPT_OUT_TOKEN"), body.get("OPT_OUT_TOKEN"));
        assertEquals(oldBody.get("OPT_OUT_PART_TOKEN"), body.get("OPT_OUT_PART_TOKEN"));
        
        assertEquals(Long.valueOf(1000l), body.get("SHOP_ID"));
        assertEquals(state1000.getReferentialState().getId(), body.get("REF_STATES"));
        assertEquals(state1000.getShopState().getId(), body.get("SHOP_STATUS"));
        assertEquals(state1000.getSegmentation().toString(), body.get("SEGMENTATION"));
    }

}
