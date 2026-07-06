package com.cognizant.ormlearn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import java.util.Date;
@SpringBootApplication
public class OrmLearnApplication {
private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
private static EmployeeService employeeService;
private static DepartmentService departmentService;
private static SkillService skillService;
public static void main(String[] args) {
ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
LOGGER.info("Inside main");
employeeService = context.getBean(EmployeeService.class);
departmentService = context.getBean(DepartmentService.class);
skillService = context.getBean(SkillService.class);
testGetEmployee();
testAddEmployee();
testUpdateEmployee();
testGetDepartment();
testAddSkillToEmployee();
}
private static void testGetEmployee() {
LOGGER.info("Start");
Employee employee = employeeService.get(1);
LOGGER.debug("Employee:{}", employee);
LOGGER.debug("Department:{}", employee.getDepartment());
LOGGER.info("End");
}
private static void testAddEmployee() {
LOGGER.info("Start");
Employee employee = new Employee();
employee.setName("New Employee");
employee.setSalary(50000);
employee.setPermanent(true);
employee.setDateOfBirth(new Date());
Department department = departmentService.get(1);
employee.setDepartment(department);
employeeService.save(employee);
LOGGER.debug("Employee after save:{}", employee);
LOGGER.info("End");
}
private static void testUpdateEmployee() {
LOGGER.info("Start");
Employee employee = employeeService.get(1);
Department department = departmentService.get(2);
employee.setDepartment(department);
employeeService.save(employee);
LOGGER.debug("Employee updated");
LOGGER.info("End");
}
private static void testGetDepartment() {
LOGGER.info("Start");
Department department = departmentService.get(1);
LOGGER.debug("Department:{}", department);
LOGGER.debug("Employees:{}", department.getEmployeeList());
LOGGER.info("End");
}
private static void testAddSkillToEmployee() {
LOGGER.info("Start");
Employee employee = employeeService.get(1);
Skill skill = skillService.get(1);
employee.getSkillList().add(skill);
employeeService.save(employee);
LOGGER.debug("Skill added to employee");
LOGGER.info("End");
}
}
