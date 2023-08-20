package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.PhoneAuthCredential;

final class zzbb<ResultT, CallbackT> extends zzam<zzcc, ResultT> implements zzcx<ResultT> {
    private final String zzgu;
    private zzcy<ResultT, CallbackT> zzgv;
    private TaskCompletionSource<ResultT> zzgw;

    public zzbb(zzcy<ResultT, CallbackT> zzcy, String str) {
        this.zzgv = zzcy;
        this.zzgv.zzib = this;
        this.zzgu = str;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzgw = taskCompletionSource;
        zzcy<ResultT, CallbackT> zzcy = this.zzgv;
        zzcy.zzhy = ((zzcc) anyClient).zzad();
        zzcy.zzy();
    }

    public final void zza(ResultT resultt, Status status) {
        Preconditions.checkNotNull(this.zzgw, "doExecute must be called before onComplete");
        if (status == null) {
            this.zzgw.setResult(resultt);
        } else if (this.zzgv.zzil != null) {
            this.zzgw.setException(zzce.zzb(status, (PhoneAuthCredential) this.zzgv.zzil.clone()));
            this.zzgv.zzil = null;
        } else {
            this.zzgw.setException(zzce.zzb(status));
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzx() {
        return this.zzgu;
    }
}
