package com.wolken.wolkenassessment.service;

import java.util.List;

import com.wolken.wolkenassessment.dto.TicketDTO;

public interface TicketService {

	String validateAndAddTicket(TicketDTO ticketDTO);

	List<TicketDTO> validateAndGetAll();

	String updateTicketById(TicketDTO ticketDTO);

	String updateStatusById(int ticketId, String status);
	
	String saveAll(List<TicketDTO> ticketDTOs);

	TicketDTO checkProgress(int tickedId);

	String validateAndSaveAll(List<TicketDTO> ticketDTO);
}
