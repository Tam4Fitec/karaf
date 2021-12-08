package com.leguide.backoffice.karaf.dao.lgbase.cpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class CpcDAO implements ICpcDAO {

    private static Logger logger = LoggerFactory.getLogger(CpcDAO.class);

    private JdbcTemplate tpl;

    @Override
    public Float[] getCPC(Long lgCat, Long mappingCat, String country) {
        String query = "select cpc from billing_pricing_method_category_cpc_list where country = ? and category_id = ? order by create_date DESC limit 1";
        logger.debug("params = " + lgCat  + " " + mappingCat + " " + country);
        Float cpcLgcat = 0f;
        Float cpcMappingCat = 0f;
        try {
            if (lgCat != null && lgCat != 0l) {
            cpcLgcat = tpl.queryForObject(query, new Object[]{country, lgCat}, Float.class);
            }
            cpcMappingCat = tpl.queryForObject(query, new Object[]{country, mappingCat}, Float.class);
        } catch(EmptyResultDataAccessException e) {
            
        }
        logger.debug("res = " + cpcLgcat  + " " + cpcMappingCat);
        return new Float[] {cpcLgcat, cpcMappingCat};
    }

    public JdbcTemplate getTpl() {
        return tpl;
    }

    public void setTpl(JdbcTemplate tpl) {
        this.tpl = tpl;
    }
}
