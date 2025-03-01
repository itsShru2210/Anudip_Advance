package com.example.demo.StudentController;


import java.util.*;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Students.Student;

@RestController
@RequestMapping("/studData")
public class studController {
	
		private Map<Long,Student> studentEntry=new HashMap<>();
		
		
		//Getting all the data /list of student
		@GetMapping    //("{myId}")
		public List<Student> getAll(){
			return new ArrayList<>(studentEntry.values());
		}

		//Data created by using post method or postMapping 
		@PostMapping
		public boolean createEntry(@RequestBody Student myEntry) {
			studentEntry.put(myEntry.getId(), myEntry);
			return true;
		}
		
		//Get individual student data by their id
		@GetMapping("id/{myId}")
		public Student getStudentsById(@PathVariable Long myId) {
			return  studentEntry.get(myId);
		}
		
		
		//delete student individually by their id
		@DeleteMapping("id/{myId}")
		public Student deleteStudentById(@PathVariable Long myId) {
			return studentEntry.remove(myId);
		}
		
		//update students by their id
		@PutMapping("/id/{id}")
		public Student updateStudentById(@PathVariable Long id,@RequestBody Student myEntry) {
			return studentEntry.put(id, myEntry);
		}
		
	
		@GetMapping("/abc")
		public String healthCheck() {
			return "Site is working";
		}
}