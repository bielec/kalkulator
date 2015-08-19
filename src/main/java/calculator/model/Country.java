package calculator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Country {
	@Id
	private String name;
	@Column
	private String currencyCode;
	@Column
	private Float tax;
	@Column
	private Float costOfIncome;
	
	public Country() {};
	
	public Country(String name, String currencyCode, Float tax,
			Float costOfIncome) {
		super();
		this.name = name;
		this.currencyCode = currencyCode;
		this.tax = tax;
		this.costOfIncome = costOfIncome;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public Float getTax() {
		return tax;
	}
	public void setTax(Float tax) {
		this.tax = tax;
	}
	public Float getCostOfIncome() {
		return costOfIncome;
	}
	public void setCostOfIncome(Float costOfIncome) {
		this.costOfIncome = costOfIncome;
	}	
}
