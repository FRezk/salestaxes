package br.com.rezk.salestaxes.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.rezk.salestaxes.service.SalesTaxesService;
import br.com.rezk.salestaxes.service.request.SalesTaxesRequest;

@RestController
public class SalesTaxesResource {
	
	@Autowired
	private SalesTaxesService salesTaxesService;
	
	@Autowired
	private Gson gson;
	
	@RequestMapping(method=RequestMethod.POST, headers="Content-Type=application/json", produces=MediaType.APPLICATION_JSON_VALUE, value="/calculate")
	public String calculateSalesTaxes(@RequestBody List<SalesTaxesRequest> request) {
		return gson.toJson(salesTaxesService.calculateSalesTaxes(request));
	}

}
