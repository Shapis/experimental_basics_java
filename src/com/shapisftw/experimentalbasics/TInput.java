package com.shapisftw.experimentalbasics;

public class TInput implements Cloneable {
	private String name;
	private String unit1;
	private String unit2;
	private int id;
	private double value1;
	private double value2;
	private double uncertainty1;
	private double uncertainty2;
	
	
	public TInput()	{
		
	}
	
	public TInput(String name, String unit, int id, double value1, double uncertainty)	{
	this.name = name;
	this.unit1 = unit;
	this.id = id;
	this.value1 = value1;
	this.uncertainty1 = uncertainty;
		
	}
	
	
	public TInput(String name, String unit1, String unit2, int id, double value1, double value2, double uncertainty1, double uncertainty2)	{
	this.name = name;
	this.unit1 = unit1;
	this.unit2 = unit2;
	this.id = id;
	this.value1 = value1;
	this.value2 = value2;
	this.uncertainty1 = uncertainty1;
	this.uncertainty2 = uncertainty2;
	}
	
	public String getUnit1() {
		return unit1;
	}
	
	public String getUnit2() {
		return unit2;
	}
	
	public void setUnit1(String unit1) {
		this.unit1 = unit1;
	}
	
	public void setUnit2(String unit2) {
		this.unit2 = unit2;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getValue1() {
		return value1;
	}
	public void setValue1(double value) {
		this.value1 = value;
		
	}
	
	public double getValue2() {
		return value2;
	}
	public void setValue2(double value) {
		this.value2 = value;
	}
	public double getUncertainty1() {
		return uncertainty1;
	}
	
	public double getUncertainty2() {
		return uncertainty2;
	}
	public void setUncertainty(double uncertainty) {
		this.uncertainty1 = uncertainty;
	}
	
	public Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
	
	
}
