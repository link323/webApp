package com.websystique.springsecurity.drools;

import java.util.ArrayList;
import java.util.List;

import com.websystique.springsecurity.model.DiabeticResults;
import com.websystique.springsecurity.model.PressureResults;

public class CheckHypertensionRisk {
	List<PressureResults> allPacientsPressureResults;
	List<PressureResults> pressureResults = new ArrayList<>();
	String pesel;
	
	public CheckHypertensionRisk(List<PressureResults> diabeticResults, String pesel) {
		this.allPacientsPressureResults = diabeticResults;
		this.pesel = pesel;
	}
	public Blood buildBloodPressureObject(){
		for(PressureResults result : allPacientsPressureResults){
			if(result.getPesel() == pesel){
				pressureResults.add(result);
			}
		}
		int sizeOfList = pressureResults.size();
		
		Blood pressure = new Blood(Integer.parseInt(pressureResults.get(sizeOfList-1).getSystolic()),
				Integer.parseInt(pressureResults.get(sizeOfList-1).getDiastolic()),
				Integer.parseInt(pressureResults.get(sizeOfList-2).getSystolic()),
				Integer.parseInt(pressureResults.get(sizeOfList-2).getDiastolic()),
				Integer.parseInt(pressureResults.get(sizeOfList-3).getSystolic()),
				Integer.parseInt(pressureResults.get(sizeOfList-3).getDiastolic()));
		
		return pressure;
	}
	
	public String callDrools(){
		Blood pressure = buildBloodPressureObject();
		Drools drools = new Drools(pressure);
		drools.droolsBloodPressureConfirmer();
		return "";
	}
}
