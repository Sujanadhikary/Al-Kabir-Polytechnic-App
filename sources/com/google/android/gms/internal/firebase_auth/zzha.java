package com.google.android.gms.internal.firebase_auth;

import android.support.p000v4.view.MotionEventCompat;
import java.io.IOException;

public final class zzha {

    public static final class zza extends zzgp<zza> {
        private String zzad = "";
        public String zzag = "";
        public long zzah = 0;
        public String zzdt = "";
        public String zzjt = "";
        private String zzkq = "";
        private long zzzj = 0;

        public zza() {
            this.zzyw = -1;
        }

        public final /* synthetic */ zzgv zza(zzgm zzgm) throws IOException {
            while (true) {
                int zzbz = zzgm.zzbz();
                switch (zzbz) {
                    case 0:
                        break;
                    case 10:
                        this.zzdt = zzgm.readString();
                        continue;
                    case 16:
                        this.zzah = zzgm.zzcb();
                        continue;
                    case MotionEventCompat.AXIS_SCROLL:
                        this.zzjt = zzgm.readString();
                        continue;
                    case MotionEventCompat.AXIS_GENERIC_3:
                        this.zzag = zzgm.readString();
                        continue;
                    case MotionEventCompat.AXIS_GENERIC_11:
                        this.zzad = zzgm.readString();
                        continue;
                    case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH:
                        this.zzkq = zzgm.readString();
                        continue;
                    case 56:
                        this.zzzj = zzgm.zzcb();
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
            if (this.zzdt != null && !this.zzdt.equals("")) {
                zzgn.zza(1, this.zzdt);
            }
            if (this.zzah != 0) {
                zzgn.zzi(2, this.zzah);
            }
            if (this.zzjt != null && !this.zzjt.equals("")) {
                zzgn.zza(3, this.zzjt);
            }
            if (this.zzag != null && !this.zzag.equals("")) {
                zzgn.zza(4, this.zzag);
            }
            if (this.zzad != null && !this.zzad.equals("")) {
                zzgn.zza(5, this.zzad);
            }
            if (this.zzkq != null && !this.zzkq.equals("")) {
                zzgn.zza(6, this.zzkq);
            }
            if (this.zzzj != 0) {
                zzgn.zzi(7, this.zzzj);
            }
            super.zza(zzgn);
        }

        /* access modifiers changed from: protected */
        public final int zzb() {
            int zzb = super.zzb();
            if (this.zzdt != null && !this.zzdt.equals("")) {
                zzb += zzgn.zzb(1, this.zzdt);
            }
            if (this.zzah != 0) {
                zzb += zzgn.zzd(2, this.zzah);
            }
            if (this.zzjt != null && !this.zzjt.equals("")) {
                zzb += zzgn.zzb(3, this.zzjt);
            }
            if (this.zzag != null && !this.zzag.equals("")) {
                zzb += zzgn.zzb(4, this.zzag);
            }
            if (this.zzad != null && !this.zzad.equals("")) {
                zzb += zzgn.zzb(5, this.zzad);
            }
            if (this.zzkq != null && !this.zzkq.equals("")) {
                zzb += zzgn.zzb(6, this.zzkq);
            }
            return this.zzzj != 0 ? zzb + zzgn.zzd(7, this.zzzj) : zzb;
        }
    }
}
