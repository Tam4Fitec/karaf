package com.leguide.backoffice.karaf.webservices.wsbrands.api.resources.param;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.WebApplicationException;

import com.leguide.backoffice.karaf.webservices.wsbrands.common.IGlobalConstants;

public class DateParam extends AbstractParam<Date> {

    public DateParam(String param) throws WebApplicationException {
        super(param);
    }

    @Override
    protected Date parse(String param) throws ParseException, IllegalArgumentException {

        if (param == null || param.equals("") || param.equals("0000-00-00")) {
            return null;
        }

        SimpleDateFormat format = new SimpleDateFormat(IGlobalConstants.WS_DATE_FORMAT);
        format.setLenient(false);
        return format.parse(param);
    }
}
