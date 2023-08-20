package com.google.firebase.database.collection;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.LLRBNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zza<K, V> extends ImmutableSortedMap<K, V> {
    /* access modifiers changed from: private */
    public final K[] zza;
    /* access modifiers changed from: private */
    public final V[] zzb;
    private final Comparator<K> zzc;

    public zza(Comparator<K> comparator) {
        this.zza = new Object[0];
        this.zzb = new Object[0];
        this.zzc = comparator;
    }

    private zza(Comparator<K> comparator, K[] kArr, V[] vArr) {
        this.zza = kArr;
        this.zzb = vArr;
        this.zzc = comparator;
    }

    private final int zza(K k) {
        int i = 0;
        while (i < this.zza.length && this.zzc.compare(this.zza[i], k) < 0) {
            i++;
        }
        return i;
    }

    public static <A, B, C> zza<A, C> zza(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator, Comparator<A> comparator) {
        Collections.sort(list, comparator);
        int size = list.size();
        Object[] objArr = new Object[size];
        Object[] objArr2 = new Object[size];
        int i = 0;
        for (A next : list) {
            objArr[i] = next;
            objArr2[i] = map.get(keyTranslator.translate(next));
            i++;
        }
        return new zza<>(comparator, objArr, objArr2);
    }

    public static <K, V> zza<K, V> zza(Map<K, V> map, Comparator<K> comparator) {
        return zza(new ArrayList(map.keySet()), map, ImmutableSortedMap.Builder.identityTranslator(), comparator);
    }

    private final Iterator<Map.Entry<K, V>> zza(int i, boolean z) {
        return new zzb(this, i, z);
    }

    private static <T> T[] zza(T[] tArr, int i) {
        int length = tArr.length - 1;
        T[] tArr2 = new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, i);
        System.arraycopy(tArr, i + 1, tArr2, i, length - i);
        return tArr2;
    }

    private static <T> T[] zza(T[] tArr, int i, T t) {
        int length = tArr.length + 1;
        T[] tArr2 = new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, i);
        tArr2[i] = t;
        System.arraycopy(tArr, i, tArr2, i + 1, (length - i) - 1);
        return tArr2;
    }

    private final int zzb(K k) {
        int i = 0;
        K[] kArr = this.zza;
        int length = kArr.length;
        int i2 = 0;
        while (i2 < length) {
            if (this.zzc.compare(k, kArr[i2]) == 0) {
                return i;
            }
            i2++;
            i++;
        }
        return -1;
    }

    private static <T> T[] zzb(T[] tArr, int i, T t) {
        int length = tArr.length;
        T[] tArr2 = new Object[length];
        System.arraycopy(tArr, 0, tArr2, 0, length);
        tArr2[i] = t;
        return tArr2;
    }

    public final boolean containsKey(K k) {
        return zzb(k) != -1;
    }

    public final V get(K k) {
        int zzb2 = zzb(k);
        if (zzb2 != -1) {
            return this.zzb[zzb2];
        }
        return null;
    }

    public final Comparator<K> getComparator() {
        return this.zzc;
    }

    public final K getMaxKey() {
        if (this.zza.length > 0) {
            return this.zza[this.zza.length - 1];
        }
        return null;
    }

    public final K getMinKey() {
        if (this.zza.length > 0) {
            return this.zza[0];
        }
        return null;
    }

    public final K getPredecessorKey(K k) {
        int zzb2 = zzb(k);
        if (zzb2 == -1) {
            throw new IllegalArgumentException("Can't find predecessor of nonexistent key");
        } else if (zzb2 > 0) {
            return this.zza[zzb2 - 1];
        } else {
            return null;
        }
    }

    public final K getSuccessorKey(K k) {
        int zzb2 = zzb(k);
        if (zzb2 == -1) {
            throw new IllegalArgumentException("Can't find successor of nonexistent key");
        } else if (zzb2 < this.zza.length - 1) {
            return this.zza[zzb2 + 1];
        } else {
            return null;
        }
    }

    public final void inOrderTraversal(LLRBNode.NodeVisitor<K, V> nodeVisitor) {
        for (int i = 0; i < this.zza.length; i++) {
            nodeVisitor.visitEntry(this.zza[i], this.zzb[i]);
        }
    }

    public final int indexOf(K k) {
        return zzb(k);
    }

    public final ImmutableSortedMap<K, V> insert(K k, V v) {
        int zzb2 = zzb(k);
        if (zzb2 != -1) {
            if (this.zza[zzb2] == k && this.zzb[zzb2] == v) {
                return this;
            }
            return new zza(this.zzc, zzb(this.zza, zzb2, k), zzb(this.zzb, zzb2, v));
        } else if (this.zza.length > 25) {
            HashMap hashMap = new HashMap(this.zza.length + 1);
            for (int i = 0; i < this.zza.length; i++) {
                hashMap.put(this.zza[i], this.zzb[i]);
            }
            hashMap.put(k, v);
            return zzc.zzb(hashMap, this.zzc);
        } else {
            int zza2 = zza(k);
            return new zza(this.zzc, zza(this.zza, zza2, k), zza(this.zzb, zza2, v));
        }
    }

    public final boolean isEmpty() {
        return this.zza.length == 0;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return zza(0, false);
    }

    public final Iterator<Map.Entry<K, V>> iteratorFrom(K k) {
        return zza(zza(k), false);
    }

    public final ImmutableSortedMap<K, V> remove(K k) {
        int zzb2 = zzb(k);
        if (zzb2 == -1) {
            return this;
        }
        return new zza(this.zzc, zza((T[]) this.zza, zzb2), zza((T[]) this.zzb, zzb2));
    }

    public final Iterator<Map.Entry<K, V>> reverseIterator() {
        return zza(this.zza.length - 1, true);
    }

    public final Iterator<Map.Entry<K, V>> reverseIteratorFrom(K k) {
        int zza2 = zza(k);
        return (zza2 >= this.zza.length || this.zzc.compare(this.zza[zza2], k) != 0) ? zza(zza2 - 1, true) : zza(zza2, true);
    }

    public final int size() {
        return this.zza.length;
    }
}
