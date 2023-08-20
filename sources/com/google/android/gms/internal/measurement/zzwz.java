package com.google.android.gms.internal.measurement;

import android.util.Log;

final class zzwz extends zzws<Double> {
    zzwz(zzxc zzxc, String str, Double d) {
        super(zzxc, str, d, (zzww) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzfb */
    public final Double zzey(String str) {
        try {
            return Double.valueOf(Double.parseDouble(str));
        } catch (NumberFormatException e) {
            String str2 = this.zzbnh;
            Log.e("PhenotypeFlag", new StringBuilder(String.valueOf(str2).length() + 27 + String.valueOf(str).length()).append("Invalid double value for ").append(str2).append(": ").append(str).toString());
            return null;
        }
    }
}
