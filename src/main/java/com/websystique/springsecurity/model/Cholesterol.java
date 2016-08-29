package com.websystique.springsecurity.model;

import org.drools.compiler.lang.DRL5Expressions.relationalOp_return;

public class Cholesterol {

	int total, hdl, ldl;
	boolean male;
	
	public Cholesterol(int total, int hdl, int ldl, boolean male){
		this.total = total;
		this.hdl = hdl;
		this.ldl = ldl;
		this.male = male;
	}
	
	public Cholesterol() {
		// TODO Auto-generated constructor stub
	}

	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public int getHdl() {
		return hdl;
	}
	
	public void setHdl(int hdl){
		this.hdl = hdl;
	}
	
	public int getLdl() {
		return ldl;
	}
	
	public void setLdl(int ldl) {
		this.ldl = ldl;
	}
	
	public boolean isMale(){
		return male;
	}
	
	public void setMale(boolean male) {
		this.male = male;
	}
}
