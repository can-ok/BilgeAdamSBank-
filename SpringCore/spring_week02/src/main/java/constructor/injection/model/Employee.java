package constructor.injection.model;

public class Employee {
	
	private String name;
	private String surname;
	private int age;
	private int id;
	
	private Address address;
	
	
	public Employee(String name, String surname, int age, int id, Address address) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.id = id;
		this.address = address;
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
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + ", age=" + age + ", id=" + id + ", address="
				+ address + "]";
	}
	

}
