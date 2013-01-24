package com.tti.accscms.dao;

public class DaoException extends Exception {
	private static final long serialVersionUID = 1449823307824945748L;
	
	public DaoException(String message) {
		super(message);
	}
	
	public DaoException(Exception e) {
		super(e.getMessage(), e.getCause());
	}
}
