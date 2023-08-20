package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.data.DataBufferObserver;
import com.google.android.gms.common.internal.Asserts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public final class ObjectDataBuffer<T> extends AbstractDataBuffer<T> implements DataBufferObserver.Observable, ObjectExclusionFilterable<T> {
    private final ArrayList<Integer> zzob;
    private final HashSet<Integer> zzoe;
    private DataBufferObserverSet zzof;
    private final ArrayList<T> zzog;

    public ObjectDataBuffer() {
        super((DataHolder) null);
        this.zzoe = new HashSet<>();
        this.zzob = new ArrayList<>();
        this.zzog = new ArrayList<>();
        this.zzof = new DataBufferObserverSet();
        zzcl();
    }

    public ObjectDataBuffer(ArrayList<T> arrayList) {
        super((DataHolder) null);
        this.zzoe = new HashSet<>();
        this.zzob = new ArrayList<>();
        this.zzog = arrayList;
        this.zzof = new DataBufferObserverSet();
        zzcl();
    }

    public ObjectDataBuffer(T... tArr) {
        super((DataHolder) null);
        this.zzoe = new HashSet<>();
        this.zzob = new ArrayList<>();
        this.zzog = new ArrayList<>(Arrays.asList(tArr));
        this.zzof = new DataBufferObserverSet();
        zzcl();
    }

    private final void zzcl() {
        this.zzob.clear();
        int size = this.zzog.size();
        for (int i = 0; i < size; i++) {
            if (!this.zzoe.contains(Integer.valueOf(i))) {
                this.zzob.add(Integer.valueOf(i));
            }
        }
    }

    public final void add(T t) {
        boolean z = false;
        int size = this.zzog.size();
        this.zzog.add(t);
        zzcl();
        if (this.zzof.hasObservers()) {
            Asserts.checkState(!this.zzoe.contains(Integer.valueOf(size)));
            int size2 = this.zzob.size();
            Asserts.checkState(size2 > 0);
            if (this.zzob.get(size2 - 1).intValue() == size) {
                z = true;
            }
            Asserts.checkState(z);
            this.zzof.onDataRangeInserted(size2 - 1, 1);
        }
    }

    public final void addObserver(DataBufferObserver dataBufferObserver) {
        this.zzof.addObserver(dataBufferObserver);
    }

    public final void filterOut(T t) {
        boolean z;
        int i;
        int size = this.zzog.size();
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        boolean z2 = false;
        int i5 = -1;
        while (i2 < size) {
            if (!this.zzoe.contains(Integer.valueOf(i2))) {
                i5++;
                if (t.equals(this.zzog.get(i2))) {
                    this.zzoe.add(Integer.valueOf(i2));
                    if (!this.zzof.hasObservers()) {
                        i = i5;
                        i5 = i4;
                        z = true;
                    } else if (i4 < 0) {
                        i3 = 1;
                        z = true;
                        i = i5;
                    } else {
                        i3++;
                        i = i5;
                        i5 = i4;
                        z = true;
                    }
                } else if (i4 >= 0) {
                    zzcl();
                    this.zzof.onDataRangeRemoved(i4, i3);
                    int i6 = i5 - i3;
                    i3 = -1;
                    z = false;
                    i = i6;
                    i5 = -1;
                }
                i2++;
                int i7 = i5;
                i5 = i;
                z2 = z;
                i4 = i7;
            }
            int i8 = i4;
            z = z2;
            i = i5;
            i5 = i8;
            i2++;
            int i72 = i5;
            i5 = i;
            z2 = z;
            i4 = i72;
        }
        if (z2) {
            zzcl();
        }
        if (i4 >= 0) {
            this.zzof.onDataRangeRemoved(i4, i3);
        }
    }

    public final void filterOutRaw(int i) {
        int i2;
        boolean add = this.zzoe.add(Integer.valueOf(i));
        if (this.zzof.hasObservers() && add) {
            int i3 = 0;
            int size = this.zzob.size();
            while (true) {
                if (i3 >= size) {
                    break;
                } else if (this.zzob.get(i3).intValue() == i) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
        }
        i2 = -1;
        zzcl();
        if (i2 >= 0) {
            this.zzof.onDataRangeRemoved(i2, 1);
        }
    }

    public final T get(int i) {
        return this.zzog.get(getRawPosition(i));
    }

    public final int getCount() {
        return this.zzog.size() - this.zzoe.size();
    }

    public final Bundle getMetadata() {
        return null;
    }

    public final int getPositionFromRawPosition(int i) {
        int i2 = -1;
        for (int i3 = 0; i3 <= i; i3++) {
            if (!this.zzoe.contains(Integer.valueOf(i3))) {
                i2++;
            }
        }
        return i2;
    }

    public final T getRaw(int i) {
        return this.zzog.get(i);
    }

    public final int getRawCount() {
        return this.zzog.size();
    }

    public final int getRawPosition(int i) {
        if (i >= 0 && i < getCount()) {
            return this.zzob.get(i).intValue();
        }
        throw new IllegalArgumentException(new StringBuilder(53).append("Position ").append(i).append(" is out of bounds for this buffer").toString());
    }

    public final void insertRaw(int i, T t) {
        this.zzog.add(i, t);
        HashSet hashSet = new HashSet(this.zzoe.size());
        Iterator<Integer> it = this.zzoe.iterator();
        int i2 = i;
        while (it.hasNext()) {
            Integer next = it.next();
            if (next.intValue() < i) {
                i2--;
            } else {
                hashSet.add(Integer.valueOf(next.intValue() + 1));
                it.remove();
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            this.zzoe.add((Integer) it2.next());
        }
        zzcl();
        if (this.zzof.hasObservers()) {
            this.zzof.onDataRangeInserted(i2, 1);
        }
    }

    public final boolean isRawPositionFiltered(int i) {
        return this.zzoe.contains(Integer.valueOf(i));
    }

    public final void notifyChanged(T t) {
        if (this.zzof.hasObservers()) {
            int size = this.zzob.size();
            for (int i = 0; i < size; i++) {
                if (t.equals(this.zzog.get(this.zzob.get(i).intValue()))) {
                    this.zzof.onDataRangeChanged(i, 1);
                }
            }
        }
    }

    public final void release() {
        this.zzof.clear();
    }

    public final void removeObserver(DataBufferObserver dataBufferObserver) {
        this.zzof.removeObserver(dataBufferObserver);
    }

    public final void removeRaw(int i) {
        this.zzog.remove(i);
        boolean remove = this.zzoe.remove(Integer.valueOf(i));
        HashSet hashSet = new HashSet(this.zzoe.size());
        Iterator<Integer> it = this.zzoe.iterator();
        int i2 = i;
        while (it.hasNext()) {
            Integer next = it.next();
            if (next.intValue() < i) {
                i2--;
            } else {
                it.remove();
                hashSet.add(Integer.valueOf(next.intValue() - 1));
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            this.zzoe.add((Integer) it2.next());
        }
        zzcl();
        if (!remove && this.zzof.hasObservers()) {
            this.zzof.onDataRangeRemoved(i2, 1);
        }
    }

    public final boolean setRaw(int i, T t) {
        this.zzog.set(i, t);
        boolean z = !this.zzoe.contains(Integer.valueOf(i));
        if (z && this.zzof.hasObservers()) {
            int size = this.zzob.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                } else if (this.zzob.get(i2).intValue() == i) {
                    this.zzof.onDataRangeChanged(i2, 1);
                    break;
                } else {
                    i2++;
                }
            }
        }
        return z;
    }

    public final void unfilter(T t) {
        int i;
        boolean z;
        int size = this.zzog.size();
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        boolean z2 = false;
        int i5 = 0;
        while (i2 < size) {
            if (!this.zzoe.contains(Integer.valueOf(i2))) {
                i5++;
                if (i4 >= 0) {
                    zzcl();
                    this.zzof.onDataRangeInserted(i4, i3);
                    int i6 = i5 + i3;
                    i3 = -1;
                    i4 = -1;
                    i = i6;
                    z = false;
                }
                boolean z3 = z2;
                i = i5;
                z = z3;
            } else if (t.equals(this.zzog.get(i2))) {
                this.zzoe.remove(Integer.valueOf(i2));
                if (!this.zzof.hasObservers()) {
                    i = i5;
                    z = true;
                } else if (i4 < 0) {
                    i3 = 1;
                    i4 = i5;
                    i = i5;
                    z = true;
                } else {
                    i3++;
                    i = i5;
                    z = true;
                }
            } else {
                if (this.zzof.hasObservers() && i4 >= 0) {
                    zzcl();
                    this.zzof.onDataRangeInserted(i4, i3);
                    int i7 = i5 + i3;
                    i3 = -1;
                    i4 = -1;
                    i = i7;
                    z = false;
                }
                boolean z32 = z2;
                i = i5;
                z = z32;
            }
            i2++;
            boolean z4 = z;
            i5 = i;
            z2 = z4;
        }
        if (z2) {
            zzcl();
        }
        if (i4 >= 0) {
            this.zzof.onDataRangeInserted(i4, i3);
        }
    }

    public final void unfilterRaw(int i) {
        int i2;
        boolean remove = this.zzoe.remove(Integer.valueOf(i));
        zzcl();
        if (this.zzof.hasObservers() && remove) {
            int i3 = 0;
            int size = this.zzob.size();
            while (true) {
                if (i3 >= size) {
                    i2 = -1;
                    break;
                } else if (this.zzob.get(i3).intValue() == i) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
            if (i2 >= 0) {
                this.zzof.onDataRangeInserted(i2, 1);
            }
        }
    }
}
