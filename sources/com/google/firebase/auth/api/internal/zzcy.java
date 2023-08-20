package com.google.firebase.auth.api.internal;

import android.app.Activity;
import android.os.RemoteException;
import android.support.annotation.MainThread;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzaj;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.android.gms.internal.firebase_auth.zzav;
import com.google.android.gms.internal.firebase_auth.zzx;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.zzv;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

abstract class zzcy<SuccessT, CallbackT> {
    protected FirebaseApp zzdz;
    protected String zzeu;
    protected final int zzhv;
    protected final zzdb zzhw = new zzdb(this);
    protected FirebaseUser zzhx;
    protected zzck zzhy;
    protected CallbackT zzhz;
    protected zzv zzia;
    protected zzcx<SuccessT> zzib;
    protected final List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> zzic = new ArrayList();
    private Activity zzid;
    protected Executor zzie;
    protected zzda zzif;
    protected zzao zzig;
    protected zzaj zzih;
    protected zzx zzii;
    protected zzav zzij;
    protected String zzik;
    protected PhoneAuthCredential zzil;
    /* access modifiers changed from: private */
    public boolean zzim;
    @VisibleForTesting
    boolean zzin;
    @VisibleForTesting
    private SuccessT zzio;
    @VisibleForTesting
    private Status zzip;

    static class zza extends LifecycleCallback {
        private List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> zziq;

        private zza(LifecycleFragment lifecycleFragment, List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> list) {
            super(lifecycleFragment);
            this.mLifecycleFragment.addCallback("PhoneAuthActivityStopCallback", this);
            this.zziq = list;
        }

        public static void zza(Activity activity, List<PhoneAuthProvider.OnVerificationStateChangedCallbacks> list) {
            LifecycleFragment fragment = getFragment(activity);
            if (((zza) fragment.getCallbackOrNull("PhoneAuthActivityStopCallback", zza.class)) == null) {
                new zza(fragment, list);
            }
        }

        @MainThread
        public void onStop() {
            synchronized (this.zziq) {
                this.zziq.clear();
            }
        }
    }

    public zzcy(int i) {
        this.zzhv = i;
    }

    /* access modifiers changed from: private */
    public final void zzak() {
        zzz();
        Preconditions.checkState(this.zzim, "no success or failure set on method implementation");
    }

    /* access modifiers changed from: private */
    public final void zzd(Status status) {
        if (this.zzia != null) {
            this.zzia.zza(status);
        }
    }

    public final zzcy<SuccessT, CallbackT> zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor) {
        synchronized (this.zzic) {
            this.zzic.add((PhoneAuthProvider.OnVerificationStateChangedCallbacks) Preconditions.checkNotNull(onVerificationStateChangedCallbacks));
        }
        this.zzid = activity;
        if (this.zzid != null) {
            zza.zza(activity, this.zzic);
        }
        this.zzie = (Executor) Preconditions.checkNotNull(executor);
        return this;
    }

    public final zzcy<SuccessT, CallbackT> zza(zzv zzv) {
        this.zzia = (zzv) Preconditions.checkNotNull(zzv, "external failure callback cannot be null");
        return this;
    }

    public final zzcy<SuccessT, CallbackT> zza(CallbackT callbackt) {
        this.zzhz = Preconditions.checkNotNull(callbackt, "external callback cannot be null");
        return this;
    }

    public final zzcy<SuccessT, CallbackT> zzb(FirebaseApp firebaseApp) {
        this.zzdz = (FirebaseApp) Preconditions.checkNotNull(firebaseApp, "firebaseApp cannot be null");
        return this;
    }

    public final void zzb(SuccessT successt) {
        this.zzim = true;
        this.zzin = true;
        this.zzio = successt;
        this.zzib.zza(successt, (Status) null);
    }

    public final void zzc(Status status) {
        this.zzim = true;
        this.zzin = false;
        this.zzip = status;
        this.zzib.zza(null, status);
    }

    public final zzcy<SuccessT, CallbackT> zzf(FirebaseUser firebaseUser) {
        this.zzhx = (FirebaseUser) Preconditions.checkNotNull(firebaseUser, "firebaseUser cannot be null");
        return this;
    }

    /* access modifiers changed from: protected */
    public abstract void zzy() throws RemoteException;

    public abstract void zzz();
}
