package test.account.initialization;

import test.account.Account;
import test.account.exception.InvalidAccountNumberException;
import test.account.exception.MinimumBalanceException;


public abstract class AccountInitialization
{
static int accountCount=0;
static int acno=1010;
public static Account accounts[]=new Account[10];

public void accountCreate()
{
  
Account ac = new Account(acno++,"Bob",500);
accounts[accountCount]=ac;
accountCount++;			
}
public void accountCreate(String name ,double amount)
{
    if(amount>500)
    {
    	
        accounts[accountCount]=new Account(acno,name,amount);
        System.out.println("Account is Created=="+accounts[0].getAccountnumber() +" "+accounts[0].getAccountName());
        acno++;
        accountCount++;	
        
   }
}

public Account[] getAccountDetails(){
	return accounts;
}

public abstract void transfer(int fromaccNo,int toAccNo,double amount) throws InvalidAccountNumberException, MinimumBalanceException;
}