package br.com.rezk.salestaxes.service.response;

import java.io.Serializable;
import java.util.List;

import br.com.rezk.salestaxes.service.request.SalesTaxesRequest;

public class SalesTaxesResponse implements Serializable {
	private static final long serialVersionUID = -9195176978681920152L;
	
	private List<SalesTaxesRequest> products;
	private Double salesTaxes;
	private Double total;
	
	public SalesTaxesResponse() {}
	
	public List<SalesTaxesRequest> getProducts() {
		return products;
	}

	public void setProducts(List<SalesTaxesRequest> products) {
		this.products = products;
	}

	public Double getSalesTaxes() {
		return salesTaxes;
	}
	public void setSalesTaxes(Double salesTaxes) {
		this.salesTaxes = salesTaxes;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
	
	

}
