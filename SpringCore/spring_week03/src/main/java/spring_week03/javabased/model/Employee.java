package spring_week03.javabased.model;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {
	
	private String name;
	private String surname;
	private int age;
	private int id;
	
	@Autowired
	private Address addres;
	
	
	public Employee(String name, String surname, int age, int id) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address getAddres() {
		return addres;
	}

	public void setAddres(Address addres) {
		this.addres = addres;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + ", age=" + age + ", id=" + id + ", addres=" + addres
				+ "]";
	}

	
}
