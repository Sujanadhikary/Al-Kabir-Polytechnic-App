package com.google.android.gms.internal.measurement;

import android.support.p000v4.view.MotionEventCompat;
import java.io.IOException;

public final class zzki extends zzaby<zzki> {
    public Integer zzash = null;
    public String zzasi = null;
    public Boolean zzasj = null;
    public String[] zzask = zzach.zzbxq;

    public zzki() {
        this.zzbww = null;
        this.zzbxh = -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: zze */
    public final zzki zzb(zzabv zzabv) throws IOException {
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    break;
                case 8:
                    int position = zzabv.getPosition();
                    try {
                        int zzuy = zzabv.zzuy();
                        if (zzuy < 0 || zzuy > 6) {
                            throw new IllegalArgumentException(new StringBuilder(41).append(zzuy).append(" is not a valid enum MatchType").toString());
                        }
                        this.zzash = Integer.valueOf(zzuy);
                        continue;
                    } catch (IllegalArgumentException e) {
                        zzabv.zzam(position);
                        zza(zzabv, zzuw);
                        break;
                    }
                case 18:
                    this.zzasi = zzabv.readString();
                    continue;
                case MotionEventCompat.AXIS_DISTANCE:
                    this.zzasj = Boolean.valueOf(zzabv.zzux());
                    continue;
                case MotionEventCompat.AXIS_GENERIC_3:
                    int zzb = zzach.zzb(zzabv, 34);
                    int length = this.zzask == null ? 0 : this.zzask.length;
                    String[] strArr = new String[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzask, 0, strArr, 0, length);
                    }
                    while (length < strArr.length - 1) {
                        strArr[length] = zzabv.readString();
                        zzabv.zzuw();
                        length++;
                    }
                    strArr[length] = zzabv.readString();
                    this.zzask = strArr;
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

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzki)) {
            return false;
        }
        zzki zzki = (zzki) obj;
        if (this.zzash == null) {
            if (zzki.zzash != null) {
                return false;
            }
        } else if (!this.zzash.equals(zzki.zzash)) {
            return false;
        }
        if (this.zzasi == null) {
            if (zzki.zzasi != null) {
                return false;
            }
        } else if (!this.zzasi.equals(zzki.zzasi)) {
            return false;
        }
        if (this.zzasj == null) {
            if (zzki.zzasj != null) {
                return false;
            }
        } else if (!this.zzasj.equals(zzki.zzasj)) {
            return false;
        }
        if (!zzacc.equals((Object[]) this.zzask, (Object[]) zzki.zzask)) {
            return false;
        }
        return (this.zzbww == null || this.zzbww.isEmpty()) ? zzki.zzbww == null || zzki.zzbww.isEmpty() : this.zzbww.equals(zzki.zzbww);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((((this.zzasj == null ? 0 : this.zzasj.hashCode()) + (((this.zzasi == null ? 0 : this.zzasi.hashCode()) + (((this.zzash == null ? 0 : this.zzash.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31) + zzacc.hashCode((Object[]) this.zzask)) * 31;
        if (this.zzbww != null && !this.zzbww.isEmpty()) {
            i = this.zzbww.hashCode();
        }
        return hashCode + i;
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int zza = super.zza();
        if (this.zzash != null) {
            zza += zzabw.zzf(1, this.zzash.intValue());
        }
        if (this.zzasi != null) {
            zza += zzabw.zzc(2, this.zzasi);
        }
        if (this.zzasj != null) {
            this.zzasj.booleanValue();
            zza += zzabw.zzaq(3) + 1;
        }
        if (this.zzask == null || this.zzask.length <= 0) {
            return zza;
        }
        int i = 0;
        int i2 = 0;
        for (String str : this.zzask) {
            if (str != null) {
                i2++;
                i += zzabw.zzfm(str);
            }
        }
        return zza + i + (i2 * 1);
    }

    public final void zza(zzabw zzabw) throws IOException {
        if (this.zzash != null) {
            zzabw.zze(1, this.zzash.intValue());
        }
        if (this.zzasi != null) {
            zzabw.zzb(2, this.zzasi);
        }
        if (this.zzasj != null) {
            zzabw.zza(3, this.zzasj.booleanValue());
        }
        if (this.zzask != null && this.zzask.length > 0) {
            for (String str : this.zzask) {
                if (str != null) {
                    zzabw.zzb(4, str);
                }
            }
        }
        super.zza(zzabw);
    }
}
