package com.crud.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.crud.example.Service.StudentService;
import com.crud.example.model.Student;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/index")
	public String setupForm(Map<String, Object> map){
		Student student = new Student();
		map.put("student", student);
		map.put("studentList", studentService.GETALLStudent());
		return "student";
	}
	@RequestMapping(value="/student.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Student student, BindingResult result, @RequestParam String action, Map<String, Object> map){
		Student studentResult = new Student();
		HashMap<String, Integer> hMap = new HashMap<String, Integer>();
		hMap.put("add", 1);
		hMap.put("edit", 2);
		hMap.put("delete", 3);
		hMap.put("search", 4);
		switch(hMap.get(action.toLowerCase())){
		case 1:
			studentService.ADD(student);
			studentResult = student;
			break;
		case 2:
			studentService.EDIT(student);
			studentResult = student;
			break;
		case 3:
			studentService.DELETE(student.getStudentId());
			studentResult = new Student();
			break;
		case 4:
			Student searchedStudent = studentService.GETStudent(student.getStudentId());
			studentResult = searchedStudent!=null ? searchedStudent : new Student();
			break;
		}
		map.put("student", studentResult);
		map.put("studentList", studentService.GETALLStudent());
		return "student";
	}
}
