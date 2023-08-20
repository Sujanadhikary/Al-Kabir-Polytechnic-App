package com.google.android.gms.internal.firebase_database;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

final class zzkb {
    private final Random zzgf = new Random();
    private final Thread zzti = zzjr.getThreadFactory().newThread(new zzkc(this));
    private zzjr zztz;
    private volatile boolean zzuc = false;
    private BlockingQueue<ByteBuffer> zzud;
    private boolean zzue = false;
    private WritableByteChannel zzuf;

    zzkb(zzjr zzjr, String str, int i) {
        zzjr.zzgi().zza(this.zzti, new StringBuilder(String.valueOf(str).length() + 18).append(str).append("Writer-").append(i).toString());
        this.zztz = zzjr;
        this.zzud = new LinkedBlockingQueue();
    }

    private final void zzgq() throws InterruptedException, IOException {
        this.zzuf.write(this.zzud.take());
    }

    /* access modifiers changed from: private */
    public final void zzgs() {
        while (!this.zzuc && !Thread.interrupted()) {
            try {
                zzgq();
            } catch (IOException e) {
                this.zztz.zzb(new zzjx("IO Exception", e));
                return;
            } catch (InterruptedException e2) {
                return;
            }
        }
        for (int i = 0; i < this.zzud.size(); i++) {
            zzgq();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(byte b, boolean z, byte[] bArr) throws IOException {
        synchronized (this) {
            int i = 6;
            int length = bArr.length;
            if (length >= 126) {
                i = length <= 65535 ? 8 : 14;
            }
            ByteBuffer allocate = ByteBuffer.allocate(i + bArr.length);
            allocate.put((byte) (b | Byte.MIN_VALUE));
            if (length < 126) {
                allocate.put((byte) (length | 128));
            } else if (length <= 65535) {
                allocate.put((byte) -2);
                allocate.putShort((short) length);
            } else {
                allocate.put((byte) -1);
                allocate.putInt(0);
                allocate.putInt(length);
            }
            byte[] bArr2 = new byte[4];
            this.zzgf.nextBytes(bArr2);
            allocate.put(bArr2);
            for (int i2 = 0; i2 < bArr.length; i2++) {
                allocate.put((byte) (bArr[i2] ^ bArr2[i2 % 4]));
            }
            allocate.flip();
            if (!this.zzuc || (!this.zzue && b == 8)) {
                if (b == 8) {
                    this.zzue = true;
                }
                this.zzud.add(allocate);
            } else {
                throw new zzjx("Shouldn't be sending");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(OutputStream outputStream) {
        this.zzuf = Channels.newChannel(outputStream);
    }

    /* access modifiers changed from: package-private */
    public final void zzgr() {
        this.zzuc = true;
    }

    /* access modifiers changed from: package-private */
    public final Thread zzgt() {
        return this.zzti;
    }
}
