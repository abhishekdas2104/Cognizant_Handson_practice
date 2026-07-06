package com.cognizant.ormlearn.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import java.util.List;
import java.util.Optional;
@Service
public class CountryService {
@Autowired
private CountryRepository countryRepository;
@Transactional
public List<Country> getAllCountries() {
return countryRepository.findAll();
}
@Transactional
public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
Optional<Country> result = countryRepository.findById(countryCode);
if (!result.isPresent()) {
throw new CountryNotFoundException("Country not found");
}
return result.get();
}
@Transactional
public void addCountry(Country country) {
countryRepository.save(country);
}
@Transactional
public void updateCountry(String code, String name) throws CountryNotFoundException {
Country country = findCountryByCode(code);
country.setName(name);
countryRepository.save(country);
}
@Transactional
public void deleteCountry(String code) {
countryRepository.deleteById(code);
}
@Transactional
public List<Country> findByNameContaining(String name) {
return countryRepository.findByNameContaining(name);
}
@Transactional
public List<Country> findByNameContainingOrderByNameAsc(String name) {
return countryRepository.findByNameContainingOrderByNameAsc(name);
}
@Transactional
public List<Country> findByNameStartingWith(String prefix) {
return countryRepository.findByNameStartingWith(prefix);
}
}
