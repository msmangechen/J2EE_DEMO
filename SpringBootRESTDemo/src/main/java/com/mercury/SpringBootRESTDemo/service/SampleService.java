package com.mercury.SpringBootRESTDemo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.SpringBootRESTDemo.bean.Sample;
import com.mercury.SpringBootRESTDemo.dao.SampleDao;

// business logic: 写在service而不是controller，这里的code非常重要！要背
@Service
public class SampleService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SampleDao sampleDao;
	
	public List<Sample> findAllSamples() {
		// System.out.println()会打印到控制台，不是网页本身
		System.out.println();
		// 用logger对象写日志
		logger.debug("debug - 1");
		logger.info("info - 2");
		logger.warn("warning - 3");
		return sampleDao.findAll();
	}
	
	// 添加到数据库
	public void addSample(Sample sample) { 
		sampleDao.save(sample);
	}
	
	// name is primary key, so we cannot change name
	public void updateSample(String name, Sample sample) {
		Optional<Sample> oldOptional = sampleDao.findById(name); // return null or other, avoid NullPointerException
		if (oldOptional.isPresent()) {
			Sample old = oldOptional.get();
			old.setAge(sample.getAge());
			sampleDao.save(old);
		}
	}
	
}
