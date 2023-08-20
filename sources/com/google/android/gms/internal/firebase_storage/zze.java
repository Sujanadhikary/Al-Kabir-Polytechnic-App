package com.google.android.gms.internal.firebase_storage;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

public final class zze {
    private static final Runtime zzdn = Runtime.getRuntime();
    private byte[] buffer = new byte[262144];
    private final InputStream zzdo;
    private int zzdp = 0;
    private boolean zzdq = false;
    private boolean zzdr = true;

    public zze(InputStream inputStream, int i) {
        this.zzdo = inputStream;
    }

    private final int zzd(int i) {
        int max = Math.max(this.buffer.length << 1, i);
        long maxMemory = zzdn.maxMemory() - (zzdn.totalMemory() - zzdn.freeMemory());
        if (!this.zzdr || ((long) max) >= maxMemory) {
            Log.w("AdaptiveStreamBuffer", "Turning off adaptive buffer resizing to conserve memory.");
        } else {
            try {
                byte[] bArr = new byte[max];
                System.arraycopy(this.buffer, 0, bArr, 0, this.zzdp);
                this.buffer = bArr;
            } catch (OutOfMemoryError e) {
                Log.w("AdaptiveStreamBuffer", "Turning off adaptive buffer resizing due to low memory.");
                this.zzdr = false;
            }
        }
        return this.buffer.length;
    }

    public final int available() {
        return this.zzdp;
    }

    public final void close() throws IOException {
        this.zzdo.close();
    }

    public final boolean isFinished() {
        return this.zzdq;
    }

    public final int zzb(int i) throws IOException {
        if (i <= this.zzdp) {
            this.zzdp -= i;
            System.arraycopy(this.buffer, i, this.buffer, 0, this.zzdp);
            return i;
        }
        this.zzdp = 0;
        int i2 = this.zzdp;
        while (i2 < i) {
            long skip = this.zzdo.skip((long) (i - i2));
            if (skip > 0) {
                i2 = (int) (((long) i2) + skip);
            } else if (skip != 0) {
                continue;
            } else if (this.zzdo.read() == -1) {
                return i2;
            } else {
                i2++;
            }
        }
        return i2;
    }

    public final int zzc(int i) throws IOException {
        if (i > this.buffer.length) {
            i = Math.min(i, zzd(i));
        }
        while (true) {
            if (this.zzdp >= i) {
                break;
            }
            int read = this.zzdo.read(this.buffer, this.zzdp, i - this.zzdp);
            if (read == -1) {
                this.zzdq = true;
                break;
            }
            this.zzdp = read + this.zzdp;
        }
        return this.zzdp;
    }

    public final byte[] zzu() {
        return this.buffer;
    }
}
