package com.yash.pms.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import com.yash.pms.entity.Product;
import com.yash.pms.utils.utilities;

public class ProductManagerImpl extends utilities implements ProductManager {

	@Override
	public boolean addProduct(Product products) {

		if (isProductListEmpty(productList)) {
			productList.add(products);
			return true;
		} else if (!isProductAlreadyExists(productList, products.getProductName())) {
			productList.add(products);
			return true;
		}

		return false;
	}

	@Override
	public void getAllProducts() {
		System.out.println(
				"Product Id | Product Name | product Location |Product Quantity | Product Price | Product Is Deleted ");
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getIsProductDeleted() == 0) {
				System.out.println(productList.get(i).getProductId() + " | " + productList.get(i).getProductName()
						+ " | " + productList.get(i).getStorageLocation() + " | " + productList.get(i).getQty() + " | "
						+ productList.get(i).getPrice()+" | "+productList.get(i).getManifactureDate() + " | " + productList.get(i).getIsProductDeleted());
			}

		}
		System.out.println();

	}

	@Override
	public int getProductByName(String productName) {

		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getProductName().equalsIgnoreCase(productName)) {
				 System.out.println(" Checking :: "+productList.get(i).getProductName()+" With: "+productName);
				return productList.get(i).getProductId();
			}
		}

		return 0;
	}

	@Override
	public boolean DeleteProduct(int productId) {
		if (!isProductListEmpty(productList)) {
			for (int i = 0; i < productList.size(); i++) {
				if (productList.get(i).getProductId() == productId) {
					System.out.println("Deleting Product name : "+productList.get(i).getProductName());
					System.out.println("Deleting Product Name : "+productList.get(i).getProductId());
					productList.remove(productList.get(i));
					return true;
				}
			}
		}
		return false;

	}

	@Override
	public boolean updateProductsName(int productId, String item) {
		if (!isProductListEmpty(productList)) {
			for (int i = 0; i < productList.size(); i++) {
				if (productList.get(i).getProductId() == productId) {
					productList.get(i).setProductName(item);
					return true;
				}
			}
		}

		return false;

	}

	@Override
	public boolean updateProductsLocation(int productId, String item) {
		if (!isProductListEmpty(productList)) {
			for (int i = 0; i < productList.size(); i++) {
				if (productList.get(i).getProductId() == productId) {
					productList.get(i).setStorageLocation(item);
				}
			}
		}
		return false;

	}

	@Override
	public boolean updateProductQty(int productId, int item) {
		if (!isProductListEmpty(productList)) {
			for (int i = 0; i < productList.size(); i++) {
				if (productList.get(i).getProductId() == productId) {
					productList.get(i).setQty(item);
					return true;
				}
			}
		}
		return false;

	}

	@Override
	public boolean updateProductPrice(int productId, int item) {
		if (!isProductListEmpty(productList)) {
			for (int i = 0; i < productList.size(); i++) {
				if (productList.get(i).getProductId() == productId) {
					productList.get(i).setPrice(item);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean updateProductManifactreDate(int productId, LocalDate item) {
		if (!isProductListEmpty(productList)) {
			for (int i = 0; i < productList.size(); i++) {
				if (productList.get(i).getProductId() == productId) {
					productList.get(i).setManifactureDate(item);
					return true;
				}
			}
		}
		return false;

	}

	@Override
	public boolean isProductListEmpty(LinkedList<Product> productList) {

		if (productList.isEmpty()) {
			return true;
		}
		return false;

	}

	public boolean isProductAlreadyExists(LinkedList<Product> productList, String productName) {
		if (!isProductListEmpty(productList)) {
			for (int i = 0; i < productList.size(); i++) {
				if (productList.get(i).getProductName().contains(productName)) {
					return true;
				}
			}
		}

		return false;
	}

}
