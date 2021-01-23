package test.account;

public class Account
{
   private int accNo;
   private String name;
   private double amount;
   
  public Account(int accNo,String name,double amount)
  {
      this.accNo=accNo;
      this.name=name;
      this.amount=amount;
  }
   public int getAccountnumber() {
        return this.accNo;
    }
    public String getAccountName() {
        return this.name;
    }
    public double getamount() {
        return this.amount;
    }
 
    public void setAccountnumber(int Accnt) {
        this.accNo = Accnt;
    }
    
    public void setAccountName(String name) {
        this.name = name;
    }
     public void setamount(double amount ) {
        this.amount = amount;
    }
     public boolean search(int acn) {
	        if (accNo==acn) {
	            return true;
	        }
	        return false;
	    }
     
     public void showAccount(){
    	 System.out.println("Account No - "+ accNo + ", Name - " + name + ", Balance Amount - " + amount);  	 
     }
     
     public void showNameAndAmount(){
    	 System.out.println("Name - " + name + ", Balance Amount - " + amount);  	 
     }
     
     public void showBalance(){
    	 System.out.println("Balance Amount - " + amount);  	 
     }
}
 
