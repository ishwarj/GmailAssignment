package com.te.mock.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class Account implements Serializable {
	@Id
	private int user_id;
	private String User_name;
	private String password;
	private String email;
	public Account() {
		super();
	}
	
	

}
