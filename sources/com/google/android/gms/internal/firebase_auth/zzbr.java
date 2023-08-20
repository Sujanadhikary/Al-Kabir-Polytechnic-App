package com.google.android.gms.internal.firebase_auth;

final class zzbr {
    private static final Class<?> zzly = zzaj("libcore.io.Memory");
    private static final boolean zzlz = (zzaj("org.robolectric.Robolectric") != null);

    private static <T> Class<T> zzaj(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable th) {
            return null;
        }
    }

    static boolean zzbr() {
        return zzly != null && !zzlz;
    }

    static Class<?> zzbs() {
        return zzly;
    }
}
