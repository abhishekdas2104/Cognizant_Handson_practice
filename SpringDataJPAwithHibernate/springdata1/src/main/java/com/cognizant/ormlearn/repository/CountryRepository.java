package com.cognizant.ormlearn.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.ormlearn.model.Country;
import java.util.List;
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
List<Country> findByNameContaining(String name);
List<Country> findByNameContainingOrderByNameAsc(String name);
List<Country> findByNameStartingWith(String prefix);
}
