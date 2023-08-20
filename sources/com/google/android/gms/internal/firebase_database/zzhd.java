package com.google.android.gms.internal.firebase_database;

import java.util.ArrayList;

final class zzhd implements Runnable {
    private final /* synthetic */ ArrayList zzpg;
    private final /* synthetic */ zzhc zzph;

    zzhd(zzhc zzhc, ArrayList arrayList) {
        this.zzph = zzhc;
        this.zzpg = arrayList;
    }

    public final void run() {
        ArrayList arrayList = this.zzpg;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            zzgy zzgy = (zzgy) arrayList.get(i);
            if (this.zzph.zzbs.zzfa()) {
                zzhz zza = this.zzph.zzbs;
                String valueOf = String.valueOf(zzgy.toString());
                zza.zza(valueOf.length() != 0 ? "Raising ".concat(valueOf) : new String("Raising "), (Throwable) null, new Object[0]);
            }
            zzgy.zzdr();
            i = i2;
        }
    }
}
