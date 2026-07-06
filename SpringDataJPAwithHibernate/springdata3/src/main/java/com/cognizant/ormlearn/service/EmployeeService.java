package com.cognizant.ormlearn.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import java.util.List;
@Service
public class EmployeeService {
private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
@Autowired
private EmployeeRepository employeeRepository;
@Transactional
public Employee get(int id) {
LOGGER.info("Start");
return employeeRepository.findById(id).get();
}
@Transactional
public void save(Employee employee) {
LOGGER.info("Start");
employeeRepository.save(employee);
LOGGER.info("End");
}
@Transactional
public List<Employee> getAllPermanentEmployees() {
LOGGER.info("Start");
return employeeRepository.getAllPermanentEmployees();
}
@Transactional
public double getAverageSalary(int departmentId) {
LOGGER.info("Start");
return employeeRepository.getAverageSalary(departmentId);
}
@Transactional
public List<Employee> getAllEmployeesNative() {
LOGGER.info("Start");
return employeeRepository.getAllEmployeesNative();
}
}
