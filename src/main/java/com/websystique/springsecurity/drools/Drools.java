package com.websystique.springsecurity.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class Drools {
    
	private String result;
    private Blood bloodPressure;
    private Glucose glucose;
    
    public Drools(Blood blood) {
        this.bloodPressure = blood;
    }
    
    public Drools(Glucose glucose) {
        this.glucose = glucose;
    }
    public String getResult(){
    	return result;
    }
    public void setResult(String s){
    	this.result = s;
    }
    
    public String droolsBloodPressureConfirmer(){
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");
        	kSession.insert(bloodPressure);
        	kSession.fireAllRules();

        } catch (Throwable t) {
            t.printStackTrace();
        }
		return "kot";
    }
    
    public String droolsGlucoseConfirmer(){
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");
        	kSession.insert(glucose);
        	kSession.fireAllRules();

        } catch (Throwable t) {
            t.printStackTrace();
        }
		return "kot";
    }
    
    public void display(String message){
    	System.out.println(message);
    }
}