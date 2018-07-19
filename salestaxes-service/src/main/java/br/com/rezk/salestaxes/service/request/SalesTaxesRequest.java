package br.com.rezk.salestaxes.service.request;

public class SalesTaxesRequest {
	
	private Long quantity;
	private Boolean imported;
	private Long idProductType;
	private String nameProductType;
	private Double price;
	
	public SalesTaxesRequest() {}
	
	public SalesTaxesRequest(Long quantity, Boolean imported, Long idProductType, Double price) {
		this.quantity = quantity;
		this.imported = imported;
		this.idProductType = idProductType;
		this.price = price;
	}
	
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Boolean getImported() {
		return imported;
	}
	public void setImported(Boolean imported) {
		this.imported = imported;
	}
	public String getNameProductType() {
		return nameProductType;
	}

	public void setNameProductType(String nameProductType) {
		this.nameProductType = nameProductType;
	}

	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getIdProductType() {
		return idProductType;
	}
	public void setIdProductType(Long idProductType) {
		this.idProductType = idProductType;
	}

}
