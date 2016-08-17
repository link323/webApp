package com.websystique.springsecurity.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springsecurity.model.DiabeticResults;
import com.websystique.springsecurity.model.PressureResults;
import com.websystique.springsecurity.model.User;

@Repository("ResultsDao")
public class ResultsDaoImpl extends AbstractDao<Integer, DiabeticResults> implements ResultsDao {
	
    @SuppressWarnings("unchecked")
	@Override
	public List<DiabeticResults> findAllDiabeticResults(){
		Criteria criteria = createCriteria(DiabeticResults.class);//.addOrder(Order.asc("pesel"));
        //criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<DiabeticResults> results = (List<DiabeticResults>) criteria.list();

        return results;
	}
    
    @SuppressWarnings("unchecked")
	@Override
	public List<PressureResults> findAllPressureResults(){
		Criteria criteria = createCriteria(PressureResults.class);//.addOrder(Order.asc("pesel"));
        //criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<PressureResults> results = (List<PressureResults>) criteria.list();

        return results;
	}
}
