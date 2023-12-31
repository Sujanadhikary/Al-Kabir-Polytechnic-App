package com.google.android.gms.internal.firebase_database;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

final class zzdj implements zzbb {
    private final /* synthetic */ zzch zzgy;
    private final /* synthetic */ zzck zzil;
    private final /* synthetic */ DatabaseReference.CompletionListener zzio;
    private final /* synthetic */ long zzjh;

    zzdj(zzck zzck, zzch zzch, long j, DatabaseReference.CompletionListener completionListener) {
        this.zzil = zzck;
        this.zzgy = zzch;
        this.zzjh = j;
        this.zzio = completionListener;
    }

    public final void zzb(String str, String str2) {
        DatabaseError zzd = zzck.zzc(str, str2);
        this.zzil.zza("updateChildren", this.zzgy, zzd);
        this.zzil.zza(this.zzjh, this.zzgy, zzd);
        this.zzil.zza(this.zzio, zzd, this.zzgy);
    }
}
