package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.EmployeeException.EmployeServiceException;
import com.example.demo.entity.Employe;
import com.example.demo.repository.EmployeRepository;
import com.example.demo.service.EmployeService;

@Service
public class EmployeServiceImpl implements EmployeService {

	@Autowired
	EmployeRepository er;

	@Override
	public void saveEmploye(Employe e) {

		if (er.existsById(e.getId())) {
			throw new EmployeServiceException("Employee already exists with id: " + e.getId(), HttpStatus.CONFLICT);
		}

		er.save(e);

	}

	@Override
	public List<Employe> getAllEmploye() {

		return er.findAll();
	}

	@Override
	public Employe getEmploye(int id) {

		Optional<Employe> o = er.findById(id);

		if (o.isPresent()) {
			return o.get();
		}

		throw new EmployeServiceException("Employenot Not Present", HttpStatus.NOT_FOUND);

	}

	@Override
	public Employe updateEmploye(Employe e) {

		if (!er.existsById(e.getId())) {
			throw new EmployeServiceException("Employee not found with id" + e.getId(), HttpStatus.NOT_FOUND);
		}

		return er.save(e);
	}

	@Override
	public void deleteEmploye(int id) {

		if (!er.existsById(id)) {
			throw new EmployeServiceException("Employee not found with id :" + id, HttpStatus.NOT_FOUND);
		}

		er.deleteById(id);

	}

}
