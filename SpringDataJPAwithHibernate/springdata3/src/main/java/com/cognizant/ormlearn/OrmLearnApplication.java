package com.cognizant.ormlearn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.EmployeeService;
import java.util.List;
@SpringBootApplication
public class OrmLearnApplication {
private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
private static EmployeeService employeeService;
public static void main(String[] args) {
ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
LOGGER.info("Inside main");
employeeService = context.getBean(EmployeeService.class);
testGetAllPermanentEmployees();
testGetAverageSalary();
testGetAllEmployeesNative();
}
private static void testGetAllPermanentEmployees() {
LOGGER.info("Start");
List<Employee> employees = employeeService.getAllPermanentEmployees();
LOGGER.debug("Permanent Employees:{}", employees);
employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
LOGGER.info("End");
}
private static void testGetAverageSalary() {
LOGGER.info("Start");
double avgSalary = employeeService.getAverageSalary(1);
LOGGER.debug("Average Salary for Department 1: {}", avgSalary);
LOGGER.info("End");
}
private static void testGetAllEmployeesNative() {
LOGGER.info("Start");
List<Employee> employees = employeeService.getAllEmployeesNative();
LOGGER.debug("All Employees (Native Query):{}", employees);
LOGGER.info("End");
}
}
