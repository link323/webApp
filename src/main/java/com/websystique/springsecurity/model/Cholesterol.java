package com.websystique.springsecurity.model;

import org.drools.compiler.lang.DRL5Expressions.relationalOp_return;

public class Cholesterol {

	int total, hdl, ldl;
	
	public Cholesterol(int total, int hdl, int ldl){
		this.total = total;
		this.hdl = hdl;
		this.ldl = ldl;
	}
	
	public Cholesterol() {
		// TODO Auto-generated constructor stub
	}

	public int getTotal() {
		return total;
	}
	
	public int getHdl() {
		return hdl;
	}
	
	public int getLdl() {
		return ldl;
	}
}
