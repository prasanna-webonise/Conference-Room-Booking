/**
 * 
 */
package com.webonise.conferenceRoomBooking.exception;

/**
 * @author ionidea
 *
 */
public class ConferenceRoomBookingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ConferenceRoomBookingException() {
	}

	/**
	 * @param message
	 */
	public ConferenceRoomBookingException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ConferenceRoomBookingException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ConferenceRoomBookingException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ConferenceRoomBookingException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
