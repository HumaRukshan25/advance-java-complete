package org.jsp.sms.exceptionclassess;

public class NoStudentException extends RuntimeException {

private String message="no students are there";
	
	public NoStudentException() {
		
	}
	public NoStudentException(String message) {
		this.message=message;
	}
	@Override
	public String getMessage() {
		return this.message;
	}
}
