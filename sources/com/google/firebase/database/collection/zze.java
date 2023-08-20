package com.google.firebase.database.collection;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.LLRBNode;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zze<A, B, C> {
    private final Map<B, C> values;
    private final List<A> zzu;
    private final ImmutableSortedMap.Builder.KeyTranslator<A, B> zzv;
    private LLRBValueNode<A, C> zzw;
    private LLRBValueNode<A, C> zzx;

    private zze(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator) {
        this.zzu = list;
        this.values = map;
        this.zzv = keyTranslator;
    }

    private final LLRBNode<A, C> zza(int i, int i2) {
        if (i2 == 0) {
            return LLRBEmptyNode.getInstance();
        }
        if (i2 == 1) {
            A a = this.zzu.get(i);
            return new LLRBBlackValueNode(a, zzd(a), (LLRBNode) null, (LLRBNode) null);
        }
        int i3 = i2 / 2;
        int i4 = i + i3;
        LLRBNode zza = zza(i, i3);
        LLRBNode zza2 = zza(i4 + 1, i3);
        A a2 = this.zzu.get(i4);
        return new LLRBBlackValueNode(a2, zzd(a2), zza, zza2);
    }

    private final void zza(LLRBNode.Color color, int i, int i2) {
        LLRBNode zza = zza(i2 + 1, i - 1);
        A a = this.zzu.get(i2);
        LLRBValueNode<A, C> lLRBRedValueNode = color == LLRBNode.Color.RED ? new LLRBRedValueNode<>(a, zzd(a), (LLRBNode) null, zza) : new LLRBBlackValueNode<>(a, zzd(a), (LLRBNode) null, zza);
        if (this.zzw == null) {
            this.zzw = lLRBRedValueNode;
            this.zzx = lLRBRedValueNode;
            return;
        }
        this.zzx.zza(lLRBRedValueNode);
        this.zzx = lLRBRedValueNode;
    }

    public static <A, B, C> zzc<A, C> zzb(List<A> list, Map<B, C> map, ImmutableSortedMap.Builder.KeyTranslator<A, B> keyTranslator, Comparator<A> comparator) {
        zze zze = new zze(list, map, keyTranslator);
        Collections.sort(list, comparator);
        Iterator<zzh> it = new zzf(list.size()).iterator();
        int size = list.size();
        while (it.hasNext()) {
            zzh next = it.next();
            size -= next.zzab;
            if (next.zzaa) {
                zze.zza(LLRBNode.Color.BLACK, next.zzab, size);
            } else {
                zze.zza(LLRBNode.Color.BLACK, next.zzab, size);
                size -= next.zzab;
                zze.zza(LLRBNode.Color.RED, next.zzab, size);
            }
        }
        return new zzc<>(zze.zzw == null ? LLRBEmptyNode.getInstance() : zze.zzw, comparator);
    }

    private final C zzd(A a) {
        return this.values.get(this.zzv.translate(a));
    }
}
