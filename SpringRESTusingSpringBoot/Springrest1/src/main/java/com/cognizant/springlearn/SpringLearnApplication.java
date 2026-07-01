package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringLearnApplication {
private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
public static void main(String[] args) {
LOGGER.info("START");
SpringApplication.run(SpringLearnApplication.class, args);
SpringLearnApplication app = new SpringLearnApplication();
app.displayDate();
app.displayCountry();
app.displayCountries();
LOGGER.info("END");
}
public void displayDate() {
LOGGER.info("START");
ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
String dateString = "31/12/2018";
try {
Date date = format.parse(dateString);
LOGGER.debug("Date : {}", date);
} catch (Exception e) {
LOGGER.error("Error parsing date", e);
}
LOGGER.info("END");
}
public void displayCountry() {
LOGGER.info("START");
ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
Country country = context.getBean("country", Country.class);
Country anotherCountry = context.getBean("country", Country.class);
LOGGER.debug("Country : {}", country.toString());
LOGGER.info("END");
}
public void displayCountries() {
LOGGER.info("START");
ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
List<Country> countryList = (List<Country>) context.getBean("countryList");
for (Country country : countryList) {
LOGGER.debug("Country : {}", country.toString());
}
LOGGER.info("END");
}
}
