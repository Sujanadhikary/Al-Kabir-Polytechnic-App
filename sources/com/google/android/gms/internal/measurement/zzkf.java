package com.google.android.gms.internal.measurement;

import android.support.p000v4.view.MotionEventCompat;
import java.io.IOException;

public final class zzkf extends zzaby<zzkf> {
    private static volatile zzkf[] zzaru;
    public zzki zzarv = null;
    public zzkg zzarw = null;
    public Boolean zzarx = null;
    public String zzary = null;

    public zzkf() {
        this.zzbww = null;
        this.zzbxh = -1;
    }

    public static zzkf[] zzlg() {
        if (zzaru == null) {
            synchronized (zzacc.zzbxg) {
                if (zzaru == null) {
                    zzaru = new zzkf[0];
                }
            }
        }
        return zzaru;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkf)) {
            return false;
        }
        zzkf zzkf = (zzkf) obj;
        if (this.zzarv == null) {
            if (zzkf.zzarv != null) {
                return false;
            }
        } else if (!this.zzarv.equals(zzkf.zzarv)) {
            return false;
        }
        if (this.zzarw == null) {
            if (zzkf.zzarw != null) {
                return false;
            }
        } else if (!this.zzarw.equals(zzkf.zzarw)) {
            return false;
        }
        if (this.zzarx == null) {
            if (zzkf.zzarx != null) {
                return false;
            }
        } else if (!this.zzarx.equals(zzkf.zzarx)) {
            return false;
        }
        if (this.zzary == null) {
            if (zzkf.zzary != null) {
                return false;
            }
        } else if (!this.zzary.equals(zzkf.zzary)) {
            return false;
        }
        return (this.zzbww == null || this.zzbww.isEmpty()) ? zzkf.zzbww == null || zzkf.zzbww.isEmpty() : this.zzbww.equals(zzkf.zzbww);
    }

    public final int hashCode() {
        int i = 0;
        zzki zzki = this.zzarv;
        int hashCode = (getClass().getName().hashCode() + 527) * 31;
        int hashCode2 = zzki == null ? 0 : zzki.hashCode();
        zzkg zzkg = this.zzarw;
        int hashCode3 = ((this.zzary == null ? 0 : this.zzary.hashCode()) + (((this.zzarx == null ? 0 : this.zzarx.hashCode()) + (((zzkg == null ? 0 : zzkg.hashCode()) + ((hashCode2 + hashCode) * 31)) * 31)) * 31)) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i = this.zzbww.hashCode();
        }
        return hashCode3 + i;
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int zza = super.zza();
        if (this.zzarv != null) {
            zza += zzabw.zzb(1, (zzace) this.zzarv);
        }
        if (this.zzarw != null) {
            zza += zzabw.zzb(2, (zzace) this.zzarw);
        }
        if (this.zzarx != null) {
            this.zzarx.booleanValue();
            zza += zzabw.zzaq(3) + 1;
        }
        return this.zzary != null ? zza + zzabw.zzc(4, this.zzary) : zza;
    }

    public final void zza(zzabw zzabw) throws IOException {
        if (this.zzarv != null) {
            zzabw.zza(1, (zzace) this.zzarv);
        }
        if (this.zzarw != null) {
            zzabw.zza(2, (zzace) this.zzarw);
        }
        if (this.zzarx != null) {
            zzabw.zza(3, this.zzarx.booleanValue());
        }
        if (this.zzary != null) {
            zzabw.zzb(4, this.zzary);
        }
        super.zza(zzabw);
    }

    public final /* synthetic */ zzace zzb(zzabv zzabv) throws IOException {
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    break;
                case 10:
                    if (this.zzarv == null) {
                        this.zzarv = new zzki();
                    }
                    zzabv.zza(this.zzarv);
                    continue;
                case 18:
                    if (this.zzarw == null) {
                        this.zzarw = new zzkg();
                    }
                    zzabv.zza(this.zzarw);
                    continue;
                case MotionEventCompat.AXIS_DISTANCE:
                    this.zzarx = Boolean.valueOf(zzabv.zzux());
                    continue;
                case MotionEventCompat.AXIS_GENERIC_3:
                    this.zzary = zzabv.readString();
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
