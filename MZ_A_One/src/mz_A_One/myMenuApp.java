package mz_A_One;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;


public class myMenuApp {
	
	private JFrame frameFirst;
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
		frameFirst.setBounds(100, 100, 750, 900);				
	    //
		frameFirst.getContentPane().setLayout(null); // very important
		//
		JButton registerButton = new JButton("REGISTER");
		registerButton.setBounds(33, 205, 101, 23);
		frameFirst.getContentPane().add(registerButton);
		//		 		
		
		JMenuBar menuBar = new JMenuBar();
		frameFirst.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("My first menu item");
		mnNewMenu.add(mntmNewMenuItem);		
		
		/******
		mntmNewMenuItem.addActionListener( new ActionListener() {
			
		public void actionPerformed( ActionEvent e ) {		   					
			
			// from Matt - registerButton
					 						
			//loginButton.setBounds(114, 205, 96, 23);											
			
			//JTextField usernameField = new JTextField();
			//usernameField.setBounds(153, 85, 134, 20);
			//frameZz.getContentPane().add(usernameField);
			//usernameField.setColumns(10);
			
			//JTextField passwordField = new JTextField();
			//passwordField.setBounds(153, 123, 134, 20);
			//frameZz.getContentPane().add(passwordField);
			//passwordField.setColumns(10);			
			
			 
			// frameZz.setVisible(true);
			// frameFirst.dispose();							
			//
		}											
		});						
		*****/
		
		
		 mntmNewMenuItem.addActionListener( new ActionListener() {
			
		 public void actionPerformed( ActionEvent e ) {		   					
			
			frameZz.setBounds(600, 100, 300, 400);
			JTextField passwordFieldZ = new JTextField();
			passwordFieldZ.setBounds(153, 123, 134, 20);
			frameZz.getContentPane().add(passwordFieldZ);
			passwordFieldZ.setColumns(10);				
			 
			frameZz.setVisible(true);
			//frameFirst.dispose();								
		 }											
		});						
		
		 
		JButton loginButton = new JButton("LOGIN");
		loginButton.setBounds(143, 205, 101, 23);
		frameFirst.getContentPane().add(loginButton);
		
		/**
		JMenu mnNewMenu_1 = new JMenu("Another Menu");
		menuBar.add(mnNewMenu_1);
		**/
		
	}
}
