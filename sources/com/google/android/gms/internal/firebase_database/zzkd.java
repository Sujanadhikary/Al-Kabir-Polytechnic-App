package com.google.android.gms.internal.firebase_database;

import java.io.IOException;
import java.util.Map;

public final class zzkd {
    private final String zzuh;
    private final Map<String, Object> zzui;

    private zzkd(String str, Map<String, Object> map) {
        this.zzuh = str;
        this.zzui = map;
    }

    public static zzkd zzu(String str) {
        if (!str.startsWith("gauth|")) {
            return null;
        }
        try {
            Map<String, Object> zzv = zzke.zzv(str.substring(6));
            return new zzkd((String) zzv.get("token"), (Map) zzv.get("auth"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse gauth token", e);
        }
    }

    public final String getToken() {
        return this.zzuh;
    }

    public final Map<String, Object> zzgu() {
        return this.zzui;
    }
}
