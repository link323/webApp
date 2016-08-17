package com.websystique.springsecurity.drools;

import java.util.ArrayList;
import java.util.List;

import com.websystique.springsecurity.model.DiabeticResults;
import com.websystique.springsecurity.model.PressureResults;

public class CheckDiabetesRisk {
	List<DiabeticResults> allPacientsDiabeticResults;
	List<DiabeticResults> diabeticResults = new ArrayList<>();
	String pesel;
	
	public CheckDiabetesRisk(List<DiabeticResults> diabeticResults, String pesel) {
		this.allPacientsDiabeticResults = diabeticResults;
		this.pesel = pesel;
	}
	public Glucose buildGlucoseObject(){
		for(DiabeticResults result : allPacientsDiabeticResults){
			if(result.getPesel() == pesel){
				diabeticResults.add(result);
			}
		}
		int sizeOfList = diabeticResults.size();
		
		Glucose glucose = new Glucose(Integer.parseInt(diabeticResults.get(sizeOfList-1).getBeforeFood()),
				Integer.parseInt(diabeticResults.get(sizeOfList-1).getResult()),
				Integer.parseInt(diabeticResults.get(sizeOfList-2).getBeforeFood()),
				Integer.parseInt(diabeticResults.get(sizeOfList-2).getResult()));
		
		return glucose;
	}
	
	public String callDrools(){
		Glucose glucose = buildGlucoseObject();
		Drools drools = new Drools(glucose);
		drools.droolsGlucoseConfirmer();
		return "";
	}
}
