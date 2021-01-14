package service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class PersonBean
 */
@Stateless
@LocalBean
public class PersonBean {

    List<String> person = new ArrayList<String>(); 

    public PersonBean() {
    	person.add("Can");
    	person.add("Okan");
    }
    
    public List<String> getPerson(){
    	
    	return person;
    }
    
    public void addPerson(String name) {
    	person.add(name);
    }

}
