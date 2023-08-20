package com.google.android.gms.internal.firebase_database;

import android.support.p003v7.app.AppCompatDelegate;

public final class zzgb {

    /* renamed from: id */
    public final long f26id;
    public final zzhh zznp;
    public final long zznq;
    public final boolean zznr;
    public final boolean zzns;

    public zzgb(long j, zzhh zzhh, long j2, boolean z, boolean z2) {
        this.f26id = j;
        if (!zzhh.zzek() || zzhh.isDefault()) {
            this.zznp = zzhh;
            this.zznq = j2;
            this.zznr = z;
            this.zzns = z2;
            return;
        }
        throw new IllegalArgumentException("Can't create TrackedQuery for a non-default query that loads all data");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        zzgb zzgb = (zzgb) obj;
        return this.f26id == zzgb.f26id && this.zznp.equals(zzgb.zznp) && this.zznq == zzgb.zznq && this.zznr == zzgb.zznr && this.zzns == zzgb.zzns;
    }

    public final int hashCode() {
        return (((((((Long.valueOf(this.f26id).hashCode() * 31) + this.zznp.hashCode()) * 31) + Long.valueOf(this.zznq).hashCode()) * 31) + Boolean.valueOf(this.zznr).hashCode()) * 31) + Boolean.valueOf(this.zzns).hashCode();
    }

    public final String toString() {
        long j = this.f26id;
        String valueOf = String.valueOf(this.zznp);
        long j2 = this.zznq;
        boolean z = this.zznr;
        return new StringBuilder(String.valueOf(valueOf).length() + AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY).append("TrackedQuery{id=").append(j).append(", querySpec=").append(valueOf).append(", lastUse=").append(j2).append(", complete=").append(z).append(", active=").append(this.zzns).append("}").toString();
    }

    public final zzgb zzdi() {
        return new zzgb(this.f26id, this.zznp, this.zznq, true, this.zzns);
    }
}
