package br.com.rezk.salestaxes.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rezk.salestaxes.service.SalesTaxesService;

@RestController
public class SalesTaxesResource {
	
	@Autowired
	private SalesTaxesService salesTaxesService;
	
	@RequestMapping(method=RequestMethod.GET, value="/test")
	public String calculateSalesTaxes() {
		return salesTaxesService.calculateSalesTaxes();
	}

}
