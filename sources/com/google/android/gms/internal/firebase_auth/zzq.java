package com.google.android.gms.internal.firebase_auth;

import android.support.p000v4.view.MotionEventCompat;
import java.io.IOException;

public final class zzq extends zzgp<zzq> {
    private long zzac = 0;
    public String zzad = "";
    private String zzbo = "";
    public boolean zzbr = false;
    public String zzby = "";
    public String zzbz = "";
    private String zzca = "";
    private boolean zzcb = false;
    private boolean zzcc = false;
    public boolean zzcd = true;
    public String zzr = "";

    public zzq() {
        this.zzyw = -1;
    }

    public final /* synthetic */ zzgv zza(zzgm zzgm) throws IOException {
        while (true) {
            int zzbz2 = zzgm.zzbz();
            switch (zzbz2) {
                case 0:
                    break;
                case 10:
                    this.zzby = zzgm.readString();
                    continue;
                case 18:
                    this.zzbz = zzgm.readString();
                    continue;
                case MotionEventCompat.AXIS_SCROLL:
                    this.zzca = zzgm.readString();
                    continue;
                case 32:
                    this.zzcb = zzgm.zzcf();
                    continue;
                case MotionEventCompat.AXIS_GENERIC_11:
                    this.zzr = zzgm.readString();
                    continue;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH:
                    this.zzbo = zzgm.readString();
                    continue;
                case 56:
                    this.zzac = zzgm.zzcs();
                    continue;
                case 66:
                    this.zzad = zzgm.readString();
                    continue;
                case 72:
                    this.zzbr = zzgm.zzcf();
                    continue;
                case 80:
                    this.zzcc = zzgm.zzcf();
                    continue;
                case 88:
                    this.zzcd = zzgm.zzcf();
                    continue;
                default:
                    if (!super.zza(zzgm, zzbz2)) {
                        break;
                    } else {
                        continue;
                    }
            }
        }
        return this;
    }

    public final void zza(zzgn zzgn) throws IOException {
        if (this.zzby != null && !this.zzby.equals("")) {
            zzgn.zza(1, this.zzby);
        }
        if (this.zzbz != null && !this.zzbz.equals("")) {
            zzgn.zza(2, this.zzbz);
        }
        if (this.zzca != null && !this.zzca.equals("")) {
            zzgn.zza(3, this.zzca);
        }
        if (this.zzcb) {
            zzgn.zzb(4, this.zzcb);
        }
        if (this.zzr != null && !this.zzr.equals("")) {
            zzgn.zza(5, this.zzr);
        }
        if (this.zzbo != null && !this.zzbo.equals("")) {
            zzgn.zza(6, this.zzbo);
        }
        if (this.zzac != 0) {
            zzgn.zzi(7, this.zzac);
        }
        if (this.zzad != null && !this.zzad.equals("")) {
            zzgn.zza(8, this.zzad);
        }
        if (this.zzbr) {
            zzgn.zzb(9, this.zzbr);
        }
        if (this.zzcc) {
            zzgn.zzb(10, this.zzcc);
        }
        if (!this.zzcd) {
            zzgn.zzb(11, this.zzcd);
        }
        super.zza(zzgn);
    }

    /* access modifiers changed from: protected */
    public final int zzb() {
        int zzb = super.zzb();
        if (this.zzby != null && !this.zzby.equals("")) {
            zzb += zzgn.zzb(1, this.zzby);
        }
        if (this.zzbz != null && !this.zzbz.equals("")) {
            zzb += zzgn.zzb(2, this.zzbz);
        }
        if (this.zzca != null && !this.zzca.equals("")) {
            zzb += zzgn.zzb(3, this.zzca);
        }
        if (this.zzcb) {
            zzb += zzgn.zzz(4) + 1;
        }
        if (this.zzr != null && !this.zzr.equals("")) {
            zzb += zzgn.zzb(5, this.zzr);
        }
        if (this.zzbo != null && !this.zzbo.equals("")) {
            zzb += zzgn.zzb(6, this.zzbo);
        }
        if (this.zzac != 0) {
            zzb += zzgn.zzd(7, this.zzac);
        }
        if (this.zzad != null && !this.zzad.equals("")) {
            zzb += zzgn.zzb(8, this.zzad);
        }
        if (this.zzbr) {
            zzb += zzgn.zzz(9) + 1;
        }
        if (this.zzcc) {
            zzb += zzgn.zzz(10) + 1;
        }
        return !this.zzcd ? zzb + zzgn.zzz(11) + 1 : zzb;
    }
}
