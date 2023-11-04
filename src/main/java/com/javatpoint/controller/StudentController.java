package com.javatpoint.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatpoint.model.GuideLinesEntity;
import com.javatpoint.service.StudentService;
//creating RestController
@RestController
public class StudentController 
{
//autowired the StudentService class
@Autowired
StudentService studentService;
//creating a get mapping that retrieves all the students detail from the database 
@GetMapping("/student")
private List<GuideLinesEntity> getAllStudent() 
{
return studentService.getAllStudent();
}
//creating a get mapping that retrieves the detail of a specific student
//@GetMapping("/student/{id}")
//private Student getStudent(@PathVariable("id") int id) 
//{
//return studentService.getStudentById(id);
//}
////creating a delete mapping that deletes a specific student
//@DeleteMapping("/student/{id}")
//private void deleteStudent(@PathVariable("id") int id) 
//{
//studentService.delete(id);
//}
////creating post mapping that post the student detail in the database
@GetMapping("/createstudent")
private int saveStudent() 
{
studentService.saveOrUpdate();
return 1;
}
@GetMapping("/updatestudent")
private int update() 
{
studentService.update();
return 1;
}
}
