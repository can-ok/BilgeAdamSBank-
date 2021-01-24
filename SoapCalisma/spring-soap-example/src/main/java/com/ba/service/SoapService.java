package com.ba.service;

import java.math.BigInteger;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.dataaccess.webservicesserver.NumberToWords;
import com.dataaccess.webservicesserver.NumberToWordsResponse;

public class SoapService extends WebServiceGatewaySupport{
	
	public NumberToWordsResponse getWords(String numbers) {
		//soap service
		String uri="https://www.dataaccess.com/webservicesserver/numberconversion.wso";
		
		//create request
		NumberToWords numberRequest=new NumberToWords();
		numberRequest.setUbiNum(new BigInteger(numbers));
		
		NumberToWordsResponse response=
				(NumberToWordsResponse) getWebServiceTemplate().marshalSendAndReceive(uri,numberRequest);
		
		
		return response;
	}

}
