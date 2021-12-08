package com.leguide.backoffice.karaf.bundle.dao.facade;

import com.leguide.backoffice.karaf.business.models.pojo.referentiel.Label;

import java.util.List;

public interface LabelDao {

    List<Label> findActiveLabelsForNamespaceAndLanguage(String namespace, String language);
}
