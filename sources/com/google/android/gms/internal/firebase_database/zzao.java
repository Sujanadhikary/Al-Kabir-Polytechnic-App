package com.google.android.gms.internal.firebase_database;

import java.util.Map;

final class zzao implements zzau {
    private final /* synthetic */ zzbb zzdx;

    zzao(zzal zzal, zzbb zzbb) {
        this.zzdx = zzbb;
    }

    public final void zzd(Map<String, Object> map) {
        String str = null;
        String str2 = (String) map.get("s");
        if (!str2.equals("ok")) {
            str = (String) map.get("d");
        } else {
            str2 = null;
        }
        if (this.zzdx != null) {
            this.zzdx.zzb(str2, str);
        }
    }
}
