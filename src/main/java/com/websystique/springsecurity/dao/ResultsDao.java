package com.websystique.springsecurity.dao;

import java.util.List;

import com.websystique.springsecurity.model.DiabeticResults;
import com.websystique.springsecurity.model.PressureResults;

public interface ResultsDao {
	
	List<DiabeticResults> findAllDiabeticResults();

	List<PressureResults> findAllPressureResults();
	
}