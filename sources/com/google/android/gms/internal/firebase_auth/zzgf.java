package com.google.android.gms.internal.firebase_auth;

public enum zzgf {
    DOUBLE(zzgk.DOUBLE, 1),
    FLOAT(zzgk.FLOAT, 5),
    INT64(zzgk.LONG, 0),
    UINT64(zzgk.LONG, 0),
    INT32(zzgk.INT, 0),
    FIXED64(zzgk.LONG, 1),
    FIXED32(zzgk.INT, 5),
    BOOL(zzgk.BOOLEAN, 0),
    STRING(zzgk.STRING, 2),
    GROUP(zzgk.MESSAGE, 3),
    MESSAGE(zzgk.MESSAGE, 2),
    BYTES(zzgk.BYTE_STRING, 2),
    UINT32(zzgk.INT, 0),
    ENUM(zzgk.ENUM, 0),
    SFIXED32(zzgk.INT, 5),
    SFIXED64(zzgk.LONG, 1),
    SINT32(zzgk.INT, 0),
    SINT64(zzgk.LONG, 0);
    
    private final zzgk zzxt;
    private final int zzxu;

    private zzgf(zzgk zzgk, int i) {
        this.zzxt = zzgk;
        this.zzxu = i;
    }

    public final zzgk zzhb() {
        return this.zzxt;
    }

    public final int zzhc() {
        return this.zzxu;
    }
}
