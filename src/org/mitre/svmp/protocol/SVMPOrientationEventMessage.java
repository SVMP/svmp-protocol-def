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
 * Note: The Orientation SensorEvents type is deprecated as of Android API level 8. Documentation for
 * the Sensor class says to "use SensorManager.getOrientation() instead", which is based off the
 * MagneticField sensor.
 * 
 * All values are angles in degrees.
 * values[0]: Azimuth, angle between the magnetic north direction and the y-axis, around the z-axis (0 to 359). 0=North, 90=East, 180=South, 270=West
 * values[1]: Pitch, rotation around x-axis (-180 to 180), with positive values when the z-axis moves toward the y-axis.
 * values[2]: Roll, rotation around y-axis (-90 to 90), with positive values when the x-axis moves toward the z-axis.
 *  
 * @author dkeppler
 *
 */
@Deprecated
public class SVMPOrientationEventMessage extends SVMPSensorEventMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	private SVMPOrientationEventMessage() {
		super();
		this.type = SVMPSensorType.TYPE_ORIENTATION;
	}

	public SVMPOrientationEventMessage(ByteBuffer buf) {
		this();
		decode(buf);
	}
	
	public SVMPOrientationEventMessage(int accuracy, long timestamp, short values[]) {
		this();

		this.accuracy = accuracy;
		this.timestamp = timestamp;
		
		if (values.length != 3)
			throw new IllegalArgumentException("Orientation SensorEvents should have a 3-element 'value' input");
		this.values[0] = values[0];
		this.values[1] = values[1];
		this.values[2] = values[2];
	}

}
