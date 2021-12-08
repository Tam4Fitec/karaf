package com.leguide.backoffice.karaf.bundle.dao.lgbase.beans;

import org.apache.camel.Body;
import org.apache.camel.Header;

import com.leguide.backoffice.karaf.models.lgbase.client.LgBaseClient;

public class MergingClient {
	public LgBaseClient merge (@Body LgBaseClient clientFinded, @Header("client-from-event") LgBaseClient eventClient) {
		clientFinded.setPaymentMeanType(eventClient.getPaymentMeanType());
		clientFinded.getInfos().setAddress1(eventClient.getInfos().getAddress1());
		clientFinded.getInfos().setAddress2(eventClient.getInfos().getAddress2());
		clientFinded.getInfos().setZipCode(eventClient.getInfos().getZipCode());
		clientFinded.getInfos().setCity(eventClient.getInfos().getCity());
		clientFinded.getInfos().setCountry(eventClient.getInfos().getCountry());
		clientFinded.getInfos().setHeading(eventClient.getInfos().getHeading());
		clientFinded.getInfos().setIntraCommunityId(eventClient.getInfos().getIntraCommunityId());
		return clientFinded;
	}
}
