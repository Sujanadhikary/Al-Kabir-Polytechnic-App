package com.google.android.gms.internal.firebase_auth;

import android.support.p000v4.view.MotionEventCompat;
import java.io.IOException;

public final class zzs extends zzgp<zzs> {
    private long zzac = 0;
    private String zzad = "";
    public String zzaf = "";
    public String zzbg = "";
    private String zzbk = "";
    private String zzbl = "";
    private String zzbo = "";
    public boolean zzbr = false;
    private String zzca = "";
    private String zzdg = "";

    public zzs() {
        this.zzyw = -1;
    }

    public final /* synthetic */ zzgv zza(zzgm zzgm) throws IOException {
        while (true) {
            int zzbz = zzgm.zzbz();
            switch (zzbz) {
                case 0:
                    break;
                case 10:
                    this.zzaf = zzgm.readString();
                    continue;
                case 18:
                    this.zzbg = zzgm.readString();
                    continue;
                case MotionEventCompat.AXIS_SCROLL:
                    this.zzca = zzgm.readString();
                    continue;
                case MotionEventCompat.AXIS_GENERIC_3:
                    this.zzbk = zzgm.readString();
                    continue;
                case MotionEventCompat.AXIS_GENERIC_11:
                    this.zzbl = zzgm.readString();
                    continue;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH:
                    this.zzdg = zzgm.readString();
                    continue;
                case 58:
                    this.zzbo = zzgm.readString();
                    continue;
                case 64:
                    this.zzac = zzgm.zzcs();
                    continue;
                case 74:
                    this.zzad = zzgm.readString();
                    continue;
                case 80:
                    this.zzbr = zzgm.zzcf();
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
        if (this.zzaf != null && !this.zzaf.equals("")) {
            zzgn.zza(1, this.zzaf);
        }
        if (this.zzbg != null && !this.zzbg.equals("")) {
            zzgn.zza(2, this.zzbg);
        }
        if (this.zzca != null && !this.zzca.equals("")) {
            zzgn.zza(3, this.zzca);
        }
        if (this.zzbk != null && !this.zzbk.equals("")) {
            zzgn.zza(4, this.zzbk);
        }
        if (this.zzbl != null && !this.zzbl.equals("")) {
            zzgn.zza(5, this.zzbl);
        }
        if (this.zzdg != null && !this.zzdg.equals("")) {
            zzgn.zza(6, this.zzdg);
        }
        if (this.zzbo != null && !this.zzbo.equals("")) {
            zzgn.zza(7, this.zzbo);
        }
        if (this.zzac != 0) {
            zzgn.zzi(8, this.zzac);
        }
        if (this.zzad != null && !this.zzad.equals("")) {
            zzgn.zza(9, this.zzad);
        }
        if (this.zzbr) {
            zzgn.zzb(10, this.zzbr);
        }
        super.zza(zzgn);
    }

    /* access modifiers changed from: protected */
    public final int zzb() {
        int zzb = super.zzb();
        if (this.zzaf != null && !this.zzaf.equals("")) {
            zzb += zzgn.zzb(1, this.zzaf);
        }
        if (this.zzbg != null && !this.zzbg.equals("")) {
            zzb += zzgn.zzb(2, this.zzbg);
        }
        if (this.zzca != null && !this.zzca.equals("")) {
            zzb += zzgn.zzb(3, this.zzca);
        }
        if (this.zzbk != null && !this.zzbk.equals("")) {
            zzb += zzgn.zzb(4, this.zzbk);
        }
        if (this.zzbl != null && !this.zzbl.equals("")) {
            zzb += zzgn.zzb(5, this.zzbl);
        }
        if (this.zzdg != null && !this.zzdg.equals("")) {
            zzb += zzgn.zzb(6, this.zzdg);
        }
        if (this.zzbo != null && !this.zzbo.equals("")) {
            zzb += zzgn.zzb(7, this.zzbo);
        }
        if (this.zzac != 0) {
            zzb += zzgn.zzd(8, this.zzac);
        }
        if (this.zzad != null && !this.zzad.equals("")) {
            zzb += zzgn.zzb(9, this.zzad);
        }
        return this.zzbr ? zzb + zzgn.zzz(10) + 1 : zzb;
    }
}
