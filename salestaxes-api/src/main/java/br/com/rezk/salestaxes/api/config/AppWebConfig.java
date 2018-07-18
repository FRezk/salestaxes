package br.com.rezk.salestaxes.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.com.rezk.salestaxes.api.resource.SalesTaxesResource;

@EnableWebMvc
@ComponentScan(basePackageClasses={SalesTaxesResource.class})
public class AppWebConfig {
}
