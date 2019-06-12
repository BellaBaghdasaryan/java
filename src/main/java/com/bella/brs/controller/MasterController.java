package com.bella.brs.controller;

import com.bella.brs.model.Model;
import com.bella.brs.model.entity.Bus;
import com.bella.brs.model.entity.Passenger;
import com.bella.brs.model.service.PassengerService;
import com.bella.brs.model.service.Service;
import com.bella.brs.ui.BannerViewPanel;
import com.bella.brs.ui.BusSelectionView;
import com.bella.brs.ui.HomeTabsPanelView;
import com.bella.brs.ui.LoginPanelView;
import com.bella.brs.ui.MasterView;
import com.bella.brs.ui.RegistrationPanelView;
import com.bella.brs.ui.SeatSelectionView;
import com.bella.brs.ui.View;

/**
 * @author Bella Baghdasaryan
 */
public class MasterController implements Controller{
	
	private MasterView masterView;
	private View bannerView;
	private Service passengerService;
    
	public MasterController(MasterView masterView) {
    	this.masterView = masterView;
    }
    
      
    public void control(Controller parentController){
    	this.bannerView = new BannerViewPanel();
    	this.loginControl();
    	//this.autoLoginControl();
    }
    
    public void loginControl(){
    	View loginForm = new LoginPanelView();
    	
    	masterView.clear();
    	masterView.insertPanel(bannerView, "north");
    	masterView.insertPanel(loginForm, "center");
    	
    	Controller loginController = new LoginController(loginForm);
    	loginController.control(this);
    }
    
    public void autoLoginControl(){
        	Passenger passenger = new Passenger();
        	passenger.setUsername("test");
        	passenger.setPassword("test");
        	passengerService = new PassengerService();
        	((PassengerService)passengerService).setModel(passenger);
        	((PassengerService)passengerService).login();
        	this.setPassengerService(passengerService);
    		this.applicationControl();
    }
    
    public void registrationControl(){
    	View registrationPanelView = new RegistrationPanelView();
    	
    	masterView.clear();
    	masterView.insertPanel(bannerView, "north");
    	masterView.insertPanel(registrationPanelView, "center");
    	
    	Controller registrationController = new RegistrationController(registrationPanelView);
    	registrationController.control(this);
    }
    
    public void applicationControl(){
    	View homeTabs = new HomeTabsPanelView();
    	
    	masterView.clear();
    	masterView.insertPanel(bannerView, "north");
    	masterView.insertPanel(homeTabs, "center");
    	
    	HomeTabsMediator homeTabsMediator = new HomeTabsMediator(homeTabs);
    	homeTabsMediator.control(this);   	
    }
    
    public void busSelectionControl(Model route, String date){
    	View busSelection = new BusSelectionView();
    	
    	masterView.clear();
    	masterView.insertPanel(busSelection, "center");
    	
    	BusSelectionController busSelectionController = new BusSelectionController(busSelection,route, date);
    	busSelectionController.control(this);   	
    }
    
    public void seatSelectionControl(Model route, String date, Bus bus){
    	View seatSelection = new SeatSelectionView();
    	
    	masterView.clear();
    	masterView.insertPanel(seatSelection, "center");
    	
    	SeatSelectionController seatSelectionController = new SeatSelectionController(seatSelection, route, date, bus);
    	seatSelectionController.control(this);   	
    }
    
    public Service getPassengerService() {
		return passengerService;
	}

	public void setPassengerService(Service passengerService) {
		this.passengerService = passengerService;
	}
    
}