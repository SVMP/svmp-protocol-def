/*
Copyright 2013 The MITRE Corporation, All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this work except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package org.mitre.svmp.protocol;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/**
 * RTSP Video URL Path message. Tells the client where to connect to 
 * get the streaming video. Contains the path component of a URI of the 
 * form rtsp://host:port/path
 * 
 * Direction: Server to Client
 * 
 * Note: Type is unused. Video url path is hardcoded on client and server now.
 * I'm leaving this class here though in case we want to alter that eventually. 
 * 
 * @author dkeppler
 *
 */
@Deprecated
public class SVMPVideoPathMessage extends SVMPMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	static private final String charset = "US-ASCII";
	
	private byte[] pathBytes;
	
	private SVMPVideoPathMessage() {
		this.tag = MessageConstants.VIDEO_PATH;
	}
	
	public SVMPVideoPathMessage(String path) {
		this();
		try {
			this.pathBytes = path.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	public SVMPVideoPathMessage(ByteBuffer buf) {
		this();
		decode(buf);
	}
	
	public String getPath() {
		if (pathBytes == null || pathBytes.length == 0)
			return null;
		else
			try {
				return new String(pathBytes, charset);
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
	}

	@Override
	public void encode(ByteBuffer buf) {
		buf.putInt(pathBytes.length);
		buf.put(pathBytes);
	}

	@Override
	public void decode(ByteBuffer buf) {
		pathBytes = new byte[buf.getInt()];
		buf.get(pathBytes);
	}

	@Override
	public int getSize() {
		// str_len + str_bytes, NOT null terminated
		return 4 + pathBytes.length;
	}

}
