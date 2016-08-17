package com.websystique.springsecurity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name="diabetic_results_table")
public class DiabeticResults {
	@Id
	@NotEmpty
    @Column(name="doctor_id", nullable=false)
    private String doctorId;
	
	@NotEmpty
    @Column(name="pesel", nullable=false)
    private String pesel;

	@NotEmpty
    @Column(name="result",nullable=false)
    private String result;

	@NotEmpty
    @Column(name="date_time",nullable=false)
    private String date;
	
	@NotEmpty
    @Column(name="before_food",nullable=false)
    private String beforeFood;
	
	@NotEmpty
    @Column(name="comment",nullable=false)
    private String comment;

	public DiabeticResults(String doctorId, String pesel, String result, String date, String beforeFood, String comment){
		this.doctorId = doctorId;
		this.pesel = pesel;
		this.result = result;
		this.date = date;
		this.beforeFood = beforeFood;
		this.comment = comment;
	}
	
	public DiabeticResults(){
		
	}
	
	public String getId() {
        return doctorId;
    }
 
    public void setId(String doctorId) {
        this.doctorId = doctorId;
    }
	public String getPesel() {
        return pesel;
    }
 
    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
 
    public String getResult() {
        return result;
    }
 
    public void setResult(String result) {
        this.result = result;
    }
    
    public String getDate() {
        return date;
    }
 
    public void setDate(String date) {
        this.date = date;
    }
    
    public String getBeforeFood() {
        return beforeFood;
    }
 
    public void setBeforeFood(String beforeFood) {
        this.beforeFood = beforeFood;
    }
    
    public String getComment() {
        return comment;
    }
 
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public String toString() {
        return "Result [pesel=" + pesel + ", result=" + result + ", date=" + date + ", before food =" + beforeFood
                + ", comment=" + comment +"]";
    }
}
