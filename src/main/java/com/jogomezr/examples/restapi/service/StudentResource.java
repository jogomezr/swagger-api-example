package com.jogomezr.examples.restapi.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.jogomezr.examples.restapi.domain.NewStudent;
import com.jogomezr.examples.restapi.domain.Student;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "students", description = "The students API")
public class StudentResource {

	@ApiOperation(value = "", nickname = "getAllStudents", notes = "Return a list of available students", response = Student.class, tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "returns a list containing the available students", response = Student.class, responseContainer = "List") })
	@GET
	public List<Student> getAllStudents() {

		return Stream.of(new Student(1L, "Peter", "Griffin", 58), new Student(2L, "Peter", "Griffin", 58))
				.collect(Collectors.toList());

	}

	@ApiOperation(value = "", nickname = "getStudentById", notes = "By passing in the appropriate identifier, you can get the student details", response = Student.class, tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "returns the student details for the provided identifier", response = Student.class),
			@ApiResponse(code = 400, message = "Bad input parameters"),
			@ApiResponse(code = 404, message = "Not found") })
	@GET
	@Path("/{id}")
	public Student getStudentById(@ApiParam(value = "ID of student", required = true) @PathParam("id")Long id) {
		return new Student(id, "Peter", "Griffin", 58);
	}

	@ApiOperation(value = "", nickname = "addStudent", notes = "Creates a new student based on the provided data", response = Student.class, tags = {})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "returns the new student details", response = Student.class),
			@ApiResponse(code = 400, message = "Bad input parameters") })
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Student addStudent(@ApiParam(value = "Data to create a new student", required = true) NewStudent student) {
		return new Student(Double.doubleToLongBits(Math.random()), student.getFirstName(), student.getLastName(),
				student.getAge());
	}

}
