package com.google.android.gms.internal.firebase_database;

import java.util.Map;

final class zzas implements zzau {
    private final /* synthetic */ zzal zzdu;

    zzas(zzal zzal) {
        this.zzdu = zzal;
    }

    public final void zzd(Map<String, Object> map) {
        String str = (String) map.get("s");
        if (!str.equals("ok")) {
            String str2 = (String) map.get("d");
            if (this.zzdu.zzbs.zzfa()) {
                this.zzdu.zzbs.zza(new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(str2).length()).append("Failed to send stats: ").append(str).append(" (message: ").append(str2).append(")").toString(), (Throwable) null, new Object[0]);
            }
        }
    }
}
