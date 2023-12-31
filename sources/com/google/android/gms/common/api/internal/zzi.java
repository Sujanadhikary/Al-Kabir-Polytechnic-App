package com.google.android.gms.common.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzi extends zzk {
    private final SparseArray<zza> zzed = new SparseArray<>();

    private class zza implements GoogleApiClient.OnConnectionFailedListener {
        public final int zzee;
        public final GoogleApiClient zzef;
        public final GoogleApiClient.OnConnectionFailedListener zzeg;

        public zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.zzee = i;
            this.zzef = googleApiClient;
            this.zzeg = onConnectionFailedListener;
            googleApiClient.registerConnectionFailedListener(this);
        }

        public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            String valueOf = String.valueOf(connectionResult);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 27).append("beginFailureResolution for ").append(valueOf).toString());
            zzi.this.zzb(connectionResult, this.zzee);
        }
    }

    private zzi(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.mLifecycleFragment.addCallback("AutoManageHelper", this);
    }

    public static zzi zza(LifecycleActivity lifecycleActivity) {
        LifecycleFragment fragment = getFragment(lifecycleActivity);
        zzi zzi = (zzi) fragment.getCallbackOrNull("AutoManageHelper", zzi.class);
        return zzi != null ? zzi : new zzi(fragment);
    }

    @Nullable
    private final zza zzd(int i) {
        if (this.zzed.size() <= i) {
            return null;
        }
        return this.zzed.get(this.zzed.keyAt(i));
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.zzed.size(); i++) {
            zza zzd = zzd(i);
            if (zzd != null) {
                printWriter.append(str).append("GoogleApiClient #").print(zzd.zzee);
                printWriter.println(":");
                zzd.zzef.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        boolean z = this.mStarted;
        String valueOf = String.valueOf(this.zzed);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 14).append("onStart ").append(z).append(" ").append(valueOf).toString());
        if (this.zzer.get() == null) {
            for (int i = 0; i < this.zzed.size(); i++) {
                zza zzd = zzd(i);
                if (zzd != null) {
                    zzd.zzef.connect();
                }
            }
        }
    }

    public void onStop() {
        super.onStop();
        for (int i = 0; i < this.zzed.size(); i++) {
            zza zzd = zzd(i);
            if (zzd != null) {
                zzd.zzef.disconnect();
            }
        }
    }

    public final void zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.checkNotNull(googleApiClient, "GoogleApiClient instance cannot be null");
        Preconditions.checkState(this.zzed.indexOfKey(i) < 0, new StringBuilder(54).append("Already managing a GoogleApiClient with id ").append(i).toString());
        zzl zzl = (zzl) this.zzer.get();
        boolean z = this.mStarted;
        String valueOf = String.valueOf(zzl);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 49).append("starting AutoManage for client ").append(i).append(" ").append(z).append(" ").append(valueOf).toString());
        this.zzed.put(i, new zza(i, googleApiClient, onConnectionFailedListener));
        if (this.mStarted && zzl == null) {
            String valueOf2 = String.valueOf(googleApiClient);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf2).length() + 11).append("connecting ").append(valueOf2).toString());
            googleApiClient.connect();
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(ConnectionResult connectionResult, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        zza zza2 = this.zzed.get(i);
        if (zza2 != null) {
            zzc(i);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zza2.zzeg;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    public final void zzc(int i) {
        zza zza2 = this.zzed.get(i);
        this.zzed.remove(i);
        if (zza2 != null) {
            zza2.zzef.unregisterConnectionFailedListener(zza2);
            zza2.zzef.disconnect();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzr() {
        for (int i = 0; i < this.zzed.size(); i++) {
            zza zzd = zzd(i);
            if (zzd != null) {
                zzd.zzef.connect();
            }
        }
    }
}
