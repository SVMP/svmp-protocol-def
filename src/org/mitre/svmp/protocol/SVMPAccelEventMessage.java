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
 * See http://developer.android.com/reference/android/hardware/SensorEvent.html
 * 
 * All values are in SI units (m/s^2) 
 * values[0]: Acceleration minus Gx on the x-axis 
 * values[1]: Acceleration minus Gy on the y-axis 
 * values[2]: Acceleration minus Gz on the z-axis 
 * 
 * @author dkeppler
 *
 */
public class SVMPAccelEventMessage extends SVMPSensorEventMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private SVMPAccelEventMessage() {
		super();
		this.type = SVMPSensorType.TYPE_ACCELEROMETER;
		this.values = new float[3];
	}
	
	public SVMPAccelEventMessage(ByteBuffer buf) {
		this();
		decode(buf);
	}

	public SVMPAccelEventMessage(int accuracy, long timestamp, float values[]) {
		this();

		this.accuracy = accuracy;
		this.timestamp = timestamp;
		
		if (values.length != 3)
			throw new IllegalArgumentException("Accelerometer SensorEvents should have a 3-element 'value' input");
		this.values[0] = values[0];
		this.values[1] = values[1];
		this.values[2] = values[2];
	}

}
