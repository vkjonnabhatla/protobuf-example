package com.protobuf.exampe.protobufexample;

import java.util.Map;

import com.student.protobuf.StudentTraining.Course;

public class CourseRepository {
    Map<Integer, Course> courses;
     
    public CourseRepository (Map<Integer, Course> courses) {
        this.courses = courses;
    }
     
    public Course getCourse(int id) {
        return courses.get(id);
    }
}