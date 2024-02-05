package com.bway.springproject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.springproject.model.Employee;
import com.bway.springproject.repository.EmployeeRepository;
import com.bway.springproject.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public void addEmployee(Employee emp) {
		
		empRepo.save(emp);
	}

	@Override
	public void deleteEmployee(Long id) {
		
		empRepo.deleteById(id);
		
	}

	@Override
	public void update(Employee emp) {
		
		empRepo.save(emp);
		
	}

	@Override
	public Employee getEmpById(Long id) {
		
		
		return empRepo.findById(id).get();
	}

	@Override
	public List<Employee> getAllEmp() {
		
		return empRepo.findAll();
	}

}
