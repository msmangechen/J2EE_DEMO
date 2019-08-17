package com.mercury.SpringBootRESTDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SpringBootRESTDemo.bean.Sample;

public interface SampleDao extends JpaRepository<Sample, String> {
	
}
