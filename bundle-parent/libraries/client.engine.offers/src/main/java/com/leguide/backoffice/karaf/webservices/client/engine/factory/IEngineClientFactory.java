package com.leguide.backoffice.karaf.webservices.client.engine.factory;

import java.util.Properties;

import org.springframework.util.StringUtils;

import com.leguide.backoffice.karaf.webservices.client.engine.IEngineClient;
import com.leguide.backoffice.karaf.webservices.client.engine.exception.EngineJaxbException;
import com.leguide.backoffice.karaf.webservices.client.engine.exception.EngineRequestParameterException;
import com.leguide.backoffice.karaf.webservices.client.engine.impl.EngineClient;

public class IEngineClientFactory {

    /**
     * Create an instance of EngineClient. The Properties parameter contains engine host and other required property :
     * 
     * <ul> Parameters to provide :
     * <li> IEngineClient.engineRequestProtocole : engine protocole
     * <li> IEngineClient.engineRequestAddress : engine host
     * <li> IEngineClient.engineRequestPort : engine host port
     * <li> IEngineClient.engineRequestDeliveryZone : engine parameter KZone
     * <li> IEngineClient.engineRequestCatCount : engine parameter KCatCount
     * <li> IEngineClient.engineRequestMarksNumber : engine parameter KMarkCount
     * <li> IEngineClient.engineRequestSite : engine parameter KSite
     * <li> IEngineClient.engineRequestShortLinksNumber : engine parameter KShortlinks
     * <li> IEngineClient.engineRequestLanguage : engine parameter KPays
     * <li> IEngineClient.engineRequestSortTypeListOffre : engine parameter KSort for List_offres
     * <li> IEngineClient.engineRequestSortTypeProductNet : engine parameter KSort for products_net
     * </ul>
     * 
     * Optional parameter
     * <ul>
     *  <li> IEngineClient.engineRequestShortReviewsSources : engine parameter kReviewsSources for products_net, -1 by
     *  default if not provided
     * </ul>
     * 
     * @param parameters cannot be null
     * @return an instance of {@link EngineClient}
     * @throws EngineRequestParameterException If one property is missing or a {@link NumberFormatException} occured
     * @throws EngineJaxbException 
     * @throws  
     */
    public static IEngineClient getInstance(Properties parameters) throws EngineRequestParameterException, EngineJaxbException {
        checkEngineParameters(parameters);
        EngineClient instance = new EngineClient(parameters.getProperty(IEngineClient.engineRequestProtocole),
                parameters.getProperty(IEngineClient.engineRequestAddress),
                Integer.valueOf(parameters.getProperty(IEngineClient.engineRequestPort)));
        instance.setCatCount(Integer.valueOf(parameters.getProperty(IEngineClient.engineRequestCatCount)));
        instance.setDeliveryZone(Integer.valueOf(parameters.getProperty(IEngineClient.engineRequestDeliveryZone)));
        instance.setMarksNumber(Integer.valueOf(parameters.getProperty(IEngineClient.engineRequestMarksNumber)));
        instance.setSite(Integer.valueOf(parameters.getProperty(IEngineClient.engineRequestSite)));
        instance.setShortLinksNumber(Short.valueOf(parameters.getProperty(IEngineClient.engineRequestShortLinksNumber)));
        instance.setLanguage(parameters.getProperty(IEngineClient.engineRequestLanguage));
        instance.setSortTypeListOffre(Integer.valueOf(parameters.getProperty(IEngineClient.engineRequestSortTypeListOffre)));
        instance.setSortTypeProductNet(Integer.valueOf(parameters.getProperty(IEngineClient.engineRequestSortTypeProductNet)));
        instance.setShortReviewsSources(Short.valueOf(parameters
                .getProperty(IEngineClient.engineRequestShortReviewsSources, "-1")));
        return instance;
    }

    private static void checkEngineParameters(Properties parameters) throws EngineRequestParameterException {
        if (parameters == null) {
            throw new EngineRequestParameterException("properties map is null");
        }
        if (!StringUtils.hasLength(parameters.getProperty(IEngineClient.engineRequestLanguage))) {
            throw new EngineRequestParameterException(IEngineClient.engineRequestLanguage + " property is null");
        }
        if (!StringUtils.hasLength(parameters.getProperty(IEngineClient.engineRequestAddress))) {
            throw new EngineRequestParameterException(IEngineClient.engineRequestAddress + " property is null");
        }
        if (!StringUtils.hasLength(parameters.getProperty(IEngineClient.engineRequestPort))) {
            throw new EngineRequestParameterException(IEngineClient.engineRequestPort + " property is null");
        } else {
            try {
                Integer.valueOf(parameters.getProperty(IEngineClient.engineRequestPort));
            } catch (NumberFormatException e) {
                throw new EngineRequestParameterException(IEngineClient.engineRequestPort + " property is not an integer");
            }
        }
        if (!StringUtils.hasLength(parameters.getProperty(IEngineClient.engineRequestProtocole))) {
            throw new EngineRequestParameterException(IEngineClient.engineRequestProtocole + " property is null");
        }
        if (!StringUtils.hasLength(parameters.getProperty(IEngineClient.engineRequestSortTypeProductNet))) {
            throw new EngineRequestParameterException(IEngineClient.engineRequestSortTypeProductNet + " property is null");
        } else {
            try {
                Integer.valueOf(parameters.getProperty(IEngineClient.engineRequestSortTypeProductNet));
            } catch (NumberFormatException e) {
                throw new EngineRequestParameterException(IEngineClient.engineRequestSortTypeProductNet + " property is not an integer");
            }
        }
        if (!StringUtils.hasLength(parameters.getProperty(IEngineClient.engineRequestSortTypeListOffre))) {
            throw new EngineRequestParameterException(IEngineClient.engineRequestSortTypeListOffre + " property is null");
        } else {
            try {
                Integer.valueOf(parameters.getProperty(IEngineClient.engineRequestSortTypeListOffre));
            } catch (NumberFormatException e) {
                throw new EngineRequestParameterException(IEngineClient.engineRequestSortTypeListOffre + " property is not an integer");
            }
        }
        if (!StringUtils.hasLength(parameters.getProperty(IEngineClient.engineRequestSite))) {
            throw new EngineRequestParameterException(IEngineClient.engineRequestSite + " property is null");
        } else {
            try {
                Integer.valueOf(parameters.getProperty(IEngineClient.engineRequestSite));
            } catch (NumberFormatException e) {
                throw new EngineRequestParameterException(IEngineClient.engineRequestSite + " property is not an integer");
            }
        }
        if (!StringUtils.hasLength(parameters.getProperty(IEngineClient.engineRequestDeliveryZone))) {
            throw new EngineRequestParameterException(IEngineClient.engineRequestDeliveryZone + " property is null");
        } else {
            try {
                Integer.valueOf(parameters.getProperty(IEngineClient.engineRequestDeliveryZone));
            } catch (NumberFormatException e) {
                throw new EngineRequestParameterException(IEngineClient.engineRequestDeliveryZone + " property is not an integer");
            }
        }
        if (!StringUtils.hasLength(parameters.getProperty(IEngineClient.engineRequestMarksNumber))) {
            throw new EngineRequestParameterException(IEngineClient.engineRequestMarksNumber + " property is null");
        } else {
            try {
                Integer.valueOf(parameters.getProperty(IEngineClient.engineRequestMarksNumber));
            } catch (NumberFormatException e) {
                throw new EngineRequestParameterException(IEngineClient.engineRequestMarksNumber + " property is not an integer");
            }
        }
        if (!StringUtils.hasLength(parameters.getProperty(IEngineClient.engineRequestShortLinksNumber))) {
            throw new EngineRequestParameterException(IEngineClient.engineRequestShortLinksNumber + " property is null");
        } else {
            try {
                Short.valueOf(parameters.getProperty(IEngineClient.engineRequestShortLinksNumber));
            } catch (NumberFormatException e) {
                throw new EngineRequestParameterException(IEngineClient.engineRequestShortLinksNumber + " property is not a short");
            }
        }
        if (!StringUtils.hasLength(parameters.getProperty(IEngineClient.engineRequestCatCount))) {
            throw new EngineRequestParameterException(IEngineClient.engineRequestCatCount + " property is null");
        } else {
            try {
                Integer.valueOf(parameters.getProperty(IEngineClient.engineRequestCatCount));
            } catch (NumberFormatException e) {
                throw new EngineRequestParameterException(IEngineClient.engineRequestCatCount + " property is not an integer");
            }
        }
        //shortReviewsSource is not mandatory
        if (StringUtils.hasLength(parameters.getProperty(IEngineClient.engineRequestShortReviewsSources))) {
            try {
                Short.valueOf(parameters.getProperty(IEngineClient.engineRequestShortReviewsSources));
            } catch (NumberFormatException e) {
                throw new EngineRequestParameterException(IEngineClient.engineRequestShortReviewsSources + " property is not a short");
            }
        }
    }
}
