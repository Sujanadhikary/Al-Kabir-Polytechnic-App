package com.google.android.gms.common.data;

import android.text.TextUtils;
import com.google.android.gms.common.data.DataBufferObserver;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

@VisibleForTesting
public final class ExclusionFilteredDataBuffer<T> extends FilteredDataBuffer<T> implements DataBufferObserver.Observable, ExclusionFilterable {
    private AbstractDataBuffer<T> zzoc;
    private final String zzod;
    private final HashSet<Integer> zzoe = new HashSet<>();
    private DataBufferObserverSet zzof;

    public ExclusionFilteredDataBuffer(AbstractDataBuffer<T> abstractDataBuffer, String str) {
        super(abstractDataBuffer);
        this.zzoc = abstractDataBuffer;
        this.zzod = str;
        this.zzof = new DataBufferObserverSet();
    }

    private final ArrayList<Integer> zza(String str, ArrayList<Integer> arrayList) {
        int i;
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            arrayList.clear();
        }
        DataHolder dataHolder = this.zzoc.mDataHolder;
        String str2 = this.zzod;
        boolean z = this.zzoc instanceof EntityBuffer;
        int count = this.zzoc.getCount();
        int i2 = 0;
        for (int i3 = 0; i3 < count; i3++) {
            int zzi = z ? ((EntityBuffer) this.zzoc).zzi(i3) : i3;
            String string = dataHolder.getString(str2, zzi, dataHolder.getWindowIndex(zzi));
            if (arrayList == null) {
                i = i2;
            } else if (this.zzoe.contains(Integer.valueOf(i3))) {
                i = (-i2) - 1;
            } else {
                int i4 = i2;
                i2++;
                i = i4;
            }
            if (!TextUtils.isEmpty(string) && string.equals(str)) {
                arrayList2.add(Integer.valueOf(i3));
                if (arrayList != null) {
                    arrayList.add(Integer.valueOf(i));
                }
            }
        }
        return arrayList2;
    }

    public final void addObserver(DataBufferObserver dataBufferObserver) {
        this.zzof.addObserver(dataBufferObserver);
    }

    public final void clearFilters() {
        int i;
        if (!this.zzof.hasObservers()) {
            this.zzoe.clear();
            return;
        }
        int size = this.zzoe.size();
        Integer[] numArr = (Integer[]) this.zzoe.toArray(new Integer[size]);
        Arrays.sort(numArr);
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < size) {
            int intValue = numArr[i2].intValue();
            this.zzoe.remove(Integer.valueOf(intValue));
            if (i3 == 0) {
                i4 = intValue;
                i = 1;
            } else if (intValue == i4 + i3) {
                i = i3 + 1;
            } else {
                this.zzof.onDataRangeRemoved(i4, i3);
                i4 = intValue;
                i = 1;
            }
            i2++;
            i3 = i;
        }
        if (i3 > 0) {
            this.zzof.onDataRangeRemoved(i4, i3);
        }
    }

    public final int computeRealPosition(int i) {
        if (this.zzoe.isEmpty()) {
            return i;
        }
        if (i < 0 || i >= getCount()) {
            throw new IllegalArgumentException(new StringBuilder(53).append("Position ").append(i).append(" is out of bounds for this buffer").toString());
        }
        int count = this.mDataBuffer.getCount();
        int i2 = 0;
        for (int i3 = 0; i3 < count; i3++) {
            if (!this.zzoe.contains(Integer.valueOf(i3))) {
                if (i2 == i) {
                    return i3;
                }
                i2++;
            }
        }
        return -1;
    }

    public final void filterOut(String str) {
        int i;
        int i2;
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = this.zzof.hasObservers() ? new ArrayList() : null;
            ArrayList<Integer> zza = zza(str, arrayList);
            if (this.zzof.hasObservers()) {
                int size = zza.size() - 1;
                int i3 = 0;
                int i4 = 0;
                while (size >= 0) {
                    int intValue = ((Integer) arrayList.get(size)).intValue();
                    if (!(intValue < 0)) {
                        this.zzoe.add(Integer.valueOf(zza.get(size).intValue()));
                        if (i3 == 0) {
                            i = 1;
                            i2 = intValue;
                        } else if (intValue == i4 - 1) {
                            i = i3 + 1;
                            i2 = i4 - 1;
                        } else {
                            this.zzof.onDataRangeRemoved(i4, i3);
                            i = 1;
                            i2 = intValue;
                        }
                    } else {
                        i = i3;
                        i2 = i4;
                    }
                    size--;
                    i4 = i2;
                    i3 = i;
                }
                if (i3 > 0) {
                    this.zzof.onDataRangeRemoved(i4, i3);
                    return;
                }
                return;
            }
            this.zzoe.addAll(zza);
        }
    }

    public final int getCount() {
        return this.mDataBuffer.getCount() - this.zzoe.size();
    }

    public final void release() {
        super.release();
        this.zzof.clear();
    }

    public final void removeObserver(DataBufferObserver dataBufferObserver) {
        this.zzof.removeObserver(dataBufferObserver);
    }

    public final void unfilter(String str) {
        int i;
        int i2;
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = this.zzof.hasObservers() ? new ArrayList() : null;
            ArrayList<Integer> zza = zza(str, arrayList);
            if (this.zzof.hasObservers()) {
                int size = zza.size() - 1;
                int i3 = 0;
                int i4 = 0;
                while (size >= 0) {
                    int intValue = ((Integer) arrayList.get(size)).intValue();
                    if (intValue < 0) {
                        this.zzoe.remove(Integer.valueOf(zza.get(size).intValue()));
                        int i5 = (-intValue) - 1;
                        if (i3 == 0) {
                            i2 = i5;
                            i = 1;
                        } else if (i5 == i4) {
                            i = i3 + 1;
                            i2 = i4;
                        } else {
                            this.zzof.onDataRangeInserted(i4, i3);
                            i2 = i5;
                            i = 1;
                        }
                    } else {
                        i = i3;
                        i2 = i4;
                    }
                    size--;
                    i4 = i2;
                    i3 = i;
                }
                if (i3 > 0) {
                    this.zzof.onDataRangeInserted(i4, i3);
                    return;
                }
                return;
            }
            this.zzoe.removeAll(zza);
        }
    }
}
