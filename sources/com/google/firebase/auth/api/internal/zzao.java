package com.google.firebase.auth.api.internal;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.firebase_auth.zzaj;
import com.google.android.gms.internal.firebase_auth.zzaq;
import com.google.android.gms.internal.firebase_auth.zzax;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.FirebaseExceptionMapper;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.ProviderQueryResult;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzad;
import com.google.firebase.auth.internal.zzh;
import com.google.firebase.auth.internal.zzk;
import com.google.firebase.auth.internal.zzm;
import com.google.firebase.auth.internal.zzu;
import com.google.firebase.auth.internal.zzv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

public final class zzao extends zzah {
    @NonNull
    private final Context zzgo;
    @NonNull
    private final zzcp zzgp;

    zzao(@NonNull Context context, @NonNull zzcp zzcp) {
        this.zzgo = context;
        this.zzgp = zzcp;
    }

    private static <ResultT, CallbackT> zzbb<ResultT, CallbackT> zza(zzcy<ResultT, CallbackT> zzcy, String str) {
        return new zzbb<>(zzcy, str);
    }

    /* access modifiers changed from: private */
    @NonNull
    public static zzk zza(@NonNull FirebaseApp firebaseApp, @NonNull zzaj zzaj) {
        return zza(firebaseApp, zzaj, false);
    }

    /* access modifiers changed from: private */
    @NonNull
    public static zzk zza(@NonNull FirebaseApp firebaseApp, @NonNull zzaj zzaj, boolean z) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(zzaj);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zzh(zzaj, FirebaseAuthProvider.PROVIDER_ID));
        List<zzaq> zzar = zzaj.zzar();
        if (zzar != null && !zzar.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= zzar.size()) {
                    break;
                }
                arrayList.add(new zzh(zzar.get(i2)));
                i = i2 + 1;
            }
        }
        zzk zzk = new zzk(firebaseApp, arrayList);
        zzk.zza(z);
        zzk.zza(new zzm(zzaj.getLastSignInTimestamp(), zzaj.getCreationTimestamp()));
        zzk.zzf(zzaj.isNewUser());
        zzk.zzc(zzaj.zzat());
        return zzk;
    }

    @NonNull
    private final GoogleApi<zzcp> zzc(boolean z) {
        zzcp zzcp = (zzcp) this.zzgp.clone();
        zzcp.zzgj = z;
        return new zzal(this.zzgo, zzcn.zzhi, zzcp, new FirebaseExceptionMapper());
    }

    @NonNull
    public final Task<Void> setFirebaseUIVersion(@NonNull String str) {
        return zzb(zza(new zzbm(str), "setFirebaseUIVersion"));
    }

    public final Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull ActionCodeSettings actionCodeSettings, @NonNull String str) {
        return zzb(zza(new zzbk(str, actionCodeSettings).zzb(firebaseApp), "sendEmailVerification"));
    }

    public final Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull AuthCredential authCredential, @NonNull zza zza) {
        return zzb(zza(new zzbo(authCredential).zzb(firebaseApp).zza(zza), "signInWithCredential"));
    }

    public final Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull EmailAuthCredential emailAuthCredential, @NonNull zza zza) {
        return zzb(zza(new zzbr(emailAuthCredential).zzb(firebaseApp).zza(zza), "sendSignInLinkToEmail"));
    }

    public final Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential, @NonNull zzad zzad) {
        return zzb(zza(new zzbc(authCredential).zzb(firebaseApp).zzf(firebaseUser).zza(zzad).zza((zzv) zzad), "reauthenticateWithCredential"));
    }

    public final Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull EmailAuthCredential emailAuthCredential, @NonNull zzad zzad) {
        return zzb(zza(new zzbe(emailAuthCredential).zzb(firebaseApp).zzf(firebaseUser).zza(zzad).zza((zzv) zzad), "reauthenticateWithEmailLink"));
    }

    public final Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull PhoneAuthCredential phoneAuthCredential, @NonNull zzad zzad) {
        return zzb(zza(new zzbx(phoneAuthCredential).zzb(firebaseApp).zzf(firebaseUser).zza(zzad).zza((zzv) zzad), "updatePhoneNumber"));
    }

    public final Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull UserProfileChangeRequest userProfileChangeRequest, @NonNull zzad zzad) {
        return zzb(zza(new zzby(userProfileChangeRequest).zzb(firebaseApp).zzf(firebaseUser).zza(zzad).zza((zzv) zzad), "updateProfile"));
    }

    @NonNull
    public final Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull zzad zzad) {
        return zza(zza(new zzbj().zzb(firebaseApp).zzf(firebaseUser).zza(zzad).zza((zzv) zzad), "reload"));
    }

    public final Task<GetTokenResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull zzad zzad) {
        return zza(zza(new zzaw(str).zzb(firebaseApp).zzf(firebaseUser).zza(zzad).zza((zzv) zzad), "getAccessToken"));
    }

    public final Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull String str2, @NonNull zzad zzad) {
        return zzb(zza(new zzbg(str, str2).zzb(firebaseApp).zzf(firebaseUser).zza(zzad).zza((zzv) zzad), "reauthenticateWithEmailPassword"));
    }

    public final Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull PhoneAuthCredential phoneAuthCredential, @NonNull zza zza) {
        return zzb(zza(new zzbs(phoneAuthCredential).zzb(firebaseApp).zza(zza), "signInWithPhoneNumber"));
    }

    public final Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull zza zza) {
        return zzb(zza(new zzbn().zzb(firebaseApp).zza(zza), "signInAnonymously"));
    }

    public final Task<ProviderQueryResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull String str) {
        return zza(zza(new zzau(str).zzb(firebaseApp), "fetchProvidersForEmail"));
    }

    public final Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull String str, @NonNull ActionCodeSettings actionCodeSettings) {
        actionCodeSettings.zzb(1);
        return zzb(zza(new zzbl(str, actionCodeSettings).zzb(firebaseApp), "sendPasswordResetEmail"));
    }

    public final Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull String str, @NonNull zza zza) {
        return zzb(zza(new zzbp(str).zzb(firebaseApp).zza(zza), "signInWithCustomToken"));
    }

    public final Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull String str, @NonNull String str2) {
        return zzb(zza(new zzar(str, str2).zzb(firebaseApp), "confirmPasswordReset"));
    }

    public final Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull String str, @NonNull String str2, @NonNull zza zza) {
        return zzb(zza(new zzas(str, str2).zzb(firebaseApp).zza(zza), "createUserWithEmailAndPassword"));
    }

    @NonNull
    public final Task<Void> zza(@NonNull FirebaseUser firebaseUser, @NonNull zzu zzu) {
        return zzb(zza(new zzat().zzf(firebaseUser).zza(zzu).zza((zzv) zzu), "delete"));
    }

    public final void zza(@NonNull FirebaseApp firebaseApp, @NonNull zzax zzax, @NonNull PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, @Nullable Activity activity, @NonNull Executor executor) {
        zzb(zza(new zzca(zzax).zzb(firebaseApp).zza(onVerificationStateChangedCallbacks, activity, executor), "verifyPhoneNumber"));
    }

    public final Task<AuthResult> zzb(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential, @NonNull zzad zzad) {
        return zzb(zza(new zzbd(authCredential).zzb(firebaseApp).zzf(firebaseUser).zza(zzad).zza((zzv) zzad), "reauthenticateWithCredentialWithData"));
    }

    public final Task<AuthResult> zzb(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull EmailAuthCredential emailAuthCredential, @NonNull zzad zzad) {
        return zzb(zza(new zzbf(emailAuthCredential).zzb(firebaseApp).zzf(firebaseUser).zza(zzad).zza((zzv) zzad), "reauthenticateWithEmailLinkWithData"));
    }

    public final Task<Void> zzb(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull PhoneAuthCredential phoneAuthCredential, @NonNull zzad zzad) {
        return zzb(zza(new zzbi(phoneAuthCredential).zzb(firebaseApp).zzf(firebaseUser).zza(zzad).zza((zzv) zzad), "reauthenticateWithPhoneCredential"));
    }

    public final Task<Void> zzb(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull zzad zzad) {
        return zzb(zza(new zzbv(str).zzb(firebaseApp).zzf(firebaseUser).zza(zzad).zza((zzv) zzad), "updateEmail"));
    }

    public final Task<AuthResult> zzb(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull String str2, @NonNull zzad zzad) {
        return zzb(zza(new zzbh(str, str2).zzb(firebaseApp).zzf(firebaseUser).zza(zzad).zza((zzv) zzad), "reauthenticateWithEmailPasswordWithData"));
    }

    public final Task<SignInMethodQueryResult> zzb(@NonNull FirebaseApp firebaseApp, @NonNull String str) {
        return zza(zza(new zzav(str).zzb(firebaseApp), "fetchSignInMethodsForEmail"));
    }

    public final Task<Void> zzb(@NonNull FirebaseApp firebaseApp, @NonNull String str, @NonNull ActionCodeSettings actionCodeSettings) {
        actionCodeSettings.zzb(6);
        return zzb(zza(new zzbl(str, actionCodeSettings).zzb(firebaseApp), "sendSignInLinkToEmail"));
    }

    public final Task<AuthResult> zzb(@NonNull FirebaseApp firebaseApp, @NonNull String str, @NonNull String str2, @NonNull zza zza) {
        return zzb(zza(new zzbq(str, str2).zzb(firebaseApp).zza(zza), "signInWithEmailAndPassword"));
    }

    public final Task<AuthResult> zzc(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential, @NonNull zzad zzad) {
        return zzb(zza(new zzbd(authCredential).zzb(firebaseApp).zzf(firebaseUser).zza(zzad).zza((zzv) zzad), "reauthenticateWithPhoneCredentialWithData"));
    }

    public final Task<Void> zzc(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull zzad zzad) {
        return zzb(zza(new zzbw(str).zzb(firebaseApp).zzf(firebaseUser).zza(zzad).zza((zzv) zzad), "updatePassword"));
    }

    public final Task<ActionCodeResult> zzc(@NonNull FirebaseApp firebaseApp, @NonNull String str) {
        return zzb(zza(new zzaq(str).zzb(firebaseApp), "checkActionCode"));
    }

    public final Task<AuthResult> zzd(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential, @NonNull zzad zzad) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzad);
        List<String> providers = firebaseUser.getProviders();
        if (providers != null && providers.contains(authCredential.getProvider())) {
            return Tasks.forException(zzce.zzb(new Status(FirebaseError.ERROR_PROVIDER_ALREADY_LINKED)));
        }
        if (authCredential instanceof EmailAuthCredential) {
            return !((EmailAuthCredential) authCredential).zzi() ? zzb(zza(new zzax((EmailAuthCredential) authCredential).zzb(firebaseApp).zzf(firebaseUser).zza(zzad).zza((zzv) zzad), "linkEmailAuthCredential")) : zzb(zza(new zzba((EmailAuthCredential) authCredential).zzb(firebaseApp).zzf(firebaseUser).zza(zzad).zza((zzv) zzad), "linkEmailAuthCredential"));
        }
        if (authCredential instanceof PhoneAuthCredential) {
            return zzb(zza(new zzaz((PhoneAuthCredential) authCredential).zzb(firebaseApp).zzf(firebaseUser).zza(zzad).zza((zzv) zzad), "linkPhoneAuthCredential"));
        }
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzad);
        return zzb(zza(new zzay(authCredential).zzb(firebaseApp).zzf(firebaseUser).zza(zzad).zza((zzv) zzad), "linkFederatedCredential"));
    }

    public final Task<AuthResult> zzd(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull zzad zzad) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzad);
        List<String> providers = firebaseUser.getProviders();
        if ((providers != null && !providers.contains(str)) || firebaseUser.isAnonymous()) {
            return Tasks.forException(zzce.zzb(new Status(FirebaseError.ERROR_NO_SUCH_PROVIDER, str)));
        }
        char c = 65535;
        switch (str.hashCode()) {
            case 1216985755:
                if (str.equals("password")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return zzb(zza(new zzbt().zzb(firebaseApp).zzf(firebaseUser).zza(zzad).zza((zzv) zzad), "unlinkEmailCredential"));
            default:
                return zzb(zza(new zzbu(str).zzb(firebaseApp).zzf(firebaseUser).zza(zzad).zza((zzv) zzad), "unlinkFederatedCredential"));
        }
    }

    public final Task<Void> zzd(@NonNull FirebaseApp firebaseApp, @NonNull String str) {
        return zzb(zza(new zzap(str).zzb(firebaseApp), "applyActionCode"));
    }

    public final Task<String> zze(@NonNull FirebaseApp firebaseApp, @NonNull String str) {
        return zzb(zza(new zzbz(str).zzb(firebaseApp), "verifyPasswordResetCode"));
    }

    /* access modifiers changed from: package-private */
    public final zzai zzu() {
        int remoteVersion = DynamiteModule.getRemoteVersion(this.zzgo, "com.google.android.gms.firebase_auth");
        GoogleApi<zzcp> zzc = zzc(false);
        int localVersion = DynamiteModule.getLocalVersion(this.zzgo, "com.google.firebase.auth");
        return new zzai(zzc, localVersion != 0 ? zzc(true) : null, new zzak(remoteVersion, localVersion, Collections.emptyMap(), true));
    }
}
