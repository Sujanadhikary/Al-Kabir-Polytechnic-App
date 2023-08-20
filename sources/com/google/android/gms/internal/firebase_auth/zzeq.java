package com.google.android.gms.internal.firebase_auth;

final class zzeq {
    private static final zzeo zztv = zzfc();
    private static final zzeo zztw = new zzep();

    static zzeo zzfa() {
        return zztv;
    }

    static zzeo zzfb() {
        return zztw;
    }

    private static zzeo zzfc() {
        try {
            return (zzeo) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }
}
