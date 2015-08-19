package calculator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import calculator.model.Country;
import calculator.repository.CountryRepository;
import calculator.services.impl.SalaryCalculationServiceImpl;
import calculator.services.util.SalaryCalculationInput;
import calculator.services.util.SalaryCalculationResult;

@RestController
@RequestMapping("/service")
public class HelloController {

	@Autowired
	private SalaryCalculationServiceImpl salaryCalculationServiceImpl;
	
	@Autowired
	private CountryRepository repo;

	@RequestMapping(value = "/countries", method = RequestMethod.GET)
	public List findItems() {
		return repo.findAll();
	}

	@RequestMapping(value = "/calculate", method = RequestMethod.POST)
	public SalaryCalculationResult calculateSalary(@RequestBody SalaryCalculationInput input) {
		
		Country country = repo.findByName(input.getCountry());
		
		SalaryCalculationResult result = salaryCalculationServiceImpl.calculateSalary(input.getDailyRate(),
				country.getCurrencyCode(), country.getTax(), country.getCostOfIncome());

		return result;
	}
}