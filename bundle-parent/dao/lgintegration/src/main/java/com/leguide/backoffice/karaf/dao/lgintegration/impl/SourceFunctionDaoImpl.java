package com.leguide.backoffice.karaf.dao.lgintegration.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leguide.backoffice.karaf.dao.lgintegration.SourceFunctionDao;
import com.leguide.backoffice.karaf.models.lgintegration.custom.FeedFunctionDTO;
import org.springframework.stereotype.Repository;

@Repository
public class SourceFunctionDaoImpl implements SourceFunctionDao {

	private static final Logger logger = LoggerFactory.getLogger(SourceFunctionDaoImpl.class);

    @PersistenceContext
	private EntityManager em;

	public static String REQ_FEEDFUNCTIONS_FOR_SOURCEID = "SELECT srcFunct.id_source_function, srcFunct.id_source, srcFunct.sfn_order, srcFunct.sfn_condition_active, rf_field2.fld_label as leftCondition,"
											+ "	srcFunct.sfn_condition_field_type,ope.cop_label as conditionOperator, rf_field3.fld_label as rightConditionField, srcFunct.sfn_condition_param_2,"
											+ " rfunc.fnc_label as functionName, rf_field1.fld_label as field, srcFunct.sfn_param_1, srcFunct.sfn_param_2 "
											+ " FROM lgintegration.tb_source_function srcFunct join lgintegration.rf_field rf_field1 on rf_field1.id_field = srcFunct.id_field "
											+ " join lgintegration.rf_field rf_field2 on rf_field2.id_field = srcFunct.sfn_condition_id_field_1 "
											+ " join lgintegration.rf_field rf_field3 on rf_field3.id_field = srcFunct.sfn_condition_id_field_2 "
											+ " join lgintegration.rf_condition_operator ope on ope.id_condition_operator = srcFunct.id_condition_operator"
											+ " join lgintegration.rf_function rfunc on rfunc.id_function = srcFunct.id_function "
											+ " where sfn_active = 'Y' and srcFunct.id_source = ? ";

	@SuppressWarnings("unchecked")
	@Override
	public List<FeedFunctionDTO> getFeedfunctionForSourceId(Long sourceId) {

		Query query =  em.createNativeQuery(REQ_FEEDFUNCTIONS_FOR_SOURCEID, FeedFunctionDTO.class);
    	query.setParameter(1, sourceId);
    	List<FeedFunctionDTO> result = query.getResultList();
    	logger.info("after getResultList "+result.size());
		return result;
	}


	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

}
