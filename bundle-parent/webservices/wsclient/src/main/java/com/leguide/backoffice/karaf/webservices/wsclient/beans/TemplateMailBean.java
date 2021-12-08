package com.leguide.backoffice.karaf.webservices.wsclient.beans;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

public class TemplateMailBean {

    public String buildTemplateMailAlertConsumption(String language, String url, Double maximumAmount, String month, String email) {
        STGroup g = new STGroupFile("tpl/templates/alertconsumption.stg", '$', '$');
        ST st = g.getInstanceOf("alertconsumption_" + language.toLowerCase());
        st.add("url", url);
        st.add("maximumAmount", maximumAmount);
        st.add("month", month);
        st.add("email", email);
        return st.render();
    }
}
