

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.io.Serializable;
import java.sql.SQLException;

public class signIn extends JFrame {

	 
	  private JTextField tfEmail = new JTextField();
	  private JPasswordField tfPassword = new JPasswordField();
	  
	  
	  private JButton btSignIn = new JButton("Sign In");
	  
	 
	  public static final long serialVersionUID = 1L;
	  AccountInfo user;
	  
	  public signIn(){
		  	
		  	
		  	
		  	JPanel SignInPane = new JPanel(new GridLayout(1,2,5,5));
		  	
		   
		  	SignInPane.add(new JLabel("Email"));
		  	SignInPane.add(tfEmail);
		  	SignInPane.add(new JLabel("Password"));
		  	SignInPane.add(tfPassword);
			    
			
			
			JPanel buttonPane = new JPanel(new GridLayout(1,2));
			buttonPane.add(new JLabel(" "));
			buttonPane.add(btSignIn);
			
			
			this.getContentPane().add(SignInPane,  BorderLayout.CENTER);
			this.getContentPane().add(buttonPane,  BorderLayout.SOUTH);
			btSignIn.addActionListener(new buttonListener());
	  }
	  
	  
	  class buttonListener implements ActionListener{
		  @Override
		  public void actionPerformed(ActionEvent e ) {
			 getData();
		  }
		  
		  
	  }
	  
	  
	  //@Override
	  public static void main(String[] args) {
		    
		  
		
	  
	    	
	    // Create a scene and place it in the stage
	    signIn frame = new signIn();
	    frame.setTitle("Sign In");
	    frame.setSize(400,80);
	    frame.setResizable(false);
	 //   frame.setLocationRelativeTo(null); // Center the frame
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	  }
	  
	  private void getData() {
		  // Get values from text fields
		  String Email = tfEmail.getText();
		  String password = tfPassword.getText();
		  
		  // Create An account object.
		  user = new AccountInfo();
	    
		  try {
			  user.signIn(Email, password); 
			  
			 
		  }
		  catch(SQLException ex) {
			  System.out.println("hello");
		  }
	   
	   System.out.println(user.getEmail());
			  System.out.println(user.getAccount());
	    
	  }


}
