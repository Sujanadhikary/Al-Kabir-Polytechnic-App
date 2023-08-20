package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;

public final class zzgm {
    private final byte[] buffer;
    private int zzmk;
    private int zzml = 64;
    private int zzmm = 67108864;
    private int zzmr;
    private int zzmt;
    private int zzmu = Integer.MAX_VALUE;
    private final int zzyg;
    private final int zzyh;
    private int zzyi;
    private int zzyj;
    private zzcd zzyk;

    private zzgm(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.zzyg = i;
        int i3 = i + i2;
        this.zzyi = i3;
        this.zzyh = i3;
        this.zzyj = i;
    }

    private final void zzcv() {
        this.zzyi += this.zzmr;
        int i = this.zzyi;
        if (i > this.zzmu) {
            this.zzmr = i - this.zzmu;
            this.zzyi -= this.zzmr;
            return;
        }
        this.zzmr = 0;
    }

    private final byte zzcw() throws IOException {
        if (this.zzyj == this.zzyi) {
            throw zzgu.zzhh();
        }
        byte[] bArr = this.buffer;
        int i = this.zzyj;
        this.zzyj = i + 1;
        return bArr[i];
    }

    public static zzgm zzi(byte[] bArr, int i, int i2) {
        return new zzgm(bArr, 0, i2);
    }

    private final void zzq(int i) throws IOException {
        if (i < 0) {
            throw zzgu.zzhi();
        } else if (this.zzyj + i > this.zzmu) {
            zzq(this.zzmu - this.zzyj);
            throw zzgu.zzhh();
        } else if (i <= this.zzyi - this.zzyj) {
            this.zzyj += i;
        } else {
            throw zzgu.zzhh();
        }
    }

    public final int getPosition() {
        return this.zzyj - this.zzyg;
    }

    public final byte[] readBytes() throws IOException {
        int zzcr = zzcr();
        if (zzcr < 0) {
            throw zzgu.zzhi();
        } else if (zzcr == 0) {
            return zzgy.zzzh;
        } else {
            if (zzcr > this.zzyi - this.zzyj) {
                throw zzgu.zzhh();
            }
            byte[] bArr = new byte[zzcr];
            System.arraycopy(this.buffer, this.zzyj, bArr, 0, zzcr);
            this.zzyj = zzcr + this.zzyj;
            return bArr;
        }
    }

    public final String readString() throws IOException {
        int zzcr = zzcr();
        if (zzcr < 0) {
            throw zzgu.zzhi();
        } else if (zzcr > this.zzyi - this.zzyj) {
            throw zzgu.zzhh();
        } else {
            String str = new String(this.buffer, this.zzyj, zzcr, zzgt.UTF_8);
            this.zzyj = zzcr + this.zzyj;
            return str;
        }
    }

    public final <T extends zzdb<T, ?>> T zza(zzer<T> zzer) throws IOException {
        if (this.zzyk == null) {
            this.zzyk = zzcd.zzd(this.buffer, this.zzyg, this.zzyh);
        }
        int zzcq = this.zzyk.zzcq();
        int i = this.zzyj - this.zzyg;
        if (zzcq > i) {
            throw new IOException(String.format("CodedInputStream read ahead of CodedInputByteBufferNano: %s > %s", new Object[]{Integer.valueOf(zzcq), Integer.valueOf(i)}));
        }
        this.zzyk.zzq(i - zzcq);
        this.zzyk.zzn(this.zzml - this.zzmk);
        T t = (zzdb) this.zzyk.zza(zzer, zzco.zzdi());
        zzm(this.zzmt);
        return t;
    }

    public final void zzay(int i) {
        zzs(i, this.zzmt);
    }

    public final void zzb(zzgv zzgv) throws IOException {
        int zzcr = zzcr();
        if (this.zzmk >= this.zzml) {
            throw new zzgu("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int zzo = zzo(zzcr);
        this.zzmk++;
        zzgv.zza(this);
        zzl(0);
        this.zzmk--;
        zzp(zzo);
    }

    public final int zzbz() throws IOException {
        if (this.zzyj == this.zzyi) {
            this.zzmt = 0;
            return 0;
        }
        this.zzmt = zzcr();
        if (this.zzmt != 0) {
            return this.zzmt;
        }
        throw new zzgu("Protocol message contained an invalid tag (zero).");
    }

    public final long zzcb() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzcw = zzcw();
            j |= ((long) (zzcw & Byte.MAX_VALUE)) << i;
            if ((zzcw & 128) == 0) {
                return j;
            }
        }
        throw zzgu.zzhj();
    }

    public final boolean zzcf() throws IOException {
        return zzcr() != 0;
    }

    public final int zzcr() throws IOException {
        byte zzcw = zzcw();
        if (zzcw >= 0) {
            return zzcw;
        }
        byte b = zzcw & Byte.MAX_VALUE;
        byte zzcw2 = zzcw();
        if (zzcw2 >= 0) {
            return b | (zzcw2 << 7);
        }
        byte b2 = b | ((zzcw2 & Byte.MAX_VALUE) << 7);
        byte zzcw3 = zzcw();
        if (zzcw3 >= 0) {
            return b2 | (zzcw3 << 14);
        }
        byte b3 = b2 | ((zzcw3 & Byte.MAX_VALUE) << 14);
        byte zzcw4 = zzcw();
        if (zzcw4 >= 0) {
            return b3 | (zzcw4 << 21);
        }
        byte b4 = b3 | ((zzcw4 & Byte.MAX_VALUE) << 21);
        byte zzcw5 = zzcw();
        byte b5 = b4 | (zzcw5 << 28);
        if (zzcw5 >= 0) {
            return b5;
        }
        for (int i = 0; i < 5; i++) {
            if (zzcw() >= 0) {
                return b5;
            }
        }
        throw zzgu.zzhj();
    }

    public final long zzcs() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzcw = zzcw();
            j |= ((long) (zzcw & Byte.MAX_VALUE)) << i;
            if ((zzcw & 128) == 0) {
                return j;
            }
        }
        throw zzgu.zzhj();
    }

    public final int zzhd() {
        if (this.zzmu == Integer.MAX_VALUE) {
            return -1;
        }
        return this.zzmu - this.zzyj;
    }

    public final void zzl(int i) throws zzgu {
        if (this.zzmt != i) {
            throw new zzgu("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean zzm(int i) throws IOException {
        int zzbz;
        switch (i & 7) {
            case 0:
                zzcr();
                return true;
            case 1:
                zzcw();
                zzcw();
                zzcw();
                zzcw();
                zzcw();
                zzcw();
                zzcw();
                zzcw();
                return true;
            case 2:
                zzq(zzcr());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzcw();
                zzcw();
                zzcw();
                zzcw();
                return true;
            default:
                throw new zzgu("Protocol message tag had invalid wire type.");
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

    public final int zzo(int i) throws zzgu {
        if (i < 0) {
            throw zzgu.zzhi();
        }
        int i2 = this.zzyj + i;
        int i3 = this.zzmu;
        if (i2 > i3) {
            throw zzgu.zzhh();
        }
        this.zzmu = i2;
        zzcv();
        return i3;
    }

    public final void zzp(int i) {
        this.zzmu = i;
        zzcv();
    }

    public final byte[] zzr(int i, int i2) {
        if (i2 == 0) {
            return zzgy.zzzh;
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.buffer, this.zzyg + i, bArr, 0, i2);
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public final void zzs(int i, int i2) {
        if (i > this.zzyj - this.zzyg) {
            throw new IllegalArgumentException(new StringBuilder(50).append("Position ").append(i).append(" is beyond current ").append(this.zzyj - this.zzyg).toString());
        } else if (i < 0) {
            throw new IllegalArgumentException(new StringBuilder(24).append("Bad position ").append(i).toString());
        } else {
            this.zzyj = this.zzyg + i;
            this.zzmt = i2;
        }
    }
}
