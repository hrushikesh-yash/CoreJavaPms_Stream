package com.yash.pms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.yash.pms.entity.Product;
import com.yash.pms.utils.utilities;

public class ProductManagerImpl extends utilities implements ProductManager {

	@Override
	public boolean addProduct(Product products) {

		if (isProductListEmpty(productMap)) {
			productMap.put(products.getProductId(), products);
			return true;
		} else if (!isProductAlreadyExists(productMap, products.getProductName())) {
			productMap.put(products.getProductId(), products);
			return true;
		}

		return false;
	}

	@Override
	public boolean updateProductName(int productId, String item) {
		if (!isProductListEmpty(productMap)) {
			{
				Product p = productMap.get(productId);
				p.setProductName(item);
				if (!(productMap.replace(productId, p).equals(null))) {
					return true;
				}
			}

			return false;
		}
		return false;
	}

	@Override
	public boolean updateProductsLocation(int productId, String item) {
		if (!isProductListEmpty(productMap)) {
			{
				Product p = productMap.get(productId);
				p.setStorageLocation(item);
				if (!(productMap.replace(productId, p).equals(null))) {
					return true;
				}
			}

			return false;
		}
		return false;

	}

	@Override
	public boolean updateProductQty(int productId, int item) {
		if (!isProductListEmpty(productMap)) {
			{
				Product p = productMap.get(productId);
				p.setQty(item);
				if (!(productMap.replace(productId, p).equals(null))) {
					return true;
				}
			}

			return false;
		}
		return false;

	}

	@Override
	public boolean updateProductPrice(int productId, int item) {
		if (!isProductListEmpty(productMap)) {
			{
				Product p = productMap.get(productId);
				p.setPrice(item);
				if (!(productMap.replace(productId, p).equals(null))) {
					return true;
				}
			}

			return false;
		}
		return false;
	}

	@Override
	public boolean updateProductManifactreDate(int productId, LocalDate item) {
		if (!isProductListEmpty(productMap)) {
			{
				Product p = productMap.get(productId);
				p.setManifactureDate(item);
				if (!(productMap.replace(productId, p).equals(null))) {
					return true;
				}
			}

			return false;
		}
		return false;

	}

	@Override
	public void getAllProducts() {
		System.out.println("Product Id | Product Name | product Location |Product Quantity | Product Price |");
		productMap.forEach((key, values) -> System.out
				.println(key + " " + values.getProductName() + " " + values.getStorageLocation() + " " + values.getQty()
						+ " " + values.getPrice() + " " + values.getManifactureDate()));
		System.out.println();

	}

	@Override
	public int getProductIdByName(String productName) {

		List<Integer> productId = productMap.entrySet().stream()
				.filter(map -> map.getValue().getProductName().equals(productName)).map(Map.Entry::getKey)
				.collect(Collectors.toList());
		System.out.println("Returning :: " + productId.get(0));
		return productId.get(0);
	}

	@Override
	public boolean DeleteProduct(String productName) {
		if (!isProductListEmpty(productMap)) {
			productMap.remove(getProductIdByName(productName));
			return true;

		}
		return false;

	}

	@Override
	public boolean isProductListEmpty(Map<Integer, Product> productList) {

		if (productList.isEmpty()) {
			return true;
		}
		return false;

	}

	public boolean isProductAlreadyExists(Map<Integer, Product> productMap, String productName) {
		if (!isProductListEmpty(productMap)) {
			return productMap.values().stream().anyMatch(value -> value.getProductName().equals(productName));
		}

		return false;
	}
}
