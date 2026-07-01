package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CountryService {
private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);
public Country getCountryIndia() {
LOGGER.info("START");
ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
Country country = context.getBean("in", Country.class);
LOGGER.info("END");
return country;
}
public List<Country> getAllCountries() {
LOGGER.info("START");
ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
List<Country> countryList = (List<Country>) context.getBean("countryList");
LOGGER.info("END");
return countryList;
}
public Country getCountry(String code) throws CountryNotFoundException {
LOGGER.info("START");
ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
List<Country> countryList = (List<Country>) context.getBean("countryList");
Country country = countryList.stream()
.filter(c -> c.getCode().equalsIgnoreCase(code))
.findFirst()
.orElseThrow(() -> new CountryNotFoundException());
LOGGER.info("END");
return country;
}
}
