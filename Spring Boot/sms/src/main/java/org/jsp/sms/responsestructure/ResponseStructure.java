package org.jsp.sms.responsestructure;

import java.util.List;

import org.jsp.sms.entity.Student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ResponseStructure<T> {
	private int httpStatus;
	private String message;
	private T body;


}
