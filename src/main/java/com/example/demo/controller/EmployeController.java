package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employe;
import com.example.demo.service.EmployeService;

@RestController
public class EmployeController {

	@Autowired
	EmployeService es;

	@PostMapping("/employe")
	ResponseEntity addEmploye(@RequestBody Employe e) {

		es.saveEmploye(e);
		
		return new ResponseEntity(HttpStatus.CREATED);

	}

	@GetMapping("/all")
	public List<Employe> getAllEmploye() {
		return es.getAllEmploye();
	}

	@GetMapping("/{id}")
	ResponseEntity getEmploye(@PathVariable int id) {

		Employe e = es.getEmploye(id);
		return new ResponseEntity(HttpStatus.OK);
	}

	@PostMapping("/update")
	public Employe updateEmploye(@RequestBody Employe e) {
		return es.updateEmploye(e);

	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmploye(@PathVariable int id) {
		es.deleteEmploye(id);
		return "Employe Deleted ";
	}

}
