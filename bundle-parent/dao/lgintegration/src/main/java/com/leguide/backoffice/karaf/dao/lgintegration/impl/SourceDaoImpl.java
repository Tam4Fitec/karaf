package com.leguide.backoffice.karaf.dao.lgintegration.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

import com.leguide.backoffice.karaf.models.lgintegration.catalog.FieldLabelMappingValue;
import com.leguide.backoffice.karaf.models.lgintegration.catalog.SourceDTO;
import com.leguide.backoffice.karaf.models.lgintegration.catalog.SourceFormatDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leguide.backoffice.karaf.dao.lgintegration.SourceDao;
import com.leguide.backoffice.karaf.models.lgintegration.custom.FeedInfosDTO;
import org.springframework.stereotype.Repository;

@Repository
public class SourceDaoImpl implements SourceDao {

    private static final Logger logger = LoggerFactory.getLogger(SourceDaoImpl.class);

    @PersistenceContext
	private EntityManager em;

	public static String REQ_FEEDINFOS_BY_REFSTATE_AND_LANGUAGE = "SELECT distinct ts.id_shopsite,ls.country,ls.store_id, tbs.id_source, tbs.src_field_separator, tbs.src_string_delimiter, tbs.src_start_line, tbs.src_encoding,tbs.src_is_xml, tbs.src_sax_parser, tbs.src_url "
			+ " FROM lgshop.tb_shopsite ts  inner join lgshop.tb_shopsite_state tss ON ts.id_shopsite = tss.id_shopsite INNER JOIN lgbase.lg_store ls on ts.id_shopsite = ls.store_uid  inner join lgintegration.tb_catalog tc on ts.id_shopsite = tc.id_shopsite inner join lgintegration.tb_source tbs on tc.id_catalog = tbs.id_catalog "
			+ " where tc.ctg_active = 'Y' and tbs.src_active = 'Y' and  ts.shs_main_language = ? and  tss.sps_id_ref_state =  ? ";

	public static String ZEUS_CONSTRAINT  = " and tss.zeus_notation > 0 ";

	public static String REQ_FEED_MAPPING_XML_BY_SOURCEID  = "SELECT rff.fld_label, tsp.sp_navigation FROM lgintegration.tb_source_parser tsp " +
            "inner join lgintegration.tb_field_mapping tfm  on tsp.id_source = tfm.id_source and tsp.sp_index = tfm.fmp_map_value " +
            "inner join lgintegration.rf_field rff on tfm.id_field = rff.id_field where tsp.id_source = ?";

	public static String REQ_FEEDINFOS_BY_SHOPSITEID = "SELECT distinct ts.id_shopsite,ls.country,ls.store_id, tbs.id_source, tbs.src_field_separator, tbs.src_string_delimiter, tbs.src_start_line, tbs.src_encoding,tbs.src_is_xml, tbs.src_sax_parser, tbs.src_url "
			+ " FROM lgshop.tb_shopsite ts inner join lgbase.lg_store ls on ts.id_shopsite = ls.store_uid  inner join lgintegration.tb_catalog tc on ts.id_shopsite = tc.id_shopsite inner join lgintegration.tb_source tbs on tc.id_catalog = tbs.id_catalog "
			+ " where tc.ctg_active = 'Y' and tbs.src_active = 'Y' and  ts.id_shopsite = ?";

    public static String REQ_SOURCES_BY_SHOPSITEID  = "SELECT tbs.id_source, tbs.id_catalog, tbs.src_url, tbs.src_field_separator, tbs.src_string_delimiter," +
            "tbs.src_start_line, tbs.src_md5_cli, tbs.src_command, tbs.src_command_active, tbs.src_last_download, tbs.src_active, tbs.src_encoding," +
            "tbs.src_check_price, tbs.src_response_timeout, tbs.src_download_timeout, tbs.id_source_type, tbs.src_command_comment, tbs.src_price_affected_by_deee," +
            "tbs.src_oldPrice_affected_by_deee, tbs.src_last_change, tbs.src_md5_original, tbs.id_source_format, tbs.src_xsl_content, tbs.src_is_xml," +
            "tbs.src_origin_id, tbs.src_cookie, tbs.src_parameters, tbs.src_downloaded_by_command, tbs.src_comment, tbs.src_sax_parser," +
            "tbs.src_download_mode FROM lgintegration.tb_source tbs inner join tb_catalog tbc on tbc.id_catalog = tbs.id_catalog where tbc.id_shopsite = ? " +
            "order by tbs.src_active desc";

	public static String REQ_FEED_FORMAT  = "SELECT tsf.id_source_format ,tsf.id_format, tsf.sfo_version, tsf.sfo_comment  "
					+ "FROM lgintegration.tb_source_format tsf "
					+ "join  lgintegration.rf_format  rff on rff.id_format = tsf.id_format "
					+ "where frm_country = upper(?) and frm_name = ? ";


	@SuppressWarnings("unchecked")
	@Override
	public List<FeedInfosDTO> getFeedInfos(Long languageId, Long idRefState, boolean onlyZeus) {
		Query query = null;
		StringBuilder req = new StringBuilder(REQ_FEEDINFOS_BY_REFSTATE_AND_LANGUAGE);
		if(onlyZeus) {
			req.append(ZEUS_CONSTRAINT);
			logger.info("getFeedInfos zeus");
		}
		logger.info("Requete : "+req.toString());
		query = em.createNativeQuery(new String(req), FeedInfosDTO.class);
    	query.setParameter(1, languageId);
    	query.setParameter(2, idRefState);
    	List<FeedInfosDTO> result = query.getResultList();
    	logger.info("after getResultList "+result.size());
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, String> getTextMappingForSourceId(Long sourceId) {

		Map<String, String> results = new HashMap<String, String>();

		logger.debug("getTextMappingForSourceId before query " + sourceId);
		TypedQuery<FieldLabelMappingValue> query = em.createNamedQuery(SourceDTO.REQ_FEED_MAPPING_TXT_BY_SOURCEID, FieldLabelMappingValue.class);
		query.setParameter(1, sourceId);
		for (FieldLabelMappingValue mapping : query.getResultList()) {
			results.put(mapping.getLabel(), mapping.getValue());
		}
		return results;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, String> getXMLMappingForSourceId(Long sourceId) {

		Map<String, String> results = new HashMap<String, String>();

		logger.debug("getXMLMappingForSourceId before query "+sourceId);
		Query query = em.createNativeQuery(REQ_FEED_MAPPING_XML_BY_SOURCEID);
		query.setParameter(1, sourceId);
		List<Object[]> resultList = query.getResultList();
		logger.debug("getXMLMappingForSourceId resultList "+resultList.size());
		for (Object[] mapping : resultList) {
			results.put((String)mapping[0], (String)mapping[1]);
		}
		return results;
	}

	@Override
	public String getXSLForSourceId(Long sourceId) {

		TypedQuery<String> query = em.createNamedQuery(SourceDTO.REQ_FEED_XSL_BY_SOURCEID, String.class);
		query.setParameter(1, sourceId);
		try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FeedInfosDTO> getFeedInfosForShopsiteId(Long shopsiteId) {
		Query query =  em.createNativeQuery(REQ_FEEDINFOS_BY_SHOPSITEID, FeedInfosDTO.class);
    	query.setParameter(1, shopsiteId);
    	List<FeedInfosDTO> result = query.getResultList();
		logger.info("after getResultList "+result.size());
		return result;
	}

    @SuppressWarnings("unchecked")
    @Override
    public List<SourceDTO> getSourcesForShopsiteId(Long shopsiteId) {
        Query query =  em.createNativeQuery(REQ_SOURCES_BY_SHOPSITEID, SourceDTO.class);
        query.setParameter(1, shopsiteId);
        return query.getResultList();
    }

	@Override
	public void createSource(SourceDTO sourceDTO) {
		em.persist(sourceDTO);
	}

	@Override
	public Boolean createFieldsAssoc(Long sourceId, Long typeFormatId) {
		try {
			em.createNativeQuery("INSERT INTO lgintegration.tb_field_mapping (fmp_map_value, id_source, id_field, id_mapping_function) "
							+ " SELECT a.fmp_map_value, " + sourceId + ", a.id_field, a.id_mapping_function"
							+ " FROM lgintegration.tb_field_mapping_typeformat a WHERE a.id_format = " + typeFormatId).executeUpdate();
			return true;
		} catch (RuntimeException e) {
			logger.error("createKelkooAssoc({}) Error: ", sourceId, e);
			return false;
		}
	}

	@Override
	public SourceFormatDTO getSourceFormat(String country, String name) {

		//logger.info("getSourceFormat "+country+ " : "+name);

		Query query = em.createNativeQuery(REQ_FEED_FORMAT, SourceFormatDTO.class);
		query.setParameter(1, country);
		query.setParameter(2, name);
		try {
			return (SourceFormatDTO) query.getSingleResult();
		} catch (NoResultException e) {
			logger.error("getSourceFormat({}) Error: ", name, e);
			return null;
		}
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
