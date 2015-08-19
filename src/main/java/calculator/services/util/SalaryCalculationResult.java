package calculator.services.util;

public class SalaryCalculationResult {

	private Float salary;
	private Float paidTax;
	private Float taxRate;
	private Float costOfIncome;
	
	public SalaryCalculationResult() {};
	
	public SalaryCalculationResult(Float salary, Float paidTax, Float taxRate, Float costOfIncome) {
		super();
		this.salary = salary;
		this.paidTax = paidTax;
		this.taxRate = taxRate;
		this.costOfIncome = costOfIncome;
	}
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	public Float getPaidTax() {
		return paidTax;
	}
	public void setPaidTax(Float paidTax) {
		this.paidTax = paidTax;
	}
	public Float getTaxRate() {
		return taxRate;
	}
	public void setTaxRate(Float taxRate) {
		this.taxRate = taxRate;
	}

	public Float getCostOfIncome() {
		return costOfIncome;
	}
	public void setCostOfIncome(Float costOfIncome) {
		this.costOfIncome = costOfIncome;
	}
}
