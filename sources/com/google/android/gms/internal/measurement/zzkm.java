package com.google.android.gms.internal.measurement;

import android.support.p000v4.view.MotionEventCompat;
import java.io.IOException;

public final class zzkm extends zzaby<zzkm> {
    private static volatile zzkm[] zzasv;
    public Integer zzarl = null;
    public zzkr zzasw = null;
    public zzkr zzasx = null;
    public Boolean zzasy = null;

    public zzkm() {
        this.zzbww = null;
        this.zzbxh = -1;
    }

    public static zzkm[] zzlk() {
        if (zzasv == null) {
            synchronized (zzacc.zzbxg) {
                if (zzasv == null) {
                    zzasv = new zzkm[0];
                }
            }
        }
        return zzasv;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkm)) {
            return false;
        }
        zzkm zzkm = (zzkm) obj;
        if (this.zzarl == null) {
            if (zzkm.zzarl != null) {
                return false;
            }
        } else if (!this.zzarl.equals(zzkm.zzarl)) {
            return false;
        }
        if (this.zzasw == null) {
            if (zzkm.zzasw != null) {
                return false;
            }
        } else if (!this.zzasw.equals(zzkm.zzasw)) {
            return false;
        }
        if (this.zzasx == null) {
            if (zzkm.zzasx != null) {
                return false;
            }
        } else if (!this.zzasx.equals(zzkm.zzasx)) {
            return false;
        }
        if (this.zzasy == null) {
            if (zzkm.zzasy != null) {
                return false;
            }
        } else if (!this.zzasy.equals(zzkm.zzasy)) {
            return false;
        }
        return (this.zzbww == null || this.zzbww.isEmpty()) ? zzkm.zzbww == null || zzkm.zzbww.isEmpty() : this.zzbww.equals(zzkm.zzbww);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (this.zzarl == null ? 0 : this.zzarl.hashCode()) + ((getClass().getName().hashCode() + 527) * 31);
        zzkr zzkr = this.zzasw;
        int i2 = hashCode * 31;
        int hashCode2 = zzkr == null ? 0 : zzkr.hashCode();
        zzkr zzkr2 = this.zzasx;
        int hashCode3 = ((this.zzasy == null ? 0 : this.zzasy.hashCode()) + (((zzkr2 == null ? 0 : zzkr2.hashCode()) + ((hashCode2 + i2) * 31)) * 31)) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i = this.zzbww.hashCode();
        }
        return hashCode3 + i;
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int zza = super.zza();
        if (this.zzarl != null) {
            zza += zzabw.zzf(1, this.zzarl.intValue());
        }
        if (this.zzasw != null) {
            zza += zzabw.zzb(2, (zzace) this.zzasw);
        }
        if (this.zzasx != null) {
            zza += zzabw.zzb(3, (zzace) this.zzasx);
        }
        if (this.zzasy == null) {
            return zza;
        }
        this.zzasy.booleanValue();
        return zza + zzabw.zzaq(4) + 1;
    }

    public final void zza(zzabw zzabw) throws IOException {
        if (this.zzarl != null) {
            zzabw.zze(1, this.zzarl.intValue());
        }
        if (this.zzasw != null) {
            zzabw.zza(2, (zzace) this.zzasw);
        }
        if (this.zzasx != null) {
            zzabw.zza(3, (zzace) this.zzasx);
        }
        if (this.zzasy != null) {
            zzabw.zza(4, this.zzasy.booleanValue());
        }
        super.zza(zzabw);
    }

    public final /* synthetic */ zzace zzb(zzabv zzabv) throws IOException {
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    break;
                case 8:
                    this.zzarl = Integer.valueOf(zzabv.zzuy());
                    continue;
                case 18:
                    if (this.zzasw == null) {
                        this.zzasw = new zzkr();
                    }
                    zzabv.zza(this.zzasw);
                    continue;
                case MotionEventCompat.AXIS_SCROLL:
                    if (this.zzasx == null) {
                        this.zzasx = new zzkr();
                    }
                    zzabv.zza(this.zzasx);
                    continue;
                case 32:
                    this.zzasy = Boolean.valueOf(zzabv.zzux());
                    continue;
                default:
                    if (!super.zza(zzabv, zzuw)) {
                        break;
                    } else {
                        continue;
                    }
            }
        }
        return this;
    }
}
