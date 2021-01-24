package com.ba.controller;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ba.service.SoapService;
import com.dataaccess.webservicesserver.NumberToWordsResponse;

@RestController
public class Controller {
	
	
	@GetMapping(path="/word/{number}")
	public String getString(@PathVariable String number) {
		
		SoapService service=new SoapService();
		
		Jaxb2Marshaller marshaller=new Jaxb2Marshaller();
		
		marshaller.setContextPath("com.dataaccess.webservicesserver");
		
		service.setMarshaller(marshaller);
		service.setUnmarshaller(marshaller);
		
		//retrive word
		
		NumberToWordsResponse response=service.getWords(number);
		
		
		return response.getNumberToWordsResult();
	}

}
