package com.example.model;

public class ErrorResponse {
	private String _message;
	private String _cause;
	private int _status;
	
	public ErrorResponse(String message, String cause, int status) {
		super();
		_message = message;
		_cause = cause;
		_status = status;
	}
	public String getMessage() {
		return _message;
	}
	public void setMessage(String message) {
		_message = message;
	}
	public String getCause() {
		return _cause;
	}
	public void setCause(String cause) {
		_cause = cause;
	}
	public int getStatus() {
		return _status;
	}
	public void setStatus(int status) {
		_status = status;
	}
}
