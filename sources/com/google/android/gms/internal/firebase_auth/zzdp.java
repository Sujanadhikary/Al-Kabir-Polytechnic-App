package com.google.android.gms.internal.firebase_auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzdp extends zzbq<String> implements zzdq, RandomAccess {
    private static final zzdp zzsk;
    private static final zzdq zzsl = zzsk;
    private final List<Object> zzsm;

    static {
        zzdp zzdp = new zzdp();
        zzsk = zzdp;
        zzdp.zzbp();
    }

    public zzdp() {
        this(10);
    }

    public zzdp(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    private zzdp(ArrayList<Object> arrayList) {
        this.zzsm = arrayList;
    }

    private static String zzg(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzbu ? ((zzbu) obj).zzbt() : zzdd.zze((byte[]) obj);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzbq();
        this.zzsm.add(i, (String) obj);
        this.modCount++;
    }

    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzbq();
        if (collection instanceof zzdq) {
            collection = ((zzdq) collection).zzel();
        }
        boolean addAll = this.zzsm.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public final void clear() {
        zzbq();
        this.zzsm.clear();
        this.modCount++;
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzsm.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzbu) {
            zzbu zzbu = (zzbu) obj;
            String zzbt = zzbu.zzbt();
            if (zzbu.zzbu()) {
                this.zzsm.set(i, zzbt);
            }
            return zzbt;
        }
        byte[] bArr = (byte[]) obj;
        String zze = zzdd.zze(bArr);
        if (zzdd.zzd(bArr)) {
            this.zzsm.set(i, zze);
        }
        return zze;
    }

    public final Object getRaw(int i) {
        return this.zzsm.get(i);
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* synthetic */ Object remove(int i) {
        zzbq();
        Object remove = this.zzsm.remove(i);
        this.modCount++;
        return zzg(remove);
    }

    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        zzbq();
        return zzg(this.zzsm.set(i, (String) obj));
    }

    public final int size() {
        return this.zzsm.size();
    }

    public final /* bridge */ /* synthetic */ boolean zzbo() {
        return super.zzbo();
    }

    public final void zzc(zzbu zzbu) {
        zzbq();
        this.zzsm.add(zzbu);
        this.modCount++;
    }

    public final List<?> zzel() {
        return Collections.unmodifiableList(this.zzsm);
    }

    public final zzdq zzem() {
        return zzbo() ? new zzfu(this) : this;
    }

    public final /* synthetic */ zzdg zzi(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzsm);
        return new zzdp((ArrayList<Object>) arrayList);
    }
}
