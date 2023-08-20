package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzdb;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zzck implements zzgl {
    private final zzci zzmi;

    private zzck(zzci zzci) {
        this.zzmi = (zzci) zzdd.zza(zzci, "output");
        this.zzmi.zzna = this;
    }

    public static zzck zza(zzci zzci) {
        return zzci.zzna != null ? zzci.zzna : new zzck(zzci);
    }

    public final void zza(int i, double d) throws IOException {
        this.zzmi.zza(i, d);
    }

    public final void zza(int i, float f) throws IOException {
        this.zzmi.zza(i, f);
    }

    public final void zza(int i, long j) throws IOException {
        this.zzmi.zza(i, j);
    }

    public final void zza(int i, zzbu zzbu) throws IOException {
        this.zzmi.zza(i, zzbu);
    }

    public final <K, V> void zza(int i, zzea<K, V> zzea, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.zzmi.zzb(i, 2);
            this.zzmi.zzw(zzdz.zza(zzea, next.getKey(), next.getValue()));
            zzdz.zza(this.zzmi, zzea, next.getKey(), next.getValue());
        }
    }

    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzbu) {
            this.zzmi.zzb(i, (zzbu) obj);
        } else {
            this.zzmi.zzb(i, (zzeh) obj);
        }
    }

    public final void zza(int i, Object obj, zzex zzex) throws IOException {
        this.zzmi.zza(i, (zzeh) obj, zzex);
    }

    public final void zza(int i, String str) throws IOException {
        this.zzmi.zza(i, str);
    }

    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzdq) {
            zzdq zzdq = (zzdq) list;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    Object raw = zzdq.getRaw(i3);
                    if (raw instanceof String) {
                        this.zzmi.zza(i, (String) raw);
                    } else {
                        this.zzmi.zza(i, (zzbu) raw);
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        } else {
            while (i2 < list.size()) {
                this.zzmi.zza(i, list.get(i2));
                i2++;
            }
        }
    }

    public final void zza(int i, List<?> list, zzex zzex) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, (Object) list.get(i2), zzex);
        }
    }

    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmi.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzci.zzaa(list.get(i4).intValue());
            }
            this.zzmi.zzw(i3);
            while (i2 < list.size()) {
                this.zzmi.zzv(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmi.zzc(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzai(int i) throws IOException {
        this.zzmi.zzb(i, 3);
    }

    public final void zzaj(int i) throws IOException {
        this.zzmi.zzb(i, 4);
    }

    public final void zzb(int i, long j) throws IOException {
        this.zzmi.zzb(i, j);
    }

    public final void zzb(int i, Object obj, zzex zzex) throws IOException {
        zzci zzci = this.zzmi;
        zzci.zzb(i, 3);
        zzex.zza((zzeh) obj, zzci.zzna);
        zzci.zzb(i, 4);
    }

    public final void zzb(int i, List<zzbu> list) throws IOException {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                this.zzmi.zza(i, list.get(i3));
                i2 = i3 + 1;
            } else {
                return;
            }
        }
    }

    public final void zzb(int i, List<?> list, zzex zzex) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, (Object) list.get(i2), zzex);
        }
    }

    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmi.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzci.zzad(list.get(i4).intValue());
            }
            this.zzmi.zzw(i3);
            while (i2 < list.size()) {
                this.zzmi.zzy(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmi.zzf(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzb(int i, boolean z) throws IOException {
        this.zzmi.zzb(i, z);
    }

    public final void zzc(int i, int i2) throws IOException {
        this.zzmi.zzc(i, i2);
    }

    public final void zzc(int i, long j) throws IOException {
        this.zzmi.zzc(i, j);
    }

    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmi.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzci.zzd(list.get(i4).longValue());
            }
            this.zzmi.zzw(i3);
            while (i2 < list.size()) {
                this.zzmi.zza(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmi.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzd(int i, int i2) throws IOException {
        this.zzmi.zzd(i, i2);
    }

    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmi.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzci.zze(list.get(i4).longValue());
            }
            this.zzmi.zzw(i3);
            while (i2 < list.size()) {
                this.zzmi.zza(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmi.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final int zzdc() {
        return zzdb.zze.zzrj;
    }

    public final void zze(int i, int i2) throws IOException {
        this.zzmi.zze(i, i2);
    }

    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmi.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzci.zzg(list.get(i4).longValue());
            }
            this.zzmi.zzw(i3);
            while (i2 < list.size()) {
                this.zzmi.zzc(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmi.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzf(int i, int i2) throws IOException {
        this.zzmi.zzf(i, i2);
    }

    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmi.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzci.zzb(list.get(i4).floatValue());
            }
            this.zzmi.zzw(i3);
            while (i2 < list.size()) {
                this.zzmi.zza(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmi.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmi.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzci.zzb(list.get(i4).doubleValue());
            }
            this.zzmi.zzw(i3);
            while (i2 < list.size()) {
                this.zzmi.zza(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmi.zza(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmi.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzci.zzaf(list.get(i4).intValue());
            }
            this.zzmi.zzw(i3);
            while (i2 < list.size()) {
                this.zzmi.zzv(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmi.zzc(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzi(int i, long j) throws IOException {
        this.zzmi.zza(i, j);
    }

    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmi.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzci.zzh(list.get(i4).booleanValue());
            }
            this.zzmi.zzw(i3);
            while (i2 < list.size()) {
                this.zzmi.zzg(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmi.zzb(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    public final void zzj(int i, long j) throws IOException {
        this.zzmi.zzc(i, j);
    }

    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmi.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzci.zzab(list.get(i4).intValue());
            }
            this.zzmi.zzw(i3);
            while (i2 < list.size()) {
                this.zzmi.zzw(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmi.zzd(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmi.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzci.zzae(list.get(i4).intValue());
            }
            this.zzmi.zzw(i3);
            while (i2 < list.size()) {
                this.zzmi.zzy(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmi.zzf(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmi.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzci.zzh(list.get(i4).longValue());
            }
            this.zzmi.zzw(i3);
            while (i2 < list.size()) {
                this.zzmi.zzc(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmi.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzm(int i, int i2) throws IOException {
        this.zzmi.zzf(i, i2);
    }

    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmi.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzci.zzac(list.get(i4).intValue());
            }
            this.zzmi.zzw(i3);
            while (i2 < list.size()) {
                this.zzmi.zzx(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmi.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzn(int i, int i2) throws IOException {
        this.zzmi.zzc(i, i2);
    }

    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzmi.zzb(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzci.zzf(list.get(i4).longValue());
            }
            this.zzmi.zzw(i3);
            while (i2 < list.size()) {
                this.zzmi.zzb(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzmi.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }
}
