package com.google.android.gms.common.config;

import android.content.Context;

final class zzc extends GservicesValue<Integer> {
    zzc(String str, Integer num) {
        super(str, num);
    }

    private static Integer zza(Context context, String str, Integer num) {
        String string = context.getSharedPreferences("gservices-direboot-cache", 0).getString(str, (String) null);
        if (string == null) {
            return num;
        }
        try {
            return Integer.valueOf(Integer.parseInt(string));
        } catch (NumberFormatException e) {
            return num;
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object retrieve(String str) {
        return GservicesValue.zzmu.zza(this.mKey, (Integer) this.mDefaultValue);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object retrieveFromDirectBootCache(Context context, String str, Object obj) {
        return zza(context, str, (Integer) obj);
    }
}
