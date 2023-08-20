package com.google.firebase.auth.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.dynamite.DynamiteModule;

public final class zzcd extends GmsClient<zzck> implements zzcc {
    private static Logger zzdv = new Logger("FirebaseAuth", "FirebaseAuth:");
    private final Context zzgo;
    private final zzcp zzhd;

    public zzcd(Context context, Looper looper, ClientSettings clientSettings, zzcp zzcp, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 112, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzgo = (Context) Preconditions.checkNotNull(context);
        this.zzhd = zzcp;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
        return queryLocalInterface instanceof zzck ? (zzck) queryLocalInterface : new zzcm(iBinder);
    }

    /* access modifiers changed from: protected */
    public final Bundle getGetServiceRequestExtraArgs() {
        Bundle getServiceRequestExtraArgs = super.getGetServiceRequestExtraArgs();
        if (getServiceRequestExtraArgs == null) {
            getServiceRequestExtraArgs = new Bundle();
        }
        if (this.zzhd != null) {
            getServiceRequestExtraArgs.putString("com.google.firebase.auth.API_KEY", this.zzhd.getApiKey());
        }
        return getServiceRequestExtraArgs;
    }

    public final int getMinApkVersion() {
        return 12451000;
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.firebase.auth.api.internal.IFirebaseAuthService";
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.firebase.auth.api.gms.service.START";
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getStartServicePackage() {
        /*
            r4 = this;
            r2 = -1
            r1 = 0
            java.lang.String r0 = "firebear.preference"
            java.lang.String r0 = com.google.firebase.auth.api.internal.zzdo.getProperty(r0)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L_0x0010
            java.lang.String r0 = "default"
        L_0x0010:
            int r3 = r0.hashCode()
            switch(r3) {
                case 103145323: goto L_0x0047;
                case 1544803905: goto L_0x0051;
                default: goto L_0x0017;
            }
        L_0x0017:
            r3 = r2
        L_0x0018:
            switch(r3) {
                case 0: goto L_0x001d;
                case 1: goto L_0x001d;
                default: goto L_0x001b;
            }
        L_0x001b:
            java.lang.String r0 = "default"
        L_0x001d:
            int r3 = r0.hashCode()
            switch(r3) {
                case 103145323: goto L_0x005b;
                default: goto L_0x0024;
            }
        L_0x0024:
            r0 = r2
        L_0x0025:
            switch(r0) {
                case 0: goto L_0x0065;
                default: goto L_0x0028;
            }
        L_0x0028:
            com.google.android.gms.common.logging.Logger r0 = zzdv
            java.lang.String r2 = "Loading module via FirebaseOptions."
            java.lang.Object[] r3 = new java.lang.Object[r1]
            r0.mo8041i(r2, r3)
            com.google.firebase.auth.api.internal.zzcp r0 = r4.zzhd
            boolean r0 = r0.zzgj
            if (r0 == 0) goto L_0x0075
            com.google.android.gms.common.logging.Logger r0 = zzdv
            java.lang.String r2 = "Preparing to create service connection to fallback implementation"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r0.mo8041i(r2, r1)
            android.content.Context r0 = r4.zzgo
            java.lang.String r0 = r0.getPackageName()
        L_0x0046:
            return r0
        L_0x0047:
            java.lang.String r3 = "local"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0017
            r3 = r1
            goto L_0x0018
        L_0x0051:
            java.lang.String r3 = "default"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0017
            r3 = 1
            goto L_0x0018
        L_0x005b:
            java.lang.String r3 = "local"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0024
            r0 = r1
            goto L_0x0025
        L_0x0065:
            com.google.android.gms.common.logging.Logger r0 = zzdv
            java.lang.String r2 = "Loading fallback module override."
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r0.mo8041i(r2, r1)
            android.content.Context r0 = r4.zzgo
            java.lang.String r0 = r0.getPackageName()
            goto L_0x0046
        L_0x0075:
            com.google.android.gms.common.logging.Logger r0 = zzdv
            java.lang.String r2 = "Preparing to create service connection to gms implementation"
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r0.mo8041i(r2, r1)
            java.lang.String r0 = "com.google.android.gms"
            goto L_0x0046
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.api.internal.zzcd.getStartServicePackage():java.lang.String");
    }

    public final boolean requiresGooglePlayServices() {
        return DynamiteModule.getLocalVersion(this.zzgo, "com.google.firebase.auth") == 0;
    }

    public final /* synthetic */ zzck zzad() throws DeadObjectException {
        return (zzck) super.getService();
    }
}
