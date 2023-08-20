package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.support.annotation.MainThread;
import android.support.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class zza extends ActivityLifecycleObserver {
    private final WeakReference<C0439zza> zzds;

    @VisibleForTesting(otherwise = 2)
    /* renamed from: com.google.android.gms.common.api.internal.zza$zza  reason: collision with other inner class name */
    static class C0439zza extends LifecycleCallback {
        private List<Runnable> zzdt = new ArrayList();

        private C0439zza(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
        }

        /* access modifiers changed from: private */
        public static C0439zza zza(Activity activity) {
            C0439zza zza;
            synchronized (activity) {
                LifecycleFragment fragment = getFragment(activity);
                zza = (C0439zza) fragment.getCallbackOrNull("LifecycleObserverOnStop", C0439zza.class);
                if (zza == null) {
                    zza = new C0439zza(fragment);
                }
            }
            return zza;
        }

        /* access modifiers changed from: private */
        public final synchronized void zza(Runnable runnable) {
            this.zzdt.add(runnable);
        }

        @MainThread
        public void onStop() {
            List<Runnable> list;
            synchronized (this) {
                list = this.zzdt;
                this.zzdt = new ArrayList();
            }
            for (Runnable run : list) {
                run.run();
            }
        }
    }

    public zza(Activity activity) {
        this(C0439zza.zza(activity));
    }

    @VisibleForTesting(otherwise = 2)
    private zza(C0439zza zza) {
        this.zzds = new WeakReference<>(zza);
    }

    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        C0439zza zza = (C0439zza) this.zzds.get();
        if (zza == null) {
            throw new IllegalStateException("The target activity has already been GC'd");
        }
        zza.zza(runnable);
        return this;
    }
}
