package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzgp;
import java.io.IOException;

public abstract class zzgp<M extends zzgp<M>> extends zzgv {
    protected zzgr zzyn;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzgp zzgp = (zzgp) super.clone();
        zzgt.zza(this, zzgp);
        return zzgp;
    }

    public void zza(zzgn zzgn) throws IOException {
        if (this.zzyn != null) {
            for (int i = 0; i < this.zzyn.size(); i++) {
                this.zzyn.zzbc(i).zza(zzgn);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzgm zzgm, int i) throws IOException {
        int position = zzgm.getPosition();
        if (!zzgm.zzm(i)) {
            return false;
        }
        int i2 = i >>> 3;
        zzgx zzgx = new zzgx(i, zzgm.zzr(position, zzgm.getPosition() - position));
        zzgs zzgs = null;
        if (this.zzyn == null) {
            this.zzyn = new zzgr();
        } else {
            zzgs = this.zzyn.zzbb(i2);
        }
        if (zzgs == null) {
            zzgs = new zzgs();
            this.zzyn.zza(i2, zzgs);
        }
        zzgs.zza(zzgx);
        return true;
    }

    /* access modifiers changed from: protected */
    public int zzb() {
        if (this.zzyn == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.zzyn.size(); i2++) {
            i += this.zzyn.zzbc(i2).zzb();
        }
        return i;
    }

    public final /* synthetic */ zzgv zzhf() throws CloneNotSupportedException {
        return (zzgp) clone();
    }
}
