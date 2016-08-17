package com.websystique.springsecurity.drools;

public class Glucose {

	int beforeFood, result1, result2;
	public Glucose(int beforeFood, int result1, int result2){
		this.beforeFood = beforeFood;
		this.result1 = result1;
		this.result2 = result2;
	}
	
	public int getBeforeFood(){
		return beforeFood;
	}
	
	public int getResult1(){
		return result1;
	}
	
	public int getResult2(){
		return result2;
	}
}
