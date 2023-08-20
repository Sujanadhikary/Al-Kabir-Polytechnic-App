package com.google.firebase.auth.internal;

import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.firebase_auth.zzv;
import com.google.firebase.auth.GetTokenResult;
import java.util.Collections;
import java.util.Map;

public final class zzx {
    private static final Logger zzdv = new Logger("GetTokenResultFactory", new String[0]);

    public static GetTokenResult zzag(String str) {
        Map<String, Object> map;
        try {
            map = zzy.zzah(str);
        } catch (zzv e) {
            zzdv.mo8035e("Error parsing token claims", e, new Object[0]);
            map = Collections.EMPTY_MAP;
        }
        return new GetTokenResult(str, map);
    }
}
