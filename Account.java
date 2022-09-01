import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.SQLException;

import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
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
import javax.swing.JOptionPane;


@SuppressWarnings("serial")
public class Account extends JFrame
{
	
	public Account(){	
	}
	public Account(AccountInfo a){
	  	
	  	
	  	
	  	JPanel APane = new JPanel(new GridLayout(11,2,3,3));
	  	
	  	APane.add(new JLabel("First Name:"));
		APane.add(new JLabel(a.getFirstName()));
		APane.add(new JLabel("Last Name:"));
		APane.add(new JLabel(a.getLastName()));
		APane.add(new JLabel("Email:"));
		APane.add(new JLabel(a.getEmail()));
		APane.add(new JLabel("Password:"));
		APane.add(new JLabel(a.getPassword()));
		    
		APane.add(new JLabel("Street Address:"));
		APane.add(new JLabel(a.getStreetAddress()));
		APane.add(new JLabel("City:"));
		APane.add(new JLabel(a.getCity()));
		APane.add(new JLabel("Zip Code:"));
		APane.add(new JLabel(" " + a.getZipCode()));
		    
		APane.add(new JLabel("Credit Card:"));
		APane.add(new JLabel(a.getCreditCard()));
		APane.add(new JLabel("Security code:"));
		APane.add(new JLabel(" " + a.getSecCode()));
		APane.add(new JLabel("expiration date:"));
		APane.add(new JLabel(a.getExpDate()));
		    
		this.getContentPane().add(APane,  BorderLayout.CENTER);
		
		
		
  }
	
	

	  
	 
}