 import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;

public class Purchase {
	  public static final long serialVersionUID = 1L; 
	   private int account;
	   private int cart;
	   private double total;
	   
	   String Host = " ";
	   String name = " ";
	   String Pass = " ";
	   
	   
	   Connection connection = DriverManager.getConnection(Host,name, Pass);
	   
	   String getID = " select account_ID from account";
	   String signInQuery = " ";
	   
	   // initializes an Account with default values
	   public Purchase() 
	   {
	      this(0, 0, 0.0); // call other constructor
	   } 
	  
	   // initializes an Account with provided values
	   public Purchase(int account, int cart, double balance)
	   {
	      this.account = account;
	      this.cart = cart;
	      this.total = total;
	   }

	   // set account ID    
	   public void setAccount(int acct)
	   {
	      this.account = account;
	   } 

	   // get account ID    
	   public int getAccount() 
	   { 
	      return account; 
	   } 
	  
	   //set cart id
	   public void setCart(int cartid)
	   {
	      this.cart = cart;
	   } 

	   // get Cart ID   
	   public int getCart() 
	   { 
	      return cart; 
	   } 
	   
	   // set Total  
	   public void setTotal(double total)
	   {
	      this.total = total;
	   } 

	   // get balance   
	   public double getTotal() 
	   { 
	      return total; 
	   } 
}
