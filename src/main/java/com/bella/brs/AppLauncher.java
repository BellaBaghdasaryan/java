package com.bella.brs;

import java.awt.EventQueue;

import com.bella.brs.ui.MasterView;

/**
 * The main launcher for java bus reservation system application. Creates the
 * {@code MasterView} object.
 * 
 * @author Bella Baghdasaryan
 * @version 2.0
 * @see MasterView
 */
public class AppLauncher {

	/**
	 * @param args
	 *            Currently no arguments required to be passed to this program.
	 */
	public static void main(String[] args) {

		// Use the event dispatch thread for Swing components
		EventQueue.invokeLater(new Runnable() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see java.lang.Runnable#run()
			 */
			@Override
			public void run() {
				new MasterView();
			}
		});
	}

}
