package com.google.android.gms.internal.firebase_database;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class zzhx implements zzia {
    private final Set<String> zzqn;
    private final zzib zzqo;

    public zzhx(zzib zzib, List<String> list) {
        if (list != null) {
            this.zzqn = new HashSet(list);
        } else {
            this.zzqn = null;
        }
        this.zzqo = zzib;
    }

    /* access modifiers changed from: protected */
    public String zza(zzib zzib, String str, String str2, long j) {
        String date = new Date(j).toString();
        String valueOf = String.valueOf(zzib);
        return new StringBuilder(String.valueOf(date).length() + 6 + String.valueOf(valueOf).length() + String.valueOf(str).length() + String.valueOf(str2).length()).append(date).append(" [").append(valueOf).append("] ").append(str).append(": ").append(str2).toString();
    }

    public final void zzb(zzib zzib, String str, String str2, long j) {
        if (zzib.ordinal() >= this.zzqo.ordinal() && (this.zzqn == null || zzib.ordinal() > zzib.DEBUG.ordinal() || this.zzqn.contains(str))) {
            String zza = zza(zzib, str, str2, j);
            switch (zzhy.zzfo[zzib.ordinal()]) {
                case 1:
                    zze(str, zza);
                    return;
                case 2:
                    zzf(str, zza);
                    return;
                case 3:
                    zzg(str, zza);
                    return;
                case 4:
                    zzh(str, zza);
                    return;
                default:
                    throw new RuntimeException("Should not reach here!");
            }
        }
    }

    public final zzib zzbn() {
        return this.zzqo;
    }

    /* access modifiers changed from: protected */
    public void zze(String str, String str2) {
        System.err.println(str2);
    }

    /* access modifiers changed from: protected */
    public void zzf(String str, String str2) {
        System.out.println(str2);
    }

    /* access modifiers changed from: protected */
    public void zzg(String str, String str2) {
        System.out.println(str2);
    }

    /* access modifiers changed from: protected */
    public void zzh(String str, String str2) {
        System.out.println(str2);
    }
}
