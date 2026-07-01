package com.employee;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

public class Employee {
@NotNull(message = "Employee id is required")
private Integer id;
@NotBlank(message = "Employee name is required")
@Size(min = 1, max = 30, message = "Employee name must be between 1 and 30 characters")
private String name;
private String email;
@NotNull(message = "Salary is required")
@Min(value = 0, message = "Salary must be zero or above")
private Double salary;
@NotNull(message = "Permanent status is required")
private Boolean permanent;
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
private Date dateOfBirth;
private Department department;
private List<Skill> skills;
public Employee() {
}
public Integer getId() {
return id;
}
public void setId(Integer id) {
this.id = id;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public String getEmail() {
return email;
}
public void setEmail(String email) {
this.email = email;
}
public Double getSalary() {
return salary;
}
public void setSalary(Double salary) {
this.salary = salary;
}
public Boolean getPermanent() {
return permanent;
}
public void setPermanent(Boolean permanent) {
this.permanent = permanent;
}
public Date getDateOfBirth() {
return dateOfBirth;
}
public void setDateOfBirth(Date dateOfBirth) {
this.dateOfBirth = dateOfBirth;
}
public Department getDepartment() {
return department;
}
public void setDepartment(Department department) {
this.department = department;
}
public List<Skill> getSkills() {
return skills;
}
public void setSkills(List<Skill> skills) {
this.skills = skills;
}
}
