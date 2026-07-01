package com.employee;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Country {
@NotNull(message = "Country code is required")
@Size(min = 2, max = 2, message = "Country code should be 2 characters")
private String code;
private String name;
public Country() {
}
public Country(String code, String name) {
this.code = code;
this.name = name;
}
public String getCode() {
return code;
}
public void setCode(String code) {
this.code = code;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
}
