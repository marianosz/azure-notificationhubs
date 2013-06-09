/*
Copyright (c) Microsoft Open Technologies, Inc.
All Rights Reserved
Apache 2.0 License
 
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
 
     http://www.apache.org/licenses/LICENSE-2.0
 
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 
See the Apache Version 2.0 License for specific language governing permissions and limitations under the License.
 */

package com.microsoft.windowsazure.messaging;

import java.net.URI;

import static com.microsoft.windowsazure.messaging.Utils.*;

/**
 * Connection string utilities to connect with a Notification Hub
 */
public class ConnectionString {
	/**
	 * Creates a connection string using a Shared Access Secret
	 * @param endPoint	The endpoint
	 * @param keyName	The key name
	 * @param accessSecret	The Shared Access Secret
	 * @return	The connection string
	 */
	public static String createUsingSharedAccessSecret(URI endPoint, String keyName, String accessSecret) {
		if (endPoint == null) {
			throw new IllegalArgumentException("endPoint");
		}

		if (isNullOrWhiteSpace(keyName)) {
			throw new IllegalArgumentException("keyName");
		}

		if (isNullOrWhiteSpace(accessSecret)) {
			throw new IllegalArgumentException("accessSecret");
		}

		return String.format("Endpoint=%s;SharedAccessKeyName=%s;SharedAccessKey=%s", endPoint.toString(), keyName, accessSecret);
	}

	/**
	 * Creates a connection string using a Shared Access Secret with full access
	 * @param endPoint	The endpoint
	 * @param fullAccessSecret	The Shared Access Secret
	 * @return	The connection string
	 */
	public static String createUsingSharedAccessSecretWithFullAccess(URI endPoint, String fullAccessSecret) {
		if (isNullOrWhiteSpace(fullAccessSecret)) {
			throw new IllegalArgumentException("fullAccessSecret");
		}

		return createUsingSharedAccessSecret(endPoint, "DefaultFullSharedAccessSignature", fullAccessSecret);
	}

	/**
	 * Creates a connection string using a Shared Access Secret with listen access
	 * @param endPoint	The endpoint
	 * @param listenAccessSecret	the Shared Access Secret
	 * @return The connection string
	 */
	public static String createUsingSharedAccessSecretWithListenAccess(URI endPoint, String listenAccessSecret) {
		if (isNullOrWhiteSpace(listenAccessSecret)) {
			throw new IllegalArgumentException("listenAccessSecret");
		}

		return createUsingSharedAccessSecret(endPoint, "DefaultListenSharedAccessSignature", listenAccessSecret);
	}
}
