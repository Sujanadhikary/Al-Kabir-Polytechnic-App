package com.google.android.gms.internal.firebase_database;

public final class zzje extends zzis {
    private final zzch zzsn;

    public zzje(zzch zzch) {
        if (zzch.size() != 1 || !zzch.zzbw().zzfh()) {
            this.zzsn = zzch;
            return;
        }
        throw new IllegalArgumentException("Can't create PathIndex with '.priority' as key. Please use PriorityIndex instead!");
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zziz zziz = (zziz) obj;
        zziz zziz2 = (zziz) obj2;
        int compareTo = zziz.zzd().zzam(this.zzsn).compareTo(zziz2.zzd().zzam(this.zzsn));
        return compareTo == 0 ? zziz.zzge().compareTo(zziz2.zzge()) : compareTo;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.zzsn.equals(((zzje) obj).zzsn);
    }

    public final int hashCode() {
        return this.zzsn.hashCode();
    }

    public final zziz zzf(zzid zzid, zzja zzja) {
        return new zziz(zzid, zzir.zzfv().zzl(this.zzsn, zzja));
    }

    public final zziz zzfw() {
        return new zziz(zzid.zzfd(), zzir.zzfv().zzl(this.zzsn, zzja.zzsj));
    }

    public final String zzfx() {
        return this.zzsn.zzbu();
    }

    public final boolean zzi(zzja zzja) {
        return !zzja.zzam(this.zzsn).isEmpty();
    }
}
