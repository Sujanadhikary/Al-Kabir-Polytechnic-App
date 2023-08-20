package com.google.android.gms.internal.firebase_auth;

final class zzdy implements zzeg {
    private zzeg[] zzsu;

    zzdy(zzeg... zzegArr) {
        this.zzsu = zzegArr;
    }

    public final boolean zzb(Class<?> cls) {
        for (zzeg zzb : this.zzsu) {
            if (zzb.zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzef zzc(Class<?> cls) {
        for (zzeg zzeg : this.zzsu) {
            if (zzeg.zzb(cls)) {
                return zzeg.zzc(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
