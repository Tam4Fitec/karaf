package com.leguide.backoffice.karaf.bundle.business.catalog.offercount.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.Body;
import org.apache.camel.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.leguide.backoffice.karaf.bundle.business.catalog.offercount.pojo.UpdatePojo;
import com.leguide.backoffice.karaf.bundle.business.catalog.offercount.utils.Headers;

public class CatalogDao {

    private static final Logger logger = LoggerFactory.getLogger(CatalogDao.class);
    private NamedParameterJdbcTemplate tpl;
    private RowMapper<UpdatePojo> shopStateRM = new RowMapper<UpdatePojo>() {

        @Override
        public UpdatePojo mapRow(ResultSet rs, int rowNum) throws SQLException {
            UpdatePojo res = new UpdatePojo();
            res.setIdshopsite(rs.getLong("id_shopsite"));
            res.setIdCatalog(rs.getLong("id_catalog"));
            return res;
        }
    };

    /**
     * Returns the catalogId linked to the shopsite_id
     * @param shopsiteId
     * @return id_catalog
     * @throws EmptyResultDataAccessException
     */
    public Long getCatalogId(@Header(Headers.SHOPSITE_ID) Long shopsiteId) throws EmptyResultDataAccessException {
        logger.debug("getCatalogId with " + shopsiteId);
        String query = "select id_catalog from tb_catalog where id_shopsite = :id_shopsite";
        Map<String, Object> paramMap = new HashMap<String, Object>(1);
        paramMap.put("id_shopsite", shopsiteId);
        return tpl.queryForObject(query, paramMap, Long.class);
    }

    /**
     * Get all couples id_shopsite, id_catalog where shopsite state is > 0 ( from vw_shopsite.sps_shop_state)
     * @return
     */
    public List<UpdatePojo> shopStateGt0() {
        String query = " select v.id_shopsite, t.id_catalog from vw_shopsite v, tb_catalog t" +
        		" where v.sps_shop_state > 0 and t.id_shopsite = v.id_shopsite";
        return tpl.query(query, shopStateRM);
    }

    /**
     * batchUpdate tb_catalog with the number of offer (updates ctg_online_count )
     * @param toUpdate a list of pojo containing the id_catalog and numbe of offers
     */
    public void batchUpdateOfferCount(@Body List<UpdatePojo> toUpdate) {
        String query = "update tb_catalog SET ctg_online_count = :total where id_catalog = :id_catalog";
        List<Map<String, Object>> params = new ArrayList<Map<String, Object>>(toUpdate.size());
        for (UpdatePojo pojo : toUpdate) {
            Map<String, Object> param = new HashMap<String, Object>(2);
            param.put("total", pojo.getTotalOffers());
            param.put("id_catalog", pojo.getIdCatalog());
            params.add(param);
        }
        tpl.batchUpdate(query, params.toArray(new HashMap[toUpdate.size()]));
    }

    public NamedParameterJdbcTemplate getTpl() {
        return tpl;
    }
    public void setTpl(NamedParameterJdbcTemplate tpl) {
        this.tpl = tpl;
    }
}
