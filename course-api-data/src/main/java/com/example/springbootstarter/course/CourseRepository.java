package com.example.springbootstarter.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface CourseRepository extends CrudRepository<Course, String> {
	
	public List<Course> findByTopicId(String TopicId);

}
