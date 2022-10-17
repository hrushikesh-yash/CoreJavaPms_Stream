package com.yash.pms.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

import com.yash.pms.entity.Product;
import com.yash.pms.utils.utilities;

public class ProductController extends utilities {

	public void addProducts(Product product) {

		if (service.addProduct(product)) {
			System.out.println(" Product Added Sucessfully!");
		} else {
			System.out.println("Product is not added into the records..");
		}

	}

	public void getAllProducts() {

		service.getAllProducts();
	}

	public void getProductIdByName(String productName) {

		System.out.println(service.getProductIdByName(productName));
	}

	public void UpdateProduct(String ProductName, String item, String choice) {
		if (choice.equalsIgnoreCase("name")) {

			if (service.updateProductName(service.getProductIdByName(ProductName), item)) {
				System.out.println("Product name is updated Sucessfully!");
			} else {
				System.out.println("Product name is not updated..");
			}
		} else if (choice.equalsIgnoreCase("location")) {
			if (service.updateProductsLocation(service.getProductIdByName(ProductName), item))
			{

				System.out.println("Product location is updated Sucessfully!");
			} else {
				System.out.println("Product location is not updated..");
			}
		}

	}

	public void UpdateProduct(String ProductName, int item, String choice) {
		if (choice.equalsIgnoreCase("qty")) {
			if(service.updateProductQty(service.getProductIdByName(ProductName), item)) {
				System.out.println("Product location is updated Sucessfully!");
			} else {
				System.out.println("Product location is not updated..");
			}

		} else if(choice.equalsIgnoreCase("price"))

		{
			if (service.updateProductPrice(service.getProductIdByName(ProductName), item)) {
				System.out.println("Product price is updated Sucessfully!");
			} else {
				System.out.println("Product price is not updated..");
			}
		}
	}

	public void UpdateProduct(String ProductName, LocalDate item) {
		if(service.updateProductManifactreDate(service.getProductIdByName(ProductName), item))
		{
			System.out.println("Product Location is updated Sucessfully!");
		} else {
			System.out.println("Product location is not updated..");
		}
		
	}

	public void DeleteProduct(String productName) {
		if (service.DeleteProduct(productName)) {
			System.out.println("Product Name : " + productName + " is deleted Sucessfully! ");
		} else {
			System.out.println("Product Name : " + productName + " is not found in the record.");
		}
	}

	public boolean isProductExists(Map<Integer, Product> productList, String productname) {
		if (service.isProductAlreadyExists(productList, productname)) {
			return true;
		}
		return false;
	}

}
