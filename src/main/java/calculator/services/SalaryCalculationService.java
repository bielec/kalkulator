package calculator.services;

import calculator.services.util.SalaryCalculationResult;

public interface SalaryCalculationService {

	public SalaryCalculationResult calculateSalary(float dailySalary, String currency, float taxRate, float costOfIncome);
}
