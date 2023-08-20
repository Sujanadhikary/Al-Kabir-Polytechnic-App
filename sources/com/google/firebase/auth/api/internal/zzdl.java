package com.google.firebase.auth.api.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;

public final class zzdl {
    private final String packageName;
    private final String zzix;

    public zzdl(Context context) {
        this(context, context.getPackageName());
    }

    private zzdl(@NonNull Context context, @NonNull String str) {
        Preconditions.checkNotNull(context);
        this.packageName = Preconditions.checkNotEmpty(str);
        try {
            byte[] packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(context, this.packageName);
            if (packageCertificateHashBytes == null) {
                String valueOf = String.valueOf(str);
                Log.e("FBA-PackageInfo", valueOf.length() != 0 ? "single cert required: ".concat(valueOf) : new String("single cert required: "));
                this.zzix = null;
                return;
            }
            this.zzix = Hex.bytesToStringUppercase(packageCertificateHashBytes, false);
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf2 = String.valueOf(str);
            Log.e("FBA-PackageInfo", valueOf2.length() != 0 ? "no pkg: ".concat(valueOf2) : new String("no pkg: "));
            this.zzix = null;
        }
    }

    public final String getPackageName() {
        return this.packageName;
    }

    @Nullable
    public final String zzal() {
        return this.zzix;
    }
}
