package com.google.android.gms.internal.firebase_auth;

import java.util.List;

final class zzdu extends zzdr {
    private zzdu() {
        super();
    }

    private static <E> zzdg<E> zzd(Object obj, long j) {
        return (zzdg) zzfx.zzp(obj, j);
    }

    /* access modifiers changed from: package-private */
    public final <L> List<L> zza(Object obj, long j) {
        zzdg zzd = zzd(obj, j);
        if (zzd.zzbo()) {
            return zzd;
        }
        int size = zzd.size();
        zzdg zzi = zzd.zzi(size == 0 ? 10 : size << 1);
        zzfx.zza(obj, j, (Object) zzi);
        return zzi;
    }

    /* access modifiers changed from: package-private */
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzdg zzd = zzd(obj, j);
        zzdg zzd2 = zzd(obj2, j);
        int size = zzd.size();
        int size2 = zzd2.size();
        if (size > 0 && size2 > 0) {
            if (!zzd.zzbo()) {
                zzd = zzd.zzi(size2 + size);
            }
            zzd.addAll(zzd2);
        }
        if (size <= 0) {
            zzd = zzd2;
        }
        zzfx.zza(obj, j, (Object) zzd);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        zzd(obj, j).zzbp();
    }
}
