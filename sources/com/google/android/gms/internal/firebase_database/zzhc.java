package com.google.android.gms.internal.firebase_database;

import java.util.ArrayList;
import java.util.List;

public final class zzhc {
    /* access modifiers changed from: private */
    public final zzhz zzbs;
    private final zzcg zzhf;

    public zzhc(zzbz zzbz) {
        this.zzhf = zzbz.zzbp();
        this.zzbs = zzbz.zzp("EventRaiser");
    }

    public final void zze(List<? extends zzgy> list) {
        if (this.zzbs.zzfa()) {
            this.zzbs.zza(new StringBuilder(28).append("Raising ").append(list.size()).append(" event(s)").toString(), (Throwable) null, new Object[0]);
        }
        this.zzhf.zza(new zzhd(this, new ArrayList(list)));
    }
}
