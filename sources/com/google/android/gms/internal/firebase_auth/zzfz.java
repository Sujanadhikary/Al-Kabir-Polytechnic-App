package com.google.android.gms.internal.firebase_auth;

import java.nio.ByteBuffer;

final class zzfz {
    private static final zzga zzxa = (zzfx.zzgu() && zzfx.zzgv() ? new zzgd() : new zzgb());

    static int zza(CharSequence charSequence) {
        int i;
        int i2 = 0;
        int length = charSequence.length();
        int i3 = 0;
        while (i3 < length && charSequence.charAt(i3) < 128) {
            i3++;
        }
        int i4 = length;
        while (true) {
            if (i3 >= length) {
                i = i4;
                break;
            }
            char charAt = charSequence.charAt(i3);
            if (charAt < 2048) {
                i4 += (127 - charAt) >>> 31;
                i3++;
            } else {
                int length2 = charSequence.length();
                while (i3 < length2) {
                    char charAt2 = charSequence.charAt(i3);
                    if (charAt2 < 2048) {
                        i2 += (127 - charAt2) >>> 31;
                    } else {
                        i2 += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i3) < 65536) {
                                throw new zzgc(i3, length2);
                            }
                            i3++;
                        }
                    }
                    i3++;
                }
                i = i4 + i2;
            }
        }
        if (i >= length) {
            return i;
        }
        throw new IllegalArgumentException(new StringBuilder(54).append("UTF-8 length does not fit in int: ").append(((long) i) + 4294967296L).toString());
    }

    static int zza(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return zzxa.zzb(charSequence, bArr, i, i2);
    }

    static void zza(CharSequence charSequence, ByteBuffer byteBuffer) {
        zzga zzga = zzxa;
        if (byteBuffer.hasArray()) {
            int arrayOffset = byteBuffer.arrayOffset();
            byteBuffer.position(zza(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
        } else if (byteBuffer.isDirect()) {
            zzga.zzb(charSequence, byteBuffer);
        } else {
            zzga.zzc(charSequence, byteBuffer);
        }
    }

    /* access modifiers changed from: private */
    public static int zzaw(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    /* access modifiers changed from: private */
    public static int zzd(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return ((i2 << 8) ^ i) ^ (i3 << 16);
    }

    public static boolean zzd(byte[] bArr) {
        return zzxa.zzf(bArr, 0, bArr.length);
    }

    public static boolean zzf(byte[] bArr, int i, int i2) {
        return zzxa.zzf(bArr, i, i2);
    }

    /* access modifiers changed from: private */
    public static int zzg(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        switch (i2 - i) {
            case 0:
                return zzaw(b);
            case 1:
                return zzp(b, bArr[i]);
            case 2:
                return zzd(b, bArr[i], bArr[i + 1]);
            default:
                throw new AssertionError();
        }
    }

    /* access modifiers changed from: private */
    public static int zzp(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return (i2 << 8) ^ i;
    }
}
