package com.crud.example.Dao;

import java.util.List;

import com.crud.example.model.Student;

public interface StudentDao {
	public void ADD(Student student);
	public void EDIT(Student student);
	public void DELETE(int studentId);
	public Student GETStudent(int studentId);
	public List GETALLStudent();
}
