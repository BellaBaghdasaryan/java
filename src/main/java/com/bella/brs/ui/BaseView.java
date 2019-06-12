package com.bella.brs.ui;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Bella Baghdasaryan
 */
@SuppressWarnings("serial")
public abstract class BaseView extends JPanel{
	
	ArrayList<JTextField> inputFields;
	
	public BaseView() {
		this.setLayout(null);
		this.inputFields = new ArrayList<JTextField>();
	}
	
	/**
	 * Clears all input and repaints the panel.
	 */
	public void refresh(){
		inputFields.forEach(field -> field.setText(null));
		this.revalidate();
	}
}