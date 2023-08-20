package com.google.android.gms.internal.firebase_database;

public final class zzfx {
    private static final zzgn<Boolean> zznk = new zzfy();
    private static final zzgn<Boolean> zznl = new zzfz();
    private static final zzgj<Boolean> zznm = new zzgj<>(true);
    private static final zzgj<Boolean> zznn = new zzgj<>(false);
    private final zzgj<Boolean> zznj;

    public zzfx() {
        this.zznj = zzgj.zzdl();
    }

    private zzfx(zzgj<Boolean> zzgj) {
        this.zznj = zzgj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfx)) {
            return false;
        }
        return this.zznj.equals(((zzfx) obj).zznj);
    }

    public final int hashCode() {
        return this.zznj.hashCode();
    }

    public final String toString() {
        String zzgj = this.zznj.toString();
        return new StringBuilder(String.valueOf(zzgj).length() + 14).append("{PruneForest:").append(zzgj).append("}").toString();
    }

    public final <T> T zza(T t, zzgm<Void, T> zzgm) {
        return this.zznj.zzb(t, new zzga(this, zzgm));
    }

    public final zzfx zzd(zzid zzid) {
        zzgj<Boolean> zze = this.zznj.zze(zzid);
        return new zzfx(zze == null ? new zzgj<>(this.zznj.getValue()) : (zze.getValue() != null || this.zznj.getValue() == null) ? zze : zze.zzb(zzch.zzbt(), this.zznj.getValue()));
    }

    public final boolean zzdh() {
        return this.zznj.zzb(zznl);
    }

    public final boolean zzv(zzch zzch) {
        Boolean zzaf = this.zznj.zzaf(zzch);
        return zzaf != null && zzaf.booleanValue();
    }

    public final boolean zzw(zzch zzch) {
        Boolean zzaf = this.zznj.zzaf(zzch);
        return zzaf != null && !zzaf.booleanValue();
    }

    public final zzfx zzx(zzch zzch) {
        if (this.zznj.zzb(zzch, zznk) == null) {
            return this.zznj.zzb(zzch, zznl) != null ? this : new zzfx(this.zznj.zza(zzch, zznm));
        }
        throw new IllegalArgumentException("Can't prune path that was kept previously!");
    }

    public final zzfx zzy(zzch zzch) {
        return this.zznj.zzb(zzch, zznk) != null ? this : new zzfx(this.zznj.zza(zzch, zznn));
    }
}
