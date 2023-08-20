package com.google.android.gms.internal.firebase_database;

import com.google.android.gms.internal.firebase_database.zziv;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public abstract class zziv<T extends zziv> implements zzja {
    protected final zzja zzre;
    private String zzrf;

    zziv(zzja zzja) {
        this.zzre = zzja;
    }

    private static int zza(zziy zziy, zziq zziq) {
        return Double.valueOf((double) ((Long) zziy.getValue()).longValue()).compareTo((Double) zziq.getValue());
    }

    public /* synthetic */ int compareTo(Object obj) {
        zzja zzja = (zzja) obj;
        if (zzja.isEmpty()) {
            return 1;
        }
        if (zzja instanceof zzif) {
            return -1;
        }
        if ((this instanceof zziy) && (zzja instanceof zziq)) {
            return zza((zziy) this, (zziq) zzja);
        }
        if ((this instanceof zziq) && (zzja instanceof zziy)) {
            return zza((zziy) zzja, (zziq) this) * -1;
        }
        zziv zziv = (zziv) zzja;
        zzix zzfb = zzfb();
        zzix zzfb2 = zziv.zzfb();
        return zzfb.equals(zzfb2) ? zza(zziv) : zzfb.compareTo(zzfb2);
    }

    public final int getChildCount() {
        return 0;
    }

    public final Object getValue(boolean z) {
        if (!z || this.zzre.isEmpty()) {
            return getValue();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(".value", getValue());
        hashMap.put(".priority", this.zzre.getValue());
        return hashMap;
    }

    public final boolean isEmpty() {
        return false;
    }

    public Iterator<zziz> iterator() {
        return Collections.emptyList().iterator();
    }

    public final Iterator<zziz> reverseIterator() {
        return Collections.emptyList().iterator();
    }

    public String toString() {
        String obj = getValue(true).toString();
        return obj.length() <= 100 ? obj : String.valueOf(obj.substring(0, 100)).concat("...");
    }

    /* access modifiers changed from: protected */
    public abstract int zza(T t);

    public final zzja zzam(zzch zzch) {
        return zzch.isEmpty() ? this : zzch.zzbw().zzfh() ? this.zzre : zzir.zzfv();
    }

    /* access modifiers changed from: protected */
    public final String zzb(zzjc zzjc) {
        switch (zziw.zzsb[zzjc.ordinal()]) {
            case 1:
            case 2:
                if (this.zzre.isEmpty()) {
                    return "";
                }
                String zza = this.zzre.zza(zzjc);
                return new StringBuilder(String.valueOf(zza).length() + 10).append("priority:").append(zza).append(":").toString();
            default:
                String valueOf = String.valueOf(zzjc);
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 22).append("Unknown hash version: ").append(valueOf).toString());
        }
    }

    public final zzja zze(zzid zzid, zzja zzja) {
        return zzid.zzfh() ? zzf(zzja) : !zzja.isEmpty() ? zzir.zzfv().zze(zzid, zzja).zzf(this.zzre) : this;
    }

    /* access modifiers changed from: protected */
    public abstract zzix zzfb();

    public final String zzfj() {
        if (this.zzrf == null) {
            this.zzrf = zzkq.zzy(zza(zzjc.V1));
        }
        return this.zzrf;
    }

    public final boolean zzfk() {
        return true;
    }

    public final zzja zzfl() {
        return this.zzre;
    }

    public final boolean zzk(zzid zzid) {
        return false;
    }

    public final zzid zzl(zzid zzid) {
        return null;
    }

    public final zzja zzl(zzch zzch, zzja zzja) {
        zzid zzbw = zzch.zzbw();
        return zzbw == null ? zzja : (!zzja.isEmpty() || zzbw.zzfh()) ? zze(zzbw, zzir.zzfv().zzl(zzch.zzbx(), zzja)) : this;
    }

    public final zzja zzm(zzid zzid) {
        return zzid.zzfh() ? this.zzre : zzir.zzfv();
    }
}
