package com.bway.springproject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.springproject.model.Department;
import com.bway.springproject.repository.DepartmentRepository;
import com.bway.springproject.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository dptRepo;
	
	
	@Override
	public void addDept(Department dept) {
		dptRepo.save(dept);
		
	}

	@Override
	public void deleteDept(int id) {
		dptRepo.deleteById(id);
		
	}

	@Override
	public void updateDept(Department dept) {
		dptRepo.save(dept);
		
	}

	@Override
	public Department getDeptById(int id) {
		
		
		
		return dptRepo.findById(id).get();
	}

	@Override
	public List<Department> getAllDepts() {
		
		return dptRepo.findAll();
	}

}
