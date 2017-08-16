package mz_A_One;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;


public class myMenuApp {

	private JFrame frameFirst = new JFrame();	
	public  JFrame frameZz = new JFrame(); // frame2


	/* Launch the application */ 
	
	public static void main(String[] args) {	
		new myMenuApp();		
	}

	/*           Create the application.	 */

	public myMenuApp() {
		initialize();
	}

	/* Initialize the contents of the frame.  */	
	private void initialize() {						
		
		frameFirst.setVisible(true);		
		
		JMenuBar menuBar = new JMenuBar();
		frameFirst.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("My first menu item");
		mnNewMenu.add(mntmNewMenuItem);		
		
		
		mntmNewMenuItem.addActionListener( new ActionListener() {
			
		public void actionPerformed( ActionEvent e ) {
		    //frame.dispose();
			frameZz.setVisible(true);				
		}										
		
		});						
		
		JMenu mnNewMenu_1 = new JMenu("Another Menu");
		menuBar.add(mnNewMenu_1);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("New radio item");
		mnNewMenu_1.add(rdbtnmntmNewRadioItem);
	}
}
