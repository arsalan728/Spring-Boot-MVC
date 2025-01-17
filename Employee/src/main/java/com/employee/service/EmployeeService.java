package com.employee.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.EmployeeEntity;
import com.employee.model.EmployeeModel;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
@Autowired
EmployeeRepository employeeRepository;

public void saveEmployeeDetails(EmployeeModel employeeModel) {
	double hra=employeeModel.getSalary()*5/100;
	double da=employeeModel.getSalary()*3/100;
	double pf=employeeModel.getSalary()*2/100;
	double bonus=employeeModel.getSalary()*10/100;
	double finalsalary= hra+da+pf+bonus+employeeModel.getSalary();
	finalsalary=finalsalary-pf;
	EmployeeEntity employeeEntity=new EmployeeEntity();
	
	employeeEntity.setFinalSalary(finalsalary);
	employeeEntity.setBonus(bonus);
	employeeEntity.setDa(da);
	employeeEntity.setHra(hra);
	employeeEntity.setPf(pf);
	
	employeeEntity.setName(employeeModel.getName());
	employeeEntity.setEmailId(employeeModel.getEmailId());
	employeeEntity.setDob(employeeModel.getDob());
	employeeEntity.setDepartment(employeeModel.getDepartment());
	employeeEntity.setLocation(employeeModel.getLocation());
	employeeEntity.setPhoneNO(employeeModel.getPhoneNO());
	employeeEntity.setSalary(employeeModel.getSalary());
	
	employeeRepository.save(employeeEntity);
}

}
