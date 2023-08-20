package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Map;

final class zzed implements zzec {
    zzed() {
    }

    public final int zzb(int i, Object obj, Object obj2) {
        zzeb zzeb = (zzeb) obj;
        if (!zzeb.isEmpty()) {
            Iterator it = zzeb.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                entry.getKey();
                entry.getValue();
                throw new NoSuchMethodError();
            }
        }
        return 0;
    }

    public final Object zzb(Object obj, Object obj2) {
        zzeb zzeb = (zzeb) obj;
        zzeb zzeb2 = (zzeb) obj2;
        if (!zzeb2.isEmpty()) {
            if (!zzeb.isMutable()) {
                zzeb = zzeb.zzer();
            }
            zzeb.zza(zzeb2);
        }
        return zzeb;
    }

    public final Map<?, ?> zzi(Object obj) {
        return (zzeb) obj;
    }

    public final Map<?, ?> zzj(Object obj) {
        return (zzeb) obj;
    }

    public final boolean zzk(Object obj) {
        return !((zzeb) obj).isMutable();
    }

    public final Object zzl(Object obj) {
        ((zzeb) obj).zzbp();
        return obj;
    }

    public final Object zzm(Object obj) {
        return zzeb.zzeq().zzer();
    }

    public final zzea<?, ?> zzn(Object obj) {
        throw new NoSuchMethodError();
    }
}
