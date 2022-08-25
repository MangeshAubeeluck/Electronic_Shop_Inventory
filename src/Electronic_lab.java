import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Electronic_lab {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Electronic_lab window = new Electronic_lab();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
   
	/**
	 * Create the application.
	 */
	public Electronic_lab() {
		initialize();
		Connect();
		table_load();
		table_load_1();
	}
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField textField_8;
	 
	public void Connect()
	    {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/javacrud", "root","");
	        }
	        catch (ClassNotFoundException ex)
	        {
	          ex.printStackTrace();
	        }
	        catch (SQLException ex)
	        {
	            ex.printStackTrace();
	        }
	 
	    }
	public void table_load()
    {
    	try 
    	{
	    pst = con.prepareStatement("select id,name,price,quantity from electronic_lab");
	    rs = pst.executeQuery();
	    table_1.setModel(DbUtils.resultSetToTableModel(rs));
	} 
    	catch (SQLException e) 
    	 {
    		e.printStackTrace();
	  } 
    }
	
	public void table_load_1()
    {
    	try 
    	{
	    pst = con.prepareStatement("select name,quantity,supplier_name,supplier_contacts from electronic_lab where quantity<=5 ");
	    rs = pst.executeQuery();
	    table.setModel(DbUtils.resultSetToTableModel(rs));
	} 
    	catch (SQLException e) 
    	 {
    		e.printStackTrace();
	  } 
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1195, 926);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Electronics Lab");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 234, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(35, 78, 505, 493);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(50, 32, 73, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(50, 73, 53, 30);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Category");
		lblNewLabel_2_1.setBounds(50, 159, 53, 30);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Description");
		lblNewLabel_2_2.setBounds(50, 118, 53, 30);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3 = new JLabel("Supplier name");
		lblNewLabel_3.setBounds(50, 215, 85, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Supplier Contact");
		lblNewLabel_3_1.setBounds(50, 262, 85, 14);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Price");
		lblNewLabel_3_2.setBounds(50, 297, 73, 14);
		panel.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Quantity");
		lblNewLabel_3_3.setBounds(50, 336, 53, 24);
		panel.add(lblNewLabel_3_3);
		
		textField = new JTextField();
		textField.setBounds(176, 42, 258, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3_4 = new JLabel("New label");
		lblNewLabel_3_4.setBounds(232, 40, 46, 14);
		panel.add(lblNewLabel_3_4);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(176, 78, 258, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(176, 123, 258, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(176, 164, 258, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(176, 212, 258, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(176, 259, 258, 20);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(176, 294, 258, 20);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(176, 338, 258, 20);
		panel.add(textField_7);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID,name,Description, Cateogory,Supplier_name,Supplier_contact,Price,Quantity;
				ID= textField.getText();
				name= textField_1.getText();
				Description = textField_2.getText();
				Cateogory = textField_3.getText();
				Supplier_name = textField_4.getText();
				Supplier_contact= textField_5.getText();
				Price=textField_6.getText();
				Quantity=textField_7.getText();
				try {
					pst = con.prepareStatement("insert into electronic_lab(id,name,Description,Category,supplier_name,supplier_contacts,Price,quantity)values(?,?,?,?,?,?,?,?)");
					pst.setString(1, ID);
					pst.setString(2, name);
					pst.setString(3, Description);
					pst.setString(4, Cateogory);
					pst.setString(5, Supplier_name);
					pst.setString(6, Supplier_contact);
					pst.setString(7, Price);
					pst.setString(8, Quantity);
					
					
					
					
		
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Product Addedddd!!!!!");
					table_load();
					table_load_1();
					
					
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					textField_7.setText("");
				}
					
					
				catch (SQLException e1)
		        {
		e1.printStackTrace();
		
		        }
				
			}
		});
		btnNewButton.setBounds(50, 410, 115, 42);
		panel.add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String bid;
				bid  = textField_8.getText();
				
				 try {
						pst = con.prepareStatement("delete from electronic_lab where id =?");
				
			            pst.setString(1, bid);
			            pst.executeUpdate();
			            JOptionPane.showMessageDialog(null, "Record Delete!!!!!");
			            table_load();
			            table_load_1();
			            
		            	textField.setText("");
		            	textField_1.setText("");
		            	textField_2.setText("");
		            	textField_3.setText("");
		            	textField_4.setText("");
		            	textField_5.setText("");
		            	textField_6.setText("");
		            	textField_7.setText("");
			            
			           
			            
					}

        catch (SQLException e1) {
			
			e1.printStackTrace();
		}
			}
		});
		btnDelete.setBounds(212, 410, 115, 42);
		panel.add(btnDelete);
		
		JButton btnNewButton_1_1 = new JButton("Update");
		btnNewButton_1_1.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
				String id,name,Description, Cateogory,Supplier_name,Supplier_contact,Price,Quantity;
				id= textField.getText();
				name= textField_1.getText();
				Description = textField_2.getText();
				Cateogory = textField_3.getText();
				Supplier_name = textField_4.getText();
				Supplier_contact= textField_5.getText();
				Price=textField_6.getText();
				Quantity=textField_7.getText();
				
				
				
				
				
				
				
				 try {
					    pst = con.prepareStatement("update electronic_lab set name=?,Description=?,Category=?,supplier_name=?,supplier_contacts=?,Price=?,quantity=? where id=?");
						pst.setString(2, name);
						pst.setString(3, Description);
						pst.setString(4, Cateogory);
						pst.setString(5, Supplier_name);
						pst.setString(6, Supplier_contact);
						pst.setString(7, Price);
						pst.setString(8, Quantity);
			            pst.executeUpdate();
			            JOptionPane.showMessageDialog(null, "Record Update!!!!!");
			            table_load();
			           
			           
		            	textField_1.setText("");
		            	textField_2.setText("");
		            	textField_3.setText("");
		            	textField_4.setText("");
		            	textField_5.setText("");
		            	textField_6.setText("");
		            	textField_7.setText("");
			           
					}

		            catch (SQLException e1) {
						
						e1.printStackTrace();
					}
	
			}
			
		});
		btnNewButton_1_1.setBounds(365, 410, 115, 42);
		panel.add(btnNewButton_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(36, 676, 1143, 179);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1109, 157);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_4 = new JLabel("Item to be reorder");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(35, 636, 363, 35);
		frame.getContentPane().add(lblNewLabel_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(563, 78, 606, 493);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 586, 471);
		panel_2.add(scrollPane_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_2.setViewportView(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_5 = new JLabel("All_Products");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(585, 25, 142, 23);
		frame.getContentPane().add(lblNewLabel_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(35, 583, 505, 62);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Item Search By ID");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(0, 23, 180, 28);
		panel_3.add(lblNewLabel_6);
		
		textField_8 = new JTextField();
		textField_8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
			          
		            String id =textField_8.getText();

		                pst = con.prepareStatement("select id,name,Description,Category,supplier_name,supplier_contacts,Price,quantity from electronic_lab where id = ?");
		                pst.setString(1, id);
		                ResultSet rs = pst.executeQuery();
		                

		            if(rs.next()==true)
		            {
		            	String ID  = rs.getString(1);
		                String name = rs.getString(2);
		                String Description = rs.getString(3);
		                String Cateogory = rs.getString(4);
		                String Supplier_name = rs.getString(5);
		                String Supplier_contact = rs.getString(6);
		                String Price = rs.getString(7);
		                String Quantity = rs.getString(8);
		                
		                
		                
		                
		                textField.setText(ID);
		            	textField_1.setText(name);
		            	textField_2.setText(Description);
		            	textField_3.setText(Cateogory);
		            	textField_4.setText(Supplier_name);
		            	textField_5.setText(Supplier_contact);
		            	textField_6.setText(Price);
		            	textField_7.setText(Quantity);
		                
		                
		            }   
		            else
		            {
		            	textField.setText("");
		            	textField_1.setText("");
		            	textField_2.setText("");
		            	textField_3.setText("");
		            	textField_4.setText("");
		            	textField_5.setText("");
		            	textField_6.setText("");
		            	textField_7.setText("");
		                 
		            }
		            


		        } 
			
			 catch (SQLException ex) {
		           
		        }
				
			}
			
			
		});
		textField_8.setBounds(177, 29, 312, 20);
		panel_3.add(textField_8);
		textField_8.setColumns(10);
	}
}
