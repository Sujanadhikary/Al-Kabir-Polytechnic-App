package com.google.android.gms.internal.firebase_auth;

final class zzcn {
    private static final Class<?> zznm = zzdd();

    private static final zzco zzao(String str) throws Exception {
        return (zzco) zznm.getDeclaredMethod(str, new Class[0]).invoke((Object) null, new Object[0]);
    }

    private static Class<?> zzdd() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static zzco zzde() {
        if (zznm != null) {
            try {
                return zzao("getEmptyRegistry");
            } catch (Exception e) {
            }
        }
        return zzco.zznq;
    }

    static zzco zzdf() {
        zzco zzco = null;
        if (zznm != null) {
            try {
                zzco = zzao("loadGeneratedRegistry");
            } catch (Exception e) {
            }
        }
        if (zzco == null) {
            zzco = zzco.zzdf();
        }
        return zzco == null ? zzde() : zzco;
    }
}
