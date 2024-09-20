package com.ey.excepion;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ProductExceptionMapper implements ExceptionMapper<ProductException> {

	@Override
	public Response toResponse(ProductException e) {
		//logging and other stuff here
		Error error = new Error();
		error.setErrorCode(123); //something superficial
		error.setErrorMessage(e.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		return Response
				.status(400)
				.entity(error)
				.build();
	}


	public static class Error {
		private int errorCode;
		private String errorMessage;
		private long timestamp;
		
		public int getErrorCode() {
			return errorCode;
		}
		public void setErrorCode(int errorCode) {
			this.errorCode = errorCode;
		}
		public String getErrorMessage() {
			return errorMessage;
		}
		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}
		public long getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(long timestamp) {
			this.timestamp = timestamp;
		}
	}
	
}

