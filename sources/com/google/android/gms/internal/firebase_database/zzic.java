package com.google.android.gms.internal.firebase_database;

public final class zzic extends zziv<zzic> {
    private final boolean value;

    public zzic(Boolean bool, zzja zzja) {
        super(zzja);
        this.value = bool.booleanValue();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzic)) {
            return false;
        }
        zzic zzic = (zzic) obj;
        return this.value == zzic.value && this.zzre.equals(zzic.zzre);
    }

    public final Object getValue() {
        return Boolean.valueOf(this.value);
    }

    public final int hashCode() {
        return (this.value ? 1 : 0) + this.zzre.hashCode();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ int zza(zziv zziv) {
        if (this.value == ((zzic) zziv).value) {
            return 0;
        }
        return this.value ? 1 : -1;
    }

    public final String zza(zzjc zzjc) {
        String zzb = zzb(zzjc);
        return new StringBuilder(String.valueOf(zzb).length() + 13).append(zzb).append("boolean:").append(this.value).toString();
    }

    public final /* synthetic */ zzja zzf(zzja zzja) {
        return new zzic(Boolean.valueOf(this.value), zzja);
    }

    /* access modifiers changed from: protected */
    public final zzix zzfb() {
        return zzix.Boolean;
    }
}
