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
 * Used to share the screen dimensions on Server
 * @author Dave Bryson
 */
public class SVMPScreenInfoMessage extends SVMPMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	
    public float xsize, ysize;

    public SVMPScreenInfoMessage(){
        this.tag = MessageConstants.CLIENT_INT;
    }

    public SVMPScreenInfoMessage(final float xsize, final float ysize){
        this();
        this.xsize = xsize;
        this.ysize = ysize;
    }

    @Override
    public void encode(ByteBuffer buf) {
        buf.putFloat(this.xsize);
        buf.putFloat(this.ysize);
    }

    @Override
    public void decode(ByteBuffer buf) {
        this.xsize = buf.getFloat();
        this.ysize = buf.getFloat();
    }

    @Override
    public int getSize() {
        return 8;
    }

    public String toString(){
        return "ScreenInfo: (" + this.xsize + "," + this.ysize + ")";
    }
}
