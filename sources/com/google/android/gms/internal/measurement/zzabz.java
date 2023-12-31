package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzaby;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class zzabz<M extends zzaby<M>, T> {
    public final int tag;
    private final int type;
    protected final Class<T> zzbwx;
    protected final boolean zzbwy;
    private final zzzq<?, ?> zzbwz;

    private zzabz(int i, Class<T> cls, int i2, boolean z) {
        this(11, cls, (zzzq<?, ?>) null, 810, false);
    }

    private zzabz(int i, Class<T> cls, zzzq<?, ?> zzzq, int i2, boolean z) {
        this.type = i;
        this.zzbwx = cls;
        this.tag = i2;
        this.zzbwy = false;
        this.zzbwz = null;
    }

    public static <M extends zzaby<M>, T extends zzace> zzabz<M, T> zza(int i, Class<T> cls, long j) {
        return new zzabz<>(11, cls, 810, false);
    }

    private final Object zzf(zzabv zzabv) {
        Class<?> componentType = this.zzbwy ? this.zzbwx.getComponentType() : this.zzbwx;
        try {
            switch (this.type) {
                case 10:
                    zzace zzace = (zzace) componentType.newInstance();
                    zzabv.zza(zzace, this.tag >>> 3);
                    return zzace;
                case 11:
                    zzace zzace2 = (zzace) componentType.newInstance();
                    zzabv.zza(zzace2);
                    return zzace2;
                default:
                    throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
            }
        } catch (InstantiationException e) {
            String valueOf = String.valueOf(componentType);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Error creating instance of class ").append(valueOf).toString(), e);
        } catch (IllegalAccessException e2) {
            String valueOf2 = String.valueOf(componentType);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 33).append("Error creating instance of class ").append(valueOf2).toString(), e2);
        } catch (IOException e3) {
            throw new IllegalArgumentException("Error reading extension field", e3);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzabz)) {
            return false;
        }
        zzabz zzabz = (zzabz) obj;
        return this.type == zzabz.type && this.zzbwx == zzabz.zzbwx && this.tag == zzabz.tag && this.zzbwy == zzabz.zzbwy;
    }

    public final int hashCode() {
        return (this.zzbwy ? 1 : 0) + ((((((this.type + 1147) * 31) + this.zzbwx.hashCode()) * 31) + this.tag) * 31);
    }

    /* access modifiers changed from: protected */
    public final void zza(Object obj, zzabw zzabw) {
        try {
            zzabw.zzar(this.tag);
            switch (this.type) {
                case 10:
                    ((zzace) obj).zza(zzabw);
                    zzabw.zzg(this.tag >>> 3, 4);
                    return;
                case 11:
                    zzabw.zzb((zzace) obj);
                    return;
                default:
                    throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    /* access modifiers changed from: package-private */
    public final T zzi(List<zzacg> list) {
        if (list == null) {
            return null;
        }
        if (this.zzbwy) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                zzacg zzacg = list.get(i);
                if (zzacg.zzbrc.length != 0) {
                    arrayList.add(zzf(zzabv.zzi(zzacg.zzbrc)));
                }
            }
            int size = arrayList.size();
            if (size == 0) {
                return null;
            }
            T cast = this.zzbwx.cast(Array.newInstance(this.zzbwx.getComponentType(), size));
            for (int i2 = 0; i2 < size; i2++) {
                Array.set(cast, i2, arrayList.get(i2));
            }
            return cast;
        } else if (list.isEmpty()) {
            return null;
        } else {
            return this.zzbwx.cast(zzf(zzabv.zzi(list.get(list.size() - 1).zzbrc)));
        }
    }

    /* access modifiers changed from: protected */
    public final int zzv(Object obj) {
        int i = this.tag >>> 3;
        switch (this.type) {
            case 10:
                return (zzabw.zzaq(i) << 1) + ((zzace) obj).zzvm();
            case 11:
                return zzabw.zzb(i, (zzace) obj);
            default:
                throw new IllegalArgumentException(new StringBuilder(24).append("Unknown type ").append(this.type).toString());
        }
    }
}
