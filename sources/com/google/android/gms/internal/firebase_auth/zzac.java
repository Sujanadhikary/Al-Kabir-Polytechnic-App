package com.google.android.gms.internal.firebase_auth;

import org.json.JSONException;

public final class zzac {
    private String message;

    public static zzac zzj(String str) throws JSONException {
        zzac zzac = new zzac();
        zzac.message = str;
        return zzac;
    }

    public final String getErrorMessage() {
        return this.message;
    }
}
