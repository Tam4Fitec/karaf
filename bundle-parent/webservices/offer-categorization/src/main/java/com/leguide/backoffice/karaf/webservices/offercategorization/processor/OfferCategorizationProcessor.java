package com.leguide.backoffice.karaf.webservices.offercategorization.processor;

import org.apache.camel.Header;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leguide.backoffice.karaf.webservices.offercategorization.beans.EngineBean;
import com.leguide.backoffice.karaf.webservices.offercategorization.beans.HBaseBean;
import com.leguide.backoffice.karaf.webservices.offercategorization.dao.impl.LoadShopsiteDAOImpl;
import com.leguide.backoffice.karaf.webservices.offercategorization.models.ws.OfferInformations;


public class OfferCategorizationProcessor {

	
    private static final Logger logger = LoggerFactory.getLogger(OfferCategorizationProcessor.class);	
    private EngineBean engineBean = new EngineBean();
	protected LoadShopsiteDAOImpl loadShopsiteDao;
    private HBaseBean hbaseBean = new HBaseBean();

	
	public OfferInformations getCategorizationOffers(@Header("country") String pays,
			@Header("listProduct") String listProduct) {

		OfferInformations offersInfoValueBeans = engineBean.getOfferInfos(pays, listProduct);

		return offersInfoValueBeans;
	}

	public void saveCategoryOffer(@Header("idthesaurus") String idthesaurus, @Header("country") String country,
			@Header("idoffer") String idoffer) {
		String idShopsite = null;
		String idMarchand = "";
		String keyHbase = "";

		//logger.info("idthesaurus : " + idthesaurus + " -- country : " + country + " == idproduct : " + idoffer);
		idMarchand = getShopsiteId(idoffer);
		idShopsite = String.valueOf(this.loadShopsiteDao.getIdShopsite(country, idMarchand));

		keyHbase = makeKeyHbase(country, idShopsite, idoffer);
		logger.info("keyHbase : **" + keyHbase + " ***");
		this.hbaseBean.updateCategorisation(keyHbase, idthesaurus);
	}

	
	private String getShopsiteId(String idOffer){
		String idMerchant;

		idMerchant = idOffer.substring(0,8);
		return idMerchant;		
	}

	private String makeKeyHbase(String country, String idShopsite, String idOffer){
		
	    //RowKey = {country}|{ShopsiteIdOn12Char}|{offerId}
		String keyHbase;
	    String formattedIdShopsite = StringUtils.leftPad(String.valueOf(idShopsite), 12, "0");
	    keyHbase = country.toLowerCase() + "|" + formattedIdShopsite + "|" + idOffer;		

		return keyHbase;
	}	
	

	public EngineBean getEngineBean() {
		return engineBean;
	}
	
	public void setEngineBean(EngineBean engineBean) {
		this.engineBean = engineBean;
	}

	public LoadShopsiteDAOImpl getLoadShopsiteDao() {
		return loadShopsiteDao;
	}

	public void setLoadShopsiteDao(LoadShopsiteDAOImpl loadShopsiteDao) {
		this.loadShopsiteDao = loadShopsiteDao;
	}

	public HBaseBean getHbaseBean() {
		return hbaseBean;
	}

	public void setHbaseBean(HBaseBean hbaseBean) {
		this.hbaseBean = hbaseBean;
	}
}