package com.websystique.springsecurity.model;

public class BMI {

	int weight, height;
	
	public BMI(int weight, int height){
		this.weight = weight;
		this.height = height; 
	}
	public BMI(){

	}
	
	public int getWeight() {
		return weight;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
}
