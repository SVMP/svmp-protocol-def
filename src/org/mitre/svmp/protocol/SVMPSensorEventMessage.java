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
 * Superclass of all SensorEvent messages. Not instantiable itself except via
 * child classes and the decoder factory method.
 * 
 * See http://developer.android.com/reference/android/hardware/SensorEvent.html
 * 
 * @author dkeppler
 *
 */
public class SVMPSensorEventMessage extends SVMPMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int type = -1;
	
	protected int accuracy;
	protected long timestamp;
	protected float[] values;
		
	protected SVMPSensorEventMessage() {
		this.tag = MessageConstants.SENSOR_EVENT;
	}
	
	public SVMPSensorEventMessage(int type, int accuracy, long timestamp, float[] values) {
		this.tag = MessageConstants.SENSOR_EVENT;
		this.type = type;
		this.accuracy = accuracy;
		this.timestamp = timestamp;
		this.values = values;
	}
	
	public static SVMPSensorEventMessage decoder(ByteBuffer buf) {
		final int type = buf.getInt();
		switch (type) {
			case SVMPSensorType.TYPE_ACCELEROMETER:
				return new SVMPAccelEventMessage(buf);
			case SVMPSensorType.TYPE_MAGNETIC_FIELD:
				return new SVMPMagneticFieldEventMessage(buf);
			case SVMPSensorType.TYPE_GYROSCOPE:
				return null;
			case SVMPSensorType.TYPE_LIGHT:
				return null;
			case SVMPSensorType.TYPE_PRESSURE:
				return null;
			case SVMPSensorType.TYPE_GRAVITY:
				return null;
			case SVMPSensorType.TYPE_LINEAR_ACCELERATION:
				return null;
			case SVMPSensorType.TYPE_ROTATION_VECTOR:
				return null;
			case SVMPSensorType.TYPE_ORIENTATION:
				return new SVMPOrientationEventMessage(buf);
			case SVMPSensorType.TYPE_RELATIVE_HUMIDITY:
				return null;
			case SVMPSensorType.TYPE_AMBIENT_TEMPERATURE:
				return null;
// FIXME Location isn't a SensorEvent
//			case SVMPSensorType.GPS:
//				return new SVMPLocationEventMessage(buf);
			default:
				return null;
		}
	}

	public int getAccuracy() {
		return accuracy;
	}

	public long getTimestamp() {
		return timestamp;
	}

	@Override
	public void encode(ByteBuffer buf) {
		int len=values.length-1;
		if (len < 0)
			len = 1;
		buf.putInt(type);
		buf.putInt(accuracy);
		buf.putLong(timestamp);
		buf.put((byte)values.length);		
		for (int i = 0; i < 3; i++) {
			if (i > len) // pad with zeros
				buf.putFloat(0.0f);
			else
				buf.putFloat(values[i]);
		}
				   
	}

	@Override
	public void decode(ByteBuffer buf) {
		int len=values.length-1;
		if (len < 0)
			len = 1;
		type = buf.getInt();
		accuracy = buf.getInt();
		timestamp = buf.getLong();
		values = new float[buf.get()];
		for (int i = 0; i < 3; i++)
			if (i > len) // pad with zeros
				buf.putFloat(0.0f);
			else
				values[i] = buf.getFloat();
	}

	@Override
	public int getSize() {
		// type + accuracy + timestamp + values[]
		return 4 + 4 + 8 + 4*values.length;
	}
	
}
