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

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Main encoder/decoder of messages
 * @author Dave Bryson
 */
public class SVMPMessageEncoderDecoder {

    public static SVMPMessage decode(final byte[] data){
        ByteBuffer buf = ByteBuffer.wrap(data);
        buf.order(ByteOrder.BIG_ENDIAN);
        // Read the tag type
        final int tag = buf.getInt();
        System.out.println("TAG NO: " + tag);
        // Process the message
        switch (tag){
            case MessageConstants.TEST:
                SVMPTestMessage test = new SVMPTestMessage();
                test.decode(buf);
                return test;
            case MessageConstants.TOUCH_EVENT:
                SVMPTouchEventMessage touch = new SVMPTouchEventMessage();
                touch.decode(buf);
                return touch;
            case MessageConstants.CLIENT_INT:
                SVMPScreenInfoMessage client = new SVMPScreenInfoMessage();
                client.decode(buf);
                return client;
            case MessageConstants.KEY_EVENT:
                SVMPKeyEventMessage key = new SVMPKeyEventMessage();
                key.decode(buf);
                return key;
            case MessageConstants.SERVER_ACK:
                SVMPServerAckMessage ack = new SVMPServerAckMessage();
                ack.decode(buf);
                return ack;
            case MessageConstants.SENSOR_EVENT:
            	return SVMPSensorEventMessage.decoder(buf);
            case MessageConstants.SENSOR_SUB:
            	return new SVMPSensorSubscribeMessage(buf);
            case MessageConstants.SENSOR_UNSUB:
            	return new SVMPSensorUnsubscribeMessage(buf);
            case MessageConstants.VIDEO_PATH:
            	return new SVMPVideoPathMessage(buf);
            default:
                return null;
        }
    }

    public static byte[] encode(final SVMPMessage obj){
        ByteBuffer buffer = ByteBuffer.allocate(obj.getSize() + 4);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.putInt(obj.getTag());
        obj.encode(buffer);
        buffer.flip();
        return buffer.array();
    }



    public static void main(String[] args) {
        SVMPTouchEventMessage touch = new SVMPTouchEventMessage(5);
        touch.addPointerCoord(0,300,600);
        touch.addPointerCoord(1,400,800);

        byte[] data = SVMPMessageEncoderDecoder.encode(touch);
        SVMPMessage msg = SVMPMessageEncoderDecoder.decode(data);
        System.out.println(" Message: " + msg.tag + " : " + msg.toString());
    }
}
