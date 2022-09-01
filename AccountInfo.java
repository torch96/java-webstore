

import java.io.Serializable;
import java.sql.*;
import javax.swing.JOptionPane;

public class AccountInfo implements Serializable
{  
   public static final long serialVersionUID = 1L; 
   
   private boolean logValue = false;
   private int account;
   
   //personal info
   private String firstName;
   private String lastName;
   private String Email;
   private String password;
   
   //Credit card info
   private String creditCard;
   private int secCode;
   private String expDate;
   
   //address
   private String streetAddress;
   private String city;
   private int zipCode;
   
   ResultSet rs = null;
   String driver = "com.mysql.jdbc.Driver";
   String Host = "jdbc:mysql://127.0.0.1:3306/javaapp?useSSL=false";
   String name = "root";
   String Pass = "pass";
   Connection connection = null;
   
   
   
   String getID = " select account_ID from account";
   String signInQuery = " ";
   
   // initializes an Account with default values
  
   
   public AccountInfo() 
   {
      this( 
      "", "", "", "",
      " ", 0, " ",
      "", "", 0); // call other constructor
   } 
   
   
   
   // initializes the Account with provided values
   public AccountInfo(
    String firstName, String lastName, String Email, String password,
    String creditCard, int secCode, String expDate,
    String streetAddress, String city, int zipCode)
   {
    
     
      this.firstName = firstName;
      this.lastName = lastName;
      this.Email = Email;
      this.password = password;

      this.creditCard = creditCard;
      this.secCode = secCode;
      this.expDate = expDate;
      
      this.streetAddress = streetAddress;
      this.city = city;
      this.zipCode = zipCode;
      
	  
      
   }
   
  public void Create() throws SQLException {
	  
	  
	  
	  
      
      String insQuery = " INSERT INTO account ( first_Name, last_name, Email, pass,  streetAddress, city, zipCode, creditCard, secCode, expDate)" 
    		  + "values(?,?,?,?, ?,?,?, ?,?,?)";
      try {
    	  Class.forName("com.mysql.jdbc.Driver");
    	  connection = DriverManager.getConnection(Host,name, Pass);
      
      PreparedStatement insertStmt =  connection.prepareStatement(insQuery);

    
      
      insertStmt.setString(1, firstName);
      insertStmt.setString(2, lastName);
      insertStmt.setString(3, Email);
      insertStmt.setString(4, password);
      
      insertStmt.setString(5, streetAddress );
      insertStmt.setString(6, city);
      insertStmt.setInt(7, zipCode);
     
      insertStmt.setString(8, creditCard);
      insertStmt.setInt(9, secCode);
      insertStmt.setString(10, expDate);
      
      
      
      insertStmt.executeUpdate(); 
      
      logValue = true;
      
      PreparedStatement getAcId =  connection.prepareStatement("select Account_ID  from javaapp.account where Email = ? and  pass = ?" );
      getAcId.setString(1, Email);
      getAcId.setString(2, password);
	  rs = getAcId.executeQuery();
	   
	   
	   
	   if(rs.next())
		account = rs.getInt(1);
      
      }
      catch (SQLException e)
      {
    	  e.printStackTrace();
    	  System.out.println("Account Creation has failed");
      }
  	catch(Exception se){
      //Handle errors for Class.forName
      se.printStackTrace();
  	}
  	 finally {
		   connection.close();
	   }
	  
  }
   public void signIn(String Email, String password) throws SQLException {
	   
	   try {
		   
		   
		   Class.forName("com.mysql.jdbc.Driver");
	    	  connection = DriverManager.getConnection(Host,name, Pass);
	
		
		PreparedStatement getit = connection.prepareStatement("select * from javaapp.account where Email = ? and  pass = ?" );
		getit.setString(1, Email);
		getit.setString(2, password);  
		
		ResultSet signSet = getit.executeQuery();
		
		if(signSet.next()) {
			 account = signSet.getInt(1);
			   System.out.println(account);   
			   firstName = signSet.getString(2);
			   System.out.println(firstName);
			   lastName = signSet.getString(3);
			   Email = signSet.getString(4);
			   password = signSet.getString(5);
			   
			   streetAddress = signSet.getString(6);
			   city = signSet.getString(7);
			   zipCode = signSet.getInt(8);
			   
			   creditCard = signSet.getString(9);
			   secCode = signSet.getInt(10);
			   expDate = signSet.getString(11);
			   logValue = true;
		} 
		  
		
		 
	   }
	   catch(SQLException ex)
	   {
		 ex.printStackTrace();
		 
	   }
		catch(Exception se){
		      //Handle errors for Class.forName
		      se.printStackTrace();
		}
	   finally {
				   connection.close();
	   }
	   
   }
   // set account number   
   public void setAccount(int acct)
   {
      this.account = account;
   } 

   // get account number   
   public int getAccount() 
   { 
      return account; 
   } 
   
   // set first name   
   public void setFirstName(String firstName)
   {
      this.firstName = firstName;
   } 

   // get first name   
   public String getFirstName() 
   { 
      return firstName; 
   } 
   
   // set last name   
   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   } 

   // get last name   
   public String getLastName() 
   {
      return lastName; 
   } 
   //set Email
    public void setEmail(String Email)
   {
      this.Email = Email;
   } 

   // get email   
   public String getEmail() 
   {
      return Email; 
   } 
 
   //set password
   public void setPassword(String password)
  {
     this.password = password;
  } 

  // get password   
  public String getPassword() 
  {
     return password; 
  } 
   
 //set CreditCard number
   public void setCreditCard(String creditCard)
   {
      this.creditCard = creditCard;
   } 

   // get CreditCard number   
   public String getCreditCard() 
   { 
      return creditCard; 
   } 
   //set Security code 
   public void setSecCode(int secCode)
   {
      this.secCode = secCode;
   } 

   // get Security code   
   public int getSecCode() 
   { 
      return secCode; 
   } 
   //set 
   public void setExpDate(String expDate)
   {
      this.expDate = expDate;
   } 

   // get account number   
   public String getExpDate() 
   { 
      return expDate; 
   } 
   
   // set street Address   
   public void setStreetAddress(String streetAddress)
   {
      this.streetAddress = streetAddress;
   } 

   // get street Address   
   public String getStreetAddress() 
   { 
      return streetAddress; 
   } 
   
   // set City name   
   public void setCity(String city)
   {
      this.city = city;
   } 

   // get City name   
   public String getCity() 
   { 
      return city; 
   } 
   
   // set zip code   
   public void setZipCode(int zipCode)
   {
      this.zipCode = zipCode;
   } 

   // get zip code   
   public int getZipCode() 
   { 
      return zipCode; 
   } 
   public boolean loginSuccess() {
	   return logValue;
   }
}
