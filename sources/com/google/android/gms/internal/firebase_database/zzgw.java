package com.google.android.gms.internal.firebase_database;

public final class zzgw {
    private final zzit zzom;
    private final zzgz zzor;
    private final zzit zzos;
    private final zzid zzot;
    private final zzid zzou;

    private zzgw(zzgz zzgz, zzit zzit, zzid zzid, zzid zzid2, zzit zzit2) {
        this.zzor = zzgz;
        this.zzom = zzit;
        this.zzot = zzid;
        this.zzou = zzid2;
        this.zzos = zzit2;
    }

    public static zzgw zza(zzid zzid, zzit zzit) {
        return new zzgw(zzgz.CHILD_ADDED, zzit, zzid, (zzid) null, (zzit) null);
    }

    public static zzgw zza(zzid zzid, zzit zzit, zzit zzit2) {
        return new zzgw(zzgz.CHILD_CHANGED, zzit, zzid, (zzid) null, zzit2);
    }

    public static zzgw zza(zzid zzid, zzja zzja, zzja zzja2) {
        return zza(zzid, zzit.zzj(zzja), zzit.zzj(zzja2));
    }

    public static zzgw zza(zzit zzit) {
        return new zzgw(zzgz.VALUE, zzit, (zzid) null, (zzid) null, (zzit) null);
    }

    public static zzgw zzb(zzid zzid, zzit zzit) {
        return new zzgw(zzgz.CHILD_REMOVED, zzit, zzid, (zzid) null, (zzit) null);
    }

    public static zzgw zzc(zzid zzid, zzit zzit) {
        return new zzgw(zzgz.CHILD_MOVED, zzit, zzid, (zzid) null, (zzit) null);
    }

    public static zzgw zzc(zzid zzid, zzja zzja) {
        return zza(zzid, zzit.zzj(zzja));
    }

    public static zzgw zzd(zzid zzid, zzja zzja) {
        return zzb(zzid, zzit.zzj(zzja));
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzor);
        String valueOf2 = String.valueOf(this.zzot);
        return new StringBuilder(String.valueOf(valueOf).length() + 9 + String.valueOf(valueOf2).length()).append("Change: ").append(valueOf).append(" ").append(valueOf2).toString();
    }

    public final zzit zzdq() {
        return this.zzom;
    }

    public final zzid zzds() {
        return this.zzot;
    }

    public final zzgz zzdt() {
        return this.zzor;
    }

    public final zzid zzdu() {
        return this.zzou;
    }

    public final zzit zzdv() {
        return this.zzos;
    }

    public final zzgw zzg(zzid zzid) {
        return new zzgw(this.zzor, this.zzom, this.zzot, zzid, this.zzos);
    }
}
