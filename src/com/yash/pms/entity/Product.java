package com.yash.pms.entity;

import java.time.LocalDate;
import java.util.Date;

public class Product {
	
	private int productId;
	private String productName;
	private String storageLocation;
	private int qty;
	private int price;
	private LocalDate manifactureDate;
	private short isProductDeleted;
	
	public Product()
	{
		
	}
	

	public Product(int productId, String productName, String storageLocation, int qty, int price,
			 LocalDate manifactureDate,short isProductDeleted) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.storageLocation = storageLocation;
		this.qty = qty;
		this.price = price;
		this.manifactureDate = manifactureDate;
		this.isProductDeleted = isProductDeleted;
	}


	public Product(int productId2, String productName2, String productLocation, int productQty, int productPrice,
			Date parse, int i) {
		
	}


	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getStorageLocation() {
		return storageLocation;
	}

	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDate getManifactureDate() {
		return manifactureDate;
	}

	public void setManifactureDate(LocalDate manifactureDate) {
		this.manifactureDate = manifactureDate;
	}

	public short getIsProductDeleted() {
		return isProductDeleted;
	}

	public void setIsProductDeleted(short isProductDeleted) {
		this.isProductDeleted = isProductDeleted;
	}
	
	

}
