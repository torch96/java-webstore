import java.io.Serializable;

public class Transaction implements Serializable
{  
   public static final long serialVersionUID = 1L; 
   private int account;
  
   private double balance;
   
   // initializes an Account with default values
   public Transaction() 
   {
      this(0, 0.0); // call other constructor
   } 
  
   // initializes an Account with provided values
   public Transaction(int account, double balance)
   {
      this.account = account;
   
      this.balance = balance;
   }

   // set account number   
   public void setaccount(int acct)
   {
      this.account = account;
   } 

   // get account number   
   public int getaccount() 
   { 
      return account; 
   } 
   
   // set balance  
   public void setbalance(double balance)
   {
      this.balance = balance;
   } 

   // get balance   
   public double getbalance() 
   { 
      return balance; 
   } 
}