package br.com.rezk.salestaxes.service.request;

public class SalesTaxesRequest {
	
	private Long quantity;
	private Boolean imported;
	private Long idProductType;
	private Double price;
	
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
