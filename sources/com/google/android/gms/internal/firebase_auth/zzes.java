package com.google.android.gms.internal.firebase_auth;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzes {
    private static final zzes zztx = new zzes();
    private final zzey zzty;
    private final ConcurrentMap<Class<?>, zzex<?>> zztz = new ConcurrentHashMap();

    private zzes() {
        zzey zzey = null;
        String[] strArr = {"com.google.protobuf.AndroidProto3SchemaFactory"};
        for (int i = 0; i <= 0; i++) {
            zzey = zzaq(strArr[0]);
            if (zzey != null) {
                break;
            }
        }
        this.zzty = zzey == null ? new zzdw() : zzey;
    }

    private static zzey zzaq(String str) {
        try {
            return (zzey) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            return null;
        }
    }

    public static zzes zzfd() {
        return zztx;
    }

    public final <T> zzex<T> zzf(Class<T> cls) {
        zzdd.zza(cls, "messageType");
        zzex<T> zzex = (zzex) this.zztz.get(cls);
        if (zzex != null) {
            return zzex;
        }
        zzex<T> zze = this.zzty.zze(cls);
        zzdd.zza(cls, "messageType");
        zzdd.zza(zze, "schema");
        zzex<T> putIfAbsent = this.zztz.putIfAbsent(cls, zze);
        return putIfAbsent != null ? putIfAbsent : zze;
    }

    public final <T> zzex<T> zzq(T t) {
        return zzf(t.getClass());
    }
}
