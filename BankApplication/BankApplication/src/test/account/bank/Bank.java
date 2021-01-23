package test.account.bank;

import test.account.exception.InvalidAccountNumberException;
import test.account.exception.MinimumBalanceException;


public interface Bank 
{
public void withdraw (int accno,double amount) throws MinimumBalanceException, InvalidAccountNumberException;
public void deposit (int accno, double amount) throws InvalidAccountNumberException; 
public void checkBalance(int accno) throws InvalidAccountNumberException;

}