package com.te.mock.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Inbox implements Serializable {
	@Id
	private  int message_id;
	private  int user_id;
	private String message;
	public Inbox() {
		super();
	}
	
	


	

}
