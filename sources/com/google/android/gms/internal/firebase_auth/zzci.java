package com.google.android.gms.internal.firebase_auth;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzci extends zzbt {
    private static final Logger logger = Logger.getLogger(zzci.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzmz = zzfx.zzgu();
    zzck zzna;

    static class zza extends zzci {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zza(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            } else if ((i | i2 | (bArr.length - (i + i2))) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
            } else {
                this.buffer = bArr;
                this.offset = i;
                this.position = i;
                this.limit = i + i2;
            }
        }

        public void flush() {
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)}), e);
            }
        }

        public final void zza(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        public final void zza(int i, long j) throws IOException {
            zzb(i, 0);
            zza(j);
        }

        public final void zza(int i, zzbu zzbu) throws IOException {
            zzb(i, 2);
            zza(zzbu);
        }

        public final void zza(int i, zzeh zzeh) throws IOException {
            zzb(i, 2);
            zzb(zzeh);
        }

        /* access modifiers changed from: package-private */
        public final void zza(int i, zzeh zzeh, zzex zzex) throws IOException {
            zzb(i, 2);
            zzbn zzbn = (zzbn) zzeh;
            int zzbm = zzbn.zzbm();
            if (zzbm == -1) {
                zzbm = zzex.zzo(zzbn);
                zzbn.zzf(zzbm);
            }
            zzw(zzbm);
            zzex.zza(zzeh, this.zzna);
        }

        public final void zza(int i, String str) throws IOException {
            zzb(i, 2);
            zzal(str);
        }

        public final void zza(long j) throws IOException {
            if (!zzci.zzmz || zzcz() < 10) {
                while ((j & -128) != 0) {
                    try {
                        byte[] bArr = this.buffer;
                        int i = this.position;
                        this.position = i + 1;
                        bArr[i] = (byte) ((((int) j) & 127) | 128);
                        j >>>= 7;
                    } catch (IndexOutOfBoundsException e) {
                        throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
                    }
                }
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr2[i2] = (byte) ((int) j);
                return;
            }
            while ((j & -128) != 0) {
                byte[] bArr3 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                zzfx.zza(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i4 = this.position;
            this.position = i4 + 1;
            zzfx.zza(bArr4, (long) i4, (byte) ((int) j));
        }

        public final void zza(zzbu zzbu) throws IOException {
            zzw(zzbu.size());
            zzbu.zza((zzbt) this);
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzeh zzeh, zzex zzex) throws IOException {
            zzbn zzbn = (zzbn) zzeh;
            int zzbm = zzbn.zzbm();
            if (zzbm == -1) {
                zzbm = zzex.zzo(zzbn);
                zzbn.zzf(zzbm);
            }
            zzw(zzbm);
            zzex.zza(zzeh, this.zzna);
        }

        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zzal(String str) throws IOException {
            int i = this.position;
            try {
                int zzab = zzab(str.length() * 3);
                int zzab2 = zzab(str.length());
                if (zzab2 == zzab) {
                    this.position = i + zzab2;
                    int zza = zzfz.zza(str, this.buffer, this.position, zzcz());
                    this.position = i;
                    zzw((zza - i) - zzab2);
                    this.position = zza;
                    return;
                }
                zzw(zzfz.zza(str));
                this.position = zzfz.zza(str, this.buffer, this.position, zzcz());
            } catch (zzgc e) {
                this.position = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zzc((Throwable) e2);
            }
        }

        public final void zzb(int i, int i2) throws IOException {
            zzw((i << 3) | i2);
        }

        public final void zzb(int i, zzbu zzbu) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzbu);
            zzb(1, 4);
        }

        public final void zzb(int i, zzeh zzeh) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzeh);
            zzb(1, 4);
        }

        public final void zzb(int i, boolean z) throws IOException {
            int i2 = 0;
            zzb(i, 0);
            if (z) {
                i2 = 1;
            }
            zza((byte) i2);
        }

        public final void zzb(zzeh zzeh) throws IOException {
            zzw(zzeh.zzdn());
            zzeh.zzb(this);
        }

        public final void zzc(int i, int i2) throws IOException {
            zzb(i, 0);
            zzv(i2);
        }

        public final void zzc(int i, long j) throws IOException {
            zzb(i, 1);
            zzc(j);
        }

        public final void zzc(long j) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) ((int) j);
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr2[i2] = (byte) ((int) (j >> 8));
                byte[] bArr3 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr3[i3] = (byte) ((int) (j >> 16));
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr4[i4] = (byte) ((int) (j >> 24));
                byte[] bArr5 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr5[i5] = (byte) ((int) (j >> 32));
                byte[] bArr6 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                bArr6[i6] = (byte) ((int) (j >> 40));
                byte[] bArr7 = this.buffer;
                int i7 = this.position;
                this.position = i7 + 1;
                bArr7[i7] = (byte) ((int) (j >> 48));
                byte[] bArr8 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                bArr8[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }

        public final int zzcz() {
            return this.limit - this.position;
        }

        public final void zzd(int i, int i2) throws IOException {
            zzb(i, 0);
            zzw(i2);
        }

        public final int zzdb() {
            return this.position - this.offset;
        }

        public final void zze(byte[] bArr, int i, int i2) throws IOException {
            zzw(i2);
            write(bArr, 0, i2);
        }

        public final void zzf(int i, int i2) throws IOException {
            zzb(i, 5);
            zzy(i2);
        }

        public final void zzv(int i) throws IOException {
            if (i >= 0) {
                zzw(i);
            } else {
                zza((long) i);
            }
        }

        public final void zzw(int i) throws IOException {
            if (!zzci.zzmz || zzcz() < 10) {
                while ((i & -128) != 0) {
                    try {
                        byte[] bArr = this.buffer;
                        int i2 = this.position;
                        this.position = i2 + 1;
                        bArr[i2] = (byte) ((i & 127) | 128);
                        i >>>= 7;
                    } catch (IndexOutOfBoundsException e) {
                        throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
                    }
                }
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) i;
                return;
            }
            while ((i & -128) != 0) {
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzfx.zza(bArr3, (long) i4, (byte) ((i & 127) | 128));
                i >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i5 = this.position;
            this.position = i5 + 1;
            zzfx.zza(bArr4, (long) i5, (byte) i);
        }

        public final void zzy(int i) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr4[i5] = i >> 24;
            } catch (IndexOutOfBoundsException e) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e);
            }
        }
    }

    static final class zzb extends zza {
        private final ByteBuffer zznb;
        private int zznc;

        zzb(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.zznb = byteBuffer;
            this.zznc = byteBuffer.position();
        }

        public final void flush() {
            this.zznb.position(this.zznc + zzdb());
        }
    }

    public static class zzc extends IOException {
        zzc() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        zzc(java.lang.String r4) {
            /*
                r3 = this;
                java.lang.String r0 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                java.lang.String r1 = java.lang.String.valueOf(r0)
                java.lang.String r0 = java.lang.String.valueOf(r4)
                int r2 = r0.length()
                if (r2 == 0) goto L_0x0018
                java.lang.String r0 = r1.concat(r0)
            L_0x0014:
                r3.<init>(r0)
                return
            L_0x0018:
                java.lang.String r0 = new java.lang.String
                r0.<init>(r1)
                goto L_0x0014
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzci.zzc.<init>(java.lang.String):void");
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        zzc(java.lang.String r4, java.lang.Throwable r5) {
            /*
                r3 = this;
                java.lang.String r0 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                java.lang.String r1 = java.lang.String.valueOf(r0)
                java.lang.String r0 = java.lang.String.valueOf(r4)
                int r2 = r0.length()
                if (r2 == 0) goto L_0x0018
                java.lang.String r0 = r1.concat(r0)
            L_0x0014:
                r3.<init>(r0, r5)
                return
            L_0x0018:
                java.lang.String r0 = new java.lang.String
                r0.<init>(r1)
                goto L_0x0014
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzci.zzc.<init>(java.lang.String, java.lang.Throwable):void");
        }

        zzc(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    static final class zzd extends zzci {
        private final int zznc;
        private final ByteBuffer zznd;
        private final ByteBuffer zzne;

        zzd(ByteBuffer byteBuffer) {
            super();
            this.zznd = byteBuffer;
            this.zzne = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.zznc = byteBuffer.position();
        }

        private final void zzan(String str) throws IOException {
            try {
                zzfz.zza(str, this.zzne);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc((Throwable) e);
            }
        }

        public final void flush() {
            this.zznd.position(this.zzne.position());
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                this.zzne.put(bArr, i, i2);
            } catch (IndexOutOfBoundsException e) {
                throw new zzc((Throwable) e);
            } catch (BufferOverflowException e2) {
                throw new zzc((Throwable) e2);
            }
        }

        public final void zza(byte b) throws IOException {
            try {
                this.zzne.put(b);
            } catch (BufferOverflowException e) {
                throw new zzc((Throwable) e);
            }
        }

        public final void zza(int i, long j) throws IOException {
            zzb(i, 0);
            zza(j);
        }

        public final void zza(int i, zzbu zzbu) throws IOException {
            zzb(i, 2);
            zza(zzbu);
        }

        public final void zza(int i, zzeh zzeh) throws IOException {
            zzb(i, 2);
            zzb(zzeh);
        }

        /* access modifiers changed from: package-private */
        public final void zza(int i, zzeh zzeh, zzex zzex) throws IOException {
            zzb(i, 2);
            zza(zzeh, zzex);
        }

        public final void zza(int i, String str) throws IOException {
            zzb(i, 2);
            zzal(str);
        }

        public final void zza(long j) throws IOException {
            while ((-128 & j) != 0) {
                this.zzne.put((byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            try {
                this.zzne.put((byte) ((int) j));
            } catch (BufferOverflowException e) {
                throw new zzc((Throwable) e);
            }
        }

        public final void zza(zzbu zzbu) throws IOException {
            zzw(zzbu.size());
            zzbu.zza((zzbt) this);
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzeh zzeh, zzex zzex) throws IOException {
            zzbn zzbn = (zzbn) zzeh;
            int zzbm = zzbn.zzbm();
            if (zzbm == -1) {
                zzbm = zzex.zzo(zzbn);
                zzbn.zzf(zzbm);
            }
            zzw(zzbm);
            zzex.zza(zzeh, this.zzna);
        }

        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zzal(String str) throws IOException {
            int position = this.zzne.position();
            try {
                int zzab = zzab(str.length() * 3);
                int zzab2 = zzab(str.length());
                if (zzab2 == zzab) {
                    int position2 = this.zzne.position() + zzab2;
                    this.zzne.position(position2);
                    zzan(str);
                    int position3 = this.zzne.position();
                    this.zzne.position(position);
                    zzw(position3 - position2);
                    this.zzne.position(position3);
                    return;
                }
                zzw(zzfz.zza(str));
                zzan(str);
            } catch (zzgc e) {
                this.zzne.position(position);
                zza(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzc((Throwable) e2);
            }
        }

        public final void zzb(int i, int i2) throws IOException {
            zzw((i << 3) | i2);
        }

        public final void zzb(int i, zzbu zzbu) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzbu);
            zzb(1, 4);
        }

        public final void zzb(int i, zzeh zzeh) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzeh);
            zzb(1, 4);
        }

        public final void zzb(int i, boolean z) throws IOException {
            int i2 = 0;
            zzb(i, 0);
            if (z) {
                i2 = 1;
            }
            zza((byte) i2);
        }

        public final void zzb(zzeh zzeh) throws IOException {
            zzw(zzeh.zzdn());
            zzeh.zzb(this);
        }

        public final void zzc(int i, int i2) throws IOException {
            zzb(i, 0);
            zzv(i2);
        }

        public final void zzc(int i, long j) throws IOException {
            zzb(i, 1);
            zzc(j);
        }

        public final void zzc(long j) throws IOException {
            try {
                this.zzne.putLong(j);
            } catch (BufferOverflowException e) {
                throw new zzc((Throwable) e);
            }
        }

        public final int zzcz() {
            return this.zzne.remaining();
        }

        public final void zzd(int i, int i2) throws IOException {
            zzb(i, 0);
            zzw(i2);
        }

        public final void zze(byte[] bArr, int i, int i2) throws IOException {
            zzw(i2);
            write(bArr, 0, i2);
        }

        public final void zzf(int i, int i2) throws IOException {
            zzb(i, 5);
            zzy(i2);
        }

        public final void zzv(int i) throws IOException {
            if (i >= 0) {
                zzw(i);
            } else {
                zza((long) i);
            }
        }

        public final void zzw(int i) throws IOException {
            while ((i & -128) != 0) {
                this.zzne.put((byte) ((i & 127) | 128));
                i >>>= 7;
            }
            try {
                this.zzne.put((byte) i);
            } catch (BufferOverflowException e) {
                throw new zzc((Throwable) e);
            }
        }

        public final void zzy(int i) throws IOException {
            try {
                this.zzne.putInt(i);
            } catch (BufferOverflowException e) {
                throw new zzc((Throwable) e);
            }
        }
    }

    static final class zze extends zzci {
        private final ByteBuffer zznd;
        private final ByteBuffer zzne;
        private final long zznf;
        private final long zzng;
        private final long zznh;
        private final long zzni = (this.zznh - 10);
        private long zznj = this.zzng;

        zze(ByteBuffer byteBuffer) {
            super();
            this.zznd = byteBuffer;
            this.zzne = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.zznf = zzfx.zzb(byteBuffer);
            this.zzng = this.zznf + ((long) byteBuffer.position());
            this.zznh = this.zznf + ((long) byteBuffer.limit());
        }

        private final void zzj(long j) {
            this.zzne.position((int) (j - this.zznf));
        }

        public final void flush() {
            this.zznd.position((int) (this.zznj - this.zznf));
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            if (bArr != null && i >= 0 && i2 >= 0 && bArr.length - i2 >= i && this.zznh - ((long) i2) >= this.zznj) {
                zzfx.zza(bArr, (long) i, this.zznj, (long) i2);
                this.zznj += (long) i2;
            } else if (bArr == null) {
                throw new NullPointerException(FirebaseAnalytics.Param.VALUE);
            } else {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.zznj), Long.valueOf(this.zznh), Integer.valueOf(i2)}));
            }
        }

        public final void zza(byte b) throws IOException {
            if (this.zznj >= this.zznh) {
                throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.zznj), Long.valueOf(this.zznh), 1}));
            }
            long j = this.zznj;
            this.zznj = 1 + j;
            zzfx.zza(j, b);
        }

        public final void zza(int i, long j) throws IOException {
            zzb(i, 0);
            zza(j);
        }

        public final void zza(int i, zzbu zzbu) throws IOException {
            zzb(i, 2);
            zza(zzbu);
        }

        public final void zza(int i, zzeh zzeh) throws IOException {
            zzb(i, 2);
            zzb(zzeh);
        }

        /* access modifiers changed from: package-private */
        public final void zza(int i, zzeh zzeh, zzex zzex) throws IOException {
            zzb(i, 2);
            zza(zzeh, zzex);
        }

        public final void zza(int i, String str) throws IOException {
            zzb(i, 2);
            zzal(str);
        }

        public final void zza(long j) throws IOException {
            if (this.zznj <= this.zzni) {
                while ((j & -128) != 0) {
                    long j2 = this.zznj;
                    this.zznj = j2 + 1;
                    zzfx.zza(j2, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                long j3 = this.zznj;
                this.zznj = j3 + 1;
                zzfx.zza(j3, (byte) ((int) j));
                return;
            }
            while (this.zznj < this.zznh) {
                if ((j & -128) == 0) {
                    long j4 = this.zznj;
                    this.zznj = j4 + 1;
                    zzfx.zza(j4, (byte) ((int) j));
                    return;
                }
                long j5 = this.zznj;
                this.zznj = j5 + 1;
                zzfx.zza(j5, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.zznj), Long.valueOf(this.zznh), 1}));
        }

        public final void zza(zzbu zzbu) throws IOException {
            zzw(zzbu.size());
            zzbu.zza((zzbt) this);
        }

        /* access modifiers changed from: package-private */
        public final void zza(zzeh zzeh, zzex zzex) throws IOException {
            zzbn zzbn = (zzbn) zzeh;
            int zzbm = zzbn.zzbm();
            if (zzbm == -1) {
                zzbm = zzex.zzo(zzbn);
                zzbn.zzf(zzbm);
            }
            zzw(zzbm);
            zzex.zza(zzeh, this.zzna);
        }

        public final void zza(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        public final void zzal(String str) throws IOException {
            long j = this.zznj;
            try {
                int zzab = zzab(str.length() * 3);
                int zzab2 = zzab(str.length());
                if (zzab2 == zzab) {
                    int i = ((int) (this.zznj - this.zznf)) + zzab2;
                    this.zzne.position(i);
                    zzfz.zza(str, this.zzne);
                    int position = this.zzne.position() - i;
                    zzw(position);
                    this.zznj = ((long) position) + this.zznj;
                    return;
                }
                int zza = zzfz.zza(str);
                zzw(zza);
                zzj(this.zznj);
                zzfz.zza(str, this.zzne);
                this.zznj = ((long) zza) + this.zznj;
            } catch (zzgc e) {
                this.zznj = j;
                zzj(this.zznj);
                zza(str, e);
            } catch (IllegalArgumentException e2) {
                throw new zzc((Throwable) e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zzc((Throwable) e3);
            }
        }

        public final void zzb(int i, int i2) throws IOException {
            zzw((i << 3) | i2);
        }

        public final void zzb(int i, zzbu zzbu) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzbu);
            zzb(1, 4);
        }

        public final void zzb(int i, zzeh zzeh) throws IOException {
            zzb(1, 3);
            zzd(2, i);
            zza(3, zzeh);
            zzb(1, 4);
        }

        public final void zzb(int i, boolean z) throws IOException {
            int i2 = 0;
            zzb(i, 0);
            if (z) {
                i2 = 1;
            }
            zza((byte) i2);
        }

        public final void zzb(zzeh zzeh) throws IOException {
            zzw(zzeh.zzdn());
            zzeh.zzb(this);
        }

        public final void zzc(int i, int i2) throws IOException {
            zzb(i, 0);
            zzv(i2);
        }

        public final void zzc(int i, long j) throws IOException {
            zzb(i, 1);
            zzc(j);
        }

        public final void zzc(long j) throws IOException {
            this.zzne.putLong((int) (this.zznj - this.zznf), j);
            this.zznj += 8;
        }

        public final int zzcz() {
            return (int) (this.zznh - this.zznj);
        }

        public final void zzd(int i, int i2) throws IOException {
            zzb(i, 0);
            zzw(i2);
        }

        public final void zze(byte[] bArr, int i, int i2) throws IOException {
            zzw(i2);
            write(bArr, 0, i2);
        }

        public final void zzf(int i, int i2) throws IOException {
            zzb(i, 5);
            zzy(i2);
        }

        public final void zzv(int i) throws IOException {
            if (i >= 0) {
                zzw(i);
            } else {
                zza((long) i);
            }
        }

        public final void zzw(int i) throws IOException {
            if (this.zznj <= this.zzni) {
                while ((i & -128) != 0) {
                    long j = this.zznj;
                    this.zznj = j + 1;
                    zzfx.zza(j, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                long j2 = this.zznj;
                this.zznj = j2 + 1;
                zzfx.zza(j2, (byte) i);
                return;
            }
            while (this.zznj < this.zznh) {
                if ((i & -128) == 0) {
                    long j3 = this.zznj;
                    this.zznj = j3 + 1;
                    zzfx.zza(j3, (byte) i);
                    return;
                }
                long j4 = this.zznj;
                this.zznj = j4 + 1;
                zzfx.zza(j4, (byte) ((i & 127) | 128));
                i >>>= 7;
            }
            throw new zzc(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.zznj), Long.valueOf(this.zznh), 1}));
        }

        public final void zzy(int i) throws IOException {
            this.zzne.putInt((int) (this.zznj - this.zznf), i);
            this.zznj += 4;
        }
    }

    private zzci() {
    }

    public static int zza(int i, zzdo zzdo) {
        int zzz = zzz(i);
        int zzdn = zzdo.zzdn();
        return zzz + zzdn + zzab(zzdn);
    }

    public static int zza(zzdo zzdo) {
        int zzdn = zzdo.zzdn();
        return zzdn + zzab(zzdn);
    }

    public static zzci zza(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new zzb(byteBuffer);
        }
        if (byteBuffer.isDirect() && !byteBuffer.isReadOnly()) {
            return zzfx.zzgv() ? new zze(byteBuffer) : new zzd(byteBuffer);
        }
        throw new IllegalArgumentException("ByteBuffer is read-only");
    }

    public static int zzaa(int i) {
        if (i >= 0) {
            return zzab(i);
        }
        return 10;
    }

    public static int zzab(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int zzac(int i) {
        return zzab(zzag(i));
    }

    public static int zzad(int i) {
        return 4;
    }

    public static int zzae(int i) {
        return 4;
    }

    public static int zzaf(int i) {
        return zzaa(i);
    }

    private static int zzag(int i) {
        return (i << 1) ^ (i >> 31);
    }

    @Deprecated
    public static int zzah(int i) {
        return zzab(i);
    }

    public static int zzam(String str) {
        int length;
        try {
            length = zzfz.zza(str);
        } catch (zzgc e) {
            length = str.getBytes(zzdd.UTF_8).length;
        }
        return length + zzab(length);
    }

    public static int zzb(double d) {
        return 8;
    }

    public static int zzb(float f) {
        return 4;
    }

    public static int zzb(int i, double d) {
        return zzz(i) + 8;
    }

    public static int zzb(int i, float f) {
        return zzz(i) + 4;
    }

    public static int zzb(int i, zzdo zzdo) {
        return (zzz(1) << 1) + zzh(2, i) + zza(3, zzdo);
    }

    static int zzb(int i, zzeh zzeh, zzex zzex) {
        return zzz(i) + zzb(zzeh, zzex);
    }

    public static int zzb(int i, String str) {
        return zzz(i) + zzam(str);
    }

    public static int zzb(zzbu zzbu) {
        int size = zzbu.size();
        return size + zzab(size);
    }

    static int zzb(zzeh zzeh, zzex zzex) {
        zzbn zzbn = (zzbn) zzeh;
        int zzbm = zzbn.zzbm();
        if (zzbm == -1) {
            zzbm = zzex.zzo(zzbn);
            zzbn.zzf(zzbm);
        }
        return zzbm + zzab(zzbm);
    }

    public static zzci zzb(byte[] bArr) {
        return new zza(bArr, 0, bArr.length);
    }

    public static int zzc(int i, zzbu zzbu) {
        int zzz = zzz(i);
        int size = zzbu.size();
        return zzz + size + zzab(size);
    }

    public static int zzc(int i, zzeh zzeh) {
        return zzz(i) + zzc(zzeh);
    }

    @Deprecated
    static int zzc(int i, zzeh zzeh, zzex zzex) {
        int zzz = zzz(i) << 1;
        zzbn zzbn = (zzbn) zzeh;
        int zzbm = zzbn.zzbm();
        if (zzbm == -1) {
            zzbm = zzex.zzo(zzbn);
            zzbn.zzf(zzbm);
        }
        return zzbm + zzz;
    }

    public static int zzc(int i, boolean z) {
        return zzz(i) + 1;
    }

    public static int zzc(zzeh zzeh) {
        int zzdn = zzeh.zzdn();
        return zzdn + zzab(zzdn);
    }

    public static int zzc(byte[] bArr) {
        int length = bArr.length;
        return length + zzab(length);
    }

    public static int zzd(int i, long j) {
        return zzz(i) + zze(j);
    }

    public static int zzd(int i, zzbu zzbu) {
        return (zzz(1) << 1) + zzh(2, i) + zzc(3, zzbu);
    }

    public static int zzd(int i, zzeh zzeh) {
        return (zzz(1) << 1) + zzh(2, i) + zzc(3, zzeh);
    }

    public static int zzd(long j) {
        return zze(j);
    }

    @Deprecated
    public static int zzd(zzeh zzeh) {
        return zzeh.zzdn();
    }

    public static int zze(int i, long j) {
        return zzz(i) + zze(j);
    }

    public static int zze(long j) {
        long j2;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        int i = 2;
        if ((-34359738368L & j) != 0) {
            i = 6;
            j2 = j >>> 28;
        } else {
            j2 = j;
        }
        if ((-2097152 & j2) != 0) {
            i += 2;
            j2 >>>= 14;
        }
        return (j2 & -16384) != 0 ? i + 1 : i;
    }

    public static int zzf(int i, long j) {
        return zzz(i) + zze(zzi(j));
    }

    public static int zzf(long j) {
        return zze(zzi(j));
    }

    public static int zzg(int i, int i2) {
        return zzz(i) + zzaa(i2);
    }

    public static int zzg(int i, long j) {
        return zzz(i) + 8;
    }

    public static int zzg(long j) {
        return 8;
    }

    public static int zzh(int i, int i2) {
        return zzz(i) + zzab(i2);
    }

    public static int zzh(int i, long j) {
        return zzz(i) + 8;
    }

    public static int zzh(long j) {
        return 8;
    }

    public static int zzh(boolean z) {
        return 1;
    }

    public static int zzi(int i, int i2) {
        return zzz(i) + zzab(zzag(i2));
    }

    private static long zzi(long j) {
        return (j << 1) ^ (j >> 63);
    }

    public static int zzj(int i, int i2) {
        return zzz(i) + 4;
    }

    public static int zzk(int i, int i2) {
        return zzz(i) + 4;
    }

    public static int zzl(int i, int i2) {
        return zzz(i) + zzaa(i2);
    }

    public static int zzz(int i) {
        return zzab(i << 3);
    }

    public abstract void flush() throws IOException;

    public abstract void write(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zza(byte b) throws IOException;

    public final void zza(double d) throws IOException {
        zzc(Double.doubleToRawLongBits(d));
    }

    public final void zza(float f) throws IOException {
        zzy(Float.floatToRawIntBits(f));
    }

    public final void zza(int i, double d) throws IOException {
        zzc(i, Double.doubleToRawLongBits(d));
    }

    public final void zza(int i, float f) throws IOException {
        zzf(i, Float.floatToRawIntBits(f));
    }

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzbu zzbu) throws IOException;

    public abstract void zza(int i, zzeh zzeh) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(int i, zzeh zzeh, zzex zzex) throws IOException;

    public abstract void zza(int i, String str) throws IOException;

    public abstract void zza(long j) throws IOException;

    public abstract void zza(zzbu zzbu) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(zzeh zzeh, zzex zzex) throws IOException;

    /* access modifiers changed from: package-private */
    public final void zza(String str, zzgc zzgc) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzgc);
        byte[] bytes = str.getBytes(zzdd.UTF_8);
        try {
            zzw(bytes.length);
            zza(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzc((Throwable) e);
        } catch (zzc e2) {
            throw e2;
        }
    }

    public abstract void zzal(String str) throws IOException;

    public abstract void zzb(int i, int i2) throws IOException;

    public final void zzb(int i, long j) throws IOException {
        zza(i, zzi(j));
    }

    public abstract void zzb(int i, zzbu zzbu) throws IOException;

    public abstract void zzb(int i, zzeh zzeh) throws IOException;

    public abstract void zzb(int i, boolean z) throws IOException;

    public final void zzb(long j) throws IOException {
        zza(zzi(j));
    }

    public abstract void zzb(zzeh zzeh) throws IOException;

    public abstract void zzc(int i, int i2) throws IOException;

    public abstract void zzc(int i, long j) throws IOException;

    public abstract void zzc(long j) throws IOException;

    public abstract int zzcz();

    public abstract void zzd(int i, int i2) throws IOException;

    public final void zze(int i, int i2) throws IOException {
        zzd(i, zzag(i2));
    }

    /* access modifiers changed from: package-private */
    public abstract void zze(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzf(int i, int i2) throws IOException;

    public final void zzg(boolean z) throws IOException {
        zza((byte) (z ? 1 : 0));
    }

    public abstract void zzv(int i) throws IOException;

    public abstract void zzw(int i) throws IOException;

    public final void zzx(int i) throws IOException {
        zzw(zzag(i));
    }

    public abstract void zzy(int i) throws IOException;
}
