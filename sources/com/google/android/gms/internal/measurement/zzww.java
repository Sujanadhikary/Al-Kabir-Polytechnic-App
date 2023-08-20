package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzww extends zzws<Long> {
    zzww(zzxc zzxc, String str, Long l) {
        super(zzxc, str, l, (zzww) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzez */
    public final Long zzey(String str) {
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException e) {
            String str2 = this.zzbnh;
            Log.e("PhenotypeFlag", new StringBuilder(String.valueOf(str2).length() + 25 + String.valueOf(str).length()).append("Invalid long value for ").append(str2).append(": ").append(str).toString());
            return null;
        }
    }
}
