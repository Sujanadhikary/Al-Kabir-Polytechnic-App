package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public class SingleRefDataBufferIterator<T> extends DataBufferIterator<T> {
    private T zzoj;

    public SingleRefDataBufferIterator(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException(new StringBuilder(46).append("Cannot advance the iterator beyond ").append(this.mPosition).toString());
        }
        this.mPosition++;
        if (this.mPosition == 0) {
            this.zzoj = this.mDataBuffer.get(0);
            if (!(this.zzoj instanceof DataBufferRef)) {
                String valueOf = String.valueOf(this.zzoj.getClass());
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 44).append("DataBuffer reference of type ").append(valueOf).append(" is not movable").toString());
            }
        } else {
            ((DataBufferRef) this.zzoj).setDataRow(this.mPosition);
        }
        return this.zzoj;
    }
}
