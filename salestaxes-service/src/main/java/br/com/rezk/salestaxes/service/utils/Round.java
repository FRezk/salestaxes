package br.com.rezk.salestaxes.service.utils;

public final class Round {
	
	private static final Long DECIMAL_PLACES = 2l;
	
	public static final Double round(Double value) {
		long factor = (long) Math.pow(10, DECIMAL_PLACES);
	    value = value * factor;
	    long dividend = Math.round(value);
	    return (double) dividend / factor;
	};

}
