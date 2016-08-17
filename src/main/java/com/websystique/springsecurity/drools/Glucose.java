package com.websystique.springsecurity.drools;

public class Glucose {

	int beforeFood1, result1, beforeFood2, result2;
	public Glucose(int beforeFood1, int result1, int beforeFood2, int result2){
		this.beforeFood1 = beforeFood1;
		this.beforeFood2 = beforeFood2;
		this.result1 = result1;
		this.result2 = result2;
	}
	
	public int getBeforeFood1(){
		return beforeFood1;
	}
	
	public int getBeforeFood2(){
		return beforeFood2;
	}
	
	public int getResult1(){
		return result1;
	}
	
	public int getResult2(){
		return result2;
	}
}
