package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;
import java.util.Arrays;

public final class zzacc {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    protected static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final Object zzbxg = new Object();

    public static boolean equals(int[] iArr, int[] iArr2) {
        return (iArr == null || iArr.length == 0) ? iArr2 == null || iArr2.length == 0 : Arrays.equals(iArr, iArr2);
    }

    public static boolean equals(long[] jArr, long[] jArr2) {
        return (jArr == null || jArr.length == 0) ? jArr2 == null || jArr2.length == 0 : Arrays.equals(jArr, jArr2);
    }

    public static boolean equals(Object[] objArr, Object[] objArr2) {
        int length = objArr == null ? 0 : objArr.length;
        int length2 = objArr2 == null ? 0 : objArr2.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length || objArr[i2] != null) {
                int i3 = i;
                while (i3 < length2 && objArr2[i3] == null) {
                    i3++;
                }
                boolean z = i2 >= length;
                boolean z2 = i3 >= length2;
                if (z && z2) {
                    return true;
                }
                if (z != z2 || !objArr[i2].equals(objArr2[i3])) {
                    return false;
                }
                i = i3 + 1;
                i2++;
            } else {
                i2++;
            }
        }
    }

    public static int hashCode(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return 0;
        }
        return Arrays.hashCode(iArr);
    }

    public static int hashCode(long[] jArr) {
        if (jArr == null || jArr.length == 0) {
            return 0;
        }
        return Arrays.hashCode(jArr);
    }

    public static int hashCode(Object[] objArr) {
        int i = 0;
        int length = objArr == null ? 0 : objArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            Object obj = objArr[i2];
            if (obj != null) {
                i = (i * 31) + obj.hashCode();
            }
        }
        return i;
    }

    public static void zza(zzaby zzaby, zzaby zzaby2) {
        if (zzaby.zzbww != null) {
            zzaby2.zzbww = (zzaca) zzaby.zzbww.clone();
        }
    }
}
