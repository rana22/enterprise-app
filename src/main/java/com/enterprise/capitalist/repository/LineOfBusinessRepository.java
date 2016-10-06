package com.enterprise.capitalist.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.enterprise.capitalist.model.LineOfBusiness;

public interface LineOfBusinessRepository extends Repository<LineOfBusiness, Long> {
	
	List<LineOfBusiness> findAll();
	LineOfBusiness findById(Long Id); 
}
