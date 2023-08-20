package com.google.firebase.database;

import com.google.android.gms.internal.firebase_database.zzch;
import com.google.android.gms.internal.firebase_database.zzja;
import com.google.android.gms.internal.firebase_database.zzkn;
import com.google.firebase.database.DatabaseReference;
import java.util.Map;

final class zzn implements Runnable {
    private final /* synthetic */ OnDisconnect zzaq;
    private final /* synthetic */ Map zzar;
    private final /* synthetic */ Map zzas;
    private final /* synthetic */ zzkn zzx;

    zzn(OnDisconnect onDisconnect, Map map, zzkn zzkn, Map map2) {
        this.zzaq = onDisconnect;
        this.zzar = map;
        this.zzx = zzkn;
        this.zzas = map2;
    }

    public final void run() {
        this.zzaq.zzai.zza(this.zzaq.zzap, (Map<zzch, zzja>) this.zzar, (DatabaseReference.CompletionListener) this.zzx.zzgv(), (Map<String, Object>) this.zzas);
    }
}
