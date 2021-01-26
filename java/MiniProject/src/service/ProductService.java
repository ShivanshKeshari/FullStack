package service;

import java.util.*;
import bean.Product;


public class ProductService {
	Map<Integer, Map<String,Float>> p = new HashMap<>(); 
	public void addProduct(int pid ,String pname,float price) {
		 if (p.get(pid) == null) {
	            p.put(pid, new HashMap<String, Float>());
	        }
	      p.get(pid).put(pname, price);
	      
	    

	}

	public void updateProduct() {
		
		System.out.println("Update Product");
	
		
	}
public void  deleteProduct(int id) {
		
		p.remove(id);

		
	}
public void retriveProductPrice() {
	

	
}
public Map<Integer, Map<String, Float>> displayProduct() {
	
	return p;
}
}
