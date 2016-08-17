package com.drools;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.websystique.springsecurity.drools.CheckDiabetesRisk;
import com.websystique.springsecurity.model.DiabeticResults;

public class CheckDiabetesRiskTest {

	@Test
	public void checkIfDiabetesTestReturnTrue() {
		List<DiabeticResults> diabeticResults = new ArrayList<>();
		String pesel = "90032511780";
		diabeticResults.add(new DiabeticResults("1","90032511780", "200", "", "1", ""));
		diabeticResults.add(new DiabeticResults("1","90032511780", "210", "", "1", ""));
		diabeticResults.add(new DiabeticResults("1","90032511777", "200", "", "1", ""));
		CheckDiabetesRisk risk = new CheckDiabetesRisk(diabeticResults, pesel);
		risk.callDrools();
	}
	@Test
	public void checkIfDiabetesTestReturnFalse() {
		List<DiabeticResults> diabeticResults = new ArrayList<>();
		String pesel = "90032511780";
		diabeticResults.add(new DiabeticResults("1","90032511780", "130", "", "1", ""));
		diabeticResults.add(new DiabeticResults("1","90032511780", "130", "", "1", ""));
		diabeticResults.add(new DiabeticResults("1","90032511777", "130", "", "1", ""));
		CheckDiabetesRisk risk = new CheckDiabetesRisk(diabeticResults, pesel);
		risk.callDrools();
	}
}
