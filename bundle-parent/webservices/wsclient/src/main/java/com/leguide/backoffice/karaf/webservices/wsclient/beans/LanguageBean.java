package com.leguide.backoffice.karaf.webservices.wsclient.beans;

import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

public class LanguageBean {

    @Value("${mail.alertconsumption.subject}")
    private String subjectMailAlertConsumption;

    private Map<String, String> mapSubjectMailAlertConsumptionTranslations;

    public void init() {
        initSubjectMailAlertConsumptionTranslations();
    }

    protected String getSubjectMailAlertConsumptionForLanguage(String language) {
        return mapSubjectMailAlertConsumptionTranslations.get(language);
    }

    private void initSubjectMailAlertConsumptionTranslations() {
        mapSubjectMailAlertConsumptionTranslations = new HashMap<String, String>();
        for (String translation : subjectMailAlertConsumption.split(";")) {
            String[] translationSplit = translation.split(":");
            mapSubjectMailAlertConsumptionTranslations.put(translationSplit[0], translationSplit[1]);
        }
    }
}
