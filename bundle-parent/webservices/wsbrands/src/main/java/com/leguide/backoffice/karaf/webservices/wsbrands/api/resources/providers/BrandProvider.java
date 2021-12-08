package com.leguide.backoffice.karaf.webservices.wsbrands.api.resources.providers;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.leguide.backoffice.karaf.webservices.wsbrands.api.domain.wrapper.in.brands.BrandInWrapper;

@Provider
@Component
@Consumes(MediaType.APPLICATION_XML)
public final class BrandProvider extends AbstractXMLProvider<BrandInWrapper> {

    private static final String XSD_FILENAME = "brand.xsd";

    @Override
    public String getSchemaName() {
        return XSD_FILENAME;
    }
}
