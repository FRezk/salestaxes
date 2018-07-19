package br.com.rezk.salestaxes.service.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import br.com.rezk.salestaxes.service.SalesTaxesService;
import br.com.rezk.salestaxes.service.engine.CalculationEngine;
import br.com.rezk.salestaxes.service.request.SalesTaxesRequest;

public class SalesTaxesServiceProvider implements SalesTaxesService {
	
	@Autowired
	private CalculationEngine calculationEngine;
	
	@Autowired
	private Gson gson;

	public String calculateSalesTaxes(List<SalesTaxesRequest> request) {
		return gson.toJson(calculationEngine.calculateSalesTaxes(request));
	}

}
