package org.jsp.user.responsestructure;


import org.jsp.user.responsestructure.ResponseStructure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//04/12/2024
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseStructure<T> {
	
		private int httpStatus;
		private String message;
		private T body;

}
