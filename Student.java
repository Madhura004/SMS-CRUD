package com.entity;            
                             //core java
public class Student {
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + ", rollnum=" + rollnum + "]";
	}

	private int id;
	private String name;
	private double marks;
	private int rollnum;
	public Student(int id, String name, double marks, int rollnum) {
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.rollnum = rollnum;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public double getMarks() {
		return marks;
	}
	
	public void setMarks(double marks) {
		this.marks=marks;
	}
	
	public int getrollnum() {
		return rollnum;
	}
	
	public void getrollnum(int rollnum) {
		this.rollnum=rollnum;
	}
	

}
