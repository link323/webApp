package com.medapp.calculations;

import com.websystique.springsecurity.model.BMI;

public class BMITask {
	BMI bmi;
	
	public BMITask(BMI bmi){
		this.bmi = bmi;
	}
	
	public String count() {

		String string;
		
		double height = (double)bmi.getHeight()/100.00;
		double weight = bmi.getWeight();
		
		double result = weight / Math.pow(height , 2);

		if(result<16.0) string = " severe thinness";
		else if(result<=16.99) string = " moderate thinness";
		else if(result<=18.49) string = " mild thinness";
		else if(result<=24.99) string = " normal range";
		else if(result<=29.99) string = " overweight - pre-obese";
		else if(result<=34.99) string = " obese class I";
		else if(result<=39.99) string = "  obese class II";
		else string =" obese class III";
		
		return "Result " + result + " is classified as " + string;
	}
}
