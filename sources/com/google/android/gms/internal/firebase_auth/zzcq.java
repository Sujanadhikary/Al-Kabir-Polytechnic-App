package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzdb;
import java.io.IOException;
import java.util.Map;

final class zzcq extends zzcp<Object> {
    zzcq() {
    }

    /* access modifiers changed from: package-private */
    public final int zza(Map.Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final Object zza(zzco zzco, zzeh zzeh, int i) {
        return zzco.zza(zzeh, i);
    }

    /* access modifiers changed from: package-private */
    public final <UT, UB> UB zza(zzew zzew, Object obj, zzco zzco, zzcs<Object> zzcs, UB ub, zzfr<UT, UB> zzfr) throws IOException {
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzbu zzbu, Object obj, zzco zzco, zzcs<Object> zzcs) throws IOException {
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzew zzew, Object obj, zzco zzco, zzcs<Object> zzcs) throws IOException {
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzgl zzgl, Map.Entry<?, ?> entry) throws IOException {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final void zza(Object obj, zzcs<Object> zzcs) {
        ((zzdb.zzc) obj).zzqx = zzcs;
    }

    /* access modifiers changed from: package-private */
    public final zzcs<Object> zzc(Object obj) {
        return ((zzdb.zzc) obj).zzqx;
    }

    /* access modifiers changed from: package-private */
    public final zzcs<Object> zzd(Object obj) {
        zzcs<Object> zzc = zzc(obj);
        if (!zzc.isImmutable()) {
            return zzc;
        }
        zzcs<Object> zzcs = (zzcs) zzc.clone();
        zza(obj, zzcs);
        return zzcs;
    }

    /* access modifiers changed from: package-private */
    public final void zze(Object obj) {
        zzc(obj).zzbp();
    }

    /* access modifiers changed from: package-private */
    public final boolean zze(zzeh zzeh) {
        return zzeh instanceof zzdb.zzc;
    }
}
