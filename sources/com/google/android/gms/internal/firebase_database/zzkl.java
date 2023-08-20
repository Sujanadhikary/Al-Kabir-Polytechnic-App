package com.google.android.gms.internal.firebase_database;

import java.util.Iterator;

public final class zzkl {
    private static long zzc(zziv<?> zziv) {
        long j = 8;
        if (!(zziv instanceof zziq) && !(zziv instanceof zziy)) {
            if (zziv instanceof zzic) {
                j = 4;
            } else if (zziv instanceof zzji) {
                j = (long) (((String) zziv.getValue()).length() + 2);
            } else {
                String valueOf = String.valueOf(zziv.getClass());
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 24).append("Unknown leaf node type: ").append(valueOf).toString());
            }
        }
        if (zziv.zzfl().isEmpty()) {
            return j;
        }
        return zzc((zziv) zziv.zzfl()) + 24 + j;
    }

    public static long zzn(zzja zzja) {
        long j;
        if (zzja.isEmpty()) {
            return 4;
        }
        if (zzja.zzfk()) {
            return zzc((zziv) zzja);
        }
        long j2 = 1;
        Iterator it = zzja.iterator();
        while (true) {
            j = j2;
            if (!it.hasNext()) {
                break;
            }
            zziz zziz = (zziz) it.next();
            j2 = zzn(zziz.zzd()) + j + ((long) zziz.zzge().zzfg().length()) + 4;
        }
        return !zzja.zzfl().isEmpty() ? j + 12 + zzc((zziv) zzja.zzfl()) : j;
    }

    public static int zzo(zzja zzja) {
        int i = 0;
        if (zzja.isEmpty()) {
            return 0;
        }
        if (zzja.zzfk()) {
            return 1;
        }
        Iterator it = zzja.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = zzo(((zziz) it.next()).zzd()) + i2;
        }
    }
}
