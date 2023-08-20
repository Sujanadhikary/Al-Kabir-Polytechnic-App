package com.google.android.gms.internal.firebase_database;

import java.util.List;
import java.util.Map;

final class zzaw {
    /* access modifiers changed from: private */
    public final List<String> zzei;
    /* access modifiers changed from: private */
    public final Map<String, Object> zzej;

    public zzaw(List<String> list, Map<String, Object> map) {
        this.zzei = list;
        this.zzej = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaw)) {
            return false;
        }
        zzaw zzaw = (zzaw) obj;
        if (this.zzei.equals(zzaw.zzei)) {
            return this.zzej.equals(zzaw.zzej);
        }
        return false;
    }

    public final int hashCode() {
        return (this.zzei.hashCode() * 31) + this.zzej.hashCode();
    }

    public final String toString() {
        String zzb = zzag.zzb(this.zzei);
        String valueOf = String.valueOf(this.zzej);
        return new StringBuilder(String.valueOf(zzb).length() + 11 + String.valueOf(valueOf).length()).append(zzb).append(" (params: ").append(valueOf).append(")").toString();
    }
}
