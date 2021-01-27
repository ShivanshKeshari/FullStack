package service;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import bean.Product;
import dao.ProductDao;

public class ProductService {	//CRUD Operation 
	List<Product> listOfProduct;
	ProductDao pd;
	
	public ProductService() {
		pd = new ProductDao();
	}
	public List<Product> getAllProductByAsc() {	
		listOfProduct = pd.getAllProduct();
		 List<Product> result = listOfProduct.stream().sorted((o1, o2)->o2.getpName().
                 compareTo(o1.getpName() )).
                 collect(Collectors.toList());
		return result;
	}
	public List<Product> getAllProductByDsc() {	
		listOfProduct = pd.getAllProduct();
		 List<Product> result = listOfProduct.stream().sorted((o1, o2)->o1.getpName().
                 compareTo(o2.getpName() )).
                 collect(Collectors.toList());
		return result;
	}
	public List<Product> getAllProductByAscPrice() {	
		listOfProduct = pd.getAllProduct();
		 List<Product> result = listOfProduct.stream().sorted((o1, o2)->Double.valueOf(o1.getPrice()) .
                 compareTo(Double.valueOf(o2.getPrice()) )).
                 collect(Collectors.toList());
		return result;
	}
	public List<Product> getAllProductByDscPrice() {	
		listOfProduct = pd.getAllProduct();
		 List<Product> result = listOfProduct.stream().sorted((o1, o2)->Double.valueOf(o2.getPrice()) .
                 compareTo(Double.valueOf(o1.getPrice()) )).
                 collect(Collectors.toList());
		return result;
	}
	public Collection<Double> displayProductUsingMargin() {	
		listOfProduct = pd.getAllProduct();
		 Collection<Double> result = listOfProduct.stream().map((p1)->p1.getPrice()*.20+p1.getPrice()).
                 collect(Collectors.toList());
		return result;
	}
	public String storeRecord(Product pp) {
		if(pp.getPrice()<0) {
			return "Price must be +ve";
		}else if(pp.getPrice()>0 && pp.getPrice()<500) {
			return "Minimum price must be > 500";
		}else if(pd.storeProductDetails(pp)>0) {
			return "Record stored successfully";
		}else {
			return "Record didn't store";
		}
	}
}



/*
class SortByName implements Comparator<Product>{
	@Override
	public int compare(Product o1, Product o2) {
		// TODO Auto-generated method stub
		return o1.getpName().compareTo(o2.getpName());
	}
}
*/

