package com.example.demo.Students;



//@Getter
//@Setter


public class Student {

	private int id;
	private String name;
	private int rollNo;
	public Student(int id, String name, int rollNo) {
		super();
		this.id = id;
		this.name = name;
		this.rollNo = rollNo;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	

}

