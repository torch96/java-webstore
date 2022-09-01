import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Homepage extends JFrame 
{
	AccountInfo acc = null ;
	//All Public Variables
	BackListener bl = new BackListener();
	
	public static boolean productView = false;
	public JPanel products = new JPanel();
	
	public static boolean AccountView = false;
	public JPanel account = new JPanel();
	
	public static boolean CartView = false;
	public JPanel cart = new JPanel();
	
	public static boolean Sign = false;
	public JPanel sign = new JPanel(new GridLayout(0,1));
	
	static JFrame frame = new Homepage();
	static  Account aframe = new Account(AccountInfo acc);
	static JFrame cframe = new Checkout();
	static login sframe = new login();
	
    String user = "Sign In";
	
	JButton c = new JButton("Cart");
	JButton a = new JButton("Account");
	JButton s = new JButton(user);
	
	boolean signin = true;
	
    TextField loginbar = new TextField();
    TextField searchbar = new TextField();
    
	String b = null,ce = null,d = null,e = null,f = null,g = null;
	
	JLabel b1 = new JLabel();
	JLabel c1 = new JLabel();
	JLabel d1 = new JLabel();
	JLabel e1 = new JLabel();
	JLabel f1 = new JLabel();
	JLabel g1 = new JLabel();
	
	JLabel l1 = new JLabel();
	JLabel l2 = new JLabel();
	JLabel l3 = new JLabel();
	JLabel l4 = new JLabel();
	JLabel l5 = new JLabel();
	JLabel l6 = new JLabel();
	
	JLabel ca1 = new JLabel();
	JLabel ca2 = new JLabel();
	JLabel ca3 = new JLabel();
	JLabel ca4 = new JLabel();
	JLabel ca5 = new JLabel();
	JLabel ca6 = new JLabel();
	
	String[] productList = {"Featured", "Apple", "Google", "LG", "Samsung", "Motorola", "$-$$", "$$-$"};
	@SuppressWarnings({ "rawtypes", "unchecked" })
	JComboBox productsTitle = new JComboBox(productList);
	
	JPanel pp1 = new JPanel(new BorderLayout());
	JPanel pp2 = new JPanel(new BorderLayout());
	JPanel pp3 = new JPanel(new BorderLayout());
	JPanel pp4 = new JPanel(new BorderLayout());
	JPanel pp5 = new JPanel(new BorderLayout());
	JPanel pp6 = new JPanel(new BorderLayout());
	
	String add = " Add to Cart";
	
	public Homepage() 
	{
		//Label for top bar
		JPanel homePanel = new JPanel(new GridLayout());
		JLabel home = new JLabel("                           Cell Phone Store");
		home.setFont(new Font("Arial Black", Font.ROMAN_BASELINE, 24));
		home.setForeground(new Color(0,0,0));
		homePanel.setBackground(new Color(20,150,250));
		homePanel.setOpaque(true);
				
		//Account button
		JPanel apanel = new JPanel();
		JButton a = new JButton("Account");
		apanel.add(a);
		apanel.setBackground(new Color(20,150,250));
		
		//Cart button
		JButton c = new JButton("Cart");
		apanel.add(c);
		
		//Product dropdown
		JPanel ppanel = new JPanel();
		productsTitle.setForeground(Color.BLACK);
		productsTitle.setFont(new Font("Arial Black", Font.ROMAN_BASELINE, 12));
		productsTitle.setForeground(Color.BLACK);
		productsTitle.setOpaque(productView);
		ppanel.add(productsTitle);
		ppanel.setBackground(new Color(20,150,250));
		
		//Sign In button
		ppanel.add(s);		
		
		//Mid section of top bar
		JPanel mid = new JPanel(new BorderLayout());
		mid.setBackground(new Color(20,150,250));
		JButton search = new JButton("Search By Model");
		mid.add(search, BorderLayout.SOUTH);
		mid.add(home, BorderLayout.NORTH);
		mid.add(searchbar, BorderLayout.CENTER);
		
		//Adding items to top bar
		homePanel.add(apanel);
		homePanel.add(mid);
		homePanel.add(ppanel);
		
		//Creates panel under top bar for products
		JPanel page = new JPanel(new GridLayout(2,4));
		page.setBackground(Color.WHITE);
		page.setOpaque(false);
		
		//Edit Panel Color
		pp1.setBackground(Color.WHITE);
		pp2.setBackground(Color.WHITE);
		pp3.setBackground(Color.WHITE);
		pp4.setBackground(Color.WHITE);
		pp5.setBackground(Color.WHITE);
		pp6.setBackground(Color.WHITE);
		
		//Adds info of device
		Font font = new Font("Arial Black", Font.ROMAN_BASELINE, 18);
		JPanel p1 = new JPanel(new GridLayout());
		p1.add(b1);
		b1.setFont(font);
		JPanel p2 = new JPanel(new GridLayout());
		p2.add(c1);
		c1.setFont(font);
		JPanel p3 = new JPanel(new GridLayout());
		p3.add(d1);
		d1.setFont(font);
		JPanel p4 = new JPanel(new GridLayout());
		p4.add(e1);
		e1.setFont(font);
		JPanel p5 = new JPanel(new GridLayout());
		p5.add(f1);
		f1.setFont(font);
		JPanel p6 = new JPanel(new GridLayout());
		p6.add(g1);
		g1.setFont(font);
		
		//Edit Panel Colors
		p1.setBackground(Color.WHITE);
		p2.setBackground(Color.WHITE);
		p3.setBackground(Color.WHITE);
		p4.setBackground(Color.WHITE);
		p5.setBackground(Color.WHITE);
		p6.setBackground(Color.WHITE);

		
		//Adds info panel to full panel at the bottom
		pp1.add(p1, BorderLayout.SOUTH);
		pp2.add(p2, BorderLayout.SOUTH);
		pp3.add(p3, BorderLayout.SOUTH);
		pp4.add(p4, BorderLayout.SOUTH);
		pp5.add(p5, BorderLayout.SOUTH);
		pp6.add(p6, BorderLayout.SOUTH);
		//Adds image panel to full panel at the top
		pp1.add(l1, BorderLayout.NORTH);
		pp2.add(l2, BorderLayout.NORTH);
		pp3.add(l3, BorderLayout.NORTH);
		pp4.add(l4, BorderLayout.NORTH);
		pp5.add(l5, BorderLayout.NORTH);
		pp6.add(l6, BorderLayout.NORTH);

		//add full panels to page
		page.add(pp1);
		page.add(pp2);
		page.add(pp3);
		page.add(pp4);
		page.add(pp5);
		page.add(pp6);
		
		//Adds page to window
		add(page);
		
		//Add top bar
		add(homePanel,BorderLayout.NORTH);
		add(page);
		
		//Adding listeners to button and combobox
		AccountListener al = new AccountListener();
		a.addActionListener(al);
		CartListener cl = new CartListener();
		c.addActionListener(cl);
		SignListener sl = new SignListener();
		s.addActionListener(sl);
		SearchListener sel = new SearchListener();
		search.addActionListener(sel);
		ComboListener coml = new ComboListener();
		productsTitle.addActionListener(coml);
		
		//Add to AccountPanel and Cart
	    JButton back = new JButton("Back");
	    account.add(back);	
	    back.addActionListener(bl);
	    JButton backc = new JButton("Back");
	    cart.add(backc);
	    backc.addActionListener(bl);
	    
		//Add to SignPanel
	    sign.setBackground(new Color(20,150,250));
	    sign.setBorder(new EmptyBorder(40,40,40,40));
	    JLabel title = new JLabel("Sign In Below");
	    sign.add(title);
	    loginbar.setColumns(20);
	    sign.add(loginbar);
	    loginbar.setFocusable(true);
	    
	    //Add Login Bar
	    JButton login = new JButton("Login");
	    sign.add(login);	
	    
	    //Add to cart
	    b1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Added to Cart");
                addToCart(b1.getText(), 1);
            }

        });
	    c1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Added to Cart");
                addToCart(c1.getText(), 2);
            }

        });
	    d1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Added to Cart");
                addToCart(d1.getText(), 3);
            }

        });
	    e1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Added to Cart");
                addToCart(e1.getText(), 4);
            }

        });
	    f1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Added to Cart");
                addToCart(f1.getText(), 5);
            }

        });
	    g1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Added to Cart");
                addToCart(g1.getText(), 6);
            }
        });
	    
	    //Load Featured Page
	    Brand f = new Brand();
	    f.find();
	}
	
	public void addToCart(String a,int b)
	{
		if(b == 1)
		{
			System.out.println("added 1 to cart");
        	//resets labels
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                	ca1.setText(a);	                
                }     
            });
            t.start();
    	    cart.add(ca1);
		}
		else if(b == 2)
		{
        	//resets labels
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                	ca2.setText(a);	                
                }     
            });
            t.start();
    	    cframe.add(ca2);
		}
		else if(b == 3)
		{
        	//resets labels
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                	ca3.setText(a);	                
                }     
            });
            t.start();
    	    cframe.add(ca3);
		}
		else if(b == 4)
		{
        	//resets labels
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                	ca4.setText(a);	                
                }     
            });
            t.start();
    	    cframe.add(ca4);
		}
		else if(b == 5)
		{
        	//resets labels
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                	ca5.setText(a);	                
                }     
            });
            t.start();
    	    cframe.add(ca5);
		}
		else if(b == 6)
		{
        	//resets labels
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                	ca6.setText(a);	                
                }     
            });
            t.start();
    	    cframe.add(ca6);
		}
	}
	
	//Open specific window when button is pressed
	public void Account()
	{
		aframe.setVisible(true);
	    account.setVisible(true);
	    aframe.add(account);
	}
	
	public void Cart()
	{
		cframe.setVisible(true);
	    cart.setVisible(true);
	    cframe.add(cart);
	}
	
	public void Sign()
	{
		sframe.setVisible(true);
	    sign.setVisible(true);
	    sframe.add(sign);
	}
	
	//Adds images to each panel
	public void image(String a,int j) 
	{   
		if(j==0)
			{		
			ImageIcon icon = new ImageIcon("C:\\StoreImages\\" + a + ".jpg");
			l1.setIcon(icon);	
			}
		else if(j==1)
    		{
			ImageIcon icon = new ImageIcon("C:\\StoreImages\\" + a + ".jpg");
			l2.setIcon(icon);	
			}
		else if(j==2)
			{		
			ImageIcon icon = new ImageIcon("C:\\StoreImages\\" + a + ".jpg");
	        l3.setIcon(icon);
			}		
		else if(j==3)
			{		
			ImageIcon icon = new ImageIcon("C:\\StoreImages\\" + a + ".jpg");
	        l4.setIcon(icon);	
			}		
		else if(j==4)
			{		
			ImageIcon icon = new ImageIcon("C:\\StoreImages\\" + a + ".jpg"); 
			l5.setIcon(icon);	
			}		
		else if(j==5)
			{
			ImageIcon icon = new ImageIcon("C:\\StoreImages\\" + a + ".jpg");
	        l6.setIcon(icon);
			}     
		}
	
//Listeners
class AccountListener implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		AccountView = true;
		productView = false;
		CartView = false;
		Sign = false;
		if(AccountView == true && signin == true)
		{
			System.out.println("Account page is up!");
			Account();
			frame.dispose();
		}
		else
			JOptionPane.showMessageDialog(frame,"You are not logged in!","Login Error",JOptionPane.ERROR_MESSAGE);
	}
}

class CartListener implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		CartView = true;
		AccountView = false;
		productView = false;
		Sign = false;
		if(CartView == true && signin == true)
		{
			Cart();
			System.out.println("Cart page is up!");
			frame.dispose();
		}
		else
			JOptionPane.showMessageDialog(frame,"You are not logged in!","Login Error",JOptionPane.ERROR_MESSAGE);
	}
}
class SignListener implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Sign = true;
		CartView = false;
		AccountView = false;
		productView = false;
		Sign();
		if(Sign == true)
			System.out.println("Sign In page is up!");
	}
}
class BackListener implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		CartView = false;
		AccountView = false;
		productView = false;
		Sign = false;
		if(CartView == false || AccountView == false || productView == false || Sign == false)
		{
				System.out.println("Back Home!");
				aframe.dispose();
				sframe.dispose();
				cframe.dispose();
				frame.setVisible(true);		
		}
	}
}

//Search Function
public class Function{
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    public ResultSet find(String s){
        try{
        //Search by Model
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javaapp?useSSL=false","root","pass");
        ps = con.prepareStatement("select Brand, Name, Price, ProductId from products where Name Like ?");
        ps.setString(1,s+"%");
        rs = ps.executeQuery();
        
        for(int i = 0;rs.next(); i++)
        {	
        	//Set Labels
        	if(i==0)
        		{
        		b ="            " + rs.getString(1) + " " + rs.getString(2) + " Price: $" + rs.getString(3) + ":"+ add;
            	image(rs.getString(4),0);
                }
        	else if(i==1)
            	{
        		ce ="            " + rs.getString(1) + " " + rs.getString(2) + " Price: $" + rs.getString(3) + ":"+ add;
            	image(rs.getString(4),1);
                }
            else if(i==2)
            	{
            	d ="            " + rs.getString(1) + " " + rs.getString(2) + " Price: $" + rs.getString(3) + ":"+ add;
            	image(rs.getString(4),2);
                }
            else if(i==3)
            	{
            	e ="            " + rs.getString(1) + " " + rs.getString(2) + " Price: $" + rs.getString(3) + ":"+ add;
            	image(rs.getString(4),3);
                }
            else if(i==4)
            	{
            	f ="            " + rs.getString(1) + " " + rs.getString(2) + " Price: $" + rs.getString(3) + ":"+ add;
            	image(rs.getString(4),4);
            	}
            else if(i==5)
         		{
            	g ="            " + rs.getString(1) + " " + rs.getString(2) + " Price: $" + rs.getString(3) + ":"+ add;
            	image(rs.getString(4),5);
                }

        	//resets labels
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                	b1.setText(b);	                	
                	c1.setText(ce);	                	
                	d1.setText(d);	                	
                	e1.setText(e);	                	
                	f1.setText(f);	
                	g1.setText(g);
                }     
            });
            t.start();
        }
        }catch(Exception ex){
           JOptionPane.showMessageDialog(null, "NUll");
           ex.printStackTrace();
        }
        return rs;
    }
}
//Combobox filter
public class Brand{
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    public ResultSet find(){
        try{
        con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javaapp?useSSL=false","root","pass");
        if(productsTitle.getSelectedIndex() == 0)
        	 ps = con.prepareStatement("select Brand, Name, Price, ProductId from products where Price > 600");
        else if(productsTitle.getSelectedIndex() == 1)
        	 ps = con.prepareStatement("select Brand, Name, Price, ProductId from products where Brand = 'Apple'");
        else if(productsTitle.getSelectedIndex() == 2) 
        	 ps = con.prepareStatement("select Brand, Name, Price, ProductId from products where Brand = 'Google'");
        else if(productsTitle.getSelectedIndex() == 3) 
        	 ps = con.prepareStatement("select Brand, Name, Price, ProductId from products where Brand = 'LG'");
        else if(productsTitle.getSelectedIndex() == 4) 
        	 ps = con.prepareStatement("select Brand, Name, Price, ProductId from products where Brand = 'Samsung'");
        else if(productsTitle.getSelectedIndex() == 5)
        	 ps = con.prepareStatement("select Brand, Name, Price, ProductId from products where Brand = 'Motorola'");
        else if(productsTitle.getSelectedIndex() == 6)
       	 	ps = con.prepareStatement("select Brand, Name, Price, ProductId from products order by Price ASC");
        else if(productsTitle.getSelectedIndex() == 7)
        	ps = con.prepareStatement("select Brand, Name, Price, ProductId from products order by Price DESC");
 
    	rs = ps.executeQuery();

        for(int i = 0;rs.next(); i++)
        {
        	if(i==0)
        		{b ="            " + rs.getString(1) + " " + rs.getString(2) + " Price: $" + rs.getString(3) + ":"+ add;
            	image(rs.getString(4),0);}
        	else if(i==1)
            	{ce ="            " + rs.getString(1) + " " + rs.getString(2) + " Price: $" + rs.getString(3) + ":"+ add;
            	image(rs.getString(4),1);}
            else if(i==2)
            	{d ="            " + rs.getString(1) + " " + rs.getString(2) + " Price: $" + rs.getString(3) + ":"+ add;
            	image(rs.getString(4),2);}
            else if(i==3)
            	{e ="            " + rs.getString(1) + " " + rs.getString(2) + " Price: $" + rs.getString(3) + ":"+ add;
            	image(rs.getString(4),3);}
            else if(i==4)
            	{f ="            " + rs.getString(1) + " " + rs.getString(2) + " Price: $" + rs.getString(3) + ":"+ add;
            	image(rs.getString(4),4);}
            else if(i==5)
        		{g ="            " + rs.getString(1) + " " + rs.getString(2) + " Price: $" + rs.getString(3) + ":"+ add;
            	image(rs.getString(4),5);}

        	//sets labels
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                	b1.setText(b);	                	
                	c1.setText(ce);	                	
                	d1.setText(d);	                	
                	e1.setText(e);	                	
                	f1.setText(f);	
                	g1.setText(g);
                }     
            });
            t.start();
        }
        }catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex.getMessage());
           ex.printStackTrace();
        }
        return rs;
    }
}
//Search bar listener
class SearchListener implements ActionListener
{
	Function f = new Function();
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if("".equals(searchbar.getText()))
				JOptionPane.showMessageDialog(frame, "Please enter a search key!", "Search Empty", JOptionPane.ERROR_MESSAGE);
		else 
			f.find(searchbar.getText());
	}
}
//Combobox listener
class ComboListener implements ActionListener
{
	Brand f = new Brand();
	@Override
	public void actionPerformed(ActionEvent e)
	{
			f.find();
	}
}
//Sets up main frame
	public static void frame()
	{
		//Creating frame for store
		frame.setSize(1200, 600);
		frame.setBackground(new Color(28,39,236));
		frame.setVisible(true);
		frame.setLocation(200, 200);		
		frame.setLocationRelativeTo(null);
	    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setTitle("Store");
	}
	//Account frame
	public static void aframe()
	{
		aframe.setVisible(false);
		aframe.setSize(1200, 600);
		aframe.setLocation(200, 200);
		aframe.setLocationRelativeTo(null);
	    //aframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    aframe.setTitle("Account");
	    
	    
	
	  	
	}
	//Sign in frame
	public static void sframe()
	{
		sframe.setVisible(false);
		sframe.setSize(400, 200);
		sframe.setLocation(200, 200);
		sframe.setLocationRelativeTo(null);
	    //sframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    sframe.setTitle("Sign In");
	     
	    
	}
	//Cart frame
	public static void cframe()
	{
		cframe.setVisible(false);
		cframe.setSize(1200, 600);
		cframe.setLocation(200, 200);
		cframe.setLocationRelativeTo(null);
	    //cframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
	    cframe.setTitle("Cart");
	    
	}
	
//Main
	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		frame();
		aframe();
		cframe();
		sframe();
		/*Load Driver
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");	
		//Connect to Database													//Database    //User    //Password
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/storefront", "k", "brumaghin30");
		System.out.println("Database connected");
		//Insert
	    String query = " insert into login (id, Username)" + " values (?, ?)";
	    PreparedStatement prep = connection.prepareStatement(query);
	    prep.setString(1,"002");
	    prep.setString(2, "Rob1");
	    prep.execute();
		Select
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select ProductID, Brand, Name, Price from products");	
		while (resultSet.next())
			System.out.println(resultSet.getString(1) + "\n" + resultSet.getString(2) + "\n" + resultSet.getString(3) + "\n" + resultSet.getString(4));
		connection.close();
		*/
	}
}