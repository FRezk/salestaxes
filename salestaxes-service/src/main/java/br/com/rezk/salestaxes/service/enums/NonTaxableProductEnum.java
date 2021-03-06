package br.com.rezk.salestaxes.service.enums;

public enum NonTaxableProductEnum {
	BOOK("Book", 1l),
	FOOD("Box of chocolates", 2l),
	MEDICAL("Medical", 3l);
	
	private String name;
	private Long id;
	
	NonTaxableProductEnum(String name, Long id) {
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
