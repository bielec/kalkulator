package calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import calculator.model.Country;
import calculator.repository.CountryRepository;

@SpringBootApplication
public class Application {
	
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        CountryRepository repo = (CountryRepository) ctx.getBean("countryRepository");
        repo.save(new Country("UK", "GBP", 25f, 600f));
        repo.save(new Country("Niemcy", "EUR", 20F, 800f));
        repo.save(new Country("Polska", "PLN", 19f, 1200f));
    }
}