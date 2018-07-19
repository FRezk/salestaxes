package br.com.rezk.salestaxes.service;

import java.util.List;

import br.com.rezk.salestaxes.service.request.SalesTaxesRequest;
import br.com.rezk.salestaxes.service.response.SalesTaxesResponse;

public interface SalesTaxesService {
	
	public SalesTaxesResponse calculateSalesTaxes(List<SalesTaxesRequest> request);

}
