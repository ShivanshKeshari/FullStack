package test.account.my.bank;

import test.account.initialization.AccountInitialization;
import test.account.Account;
import test.account.bank.Bank;
import test.account.exception.InvalidAccountNumberException;
import test.account.exception.MinimumBalanceException;

public class MyBank extends AccountInitialization implements Bank 
{
    public void transfer(int fromaccNo,int toAccNo,double amount)throws MinimumBalanceException, InvalidAccountNumberException {
    
       
       if(amount>0)
       {
           System.out.println("Transfering the money");
           Account fromAccount=null;
           Account toAccount=null;
           int fromAccountIndex=0;
           int toAccountIndex=0;
       	boolean foundFromAccount=false;
       	boolean foundToAccount=false;
       	
       	//finding from account
  		 for (int i = 0; i < accounts.length; i++) {
  			fromAccountIndex=i;
  			foundFromAccount= accounts[i].search(fromaccNo);
  			 if(foundFromAccount){
  				fromAccount=accounts[i];
  				 break;
  				 }
  		 }
  		if(!foundFromAccount){
   			throw new InvalidAccountNumberException("From Account number is not valid");
   		}
  		 //finding to account
  		 for (int i = 0; i < accounts.length; i++) {
  			toAccountIndex=i;
  			foundToAccount= accounts[i].search(toAccNo);
  			 if(foundToAccount){
  				toAccount=accounts[i];
  				 break;
  				 }
  		 }
  		if(!foundToAccount){
   			throw new InvalidAccountNumberException("To Account number is not valid");
   		}
  		 
  		 if(fromAccount.getamount()>=amount){
  			fromAccount.setamount(fromAccount.getamount()-amount);
  			accounts[fromAccountIndex]=fromAccount;
  			toAccount.setamount(toAccount.getamount()+amount);
  			accounts[toAccountIndex]=toAccount;
  		 }
  		 else{
  			throw new MinimumBalanceException("From Account balance is low"); 
  		 }
           
       }
       else
       {
            throw new MinimumBalanceException("Please maintain your balance to transfer the money");
       }

    }
    public void withdraw(int accno,double amount)throws MinimumBalanceException, InvalidAccountNumberException
    {
        if(amount-500>0)
        {
        	boolean found=false;
   		 for (int i = 0; i < accounts.length; i++) {
   			 found= accounts[i].search(accno);
   			 if(found){
   				 accounts[i].setamount(accounts[i].getamount()- amount);
   				accounts[i].showBalance();
   				 break;
   				 }
   		 }	
   		if(!found){
   			throw new InvalidAccountNumberException("Account number is not valid");
   		}
        }
        else
        {
            throw new MinimumBalanceException("Low Balance in your account");
        }
    }
	@Override
	public void deposit(int accno, double amount) throws InvalidAccountNumberException {
		boolean found=false;
  		 for (int i = 0; i < accounts.length; i++) {
  			 found= accounts[i].search(accno);
  			 if(found){
  				 accounts[i].setamount(accounts[i].getamount()+ amount);
  				accounts[i].showBalance();
  				 break;
  				 }
  		 }	
  		if(!found){
  			throw new InvalidAccountNumberException("Account number is not valid");
  		}
		
	}
	@Override
	public void checkBalance(int accno) throws InvalidAccountNumberException {
		Account account= getAccountByAccountNo(accno);
		if(account!=null){
			account.showBalance();
		}else{
			throw new InvalidAccountNumberException("Account number is not valid");
		}
		
	}
	 
public void showAccountDetails(int accno) throws InvalidAccountNumberException {
		
	Account account= getAccountByAccountNo(accno);
	if(account!=null){
		account.showAccount();
	}else{
		throw new InvalidAccountNumberException("Account number is not valid");
	}
	
	}

public void showNameAndAmount(int accno) throws InvalidAccountNumberException {
	
Account account= getAccountByAccountNo(accno);
if(account!=null){
	account.showNameAndAmount();
}else{
	throw new InvalidAccountNumberException("Account number is not valid");
}
	
	}

private Account getAccountByAccountNo(int accno){
	Account account=null;
	try{
	
	boolean found=false;
	 for (int i = 0; i < accounts.length; i++) {
		 
		 found= accounts[i].search(accno);
		 if(found){
			 account = accounts[i];
		 break;
		 }
	 }	
	}catch(Exception e){
	//
	}
	return account;
}
}
