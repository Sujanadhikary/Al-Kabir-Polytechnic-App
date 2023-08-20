package com.google.android.gms.internal.firebase_database;

public final class zziq extends zziv<zziq> {
    private final Double zzrv;

    public zziq(Double d, zzja zzja) {
        super(zzja);
        this.zzrv = d;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zziq)) {
            return false;
        }
        zziq zziq = (zziq) obj;
        return this.zzrv.equals(zziq.zzrv) && this.zzre.equals(zziq.zzre);
    }

    public final Object getValue() {
        return this.zzrv;
    }

    public final int hashCode() {
        return this.zzrv.hashCode() + this.zzre.hashCode();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ int zza(zziv zziv) {
        return this.zzrv.compareTo(((zziq) zziv).zzrv);
    }

    public final String zza(zzjc zzjc) {
        String valueOf = String.valueOf(String.valueOf(zzb(zzjc)).concat("number:"));
        String valueOf2 = String.valueOf(zzkq.zzc(this.zzrv.doubleValue()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final /* synthetic */ zzja zzf(zzja zzja) {
        return new zziq(this.zzrv, zzja);
    }

    /* access modifiers changed from: protected */
    public final zzix zzfb() {
        return zzix.Number;
    }
}
