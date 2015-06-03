package com.google.spring.controllers;


public class Response<T> {
	
	public String tag;
	public T response;
	
	
	
	public Response(String tag, T response) {
		super();
		this.tag = tag;
		this.response = response;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}
	

}
