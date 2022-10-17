package com.yash.pms.utils;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.yash.pms.controller.ProductController;
import com.yash.pms.entity.Product;
import com.yash.pms.service.ProductManagerImpl;

public class utilities {

	public static int choice;
	public static int updateChoice;
	public static int productId=1;
	public static Scanner input= new Scanner(System.in);
	
	protected static Map<Integer,Product> productMap= new HashMap<Integer,Product>();
	protected static String dateFormat = "dd/MM/yyyy";
	
	
	// Objects
	protected static ProductController controller= new ProductController();
	protected static ProductManagerImpl service = new ProductManagerImpl();

}
