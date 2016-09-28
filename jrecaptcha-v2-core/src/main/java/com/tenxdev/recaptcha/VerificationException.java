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
