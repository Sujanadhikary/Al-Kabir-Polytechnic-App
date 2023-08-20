package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.util.Arrays;

final class zzcf extends zzcd {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzmq;
    private int zzmr;
    private int zzms;
    private int zzmt;
    private int zzmu;

    private zzcf(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzmu = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i + i2;
        this.pos = i;
        this.zzms = this.pos;
        this.zzmq = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006a, code lost:
        if (r3[r2] < 0) goto L_0x006c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzcr() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.pos
            int r1 = r5.limit
            if (r1 == r0) goto L_0x006c
            byte[] r3 = r5.buffer
            int r2 = r0 + 1
            byte r0 = r3[r0]
            if (r0 < 0) goto L_0x0011
            r5.pos = r2
        L_0x0010:
            return r0
        L_0x0011:
            int r1 = r5.limit
            int r1 = r1 - r2
            r4 = 9
            if (r1 < r4) goto L_0x006c
            int r1 = r2 + 1
            byte r2 = r3[r2]
            int r2 = r2 << 7
            r0 = r0 ^ r2
            if (r0 >= 0) goto L_0x0026
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
        L_0x0023:
            r5.pos = r1
            goto L_0x0010
        L_0x0026:
            int r2 = r1 + 1
            byte r1 = r3[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0033
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            r1 = r2
            goto L_0x0023
        L_0x0033:
            int r1 = r2 + 1
            byte r2 = r3[r2]
            int r2 = r2 << 21
            r0 = r0 ^ r2
            if (r0 >= 0) goto L_0x0041
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0023
        L_0x0041:
            int r2 = r1 + 1
            byte r1 = r3[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x0072
            int r1 = r2 + 1
            byte r2 = r3[r2]
            if (r2 >= 0) goto L_0x0023
            int r2 = r1 + 1
            byte r1 = r3[r1]
            if (r1 >= 0) goto L_0x0072
            int r1 = r2 + 1
            byte r2 = r3[r2]
            if (r2 >= 0) goto L_0x0023
            int r2 = r1 + 1
            byte r1 = r3[r1]
            if (r1 >= 0) goto L_0x0072
            int r1 = r2 + 1
            byte r2 = r3[r2]
            if (r2 >= 0) goto L_0x0023
        L_0x006c:
            long r0 = r5.zzco()
            int r0 = (int) r0
            goto L_0x0010
        L_0x0072:
            r1 = r2
            goto L_0x0023
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzcf.zzcr():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b2, code lost:
        if (((long) r4[r3]) < 0) goto L_0x00b4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zzcs() throws java.io.IOException {
        /*
            r10 = this;
            r8 = 0
            int r0 = r10.pos
            int r1 = r10.limit
            if (r1 == r0) goto L_0x00b4
            byte[] r4 = r10.buffer
            int r1 = r0 + 1
            byte r0 = r4[r0]
            if (r0 < 0) goto L_0x0014
            r10.pos = r1
            long r0 = (long) r0
        L_0x0013:
            return r0
        L_0x0014:
            int r2 = r10.limit
            int r2 = r2 - r1
            r3 = 9
            if (r2 < r3) goto L_0x00b4
            int r2 = r1 + 1
            byte r1 = r4[r1]
            int r1 = r1 << 7
            r0 = r0 ^ r1
            if (r0 >= 0) goto L_0x002a
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            long r0 = (long) r0
        L_0x0027:
            r10.pos = r2
            goto L_0x0013
        L_0x002a:
            int r3 = r2 + 1
            byte r1 = r4[r2]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0038
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            long r0 = (long) r0
            r2 = r3
            goto L_0x0027
        L_0x0038:
            int r2 = r3 + 1
            byte r1 = r4[r3]
            int r1 = r1 << 21
            r0 = r0 ^ r1
            if (r0 >= 0) goto L_0x0047
            r1 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r1
            long r0 = (long) r0
            goto L_0x0027
        L_0x0047:
            long r0 = (long) r0
            int r3 = r2 + 1
            byte r2 = r4[r2]
            long r6 = (long) r2
            r2 = 28
            long r6 = r6 << r2
            long r0 = r0 ^ r6
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 < 0) goto L_0x005b
            r4 = 266354560(0xfe03f80, double:1.315966377E-315)
            long r0 = r0 ^ r4
            r2 = r3
            goto L_0x0027
        L_0x005b:
            int r2 = r3 + 1
            byte r3 = r4[r3]
            long r6 = (long) r3
            r3 = 35
            long r6 = r6 << r3
            long r0 = r0 ^ r6
            int r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x006f
            r4 = -34093383808(0xfffffff80fe03f80, double:NaN)
            long r0 = r0 ^ r4
            goto L_0x0027
        L_0x006f:
            int r3 = r2 + 1
            byte r2 = r4[r2]
            long r6 = (long) r2
            r2 = 42
            long r6 = r6 << r2
            long r0 = r0 ^ r6
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 < 0) goto L_0x0084
            r4 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            long r0 = r0 ^ r4
            r2 = r3
            goto L_0x0027
        L_0x0084:
            int r2 = r3 + 1
            byte r3 = r4[r3]
            long r6 = (long) r3
            r3 = 49
            long r6 = r6 << r3
            long r0 = r0 ^ r6
            int r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x0098
            r4 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            long r0 = r0 ^ r4
            goto L_0x0027
        L_0x0098:
            int r3 = r2 + 1
            byte r2 = r4[r2]
            long r6 = (long) r2
            r2 = 56
            long r6 = r6 << r2
            long r0 = r0 ^ r6
            r6 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r0 = r0 ^ r6
            int r2 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x00ba
            int r2 = r3 + 1
            byte r3 = r4[r3]
            long r4 = (long) r3
            int r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r3 >= 0) goto L_0x0027
        L_0x00b4:
            long r0 = r10.zzco()
            goto L_0x0013
        L_0x00ba:
            r2 = r3
            goto L_0x0027
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzcf.zzcs():long");
    }

    private final int zzct() throws IOException {
        int i = this.pos;
        if (this.limit - i < 4) {
            throw zzdh.zzeb();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long zzcu() throws IOException {
        int i = this.pos;
        if (this.limit - i < 8) {
            throw zzdh.zzeb();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    private final void zzcv() {
        this.limit += this.zzmr;
        int i = this.limit - this.zzms;
        if (i > this.zzmu) {
            this.zzmr = i - this.zzmu;
            this.limit -= this.zzmr;
            return;
        }
        this.zzmr = 0;
    }

    private final byte zzcw() throws IOException {
        if (this.pos == this.limit) {
            throw zzdh.zzeb();
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzcu());
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzct());
    }

    public final String readString() throws IOException {
        int zzcr = zzcr();
        if (zzcr > 0 && zzcr <= this.limit - this.pos) {
            String str = new String(this.buffer, this.pos, zzcr, zzdd.UTF_8);
            this.pos = zzcr + this.pos;
            return str;
        } else if (zzcr == 0) {
            return "";
        } else {
            if (zzcr < 0) {
                throw zzdh.zzec();
            }
            throw zzdh.zzeb();
        }
    }

    public final <T extends zzeh> T zza(zzer<T> zzer, zzco zzco) throws IOException {
        int zzcr = zzcr();
        if (this.zzmk >= this.zzml) {
            throw zzdh.zzeg();
        }
        int zzo = zzo(zzcr);
        this.zzmk++;
        T t = (zzeh) zzer.zza(this, zzco);
        zzl(0);
        this.zzmk--;
        zzp(zzo);
        return t;
    }

    public final int zzbz() throws IOException {
        if (zzcp()) {
            this.zzmt = 0;
            return 0;
        }
        this.zzmt = zzcr();
        if ((this.zzmt >>> 3) != 0) {
            return this.zzmt;
        }
        throw new zzdh("Protocol message contained an invalid tag (zero).");
    }

    public final long zzca() throws IOException {
        return zzcs();
    }

    public final long zzcb() throws IOException {
        return zzcs();
    }

    public final int zzcc() throws IOException {
        return zzcr();
    }

    public final long zzcd() throws IOException {
        return zzcu();
    }

    public final int zzce() throws IOException {
        return zzct();
    }

    public final boolean zzcf() throws IOException {
        return zzcs() != 0;
    }

    public final String zzcg() throws IOException {
        int zzcr = zzcr();
        if (zzcr <= 0 || zzcr > this.limit - this.pos) {
            if (zzcr == 0) {
                return "";
            }
            if (zzcr <= 0) {
                throw zzdh.zzec();
            }
            throw zzdh.zzeb();
        } else if (!zzfz.zzf(this.buffer, this.pos, this.pos + zzcr)) {
            throw new zzdh("Protocol message had invalid UTF-8.");
        } else {
            int i = this.pos;
            this.pos += zzcr;
            return new String(this.buffer, i, zzcr, zzdd.UTF_8);
        }
    }

    public final zzbu zzch() throws IOException {
        byte[] bArr;
        int zzcr = zzcr();
        if (zzcr > 0 && zzcr <= this.limit - this.pos) {
            zzbu zzb = zzbu.zzb(this.buffer, this.pos, zzcr);
            this.pos = zzcr + this.pos;
            return zzb;
        } else if (zzcr == 0) {
            return zzbu.zzmc;
        } else {
            if (zzcr > 0 && zzcr <= this.limit - this.pos) {
                int i = this.pos;
                this.pos = zzcr + this.pos;
                bArr = Arrays.copyOfRange(this.buffer, i, this.pos);
            } else if (zzcr > 0) {
                throw zzdh.zzeb();
            } else if (zzcr == 0) {
                bArr = zzdd.EMPTY_BYTE_ARRAY;
            } else {
                throw zzdh.zzec();
            }
            return zzbu.zza(bArr);
        }
    }

    public final int zzci() throws IOException {
        return zzcr();
    }

    public final int zzcj() throws IOException {
        return zzcr();
    }

    public final int zzck() throws IOException {
        return zzct();
    }

    public final long zzcl() throws IOException {
        return zzcu();
    }

    public final int zzcm() throws IOException {
        int zzcr = zzcr();
        return (-(zzcr & 1)) ^ (zzcr >>> 1);
    }

    public final long zzcn() throws IOException {
        long zzcs = zzcs();
        return (-(zzcs & 1)) ^ (zzcs >>> 1);
    }

    /* access modifiers changed from: package-private */
    public final long zzco() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzcw = zzcw();
            j |= ((long) (zzcw & Byte.MAX_VALUE)) << i;
            if ((zzcw & 128) == 0) {
                return j;
            }
        }
        throw zzdh.zzed();
    }

    public final boolean zzcp() throws IOException {
        return this.pos == this.limit;
    }

    public final int zzcq() {
        return this.pos - this.zzms;
    }

    public final void zzl(int i) throws zzdh {
        if (this.zzmt != i) {
            throw zzdh.zzee();
        }
    }

    public final boolean zzm(int i) throws IOException {
        int zzbz;
        int i2 = 0;
        switch (i & 7) {
            case 0:
                if (this.limit - this.pos >= 10) {
                    while (i2 < 10) {
                        byte[] bArr = this.buffer;
                        int i3 = this.pos;
                        this.pos = i3 + 1;
                        if (bArr[i3] >= 0) {
                            return true;
                        }
                        i2++;
                    }
                    throw zzdh.zzed();
                }
                while (i2 < 10) {
                    if (zzcw() >= 0) {
                        return true;
                    }
                    i2++;
                }
                throw zzdh.zzed();
            case 1:
                zzq(8);
                return true;
            case 2:
                zzq(zzcr());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzq(4);
                return true;
            default:
                throw zzdh.zzef();
        }
        do {
            zzbz = zzbz();
            if (zzbz == 0 || !zzm(zzbz)) {
                zzl(((i >>> 3) << 3) | 4);
                return true;
            }
            zzbz = zzbz();
            zzl(((i >>> 3) << 3) | 4);
            return true;
        } while (!zzm(zzbz));
        zzl(((i >>> 3) << 3) | 4);
        return true;
    }

    public final int zzo(int i) throws zzdh {
        if (i < 0) {
            throw zzdh.zzec();
        }
        int zzcq = zzcq() + i;
        int i2 = this.zzmu;
        if (zzcq > i2) {
            throw zzdh.zzeb();
        }
        this.zzmu = zzcq;
        zzcv();
        return i2;
    }

    public final void zzp(int i) {
        this.zzmu = i;
        zzcv();
    }

    public final void zzq(int i) throws IOException {
        if (i >= 0 && i <= this.limit - this.pos) {
            this.pos += i;
        } else if (i < 0) {
            throw zzdh.zzec();
        } else {
            throw zzdh.zzeb();
        }
    }
}
