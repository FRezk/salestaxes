package br.com.rezk.salestaxes.service;

import java.util.List;

import br.com.rezk.salestaxes.service.request.SalesTaxesRequest;

public interface SalesTaxesService {
	
	public String calculateSalesTaxes(List<SalesTaxesRequest> request);

}
