package com.itr.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import com.itr.wsdl.GetCountryRequest;
import com.itr.wsdl.GetCountryResponse;


public class CountryClient extends WebServiceGatewaySupport{
	
	private static final Logger log = LoggerFactory.getLogger(CountryClient.class);
	
	public GetCountryResponse getCountry(String country) {

		GetCountryRequest request = new GetCountryRequest();
		request.setName(country);

		log.info("Requesting location for " + country);

		GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/countries", request);

		return response;
	}

}
