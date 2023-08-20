package com.google.android.gms.internal.firebase_storage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.StorageException;
import java.io.InputStream;
import java.net.SocketException;
import org.json.JSONObject;

public final class zzq {
    private zzl zzed;
    private int zzee;
    private Exception zzef;
    private Exception zzk;

    public zzq(@NonNull zzl zzl) {
        this.zzed = zzl;
    }

    private final void zza(Exception exc, String str) {
        Log.e("NetworkRequestProxy", str, exc);
        this.zzk = exc;
    }

    @Nullable
    public final Exception getException() {
        try {
            return this.zzef != null ? this.zzef : this.zzk != null ? this.zzk : (Exception) ObjectWrapper.unwrap(this.zzed.zzz());
        } catch (RemoteException e) {
            zza((Exception) e, "getException failed with a RemoteException");
            return null;
        }
    }

    public final int getResultCode() {
        try {
            return this.zzee != 0 ? this.zzee : this.zzed.getResultCode();
        } catch (RemoteException e) {
            zza((Exception) e, "getResultCode failed with a RemoteException");
            return 0;
        }
    }

    @Nullable
    public final InputStream getStream() {
        try {
            return (InputStream) ObjectWrapper.unwrap(this.zzed.zzw());
        } catch (RemoteException e) {
            zza((Exception) e, "getStream failed with a RemoteException");
            return null;
        }
    }

    public final void reset() {
        try {
            this.zzee = 0;
            this.zzef = null;
            this.zzed.reset();
        } catch (RemoteException e) {
            zza((Exception) e, "reset failed with a RemoteException");
        }
    }

    public final <TResult> void zza(TaskCompletionSource<TResult> taskCompletionSource, TResult tresult) {
        Exception exception = getException();
        if (!zzaa() || exception != null) {
            taskCompletionSource.setException(StorageException.fromExceptionAndHttpCode(exception, getResultCode()));
        } else {
            taskCompletionSource.setResult(tresult);
        }
    }

    public final void zza(@Nullable String str, @NonNull Context context) {
        boolean z;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                this.zzee = -2;
                this.zzef = new SocketException("Network subsystem is unavailable");
                z = false;
            } else {
                z = true;
            }
            if (z) {
                this.zzed.zzf(str);
            }
        } catch (RemoteException e) {
            zza(this.zzk, "performRequest failed with a RemoteException");
        }
    }

    public final void zza(String str, String str2) {
        try {
            this.zzed.zza(str, str2);
        } catch (RemoteException e) {
            RemoteException remoteException = e;
            String valueOf = String.valueOf(str);
            Log.e("NetworkRequestProxy", valueOf.length() != 0 ? "Caught remote exception setting custom header:".concat(valueOf) : new String("Caught remote exception setting custom header:"), remoteException);
        }
    }

    public final boolean zzaa() {
        try {
            if (this.zzee == -2 || this.zzef != null) {
                return false;
            }
            return this.zzed.zzaa();
        } catch (RemoteException e) {
            zza((Exception) e, "isResultSuccess failed with a RemoteException");
            return false;
        }
    }

    public final int zzab() {
        try {
            return this.zzed.zzab();
        } catch (RemoteException e) {
            zza((Exception) e, "getResultingContentLength failed with a RemoteException");
            return 0;
        }
    }

    @NonNull
    public final JSONObject zzad() throws RemoteException {
        return (JSONObject) ObjectWrapper.unwrap(this.zzed.zzx());
    }

    public final void zzg(@Nullable String str) {
        try {
            this.zzed.zzg(str);
        } catch (RemoteException e) {
            zza((Exception) e, "performRequestStart failed with a RemoteException");
        }
    }

    @Nullable
    public final String zzh(String str) {
        try {
            return this.zzed.zzh(str);
        } catch (RemoteException e) {
            RemoteException remoteException = e;
            String valueOf = String.valueOf(str);
            Log.e("NetworkRequestProxy", valueOf.length() != 0 ? "getResultString failed with a RemoteException:".concat(valueOf) : new String("getResultString failed with a RemoteException:"), remoteException);
            return null;
        }
    }

    public final void zzv() {
        try {
            if (this.zzed != null) {
                this.zzed.zzv();
            }
        } catch (RemoteException e) {
            zza((Exception) e, "performRequestEnd failed with a RemoteException");
        }
    }

    @Nullable
    public final String zzy() {
        try {
            this.zzed.zzy();
            return null;
        } catch (RemoteException e) {
            zza((Exception) e, "getRawResult failed with a RemoteException");
            return null;
        }
    }
}
