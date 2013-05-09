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
 * @author Dave Bryson
 */
public class SVMPServerAckMessage extends SVMPMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	
    public static final int OK = 100;
    public static final int ERROR = 101;
    public String message;
    private int messageSize = 0;
    public int value;

    public SVMPServerAckMessage(){
        this.tag = MessageConstants.SERVER_ACK;
    }

    public SVMPServerAckMessage(final int value, final String message){
        this();
        this.value = value;
        this.message = message;
    }


    @Override
    public void encode(ByteBuffer buf) {
        buf.putInt(this.value);
        if(message != null){
            this.messageSize = message.getBytes().length;
            buf.putInt(messageSize);
            buf.put(this.message.getBytes());
        } else {
            buf.putInt(0);
        }
    }

    @Override
    public void decode(ByteBuffer buf) {
        this.value = buf.getInt();
        this.messageSize = buf.getInt();
        if(messageSize > 0){
            final byte[] data = new byte[this.messageSize];
            this.message = new String(buf.get(data).array());
        }
    }

    @Override
    public int getSize() {
        return 4 + 4 + this.message.getBytes().length;
    }

    public String toString(){
        return "Ack: " + this.value + "," + this.message;
    }
}
