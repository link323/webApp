package com.websystique.springsecurity.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class Drools {
    
    private Blood bloodPressure;
    private Glucose glucose;
    
    public Drools(Blood blood) {
        this.bloodPressure = blood;
    }
    
    public Drools(Glucose glucose) {
        this.glucose = glucose;
    }
    
    public String droolsBloodPressureConfirmer(){
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");
        	kSession.insert(bloodPressure);
        	kSession.fireAllRules();

        	System.out.println("in droolsGlucoseConfirmer "+bloodPressure.getInterpretation());
        } catch (Throwable t) {
            t.printStackTrace();
        }
		return bloodPressure.getInterpretation();
    }
    
    public String droolsGlucoseConfirmer(){
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");
        	kSession.insert(glucose);
        	
        	System.out.println(glucose.getInterpretation());

        	kSession.fireAllRules();
        	
        	System.out.println("in droolsGlucoseConfirmer "+glucose.getInterpretation());

        } catch (Throwable t) {
            t.printStackTrace();
        }
		return glucose.getInterpretation();
    }
}