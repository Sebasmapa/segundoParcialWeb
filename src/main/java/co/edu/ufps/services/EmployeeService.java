package co.edu.ufps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.entities.Employee;
import co.edu.ufps.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
    private EmployeeRepository employeeRepository;
	
	public List<Employee> listEmployees() {
        return employeeRepository.findAll();
    }
	
	public Employee updateEmployee(Integer id, Employee employeeDetails) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setFirst_name(employeeDetails.getFirst_name());
            employee.setLast_name(employeeDetails.getLast_name());
            employee.setBirthdate(employeeDetails.getBirthdate());
            employee.setEntry_date(employeeDetails.getEntry_date());
            return employeeRepository.save(employee);
        }
        throw new RuntimeException("Empleado no encontrado con el id: " + id);
    }
	
	public Employee getEmployeeWithSalary(Integer id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setPosition(employee.getPosition());
            return employee;
        }
        throw new RuntimeException("Empleado no encontrado con el id: " + id);
    }
    
	
}
