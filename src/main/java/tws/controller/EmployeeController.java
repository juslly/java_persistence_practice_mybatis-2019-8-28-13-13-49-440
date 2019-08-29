package tws.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import tws.entity.Employee;
import tws.mapper.EmployeeMapper;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addEmployee(@RequestBody Employee employee) {
		
		employeeMapper.insertEmployee(employee);
		
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Employee> getEmployees(){
		return employeeMapper.selectEmployees();
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateEmployee(@PathVariable int id) {
		for(Employee employee:getEmployees()) {
			if(employee.getId() == id) {
				employeeMapper.updateEmployee(id);
				
			}
		}
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteEmployee(@PathVariable int id) {
		for(Employee employee:getEmployees()) {
			if(employee.getId() == id) {
				employeeMapper.deleteEmployee(id);
				
			}
		}
	}
	
	
	
	
	

}