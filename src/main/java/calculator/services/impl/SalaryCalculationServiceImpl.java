package calculator.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import calculator.services.SalaryCalculationService;
import calculator.services.util.SalaryCalculationResult;

@Service
public class SalaryCalculationServiceImpl implements SalaryCalculationService{

	@Autowired
	CurrencyExchangeServiceImpl exchangeService;

	@Value("${application.operatingCurrency}")
	String OPERATING_CURRENCY;
	
	@Value("${application.daysInMonth}")
	int NUMBER_OF_DAYS;
	
	public SalaryCalculationResult calculateSalary(float dailySalary, String currency, float taxRate, float costOfIncome) {
		// use exchange rates if necessary
    	if(!currency.equals(OPERATING_CURRENCY)) {
	    	try {
	    		float exchangeRate = exchangeService.getExchangeRateFor(currency);
	    		dailySalary *= exchangeRate;
	    		costOfIncome *= exchangeRate;
	    	} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	float salary = NUMBER_OF_DAYS * dailySalary;
    	float taxationBase = NUMBER_OF_DAYS * dailySalary - costOfIncome;
    	float tax = 0;
    	if (taxationBase > 0) {
    		tax = taxationBase * taxRate * 0.01f;
    	}
		
    	salary -= tax;
    	
		return new SalaryCalculationResult(salary, tax, taxRate, costOfIncome);
	}
}
