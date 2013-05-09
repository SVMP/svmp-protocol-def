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
 * Key Event
 *
 * @author Dave Bryson
 */
public class SVMPKeyEventMessage extends SVMPMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	
    public int action;
    public int keycode;

    public SVMPKeyEventMessage(){
        this.tag = MessageConstants.KEY_EVENT;
    }

    public SVMPKeyEventMessage(final int action, final int keycode){
        this();
        this.action = action;
        this.keycode = keycode;
    }

    @Override
    public void encode(ByteBuffer buf) {
        buf.putInt(this.action);
        buf.putInt(this.keycode);
    }

    @Override
    public void decode(ByteBuffer buf) {
        this.action = buf.getInt();
        this.keycode = buf.getInt();
    }

    @Override
    public int getSize() {
        return 8;
    }
}
