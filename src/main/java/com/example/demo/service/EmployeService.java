package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employe;

public interface EmployeService {

	void saveEmploye(Employe e);

	List<Employe> getAllEmploye();

	Employe getEmploye(int id);

	Employe updateEmploye(Employe e);

	void deleteEmploye(int id);

}
