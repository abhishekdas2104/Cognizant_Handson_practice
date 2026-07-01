package com.employee;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Department {
@NotNull(message = "Department id is required")
private Integer id;
@NotBlank(message = "Department name is required")
@Size(min = 1, max = 30, message = "Department name must be between 1 and 30 characters")
private String name;
public Department() {
}
public Department(Integer id, String name) {
this.id = id;
this.name = name;
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
}
