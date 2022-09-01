import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;
import javax.swing.JTabbedPane;
import java.awt.List;

public class Checkout extends JFrame {
	
	public Checkout(){
		JTabbedPane	 tabbedPane = new JTabbedPane();
		
		JPanel cartTab = new cartPanel();
		tabbedPane.addTab( "cart", cartTab);
		JPanel OrderTab = new orderPanel();
		tabbedPane.addTab( "Order", OrderTab);
		//JPanel orderTab = new orderPanel();
		
		this.getContentPane().add(tabbedPane,BorderLayout.CENTER);
		
		
	}
	
	
	public class cartPanel extends JPanel{
		java.util.List<Item> a = new LinkedList<>();
		public cartPanel(){
			JPanel itemContainer = new JPanel(new GridLayout(20,1,3,3), false);
			
			this.add(itemContainer, BorderLayout.WEST);
		}
		public void cartPanelAdd(String product) {
			a.add(new Item(product));
		}
	}
	
	public class orderPanel extends JPanel{
		
		java.util.List<Item> a = new LinkedList<>();
		public orderPanel(){
			JPanel itemContainer = new JPanel(new GridLayout(20,1,3,3), false);
			
			this.add(itemContainer, BorderLayout.WEST);
		}
		public void orderPanelAdd(String product) {
			a.add(new Item(product));
		}
		
		
	}
	
	public class Item extends JPanel{
		JCheckBox JCB = new JCheckBox();
		boolean box = false;
		public Item(String prodID){
			JPanel item = new JPanel(new GridLayout(1,3,3,3));
			item.add(JCB);
			item.add(new JLabel(prodID));
			
			this.add(item, BorderLayout.WEST);
			JCB.addItemListener(new JCBListener());
		}
		public class JCBListener implements ItemListener{
			  @Override
			  public void itemStateChanged(ItemEvent e ) {
				box = !box;
			  }
			  
			  
		  }
	}
		
		
	
}