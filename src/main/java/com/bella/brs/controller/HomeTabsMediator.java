package com.bella.brs.controller;

import java.awt.event.ActionEvent;

import javax.swing.event.ChangeEvent;

import com.bella.brs.model.service.PassengerService;
import com.bella.brs.ui.CancellationTabView;
import com.bella.brs.ui.HomeTabsPanelView;
import com.bella.brs.ui.ReservationHistoryTabView;
import com.bella.brs.ui.ReservationTabView;
import com.bella.brs.ui.View;

/**
 * @author Bella Baghdasaryan
 */
public class HomeTabsMediator implements Controller{
	
	private HomeTabsMediator _this;
	private MasterController masterController;
	
	private HomeTabsPanelView homeTabs;
	private CancellationController cancellationController;
	private ReservationHistoryController historyTabController;
	private ReservationController reservationController;
	private PassengerService passengerService;
	
    public HomeTabsMediator(View homeTabs) {
    	_this = this;
    	this.homeTabs = (HomeTabsPanelView) homeTabs;
    }
    
    public void control(Controller parentController){
    	masterController = (MasterController) parentController;
    	passengerService = (PassengerService) masterController.getPassengerService();
    	
    	View reservationTab = new ReservationTabView();
    	View cancelTab = new CancellationTabView();
    	View historyTab = new ReservationHistoryTabView();
    	
    	homeTabs.insertTab(reservationTab, "Reservation ");
    	homeTabs.insertTab(cancelTab, "Cancel ticket ");
    	homeTabs.insertTab(historyTab, "History ");
    	homeTabs.setWelcome(passengerService.getModel().getName());
    	
    	
    	/*
		 * Initializing elements and setting styles.
		 */
		/*try {
			reservationPanel = new ReservationPanel(mainFrame);
		} catch (DBConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
    	
    	reservationController = new ReservationController(reservationTab);
    	reservationController.control(this);
    	
    	cancellationController = new CancellationController(cancelTab);
    	cancellationController.control(this);
    	
    	historyTabController = new ReservationHistoryController(historyTab);
    	historyTabController.control(this);
    	
    	
    	
    	/**
		 *  On clicking logout button, control goes back login form.
		 */
    	homeTabs.getLogoutButton().addActionListener(new ActionAdapter() {
    		
    		@Override
			public void actionPerformed(ActionEvent ae) {
				masterController.loginControl();
			}
		});
    	
    	homeTabs.getTabs().addChangeListener(new ChangeAdapter() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				_this.updateTabs();
			}
		});
    	
    }
    
    public MasterController getMasterController() {
		return masterController;
	}

	public PassengerService getPassengerService() {
		return passengerService;
	}
    
    public void updateTabs(){
    	historyTabController.populateReservationHistoryTable();
    }
        
}