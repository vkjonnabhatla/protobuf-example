package com.protobuf.exampe.protobufexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.protobuf.StudentTraining.Course;

import java.awt.*;

@RestController
public class CourseController {
    @Autowired
    CourseRepository courseRepo;
 
    @RequestMapping(value = "/courses/{id}", produces = {"application/xml", "application/x-protobuf", "application/json"})//produces = MediaType.APPLICATION_JSON_VALUE
    Course customer(@PathVariable Integer id) {
        return courseRepo.getCourse(id);
    }
}
