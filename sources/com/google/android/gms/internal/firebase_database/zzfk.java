package com.google.android.gms.internal.firebase_database;

public final class zzfk extends zzfl {
    private final zzbv zzmm;

    public zzfk(zzfn zzfn, zzch zzch, zzbv zzbv) {
        super(zzfm.Merge, zzfn, zzch);
        this.zzmm = zzbv;
    }

    public final String toString() {
        return String.format("Merge { path=%s, source=%s, children=%s }", new Object[]{this.zzap, this.zzmo, this.zzmm});
    }

    public final zzfl zzc(zzid zzid) {
        if (this.zzap.isEmpty()) {
            zzbv zzg = this.zzmm.zzg(new zzch(zzid));
            if (zzg.isEmpty()) {
                return null;
            }
            return zzg.zzbg() != null ? new zzfp(this.zzmo, zzch.zzbt(), zzg.zzbg()) : new zzfk(this.zzmo, zzch.zzbt(), zzg);
        } else if (this.zzap.zzbw().equals(zzid)) {
            return new zzfk(this.zzmo, this.zzap.zzbx(), this.zzmm);
        } else {
            return null;
        }
    }

    public final zzbv zzcx() {
        return this.zzmm;
    }
}
