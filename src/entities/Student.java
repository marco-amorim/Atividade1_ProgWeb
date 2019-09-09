package entities;

import java.util.List;

public class Student {

	private String name;
	private int age;
	private String gender;
	private List<String> listClasses;

	public Student(String name, int age, String gender, List<String> listClasses) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.listClasses = listClasses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getListClasses() {
		return listClasses;
	}

}
