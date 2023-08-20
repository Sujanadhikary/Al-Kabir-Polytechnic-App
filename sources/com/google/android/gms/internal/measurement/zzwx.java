package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzwx extends zzws<Integer> {
    zzwx(zzxc zzxc, String str, Integer num) {
        super(zzxc, str, num, (zzww) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzfa */
    public final Integer zzey(String str) {
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            String str2 = this.zzbnh;
            Log.e("PhenotypeFlag", new StringBuilder(String.valueOf(str2).length() + 28 + String.valueOf(str).length()).append("Invalid integer value for ").append(str2).append(": ").append(str).toString());
            return null;
        }
    }
}
