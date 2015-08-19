package calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import calculator.model.Country;

public interface CountryRepository  extends JpaRepository<Country, Integer> {

	@Query("select c from Country c where c.name = ?1")
	public Country findByName(String name);
}
