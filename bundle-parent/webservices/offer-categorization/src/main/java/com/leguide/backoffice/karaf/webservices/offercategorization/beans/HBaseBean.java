package com.leguide.backoffice.karaf.webservices.offercategorization.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leguide.backoffice.karaf.services.hadoop.exception.HadoopServiceException;
import com.leguide.backoffice.karaf.services.hadoop.HBaseService;

public class HBaseBean {

    private static final Logger logger = LoggerFactory.getLogger(HBaseBean.class);
    private HBaseService hbaseService;
 
	
	public void updateCategorisation(String keyHbase, String idthesaurus) 
	{
		//MAJ de CATEGORYINTRAID_FIELD "d:27";	
		try {
			hbaseService.doPut("offers", keyHbase, "d:27", idthesaurus);
		} catch (HadoopServiceException e) {
			 logger.debug("[Error] updateCategorisation : " + e.getMessage().toString());
		}
	}

	public void setHbaseService(HBaseService hbaseService) {
		this.hbaseService = hbaseService;
	}
}