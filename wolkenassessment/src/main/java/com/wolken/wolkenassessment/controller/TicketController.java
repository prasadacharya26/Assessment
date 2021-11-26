package com.wolken.wolkenassessment.controller;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.wolken.wolkenassessment.dto.TicketDTO;
import com.wolken.wolkenassessment.service.TicketService;


@RestController
public class TicketController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	TicketService ticketService;
	
	@PostMapping("saveTicket")
	String saveTicket(@RequestBody TicketDTO ticketDTO) {
		String message = null;
		try {
			message = ticketService.validateAndAddTicket(ticketDTO);
		} catch (Exception e) {
			logger.error(e.getMessage(),e.getClass().getSimpleName());
		}
		return message;
	}
	
	@GetMapping("allTicket")
	List<TicketDTO> allTicket(){
		List<TicketDTO> ticketDTOs = null;
		try {
			ticketDTOs = ticketService.validateAndGetAll();
		} catch (Exception e) {
			logger.error(e.getMessage(),e.getClass().getSimpleName());
		}
		return ticketDTOs;
	}
	
	@PostMapping("updateTicket")
	String updateTicket(@RequestBody TicketDTO ticketDTO) {
		String message = null;
		try {
			message = ticketService.updateTicketById(ticketDTO);
		} catch (Exception e) {
			logger.error(e.getMessage(),e.getClass().getSimpleName());
		}
		return message;
	}
	
	@PutMapping("updateStatus")
	String updateStatus(@RequestParam int ticketId,String status) {
		String message = null;
		try {
			message = ticketService.updateStatusById(ticketId,status);
		} catch (Exception e) {
			logger.error(e.getMessage(),e.getClass().getSimpleName());
		}
		return message;
	}
	
	@GetMapping("checkProgress")
	TicketDTO checkProgress(@RequestParam int tickedId) {
		TicketDTO ticketDTO = null;
		try {
			ticketDTO = ticketService.checkProgress(tickedId);
		} catch (Exception e) {
			logger.error(e.getMessage(),e.getClass().getSimpleName());
		}
		return ticketDTO;
	}
	
	@PostMapping("saveAll")
	String saveAll(@RequestBody List<TicketDTO> ticketDTO) {
		String message = null;
		try {
			message = ticketService.validateAndSaveAll(ticketDTO);
		} catch (Exception e) {
			logger.error(e.getMessage(),e.getClass().getSimpleName());
		}
		return message;
	}
	
	@ExceptionHandler(value = {HttpMessageNotReadableException.class, MethodArgumentTypeMismatchException.class,ConstraintViolationException.class})
	String exception() {
		return "Invalid format/Invalid user id";
	}
}
