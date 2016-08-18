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
			if(cholesterol.getTotal()<200) result = " w normie";
			else if(cholesterol.getTotal() <= 239) result = " podwy¿szony";
			else result = " wskazuj¹cy na wysokie ryzyko chorób serca";
		}
		return cholesterol.getTotal()+" to wynik " + result;
	}

	public String checkHDLMan() {
		
		String result = "";
		
		if(cholesterol.getHdl() != 0){
			if(cholesterol.getHdl()<35) result = " poni¿ej normy";
			else if(cholesterol.getHdl() <= 70) result = " w normie";
			else result = " powy¿ej normy";
		}
		
		return cholesterol.getHdl()+" to wynik " + result;
	}
	
	public String checkHDLWoman() {
		
		String result = "";
		
		if(cholesterol.getHdl() != 0){
			if(cholesterol.getHdl()<40) result = " poni¿ej normy";
			else if(cholesterol.getHdl() <= 80) result = " w normie";
			else result = " powy¿ej normy";
		}
		
		return cholesterol.getHdl()+" to wynik " + result;
	}
	
	public String checkLDL() {
		
		String result = "";
		
		if(cholesterol.getLdl() != 0){
			if(cholesterol.getLdl()<100) result = " optymalny";
			else if(cholesterol.getLdl() <= 129) result = " powiêkszony optymalny";
			else if(cholesterol.getLdl() <= 159) result = " graniczny";
			else if(cholesterol.getLdl() <= 189) result = " wysoki";
			else result = " bardzo wysoki";
		}
		
		return cholesterol.getLdl()+" to wynik " + result;
	}
}
