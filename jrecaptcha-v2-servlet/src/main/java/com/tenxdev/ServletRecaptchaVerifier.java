/**
 * 
 */
package com.tenxdev;

import java.net.Proxy.Type;

import javax.servlet.http.HttpServletRequest;

import com.tenxdev.recaptcha.RecaptchaVerifier;
import com.tenxdev.recaptcha.VerificationException;
import com.tenxdev.recaptcha.VerificationResult;

/**
 * @author tony.benbrahim
 *
 */
public class ServletRecaptchaVerifier extends RecaptchaVerifier {

	public static final String JS_INCLUDE = "<script src=\"https://www.google.com/recaptcha/api.js\"></script>";
	private static final String CAPTCHA_RESPONSE_PARAMETER = "g-recaptcha-response";

	public ServletRecaptchaVerifier(final String siteKey, final String secretKey) {
		super(siteKey, secretKey);
	}

	public String getCaptchaHtml() {
		return String.format("<div class=\"g-recaptcha\" data-sitekey=\"%s\"></div>", siteKey);
	}

	public VerificationResult verifyUserResponse(final HttpServletRequest request) throws VerificationException {
		final String responseValue = request.getParameter(CAPTCHA_RESPONSE_PARAMETER);
		if (responseValue == null) {
			throw new VerificationException(
					String.format("request is missing the %s parameter", CAPTCHA_RESPONSE_PARAMETER));
		}
		return super.verifyUserResponse(responseValue);
	}

	@Override
	public ServletRecaptchaVerifier withProxy(final Type proxyType, final String proxyHost, final int proxyPort) {
		return (ServletRecaptchaVerifier) super.withProxy(proxyType, proxyHost, proxyPort);
	}

}
