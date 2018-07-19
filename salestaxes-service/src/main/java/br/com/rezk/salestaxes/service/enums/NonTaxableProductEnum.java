package br.com.rezk.salestaxes.service.enums;

public enum NonTaxableProductEnum {
	BOOK(1l),
	FOOD(2l),
	MEDICAL(3l);
	
	private Long id;
	
	NonTaxableProductEnum(Long id) {
		this.id = id;
	}
	
	public static NonTaxableProductEnum get(Long id) {
		for(NonTaxableProductEnum retorno : NonTaxableProductEnum.values()) {
			if(retorno.id == id) {
				return retorno;
			}
		}
		return null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
