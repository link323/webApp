package com.websystique.springsecurity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="pressure_results_table")
public class PressureResults {
	
	@Id
	@NotEmpty
    @Column(name="id", unique=true, nullable=false)
    private String id;
	
	@NotEmpty
    @Column(name="pesel", unique=true, nullable=false)
    private String pesel;
	
	@NotEmpty
    @Column(name="systolic",nullable=false)
    private String systolic;
	
	@NotEmpty
    @Column(name="diastolic",nullable=false)
    private String diastolic;
	
	@NotEmpty
    @Column(name="date_time",nullable=false)
    private String date;
	
	@NotEmpty
    @Column(name="comment",nullable=false)
    private String comment;
	
	public PressureResults(String id, String pesel, String systolic, String diastolic, String date, String comment){
		this.id = id;
		this.pesel = pesel;
		this.systolic = systolic;
		this.diastolic = diastolic;
		this.date = date;
		this.comment = comment;
	}
	public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
    
	public String getPesel() {
        return pesel;
    }
 
    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
    
    public String getSystolic() {
        return systolic;
    }
 
    public void setSystolic(String systolic) {
        this.systolic = systolic;
    }
    
    public String getDiastolic() {
        return diastolic;
    }
 
    public void setDiastolic(String diastolic) {
        this.diastolic = diastolic;
    }
    
    public String getDate() {
        return date;
    }
 
    public void setDate(String date) {
        this.date = date;
    }
    
    public String getComment() {
        return comment;
    }
 
    public void setComment(String comment) {
        this.comment = comment;
    }
}
