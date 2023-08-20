package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.p000v4.app.NotificationCompat;
import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

public final class zzhk extends zzhh {
    @VisibleForTesting
    protected zzid zzanp;
    private AppMeasurement.EventInterceptor zzanq;
    private final Set<AppMeasurement.OnEventListener> zzanr = new CopyOnWriteArraySet();
    private boolean zzans;
    private final AtomicReference<String> zzant = new AtomicReference<>();
    @VisibleForTesting
    protected boolean zzanu = true;

    protected zzhk(zzgl zzgl) {
        super(zzgl);
    }

    private final void zza(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        long currentTimeMillis = zzbt().currentTimeMillis();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mName);
        Preconditions.checkNotEmpty(conditionalUserProperty.mOrigin);
        Preconditions.checkNotNull(conditionalUserProperty.mValue);
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        String str = conditionalUserProperty.mName;
        Object obj = conditionalUserProperty.mValue;
        if (zzgb().zzcf(str) != 0) {
            zzge().zzim().zzg("Invalid conditional user property name", zzga().zzbl(str));
        } else if (zzgb().zzi(str, obj) != 0) {
            zzge().zzim().zze("Invalid conditional user property value", zzga().zzbl(str), obj);
        } else {
            Object zzj = zzgb().zzj(str, obj);
            if (zzj == null) {
                zzge().zzim().zze("Unable to normalize conditional user property value", zzga().zzbl(str), obj);
                return;
            }
            conditionalUserProperty.mValue = zzj;
            long j = conditionalUserProperty.mTriggerTimeout;
            if (TextUtils.isEmpty(conditionalUserProperty.mTriggerEventName) || (j <= 15552000000L && j >= 1)) {
                long j2 = conditionalUserProperty.mTimeToLive;
                if (j2 > 15552000000L || j2 < 1) {
                    zzge().zzim().zze("Invalid conditional user property time to live", zzga().zzbl(str), Long.valueOf(j2));
                } else {
                    zzgd().zzc((Runnable) new zzhr(this, conditionalUserProperty));
                }
            } else {
                zzge().zzim().zze("Invalid conditional user property timeout", zzga().zzbl(str), Long.valueOf(j));
            }
        }
    }

    private final void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        Bundle bundle2;
        if (bundle == null) {
            bundle2 = new Bundle();
        } else {
            bundle2 = new Bundle(bundle);
            for (String str4 : bundle2.keySet()) {
                Object obj = bundle2.get(str4);
                if (obj instanceof Bundle) {
                    bundle2.putBundle(str4, new Bundle((Bundle) obj));
                } else if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= parcelableArr.length) {
                            break;
                        }
                        if (parcelableArr[i2] instanceof Bundle) {
                            parcelableArr[i2] = new Bundle((Bundle) parcelableArr[i2]);
                        }
                        i = i2 + 1;
                    }
                } else if (obj instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) obj;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= arrayList.size()) {
                            break;
                        }
                        Object obj2 = arrayList.get(i4);
                        if (obj2 instanceof Bundle) {
                            arrayList.set(i4, new Bundle((Bundle) obj2));
                        }
                        i3 = i4 + 1;
                    }
                }
            }
        }
        zzgd().zzc((Runnable) new zzic(this, str, str2, j, bundle2, z, z2, z3, str3));
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzgd().zzc((Runnable) new zzhm(this, str, str2, obj, j));
    }

    private final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zza(str, str2, zzbt().currentTimeMillis(), bundle, true, z2, z3, (String) null);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(String str, String str2, Object obj, long j) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        if (!this.zzacw.isEnabled()) {
            zzge().zzis().log("User property not set since app measurement is disabled");
        } else if (this.zzacw.zzjv()) {
            zzge().zzis().zze("Setting user property (FE)", zzga().zzbj(str2), obj);
            zzfx().zzb(new zzjx(str2, j, obj, str));
        }
    }

    private final void zza(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zzbt().currentTimeMillis();
        Preconditions.checkNotEmpty(str2);
        AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
        conditionalUserProperty.mAppId = str;
        conditionalUserProperty.mName = str2;
        conditionalUserProperty.mCreationTimestamp = currentTimeMillis;
        if (str3 != null) {
            conditionalUserProperty.mExpiredEventName = str3;
            conditionalUserProperty.mExpiredEventParams = bundle;
        }
        zzgd().zzc((Runnable) new zzhs(this, conditionalUserProperty));
    }

    @VisibleForTesting
    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        if (zzgd().zzjk()) {
            zzge().zzim().log("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        zzgd();
        if (zzgg.isMainThread()) {
            zzge().zzim().log("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.zzacw.zzgd().zzc((Runnable) new zzhu(this, atomicReference, str, str2, str3, z));
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                zzge().zzip().zzg("Interrupted waiting for get user properties", e);
            }
        }
        List<zzjx> list = (List) atomicReference.get();
        if (list == null) {
            zzge().zzip().log("Timed out waiting for get user properties");
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzjx zzjx : list) {
            arrayMap.put(zzjx.name, zzjx.getValue());
        }
        return arrayMap;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzb(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        zzab();
        zzch();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mName);
        Preconditions.checkNotEmpty(conditionalUserProperty.mOrigin);
        Preconditions.checkNotNull(conditionalUserProperty.mValue);
        if (!this.zzacw.isEnabled()) {
            zzge().zzis().log("Conditional property not sent since Firebase Analytics is disabled");
            return;
        }
        zzjx zzjx = new zzjx(conditionalUserProperty.mName, conditionalUserProperty.mTriggeredTimestamp, conditionalUserProperty.mValue, conditionalUserProperty.mOrigin);
        try {
            zzeu zza = zzgb().zza(conditionalUserProperty.mTriggeredEventName, conditionalUserProperty.mTriggeredEventParams, conditionalUserProperty.mOrigin, 0, true, false);
            zzfx().zzd(new zzed(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, zzjx, conditionalUserProperty.mCreationTimestamp, false, conditionalUserProperty.mTriggerEventName, zzgb().zza(conditionalUserProperty.mTimedOutEventName, conditionalUserProperty.mTimedOutEventParams, conditionalUserProperty.mOrigin, 0, true, false), conditionalUserProperty.mTriggerTimeout, zza, conditionalUserProperty.mTimeToLive, zzgb().zza(conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, 0, true, false)));
        } catch (IllegalArgumentException e) {
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        int i;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(bundle);
        zzab();
        zzch();
        if (!this.zzacw.isEnabled()) {
            zzge().zzis().log("Event not sent since app measurement is disabled");
            return;
        }
        if (!this.zzans) {
            this.zzans = true;
            try {
                try {
                    Class.forName("com.google.android.gms.tagmanager.TagManagerService").getDeclaredMethod("initialize", new Class[]{Context.class}).invoke((Object) null, new Object[]{getContext()});
                } catch (Exception e) {
                    zzge().zzip().zzg("Failed to invoke Tag Manager's initialize() method", e);
                }
            } catch (ClassNotFoundException e2) {
                zzge().zzir().log("Tag Manager is not found and thus will not be used");
            }
        }
        if (z3 && !"_iap".equals(str2)) {
            zzka zzgb = this.zzacw.zzgb();
            int i2 = !zzgb.zzq(NotificationCompat.CATEGORY_EVENT, str2) ? 2 : !zzgb.zza(NotificationCompat.CATEGORY_EVENT, AppMeasurement.Event.zzacx, str2) ? 13 : !zzgb.zza(NotificationCompat.CATEGORY_EVENT, 40, str2) ? 2 : 0;
            if (i2 != 0) {
                zzge().zzio().zzg("Invalid public event name. Event will not be logged (FE)", zzga().zzbj(str2));
                this.zzacw.zzgb();
                this.zzacw.zzgb().zza(i2, "_ev", zzka.zza(str2, 40, true), str2 != null ? str2.length() : 0);
                return;
            }
        }
        zzie zzkc = zzfy().zzkc();
        if (zzkc != null && !bundle.containsKey("_sc")) {
            zzkc.zzaok = true;
        }
        zzif.zza(zzkc, bundle, z && z3);
        boolean equals = "am".equals(str);
        boolean zzci = zzka.zzci(str2);
        if (z && this.zzanq != null && !zzci && !equals) {
            zzge().zzis().zze("Passing event to registered event handler (FE)", zzga().zzbj(str2), zzga().zzb(bundle));
            this.zzanq.interceptEvent(str, str2, bundle, j);
        } else if (this.zzacw.zzjv()) {
            int zzcd = zzgb().zzcd(str2);
            if (zzcd != 0) {
                zzge().zzio().zzg("Invalid event name. Event will not be logged (FE)", zzga().zzbj(str2));
                zzgb();
                this.zzacw.zzgb().zza(str3, zzcd, "_ev", zzka.zza(str2, 40, true), str2 != null ? str2.length() : 0);
                return;
            }
            List listOf = CollectionUtils.listOf((T[]) new String[]{"_o", "_sn", "_sc", "_si"});
            Bundle zza = zzgb().zza(str2, bundle, (List<String>) listOf, z3, true);
            zzie zzie = (zza == null || !zza.containsKey("_sc") || !zza.containsKey("_si")) ? null : new zzie(zza.getString("_sn"), zza.getString("_sc"), Long.valueOf(zza.getLong("_si")).longValue());
            zzie zzie2 = zzie == null ? zzkc : zzie;
            ArrayList arrayList = new ArrayList();
            arrayList.add(zza);
            long nextLong = zzgb().zzlc().nextLong();
            int i3 = 0;
            String[] strArr = (String[]) zza.keySet().toArray(new String[bundle.size()]);
            Arrays.sort(strArr);
            int length = strArr.length;
            int i4 = 0;
            while (i4 < length) {
                String str4 = strArr[i4];
                Object obj = zza.get(str4);
                zzgb();
                Bundle[] zze = zzka.zze(obj);
                if (zze != null) {
                    zza.putInt(str4, zze.length);
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 >= zze.length) {
                            break;
                        }
                        Bundle bundle2 = zze[i6];
                        zzif.zza(zzie2, bundle2, true);
                        Bundle zza2 = zzgb().zza("_ep", bundle2, (List<String>) listOf, z3, false);
                        zza2.putString("_en", str2);
                        zza2.putLong("_eid", nextLong);
                        zza2.putString("_gn", str4);
                        zza2.putInt("_ll", zze.length);
                        zza2.putInt("_i", i6);
                        arrayList.add(zza2);
                        i5 = i6 + 1;
                    }
                    i = zze.length + i3;
                } else {
                    i = i3;
                }
                i4++;
                i3 = i;
            }
            if (i3 != 0) {
                zza.putLong("_eid", nextLong);
                zza.putInt("_epc", i3);
            }
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= arrayList.size()) {
                    break;
                }
                Bundle bundle3 = (Bundle) arrayList.get(i8);
                String str5 = i8 != 0 ? "_ep" : str2;
                bundle3.putString("_o", str);
                Bundle zzd = z2 ? zzgb().zzd(bundle3) : bundle3;
                zzge().zzis().zze("Logging event (FE)", zzga().zzbj(str2), zzga().zzb(zzd));
                zzfx().zzb(new zzeu(str5, new zzer(zzd), str, j), str3);
                if (!equals) {
                    for (AppMeasurement.OnEventListener onEvent : this.zzanr) {
                        onEvent.onEvent(str, str2, new Bundle(zzd), j);
                    }
                }
                i7 = i8 + 1;
            }
            if (zzfy().zzkc() != null && AppMeasurement.Event.APP_EXCEPTION.equals(str2)) {
                zzgc().zzl(true);
            }
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzc(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        zzab();
        zzch();
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mName);
        if (!this.zzacw.isEnabled()) {
            zzge().zzis().log("Conditional property not cleared since Firebase Analytics is disabled");
            return;
        }
        zzjx zzjx = new zzjx(conditionalUserProperty.mName, 0, (Object) null, (String) null);
        try {
            zzfx().zzd(new zzed(conditionalUserProperty.mAppId, conditionalUserProperty.mOrigin, zzjx, conditionalUserProperty.mCreationTimestamp, conditionalUserProperty.mActive, conditionalUserProperty.mTriggerEventName, (zzeu) null, conditionalUserProperty.mTriggerTimeout, (zzeu) null, conditionalUserProperty.mTimeToLive, zzgb().zza(conditionalUserProperty.mExpiredEventName, conditionalUserProperty.mExpiredEventParams, conditionalUserProperty.mOrigin, conditionalUserProperty.mCreationTimestamp, true, false)));
        } catch (IllegalArgumentException e) {
        }
    }

    @VisibleForTesting
    private final List<AppMeasurement.ConditionalUserProperty> zzf(String str, String str2, String str3) {
        if (zzgd().zzjk()) {
            zzge().zzim().log("Cannot get conditional user properties from analytics worker thread");
            return Collections.emptyList();
        }
        zzgd();
        if (zzgg.isMainThread()) {
            zzge().zzim().log("Cannot get conditional user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.zzacw.zzgd().zzc((Runnable) new zzht(this, atomicReference, str, str2, str3));
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                zzge().zzip().zze("Interrupted waiting for get conditional user properties", str, e);
            }
        }
        List<zzed> list = (List) atomicReference.get();
        if (list == null) {
            zzge().zzip().zzg("Timed out waiting for get conditional user properties", str);
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (zzed zzed : list) {
            AppMeasurement.ConditionalUserProperty conditionalUserProperty = new AppMeasurement.ConditionalUserProperty();
            conditionalUserProperty.mAppId = str;
            conditionalUserProperty.mOrigin = str2;
            conditionalUserProperty.mCreationTimestamp = zzed.creationTimestamp;
            conditionalUserProperty.mName = zzed.zzaep.name;
            conditionalUserProperty.mValue = zzed.zzaep.getValue();
            conditionalUserProperty.mActive = zzed.active;
            conditionalUserProperty.mTriggerEventName = zzed.triggerEventName;
            if (zzed.zzaeq != null) {
                conditionalUserProperty.mTimedOutEventName = zzed.zzaeq.name;
                if (zzed.zzaeq.zzafq != null) {
                    conditionalUserProperty.mTimedOutEventParams = zzed.zzaeq.zzafq.zzif();
                }
            }
            conditionalUserProperty.mTriggerTimeout = zzed.triggerTimeout;
            if (zzed.zzaer != null) {
                conditionalUserProperty.mTriggeredEventName = zzed.zzaer.name;
                if (zzed.zzaer.zzafq != null) {
                    conditionalUserProperty.mTriggeredEventParams = zzed.zzaer.zzafq.zzif();
                }
            }
            conditionalUserProperty.mTriggeredTimestamp = zzed.zzaep.zzaqz;
            conditionalUserProperty.mTimeToLive = zzed.timeToLive;
            if (zzed.zzaes != null) {
                conditionalUserProperty.mExpiredEventName = zzed.zzaes.name;
                if (zzed.zzaes.zzafq != null) {
                    conditionalUserProperty.mExpiredEventParams = zzed.zzaes.zzafq.zzif();
                }
            }
            arrayList.add(conditionalUserProperty);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzi(boolean z) {
        zzab();
        zzch();
        zzge().zzis().zzg("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzgf().setMeasurementEnabled(z);
        if (!zzgg().zzaz(zzfv().zzah())) {
            zzfx().zzke();
        } else if (!this.zzacw.isEnabled() || !this.zzanu) {
            zzfx().zzke();
        } else {
            zzge().zzis().log("Recording app launch after enabling measurement for the first time (FE)");
            zzkb();
        }
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zza((String) null, str, str2, bundle);
    }

    public final void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotEmpty(str);
        zzfr();
        zza(str, str2, str3, bundle);
    }

    public final Task<String> getAppInstanceId() {
        try {
            String zzja = zzgf().zzja();
            return zzja != null ? Tasks.forResult(zzja) : Tasks.call(zzgd().zzjl(), new zzho(this));
        } catch (Exception e) {
            zzge().zzip().log("Failed to schedule task for getAppInstanceId");
            return Tasks.forException(e);
        }
    }

    public final List<AppMeasurement.ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        return zzf((String) null, str, str2);
    }

    public final List<AppMeasurement.ConditionalUserProperty> getConditionalUserPropertiesAs(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzfr();
        return zzf(str, str2, str3);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        return zzb((String) null, str, str2, z);
    }

    public final Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        Preconditions.checkNotEmpty(str);
        zzfr();
        return zzb(str, str2, str3, z);
    }

    public final void logEvent(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, this.zzanq == null || zzka.zzci(str2), false, (String) null);
    }

    public final void registerOnMeasurementEventListener(AppMeasurement.OnEventListener onEventListener) {
        zzch();
        Preconditions.checkNotNull(onEventListener);
        if (!this.zzanr.add(onEventListener)) {
            zzge().zzip().log("OnEventListener already registered");
        }
    }

    public final void resetAnalyticsData() {
        zzgd().zzc((Runnable) new zzhq(this, zzbt().currentTimeMillis()));
    }

    public final void setConditionalUserProperty(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        AppMeasurement.ConditionalUserProperty conditionalUserProperty2 = new AppMeasurement.ConditionalUserProperty(conditionalUserProperty);
        if (!TextUtils.isEmpty(conditionalUserProperty2.mAppId)) {
            zzge().zzip().log("Package name should be null when calling setConditionalUserProperty");
        }
        conditionalUserProperty2.mAppId = null;
        zza(conditionalUserProperty2);
    }

    public final void setConditionalUserPropertyAs(AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        Preconditions.checkNotNull(conditionalUserProperty);
        Preconditions.checkNotEmpty(conditionalUserProperty.mAppId);
        zzfr();
        zza(new AppMeasurement.ConditionalUserProperty(conditionalUserProperty));
    }

    @WorkerThread
    public final void setEventInterceptor(AppMeasurement.EventInterceptor eventInterceptor) {
        zzab();
        zzch();
        if (!(eventInterceptor == null || eventInterceptor == this.zzanq)) {
            Preconditions.checkState(this.zzanq == null, "EventInterceptor already set.");
        }
        this.zzanq = eventInterceptor;
    }

    public final void setMeasurementEnabled(boolean z) {
        zzch();
        zzgd().zzc((Runnable) new zzhz(this, z));
    }

    public final void setMinimumSessionDuration(long j) {
        zzgd().zzc((Runnable) new zzia(this, j));
    }

    public final void setSessionTimeoutDuration(long j) {
        zzgd().zzc((Runnable) new zzib(this, j));
    }

    public final void setUserProperty(String str, String str2, Object obj) {
        int i = 0;
        Preconditions.checkNotEmpty(str);
        long currentTimeMillis = zzbt().currentTimeMillis();
        int zzcf = zzgb().zzcf(str2);
        if (zzcf != 0) {
            zzgb();
            String zza = zzka.zza(str2, 24, true);
            if (str2 != null) {
                i = str2.length();
            }
            this.zzacw.zzgb().zza(zzcf, "_ev", zza, i);
        } else if (obj != null) {
            int zzi = zzgb().zzi(str2, obj);
            if (zzi != 0) {
                zzgb();
                String zza2 = zzka.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i = String.valueOf(obj).length();
                }
                this.zzacw.zzgb().zza(zzi, "_ev", zza2, i);
                return;
            }
            Object zzj = zzgb().zzj(str2, obj);
            if (zzj != null) {
                zza(str, str2, currentTimeMillis, zzj);
            }
        } else {
            zza(str, str2, currentTimeMillis, (Object) null);
        }
    }

    public final void unregisterOnMeasurementEventListener(AppMeasurement.OnEventListener onEventListener) {
        zzch();
        Preconditions.checkNotNull(onEventListener);
        if (!this.zzanr.remove(onEventListener)) {
            zzge().zzip().log("OnEventListener had not been registered");
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(String str, String str2, Bundle bundle) {
        zzab();
        zzb(str, str2, zzbt().currentTimeMillis(), bundle, true, this.zzanq == null || zzka.zzci(str2), false, (String) null);
    }

    public final void zza(String str, String str2, Bundle bundle, long j) {
        zza(str, str2, j, bundle, false, true, true, (String) null);
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z) {
        zza(str, str2, bundle, true, this.zzanq == null || zzka.zzci(str2), true, (String) null);
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final String zzae(long j) {
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            zzgd().zzc((Runnable) new zzhp(this, atomicReference));
            try {
                atomicReference.wait(j);
            } catch (InterruptedException e) {
                zzge().zzip().log("Interrupted waiting for app instance id");
                return null;
            }
        }
        return (String) atomicReference.get();
    }

    /* access modifiers changed from: package-private */
    public final void zzbr(@Nullable String str) {
        this.zzant.set(str);
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        return super.zzbt();
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        super.zzfr();
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        super.zzfs();
    }

    public final /* bridge */ /* synthetic */ zzdu zzft() {
        return super.zzft();
    }

    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        return super.zzfu();
    }

    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        return super.zzfv();
    }

    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        return super.zzfw();
    }

    public final /* bridge */ /* synthetic */ zzii zzfx() {
        return super.zzfx();
    }

    public final /* bridge */ /* synthetic */ zzif zzfy() {
        return super.zzfy();
    }

    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        return super.zzfz();
    }

    public final /* bridge */ /* synthetic */ zzfe zzga() {
        return super.zzga();
    }

    public final /* bridge */ /* synthetic */ zzka zzgb() {
        return super.zzgb();
    }

    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        return super.zzgc();
    }

    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        return super.zzgd();
    }

    public final /* bridge */ /* synthetic */ zzfg zzge() {
        return super.zzge();
    }

    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        return super.zzgf();
    }

    public final /* bridge */ /* synthetic */ zzef zzgg() {
        return super.zzgg();
    }

    /* access modifiers changed from: protected */
    public final boolean zzhf() {
        return false;
    }

    public final String zzhm() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzgd().zza(atomicReference, 15000, "String test flag value", new zzhv(this, atomicReference));
    }

    public final List<zzjx> zzj(boolean z) {
        zzch();
        zzge().zzis().log("Fetching user attributes (FE)");
        if (zzgd().zzjk()) {
            zzge().zzim().log("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        }
        zzgd();
        if (zzgg.isMainThread()) {
            zzge().zzim().log("Cannot get all user properties from main thread");
            return Collections.emptyList();
        }
        AtomicReference atomicReference = new AtomicReference();
        synchronized (atomicReference) {
            this.zzacw.zzgd().zzc((Runnable) new zzhn(this, atomicReference, z));
            try {
                atomicReference.wait(5000);
            } catch (InterruptedException e) {
                zzge().zzip().zzg("Interrupted waiting for get user properties", e);
            }
        }
        List<zzjx> list = (List) atomicReference.get();
        if (list != null) {
            return list;
        }
        zzge().zzip().log("Timed out waiting for get user properties");
        return Collections.emptyList();
    }

    @Nullable
    public final String zzja() {
        return this.zzant.get();
    }

    public final Boolean zzjx() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzgd().zza(atomicReference, 15000, "boolean test flag value", new zzhl(this, atomicReference));
    }

    public final Long zzjy() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzgd().zza(atomicReference, 15000, "long test flag value", new zzhw(this, atomicReference));
    }

    public final Integer zzjz() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzgd().zza(atomicReference, 15000, "int test flag value", new zzhx(this, atomicReference));
    }

    public final Double zzka() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzgd().zza(atomicReference, 15000, "double test flag value", new zzhy(this, atomicReference));
    }

    @WorkerThread
    public final void zzkb() {
        zzab();
        zzch();
        if (this.zzacw.zzjv()) {
            zzfx().zzkb();
            this.zzanu = false;
            String zzjd = zzgf().zzjd();
            if (!TextUtils.isEmpty(zzjd)) {
                zzfw().zzch();
                if (!zzjd.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", zzjd);
                    logEvent("auto", "_ou", bundle);
                }
            }
        }
    }
}
