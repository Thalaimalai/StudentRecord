package com.studentrecord.exception;

public class CustomException extends RuntimeException {
	
	public CustomException(String msg) {
		super(msg);
	}

	public static class RecordNotfoundException extends CustomException {

		public RecordNotfoundException(String msg) {
			super(msg);
		}
	}

	public static class RollNumberAlreadyFoundException extends CustomException {

		public RollNumberAlreadyFoundException(String msg) {
			super(msg);
		}
	}

	public static class AccessFailedException extends CustomException {

	        public AccessFailedException(String msg) {
	            super(msg);
	        }
	}
	
	public static class DetailsAlreadyFoundException extends CustomException {

        public DetailsAlreadyFoundException(String msg) {
            super(msg);
        }
}
}

