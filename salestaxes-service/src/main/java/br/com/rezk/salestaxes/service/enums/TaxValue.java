package br.com.rezk.salestaxes.service.enums;

public enum TaxValue {
	BASIC(0.1),
	IMPORTED(0.05);
	
	private Double tax;
	
	TaxValue(Double tax) {
		this.tax = tax;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

}
