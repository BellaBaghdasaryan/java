package com.bella.brs.controller;

import java.awt.event.ActionEvent;

import org.springframework.dao.EmptyResultDataAccessException;

import com.bella.brs.model.entity.Reserve;
import com.bella.brs.model.service.ReserveService;
import com.bella.brs.ui.Alert;
import com.bella.brs.ui.CancellationTabView;
import com.bella.brs.ui.View;
import com.bella.brs.utility.constants.Messages;

/**
 * @author Bella Baghdasaryan
 */
public class CancellationController implements Controller{
	
	private CancellationController _this;
	
	private CancellationTabView cancellationTab;
	private Reserve reserve;
	private ReserveService reserveService;
	
    public CancellationController(View cancellationTab) {
    	_this = this;
    	this.cancellationTab = (CancellationTabView) cancellationTab;
    	this.reserve = new Reserve();
    }
    
    public void control(Controller parentController){
    	
    	reserve.setPassengerID(((HomeTabsMediator)parentController).getPassengerService().getModel().getId());
    	
    	cancellationTab.getSubmitButton().addActionListener(new ActionAdapter() {
			
			public void actionPerformed(ActionEvent ae) {
				if(cancellationTab.validateFields()){
					reserve.setId(cancellationTab.getTicketNumber());
					try{
						if(_this.cancelTicket()){
							Alert.successMessage(Messages.CANCEL_SUCCESS);
						}else{
							Alert.errorMessage(Messages.NO_ACCESS_TO_CANCEL);
						}
					}catch(EmptyResultDataAccessException e){
						Alert.errorMessage(Messages.UNKNOWN_TICKET_NO);
					}
				}
			}
			
		});
    	
    }
    
    private boolean cancelTicket(){
    	if(reserveService == null){
    		reserveService = new ReserveService();
    	}
    	reserveService.setModel(reserve);
    	return reserveService.cancelTicket();
    }
        
}