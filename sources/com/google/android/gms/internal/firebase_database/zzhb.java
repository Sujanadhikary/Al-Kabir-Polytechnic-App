package com.google.android.gms.internal.firebase_database;

import java.util.Comparator;

final class zzhb implements Comparator<zzgw> {
    private final /* synthetic */ zzha zzpf;

    zzhb(zzha zzha) {
        this.zzpf = zzha;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzgw zzgw = (zzgw) obj;
        zzgw zzgw2 = (zzgw) obj2;
        return this.zzpf.zzpe.compare(new zziz(zzgw.zzds(), zzgw.zzdq().zzd()), new zziz(zzgw2.zzds(), zzgw2.zzdq().zzd()));
    }
}
