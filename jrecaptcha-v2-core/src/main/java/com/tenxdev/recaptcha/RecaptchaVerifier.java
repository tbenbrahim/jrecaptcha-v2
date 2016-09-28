/**
 * 
 */
package com.tenxdev.recaptcha;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;

/**
 * verifies a reCAPTCHA response
 * 
 * @author tony.benbrahim@10xdev.com
 *
 */
public class RecaptchaVerifier {

	private static final String SITE_VERIFICATION_URL = "https://www.google.com/recaptcha/api/siteverify";
	protected final String siteKey;
	private final String secretKey;
	private Type proxyType;
	private String proxyHost;
	private int proxyPort;
	private boolean useProxy;

	public RecaptchaVerifier(final String siteKey, final String secretKey) {
		this.siteKey = siteKey;
		this.secretKey = secretKey;
	}

	public VerificationResult verifyUserResponse(final String captchaResponse) throws VerificationException {
		try {
			final HttpsURLConnection conn = createConnection();
			sendRequest(conn, captchaResponse);
			return readResponse(conn);
		} catch (final IOException e) {
			throw new VerificationException("Unable to connect to authorization server:" + e.getMessage(), e);
		}
	}

	public RecaptchaVerifier withProxy(final Type proxyType, final String proxyHost, final int proxyPort) {
		this.useProxy = true;
		this.proxyType = proxyType;
		this.proxyHost = proxyHost;
		this.proxyPort = proxyPort;
		return this;
	}

	private HttpsURLConnection createConnection() throws IOException {
		HttpsURLConnection conn;
		if (useProxy) {
			final Proxy proxy = new Proxy(proxyType, new InetSocketAddress(proxyHost, proxyPort));
			conn = (HttpsURLConnection) new URL(SITE_VERIFICATION_URL).openConnection(proxy);
		} else {
			conn = (HttpsURLConnection) new URL(SITE_VERIFICATION_URL).openConnection();
		}
		return conn;
	}

	private VerificationResult readResponse(final HttpsURLConnection conn) throws IOException, VerificationException {
		final int responseCode = conn.getResponseCode();
		if (responseCode == 200) {
			return new Gson().fromJson(new InputStreamReader(conn.getInputStream()), VerificationResult.class);
		}
		throw new VerificationException(String.format("Unexpected responce code %s", responseCode));
	}

	private void sendRequest(final HttpsURLConnection conn, final String captchaResponse) throws IOException {
		final String postData = String.format("secret=%s&response=%s",
				URLEncoder.encode(secretKey, StandardCharsets.UTF_8.name()),
				URLEncoder.encode(captchaResponse, StandardCharsets.UTF_8.name()));
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty("charset", "utf-8");
		conn.setRequestProperty("Content-Length", String.valueOf(postData.length()));
		conn.getOutputStream().write(postData.getBytes(StandardCharsets.UTF_8));
		conn.getOutputStream().flush();
	}

}
