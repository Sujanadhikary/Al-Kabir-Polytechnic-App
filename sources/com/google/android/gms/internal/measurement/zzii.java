package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@VisibleForTesting
public final class zzii extends zzhh {
    /* access modifiers changed from: private */
    public final zziw zzaox;
    /* access modifiers changed from: private */
    public zzey zzaoy;
    private volatile Boolean zzaoz;
    private final zzem zzapa;
    private final zzjm zzapb;
    private final List<Runnable> zzapc = new ArrayList();
    private final zzem zzapd;

    protected zzii(zzgl zzgl) {
        super(zzgl);
        this.zzapb = new zzjm(zzgl.zzbt());
        this.zzaox = new zziw(this);
        this.zzapa = new zzij(this, zzgl);
        this.zzapd = new zzio(this, zzgl);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void onServiceDisconnected(ComponentName componentName) {
        zzab();
        if (this.zzaoy != null) {
            this.zzaoy = null;
            zzge().zzit().zzg("Disconnected from device MeasurementService", componentName);
            zzab();
            zzdf();
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzcu() {
        zzab();
        this.zzapb.start();
        this.zzapa.zzh(zzew.zzaho.get().longValue());
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzcv() {
        zzab();
        if (isConnected()) {
            zzge().zzit().log("Inactivity, disconnecting from the service");
            disconnect();
        }
    }

    @WorkerThread
    private final void zzf(Runnable runnable) throws IllegalStateException {
        zzab();
        if (isConnected()) {
            runnable.run();
        } else if (((long) this.zzapc.size()) >= 1000) {
            zzge().zzim().log("Discarding data. Max runnable queue size reached");
        } else {
            this.zzapc.add(runnable);
            this.zzapd.zzh(60000);
            zzdf();
        }
    }

    @Nullable
    @WorkerThread
    private final zzdz zzk(boolean z) {
        return zzfv().zzbi(z ? zzge().zziv() : null);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzkg() {
        zzab();
        zzge().zzit().zzg("Processing queued up service tasks", Integer.valueOf(this.zzapc.size()));
        for (Runnable run : this.zzapc) {
            try {
                run.run();
            } catch (Exception e) {
                zzge().zzim().zzg("Task exception while flushing queue", e);
            }
        }
        this.zzapc.clear();
        this.zzapd.cancel();
    }

    @WorkerThread
    public final void disconnect() {
        zzab();
        zzch();
        try {
            ConnectionTracker.getInstance().unbindService(getContext(), this.zzaox);
        } catch (IllegalArgumentException | IllegalStateException e) {
        }
        this.zzaoy = null;
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    public final boolean isConnected() {
        zzab();
        zzch();
        return this.zzaoy != null;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void resetAnalyticsData() {
        zzab();
        zzch();
        zzdz zzk = zzk(false);
        zzfz().resetAnalyticsData();
        zzf(new zzik(this, zzk));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    @VisibleForTesting
    public final void zza(zzey zzey) {
        zzab();
        Preconditions.checkNotNull(zzey);
        this.zzaoy = zzey;
        zzcu();
        zzkg();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final void zza(zzey zzey, AbstractSafeParcelable abstractSafeParcelable, zzdz zzdz) {
        zzab();
        zzch();
        int i = 100;
        for (int i2 = 0; i2 < 1001 && i == 100; i2++) {
            ArrayList arrayList = new ArrayList();
            List<AbstractSafeParcelable> zzp = zzfz().zzp(100);
            if (zzp != null) {
                arrayList.addAll(zzp);
                i = zzp.size();
            } else {
                i = 0;
            }
            if (abstractSafeParcelable != null && i < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList2.get(i3);
                i3++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzeu) {
                    try {
                        zzey.zza((zzeu) abstractSafeParcelable2, zzdz);
                    } catch (RemoteException e) {
                        zzge().zzim().zzg("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zzjx) {
                    try {
                        zzey.zza((zzjx) abstractSafeParcelable2, zzdz);
                    } catch (RemoteException e2) {
                        zzge().zzim().zzg("Failed to send attribute to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzed) {
                    try {
                        zzey.zza((zzed) abstractSafeParcelable2, zzdz);
                    } catch (RemoteException e3) {
                        zzge().zzim().zzg("Failed to send conditional property to the service", e3);
                    }
                } else {
                    zzge().zzim().log("Discarding data. Unrecognized parcel type.");
                }
            }
        }
    }

    @WorkerThread
    public final void zza(AtomicReference<String> atomicReference) {
        zzab();
        zzch();
        zzf(new zzil(this, atomicReference, zzk(false)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(AtomicReference<List<zzed>> atomicReference, String str, String str2, String str3) {
        zzab();
        zzch();
        zzf(new zzis(this, atomicReference, str, str2, str3, zzk(false)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(AtomicReference<List<zzjx>> atomicReference, String str, String str2, String str3, boolean z) {
        zzab();
        zzch();
        zzf(new zzit(this, atomicReference, str, str2, str3, z, zzk(false)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(AtomicReference<List<zzjx>> atomicReference, boolean z) {
        zzab();
        zzch();
        zzf(new zziv(this, atomicReference, zzk(false), z));
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzb(zzeu zzeu, String str) {
        Preconditions.checkNotNull(zzeu);
        zzab();
        zzch();
        zzf(new zziq(this, true, zzfz().zza(zzeu), zzeu, zzk(true), str));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzb(zzie zzie) {
        zzab();
        zzch();
        zzf(new zzin(this, zzie));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzb(zzjx zzjx) {
        zzab();
        zzch();
        zzf(new zziu(this, zzfz().zza(zzjx), zzjx, zzk(true)));
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        return super.zzbt();
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzd(zzed zzed) {
        Preconditions.checkNotNull(zzed);
        zzab();
        zzch();
        zzf(new zzir(this, true, zzfz().zzc(zzed), new zzed(zzed), zzk(true), zzed));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzdf() {
        boolean z;
        boolean z2;
        boolean z3 = true;
        zzab();
        zzch();
        if (!isConnected()) {
            if (this.zzaoz == null) {
                zzab();
                zzch();
                Boolean zzjb = zzgf().zzjb();
                if (zzjb == null || !zzjb.booleanValue()) {
                    if (zzfv().zzik() != 1) {
                        zzge().zzit().log("Checking service availability");
                        int isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(zzgb().getContext(), 12451);
                        switch (isGooglePlayServicesAvailable) {
                            case 0:
                                zzge().zzit().log("Service available");
                                z = true;
                                z2 = true;
                                break;
                            case 1:
                                zzge().zzit().log("Service missing");
                                z = true;
                                z2 = false;
                                break;
                            case 2:
                                zzge().zzis().log("Service container out of date");
                                if (zzgb().zzld() >= 12600) {
                                    Boolean zzjb2 = zzgf().zzjb();
                                    z2 = zzjb2 == null || zzjb2.booleanValue();
                                    z = false;
                                    break;
                                } else {
                                    z = true;
                                    z2 = false;
                                    break;
                                }
                            case 3:
                                zzge().zzip().log("Service disabled");
                                z = false;
                                z2 = false;
                                break;
                            case 9:
                                zzge().zzip().log("Service invalid");
                                z = false;
                                z2 = false;
                                break;
                            case 18:
                                zzge().zzip().log("Service updating");
                                z = true;
                                z2 = true;
                                break;
                            default:
                                zzge().zzip().zzg("Unexpected service status", Integer.valueOf(isGooglePlayServicesAvailable));
                                z = false;
                                z2 = false;
                                break;
                        }
                    } else {
                        z = true;
                        z2 = true;
                    }
                    if (z) {
                        zzgf().zzf(z2);
                    }
                } else {
                    z2 = true;
                }
                this.zzaoz = Boolean.valueOf(z2);
            }
            if (this.zzaoz.booleanValue()) {
                this.zzaox.zzkh();
                return;
            }
            List<ResolveInfo> queryIntentServices = getContext().getPackageManager().queryIntentServices(new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
            if (queryIntentServices == null || queryIntentServices.size() <= 0) {
                z3 = false;
            }
            if (z3) {
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                intent.setComponent(new ComponentName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"));
                this.zzaox.zzc(intent);
                return;
            }
            zzge().zzim().log("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
        }
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

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzkb() {
        zzab();
        zzch();
        zzf(new zzim(this, zzk(true)));
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzke() {
        zzab();
        zzch();
        zzf(new zzip(this, zzk(true)));
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzkf() {
        return this.zzaoz;
    }
}
