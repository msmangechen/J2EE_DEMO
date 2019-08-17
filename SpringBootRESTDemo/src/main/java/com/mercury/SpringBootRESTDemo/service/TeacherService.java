package com.mercury.SpringBootRESTDemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.SpringBootRESTDemo.bean.Teacher;
import com.mercury.SpringBootRESTDemo.dao.TeacherDao;

@Service
public class TeacherService {

	@Autowired
	TeacherDao teacherDao;
	
	public List<Teacher> findAllTeachers() {
		return teacherDao.findAll();
	}
	
	public void addTeacher(Teacher teacher) {
		teacherDao.save(teacher);
	}
	
	public void updateTeacher(Integer id, Teacher teacher) {
		Optional<Teacher> oldOptional = teacherDao.findById(id);
		if (oldOptional.isPresent()) {
			Teacher old = oldOptional.get();
			old.setName(teacher.getName());
			old.setDeptId(teacher.getDeptId());
			teacherDao.save(old);
		}
	}
	
}

