package com.google.android.gms.internal.firebase_database;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;

final class zzka {
    private zzjw zztc = null;
    private DataInputStream zzty = null;
    private zzjr zztz = null;
    private byte[] zzua = new byte[112];
    private zzjm zzub;
    private volatile boolean zzuc = false;

    zzka(zzjr zzjr) {
        this.zztz = zzjr;
    }

    private final int read(byte[] bArr, int i, int i2) throws IOException {
        this.zzty.readFully(bArr, i, i2);
        return i2;
    }

    private final void zzc(zzjx zzjx) {
        this.zzuc = true;
        this.zztz.zzb(zzjx);
    }

    /* access modifiers changed from: package-private */
    public final void run() {
        this.zztc = this.zztz.zzgj();
        while (!this.zzuc) {
            try {
                int read = read(this.zzua, 0, 1) + 0;
                boolean z = (this.zzua[0] & 128) != 0;
                if ((this.zzua[0] & 112) != 0) {
                    throw new zzjx("Invalid frame received");
                }
                byte b = (byte) (this.zzua[0] & 15);
                int read2 = read + read(this.zzua, read, 1);
                byte b2 = this.zzua[1];
                long j = 0;
                if (b2 < 126) {
                    j = (long) b2;
                } else if (b2 == 126) {
                    read(this.zzua, read2, 2);
                    j = (long) (((this.zzua[2] & 255) << 8) | (this.zzua[3] & 255));
                } else if (b2 == Byte.MAX_VALUE) {
                    byte[] bArr = this.zzua;
                    int read3 = (read(this.zzua, read2, 8) + read2) - 8;
                    j = ((long) (bArr[read3 + 7] & 255)) + (((long) bArr[read3]) << 56) + (((long) (bArr[read3 + 1] & 255)) << 48) + (((long) (bArr[read3 + 2] & 255)) << 40) + (((long) (bArr[read3 + 3] & 255)) << 32) + (((long) (bArr[read3 + 4] & 255)) << 24) + ((long) ((bArr[read3 + 5] & 255) << 16)) + ((long) ((bArr[read3 + 6] & 255) << 8));
                }
                byte[] bArr2 = new byte[((int) j)];
                read(bArr2, 0, (int) j);
                if (b == 8) {
                    this.zztz.zzgk();
                } else if (b == 10) {
                    continue;
                } else if (b != 1 && b != 2 && b != 9 && b != 0) {
                    throw new zzjx(new StringBuilder(24).append("Unsupported opcode: ").append(b).toString());
                } else if (b == 9) {
                    if (!z) {
                        throw new zzjx("PING must not fragment across frames");
                    } else if (bArr2.length <= 125) {
                        this.zztz.zzd(bArr2);
                    } else {
                        throw new zzjx("PING frame too long");
                    }
                } else if (this.zzub != null && b != 0) {
                    throw new zzjx("Failed to continue outstanding frame");
                } else if (this.zzub == null && b == 0) {
                    throw new zzjx("Received continuing frame, but there's nothing to continue");
                } else {
                    if (this.zzub == null) {
                        this.zzub = b == 2 ? new zzjl() : new zzjn();
                    }
                    if (!this.zzub.zzb(bArr2)) {
                        throw new zzjx("Failed to decode frame");
                    } else if (z) {
                        zzjz zzgh = this.zzub.zzgh();
                        this.zzub = null;
                        if (zzgh == null) {
                            throw new zzjx("Failed to decode whole message");
                        }
                        this.zztc.zza(zzgh);
                    } else {
                        continue;
                    }
                }
            } catch (SocketTimeoutException e) {
            } catch (IOException e2) {
                zzc(new zzjx("IO Error", e2));
            } catch (zzjx e3) {
                zzc(e3);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(DataInputStream dataInputStream) {
        this.zzty = dataInputStream;
    }

    /* access modifiers changed from: package-private */
    public final void zzgp() {
        this.zzuc = true;
    }
}
