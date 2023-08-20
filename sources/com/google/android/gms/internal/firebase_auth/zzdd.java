package com.google.android.gms.internal.firebase_auth;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzdd {
    public static final byte[] EMPTY_BYTE_ARRAY;
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final ByteBuffer zzro;
    private static final zzcd zzrp;

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        zzro = ByteBuffer.wrap(bArr);
        byte[] bArr2 = EMPTY_BYTE_ARRAY;
        zzrp = zzcd.zza(bArr2, 0, bArr2.length, false);
    }

    static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int zza = zza(length, bArr, 0, length);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static Object zza(Object obj, Object obj2) {
        return ((zzeh) obj).zzdw().zza((zzeh) obj2).zzdz();
    }

    static <T> T zza(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean zzd(byte[] bArr) {
        return zzfz.zzd(bArr);
    }

    public static String zze(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    static boolean zzf(zzeh zzeh) {
        return false;
    }

    public static int zzi(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zzk(long j) {
        return (int) ((j >>> 32) ^ j);
    }
}
