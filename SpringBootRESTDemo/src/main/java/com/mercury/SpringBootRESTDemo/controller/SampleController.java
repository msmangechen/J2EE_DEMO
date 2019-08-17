package com.mercury.SpringBootRESTDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SpringBootRESTDemo.bean.Sample;
import com.mercury.SpringBootRESTDemo.mail.EmailService;
import com.mercury.SpringBootRESTDemo.service.SampleService;

// 如果都需要@ResponseBody来传JSON，用@RestController: @Controller + @ResponseBody
// 为下面每个方法都添加@ResponseBody
@RestController
public class SampleController {
	
	@Autowired
	SampleService sampleService;

	@PreAuthorize("isAuthenticated()") // 登录成功都可以，还有PostAuthorize，方法运行前还是后的区别
	@GetMapping("/samples") 	// handle get request
	public List<Sample> getSample() {
		return sampleService.findAllSamples();
	}
	
	// sample data在request，request放在RequestBody
	@PostMapping("/samples")
	public void postSamples(@RequestBody Sample sample) {
		// @RequestBody: convert JSON object to Java object.
		sampleService.addSample(sample);
	}

	// path的var，name和上一行传进来的name必须一致，如果不一致，要用{name="name"}
	@PutMapping("/samples/{name}") // nodejs是:name
	public void putSamples(@PathVariable String name, @RequestBody Sample sample) {
		sampleService.updateSample(name, sample);
	}
	
	// Spring Cache demo
	// 这俩是为了实现对Cache的更新
	// @CacheEvit: delete a result from cache
	// @CachePut: save a new result in cache
	@Cacheable("prime")
	@GetMapping("/prime/{range}")
	public int getPrime(@PathVariable int range) throws InterruptedException {
		Thread.sleep(2000);
		return range * range;
	}
	
	@Autowired
	EmailService emailService;
	
	@PostMapping("/mail")
	public void sendMail(@RequestBody SimpleMailMessage smm) {
		emailService.sendEmail(smm);
	}
	
}
