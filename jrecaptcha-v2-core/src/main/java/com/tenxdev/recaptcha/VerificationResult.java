/**
 * 
 */
package com.tenxdev.recaptcha;

/**
 * Represents the result of a reCAPTCHA verification
 * 
 * @author tony.benbrahim@10xdev.com
 *
 */
public class VerificationResult {

	private boolean success;
	private String challenge_ts;
	private String hostname;
	private String[] errorCodes;

	/**
	 * @return the challenge timestamp in ISO format yyyy-MM-dd'T'HH:mm:ssZZ
	 */
	public String getChallengeTimestamp() {
		return challenge_ts;
	}

	/**
	 * @return an error of error codes if there are any errors, or null if no
	 *         errors.
	 *         <table>
	 *         <tr>
	 *         <th>Error code</th>
	 *         <th>Description</th>
	 *         </tr>
	 *         <tr>
	 *         <td>missing-input-secret</td>
	 *         <td>The secret parameter is missing.</td>
	 *         </tr>
	 *         <tr>
	 *         <td>invalid-input-secret</td>
	 *         <td>The secret parameter is invalid or malformed.</td>
	 *         </tr>
	 *         <tr>
	 *         <td>missing-input-response</td>
	 *         <td>The response parameter is missing.</td>
	 *         </tr>
	 *         <tr>
	 *         <td>invalid-input-response</td>
	 *         <td>The response parameter is invalid or malformed.</td>
	 *         </tr>
	 *         </table>
	 */
	public String[] getErrorCodes() {
		return errorCodes;
	}

	/**
	 * @return the hostname of the site where the reCAPTCHA was solved
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * @return true if the verification was successful, false otherwise
	 */
	public boolean isSuccessful() {
		return success;
	}
}
