import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;


public class testJavaSwing extends JFrame {
	
	
	JButton btS = new JButton(" B ");
	JButton dtS = new JButton(" D ");
	AccountInfo acc = null;
	login rame = new  login();
	
	public testJavaSwing(){
	  	
	  	
	  	
	  	JPanel testJavaPane = new JPanel(new GridLayout(1,2,5,5));
	  	
	  	testJavaPane.add(new JLabel(" hello"));
	  	
	  	
		    
		
		
		JPanel buttonPane = new JPanel(new GridLayout(1,2));
		buttonPane.add(new JLabel(" "));
		buttonPane.add(btS);
		buttonPane.add(dtS);
		
		this.add(testJavaPane,  BorderLayout.CENTER);
		this.add(buttonPane,  BorderLayout.SOUTH);
		btS.addActionListener(new buttonr());
		dtS.addActionListener(new buttoner());
  }
	
	
	public static void main(String[] args){
		
		
		// Create a scene and place it in the stage
		testJavaSwing frame = new testJavaSwing();
	    frame.setTitle("javaTest");
	    frame.setSize(400,80);
	    frame.setResizable(false);
	 //   frame.setLocationRelativeTo(null); // Center the frame
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
		
		
	}
	
	class buttonr implements ActionListener{
		  @Override
		  public void actionPerformed(ActionEvent e ) {
			 NewFrame();
		  }
		  
		  
		  
	  }
	class buttoner implements ActionListener{
			  @Override
			  public void actionPerformed(ActionEvent e ) {
				  acc = rame.getAC();
				  NewFram();
			  }
	}
	public void NewFrame() {
		
	    rame.setTitle("create accounts");
	    rame.setSize(400, 400);
	    rame.setResizable(false);
	 //   frame.setLocationRelativeTo(null); // Center the frame
	    rame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    rame.setVisible(true);
	    acc = rame.getAC();
	}
	
	public void NewFram() {
		
		Account ramed = new  Account(acc);
	    ramed.setTitle("create accounts");
	    ramed.setSize(200, 400);
	    ramed.setResizable(false);
	 //   frame.setLocationRelativeTo(null); // Center the frame
	    ramed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    ramed.setVisible(true);
	    
	}
	}
