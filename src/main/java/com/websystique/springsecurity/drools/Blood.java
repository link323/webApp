package com.websystique.springsecurity.drools;

public class Blood {

	private int skurczowe1, rozkurczowe1, skurczowe2, rozkurczowe2, skurczowe3, rozkurczowe3;
	
	public Blood(int skurczowe1, int rozkurczowe1,int skurczowe2, int rozkurczowe2, int skurczowe3, int rozkurczowe3){
		this.skurczowe1 = skurczowe1;
		this.rozkurczowe1 = rozkurczowe1;
		this.skurczowe2 = skurczowe2;
		this.rozkurczowe2 = rozkurczowe2;
		this.skurczowe3 = skurczowe3;
		this.rozkurczowe3 = rozkurczowe3;
	}
	
	public int getSkurczowe1(){
		return skurczowe1;
	}
	
	public int getRozkurczowe1(){
		return rozkurczowe1;
	}
	public int getSkurczowe2(){
		return skurczowe2;
	}
	
	public int getRozkurczowe2(){
		return rozkurczowe2;
	}
	public int getSkurczowe3(){
		return skurczowe3;
	}
	
	public int getRozkurczowe3(){
		return rozkurczowe3;
	}
	
    public void display(String message){
    	System.out.println(message);
    }
}
