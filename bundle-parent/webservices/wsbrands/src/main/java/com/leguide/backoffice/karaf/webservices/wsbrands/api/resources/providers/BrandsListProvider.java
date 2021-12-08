package com.leguide.backoffice.karaf.webservices.wsbrands.api.resources.providers;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.in.brands.BrandsListInWrapper;

@Provider
@Component
@Consumes(MediaType.APPLICATION_XML)
public final class BrandsListProvider extends AbstractXMLProvider<BrandsListInWrapper> {

    private static final String XSD_FILENAME = "brand_list.xsd";

    @Override
    public String getSchemaName() {
        return XSD_FILENAME;
    }
}
