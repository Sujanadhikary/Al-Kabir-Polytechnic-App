package com.google.android.gms.internal.measurement;

import android.support.p000v4.view.MotionEventCompat;
import java.io.IOException;

public final class zzkn extends zzaby<zzkn> {
    private static volatile zzkn[] zzasz;
    public Integer count = null;
    public String name = null;
    public zzko[] zzata = zzko.zzlm();
    public Long zzatb = null;
    public Long zzatc = null;

    public zzkn() {
        this.zzbww = null;
        this.zzbxh = -1;
    }

    public static zzkn[] zzll() {
        if (zzasz == null) {
            synchronized (zzacc.zzbxg) {
                if (zzasz == null) {
                    zzasz = new zzkn[0];
                }
            }
        }
        return zzasz;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkn)) {
            return false;
        }
        zzkn zzkn = (zzkn) obj;
        if (!zzacc.equals((Object[]) this.zzata, (Object[]) zzkn.zzata)) {
            return false;
        }
        if (this.name == null) {
            if (zzkn.name != null) {
                return false;
            }
        } else if (!this.name.equals(zzkn.name)) {
            return false;
        }
        if (this.zzatb == null) {
            if (zzkn.zzatb != null) {
                return false;
            }
        } else if (!this.zzatb.equals(zzkn.zzatb)) {
            return false;
        }
        if (this.zzatc == null) {
            if (zzkn.zzatc != null) {
                return false;
            }
        } else if (!this.zzatc.equals(zzkn.zzatc)) {
            return false;
        }
        if (this.count == null) {
            if (zzkn.count != null) {
                return false;
            }
        } else if (!this.count.equals(zzkn.count)) {
            return false;
        }
        return (this.zzbww == null || this.zzbww.isEmpty()) ? zzkn.zzbww == null || zzkn.zzbww.isEmpty() : this.zzbww.equals(zzkn.zzbww);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.count == null ? 0 : this.count.hashCode()) + (((this.zzatc == null ? 0 : this.zzatc.hashCode()) + (((this.zzatb == null ? 0 : this.zzatb.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzacc.hashCode((Object[]) this.zzata)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i = this.zzbww.hashCode();
        }
        return hashCode + i;
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int zza = super.zza();
        if (this.zzata != null && this.zzata.length > 0) {
            for (zzko zzko : this.zzata) {
                if (zzko != null) {
                    zza += zzabw.zzb(1, (zzace) zzko);
                }
            }
        }
        if (this.name != null) {
            zza += zzabw.zzc(2, this.name);
        }
        if (this.zzatb != null) {
            zza += zzabw.zzc(3, this.zzatb.longValue());
        }
        if (this.zzatc != null) {
            zza += zzabw.zzc(4, this.zzatc.longValue());
        }
        return this.count != null ? zza + zzabw.zzf(5, this.count.intValue()) : zza;
    }

    public final void zza(zzabw zzabw) throws IOException {
        if (this.zzata != null && this.zzata.length > 0) {
            for (zzko zzko : this.zzata) {
                if (zzko != null) {
                    zzabw.zza(1, (zzace) zzko);
                }
            }
        }
        if (this.name != null) {
            zzabw.zzb(2, this.name);
        }
        if (this.zzatb != null) {
            zzabw.zzb(3, this.zzatb.longValue());
        }
        if (this.zzatc != null) {
            zzabw.zzb(4, this.zzatc.longValue());
        }
        if (this.count != null) {
            zzabw.zze(5, this.count.intValue());
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
                    int zzb = zzach.zzb(zzabv, 10);
                    int length = this.zzata == null ? 0 : this.zzata.length;
                    zzko[] zzkoArr = new zzko[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzata, 0, zzkoArr, 0, length);
                    }
                    while (length < zzkoArr.length - 1) {
                        zzkoArr[length] = new zzko();
                        zzabv.zza(zzkoArr[length]);
                        zzabv.zzuw();
                        length++;
                    }
                    zzkoArr[length] = new zzko();
                    zzabv.zza(zzkoArr[length]);
                    this.zzata = zzkoArr;
                    continue;
                case 18:
                    this.name = zzabv.readString();
                    continue;
                case MotionEventCompat.AXIS_DISTANCE:
                    this.zzatb = Long.valueOf(zzabv.zzuz());
                    continue;
                case 32:
                    this.zzatc = Long.valueOf(zzabv.zzuz());
                    continue;
                case MotionEventCompat.AXIS_GENERIC_9:
                    this.count = Integer.valueOf(zzabv.zzuy());
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
