package test.main.account.bank;

import java.util.Scanner;

import test.account.exception.InvalidAccountNumberException;
import test.account.my.bank.MyBank;


public class Bank_Test_Application
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        
         
         int option;
         int accountNo;
         double amount;
        do
        {
        	 System.out.println("Enter 1 for create account");
             System.out.println("Enter 2 for default details");
             System.out.println("Enter 3 for name and amount pass"); 
             System.out.println("Enter 4 check account balance");
             System.out.println("Enter 5 for Withdraw the amount");
             System.out.println("Enter 6 for deposit the account");
             System.out.println("Enter 7 for Transefer the account");
             System.out.println("Enter 8 for exit the application");
             System.out.println("Enter your choice \n");
        
            MyBank bank = new MyBank();
            option=sc.nextInt();
            switch(option)
            {
                case 1:
                	System.out.println("Please Enter name");
                	String name= sc.next();
                	System.out.println("Please Enter Amount");
                    amount = sc.nextDouble();
                	bank.accountCreate(name,amount);
                	 break;
                	 
                	 
                case 2:
                	System.out.println("Please Enter account number");
               	   accountNo =sc.nextInt();
               	   try {
					bank.showAccountDetails(accountNo);
				} catch (InvalidAccountNumberException e) {
					System.out.println(e.getMessage());
				}
                   break;
                   
                   
                case 3:
                	 System.out.println("Please Enter account number");
                 	  accountNo =sc.nextInt();
				try {
					bank.showNameAndAmount(accountNo);
				} catch (InvalidAccountNumberException e1) {
					System.out.println(e1.getMessage());
				}
                  	 break;
                  	 
                  	 
                case 4:
                	  System.out.println("Please Enter account number");
                	  accountNo =sc.nextInt();
				try {
					bank.checkBalance(accountNo);
				} catch (InvalidAccountNumberException e1) {
					System.out.println(e1.getMessage());
				}
                	 break;
                	
                case 5:
                	 System.out.println("Please Enter account number");
               	  accountNo =sc.nextInt();
               	System.out.println("Please Enter withdraw amount");
               	amount = sc.nextDouble();
               	 try {
					bank.withdraw(accountNo, amount);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
               	 break;
                	
                case 6:
                	 System.out.println("Please Enter account number");
                  	  accountNo =sc.nextInt();
                  	System.out.println("Please Enter deposit amount");
                  	amount = sc.nextDouble();
				try {
					bank.deposit(accountNo, amount);
				} catch (InvalidAccountNumberException e1) {
					System.out.println(e1.getMessage());
				}
                  	 break;
                	
                case 7:
               	 System.out.println("Please Enter source account number");
              	  int fromAccountNo =sc.nextInt();
             	 System.out.println("Please Enter destination account number");
              	  int toAccountNo =sc.nextInt();
              	System.out.println("Please Enter transfer amount");
              	amount = sc.nextDouble();
              	try {
					bank.transfer(fromAccountNo, toAccountNo, amount);
				} catch (Exception e) {
				System.out.println(e.getMessage());
				}
              	break;
              	
              	
                case 8:
                	System.out.println("GoodBye==");
            }
        }
        while(option!=8);
    }
}












