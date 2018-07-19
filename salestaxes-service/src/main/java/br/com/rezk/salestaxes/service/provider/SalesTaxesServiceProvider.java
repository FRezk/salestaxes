package br.com.rezk.salestaxes.service.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.rezk.salestaxes.service.SalesTaxesService;
import br.com.rezk.salestaxes.service.engine.CalculationEngine;
import br.com.rezk.salestaxes.service.request.SalesTaxesRequest;
import br.com.rezk.salestaxes.service.response.SalesTaxesResponse;

public class SalesTaxesServiceProvider implements SalesTaxesService {
	
	@Autowired
	private CalculationEngine calculationEngine;

	public SalesTaxesResponse calculateSalesTaxes(List<SalesTaxesRequest> request) {
		return calculationEngine.calculateSalesTaxes(request);
	}

}
