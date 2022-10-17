package com.yash.pms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.yash.pms.entity.Product;
import com.yash.pms.utils.utilities;

public class DriverClass extends utilities {

	public static void main(String[] args) {
		while (true) {
		System.out.println("********** PRODUCT MANAGEMENT SYSTEM **********");
		System.out.println("Enter the choice do you want to perform. ");
		System.out.println("1.ADD");
		System.out.println("2.Update");
		System.out.println("3.Delete");
		System.out.println("4.View Product List");
		System.out.println("5.Search by Product Name");
		System.out.println();

		choice = input.nextInt();
		
			switch (choice) {
			case (1):
				System.out.println("Enter the Product Name");
				String productName = input.next();
				System.out.println("Enter the Product Storage Location");
				String productLocation = input.next();
				System.out.println("Enter the Product quantity");
				int productQty = input.nextInt();
				System.out.println("Enter the Product price");
				int productPrice = input.nextInt();
				
				 System.out.println("Enter the Product mamifactutred Date in formta of dd/MM/yyyy");
				try {
				String productMfDateString=input.next();
				DateTimeFormatter dateTimeFormat= DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate productMfDate =LocalDate.parse(productMfDateString, dateTimeFormat); 
					Product newProduct = new Product(productId++, productName, productLocation,productQty,productPrice,productMfDate, (short) 0);
					controller.addProducts(newProduct);
				} catch (Exception e) {
					// **To do
					
					e.printStackTrace();
				}

				break;
			case 2:
				System.out.println("To update any things of the product enter the product name : ");
				String productNameToUpdate = input.next();
				if(true)//(controller.isProductExists(productMap, productNameToUpdate))
				{
					System.out.println("What do you want to update");
					System.out.println("1.Name");
					System.out.println("2.Location");
					System.out.println("3.Quantity");
					System.out.println("4.Price ");
					System.out.println("5.Manifacture Date");
					updateChoice = input.nextInt();
					switch (updateChoice) {
					case 1:
						System.out.println("Enter new product Name");
						controller.UpdateProduct(productNameToUpdate, input.next(), "name");
						break;
					case 2:
						System.out.println("Enter new product location");
						controller.UpdateProduct(productNameToUpdate, input.next(), "location");
						break;
					case 3:
						System.out.println("Enter new product QTY");
						controller.UpdateProduct(productNameToUpdate, input.nextInt(), "qty");
						break;
					case 4:
						System.out.println("Enter new product price");
						controller.UpdateProduct(productNameToUpdate, input.nextInt(), "price");
						break;
					case 5:
						System.out.println("Enter new product manifactureing date");
						String productMfDateString=input.next();
						DateTimeFormatter dateTimeFormat= DateTimeFormatter.ofPattern("dd/MM/yyyy");
						LocalDate productMfDate =LocalDate.parse(productMfDateString, dateTimeFormat); 
						try {
							controller.UpdateProduct(productNameToUpdate,productMfDate);
						} catch (Exception e) {
							// **To do
							e.printStackTrace();
						}
						break;
					default:
						break;
					}
				}
				else
				{
					System.out.println("Product Name : "+productNameToUpdate+" is not found in the records");
				}
				break;
			case 3:
				System.out.println("To delete product enter the product name : ");
				String productNameToDelete = input.next();
				controller.DeleteProduct(productNameToDelete);
				break;
			case 4:
				controller.getAllProducts();
				break;
			case 5:
				System.out.println("Enter product Name to search : ");
				String productNameToSearch = input.next();
				controller.getProductIdByName(productNameToSearch);
				break;
			default:
				System.out.println(" You entered incorrect choice.");
				break;
			}
		}

	}

}
