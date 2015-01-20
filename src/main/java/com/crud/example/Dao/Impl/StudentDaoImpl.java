package com.crud.example.Dao.Impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crud.example.Dao.StudentDao;
import com.crud.example.model.Student;
@Repository
public class StudentDaoImpl implements StudentDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void ADD(Student student) {
		sessionFactory.getCurrentSession().save(student);
		
	}

	public void EDIT(Student student) {
		sessionFactory.getCurrentSession().update(student);
		
	}

	public void DELETE(int studentId) {
		sessionFactory.getCurrentSession().delete(GETStudent(studentId));
		
	}

	public Student GETStudent(int studentId) {
		
		return (Student) sessionFactory.getCurrentSession().get(Student.class, studentId);
	}

	public List GETALLStudent() {
		
		return sessionFactory.getCurrentSession().createQuery("from student").list();
	}

}
