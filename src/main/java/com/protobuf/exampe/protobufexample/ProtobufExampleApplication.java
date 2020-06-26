package com.protobuf.exampe.protobufexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.student.protobuf.StudentTraining.Course;
import com.student.protobuf.StudentTraining.Student;
import com.student.protobuf.StudentTraining.Student.PhoneNumber;
import com.student.protobuf.StudentTraining.Student.PhoneType;

@SpringBootApplication
public class ProtobufExampleApplication {

	public static void main(String[] args) {
        SpringApplication.run(ProtobufExampleApplication.class, args);
    }

    @Bean
    RestTemplate restTemplate(ProtobufHttpMessageConverter hmc) {
        return new RestTemplate(Arrays.asList(hmc));
    }

    /**
     * This converter supports by default "application/x-protobuf" and "text/plain" with the official "com.google.protobuf:protobuf-java" library. Other formats can be supported with one of the following additional libraries on the classpath:
     *
     * "application/json", "application/xml", and "text/html" (write-only) with the "com.googlecode.protobuf-java-format:protobuf-java-format" third-party library
     * "application/json" with the official "com.google.protobuf:protobuf-java-util" for Protobuf 3 (see ProtobufJsonFormatHttpMessageConverter for a configurable variant)
     * Requires Protobuf 2.6 or higher (and Protobuf Java Format 1.4 or higher for formatting). This converter will auto-adapt to Protobuf 3 and its default protobuf-java-util JSON format if the Protobuf 2 based protobuf-java-format isn't present; however, for more explicit JSON setup on Protobuf 3, consider ProtobufJsonFormatHttpMessageConverter.
     * @return
     */
    @Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }

    @Bean
    public CourseRepository createTestCourses() {
        Map<Integer, Course> courses = new HashMap<>();

        Course course1 = Course.newBuilder().setId(0).setCourseDesc("xxxxxxxxx").addAllStudent(createTestStudents()).build();

        Course course2 = Course.newBuilder().setId(2).setCourseName("Learn Spring Security").addAllStudent(createTestStudents()).build();

        courses.put(course1.getId(), course1);
        courses.put(course2.getId(), course2);

        return new CourseRepository(courses);
    }

    private List<Student> createTestStudents() {
        PhoneNumber phone1 = createPhone("123456", PhoneType.MOBILE);
        Student student1 = createStudent(0, "", "Doe", "john.doe@baeldung.com", Arrays.asList(phone1));

        PhoneNumber phone2 = createPhone("234567", PhoneType.LANDLINE);
        Student student2 = createStudent(0, "Krishna", "Roe", "richard.roe@baeldung.com", Arrays.asList(phone2));

        PhoneNumber phone3_1 = createPhone("345678", PhoneType.MOBILE);
        PhoneNumber phone3_2 = createPhone("456789", PhoneType.LANDLINE);
        Student student3 = createStudent(3, "", "Doe", "jane.doe@baeldung.com", Arrays.asList(phone3_1, phone3_2));

        return Arrays.asList(student1, student2, student3);
    }

    private Student createStudent(int id, String firstName, String lastName, String email, List<PhoneNumber> phones) {
        return Student.newBuilder().setId(id).setFirstName(firstName).setLastName(lastName).setEmail(email).addAllPhone(phones).build();
    }

    private PhoneNumber createPhone(String number, PhoneType type) {
        return PhoneNumber.newBuilder().setNumber(number).setType(type).build();
    }

}
