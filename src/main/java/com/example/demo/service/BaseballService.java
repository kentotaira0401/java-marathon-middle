package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.League;
import com.example.demo.repository.BaseballRepository;

@Service
public class BaseballService {

	@Autowired
	private BaseballRepository repository;
	
	public League load(Integer id) {
		System.out.println("ser_id="+id);
		return repository.load(id);  
	}
	
	
}
