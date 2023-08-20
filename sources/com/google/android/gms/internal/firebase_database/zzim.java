package com.google.android.gms.internal.firebase_database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

final class zzim {
    private StringBuilder zzrl = null;
    private Stack<zzid> zzrm = new Stack<>();
    private int zzrn = -1;
    private int zzro;
    private boolean zzrp = true;
    /* access modifiers changed from: private */
    public final List<zzch> zzrq = new ArrayList();
    /* access modifiers changed from: private */
    public final List<String> zzrr = new ArrayList();
    private final zzio zzrs;

    public zzim(zzio zzio) {
        this.zzrs = zzio;
    }

    private static void zza(StringBuilder sb, zzid zzid) {
        sb.append(zzkq.zzz(zzid.zzfg()));
    }

    /* access modifiers changed from: private */
    public final void zzb(zziv<?> zziv) {
        zzfr();
        this.zzrn = this.zzro;
        this.zzrl.append(zziv.zza(zzjc.V2));
        this.zzrp = true;
        if (this.zzrs.zze(this)) {
            zzfu();
        }
    }

    private final zzch zze(int i) {
        zzid[] zzidArr = new zzid[i];
        for (int i2 = 0; i2 < i; i2++) {
            zzidArr[i2] = (zzid) this.zzrm.get(i2);
        }
        return new zzch(zzidArr);
    }

    private final boolean zzfo() {
        return this.zzrl != null;
    }

    private final void zzfr() {
        if (!zzfo()) {
            this.zzrl = new StringBuilder();
            this.zzrl.append("(");
            Iterator<zzid> it = zze(this.zzro).iterator();
            while (it.hasNext()) {
                zza(this.zzrl, it.next());
                this.zzrl.append(":(");
            }
            this.zzrp = false;
        }
    }

    /* access modifiers changed from: private */
    public final void zzfs() {
        this.zzro--;
        if (zzfo()) {
            this.zzrl.append(")");
        }
        this.zzrp = true;
    }

    /* access modifiers changed from: private */
    public final void zzft() {
        zzkq.zza(this.zzro == 0, "Can't finish hashing in the middle processing a child");
        if (zzfo()) {
            zzfu();
        }
        this.zzrr.add("");
    }

    private final void zzfu() {
        zzkq.zza(zzfo(), "Can't end range without starting a range!");
        for (int i = 0; i < this.zzro; i++) {
            this.zzrl.append(")");
        }
        this.zzrl.append(")");
        zzch zze = zze(this.zzrn);
        this.zzrr.add(zzkq.zzy(this.zzrl.toString()));
        this.zzrq.add(zze);
        this.zzrl = null;
    }

    /* access modifiers changed from: private */
    public final void zzn(zzid zzid) {
        zzfr();
        if (this.zzrp) {
            this.zzrl.append(",");
        }
        zza(this.zzrl, zzid);
        this.zzrl.append(":(");
        if (this.zzro == this.zzrm.size()) {
            this.zzrm.add(zzid);
        } else {
            this.zzrm.set(this.zzro, zzid);
        }
        this.zzro++;
        this.zzrp = false;
    }

    public final int zzfp() {
        return this.zzrl.length();
    }

    public final zzch zzfq() {
        return zze(this.zzro);
    }
}
