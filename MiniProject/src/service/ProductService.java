package service;

import java.util.*;

import bean.Product;


public class ProductService {
	Map<Integer, Map<String,Float>> p = new HashMap<>(); 
	Product ps=new Product();
	public void addProduct(int pid ,String pname,float price) {
		ps.setPid(pid);
		ps.setPname(pname);
		ps.setPrice(price);
		if (p.get(ps.getPid()) == null) {
			p.put(pid, new HashMap<String, Float>());
		}
		p.get(ps.getPid()).put(ps.getPname(), ps.getPrice());



	}

	public void updateProduct(int pid ,String pname,float price) {
		ps.setPid(pid);
		ps.setPname(pname);
		ps.setPrice(price);
		p.get(ps.getPid()).put(ps.getPname(), ps.getPrice());


	}
	public void  deleteProduct(int pid) {
		ps.setPid(pid);
		p.remove(ps.getPid());


	}
	public Collection<Float> retriveProductPrice(int pid) {
		ps.setPid(pid);
		Map<String,Float>n=p.get(ps.getPid());

		return n.values();

	}
	public Map<Integer, Map<String, Float>> displayProduct() {

		return p;
	}
}
