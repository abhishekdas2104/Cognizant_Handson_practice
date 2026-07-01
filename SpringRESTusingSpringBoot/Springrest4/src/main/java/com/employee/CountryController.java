package com.employee;

import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/countries")
public class CountryController {
@PostMapping
public Country addCountry(@RequestBody @Valid Country country) {
return country;
}
}
