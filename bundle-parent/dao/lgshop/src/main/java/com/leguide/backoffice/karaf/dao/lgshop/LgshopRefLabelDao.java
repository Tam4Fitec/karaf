package com.leguide.backoffice.karaf.dao.lgshop;

import com.leguide.backoffice.karaf.models.lgshop.referentiel.LgshopRefLabel;

import java.util.List;

public interface LgshopRefLabelDao {

	List<LgshopRefLabel> findActiveLabelsForNamespaceAndLocale(String namespace, String locale);

}
