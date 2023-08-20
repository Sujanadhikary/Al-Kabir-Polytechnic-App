package com.google.android.gms.internal.firebase_auth;

public enum zzdj {
    VOID(Void.class, Void.class, (Class<?>) null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzbu.class, zzbu.class, zzbu.zzmc),
    ENUM(Integer.TYPE, Integer.class, (Class<?>) null),
    MESSAGE(Object.class, Object.class, (Class<?>) null);
    
    private final Class<?> zzsb;
    private final Class<?> zzsc;
    private final Object zzsd;

    private zzdj(Class<?> cls, Class<?> cls2, Object obj) {
        this.zzsb = cls;
        this.zzsc = cls2;
        this.zzsd = obj;
    }

    public final Class<?> zzei() {
        return this.zzsc;
    }
}
