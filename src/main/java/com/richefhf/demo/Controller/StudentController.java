package com.richefhf.demo.Controller;

import com.richefhf.demo.model.Student;
import com.richefhf.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController // serve as a restful API
@RequestMapping("api/v1/students") // URL path for client
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //RequestMapping (method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    //RequestMapping (method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path = "{studentId}")
    @GetMapping(path = "{studentId}")
    public Student getStudentById(@PathVariable("studentId") UUID studentId) {
        return studentService.getStudentById(studentId);
    }

    //RequestMapping (method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    public void insertNewStudent(@RequestBody Student student) {
        studentService.postNewStudent(null, student);
    }

    //RequestMapping (method = RequestMethod.PUT, consume = MediaType.APPLICATION_JSON_VALUE, path = "{studentId}")
    @PutMapping(path = "{studentId")
    public void updateStudentById(@PathVariable("studentId") UUID studentId, @RequestBody Student student) {
        studentService.updateStudentById(studentId, student);
    }

    //RequestMapping (method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, path = "{studentId}")
    @DeleteMapping("{studentId}")
    public void deleteStudentById(@PathVariable("studentId") UUID studentId) {
        studentService.deleteStudentById(studentId);
    }
}
