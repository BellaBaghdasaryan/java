package com.bella.brs.controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;

import org.springframework.dao.EmptyResultDataAccessException;

import com.bella.brs.model.Model;
import com.bella.brs.model.bean.ReservationBean;
import com.bella.brs.model.entity.Bus;
import com.bella.brs.model.entity.Reserve;
import com.bella.brs.model.entity.Route;
import com.bella.brs.model.service.PassengerService;
import com.bella.brs.model.service.ReserveService;
import com.bella.brs.ui.Alert;
import com.bella.brs.ui.SeatSelectionView;
import com.bella.brs.ui.View;
import com.bella.brs.utility.DateUtil;
import com.bella.brs.utility.constants.Messages;

/**
 * @author Bella Baghdasaryan
 */
public class SeatSelectionController implements Controller{
	
	private SeatSelectionController _this;
	
	private SeatSelectionView seatSelectionView;
	private Route route;
	private String date;
	private Bus bus;
	private int pid;
	private ReserveService reserveService;
	private List<ReservationBean> tickets = new ArrayList<ReservationBean>();
	
	
    public SeatSelectionController(View seatSelectionView, Model route, String date, Bus bus) {
    	_this = this;
    	this.seatSelectionView = (SeatSelectionView) seatSelectionView;
    	this.route = (Route) route;
    	this.date = date;
    	this.bus = bus;
    }
    
    public void control(Controller parentController){
    	MasterController masterController = (MasterController) parentController;
    	
    	pid = ((PassengerService) masterController.getPassengerService()).getModel().getId();
    	
    	this.populateSeats();
    	
    	seatSelectionView.getBackButton().addActionListener(new ActionAdapter() {
			public void actionPerformed(ActionEvent ae) {
				masterController.busSelectionControl(route, date);
			}
		});
    	
    	seatSelectionView.getBookButton().addActionListener(new ActionAdapter() {
			public void actionPerformed(ActionEvent ae) {
				for (JCheckBox seat : seatSelectionView.getSeats()) {
					if(seat.isSelected()){
						_this.reserve(Integer.parseInt(seat.getActionCommand()));
					}
				}
				if(!tickets.isEmpty()){
					reserveService.printTickets(tickets);
					masterController.applicationControl();
				}else{
					Alert.successMessage(Messages.NO_SEAT_SELECTED);
				}
			}
		});
    	
    }
    
    private void populateSeats() {
    	if (reserveService == null) {
    		reserveService = new ReserveService();
    	}
		try {
			List<Integer> occupiedSeatNumbers = reserveService.getOccupiedSeatNumbers(bus.getId(), date);
			
			for (Integer occupiedSeat : occupiedSeatNumbers) {
				seatSelectionView.disableSeat(occupiedSeat);
			}	

		} catch (EmptyResultDataAccessException e) {
			System.out.print("No Seats");
		}		
	}
    
    private void reserve(int seatNumber) {
    	if (reserveService == null) {
    		reserveService = new ReserveService();
    	}
		try{
			Reserve reserve = new Reserve();
			reserve.setPassengerID(pid);
			reserve.setBusID(bus.getId());
			reserve.setDt(date);
			reserve.setTstamp(DateUtil.getTimeStamp());
			reserve.setSeat(seatNumber);
			int ticketNum = reserveService.reserve(reserve);
			
			reserve.setId(ticketNum);
			
			ReservationBean reservationBean = new ReservationBean(reserve);
			reservationBean.setOrigin(route.getOrigin());
			reservationBean.setDestination(route.getDestination());
			reservationBean.setArrivaltime(bus.getArrivalTime());
			reservationBean.setDeparturetime(bus.getDepartureTime());
			
			tickets.add(reservationBean);
		} catch (EmptyResultDataAccessException e) {
			System.out.print("Reservation Failed");
		}		
	}
    
    
}