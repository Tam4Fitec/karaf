package com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.jaxb.adapters;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date> {

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date unmarshal(String date) throws ParseException {
        if (date == null || date.equals("") || date.equals("0000-00-00")) {
            return null;
        }

        this.dateFormat.setLenient(false);
        return this.dateFormat.parse(date);
    }

    @Override
    public String marshal(Date date) throws Exception {
        return this.dateFormat.format(date);
    }
}
