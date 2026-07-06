package com.cognizant.ormlearn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import java.util.List;
@SpringBootApplication
public class OrmLearnApplication {
private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
private static CountryService countryService;
public static void main(String[] args) {
ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
LOGGER.info("Inside main");
countryService = context.getBean(CountryService.class);
testGetAllCountries();
try {
testFindCountryByCode();
testAddCountry();
testUpdateCountry();
testDeleteCountry();
testQueryMethods();
} catch (Exception e) {
LOGGER.error("Error: " + e.getMessage());
}
}
private static void testGetAllCountries() {
LOGGER.info("Start");
List<Country> countries = countryService.getAllCountries();
LOGGER.debug("countries={}", countries);
LOGGER.info("End");
}
private static void testFindCountryByCode() throws Exception {
LOGGER.info("Start");
Country country = countryService.findCountryByCode("IN");
LOGGER.debug("Country:{}", country);
LOGGER.info("End");
}
private static void testAddCountry() {
LOGGER.info("Start");
Country country = new Country();
country.setCode("TS");
country.setName("Test Country");
countryService.addCountry(country);
LOGGER.debug("Added Country");
LOGGER.info("End");
}
private static void testUpdateCountry() throws Exception {
LOGGER.info("Start");
countryService.updateCountry("TS", "Updated Test Country");
LOGGER.debug("Updated Country");
LOGGER.info("End");
}
private static void testDeleteCountry() {
LOGGER.info("Start");
countryService.deleteCountry("TS");
LOGGER.debug("Deleted Country");
LOGGER.info("End");
}
private static void testQueryMethods() {
LOGGER.info("Start");
List<Country> countries = countryService.findByNameContaining("ou");
LOGGER.debug("Countries containing 'ou': {}", countries);
List<Country> sortedCountries = countryService.findByNameContainingOrderByNameAsc("ou");
LOGGER.debug("Sorted countries containing 'ou': {}", sortedCountries);
List<Country> startsWithZ = countryService.findByNameStartingWith("Z");
LOGGER.debug("Countries starting with 'Z': {}", startsWithZ);
LOGGER.info("End");
}
}
