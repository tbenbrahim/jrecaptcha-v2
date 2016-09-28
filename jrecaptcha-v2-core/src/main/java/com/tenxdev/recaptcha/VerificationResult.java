/*
Copyright 2016 Tony BenBrahim <tony.benbrahim@10xdev.com>

This file is part of jrecaptcha-v2-core.

    jrecaptcha-v2-core is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    jrecaptcha-v2-core is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
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
