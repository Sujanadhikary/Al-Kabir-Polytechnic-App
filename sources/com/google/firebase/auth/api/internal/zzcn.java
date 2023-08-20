package com.google.firebase.auth.api.internal;

import android.content.Context;
import com.google.android.gms.common.api.Api;

public final class zzcn {
    private static final Api.ClientKey<zzcc> CLIENT_KEY = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zzcc, zzcp> zzhh = new zzco();
    public static final Api<zzcp> zzhi = new Api<>("InternalFirebaseAuth.FIREBASE_AUTH_API", zzhh, CLIENT_KEY);

    public static zzao zza(Context context, zzcp zzcp) {
        return new zzao(context, zzcp);
    }
}
