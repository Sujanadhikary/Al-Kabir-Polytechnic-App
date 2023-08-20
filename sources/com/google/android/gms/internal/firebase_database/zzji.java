package com.google.android.gms.internal.firebase_database;

public final class zzji extends zziv<zzji> {
    private final String value;

    public zzji(String str, zzja zzja) {
        super(zzja);
        this.value = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzji)) {
            return false;
        }
        zzji zzji = (zzji) obj;
        return this.value.equals(zzji.value) && this.zzre.equals(zzji.zzre);
    }

    public final Object getValue() {
        return this.value;
    }

    public final int hashCode() {
        return this.value.hashCode() + this.zzre.hashCode();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ int zza(zziv zziv) {
        return this.value.compareTo(((zzji) zziv).value);
    }

    public final String zza(zzjc zzjc) {
        switch (zzjj.zzsb[zzjc.ordinal()]) {
            case 1:
                String zzb = zzb(zzjc);
                String str = this.value;
                return new StringBuilder(String.valueOf(zzb).length() + 7 + String.valueOf(str).length()).append(zzb).append("string:").append(str).toString();
            case 2:
                String zzb2 = zzb(zzjc);
                String zzz = zzkq.zzz(this.value);
                return new StringBuilder(String.valueOf(zzb2).length() + 7 + String.valueOf(zzz).length()).append(zzb2).append("string:").append(zzz).toString();
            default:
                String valueOf = String.valueOf(zzjc);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 38).append("Invalid hash version for string node: ").append(valueOf).toString());
        }
    }

    public final /* synthetic */ zzja zzf(zzja zzja) {
        return new zzji(this.value, zzja);
    }

    /* access modifiers changed from: protected */
    public final zzix zzfb() {
        return zzix.String;
    }
}
