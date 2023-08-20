package com.google.android.gms.internal.firebase_auth;

final class zzcr {
    private static final zzcp<?> zzns = new zzcq();
    private static final zzcp<?> zznt = zzdj();

    private static zzcp<?> zzdj() {
        try {
            return (zzcp) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }

    static zzcp<?> zzdk() {
        return zzns;
    }

    static zzcp<?> zzdl() {
        if (zznt != null) {
            return zznt;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
