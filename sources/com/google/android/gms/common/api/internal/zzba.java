package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

final class zzba extends Handler {
    private final /* synthetic */ zzav zzit;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzba(zzav zzav, Looper looper) {
        super(looper);
        this.zzit = zzav;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.zzit.zzay();
                return;
            case 2:
                this.zzit.resume();
                return;
            default:
                Log.w("GoogleApiClientImpl", new StringBuilder(31).append("Unknown message id: ").append(message.what).toString());
                return;
        }
    }
}
