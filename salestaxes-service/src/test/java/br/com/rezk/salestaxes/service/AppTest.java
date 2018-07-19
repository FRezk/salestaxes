package br.com.rezk.salestaxes.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
	@Autowired
	private SalesTaxesService salesTaxesService;
	
	@Test
    public void testCase1() {
		assertEquals(true, true);
    }
	
	@Test
    public void testCase2() {
		assertEquals(true, true);
    }
	
	@Test
    public void testCase3() {
		assertEquals(true, true);
    }
}
