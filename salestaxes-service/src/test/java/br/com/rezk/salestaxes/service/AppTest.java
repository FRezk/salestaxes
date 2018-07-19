package br.com.rezk.salestaxes.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.rezk.salestaxes.service.engine.CalculationEngine;
import br.com.rezk.salestaxes.service.enums.NonTaxableProductEnum;
import br.com.rezk.salestaxes.service.enums.TaxableProductEnum;
import br.com.rezk.salestaxes.service.request.SalesTaxesRequest;
import br.com.rezk.salestaxes.service.response.SalesTaxesResponse;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest extends TestCase
{
	@Autowired
	private CalculationEngine calculationEngine;
	
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
		SalesTaxesResponse response = calculationEngine.calculateSalesTaxes(request);
    }
}
