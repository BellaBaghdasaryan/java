package com.bella.brs.ui;

import javax.swing.JOptionPane;

/**
 * @author Bella Baghdasaryan
 */
public class Alert {
	public static final void errorMessage(String mesg){
		JOptionPane.showMessageDialog(null, mesg, "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public static final void successMessage(String mesg){
		JOptionPane.showMessageDialog(null, mesg, "Success", JOptionPane.PLAIN_MESSAGE);
	}
}