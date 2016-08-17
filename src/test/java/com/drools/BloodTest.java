package com.drools;

import static org.junit.Assert.*;

import org.junit.Test;

import com.websystique.springsecurity.drools.Blood;
import com.websystique.springsecurity.drools.Drools;
import com.websystique.springsecurity.drools.Glucose;

public class BloodTest {

	@Test
	public void checkIfHypertensionTestReturnTrue() {
		Blood blood = new Blood(140, 90, 150, 93, 138, 86);
		Drools drools = new Drools(blood);
		drools.droolsBloodPressureConfirmer();
		
	}
	
	@Test
	public void checkIfHypertensionTestReturnFalse() {
		Blood blood = new Blood(120, 90, 110, 78, 120, 80);
		Drools drools = new Drools(blood);
		drools.droolsBloodPressureConfirmer();
		
	}
	
	@Test
	public void checkIfDiabetesTestReturnTrueBeforeFood(){
		Glucose glucose = new Glucose(1, 140, 1, 136);
		Drools drools = new Drools(glucose);
		drools.droolsGlucoseConfirmer();
	}
	
	@Test
	public void checkIfDiabetesTestReturnTrueAfterFood(){
		Glucose glucose = new Glucose(0, 215, 0, 200);
		Drools drools = new Drools(glucose);
		drools.droolsGlucoseConfirmer();
	}
	
	@Test
	public void checkIfDiabetesTestReturnFalseBeforeFood(){
		Glucose glucose = new Glucose(1, 120, 1, 110);
		Drools drools = new Drools(glucose);
		drools.droolsGlucoseConfirmer();
	}
	
	@Test
	public void checkIfDiabetesTestReturnFalseAfterFood(){
		Glucose glucose = new Glucose(0, 170, 0, 150);
		Drools drools = new Drools(glucose);
		drools.droolsGlucoseConfirmer();
	}

}
