package com.google.android.gms.internal.firebase_database;

final class zzan implements zzae {
    private final /* synthetic */ long zzdv;
    private final /* synthetic */ zzam zzdw;

    zzan(zzam zzam, long j) {
        this.zzdw = zzam;
        this.zzdv = j;
    }

    public final void onError(String str) {
        if (this.zzdv == this.zzdw.zzdu.zzdo) {
            zzav unused = this.zzdw.zzdu.zzdc = zzav.Disconnected;
            zzhz zza = this.zzdw.zzdu.zzbs;
            String valueOf = String.valueOf(str);
            zza.zza(valueOf.length() != 0 ? "Error fetching token: ".concat(valueOf) : new String("Error fetching token: "), (Throwable) null, new Object[0]);
            this.zzdw.zzdu.zzae();
            return;
        }
        this.zzdw.zzdu.zzbs.zza("Ignoring getToken error, because this was not the latest attempt.", (Throwable) null, new Object[0]);
    }

    public final void zzf(String str) {
        if (this.zzdv != this.zzdw.zzdu.zzdo) {
            this.zzdw.zzdu.zzbs.zza("Ignoring getToken result, because this was not the latest attempt.", (Throwable) null, new Object[0]);
        } else if (this.zzdw.zzdu.zzdc == zzav.GettingToken) {
            this.zzdw.zzdu.zzbs.zza("Successfully fetched token, opening connection", (Throwable) null, new Object[0]);
            this.zzdw.zzdu.zzi(str);
        } else {
            zzag.zza(this.zzdw.zzdu.zzdc == zzav.Disconnected, "Expected connection state disconnected, but was %s", this.zzdw.zzdu.zzdc);
            this.zzdw.zzdu.zzbs.zza("Not opening connection after token refresh, because connection was set to disconnected", (Throwable) null, new Object[0]);
        }
    }
}
