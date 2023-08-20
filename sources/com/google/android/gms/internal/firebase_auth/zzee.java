package com.google.android.gms.internal.firebase_auth;

final class zzee {
    private static final zzec zzta = zzev();
    private static final zzec zztb = new zzed();

    static zzec zzet() {
        return zzta;
    }

    static zzec zzeu() {
        return zztb;
    }

    private static zzec zzev() {
        try {
            return (zzec) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }
}
