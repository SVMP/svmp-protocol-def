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

/**
 * Constant of message types
 * @author Dave Bryson
 */
public class MessageConstants {
    public static final int TEST = 99;
    
    public static final int TOUCH_EVENT = 1;
    public static final int CLIENT_INT = 2;
    public static final int KEY_EVENT = 3;
    public static final int SERVER_ACK = 4;
    
    public static final int SENSOR_EVENT = 20;
    public static final int SENSOR_SUB = 21;
    public static final int SENSOR_UNSUB = 22;
    
    public static final int VIDEO_PATH = 30;
}
