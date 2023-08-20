package com.google.android.gms.internal.firebase_database;

import java.util.Map;

public final class zzip extends zziv<zzip> {
    private Map<Object, Object> zzru;

    public zzip(Map<Object, Object> map, zzja zzja) {
        super(zzja);
        this.zzru = map;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzip)) {
            return false;
        }
        zzip zzip = (zzip) obj;
        return this.zzru.equals(zzip.zzru) && this.zzre.equals(zzip.zzre);
    }

    public final Object getValue() {
        return this.zzru;
    }

    public final int hashCode() {
        return this.zzru.hashCode() + this.zzre.hashCode();
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ int zza(zziv zziv) {
        return 0;
    }

    public final String zza(zzjc zzjc) {
        String zzb = zzb(zzjc);
        String valueOf = String.valueOf(this.zzru);
        return new StringBuilder(String.valueOf(zzb).length() + 14 + String.valueOf(valueOf).length()).append(zzb).append("deferredValue:").append(valueOf).toString();
    }

    public final /* synthetic */ zzja zzf(zzja zzja) {
        return new zzip(this.zzru, zzja);
    }

    /* access modifiers changed from: protected */
    public final zzix zzfb() {
        return zzix.DeferredValue;
    }
}
