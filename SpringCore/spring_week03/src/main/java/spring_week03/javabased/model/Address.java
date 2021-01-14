package spring_week03.javabased.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Address {
	
	@Value(value="İstanbul")
	private String city;
	
	@Value(value="Turkey")
	private String coutry;
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCoutry() {
		return coutry;
	}
	public void setCoutry(String coutry) {
		this.coutry = coutry;
	}
	
	@Override
	public String toString() {
		return "Address [city=" + city + ", coutry=" + coutry + "]";
	}
	
	

}


