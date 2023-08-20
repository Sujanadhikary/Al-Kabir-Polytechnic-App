package com.google.android.gms.internal.firebase_database;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.StandardComparator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class zzgj<T> implements Iterable<Map.Entry<zzch, T>> {
    private static final ImmutableSortedMap zzoc = ImmutableSortedMap.Builder.emptyMap(StandardComparator.getComparator(zzid.class));
    private static final zzgj zzod = new zzgj((Object) null, zzoc);
    private final T value;
    private final ImmutableSortedMap<zzid, zzgj<T>> zzob;

    public zzgj(T t) {
        this(t, zzoc);
    }

    private zzgj(T t, ImmutableSortedMap<zzid, zzgj<T>> immutableSortedMap) {
        this.value = t;
        this.zzob = immutableSortedMap;
    }

    private final <R> R zza(zzch zzch, zzgm<? super T, R> zzgm, R r) {
        Iterator<Map.Entry<zzid, zzgj<T>>> it = this.zzob.iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            r = ((zzgj) next.getValue()).zza(zzch.zza((zzid) next.getKey()), zzgm, r);
        }
        return this.value != null ? zzgm.zza(zzch, this.value, r) : r;
    }

    public static <V> zzgj<V> zzdl() {
        return zzod;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzgj zzgj = (zzgj) obj;
        if (this.zzob == null ? zzgj.zzob != null : !this.zzob.equals(zzgj.zzob)) {
            return false;
        }
        if (this.value != null) {
            if (this.value.equals(zzgj.value)) {
                return true;
            }
        } else if (zzgj.value == null) {
            return true;
        }
        return false;
    }

    public final T getValue() {
        return this.value;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (this.value != null ? this.value.hashCode() : 0) * 31;
        if (this.zzob != null) {
            i = this.zzob.hashCode();
        }
        return hashCode + i;
    }

    public final boolean isEmpty() {
        return this.value == null && this.zzob.isEmpty();
    }

    public final Iterator<Map.Entry<zzch, T>> iterator() {
        ArrayList arrayList = new ArrayList();
        zza(new zzgl(this, arrayList));
        return arrayList.iterator();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableTree { value=");
        sb.append(this.value);
        sb.append(", children={");
        Iterator<Map.Entry<zzid, zzgj<T>>> it = this.zzob.iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            sb.append(((zzid) next.getKey()).zzfg());
            sb.append("=");
            sb.append(next.getValue());
        }
        sb.append("} }");
        return sb.toString();
    }

    public final Collection<T> values() {
        ArrayList arrayList = new ArrayList();
        zza(new zzgk(this, arrayList));
        return arrayList;
    }

    public final zzch zza(zzch zzch, zzgn<? super T> zzgn) {
        if (this.value != null && zzgn.zzd(this.value)) {
            return zzch.zzbt();
        }
        if (zzch.isEmpty()) {
            return null;
        }
        zzid zzbw = zzch.zzbw();
        zzgj zzgj = this.zzob.get(zzbw);
        if (zzgj == null) {
            return null;
        }
        zzch zza = zzgj.zza(zzch.zzbx(), zzgn);
        if (zza == null) {
            return null;
        }
        return new zzch(zzbw).zzh(zza);
    }

    public final zzgj<T> zza(zzch zzch, zzgj<T> zzgj) {
        if (zzch.isEmpty()) {
            return zzgj;
        }
        zzid zzbw = zzch.zzbw();
        zzgj zzgj2 = this.zzob.get(zzbw);
        if (zzgj2 == null) {
            zzgj2 = zzod;
        }
        zzgj<T> zza = zzgj2.zza(zzch.zzbx(), zzgj);
        return new zzgj<>(this.value, zza.isEmpty() ? this.zzob.remove(zzbw) : this.zzob.insert(zzbw, zza));
    }

    public final void zza(zzgm<T, Void> zzgm) {
        zza(zzch.zzbt(), zzgm, (Object) null);
    }

    public final zzch zzae(zzch zzch) {
        return zza(zzch, zzgn.zzog);
    }

    public final T zzaf(zzch zzch) {
        zzgj zzgj;
        zzgn<Object> zzgn = zzgn.zzog;
        T t = (this.value == null || !zzgn.zzd(this.value)) ? null : this.value;
        Iterator<zzid> it = zzch.iterator();
        T t2 = t;
        while (it.hasNext() && (zzgj = this.zzob.get(it.next())) != null) {
            if (zzgj.value != null && zzgn.zzd(zzgj.value)) {
                t2 = zzgj.value;
            }
            this = zzgj;
        }
        return t2;
    }

    public final zzgj<T> zzag(zzch zzch) {
        while (!zzch.isEmpty()) {
            zzgj<T> zzgj = this.zzob.get(zzch.zzbw());
            if (zzgj == null) {
                return zzod;
            }
            zzch = zzch.zzbx();
            this = zzgj;
        }
        return this;
    }

    public final zzgj<T> zzah(zzch zzch) {
        if (zzch.isEmpty()) {
            return this.zzob.isEmpty() ? zzod : new zzgj<>((Object) null, this.zzob);
        }
        zzid zzbw = zzch.zzbw();
        zzgj zzgj = this.zzob.get(zzbw);
        if (zzgj == null) {
            return this;
        }
        zzgj zzah = zzgj.zzah(zzch.zzbx());
        ImmutableSortedMap<zzid, zzgj<T>> remove = zzah.isEmpty() ? this.zzob.remove(zzbw) : this.zzob.insert(zzbw, zzah);
        return (this.value != null || !remove.isEmpty()) ? new zzgj<>(this.value, remove) : zzod;
    }

    public final T zzai(zzch zzch) {
        while (!zzch.isEmpty()) {
            zzgj zzgj = this.zzob.get(zzch.zzbw());
            if (zzgj == null) {
                return null;
            }
            zzch = zzch.zzbx();
            this = zzgj;
        }
        return this.value;
    }

    public final zzgj<T> zzb(zzch zzch, T t) {
        if (zzch.isEmpty()) {
            return new zzgj<>(t, this.zzob);
        }
        zzid zzbw = zzch.zzbw();
        zzgj zzgj = this.zzob.get(zzbw);
        if (zzgj == null) {
            zzgj = zzod;
        }
        return new zzgj<>(this.value, this.zzob.insert(zzbw, zzgj.zzb(zzch.zzbx(), t)));
    }

    public final T zzb(zzch zzch, zzgn<? super T> zzgn) {
        if (this.value != null && zzgn.zzd(this.value)) {
            return this.value;
        }
        Iterator<zzid> it = zzch.iterator();
        while (it.hasNext()) {
            zzgj zzgj = this.zzob.get(it.next());
            if (zzgj == null) {
                return null;
            }
            if (zzgj.value != null && zzgn.zzd(zzgj.value)) {
                return zzgj.value;
            }
            this = zzgj;
        }
        return null;
    }

    public final <R> R zzb(R r, zzgm<? super T, R> zzgm) {
        return zza(zzch.zzbt(), zzgm, r);
    }

    public final boolean zzb(zzgn<? super T> zzgn) {
        if (this.value != null && zzgn.zzd(this.value)) {
            return true;
        }
        Iterator<Map.Entry<zzid, zzgj<T>>> it = this.zzob.iterator();
        while (it.hasNext()) {
            if (((zzgj) it.next().getValue()).zzb(zzgn)) {
                return true;
            }
        }
        return false;
    }

    public final ImmutableSortedMap<zzid, zzgj<T>> zzdm() {
        return this.zzob;
    }

    public final zzgj<T> zze(zzid zzid) {
        zzgj<T> zzgj = this.zzob.get(zzid);
        return zzgj != null ? zzgj : zzod;
    }
}
