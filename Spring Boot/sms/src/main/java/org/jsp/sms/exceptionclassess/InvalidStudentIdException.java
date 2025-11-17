package org.jsp.sms.exceptionclassess;

public class InvalidStudentIdException extends RuntimeException {
	
	private String message="Student id is invalid";
	
	public InvalidStudentIdException() {
		
	}
	public InvalidStudentIdException(String message) {
		this.message=message;
	}
	@Override
	public String getMessage() {
		return this.message;
	}

}
