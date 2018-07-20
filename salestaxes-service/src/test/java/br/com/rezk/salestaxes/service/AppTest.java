package br.com.rezk.salestaxes.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.rezk.salestaxes.service.engine.CalculationEngine;
import br.com.rezk.salestaxes.service.enums.NonTaxableProductEnum;
import br.com.rezk.salestaxes.service.enums.TaxValue;
import br.com.rezk.salestaxes.service.enums.TaxableProductEnum;
import br.com.rezk.salestaxes.service.request.SalesTaxesRequest;
import br.com.rezk.salestaxes.service.response.SalesTaxesResponse;
import br.com.rezk.salestaxes.service.utils.Round;
import junit.framework.TestCase;

public class AppTest extends TestCase
{
												// Simulating lambda expression ( Java 8 )
	private CalculationEngine calculationEngine = (List<SalesTaxesRequest> request) -> {
		SalesTaxesResponse response = new SalesTaxesResponse();
		Double salesTaxes = new Double(0);
		Double total = new Double(0);
		response.setProducts(request);
		for(SalesTaxesRequest re : response.getProducts()) {
			Double taxApplied = new Double(0);
			Double originalPrice = re.getPrice();
			if(NonTaxableProductEnum.get(re.getIdProductType()) == null) {
				taxApplied += re.getPrice() * TaxValue.BASIC.getTax() * re.getQuantity();
				re.setNameProductType(TaxableProductEnum.get(re.getIdProductType()).getName());
				re.setIdProductType(null);
			}
			if(re.getImported()) {
				taxApplied += re.getPrice() * TaxValue.IMPORTED.getTax() * re.getQuantity(); 
			}
			if(re.getIdProductType() != null) {
				re.setNameProductType(NonTaxableProductEnum.get(re.getIdProductType()).getName());
				re.setIdProductType(null);
			}
			re.setPrice(Round.roundUp(re.getPrice() * re.getQuantity() + taxApplied));
			total += re.getPrice();
			salesTaxes += Round.round(re.getPrice() - originalPrice);
			
		}
		response.setSalesTaxes(Round.round(salesTaxes));
		response.setTotal(Round.round(total));
		return response;
	};
	
	@Test
    public void testCase1() {
		List<SalesTaxesRequest> request = new ArrayList<SalesTaxesRequest>();
		SalesTaxesRequest product1 = new SalesTaxesRequest(1l, false, NonTaxableProductEnum.BOOK.getId(), 12.49);
		SalesTaxesRequest product2 = new SalesTaxesRequest(1l, false, TaxableProductEnum.MUSIC.getId(), 14.99);
		SalesTaxesRequest product3 = new SalesTaxesRequest(1l, false, NonTaxableProductEnum.FOOD.getId(), 0.85);
		request.add(product1);
		request.add(product2);
		request.add(product3);
		SalesTaxesResponse response = calculationEngine.calculateSalesTaxes(request);
		
		SalesTaxesRequest product = response.getProducts().get(0);
		{
			assertEquals(product.getQuantity(), (Long) 1l);
			assertEquals(product.getImported().booleanValue(), false);
			assertEquals(product.getNameProductType(), "Book");
			assertEquals(product.getPrice(), 12.49);
		}
		
		product = response.getProducts().get(1);
		{
			assertEquals(product.getQuantity(), (Long) 1l);
			assertEquals(product.getImported().booleanValue(), false);
			assertEquals(product.getNameProductType(), "Music CD");
			assertEquals(product.getPrice(), 16.49);
		}
		
		product = response.getProducts().get(2);
		{
			assertEquals(product.getQuantity(), (Long) 1l);
			assertEquals(product.getImported().booleanValue(), false);
			assertEquals(product.getNameProductType(), "Box of chocolates");
			assertEquals(product.getPrice(), 0.85);
		}
		
    }
	
	@Test
    public void testCase2() {
		List<SalesTaxesRequest> request = new ArrayList<SalesTaxesRequest>();
		SalesTaxesRequest product1 = new SalesTaxesRequest(1l, true, NonTaxableProductEnum.FOOD.getId(), 10.00);
		SalesTaxesRequest product2 = new SalesTaxesRequest(1l, true, TaxableProductEnum.PERFUME.getId(), 47.50);
		request.add(product1);
		request.add(product2);
		SalesTaxesResponse response = calculationEngine.calculateSalesTaxes(request);
		
		SalesTaxesRequest product = response.getProducts().get(0);
		{
			assertEquals(product.getQuantity(), (Long) 1l);
			assertEquals(product.getImported().booleanValue(), true);
			assertEquals(product.getNameProductType(), "Box of chocolates");
			assertEquals(product.getPrice(), 10.50);
		}
		
		product = response.getProducts().get(1);
		{
			assertEquals(product.getQuantity(), (Long) 1l);
			assertEquals(product.getImported().booleanValue(), true);
			assertEquals(product.getNameProductType(), "Bottle of Perfume");
			assertEquals(product.getPrice(), 54.65);
		}
    }
	
	@Test
    public void testCase3() {
		List<SalesTaxesRequest> request = new ArrayList<SalesTaxesRequest>();
		SalesTaxesRequest product1 = new SalesTaxesRequest(1l, true, TaxableProductEnum.PERFUME.getId(), 27.99);
		SalesTaxesRequest product2 = new SalesTaxesRequest(1l, false, TaxableProductEnum.PERFUME.getId(), 18.99);
		SalesTaxesRequest product3 = new SalesTaxesRequest(1l, false, NonTaxableProductEnum.MEDICAL.getId(), 9.75);
		SalesTaxesRequest product4 = new SalesTaxesRequest(1l, true, NonTaxableProductEnum.FOOD.getId(), 11.25);
		request.add(product1);
		request.add(product2);
		request.add(product3);
		request.add(product4);
		SalesTaxesResponse response = calculationEngine.calculateSalesTaxes(request);
		
		SalesTaxesRequest product = response.getProducts().get(0);
		{
			assertEquals(product.getQuantity(), (Long) 1l);
			assertEquals(product.getImported().booleanValue(), true);
			assertEquals(product.getNameProductType(), "Bottle of Perfume");
			assertEquals(product.getPrice(), 32.19);
		}
		
		product = response.getProducts().get(1);
		{
			assertEquals(product.getQuantity(), (Long) 1l);
			assertEquals(product.getImported().booleanValue(), false);
			assertEquals(product.getNameProductType(), "Bottle of Perfume");
			assertEquals(product.getPrice(), 20.89);
		}
		
		product = response.getProducts().get(2);
		{
			assertEquals(product.getQuantity(), (Long) 1l);
			assertEquals(product.getImported().booleanValue(), false);
			assertEquals(product.getNameProductType(), "Medical");
			assertEquals(product.getPrice(), 9.75);
		}
		
		product = response.getProducts().get(3);
		{
			assertEquals(product.getQuantity(), (Long) 1l);
			assertEquals(product.getImported().booleanValue(), true);
			assertEquals(product.getNameProductType(), "Box of chocolates");
			assertEquals(product.getPrice(), 11.85);
		}
    }
}
