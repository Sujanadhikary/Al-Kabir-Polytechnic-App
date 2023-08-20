package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;

public final class zzf extends zzgp<zzf> {
    private static volatile zzf[] zze;
    private String value = "";
    private String zzf = "";

    public zzf() {
        this.zzyw = -1;
    }

    public static zzf[] zza() {
        if (zze == null) {
            synchronized (zzgt.zzyv) {
                if (zze == null) {
                    zze = new zzf[0];
                }
            }
        }
        return zze;
    }

    public final /* synthetic */ zzgv zza(zzgm zzgm) throws IOException {
        while (true) {
            int zzbz = zzgm.zzbz();
            switch (zzbz) {
                case 0:
                    break;
                case 10:
                    this.zzf = zzgm.readString();
                    continue;
                case 18:
                    this.value = zzgm.readString();
                    continue;
                default:
                    if (!super.zza(zzgm, zzbz)) {
                        break;
                    } else {
                        continue;
                    }
            }
        }
        return this;
    }

    public final void zza(zzgn zzgn) throws IOException {
        if (this.zzf != null && !this.zzf.equals("")) {
            zzgn.zza(1, this.zzf);
        }
        if (this.value != null && !this.value.equals("")) {
            zzgn.zza(2, this.value);
        }
        super.zza(zzgn);
    }

    /* access modifiers changed from: protected */
    public final int zzb() {
        int zzb = super.zzb();
        if (this.zzf != null && !this.zzf.equals("")) {
            zzb += zzgn.zzb(1, this.zzf);
        }
        return (this.value == null || this.value.equals("")) ? zzb : zzb + zzgn.zzb(2, this.value);
    }
}
