package com.google.android.gms.internal.firebase_auth;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzfa<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zznv;
    private final int zzvf;
    /* access modifiers changed from: private */
    public List<zzfh> zzvg;
    /* access modifiers changed from: private */
    public Map<K, V> zzvh;
    private volatile zzfj zzvi;
    /* access modifiers changed from: private */
    public Map<K, V> zzvj;
    private volatile zzfd zzvk;

    private zzfa(int i) {
        this.zzvf = i;
        this.zzvg = Collections.emptyList();
        this.zzvh = Collections.emptyMap();
        this.zzvj = Collections.emptyMap();
    }

    /* synthetic */ zzfa(int i, zzfb zzfb) {
        this(i);
    }

    private final int zza(K k) {
        int size = this.zzvg.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo((Comparable) this.zzvg.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        int i2 = size;
        while (i <= i2) {
            int i3 = (i + i2) / 2;
            int compareTo2 = k.compareTo((Comparable) this.zzvg.get(i3).getKey());
            if (compareTo2 < 0) {
                i2 = i3 - 1;
            } else if (compareTo2 <= 0) {
                return i3;
            } else {
                i = i3 + 1;
            }
        }
        return -(i + 1);
    }

    static <FieldDescriptorType extends zzcu<FieldDescriptorType>> zzfa<FieldDescriptorType, Object> zzat(int i) {
        return new zzfb(i);
    }

    /* access modifiers changed from: private */
    public final V zzav(int i) {
        zzgj();
        V value = this.zzvg.remove(i).getValue();
        if (!this.zzvh.isEmpty()) {
            Iterator it = zzgk().entrySet().iterator();
            this.zzvg.add(new zzfh(this, (Map.Entry) it.next()));
            it.remove();
        }
        return value;
    }

    /* access modifiers changed from: private */
    public final void zzgj() {
        if (this.zznv) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzgk() {
        zzgj();
        if (this.zzvh.isEmpty() && !(this.zzvh instanceof TreeMap)) {
            this.zzvh = new TreeMap();
            this.zzvj = ((TreeMap) this.zzvh).descendingMap();
        }
        return (SortedMap) this.zzvh;
    }

    public void clear() {
        zzgj();
        if (!this.zzvg.isEmpty()) {
            this.zzvg.clear();
        }
        if (!this.zzvh.isEmpty()) {
            this.zzvh.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzvh.containsKey(comparable);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzvi == null) {
            this.zzvi = new zzfj(this, (zzfb) null);
        }
        return this.zzvi;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfa)) {
            return super.equals(obj);
        }
        zzfa zzfa = (zzfa) obj;
        int size = size();
        if (size != zzfa.size()) {
            return false;
        }
        int zzgg = zzgg();
        if (zzgg != zzfa.zzgg()) {
            return entrySet().equals(zzfa.entrySet());
        }
        for (int i = 0; i < zzgg; i++) {
            if (!zzau(i).equals(zzfa.zzau(i))) {
                return false;
            }
        }
        if (zzgg != size) {
            return this.zzvh.equals(zzfa.zzvh);
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        return zza >= 0 ? this.zzvg.get(zza).getValue() : this.zzvh.get(comparable);
    }

    public int hashCode() {
        int zzgg = zzgg();
        int i = 0;
        for (int i2 = 0; i2 < zzgg; i2++) {
            i += this.zzvg.get(i2).hashCode();
        }
        return this.zzvh.size() > 0 ? this.zzvh.hashCode() + i : i;
    }

    public final boolean isImmutable() {
        return this.zznv;
    }

    public V remove(Object obj) {
        zzgj();
        Comparable comparable = (Comparable) obj;
        int zza = zza(comparable);
        if (zza >= 0) {
            return zzav(zza);
        }
        if (this.zzvh.isEmpty()) {
            return null;
        }
        return this.zzvh.remove(comparable);
    }

    public int size() {
        return this.zzvg.size() + this.zzvh.size();
    }

    /* renamed from: zza */
    public final V put(K k, V v) {
        zzgj();
        int zza = zza(k);
        if (zza >= 0) {
            return this.zzvg.get(zza).setValue(v);
        }
        zzgj();
        if (this.zzvg.isEmpty() && !(this.zzvg instanceof ArrayList)) {
            this.zzvg = new ArrayList(this.zzvf);
        }
        int i = -(zza + 1);
        if (i >= this.zzvf) {
            return zzgk().put(k, v);
        }
        if (this.zzvg.size() == this.zzvf) {
            zzfh remove = this.zzvg.remove(this.zzvf - 1);
            zzgk().put((Comparable) remove.getKey(), remove.getValue());
        }
        this.zzvg.add(i, new zzfh(this, k, v));
        return null;
    }

    public final Map.Entry<K, V> zzau(int i) {
        return this.zzvg.get(i);
    }

    public void zzbp() {
        if (!this.zznv) {
            this.zzvh = this.zzvh.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzvh);
            this.zzvj = this.zzvj.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzvj);
            this.zznv = true;
        }
    }

    public final int zzgg() {
        return this.zzvg.size();
    }

    public final Iterable<Map.Entry<K, V>> zzgh() {
        return this.zzvh.isEmpty() ? zzfe.zzgm() : this.zzvh.entrySet();
    }

    /* access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> zzgi() {
        if (this.zzvk == null) {
            this.zzvk = new zzfd(this, (zzfb) null);
        }
        return this.zzvk;
    }
}
