package main;

import service.ProductService;

import java.util.Scanner;
public class Demo {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
	ProductService ps  = new ProductService();
//	ps.getAllProduct();
		 int option;
		 int pid = 0;
		 String pname = null;
		 float price = 0;
        do
        {
        	 System.out.println("Enter 1 Add Product");
             System.out.println("Enter 2 Update Product");
             System.out.println("Enter 3 Delete Product"); 
             System.out.println("Enter 4 Retrieve Product Price");
             System.out.println("Enter 5 Display");
             System.out.println("Enter 6 for exit");
             System.out.println("Enter your choice \n");
        
        
            option=sc.nextInt();
            switch(option)
            {
                case 1:
                	System.out.println("Add Product");
                	System.out.println("Enter Product ID");
                	pid=sc.nextInt();
                	System.out.println("Enter Product Name");
                	pname=sc.next();
                	System.out.println("Enter Product Price");
                	price=sc.nextFloat();
                	ps.addProduct(pid,pname,price);
                
                	 break;
                	 
                	 
                case 2:
                	System.out.println("Update Product");
                	ps.updateProduct();
                	
				
                   break;
                   
                   
                case 3:
                	
                     	System.out.println("Enter Product ID");
                    	pid=sc.nextInt();
                		ps.deleteProduct(pid);
				
                	 	break;
                  	 
                  	 
                case 4:
                	 System.out.println("Retrieve Product Price");
                	 ps.retriveProductPrice();
                
                	
				 break;
                	
                case 5:
                	  System.out.println(ps.displayProduct());
               	
               	 break;
        	
              	case 6:
                	System.out.println("GoodBye==");
                	break;
            }
        }
        while(option!=6);
		
	}

}
