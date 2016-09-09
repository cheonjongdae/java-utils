/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.izeye.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Utilities for HTTP.
 *
 * @author Johnny Lim
 */
public abstract class HttpUtils {

	private HttpUtils() {
	}

	public static Map<String, String> parseCookieHeaderValue(String cookieHeaderValue) {
		Map<String, String> cookies = new HashMap<>();
		String[] cookieTokens = cookieHeaderValue.split(";");
		for (String cookieToken : cookieTokens) {
			String[] cookieNameValue = cookieToken.trim().split("=");
			cookies.put(cookieNameValue[0], cookieNameValue.length == 1 ? "" : cookieNameValue[1]);
		}
		return cookies;
	}

	public static String extractCookieValue(String cookieHeaderValue, String cookieName) {
		return parseCookieHeaderValue(cookieHeaderValue).get(cookieName);
	}

}
