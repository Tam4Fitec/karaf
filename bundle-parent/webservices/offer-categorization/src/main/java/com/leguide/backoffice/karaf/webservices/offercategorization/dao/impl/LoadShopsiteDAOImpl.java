package com.leguide.backoffice.karaf.webservices.offercategorization.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.leguide.backoffice.karaf.webservices.offercategorization.dao.LoadShopsiteDAO;


public class LoadShopsiteDAOImpl implements LoadShopsiteDAO {

		
	private static final Logger logger = LoggerFactory.getLogger(LoadShopsiteDAOImpl.class);
	
	/** The jdbc template. */
	private JdbcTemplate lgbaseDS;
	
	
    private RowMapper<Long> rmL = new RowMapper<Long>() {

        @Override
        public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
            return rs.getLong("store_uid");
        }
    };
    
	public Long getIdShopsite(String country, String storeId) {
		Long idShopiste = null;

		String request = "SELECT distinct store_uid " +
				" FROM lg_store  s "
				+ " WHERE  s.store_id = " + new Integer(storeId) + " AND s.country ='" + country + "'";

//			logger.info("Requete Sql : " + request);
	
		try  {
	    	List<Long> res = lgbaseDS.query(request, rmL);
			
	        if (res != null && !res.isEmpty()) {
	        	idShopiste = res.get(0);
	        }
		} catch (Exception e) {
			logger.error("getThesaurusInternal() Error: {}", e);
			return null;
		}
		return idShopiste;
	}

	/**
	 * Sets the lgbase ds.
	 *
	 * @param ds the new lgbase ds
	 */
	public void setLgbaseDS(DataSource ds) {
		lgbaseDS = new JdbcTemplate(ds);
	}

}
