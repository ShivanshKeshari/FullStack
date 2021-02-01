package service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import bean.Product;
import dao.Dao;

public class ProductService
{
	Integer pid;

	Dao dao = new Dao();
	
	
	public int addProduct(Product p) throws ClassNotFoundException, SQLException 
	{
		
		int pid = dao.addProduct(p);;	
		return pid;
	}
	
	public int updateProduct(Product p) throws ClassNotFoundException, SQLException
	{
		int statuc = dao.update(p);
		return statuc;
	}
	
	public int deleteProduct(int pid) throws ClassNotFoundException, SQLException
	{
		int id = dao.delete(pid);
		return id;
	}
	

	public ArrayList<Product> display4() throws ClassNotFoundException, SQLException
	{		
		
        Comparator<Product> sortList = (Product s1, Product s2)->(int)(s2.getPrice()-s1.getPrice());
		
		return (ArrayList<Product>) dao.displayAll().stream().sorted(sortList).collect(Collectors.toList());
	}
	
	public ArrayList<Product> display1() throws ClassNotFoundException, SQLException
	{		
		Comparator<Product> sortList = (Product s1, Product s2)->s1.getPname().compareTo(s2.getPname());
		
		return (ArrayList<Product>) dao.displayAll().stream().sorted(sortList).collect(Collectors.toList());
	}
	
	public ArrayList<Product> display2() throws ClassNotFoundException, SQLException
	{		
		
        Comparator<Product> sortList = (Product s1, Product s2)->s2.getPname().compareTo(s1.getPname());
		
		return (ArrayList<Product>) dao.displayAll().stream().sorted(sortList).collect(Collectors.toList());
	}
	public ArrayList<Product> display() throws ClassNotFoundException, SQLException
	{		
		ArrayList<Product> p = (ArrayList<Product>) dao.displayAll().stream().collect(Collectors.toList());
		return p;
	}
	public ArrayList<Product> display3() throws ClassNotFoundException, SQLException
	{		
		
        Comparator<Product> sortList = (Product s1, Product s2)->(int)(s1.getPrice()-s2.getPrice());
		
		return (ArrayList<Product>) dao.displayAll().stream().sorted(sortList).collect(Collectors.toList());
	}
	

	
		
}
