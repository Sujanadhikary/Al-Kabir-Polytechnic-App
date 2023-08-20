package com.google.android.gms.internal.firebase_storage;

import android.content.Context;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.firebase.FirebaseApp;
import org.json.JSONObject;

public final class zzp {
    @VisibleForTesting
    private static final DynamiteModule.VersionPolicy zzdz = DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION;
    private static final Object zzea = new Object();
    private static volatile zzp zzeb;
    private Context mContext;
    private zzn zzec;
    private FirebaseApp zzp;

    private zzp(@NonNull FirebaseApp firebaseApp) throws RemoteException {
        zzn zzo;
        this.mContext = firebaseApp.getApplicationContext();
        this.zzp = firebaseApp;
        try {
            IBinder instantiate = DynamiteModule.load(this.mContext, zzdz, "com.google.android.gms.firebasestorage").instantiate("com.google.firebase.storage.network.NetworkRequestFactoryImpl");
            if (instantiate == null) {
                zzo = null;
            } else {
                IInterface queryLocalInterface = instantiate.queryLocalInterface("com.google.firebase.storage.network.INetworkRequestFactory");
                zzo = queryLocalInterface instanceof zzn ? (zzn) queryLocalInterface : new zzo(instantiate);
            }
            this.zzec = zzo;
            if (this.zzec == null) {
                Log.e("NetworkRqFactoryProxy", "Unable to load Firebase Storage Network layer.");
                throw new RemoteException();
            }
        } catch (DynamiteModule.LoadingException e) {
            Log.e("NetworkRqFactoryProxy", "NetworkRequestFactoryProxy failed with a RemoteException:", e);
            throw new RemoteException();
        }
    }

    public static zzp zzb(@NonNull FirebaseApp firebaseApp) throws RemoteException {
        if (zzeb == null) {
            synchronized (zzea) {
                if (zzeb == null) {
                    zzeb = new zzp(firebaseApp);
                }
            }
        }
        return zzeb;
    }

    private final zzq zze(zzq zzq) {
        zzq.zza("x-firebase-gmpid", this.zzp.getOptions().getApplicationId());
        return zzq;
    }

    @NonNull
    public final zzq zza(Uri uri, long j) throws RemoteException {
        return zze(new zzq(this.zzec.zza(uri, ObjectWrapper.wrap(this.mContext), j)));
    }

    @Nullable
    public final zzq zza(Uri uri, String str) throws RemoteException {
        return zze(new zzq(this.zzec.zza(uri, ObjectWrapper.wrap(this.mContext), str)));
    }

    @NonNull
    public final zzq zza(Uri uri, String str, byte[] bArr, long j, int i, boolean z) throws RemoteException {
        return zze(new zzq(this.zzec.zza(uri, ObjectWrapper.wrap(this.mContext), str, ObjectWrapper.wrap(bArr), j, i, z)));
    }

    @NonNull
    public final zzq zza(Uri uri, JSONObject jSONObject) throws RemoteException {
        return zze(new zzq(this.zzec.zza(uri, ObjectWrapper.wrap(this.mContext), ObjectWrapper.wrap(jSONObject))));
    }

    @NonNull
    public final zzq zza(Uri uri, JSONObject jSONObject, String str) throws RemoteException {
        return zze(new zzq(this.zzec.zza(uri, ObjectWrapper.wrap(this.mContext), ObjectWrapper.wrap(jSONObject), str)));
    }

    @Nullable
    public final String zzac() {
        try {
            return this.zzec.zzac();
        } catch (RemoteException e) {
            Log.e("NetworkRqFactoryProxy", "getBackendAuthority failed with a RemoteException:", e);
            return null;
        }
    }

    @NonNull
    public final zzq zzb(Uri uri, String str) throws RemoteException {
        return zze(new zzq(this.zzec.zzb(uri, ObjectWrapper.wrap(this.mContext), str)));
    }

    @Nullable
    public final String zzb(Uri uri) {
        try {
            return this.zzec.zzb(uri);
        } catch (RemoteException e) {
            Log.e("NetworkRqFactoryProxy", "getDefaultURL failed with a RemoteException:", e);
            return null;
        }
    }

    @NonNull
    public final zzq zzc(Uri uri) throws RemoteException {
        return zze(new zzq(this.zzec.zza(uri, ObjectWrapper.wrap(this.mContext))));
    }

    @NonNull
    public final zzq zzd(Uri uri) throws RemoteException {
        return zze(new zzq(this.zzec.zzb(uri, ObjectWrapper.wrap(this.mContext))));
    }
}
