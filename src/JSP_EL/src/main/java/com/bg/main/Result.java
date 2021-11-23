package com.bg.main;

public class Result {

	private double mid;
	private double last;
	private String grade;
	private String avg2;
	private String name;
	
	public Result(double mid, double last, String grade, String avg2, String name) {
		super();
		this.mid = mid;
		this.last = last;
		this.grade = grade;
		this.avg2 = avg2;
		this.name = name;
	}
	
	public double getMid() {
		return mid;
	}
	public void setMid(double mid) {
		this.mid = mid;
	}
	public double getLast() {
		return last;
	}
	public void setLast(double last) {
		this.last = last;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getAvg2() {
		return avg2;
	}
	public void setAvg2(String avg2) {
		this.avg2 = avg2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
