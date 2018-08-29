package com.zycus.test;

import org.junit.Test;

import com.zycus.dao.GenericD;
import com.zycus.entity.courseStudent.Course;
import com.zycus.entity.courseStudent.Student;

public class CourseStudentTest {

	GenericD genericD = new GenericD();

	@Test
	public void addFewCourses() {
		Course course = new Course();
		course.setName("science");
		course.setDuration(12);
		course.setFees(12000);

		genericD.create(course);

	}

	@Test
	public void addFewStudents() {

		Student student = new Student();
		student.setName("Aditya");
		student.setAddress("Mumbai");

		genericD.create(student);
	}

	@Test
	public void enrollAStudentForsomeCourse() {

		Course c1 = genericD.fetchById(1, Course.class);
		Student s1 = genericD.fetchById(1, Student.class);

		s1.getCourses().add(c1);
		genericD.update(s1);
	}

}
