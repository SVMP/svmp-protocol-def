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
import java.nio.ByteBuffer;

/**
 * Server to client message to ask for access to a given sensor.
 * 
 * @author dkeppler
 *
 */
public class SVMPSensorSubscribeMessage extends SVMPMessage  implements Serializable {
	private static final long serialVersionUID = 1L;

	private int sensor = -1;
	private int refresh = -1; // in Hz
	
	/**
	 * @param sensorType Which sensor is the request for. From SVMPSensorType
	 * @param refreshRate Desired refresh rate in Hz. Final decision is the client's. 
	 */
	public SVMPSensorSubscribeMessage(int sensorType, int refreshRate) {
		this.sensor = sensorType;
		this.refresh = refreshRate;
	}
	
	public SVMPSensorSubscribeMessage(ByteBuffer buf) {
		this.decode(buf);
	}

	@Override
	public void encode(ByteBuffer buf) {
		buf.putInt(sensor);
		buf.putInt(refresh);
	}

	@Override
	public void decode(ByteBuffer buf) {
		sensor = buf.getInt();
		refresh = buf.getInt();
	}

	@Override
	public int getSize() {
		return 8;
	}

}
