package alchemystar.freedom.meta.value;

import alchemystar.freedom.util.BufferWrapper;

/**
 * @Author lizhuyang
 */
public class ValueLong extends Value {

    private long i;

    public ValueLong() {
    }

    public ValueLong(long i) {
        this.i = i;
    }

    @Override
    public int getLength() {
        // 1 for tupe
        return 1 + 8;
    }

    @Override
    public byte getType() {
        return LONG;
    }

    @Override
    public byte[] getBytes() {
        BufferWrapper wrapper = new BufferWrapper(getLength());
        // int type
        wrapper.writeByte(LONG);
        // for the value string
        wrapper.writeLong(i);
        return wrapper.getBuffer();
    }

    @Override
    public void read(byte[] bytes) {
        BufferWrapper wrapper = new BufferWrapper(bytes);
        i = wrapper.readLong();
    }

    @Override
    public String toString() {
        return String.valueOf(i);
    }

    public long getLong() {
        return i;
    }

    public ValueLong setLong(long i) {
        this.i = i;
        return this;
    }

    @Override
    public int compare(Value value) {
        long toCompare = (((ValueLong) value).getLong());
        if (i > toCompare) {
            return 1;
        }
        if (i == toCompare) {
            return 0;
        }
        return -1;
    }
}