package com.google.android.gms.internal.firebase_database;

import com.google.firebase.database.DatabaseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class zzch implements Comparable<zzch>, Iterable<zzid> {
    private static final zzch zzhs = new zzch("");
    /* access modifiers changed from: private */
    public final int end;
    /* access modifiers changed from: private */
    public final int start;
    /* access modifiers changed from: private */
    public final zzid[] zzhr;

    public zzch(String str) {
        int i;
        String[] split = str.split("/");
        int i2 = 0;
        for (String length : split) {
            if (length.length() > 0) {
                i2++;
            }
        }
        this.zzhr = new zzid[i2];
        int length2 = split.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length2) {
            String str2 = split[i3];
            if (str2.length() > 0) {
                i = i4 + 1;
                this.zzhr[i4] = zzid.zzt(str2);
            } else {
                i = i4;
            }
            i3++;
            i4 = i;
        }
        this.start = 0;
        this.end = this.zzhr.length;
    }

    public zzch(List<String> list) {
        this.zzhr = new zzid[list.size()];
        int i = 0;
        for (String zzt : list) {
            this.zzhr[i] = zzid.zzt(zzt);
            i++;
        }
        this.start = 0;
        this.end = list.size();
    }

    public zzch(zzid... zzidArr) {
        this.zzhr = (zzid[]) Arrays.copyOf(zzidArr, zzidArr.length);
        this.start = 0;
        this.end = zzidArr.length;
    }

    private zzch(zzid[] zzidArr, int i, int i2) {
        this.zzhr = zzidArr;
        this.start = i;
        this.end = i2;
    }

    public static zzch zza(zzch zzch, zzch zzch2) {
        while (true) {
            zzid zzbw = zzch.zzbw();
            zzid zzbw2 = zzch2.zzbw();
            if (zzbw == null) {
                return zzch2;
            }
            if (zzbw.equals(zzbw2)) {
                zzch = zzch.zzbx();
                zzch2 = zzch2.zzbx();
            } else {
                String valueOf = String.valueOf(zzch2);
                String valueOf2 = String.valueOf(zzch);
                throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 37 + String.valueOf(valueOf2).length()).append("INTERNAL ERROR: ").append(valueOf).append(" is not contained in ").append(valueOf2).toString());
            }
        }
    }

    public static zzch zzbt() {
        return zzhs;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzch)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zzch zzch = (zzch) obj;
        if (size() != zzch.size()) {
            return false;
        }
        int i = this.start;
        int i2 = zzch.start;
        while (i < this.end && i2 < zzch.end) {
            if (!this.zzhr[i].equals(zzch.zzhr[i2])) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        for (int i2 = this.start; i2 < this.end; i2++) {
            i = (i * 37) + this.zzhr[i2].hashCode();
        }
        return i;
    }

    public final boolean isEmpty() {
        return this.start >= this.end;
    }

    public final Iterator<zzid> iterator() {
        return new zzci(this);
    }

    public final int size() {
        return this.end - this.start;
    }

    public final String toString() {
        if (isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = this.start; i < this.end; i++) {
            sb.append("/");
            sb.append(this.zzhr[i].zzfg());
        }
        return sb.toString();
    }

    public final zzch zza(zzid zzid) {
        int size = size();
        zzid[] zzidArr = new zzid[(size + 1)];
        System.arraycopy(this.zzhr, this.start, zzidArr, 0, size);
        zzidArr[size] = zzid;
        return new zzch(zzidArr, 0, size + 1);
    }

    public final String zzbu() {
        if (isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = this.start; i < this.end; i++) {
            if (i > this.start) {
                sb.append("/");
            }
            sb.append(this.zzhr[i].zzfg());
        }
        return sb.toString();
    }

    public final List<String> zzbv() {
        ArrayList arrayList = new ArrayList(size());
        Iterator<zzid> it = iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().zzfg());
        }
        return arrayList;
    }

    public final zzid zzbw() {
        if (isEmpty()) {
            return null;
        }
        return this.zzhr[this.start];
    }

    public final zzch zzbx() {
        int i = this.start;
        if (!isEmpty()) {
            i++;
        }
        return new zzch(this.zzhr, i, this.end);
    }

    public final zzch zzby() {
        if (isEmpty()) {
            return null;
        }
        return new zzch(this.zzhr, this.start, this.end - 1);
    }

    public final zzid zzbz() {
        if (!isEmpty()) {
            return this.zzhr[this.end - 1];
        }
        return null;
    }

    public final zzch zzh(zzch zzch) {
        int size = size() + zzch.size();
        zzid[] zzidArr = new zzid[size];
        System.arraycopy(this.zzhr, this.start, zzidArr, 0, size());
        System.arraycopy(zzch.zzhr, zzch.start, zzidArr, size(), zzch.size());
        return new zzch(zzidArr, 0, size);
    }

    public final boolean zzi(zzch zzch) {
        if (size() > zzch.size()) {
            return false;
        }
        int i = this.start;
        int i2 = zzch.start;
        while (i < this.end) {
            if (!this.zzhr[i].equals(zzch.zzhr[i2])) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    /* renamed from: zzj */
    public final int compareTo(zzch zzch) {
        int i = this.start;
        int i2 = zzch.start;
        while (i < this.end && i2 < zzch.end) {
            int zzi = this.zzhr[i].compareTo(zzch.zzhr[i2]);
            if (zzi != 0) {
                return zzi;
            }
            i++;
            i2++;
        }
        if (i == this.end && i2 == zzch.end) {
            return 0;
        }
        return i == this.end ? -1 : 1;
    }
}
