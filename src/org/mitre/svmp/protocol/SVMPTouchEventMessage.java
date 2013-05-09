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
import java.util.ArrayList;

/**
 * Transports touch events
 * @author Dave Bryson
 */
public class SVMPTouchEventMessage extends SVMPMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	
    public int action;
    public ArrayList<PointerCoords> pointerItems = new ArrayList<PointerCoords>();

    public SVMPTouchEventMessage() {
        this.tag = MessageConstants.TOUCH_EVENT;
    }

    public SVMPTouchEventMessage(final int action) {
        this();
        this.action = action;
    }

    public void addPointerCoord(final int id, final float x, final float y) {
        this.pointerItems.add(new PointerCoords(id, x, y));
    }


    @Override
    public void encode(ByteBuffer buffer) {
        final int pointerCount = this.pointerItems.size();
        buffer.putInt(this.action);
        buffer.put((byte) pointerCount);

        for (int i = 0; i < pointerCount; i++) {
            buffer.put((byte) this.pointerItems.get(i).id);
            buffer.putFloat(this.pointerItems.get(i).x);
            buffer.putFloat(this.pointerItems.get(i).y);
        }

    }

    @Override
    public void decode(ByteBuffer buffer) {
        this.action = buffer.getInt();
        final byte pointerCount = buffer.get();
        for (int i = 0; i < pointerCount; i++) {
            final byte id = buffer.get();
            final float x = buffer.getFloat();
            final float y = buffer.getFloat();
            this.addPointerCoord(id, x, y);
        }
    }

    @Override
    public String toString() {
        StringBuffer buff = new StringBuffer("Event: ( ");
        buff.append("TOUCH");
        buff.append(" Action: ").append(this.action).append(" PointerCount: ").append(this.pointerItems.size());
        buff.append(" : ");
        for (PointerCoords p : this.pointerItems) {
            buff.append(p);
        }
        return buff.toString();
    }


    @Override
    public int getSize() {
        // action = 4
        // pointercount = 1
        // point count * 9  (1 id, 4 x, 4 y)
        return 5 + (this.pointerItems.size() * 9);
    }

    public static class PointerCoords implements Serializable {
        public int id;
        public float x;
        public float y;

        public PointerCoords() {
        }

        public PointerCoords(final int id, final float x, final float y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }

        public String toString() {
            StringBuffer buff = new StringBuffer();
            buff.append("Pointer( # ")
                    .append(this.id)
                    .append(" , ")
                    .append(this.x)
                    .append(" , ")
                    .append(this.y)
                    .append(" ), ");
            return buff.toString();
        }
    }
}
