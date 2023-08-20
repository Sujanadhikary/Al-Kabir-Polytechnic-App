package com.google.android.gms.internal.firebase_auth;

import android.support.p000v4.view.MotionEventCompat;
import java.io.IOException;

public final class zzl extends zzgp<zzl> {
    public String zzad = "";
    public String zzaf = "";
    public int zzam = 0;
    private String zzan = "";
    private String zzao = "";
    private String zzap = "";
    private String zzaq = "";
    public String zzar = "";
    public String zzas = "";
    public String zzat = "";
    public String zzau = "";
    public boolean zzav = false;
    public String zzaw = "";
    public boolean zzax = false;

    public zzl() {
        this.zzyw = -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzb */
    public final zzl zza(zzgm zzgm) throws IOException {
        while (true) {
            int zzbz = zzgm.zzbz();
            switch (zzbz) {
                case 0:
                    break;
                case 8:
                    int position = zzgm.getPosition();
                    try {
                        this.zzam = zzgz.zzbe(zzgm.zzcr());
                        continue;
                    } catch (IllegalArgumentException e) {
                        zzgm.zzay(position);
                        zza(zzgm, zzbz);
                        break;
                    }
                case 18:
                    this.zzaf = zzgm.readString();
                    continue;
                case MotionEventCompat.AXIS_SCROLL:
                    this.zzan = zzgm.readString();
                    continue;
                case MotionEventCompat.AXIS_GENERIC_3:
                    this.zzao = zzgm.readString();
                    continue;
                case MotionEventCompat.AXIS_GENERIC_11:
                    this.zzap = zzgm.readString();
                    continue;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH:
                    this.zzaq = zzgm.readString();
                    continue;
                case 58:
                    this.zzad = zzgm.readString();
                    continue;
                case 66:
                    this.zzar = zzgm.readString();
                    continue;
                case 74:
                    this.zzas = zzgm.readString();
                    continue;
                case 82:
                    this.zzat = zzgm.readString();
                    continue;
                case 90:
                    this.zzau = zzgm.readString();
                    continue;
                case 96:
                    this.zzav = zzgm.zzcf();
                    continue;
                case 106:
                    this.zzaw = zzgm.readString();
                    continue;
                case 112:
                    this.zzax = zzgm.zzcf();
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
        if (this.zzam != 0) {
            zzgn.zzc(1, this.zzam);
        }
        if (this.zzaf != null && !this.zzaf.equals("")) {
            zzgn.zza(2, this.zzaf);
        }
        if (this.zzan != null && !this.zzan.equals("")) {
            zzgn.zza(3, this.zzan);
        }
        if (this.zzao != null && !this.zzao.equals("")) {
            zzgn.zza(4, this.zzao);
        }
        if (this.zzap != null && !this.zzap.equals("")) {
            zzgn.zza(5, this.zzap);
        }
        if (this.zzaq != null && !this.zzaq.equals("")) {
            zzgn.zza(6, this.zzaq);
        }
        if (this.zzad != null && !this.zzad.equals("")) {
            zzgn.zza(7, this.zzad);
        }
        if (this.zzar != null && !this.zzar.equals("")) {
            zzgn.zza(8, this.zzar);
        }
        if (this.zzas != null && !this.zzas.equals("")) {
            zzgn.zza(9, this.zzas);
        }
        if (this.zzat != null && !this.zzat.equals("")) {
            zzgn.zza(10, this.zzat);
        }
        if (this.zzau != null && !this.zzau.equals("")) {
            zzgn.zza(11, this.zzau);
        }
        if (this.zzav) {
            zzgn.zzb(12, this.zzav);
        }
        if (this.zzaw != null && !this.zzaw.equals("")) {
            zzgn.zza(13, this.zzaw);
        }
        if (this.zzax) {
            zzgn.zzb(14, this.zzax);
        }
        super.zza(zzgn);
    }

    /* access modifiers changed from: protected */
    public final int zzb() {
        int zzb = super.zzb();
        if (this.zzam != 0) {
            zzb += zzgn.zzg(1, this.zzam);
        }
        if (this.zzaf != null && !this.zzaf.equals("")) {
            zzb += zzgn.zzb(2, this.zzaf);
        }
        if (this.zzan != null && !this.zzan.equals("")) {
            zzb += zzgn.zzb(3, this.zzan);
        }
        if (this.zzao != null && !this.zzao.equals("")) {
            zzb += zzgn.zzb(4, this.zzao);
        }
        if (this.zzap != null && !this.zzap.equals("")) {
            zzb += zzgn.zzb(5, this.zzap);
        }
        if (this.zzaq != null && !this.zzaq.equals("")) {
            zzb += zzgn.zzb(6, this.zzaq);
        }
        if (this.zzad != null && !this.zzad.equals("")) {
            zzb += zzgn.zzb(7, this.zzad);
        }
        if (this.zzar != null && !this.zzar.equals("")) {
            zzb += zzgn.zzb(8, this.zzar);
        }
        if (this.zzas != null && !this.zzas.equals("")) {
            zzb += zzgn.zzb(9, this.zzas);
        }
        if (this.zzat != null && !this.zzat.equals("")) {
            zzb += zzgn.zzb(10, this.zzat);
        }
        if (this.zzau != null && !this.zzau.equals("")) {
            zzb += zzgn.zzb(11, this.zzau);
        }
        if (this.zzav) {
            zzb += zzgn.zzz(12) + 1;
        }
        if (this.zzaw != null && !this.zzaw.equals("")) {
            zzb += zzgn.zzb(13, this.zzaw);
        }
        return this.zzax ? zzb + zzgn.zzz(14) + 1 : zzb;
    }
}
