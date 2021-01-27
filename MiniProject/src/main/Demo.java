package main;

import service.ProductService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Scanner;
public class Demo {

	@SuppressWarnings("resource")
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
			System.out.println("Enter 6 to Save in a File");
			System.out.println("Enter 7 for exit");
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
				System.out.println("Enter Product ID");
				pid=sc.nextInt();
				System.out.println("Enter Product New Name");
				pname=sc.next();
				System.out.println("Enter Product New Price");
				price=sc.nextFloat();
				ps.updateProduct(pid,pname,price);


				break;


			case 3:

				System.out.println("Enter Product ID");
				pid=sc.nextInt();
				ps.deleteProduct(pid);

				break;


			case 4:
				System.out.println("Retrieve Product Price");
				System.out.println("Enter Product ID");
				pid=sc.nextInt();
				Collection<Float> ans=ps.retriveProductPrice(pid);
				System.out.println(ans);


				break;

			case 5:

				System.out.println(ps.displayProduct());

				break;
			case 6:

				System.out.println("Saved in a File");
				 try {
				        File fileOne=new File("fileone.text");
				        FileOutputStream fos=new FileOutputStream(fileOne);
				        ObjectOutputStream oos=new ObjectOutputStream(fos);

				        oos.writeObject(ps.displayProduct());
				        oos.flush();
				        oos.close();
				        fos.close();
				    } catch(Exception e) {}
				 
				break;

			case 7:
				System.out.println("GoodBye==");
				break;
			}
		}
		while(option!=6);

	}

}
