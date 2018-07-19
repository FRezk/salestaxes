package br.com.rezk.salestaxes.service.enums;

public enum TaxableProductEnum {
	MUSIC("Music CD", 4l),
	PERFUME("Bottle of Perfume", 5l);
	
	private String name;
	private Long id;
	
	TaxableProductEnum(String name, Long id) {
		this.name = name;
		this.id = id;
	}
	
	public static TaxableProductEnum get(Long id) {
		for(TaxableProductEnum retorno : TaxableProductEnum.values()) {
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
