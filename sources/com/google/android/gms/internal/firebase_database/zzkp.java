package com.google.android.gms.internal.firebase_database;

import java.util.Random;

public final class zzkp {
    private static final Random zzuo = new Random();
    private static long zzup = 0;
    private static final int[] zzuq = new int[12];

    public static synchronized String zzo(long j) {
        String sb;
        synchronized (zzkp.class) {
            boolean z = j == zzup;
            zzup = j;
            char[] cArr = new char[8];
            StringBuilder sb2 = new StringBuilder(20);
            for (int i = 7; i >= 0; i--) {
                cArr[i] = "-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".charAt((int) (j % 64));
                j /= 64;
            }
            sb2.append(cArr);
            if (!z) {
                for (int i2 = 0; i2 < 12; i2++) {
                    zzuq[i2] = zzuo.nextInt(64);
                }
            } else {
                int i3 = 11;
                while (true) {
                    if (i3 < 0) {
                        break;
                    } else if (zzuq[i3] != 63) {
                        zzuq[i3] = zzuq[i3] + 1;
                        break;
                    } else {
                        zzuq[i3] = 0;
                        i3--;
                    }
                }
            }
            for (int i4 = 0; i4 < 12; i4++) {
                sb2.append("-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz".charAt(zzuq[i4]));
            }
            sb = sb2.toString();
        }
        return sb;
    }
}
