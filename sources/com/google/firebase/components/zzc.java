package com.google.firebase.components;

import android.content.Context;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public final class zzc {
    private final Context mContext;
    private final zzf zzag;

    public zzc(Context context) {
        this(context, new zze());
    }

    @VisibleForTesting
    private zzc(Context context, zzf zzf) {
        this.mContext = context;
        this.zzag = zzf;
    }

    private static List<ComponentRegistrar> zza(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            try {
                Class<?> cls = Class.forName(next);
                if (!ComponentRegistrar.class.isAssignableFrom(cls)) {
                    Log.w("ComponentDiscovery", String.format("Class %s is not an instance of %s", new Object[]{next, "com.google.firebase.components.ComponentRegistrar"}));
                } else {
                    arrayList.add((ComponentRegistrar) cls.newInstance());
                }
            } catch (ClassNotFoundException e) {
                Log.w("ComponentDiscovery", String.format("Class %s is not an found.", new Object[]{next}), e);
            } catch (IllegalAccessException e2) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", new Object[]{next}), e2);
            } catch (InstantiationException e3) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", new Object[]{next}), e3);
            }
        }
        return arrayList;
    }

    public final List<ComponentRegistrar> zzj() {
        return zza(this.zzag.zzc(this.mContext));
    }
}
