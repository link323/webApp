package com.medapp.calculations;

import com.websystique.springsecurity.model.Cholesterol;

public class CholesterolTasks {
	
	private Cholesterol cholesterol;
	
	public CholesterolTasks(Cholesterol cholesterol) {
		this.cholesterol = cholesterol;
	}

	public String checkTotal() {
		
		String result = "";
		
		if(cholesterol.getTotal() != 0){
			if(cholesterol.getTotal()<200) result = " desirable";
			else if(cholesterol.getTotal() <= 239) result = " borderline high";
			else result = " high - indicating a high risk of heart disease";
		}
		return "Result " + cholesterol.getTotal()+" is " + result;
	}

	public String checkHDL(){
		String result = "";
		if (cholesterol.isMale() == true){
			result = checkHDLMan();
		}else{
			result = checkHDLWoman();
		}
		return result;
	}
	public String checkHDLMan() {
		
		String result = "";
		
		if(cholesterol.getHdl() != 0){
			if(cholesterol.getHdl()<35) result = " too low";
			else if(cholesterol.getHdl() <= 70) result = " optimal";
			else result = " too high";
		}
		
		return "Result " + cholesterol.getHdl()+" is " + result;
	}
	
	public String checkHDLWoman() {
		
		String result = "";
		
		if(cholesterol.getHdl() != 0){
			if(cholesterol.getHdl()<40) result = " too low";
			else if(cholesterol.getHdl() <= 80) result = " optimal";
			else result = " too high";
		}
		
		return "Result " + cholesterol.getHdl()+" is " + result;
	}
	
	public String checkLDL() {
		
		String result = "";
		
		if(cholesterol.getLdl() != 0){
			if(cholesterol.getLdl()<100) result = " optimal";
			else if(cholesterol.getLdl() <= 129) result = " near optimal";
			else if(cholesterol.getLdl() <= 159) result = " borderline high";
			else if(cholesterol.getLdl() <= 189) result = " high";
			else result = " very high";
		}
		
		return "Result " + cholesterol.getLdl()+" is " + result;
	}
}
