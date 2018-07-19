package br.com.rezk.salestaxes.service.engine;

import java.util.List;

import br.com.rezk.salestaxes.service.request.SalesTaxesRequest;
import br.com.rezk.salestaxes.service.response.SalesTaxesResponse;

public interface CalculationEngine {
	public SalesTaxesResponse calculateSalesTaxes(List<SalesTaxesRequest> produtos);
}