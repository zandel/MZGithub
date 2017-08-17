package mz_A_One;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

import java.sql.*;

import java.awt.event.*;
import java.awt.EventQueue;


public class myMenuApp extends DBConnection{
	
	private JFrame frameFirst;
	
	private JTextField textField;
	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField idField;

	
	public  JFrame frameZz = new JFrame(); // frame2
	
	/* Launch the application */ 
	
	public static void main(String[] args) {	
		myMenuApp window = new myMenuApp();
		window.frameFirst.setVisible(true);
	}

	/* Create the application	*/

	public myMenuApp() {
		initialize();
	}

	/* Initialize the contents of the frame.  */	
	private void initialize() {
		//
		frameFirst = new JFrame();
		frameFirst.setTitle("Manage User Records");
		frameFirst.setBounds(100, 100, 750, 900);				
	    //
		textField = new JTextField();
		//frameFirst.getContentPane().add(textField, BorderLayout.CENTER);
		//
		frameFirst.getContentPane().setLayout(null); // very important
		//
		JButton registerButton = new JButton("ADD USER");
		registerButton.setBounds(203, 205, 101, 23);
		frameFirst.getContentPane().add(registerButton);
		//
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt( idField.getText() );
				
				String username = usernameField.getText();
				String password = passwordField.getText();
				//				
				registerDetails( id, username, password );								
				openConfirmBox();
			}
		});		// end of addActionListener
		
		JMenuBar menuBar = new JMenuBar();
		frameFirst.setJMenuBar(menuBar);
		menuBar.add(Box.createRigidArea(new Dimension(20,55)));
		
		JMenu mnNewMenu = new JMenu("Query User Table ");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Display usename/password");
		mnNewMenu.add(mntmNewMenuItem);						
		
		mntmNewMenuItem.addActionListener( new ActionListener() {			
		public void actionPerformed( ActionEvent e ) {
				
			//
			String driverName = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/onlinejobseek";
			String userName = "root";
			String password = "";
			
			String[] columnNames = {"Student Name", "Student Password"};					
			
			
			frameZz.setLayout(new BorderLayout());	
			DefaultTableModel model = new DefaultTableModel();			
			model.setColumnIdentifiers(columnNames);
			
			JTable table =  new JTable();			
			table.setModel(model);
			
			
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			table.setFillsViewportHeight(true);												
			
			JScrollPane scroll = new JScrollPane(table);
			scroll.setHorizontalScrollBarPolicy(
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scroll.setVerticalScrollBarPolicy(
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);								
			/***********************************/
			String name= "";
			String cl = "";						
			try 
			{			
				Class.forName(driverName);		
				Connection con = DriverManager.getConnection(url, userName, password);				
				String sql = "select student_name, student_password from student_login";				
				
				PreparedStatement ps = con.prepareStatement(sql);
		        ResultSet rs = ps.executeQuery();
		        int i =0;		        				
		        while(rs.next()) { 
		        {														
					name = rs.getString("student_name");
					cl = rs.getString("student_password");										
					model.addRow(new Object[]{name, cl});
					i++;				
		        }
		        /********************
				if(i <1)
				{
					JOptionPane.showMessageDialog(null, "No Record Found","Error",
							JOptionPane.ERROR_MESSAGE);
				}
				if(i ==1)
				{
				System.out.println(i+" Record Found");
				}
				else
				{
					System.out.println(i+" Records Found");
				}
				***************/
		        }
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",
						JOptionPane.ERROR_MESSAGE);
			}			
			
			frameZz.setBounds(400, 200, 500, 600);
			frameZz.setVisible(true);			
			frameZz.add(scroll);	// very important						
		 }											
		});	// end of addActionListener			 					
		
		
		JTextField passwordFieldZ = new JTextField();
		// passwordFieldZ.setBounds(153, 123, 134, 20);
		
		frameZz.getContentPane().add(passwordFieldZ);
		passwordFieldZ.setColumns(10);						 
		
        usernameField = new JTextField();
        usernameField.setBounds(153, 85, 134, 20);
        frameFirst.getContentPane().add(usernameField);
        usernameField.setColumns(10);

        passwordField = new JTextField();
        passwordField.setBounds(153, 123, 134, 20);
        frameFirst.getContentPane().add(passwordField);
        passwordField.setColumns(10);

JLabel lblUsername = new JLabel("Username");
lblUsername.setBounds(85, 88, 66, 14);
frameFirst.getContentPane().add(lblUsername);

JLabel lblPassword = new JLabel("Password");
lblPassword.setBounds(86, 126, 65, 14);
frameFirst.getContentPane().add(lblPassword);
usernameField.setColumns(10);

idField = new JTextField();
idField.setBounds(170, 48, 86, 20);
frameFirst.getContentPane().add(idField);
idField.setColumns(10);

JLabel lblId = new JLabel("ID");
lblId.setBounds(97, 51, 31, 14);
frameFirst.getContentPane().add(lblId);

	}
	public void openConfirmBox() {
		idField.setText("");
		usernameField.setText("");
		passwordField.setText("");
		
		JOptionPane.showMessageDialog( frameFirst, "User Registered!" );
		
	}
} // end of public class myMenuApp
