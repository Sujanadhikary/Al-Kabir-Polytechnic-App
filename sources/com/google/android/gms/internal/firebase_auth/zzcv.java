package com.google.android.gms.internal.firebase_auth;

import java.lang.reflect.Type;

public enum zzcv {
    DOUBLE(0, zzcx.SCALAR, zzdj.DOUBLE),
    FLOAT(1, zzcx.SCALAR, zzdj.FLOAT),
    INT64(2, zzcx.SCALAR, zzdj.LONG),
    UINT64(3, zzcx.SCALAR, zzdj.LONG),
    INT32(4, zzcx.SCALAR, zzdj.INT),
    FIXED64(5, zzcx.SCALAR, zzdj.LONG),
    FIXED32(6, zzcx.SCALAR, zzdj.INT),
    BOOL(7, zzcx.SCALAR, zzdj.BOOLEAN),
    STRING(8, zzcx.SCALAR, zzdj.STRING),
    MESSAGE(9, zzcx.SCALAR, zzdj.MESSAGE),
    BYTES(10, zzcx.SCALAR, zzdj.BYTE_STRING),
    UINT32(11, zzcx.SCALAR, zzdj.INT),
    ENUM(12, zzcx.SCALAR, zzdj.ENUM),
    SFIXED32(13, zzcx.SCALAR, zzdj.INT),
    SFIXED64(14, zzcx.SCALAR, zzdj.LONG),
    SINT32(15, zzcx.SCALAR, zzdj.INT),
    SINT64(16, zzcx.SCALAR, zzdj.LONG),
    GROUP(17, zzcx.SCALAR, zzdj.MESSAGE),
    DOUBLE_LIST(18, zzcx.VECTOR, zzdj.DOUBLE),
    FLOAT_LIST(19, zzcx.VECTOR, zzdj.FLOAT),
    INT64_LIST(20, zzcx.VECTOR, zzdj.LONG),
    UINT64_LIST(21, zzcx.VECTOR, zzdj.LONG),
    INT32_LIST(22, zzcx.VECTOR, zzdj.INT),
    FIXED64_LIST(23, zzcx.VECTOR, zzdj.LONG),
    FIXED32_LIST(24, zzcx.VECTOR, zzdj.INT),
    BOOL_LIST(25, zzcx.VECTOR, zzdj.BOOLEAN),
    STRING_LIST(26, zzcx.VECTOR, zzdj.STRING),
    MESSAGE_LIST(27, zzcx.VECTOR, zzdj.MESSAGE),
    BYTES_LIST(28, zzcx.VECTOR, zzdj.BYTE_STRING),
    UINT32_LIST(29, zzcx.VECTOR, zzdj.INT),
    ENUM_LIST(30, zzcx.VECTOR, zzdj.ENUM),
    SFIXED32_LIST(31, zzcx.VECTOR, zzdj.INT),
    SFIXED64_LIST(32, zzcx.VECTOR, zzdj.LONG),
    SINT32_LIST(33, zzcx.VECTOR, zzdj.INT),
    SINT64_LIST(34, zzcx.VECTOR, zzdj.LONG),
    DOUBLE_LIST_PACKED(35, zzcx.PACKED_VECTOR, zzdj.DOUBLE),
    FLOAT_LIST_PACKED(36, zzcx.PACKED_VECTOR, zzdj.FLOAT),
    INT64_LIST_PACKED(37, zzcx.PACKED_VECTOR, zzdj.LONG),
    UINT64_LIST_PACKED(38, zzcx.PACKED_VECTOR, zzdj.LONG),
    INT32_LIST_PACKED(39, zzcx.PACKED_VECTOR, zzdj.INT),
    FIXED64_LIST_PACKED(40, zzcx.PACKED_VECTOR, zzdj.LONG),
    FIXED32_LIST_PACKED(41, zzcx.PACKED_VECTOR, zzdj.INT),
    BOOL_LIST_PACKED(42, zzcx.PACKED_VECTOR, zzdj.BOOLEAN),
    UINT32_LIST_PACKED(43, zzcx.PACKED_VECTOR, zzdj.INT),
    ENUM_LIST_PACKED(44, zzcx.PACKED_VECTOR, zzdj.ENUM),
    SFIXED32_LIST_PACKED(45, zzcx.PACKED_VECTOR, zzdj.INT),
    SFIXED64_LIST_PACKED(46, zzcx.PACKED_VECTOR, zzdj.LONG),
    SINT32_LIST_PACKED(47, zzcx.PACKED_VECTOR, zzdj.INT),
    SINT64_LIST_PACKED(48, zzcx.PACKED_VECTOR, zzdj.LONG),
    GROUP_LIST(49, zzcx.VECTOR, zzdj.MESSAGE),
    MAP(50, zzcx.MAP, zzdj.VOID);
    
    private static final zzcv[] zzqc = null;
    private static final Type[] zzqd = null;

    /* renamed from: id */
    private final int f25id;
    private final zzdj zzpy;
    private final zzcx zzpz;
    private final Class<?> zzqa;
    private final boolean zzqb;

    static {
        int i;
        zzqd = new Type[0];
        zzcv[] values = values();
        zzqc = new zzcv[values.length];
        for (zzcv zzcv : values) {
            zzqc[zzcv.f25id] = zzcv;
        }
    }

    private zzcv(int i, zzcx zzcx, zzdj zzdj) {
        this.f25id = i;
        this.zzpz = zzcx;
        this.zzpy = zzdj;
        switch (zzcw.zzqf[zzcx.ordinal()]) {
            case 1:
                this.zzqa = zzdj.zzei();
                break;
            case 2:
                this.zzqa = zzdj.zzei();
                break;
            default:
                this.zzqa = null;
                break;
        }
        boolean z = false;
        if (zzcx == zzcx.SCALAR) {
            switch (zzcw.zzqg[zzdj.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    break;
                default:
                    z = true;
                    break;
            }
        }
        this.zzqb = z;
    }

    /* renamed from: id */
    public final int mo8863id() {
        return this.f25id;
    }
}
