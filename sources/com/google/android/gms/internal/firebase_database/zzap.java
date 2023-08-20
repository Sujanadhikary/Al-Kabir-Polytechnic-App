package com.google.android.gms.internal.firebase_database;

import java.util.Map;

final class zzap implements zzau {
    private final /* synthetic */ zzal zzdu;
    private final /* synthetic */ boolean zzdy;

    zzap(zzal zzal, boolean z) {
        this.zzdu = zzal;
        this.zzdy = z;
    }

    public final void zzd(Map<String, Object> map) {
        zzav unused = this.zzdu.zzdc = zzav.Connected;
        String str = (String) map.get("s");
        if (str.equals("ok")) {
            int unused2 = this.zzdu.zzdp = 0;
            this.zzdu.zzcw.zzb(true);
            if (this.zzdy) {
                this.zzdu.zzaf();
                return;
            }
            return;
        }
        String unused3 = this.zzdu.zzdj = null;
        boolean unused4 = this.zzdu.zzdk = true;
        this.zzdu.zzcw.zzb(false);
        String str2 = (String) map.get("d");
        this.zzdu.zzbs.zza(new StringBuilder(String.valueOf(str).length() + 26 + String.valueOf(str2).length()).append("Authentication failed: ").append(str).append(" (").append(str2).append(")").toString(), (Throwable) null, new Object[0]);
        this.zzdu.zzdb.close();
        if (str.equals("invalid_token")) {
            zzal.zzj(this.zzdu);
            if (((long) this.zzdu.zzdp) >= 3) {
                this.zzdu.zzdm.zzay();
                this.zzdu.zzbs.zzb("Provided authentication credentials are invalid. This usually indicates your FirebaseApp instance was not initialized correctly. Make sure your google-services.json file has the correct firebase_url and api_key. You can re-download google-services.json from https://console.firebase.google.com/.", (Throwable) null);
            }
        }
    }
}
