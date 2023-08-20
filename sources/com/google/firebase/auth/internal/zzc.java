package com.google.firebase.auth.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.internal.firebase_auth.zzav;
import com.google.firebase.auth.ActionCodeResult;

public final class zzc implements ActionCodeResult {
    private final String zzaf;
    private final int zzkk;
    private final String zzkl;

    public zzc(@NonNull zzav zzav) {
        if (TextUtils.isEmpty(zzav.zzay())) {
            this.zzaf = zzav.getEmail();
        } else {
            this.zzaf = zzav.zzay();
        }
        this.zzkl = zzav.getEmail();
        if (TextUtils.isEmpty(zzav.zzaz())) {
            this.zzkk = 3;
        } else if (zzav.zzaz().equals("PASSWORD_RESET")) {
            this.zzkk = 0;
        } else if (zzav.zzaz().equals("VERIFY_EMAIL")) {
            this.zzkk = 1;
        } else if (zzav.zzaz().equals("RECOVER_EMAIL")) {
            this.zzkk = 2;
        } else if (zzav.zzaz().equals("EMAIL_SIGNIN")) {
            this.zzkk = 4;
        } else {
            this.zzkk = 3;
        }
    }

    @Nullable
    public final String getData(int i) {
        switch (i) {
            case 0:
                if (this.zzkk != 4) {
                    return this.zzaf;
                }
                return null;
            case 1:
                return this.zzkl;
            default:
                return null;
        }
    }

    public final int getOperation() {
        return this.zzkk;
    }
}
