package com.rabbit.spring.model;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 6351128927224536558L;
	private String name;
	private String pw;
	
	public User(String name, String pw){
		this.name = name;
		this.pw = pw;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
}
