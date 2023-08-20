package com.google.android.gms.internal.firebase_auth;

import java.lang.reflect.Field;
import java.util.Arrays;

final class zzeu {
    /* access modifiers changed from: private */
    public final int flags;
    private final Object[] zzte;
    /* access modifiers changed from: private */
    public final int zztf;
    /* access modifiers changed from: private */
    public final int zztg;
    /* access modifiers changed from: private */
    public final int zzth;
    /* access modifiers changed from: private */
    public final int[] zztn;
    private final zzev zzub;
    private Class<?> zzuc;
    /* access modifiers changed from: private */
    public final int zzud;
    private final int zzue;
    private final int zzuf;
    /* access modifiers changed from: private */
    public final int zzug;
    /* access modifiers changed from: private */
    public final int zzuh;
    /* access modifiers changed from: private */
    public final int zzui;
    private int zzuj;
    private int zzuk;
    private int zzul = Integer.MAX_VALUE;
    private int zzum = Integer.MIN_VALUE;
    private int zzun = 0;
    private int zzuo = 0;
    private int zzup = 0;
    private int zzuq = 0;
    private int zzur = 0;
    private int zzus;
    private int zzut;
    private int zzuu;
    private int zzuv;
    private int zzuw;
    private Field zzux;
    private Object zzuy;
    private Object zzuz;
    private Object zzva;

    zzeu(Class<?> cls, String str, Object[] objArr) {
        int[] iArr = null;
        this.zzuc = cls;
        this.zzub = new zzev(str);
        this.zzte = objArr;
        this.flags = this.zzub.next();
        this.zzud = this.zzub.next();
        if (this.zzud == 0) {
            this.zzue = 0;
            this.zzuf = 0;
            this.zztf = 0;
            this.zztg = 0;
            this.zzug = 0;
            this.zzuh = 0;
            this.zzth = 0;
            this.zzui = 0;
            this.zztn = null;
            return;
        }
        this.zzue = this.zzub.next();
        this.zzuf = this.zzub.next();
        this.zztf = this.zzub.next();
        this.zztg = this.zzub.next();
        this.zzuh = this.zzub.next();
        this.zzth = this.zzub.next();
        this.zzug = this.zzub.next();
        this.zzui = this.zzub.next();
        int next = this.zzub.next();
        this.zztn = next != 0 ? new int[next] : iArr;
        this.zzuj = (this.zzue << 1) + this.zzuf;
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            throw new RuntimeException(new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length()).append("Field ").append(str).append(" for ").append(name).append(" not found. Known fields are ").append(arrays).toString());
        }
    }

    private final Object zzfm() {
        Object[] objArr = this.zzte;
        int i = this.zzuj;
        this.zzuj = i + 1;
        return objArr[i];
    }

    private final boolean zzfo() {
        return (this.flags & 1) == 1;
    }

    /* access modifiers changed from: package-private */
    public final boolean next() {
        boolean z = false;
        if (!this.zzub.hasNext()) {
            return false;
        }
        this.zzus = this.zzub.next();
        this.zzut = this.zzub.next();
        this.zzuu = this.zzut & 255;
        if (this.zzus < this.zzul) {
            this.zzul = this.zzus;
        }
        if (this.zzus > this.zzum) {
            this.zzum = this.zzus;
        }
        if (this.zzuu == zzcv.MAP.mo8863id()) {
            this.zzun++;
        } else if (this.zzuu >= zzcv.DOUBLE_LIST.mo8863id() && this.zzuu <= zzcv.GROUP_LIST.mo8863id()) {
            this.zzuo++;
        }
        this.zzur++;
        if (zzez.zzc(this.zzul, this.zzus, this.zzur)) {
            this.zzuq = this.zzus + 1;
            this.zzup = this.zzuq - this.zzul;
        } else {
            this.zzup++;
        }
        if ((this.zzut & 1024) != 0) {
            int[] iArr = this.zztn;
            int i = this.zzuk;
            this.zzuk = i + 1;
            iArr[i] = this.zzus;
        }
        this.zzuy = null;
        this.zzuz = null;
        this.zzva = null;
        if (zzfp()) {
            this.zzuv = this.zzub.next();
            if (this.zzuu == zzcv.MESSAGE.mo8863id() + 51 || this.zzuu == zzcv.GROUP.mo8863id() + 51) {
                this.zzuy = zzfm();
            } else if (this.zzuu == zzcv.ENUM.mo8863id() + 51 && zzfo()) {
                this.zzuz = zzfm();
            }
        } else {
            this.zzux = zza(this.zzuc, (String) zzfm());
            if (zzft()) {
                this.zzuw = this.zzub.next();
            }
            if (this.zzuu == zzcv.MESSAGE.mo8863id() || this.zzuu == zzcv.GROUP.mo8863id()) {
                this.zzuy = this.zzux.getType();
            } else if (this.zzuu == zzcv.MESSAGE_LIST.mo8863id() || this.zzuu == zzcv.GROUP_LIST.mo8863id()) {
                this.zzuy = zzfm();
            } else if (this.zzuu == zzcv.ENUM.mo8863id() || this.zzuu == zzcv.ENUM_LIST.mo8863id() || this.zzuu == zzcv.ENUM_LIST_PACKED.mo8863id()) {
                if (zzfo()) {
                    this.zzuz = zzfm();
                }
            } else if (this.zzuu == zzcv.MAP.mo8863id()) {
                this.zzva = zzfm();
                if ((this.zzut & 2048) != 0) {
                    z = true;
                }
                if (z) {
                    this.zzuz = zzfm();
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final int zzcx() {
        return this.zzus;
    }

    /* access modifiers changed from: package-private */
    public final int zzfn() {
        return this.zzuu;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzfp() {
        return this.zzuu > zzcv.MAP.mo8863id();
    }

    /* access modifiers changed from: package-private */
    public final Field zzfq() {
        int i = this.zzuv << 1;
        Object obj = this.zzte[i];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field zza = zza(this.zzuc, (String) obj);
        this.zzte[i] = zza;
        return zza;
    }

    /* access modifiers changed from: package-private */
    public final Field zzfr() {
        int i = (this.zzuv << 1) + 1;
        Object obj = this.zzte[i];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field zza = zza(this.zzuc, (String) obj);
        this.zzte[i] = zza;
        return zza;
    }

    /* access modifiers changed from: package-private */
    public final Field zzfs() {
        return this.zzux;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzft() {
        return zzfo() && this.zzuu <= zzcv.GROUP.mo8863id();
    }

    /* access modifiers changed from: package-private */
    public final Field zzfu() {
        int i = (this.zzuw / 32) + (this.zzue << 1);
        Object obj = this.zzte[i];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field zza = zza(this.zzuc, (String) obj);
        this.zzte[i] = zza;
        return zza;
    }

    /* access modifiers changed from: package-private */
    public final int zzfv() {
        return this.zzuw % 32;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzfw() {
        return (this.zzut & 256) != 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzfx() {
        return (this.zzut & 512) != 0;
    }

    /* access modifiers changed from: package-private */
    public final Object zzfy() {
        return this.zzuy;
    }

    /* access modifiers changed from: package-private */
    public final Object zzfz() {
        return this.zzuz;
    }

    /* access modifiers changed from: package-private */
    public final Object zzga() {
        return this.zzva;
    }
}
