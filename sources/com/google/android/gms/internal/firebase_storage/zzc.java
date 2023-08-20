package com.google.android.gms.internal.firebase_storage;

import android.app.Activity;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzc {
    private static final zzc zzdg = new zzc();
    private final Map<Object, zzd> zzdh = new HashMap();
    private final Object zzdi = new Object();

    private static class zza extends LifecycleCallback {
        private final List<zzd> zzdm = new ArrayList();

        private zza(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.mLifecycleFragment.addCallback("StorageOnStopCallback", this);
        }

        public static zza zza(Activity activity) {
            LifecycleFragment fragment = getFragment(new LifecycleActivity(activity));
            zza zza = (zza) fragment.getCallbackOrNull("StorageOnStopCallback", zza.class);
            return zza == null ? new zza(fragment) : zza;
        }

        @MainThread
        public void onStop() {
            ArrayList arrayList;
            synchronized (this.zzdm) {
                arrayList = new ArrayList(this.zzdm);
                this.zzdm.clear();
            }
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                zzd zzd = (zzd) obj;
                if (zzd != null) {
                    Log.d("StorageOnStopCallback", "removing subscription from activity.");
                    zzd.zzj().run();
                    zzc.zzs().zzd(zzd.zzt());
                }
            }
        }

        public final void zza(zzd zzd) {
            synchronized (this.zzdm) {
                this.zzdm.add(zzd);
            }
        }

        public final void zzb(zzd zzd) {
            synchronized (this.zzdm) {
                this.zzdm.remove(zzd);
            }
        }
    }

    private zzc() {
    }

    @NonNull
    public static zzc zzs() {
        return zzdg;
    }

    public final void zza(@NonNull Activity activity, @NonNull Object obj, @NonNull Runnable runnable) {
        synchronized (this.zzdi) {
            zzd zzd = new zzd(activity, runnable, obj);
            zza.zza(activity).zza(zzd);
            this.zzdh.put(obj, zzd);
        }
    }

    public final void zzd(@NonNull Object obj) {
        synchronized (this.zzdi) {
            zzd zzd = this.zzdh.get(obj);
            if (zzd != null) {
                zza.zza(zzd.getActivity()).zzb(zzd);
            }
        }
    }
}
