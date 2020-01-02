package com.prakash.springboot.test.SprinBootTest.Helloworld;

public class Helloworldbean {
	
	private String Message;

	public Helloworldbean(String message) {
		super();
		this.Message = message;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		this.Message = message;
	}

	@Override
	public String toString() {
		return "Helloworldbean [Message=" + Message + "]";
	}
	
	
	
	
	

}
