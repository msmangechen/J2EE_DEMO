package com.mercury.SpringBootRESTDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.SpringBootRESTDemo.bean.Teacher;

public interface TeacherDao extends JpaRepository<Teacher, Integer> {

}
