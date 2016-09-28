/**
 * 
 */
package com.tenxdev.recaptcha;

/**
 * Exception thrown when verification fails
 * 
 * @author tony.benbrahim@10xdev.com
 *
 */
@SuppressWarnings("serial")
public class VerificationException extends Exception {

	public VerificationException(final String message) {
		super(message);
	}

	public VerificationException(final String message, final Throwable t) {
		super(message, t);
	}

}
