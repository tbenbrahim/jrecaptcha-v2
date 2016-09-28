package com.tenxdev;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tenxdev.recaptcha.VerificationException;
import com.tenxdev.recaptcha.VerificationResult;

@SuppressWarnings("serial")
public class SampleServlet extends HttpServlet {

	private ServletRecaptchaVerifier recaptchaVerifier;

	@Override
	public void init(final ServletConfig config) throws ServletException {
		recaptchaVerifier = new ServletRecaptchaVerifier(config.getInitParameter("site-key"),
				config.getInitParameter("secret-key"));
		super.init(config);
	}

	@Override
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		final PrintWriter out = response.getWriter();
		out.write("<head><title>Are you a robot?</title><style>");
		out.print("body {font-family: Segoe UI, Arial, Helvetica;width:600px;");
		out.print("margin: 20px auto;}</style>");
		out.print("<script src=\"https://www.google.com/recaptcha/api.js\"></script></head>");
		out.print("<body><h2>Are you a robot?</h2><p>");
		try {
			final VerificationResult verificationResult = recaptchaVerifier.verifyUserResponse(request);
			log("Recaptcha success: " + verificationResult.isSuccessful());
			log("Recaptcha timestamp: " + verificationResult.getChallengeTimestamp());
			log("Recaptcha hostname: " + verificationResult.getHostname());
			log("Recaptcha errors: " + verificationResult.getErrorCodes());
			if (verificationResult.isSuccessful()) {
				out.print("No, Google does not think you are a robot.");
			} else {
				out.print("Tes, Google thinks you are a robot.");
			}
		} catch (final VerificationException e) {
			out.print("Unable to determine if you are a robot, got an error: " + e.getMessage());
			log("Recaptcha verification exception", e);
		}
		out.print("</p><p><a href=\"index.html\">Try again</a></p></body>");
	}

}
