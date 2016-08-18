package com.medapp.calculations;

import com.websystique.springsecurity.model.BMI;

public class BMITask {
	BMI bmi;
	
	public BMITask(BMI bmi){
		this.bmi = bmi;
	}
	
	public String count() {
//		bmi = masa [kg] / wzrost [m]^2
//		< 16,0 – wyg³odzenie
//		16,0–16,99 – wychudzenie (spowodowane czêsto przez ciê¿k¹ chorobê lub anoreksjê)
//		17,0–18,49 – niedowagê
//		18,5–24,99 – wartoœæ prawid³ow¹
//		25,0–29,99 – nadwagê
//		30,0–34,99 – I stopieñ oty³oœci
//		35,0–39,99 – II stopieñ oty³oœci (oty³oœæ kliniczna)
//	 	>= 40,0 – III stopieñ oty³oœci (oty³oœæ skrajna)
		String string;
		
		double height = (double)bmi.getHeight()/100.00;
		double weight = bmi.getWeight();
		
		double result = weight / Math.pow(height , 2);

		if(result<16.0) string = " wyg³odzenie";
		else if(result<=16.99) string = " wychudzenie";
		else if(result<=18.49) string = " niedowagê";
		else if(result<=24.99) string = " wartoœæ prawid³ow¹";
		else if(result<=29.99) string = " nadwagê";
		else if(result<=34.99) string = " I stopieñ oty³oœci";
		else if(result<=39.99) string = " II stopieñ oty³oœci";
		else string =" III stopieñ oty³oœci";
		
		return "Wynik " + result + " wskazuje na " + string;
	}
}
