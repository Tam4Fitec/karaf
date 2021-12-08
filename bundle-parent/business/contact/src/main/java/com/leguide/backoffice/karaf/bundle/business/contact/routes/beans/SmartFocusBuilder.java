package com.leguide.backoffice.karaf.bundle.business.contact.routes.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.camel.Body;
import org.apache.camel.Exchange;

import com.leguide.backoffice.karaf.bundle.business.contact.routes.pojo.SmartFocusUpdatePOJO;
import com.leguide.backoffice.karaf.bundle.dao.facade.ShopSiteDao;
import com.leguide.backoffice.karaf.business.models.pojo.contact.Contact;
import com.leguide.backoffice.karaf.business.models.pojo.shopsite.state.ShopSiteState;
import com.leguide.backoffice.karaf.dao.lgbase.LgbaseAccountStoreDao;

public final class SmartFocusBuilder {

    private LgbaseAccountStoreDao lgAccountStoreDAO;
    private ShopSiteDao shopSiteDao;

    public SmartFocusUpdatePOJO convert(@Body Contact newContact) {
        return new SmartFocusUpdatePOJO(newContact);
    }

    public void buildBody(@Body SmartFocusUpdatePOJO pojo, Exchange ex) {
        Map<String, Object> result = new HashMap<String, Object>(3);
        result.put("FIRSTNAME", pojo.getFirstName());
        result.put("LASTNAME", pojo.getLastName());
        result.put("EMAIL", pojo.getEmail());
        result.put("TITLE", pojo.getCivility());
        result.put("COUNTRY", pojo.getCountry());
        result.put("IS_OPTIN_NL", pojo.getOptInLG());
        result.put("IS_OPTIN_PART", pojo.getOptInPartner());
        result.put("USER_ID", pojo.getContactId());
        result.put("OPT_OUT_TOKEN", pojo.getOptOutToken());
        result.put("OPT_OUT_PART_TOKEN", pojo.getOptOutTokenPartner());
        ex.getIn().setHeader("synchro.smartfocus.body", result);
    }

    public void buildBodyOptOut(@Body SmartFocusUpdatePOJO pojo, Exchange ex) {
        Map<String, Object> result = new HashMap<String, Object>(3);
        result.put("IS_OPTIN_NL", Integer.valueOf(0));
        result.put("IS_OPTIN_PART", Integer.valueOf(0));
        ex.getIn().setHeader("synchro.smartfocus.body", result);
    }
    public void buildUIDList(@Body SmartFocusUpdatePOJO pojo, Exchange ex) {
        List<Long> shopsiteIds = lgAccountStoreDAO.getListIdShopsiteByAccountId(pojo.getAccountId());
        ex.getIn().setHeader("synchro.smartfocus.user_id", pojo.getContactId());
        if (shopsiteIds != null) {
            ex.getIn().setHeader("synchro.smartfocus.shop_id.list", shopsiteIds);
                    //shopsiteIds.stream().map(l -> ("USER_ID:" +  pojo.getContactId() + "|SHOP_ID:" + l)).collect(Collectors.toList()));
        }
    }

    public Map<String, Object> addMissingFields(Map<String, Object> body, Long shopId) {

        Map<String, Object> result = new HashMap<String, Object>(body);
        result.put("SHOP_ID", shopId);
        ShopSiteState state = shopSiteDao.findStateOfShopSite(shopId);
        if (state != null) {
            result.put("REF_STATES", state.getReferentialState().getId());
            result.put("SHOP_STATUS", state.getShopState().getId());
            result.put("SEGMENTATION", state.getSegmentation().toString());
        }
        return result;
    }

    public LgbaseAccountStoreDao getLgAccountStoreDAO() {
        return lgAccountStoreDAO;
    }

    public void setLgAccountStoreDAO(LgbaseAccountStoreDao lgAccountStoreDAO) {
        this.lgAccountStoreDAO = lgAccountStoreDAO;
    }

    public ShopSiteDao getShopSiteDao() {
        return shopSiteDao;
    }

    public void setShopSiteDao(ShopSiteDao shopSiteDao) {
        this.shopSiteDao = shopSiteDao;
    }

}
