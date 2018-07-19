package br.com.rezk.salestaxes.api.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;

import com.google.gson.Gson;

import br.com.rezk.salestaxes.service.SalesTaxesService;
import br.com.rezk.salestaxes.service.engine.CalculationEngine;
import br.com.rezk.salestaxes.service.enums.NonTaxableProductEnum;
import br.com.rezk.salestaxes.service.enums.TaxValue;
import br.com.rezk.salestaxes.service.provider.SalesTaxesServiceProvider;
import br.com.rezk.salestaxes.service.request.SalesTaxesRequest;
import br.com.rezk.salestaxes.service.response.SalesTaxesResponse;
import br.com.rezk.salestaxes.service.utils.Round;

@Configuration
public class BeansConfig {
	
	@Bean
	public SalesTaxesService salesTaxesService(){
		return new SalesTaxesServiceProvider();
	}
	
	@Bean
	public Gson gson() {
		return new Gson();
	}
	
	@Bean
	@ApplicationScope
	public CalculationEngine calculationEngine() {
		CalculationEngine calculationEngine = (List<SalesTaxesRequest> request) -> {
			SalesTaxesResponse response = new SalesTaxesResponse();
			Double salesTaxes = new Double(0);
			Double total = new Double(0);
			response.setProducts(request);
			for(SalesTaxesRequest re : response.getProducts()) {
				Double tax = 0.00;
				if(NonTaxableProductEnum.get(re.getIdProductType()) == null) {
					tax += Round.round(re.getPrice() * TaxValue.BASIC.getTax() * re.getQuantity());
				}
				if(re.getImported()) {
					tax += Round.round(re.getPrice() * TaxValue.IMPORTED.getTax() * re.getQuantity()); 
				}
				re.setPrice(Round.round( re.getPrice() * re.getQuantity() + tax));
				total += Round.round(re.getPrice());
				salesTaxes += tax;
			}
			response.setSalesTaxes(salesTaxes);
			response.setTotal(total);
			return response;
		};
		return calculationEngine;
	}

}