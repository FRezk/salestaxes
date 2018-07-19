package br.com.rezk.salestaxes.service.utils;

public final class Round {
	
	private static final Long DECIMAL_PLACES = 2l;
	private static final Long CUSTOM_DECIMAL = 5l;
	
	public static final Double round(Double value) {
		long factor = (long) Math.pow(10, DECIMAL_PLACES);
	    value = value * factor;
	    long dividend = Math.round(value);
	    return (double) dividend / factor;
	};
	
	public static final Double roundUp(Double value) {
		StringBuilder sb = new StringBuilder();
		sb.append(Math.floor(value % 1 * 100));
		if(sb.length() > 2) {
			int secondDecimalPlace = Character.getNumericValue(sb.charAt(1));
			if(secondDecimalPlace > 0 && secondDecimalPlace < 5) {
				StringBuilder auxSb = new StringBuilder("0.0");
				auxSb.append(sb.charAt(1));
				value -= Double.parseDouble(auxSb.toString());
				auxSb = new StringBuilder("0.0");
				auxSb.append(CUSTOM_DECIMAL);
				value += Double.parseDouble(auxSb.toString());
			}
		}
		return round(value);
	};

}
