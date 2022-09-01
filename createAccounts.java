

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.GridLayout;
import java.io.Serializable;
import java.sql.SQLException;

public class createAccounts extends JFrame   {
	private JTextField tfFirstName = new JTextField();
	  private JTextField tfLastName = new JTextField();
	  private JTextField tfEmail = new JTextField();
	  private JPasswordField tfPassword = new JPasswordField();
	  
	  private JTextField tfStreetAddress = new JTextField();
	  private JTextField tfCity = new JTextField();
	  private JTextField tfZipCode = new JTextField();
	  
	  private JTextField tfCreditCard = new JTextField();
	  private JTextField tfSecCode = new JTextField();
	  private JTextField tfExpDate = new JTextField();
	  
	  private JButton btFinish = new JButton("Finish");
	  
	 
	  public static final long serialVersionUID = 1L;
	  AccountInfo user;
	  
	  public createAccounts()  {
		  	
		  	
		  	
		  	JPanel accPane = new JPanel(new GridLayout(11,2,3,3));
		  	accPane.setSize(new Dimension(400,400));
		   
			accPane.add(new JLabel("First Name"));
			accPane.add(tfFirstName);
			accPane.add(new JLabel("Last Name"));
			accPane.add(tfLastName);
			accPane.add(new JLabel("Email"));
			accPane.add(tfEmail);
			accPane.add(new JLabel("Password"));
			accPane.add(tfPassword);
			    
			accPane.add(new JLabel("Street Address"));
			accPane.add(tfStreetAddress);
			accPane.add(new JLabel("City"));
			accPane.add(tfCity);
			accPane.add(new JLabel("Zip Code"));
			accPane.add(tfZipCode);
			    
			accPane.add(new JLabel("Credit Card"));
			accPane.add(tfCreditCard);
			accPane.add(new JLabel("Security code"));
			accPane.add(tfSecCode);
			accPane.add(new JLabel("expiration date"));
			accPane.add(tfExpDate);
			
			
			JPanel buttonPane = new JPanel(new GridLayout(1,2));
			buttonPane.add(new JLabel(" "));
			buttonPane.add(btFinish);
			
			
			this.getContentPane().add(accPane,BorderLayout.CENTER);
			this.getContentPane().add(buttonPane,BorderLayout.SOUTH);
			btFinish.addActionListener(new buttonListener());
	  }
	  
	  
	  class buttonListener implements ActionListener{
		  @Override
		  public void actionPerformed(ActionEvent e ) {
			 getData();
		  }
		  
		  
	  }
	  
	  
	
	  public static void main(String[] args) {
		    
		  
		
	 
	    // Create a scene and place it in the stage
	    createAccounts frame = new  createAccounts();
	    frame.setTitle("create accounts");
	    frame.setSize(400, 400);
	    frame.setResizable(false);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    

	  }
	  
	  private void getData() {
	    // Get values from text fields
	    String firstName = tfFirstName.getText();
	    String lastName = tfLastName.getText();
	    String Email = tfEmail.getText();
	    String password = tfPassword.getText();
	    
	    String streetAddress = tfStreetAddress.getText();
	    String city = tfCity.getText();
	    int zipCode = Integer.parseInt(tfZipCode.getText());
	    
	    String creditCard = tfCreditCard.getText();
	    int secCode = Integer.parseInt(tfSecCode.getText());
	    String expDate = tfExpDate.getText();
	    
	    
	    // Create An account object.
	    user = new AccountInfo(
	    		 firstName,  lastName,  Email,  password,
	    	     creditCard,  secCode, expDate,
	    	     streetAddress,  city,  zipCode);
	   
	    try {
	    user.Create();
	   
	    }
	    catch(SQLException ex) {
	    	JOptionPane.showMessageDialog(	new JFrame() ,
				    "Incorrect Username or password", "ERROR",
				    JOptionPane.ERROR_MESSAGE);
	    }
	  }





	
	  
	  
	  
	 
}
