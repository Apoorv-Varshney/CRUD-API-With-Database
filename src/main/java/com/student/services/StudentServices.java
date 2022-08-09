package com.student.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.student.entity.Student;

@Component
public class StudentServices {

	public static List<Student> list = new ArrayList<>();

	static {
		list.add(new Student(101, "ashu", "agra"));
		list.add(new Student(102, "vivek", "delhi"));
	}

	public List<Student> getAll() {
		return list;
	}

	public Student getStudent(int id) {
		return list.stream().filter(i -> i.getId() == id).findFirst().get();
	}

	public Student createStudent(Student st) {
		list.add(st);
		return st;
	}

	public void deleteStudent(int id) {
		list = list.stream().filter(i -> i.getId() != id).collect(Collectors.toList());
	}

	public Student updateStudent(int id, Student st) {
		list.stream().map(s -> {
			if (s.getId() == id) {
				s.setName(st.getName());
				s.setCity(st.getCity());
			}
			return s;
		}).collect(Collectors.toList());
		return st;
	}

}
