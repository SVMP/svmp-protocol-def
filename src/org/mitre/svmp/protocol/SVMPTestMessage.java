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
 * Simple message used ONLY for testing
 * @author Dave Bryson
 */
public class SVMPTestMessage extends SVMPMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	
    public int value;

    public SVMPTestMessage(){
        this.size = 4;
        this.tag = MessageConstants.TEST;
    }

    public SVMPTestMessage(final int val){
        this();
        this.value = val;
    }

    @Override
    public void encode(final ByteBuffer buf) {
        buf.putInt(this.value);
    }

    @Override
    public void decode(ByteBuffer buf) {
        this.value = buf.getInt();
    }

    @Override
    public int getSize() {
        return 4;
    }
}
