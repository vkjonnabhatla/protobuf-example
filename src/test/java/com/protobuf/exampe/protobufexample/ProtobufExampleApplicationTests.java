package com.protobuf.exampe.protobufexample;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.google.protobuf.util.JsonFormat;
import com.student.protobuf.StudentTraining.Course;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ProtobufExampleApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public class ProtobufExampleApplicationTests {
/*
	@Test
	public void contextLoads() {
	}
	
	private static final String COURSE1_URL = "http://localhost:8080/courses/0";

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void whenUsingRestTemplate_thenSucceed() {
        ResponseEntity<Course> course = restTemplate.getForEntity(COURSE1_URL, Course.class);
        assertResponse(course.toString());
    }

    @Test
    public void whenUsingHttpClient_thenSucceed() throws IOException {
        InputStream responseStream = executeHttpRequest(COURSE1_URL);
        String jsonOutput = convertProtobufMessageStreamToJsonString(responseStream);
        System.out.println(jsonOutput);
        assertResponse(jsonOutput);
    }

    private InputStream executeHttpRequest(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        HttpResponse httpResponse = httpClient.execute(request);
        return httpResponse.getEntity().getContent();
    }

    private String convertProtobufMessageStreamToJsonString(InputStream protobufStream) throws IOException {
        JsonFormat jsonFormat = new JsonFormat();
        Course course = Course.parseFrom(protobufStream);
        BufferedReader br = new BufferedReader(new InputStreamReader(protobufStream));

    		String output;
    		System.out.println("Output from Server .... \n");
    		while ((output = br.readLine()) != null) {
    			System.out.println(output);
    		}
    		
        return jsonFormat.printToString(course);
    }

    private void assertResponse(String response) {
        assertThat(response, containsString("id"));
        assertThat(response, containsString("course_name"));
        assertThat(response, containsString("REST with Spring"));
        assertThat(response, containsString("student"));
        assertThat(response, containsString("first_name"));
        assertThat(response, containsString("last_name"));
        assertThat(response, containsString("email"));
        assertThat(response, containsString("john.doe@baeldung.com"));
        assertThat(response, containsString("richard.roe@baeldung.com"));
        assertThat(response, containsString("jane.doe@baeldung.com"));
        assertThat(response, containsString("phone"));
        assertThat(response, containsString("number"));
        assertThat(response, containsString("type"));
    }
*/
}
