package com.drools;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.websystique.springsecurity.drools.CheckDiabetesRisk;
import com.websystique.springsecurity.drools.CheckHypertensionRisk;
import com.websystique.springsecurity.model.DiabeticResults;
import com.websystique.springsecurity.model.PressureResults;

public class CheckHypertensionRiskTest {

	@Test
	public void checkIfHypertensionTestReturnTrue() {
		List<PressureResults> pressureResults = new ArrayList<>();
		String pesel = "90032511780";
		pressureResults.add(new PressureResults("1","90032511780", "140", "90", "", ""));
		pressureResults.add(new PressureResults("1","90032511780", "135", "90", "", ""));
		pressureResults.add(new PressureResults("1","90032511777", "150", "90", "", ""));
		pressureResults.add(new PressureResults("1","90032511780", "135", "90", "", ""));
		CheckHypertensionRisk risk = new CheckHypertensionRisk(pressureResults, pesel);
		risk.callDrools();
	}
	@Test
	public void checkIfHypertensionTestReturnFalse() {
		List<PressureResults> pressureResults = new ArrayList<>();
		String pesel = "90032511780";
		pressureResults.add(new PressureResults("1","90032511780", "120", "80", "", ""));
		pressureResults.add(new PressureResults("1","90032511780", "135", "90", "", ""));
		pressureResults.add(new PressureResults("1","90032511777", "150", "90", "", ""));
		pressureResults.add(new PressureResults("1","90032511780", "120", "80", "", ""));
		CheckHypertensionRisk risk = new CheckHypertensionRisk(pressureResults, pesel);
		risk.callDrools();
	}
}
