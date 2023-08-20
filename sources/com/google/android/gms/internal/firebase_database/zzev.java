package com.google.android.gms.internal.firebase_database;

import android.support.p000v4.media.session.PlaybackStateCompat;
import com.google.firebase.database.DatabaseError;
import java.util.ArrayList;
import java.util.List;

final class zzev implements zzai, zzet {
    private final /* synthetic */ zzee zzlb;
    private final zzhi zzlo;
    /* access modifiers changed from: private */
    public final zzex zzlp;

    public zzev(zzee zzee, zzhi zzhi) {
        this.zzlb = zzee;
        this.zzlo = zzhi;
        this.zzlp = zzee.zze(zzhi.zzeo());
    }

    public final List<? extends zzgy> zzb(DatabaseError databaseError) {
        if (databaseError == null) {
            return this.zzlp != null ? this.zzlb.zza(this.zzlp) : this.zzlb.zzs(this.zzlo.zzeo().zzg());
        }
        zzhz zza = this.zzlb.zzbs;
        String valueOf = String.valueOf(this.zzlo.zzeo().zzg());
        String databaseError2 = databaseError.toString();
        zza.zzb(new StringBuilder(String.valueOf(valueOf).length() + 19 + String.valueOf(databaseError2).length()).append("Listen at ").append(valueOf).append(" failed: ").append(databaseError2).toString(), (Throwable) null);
        return this.zzlb.zza(this.zzlo.zzeo(), databaseError);
    }

    public final String zzx() {
        return this.zzlo.zzep().zzfj();
    }

    public final boolean zzy() {
        return zzkl.zzn(this.zzlo.zzep()) > PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
    }

    public final zzy zzz() {
        zzik zzh = zzik.zzh(this.zzlo.zzep());
        List<zzch> zzo = zzh.zzo();
        ArrayList arrayList = new ArrayList(zzo.size());
        for (zzch zzbv : zzo) {
            arrayList.add(zzbv.zzbv());
        }
        return new zzy(arrayList, zzh.zzp());
    }
}
