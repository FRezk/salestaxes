package br.com.rezk.salestaxes.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.rezk.salestaxes.service.SalesTaxesService;
import br.com.rezk.salestaxes.service.provider.SalesTaxesServiceProvider;

@Configuration
public class BeansConfig {
	
	@Bean
	public SalesTaxesService homeService(){
		return new SalesTaxesServiceProvider();
	}

}
