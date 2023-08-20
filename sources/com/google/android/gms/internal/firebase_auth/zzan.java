package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.api.internal.zzdp;

public final class zzan implements zzdp<zzl> {
    private String zzad;
    private String zzaf;
    private ActionCodeSettings zzgx;
    private String zzjr;

    public zzan(@NonNull int i) {
        String str;
        switch (i) {
            case 1:
                str = "PASSWORD_RESET";
                break;
            case 4:
                str = "VERIFY_EMAIL";
                break;
            case 6:
                str = "EMAIL_SIGNIN";
                break;
            default:
                str = "REQUEST_TYPE_UNSET_ENUM_VALUE";
                break;
        }
        this.zzjr = str;
    }

    public final zzan zza(@NonNull ActionCodeSettings actionCodeSettings) {
        this.zzgx = (ActionCodeSettings) Preconditions.checkNotNull(actionCodeSettings);
        return this;
    }

    public final /* synthetic */ zzgv zzam() {
        int i = 1;
        zzl zzl = new zzl();
        String str = this.zzjr;
        char c = 65535;
        switch (str.hashCode()) {
            case -1452371317:
                if (str.equals("PASSWORD_RESET")) {
                    c = 0;
                    break;
                }
                break;
            case -1341836234:
                if (str.equals("VERIFY_EMAIL")) {
                    c = 1;
                    break;
                }
                break;
            case 870738373:
                if (str.equals("EMAIL_SIGNIN")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                break;
            case 1:
                i = 4;
                break;
            case 2:
                i = 6;
                break;
            default:
                i = Integer.MIN_VALUE;
                break;
        }
        zzl.zzam = i;
        zzl.zzaf = this.zzaf;
        zzl.zzad = this.zzad;
        if (this.zzgx != null) {
            zzl.zzar = this.zzgx.getUrl();
            zzl.zzas = this.zzgx.getIOSBundle();
            zzl.zzat = this.zzgx.zze();
            zzl.zzau = this.zzgx.getAndroidPackageName();
            zzl.zzav = this.zzgx.getAndroidInstallApp();
            zzl.zzaw = this.zzgx.getAndroidMinimumVersion();
            zzl.zzax = this.zzgx.canHandleCodeInApp();
        }
        return zzl;
    }

    public final zzan zzp(@NonNull String str) {
        this.zzaf = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzan zzq(@NonNull String str) {
        this.zzad = Preconditions.checkNotEmpty(str);
        return this;
    }
}
