package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;

final class zzft extends zzfr<zzfs, zzfs> {
    zzft() {
    }

    private static void zza(Object obj, zzfs zzfs) {
        ((zzdb) obj).zzqr = zzfs;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzfs) obj).zzb(i << 3, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, zzbu zzbu) {
        ((zzfs) obj).zzb((i << 3) | 2, zzbu);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, Object obj2) {
        ((zzfs) obj).zzb((i << 3) | 3, (zzfs) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, zzgl zzgl) throws IOException {
        ((zzfs) obj).zzb(zzgl);
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzew zzew) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, int i, long j) {
        ((zzfs) obj).zzb((i << 3) | 1, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Object obj, int i, int i2) {
        ((zzfs) obj).zzb((i << 3) | 5, Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Object obj, zzgl zzgl) throws IOException {
        ((zzfs) obj).zza(zzgl);
    }

    /* access modifiers changed from: package-private */
    public final void zze(Object obj) {
        ((zzdb) obj).zzqr.zzbp();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(Object obj, Object obj2) {
        zza(obj, (zzfs) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(Object obj, Object obj2) {
        zza(obj, (zzfs) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzg(Object obj, Object obj2) {
        zzfs zzfs = (zzfs) obj;
        zzfs zzfs2 = (zzfs) obj2;
        return zzfs2.equals(zzfs.zzgr()) ? zzfs : zzfs.zza(zzfs, zzfs2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzgq() {
        return zzfs.zzgs();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzl(Object obj) {
        zzfs zzfs = (zzfs) obj;
        zzfs.zzbp();
        return zzfs;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzo(Object obj) {
        return ((zzfs) obj).zzdn();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzr(Object obj) {
        return ((zzdb) obj).zzqr;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzs(Object obj) {
        zzfs zzfs = ((zzdb) obj).zzqr;
        if (zzfs != zzfs.zzgr()) {
            return zzfs;
        }
        zzfs zzgs = zzfs.zzgs();
        zza(obj, zzgs);
        return zzgs;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzt(Object obj) {
        return ((zzfs) obj).zzgt();
    }
}
