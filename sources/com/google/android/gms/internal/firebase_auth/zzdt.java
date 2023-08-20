package com.google.android.gms.internal.firebase_auth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class zzdt extends zzdr {
    private static final Class<?> zzsp = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzdt() {
        super();
    }

    private static <L> List<L> zza(Object obj, long j, int i) {
        List<L> zzc = zzc(obj, j);
        if (zzc.isEmpty()) {
            List<L> zzdp = zzc instanceof zzdq ? new zzdp(i) : new ArrayList<>(i);
            zzfx.zza(obj, j, (Object) zzdp);
            return zzdp;
        } else if (zzsp.isAssignableFrom(zzc.getClass())) {
            ArrayList arrayList = new ArrayList(zzc.size() + i);
            arrayList.addAll(zzc);
            zzfx.zza(obj, j, (Object) arrayList);
            return arrayList;
        } else if (!(zzc instanceof zzfu)) {
            return zzc;
        } else {
            zzdp zzdp2 = new zzdp(zzc.size() + i);
            zzdp2.addAll((zzfu) zzc);
            zzfx.zza(obj, j, (Object) zzdp2);
            return zzdp2;
        }
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzfx.zzp(obj, j);
    }

    /* access modifiers changed from: package-private */
    public final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    /* access modifiers changed from: package-private */
    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzc = zzc(obj2, j);
        List zza = zza(obj, j, zzc.size());
        int size = zza.size();
        int size2 = zzc.size();
        if (size > 0 && size2 > 0) {
            zza.addAll(zzc);
        }
        if (size <= 0) {
            zza = zzc;
        }
        zzfx.zza(obj, j, (Object) zza);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        Object unmodifiableList;
        List list = (List) zzfx.zzp(obj, j);
        if (list instanceof zzdq) {
            unmodifiableList = ((zzdq) list).zzem();
        } else if (!zzsp.isAssignableFrom(list.getClass())) {
            unmodifiableList = Collections.unmodifiableList(list);
        } else {
            return;
        }
        zzfx.zza(obj, j, unmodifiableList);
    }
}
