package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CountryController {
private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
@Autowired
private CountryService countryService;
public CountryController() {
LOGGER.debug("CountryController initialized");
}
@RequestMapping("/country")
public Country getCountryIndia() {
LOGGER.info("START");
Country country = countryService.getCountryIndia();
LOGGER.info("END");
return country;
}
@GetMapping("/countries")
public List<Country> getAllCountries() {
LOGGER.info("START");
List<Country> countries = countryService.getAllCountries();
LOGGER.info("END");
return countries;
}
@GetMapping("/countries/{code}")
public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
LOGGER.info("START");
Country country = countryService.getCountry(code);
LOGGER.info("END");
return country;
}
}
