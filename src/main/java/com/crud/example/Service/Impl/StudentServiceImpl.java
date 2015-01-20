package com.crud.example.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.example.Dao.StudentDao;
import com.crud.example.Service.StudentService;
import com.crud.example.model.Student;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDao  studentDao;
	@Transactional
	public void ADD(Student student) {
		studentDao.ADD(student);
		
	}
	@Transactional
	public void EDIT(Student student) {
		studentDao.EDIT(student);
		
	}
	@Transactional
	public void DELETE(int studentId) {
		studentDao.DELETE(studentId);;
		
	}
	@Transactional
	public Student GETStudent(int studentId) {
		return studentDao.GETStudent(studentId);
	}
	@Transactional
	public List GETALLStudent() {
		return studentDao.GETALLStudent();
	}

}
