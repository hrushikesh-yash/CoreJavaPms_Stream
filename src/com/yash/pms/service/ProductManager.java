package com.yash.pms.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import com.yash.pms.entity.Product;

public interface ProductManager {
	
	public boolean addProduct(Product products);

	public void getAllProducts();

	public int getProductIdByName(String productName);

	public boolean updateProductName(int productId, String item);

	public boolean updateProductsLocation(int productId, String item);

	public boolean updateProductQty(int productId, int item);

	public boolean updateProductPrice(int productId, int item);
	
	public boolean updateProductManifactreDate(int productId, LocalDate item);

	public boolean DeleteProduct(String productName);
	
	//public boolean isProductListEmpty(LinkedList<Product> productList);
	
	//public boolean isProductAlreadyExists(LinkedList<Product> productList, String productName);

	public boolean isProductListEmpty(Map<Integer, Product> productList);
}
