package com.example.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	
	public List<Course> getAllCourse(String topicId){
		List<Course> courses = new ArrayList<>();
		for(Course t: courseRepository.findByTopicId(topicId)) {
			courses.add(t);
		}
		return courses;
	}
	
	
	public Optional<Course> getCourse(String id) { 
		return courseRepository.findById(id); 
	}
	 

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	
	public void updateCourse(Course course) {
		//works for both save and update
		courseRepository.save(course);
	}
	  
	
	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}
	 
}
