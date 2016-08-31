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
	public CheckDiabetesRisk(List<DiabeticResults> diabeticResults) {
		this.allPacientsDiabeticResults = diabeticResults;
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
	
	public Glucose buildGlucoseObjectForPacient(){
		int sizeOfList = allPacientsDiabeticResults.size();
		System.out.println("sizeOfList is "+ sizeOfList);
		Glucose glucose = new Glucose(Integer.parseInt(allPacientsDiabeticResults.get(sizeOfList-1).getBeforeFood()),
				Integer.parseInt(allPacientsDiabeticResults.get(sizeOfList-1).getResult()),
				Integer.parseInt(allPacientsDiabeticResults.get(sizeOfList-2).getBeforeFood()),
				Integer.parseInt(allPacientsDiabeticResults.get(sizeOfList-2).getResult()));
		System.out.println(glucose.beforeFood1 + " " + glucose.getResult1());
		System.out.println(glucose.beforeFood2 + " " + glucose.getResult2());
		return glucose;
	}
	
	public String callDrools(){
		Glucose glucose = buildGlucoseObject();
		Drools drools = new Drools(glucose);
		String result = drools.droolsGlucoseConfirmer();
		System.out.println("in callDrools "+result);
		
		return result;
	}
	
	public String callDroolsForPacient(){
		Glucose glucose = buildGlucoseObjectForPacient();
		System.out.println("creating drools object");
		Drools drools = new Drools(glucose);
		String result = drools.droolsGlucoseConfirmer();
		System.out.println("in callDrools "+result);
		
		return result;
	}
}
