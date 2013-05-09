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

/*
 * Copyright (C) 2008 The Android Open Source Project
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

package org.mitre.svmp.protocol;

/**
 * Sensor type values from android.hardware.Sensor
 * http://developer.android.com/reference/android/hardware/Sensor.html
 * 
 * @author dkeppler
 *
 */
public class SVMPSensorType {
    /**
     * A constant describing an accelerometer sensor type. See
     * {@link android.hardware.SensorEvent#values SensorEvent.values} for more
     * details.
     */
    public static final int TYPE_ACCELEROMETER = 1;

    /**
     * A constant describing a magnetic field sensor type. See
     * {@link android.hardware.SensorEvent#values SensorEvent.values} for more
     * details.
     */
    public static final int TYPE_MAGNETIC_FIELD = 2;

    /**
     * A constant describing an orientation sensor type. See
     * {@link android.hardware.SensorEvent#values SensorEvent.values} for more
     * details.
     *
     * @deprecated use {@link android.hardware.SensorManager#getOrientation
     *             SensorManager.getOrientation()} instead.
     */
    @Deprecated
    public static final int TYPE_ORIENTATION = 3;

    /** A constant describing a gyroscope sensor type */
    public static final int TYPE_GYROSCOPE = 4;

    /**
     * A constant describing a light sensor type. See
     * {@link android.hardware.SensorEvent#values SensorEvent.values} for more
     * details.
     */
    public static final int TYPE_LIGHT = 5;

    /** A constant describing a pressure sensor type */
    public static final int TYPE_PRESSURE = 6;

    /**
     * A constant describing a temperature sensor type
     *
     * @deprecated use
     *             {@link android.hardware.Sensor#TYPE_AMBIENT_TEMPERATURE
     *             Sensor.TYPE_AMBIENT_TEMPERATURE} instead.
     */
    @Deprecated
    public static final int TYPE_TEMPERATURE = 7;

    /**
     * A constant describing a proximity sensor type. See
     * {@link android.hardware.SensorEvent#values SensorEvent.values} for more
     * details.
     */
    public static final int TYPE_PROXIMITY = 8;

    /**
     * A constant describing a gravity sensor type.
     * See {@link android.hardware.SensorEvent SensorEvent}
     * for more details.
     */
    public static final int TYPE_GRAVITY = 9;

    /**
     * A constant describing a linear acceleration sensor type.
     * See {@link android.hardware.SensorEvent SensorEvent}
     * for more details.
     */
    public static final int TYPE_LINEAR_ACCELERATION = 10;

    /**
     * A constant describing a rotation vector sensor type.
     * See {@link android.hardware.SensorEvent SensorEvent}
     * for more details.
     */
    public static final int TYPE_ROTATION_VECTOR = 11;

    /**
     * A constant describing a relative humidity sensor type.
     * See {@link android.hardware.SensorEvent SensorEvent}
     * for more details.
     */
    public static final int TYPE_RELATIVE_HUMIDITY = 12;

    /** A constant describing an ambient temperature sensor type */
    public static final int TYPE_AMBIENT_TEMPERATURE = 13;
}
