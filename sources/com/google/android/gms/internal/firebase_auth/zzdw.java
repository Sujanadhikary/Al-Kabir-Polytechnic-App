package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzdb;

final class zzdw implements zzey {
    private static final zzeg zzst = new zzdx();
    private final zzeg zzss;

    public zzdw() {
        this(new zzdy(zzda.zzdv(), zzep()));
    }

    private zzdw(zzeg zzeg) {
        this.zzss = (zzeg) zzdd.zza(zzeg, "messageInfoFactory");
    }

    private static boolean zza(zzef zzef) {
        return zzef.zzew() == zzdb.zze.zzrg;
    }

    private static zzeg zzep() {
        try {
            return (zzeg) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception e) {
            return zzst;
        }
    }

    public final <T> zzex<T> zze(Class<T> cls) {
        zzez.zzg(cls);
        zzef zzc = this.zzss.zzc(cls);
        if (zzc.zzex()) {
            return zzdb.class.isAssignableFrom(cls) ? zzem.zza(zzez.zzgd(), zzcr.zzdk(), zzc.zzey()) : zzem.zza(zzez.zzgb(), zzcr.zzdl(), zzc.zzey());
        }
        if (zzdb.class.isAssignableFrom(cls)) {
            if (zza(zzc)) {
                return zzel.zza(cls, zzc, zzeq.zzfb(), zzdr.zzeo(), zzez.zzgd(), zzcr.zzdk(), zzee.zzeu());
            }
            return zzel.zza(cls, zzc, zzeq.zzfb(), zzdr.zzeo(), zzez.zzgd(), (zzcp<?>) null, zzee.zzeu());
        } else if (zza(zzc)) {
            return zzel.zza(cls, zzc, zzeq.zzfa(), zzdr.zzen(), zzez.zzgb(), zzcr.zzdl(), zzee.zzet());
        } else {
            return zzel.zza(cls, zzc, zzeq.zzfa(), zzdr.zzen(), zzez.zzgc(), (zzcp<?>) null, zzee.zzet());
        }
    }
}
