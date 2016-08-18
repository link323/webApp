package com.medapp.calculations;

import com.websystique.springsecurity.model.BMI;

public class BMITask {
	BMI bmi;
	
	public BMITask(BMI bmi){
		this.bmi = bmi;
	}
	
	public String count() {
//		bmi = masa [kg] / wzrost [m]^2
//		< 16,0 � wyg�odzenie
//		16,0�16,99 � wychudzenie (spowodowane cz�sto przez ci�k� chorob� lub anoreksj�)
//		17,0�18,49 � niedowag�
//		18,5�24,99 � warto�� prawid�ow�
//		25,0�29,99 � nadwag�
//		30,0�34,99 � I stopie� oty�o�ci
//		35,0�39,99 � II stopie� oty�o�ci (oty�o�� kliniczna)
//	 	>= 40,0 � III stopie� oty�o�ci (oty�o�� skrajna)
		String string;
		
		double height = (double)bmi.getHeight()/100.00;
		double weight = bmi.getWeight();
		
		double result = weight / Math.pow(height , 2);

		if(result<16.0) string = " wyg�odzenie";
		else if(result<=16.99) string = " wychudzenie";
		else if(result<=18.49) string = " niedowag�";
		else if(result<=24.99) string = " warto�� prawid�ow�";
		else if(result<=29.99) string = " nadwag�";
		else if(result<=34.99) string = " I stopie� oty�o�ci";
		else if(result<=39.99) string = " II stopie� oty�o�ci";
		else string =" III stopie� oty�o�ci";
		
		return "Wynik " + result + " wskazuje na " + string;
	}
}
