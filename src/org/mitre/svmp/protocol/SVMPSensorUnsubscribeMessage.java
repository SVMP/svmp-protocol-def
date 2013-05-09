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

public class SVMPSensorUnsubscribeMessage extends SVMPMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	private int sensor = -1;
	
	public SVMPSensorUnsubscribeMessage(int sensorType) {
		this.sensor = sensorType;
	}
	
	public SVMPSensorUnsubscribeMessage(ByteBuffer buf) {
		decode(buf);
	}

	@Override
	public void encode(ByteBuffer buf) {
		buf.putInt(sensor);
	}

	@Override
	public void decode(ByteBuffer buf) {
		this.sensor = buf.getInt();
	}

	@Override
	public int getSize() {
		return 4;
	}

}
