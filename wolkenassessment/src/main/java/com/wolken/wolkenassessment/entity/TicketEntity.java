package com.wolken.wolkenassessment.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor

public class TicketEntity{
	@Id
	@GenericGenerator(name = "ticketId",strategy = "increment")
	@GeneratedValue(generator = "ticketId")
	private int ticketId;
	private String agentId;
	private String requestType;
	private String issue;
	private Date date;
	private String productId;
	private String productName;
	private String urgency;
	private String status;
	private String assignedTo;
	@ManyToOne(targetEntity = UserEntity.class)
	@JsonIgnore
	private UserEntity userEntity;

}
