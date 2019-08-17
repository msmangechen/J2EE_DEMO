package com.mercury.SpringBootRESTDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mercury.SpringBootRESTDemo.bean.Teacher;
import com.mercury.SpringBootRESTDemo.service.TeacherService;

@RestController
public class TeacherController {

	@Autowired
	TeacherService teacherService;
	
	@GetMapping("/teachers")
	public List<Teacher> getTeacher() {
		return teacherService.findAllTeachers();
	}
	
	@PostMapping("/teachers")
	public void postTeacher(@RequestBody Teacher teacher) {
		teacherService.addTeacher(teacher);
	}
	
	@PutMapping("/teachers/{id}")
	public void putTeacher(@PathVariable Integer id, @RequestBody Teacher teacher) {
		teacherService.updateTeacher(id, teacher);
	}
	
}
