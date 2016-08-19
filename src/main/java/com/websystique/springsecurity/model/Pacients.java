package com.websystique.springsecurity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="pacients_list")
public class Pacients {
	
	@Id
	@NotEmpty
    @Column(name="pesel", nullable=false)
    private String pesel;
	
	@NotEmpty
    @Column(name="name", nullable=false)
    private String name;

	@NotEmpty
    @Column(name="surname",nullable=false)
    private String surname;
	
	public Pacients(){
		
	}
	
	public Pacients(String pesel, String name, String surname){
		this.pesel = pesel;
		this.name = name;
		this.surname = surname;
	}
	
	public String getPesel(){
		return pesel;
	}
	
	public String getName(){
		return name;
	}
	
	public String getSurname(){
		return surname;
	}
	
	public void setPesel(String pesel){
		this.pesel = pesel;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setSurname(String surname){
		this.surname = surname;
	}
}
