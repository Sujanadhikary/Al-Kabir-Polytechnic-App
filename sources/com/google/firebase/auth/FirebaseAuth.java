package com.google.firebase.auth;

import android.app.Activity;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzax;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.api.internal.zzao;
import com.google.firebase.auth.api.internal.zzce;
import com.google.firebase.auth.api.internal.zzcn;
import com.google.firebase.auth.api.internal.zzcq;
import com.google.firebase.auth.api.internal.zzcw;
import com.google.firebase.auth.internal.zzaa;
import com.google.firebase.auth.internal.zzac;
import com.google.firebase.auth.internal.zzad;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.auth.internal.zzj;
import com.google.firebase.auth.internal.zzk;
import com.google.firebase.auth.internal.zzu;
import com.google.firebase.auth.internal.zzv;
import com.google.firebase.auth.internal.zzx;
import com.google.firebase.auth.internal.zzz;
import com.google.firebase.internal.InternalTokenProvider;
import com.google.firebase.internal.InternalTokenResult;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class FirebaseAuth implements InternalTokenProvider {
    private static Map<String, FirebaseAuth> zzej = new ArrayMap();
    private static FirebaseAuth zzek;
    /* access modifiers changed from: private */
    public FirebaseApp zzdz;
    /* access modifiers changed from: private */
    public List<IdTokenListener> zzea;
    /* access modifiers changed from: private */
    public List<AuthStateListener> zzeb;
    private zzao zzec;
    /* access modifiers changed from: private */
    public FirebaseUser zzed;
    private final Object zzee;
    private String zzef;
    private zzz zzeg;
    private zzaa zzeh;
    private zzac zzei;

    public interface AuthStateListener {
        void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth);
    }

    public interface IdTokenListener {
        void onIdTokenChanged(@NonNull FirebaseAuth firebaseAuth);
    }

    @VisibleForTesting
    class zza implements com.google.firebase.auth.internal.zza {
        zza() {
        }

        public final void zza(@NonNull com.google.android.gms.internal.firebase_auth.zzao zzao, @NonNull FirebaseUser firebaseUser) {
            Preconditions.checkNotNull(zzao);
            Preconditions.checkNotNull(firebaseUser);
            firebaseUser.zza(zzao);
            FirebaseAuth.this.zza(firebaseUser, zzao, true);
        }
    }

    @VisibleForTesting
    class zzb extends zza implements com.google.firebase.auth.internal.zza, zzv {
        zzb() {
            super();
        }

        public final void zza(Status status) {
            if (status.getStatusCode() == 17011 || status.getStatusCode() == 17021 || status.getStatusCode() == 17005) {
                FirebaseAuth.this.signOut();
            }
        }
    }

    public FirebaseAuth(FirebaseApp firebaseApp) {
        this(firebaseApp, zzcn.zza(firebaseApp.getApplicationContext(), new zzcq(firebaseApp.getOptions().getApiKey()).zzaf()), new zzz(firebaseApp.getApplicationContext(), firebaseApp.getPersistenceKey()));
    }

    @VisibleForTesting
    private FirebaseAuth(FirebaseApp firebaseApp, zzao zzao, zzz zzz) {
        com.google.android.gms.internal.firebase_auth.zzao zzh;
        this.zzee = new Object();
        this.zzdz = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        this.zzec = (zzao) Preconditions.checkNotNull(zzao);
        this.zzeg = (zzz) Preconditions.checkNotNull(zzz);
        this.zzea = new CopyOnWriteArrayList();
        this.zzeb = new CopyOnWriteArrayList();
        this.zzei = zzac.zzbk();
        this.zzed = this.zzeg.zzbi();
        if (this.zzed != null && (zzh = this.zzeg.zzh(this.zzed)) != null) {
            zza(this.zzed, zzh, false);
        }
    }

    @Keep
    public static FirebaseAuth getInstance() {
        return zza(FirebaseApp.getInstance());
    }

    @Keep
    public static FirebaseAuth getInstance(@NonNull FirebaseApp firebaseApp) {
        return zza(firebaseApp);
    }

    private static synchronized FirebaseAuth zza(@NonNull FirebaseApp firebaseApp) {
        FirebaseAuth firebaseAuth;
        synchronized (FirebaseAuth.class) {
            String persistenceKey = firebaseApp.getPersistenceKey();
            firebaseAuth = zzej.get(persistenceKey);
            if (firebaseAuth == null) {
                firebaseAuth = new zzj(firebaseApp);
                firebaseApp.setTokenProvider(firebaseAuth);
                if (zzek == null) {
                    zzek = firebaseAuth;
                }
                zzej.put(persistenceKey, firebaseAuth);
            }
        }
        return firebaseAuth;
    }

    @VisibleForTesting
    private final synchronized void zza(zzaa zzaa) {
        this.zzeh = zzaa;
        this.zzdz.setIdTokenListenersCountChangedListener(zzaa);
    }

    private final void zzb(@Nullable FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            String uid = firebaseUser.getUid();
            Log.d("FirebaseAuth", new StringBuilder(String.valueOf(uid).length() + 45).append("Notifying id token listeners about user ( ").append(uid).append(" ).").toString());
        } else {
            Log.d("FirebaseAuth", "Notifying id token listeners about a sign-out event.");
        }
        this.zzei.execute(new zzk(this, new InternalTokenResult(firebaseUser != null ? firebaseUser.zzp() : null)));
    }

    private final void zzc(@Nullable FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            String uid = firebaseUser.getUid();
            Log.d("FirebaseAuth", new StringBuilder(String.valueOf(uid).length() + 47).append("Notifying auth state listeners about user ( ").append(uid).append(" ).").toString());
        } else {
            Log.d("FirebaseAuth", "Notifying auth state listeners about a sign-out event.");
        }
        this.zzei.execute(new zzl(this));
    }

    @VisibleForTesting
    private final synchronized zzaa zzk() {
        if (this.zzeh == null) {
            zza(new zzaa(this.zzdz));
        }
        return this.zzeh;
    }

    public void addAuthStateListener(@NonNull AuthStateListener authStateListener) {
        this.zzeb.add(authStateListener);
        this.zzei.execute(new zzj(this, authStateListener));
    }

    public void addIdTokenListener(@NonNull IdTokenListener idTokenListener) {
        this.zzea.add(idTokenListener);
        this.zzei.execute(new zzi(this, idTokenListener));
    }

    @NonNull
    public Task<Void> applyActionCode(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzec.zzd(this.zzdz, str);
    }

    @NonNull
    public Task<ActionCodeResult> checkActionCode(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzec.zzc(this.zzdz, str);
    }

    @NonNull
    public Task<Void> confirmPasswordReset(@NonNull String str, @NonNull String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.zzec.zza(this.zzdz, str, str2);
    }

    @NonNull
    public Task<AuthResult> createUserWithEmailAndPassword(@NonNull String str, @NonNull String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.zzec.zza(this.zzdz, str, str2, (com.google.firebase.auth.internal.zza) new zza());
    }

    @Deprecated
    @NonNull
    public Task<ProviderQueryResult> fetchProvidersForEmail(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzec.zza(this.zzdz, str);
    }

    @NonNull
    public Task<SignInMethodQueryResult> fetchSignInMethodsForEmail(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzec.zzb(this.zzdz, str);
    }

    @NonNull
    public Task<GetTokenResult> getAccessToken(boolean z) {
        return zza(this.zzed, z);
    }

    public FirebaseApp getApp() {
        return this.zzdz;
    }

    @Nullable
    public FirebaseUser getCurrentUser() {
        return this.zzed;
    }

    @Nullable
    public String getLanguageCode() {
        String str;
        synchronized (this.zzee) {
            str = this.zzef;
        }
        return str;
    }

    @Nullable
    public String getUid() {
        if (this.zzed == null) {
            return null;
        }
        return this.zzed.getUid();
    }

    public boolean isSignInWithEmailLink(@NonNull String str) {
        return EmailAuthCredential.isSignInWithEmailLink(str);
    }

    public void removeAuthStateListener(@NonNull AuthStateListener authStateListener) {
        this.zzeb.remove(authStateListener);
    }

    public void removeIdTokenListener(@NonNull IdTokenListener idTokenListener) {
        this.zzea.remove(idTokenListener);
    }

    @NonNull
    public Task<Void> sendPasswordResetEmail(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return sendPasswordResetEmail(str, (ActionCodeSettings) null);
    }

    @NonNull
    public Task<Void> sendPasswordResetEmail(@NonNull String str, @Nullable ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.newBuilder().build();
        }
        if (this.zzef != null) {
            actionCodeSettings.zza(this.zzef);
        }
        actionCodeSettings.zzb(1);
        return this.zzec.zza(this.zzdz, str, actionCodeSettings);
    }

    public Task<Void> sendSignInLinkToEmail(@NonNull String str, @NonNull ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(actionCodeSettings);
        if (!actionCodeSettings.canHandleCodeInApp()) {
            throw new IllegalArgumentException("You must set canHandleCodeInApp in your ActionCodeSettings to true for Email-Link Sign-in.");
        }
        if (this.zzef != null) {
            actionCodeSettings.zza(this.zzef);
        }
        return this.zzec.zzb(this.zzdz, str, actionCodeSettings);
    }

    public Task<Void> setFirebaseUIVersion(@Nullable String str) {
        return this.zzec.setFirebaseUIVersion(str);
    }

    public void setLanguageCode(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        synchronized (this.zzee) {
            this.zzef = str;
        }
    }

    @NonNull
    public Task<AuthResult> signInAnonymously() {
        if (this.zzed == null || !this.zzed.isAnonymous()) {
            return this.zzec.zza(this.zzdz, (com.google.firebase.auth.internal.zza) new zza());
        }
        zzk zzk = (zzk) this.zzed;
        zzk.zzf(false);
        return Tasks.forResult(new zzf(zzk));
    }

    @NonNull
    public Task<AuthResult> signInWithCredential(@NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        if (authCredential instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            return !emailAuthCredential.zzi() ? this.zzec.zzb(this.zzdz, emailAuthCredential.getEmail(), emailAuthCredential.getPassword(), (com.google.firebase.auth.internal.zza) new zza()) : this.zzec.zza(this.zzdz, emailAuthCredential, (com.google.firebase.auth.internal.zza) new zza());
        } else if (!(authCredential instanceof PhoneAuthCredential)) {
            return this.zzec.zza(this.zzdz, authCredential, (com.google.firebase.auth.internal.zza) new zza());
        } else {
            return this.zzec.zza(this.zzdz, (PhoneAuthCredential) authCredential, (com.google.firebase.auth.internal.zza) new zza());
        }
    }

    @NonNull
    public Task<AuthResult> signInWithCustomToken(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzec.zza(this.zzdz, str, (com.google.firebase.auth.internal.zza) new zza());
    }

    @NonNull
    public Task<AuthResult> signInWithEmailAndPassword(@NonNull String str, @NonNull String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.zzec.zzb(this.zzdz, str, str2, (com.google.firebase.auth.internal.zza) new zza());
    }

    @NonNull
    public Task<AuthResult> signInWithEmailLink(@NonNull String str, @NonNull String str2) {
        return signInWithCredential(EmailAuthProvider.getCredentialWithLink(str, str2));
    }

    public void signOut() {
        zzj();
        if (this.zzeh != null) {
            this.zzeh.cancel();
        }
    }

    public void useAppLanguage() {
        synchronized (this.zzee) {
            this.zzef = zzcw.zzaj();
        }
    }

    @NonNull
    public Task<String> verifyPasswordResetCode(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzec.zze(this.zzdz, str);
    }

    @NonNull
    public final Task<Void> zza(@Nullable ActionCodeSettings actionCodeSettings, @NonNull String str) {
        Preconditions.checkNotEmpty(str);
        if (this.zzef != null) {
            if (actionCodeSettings == null) {
                actionCodeSettings = ActionCodeSettings.newBuilder().build();
            }
            actionCodeSettings.zza(this.zzef);
        }
        return this.zzec.zza(this.zzdz, actionCodeSettings, str);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.internal.zzad, com.google.firebase.auth.FirebaseAuth$zzb] */
    /* JADX WARNING: type inference failed for: r2v1, types: [com.google.firebase.auth.internal.zzad, com.google.firebase.auth.FirebaseAuth$zzb] */
    /* JADX WARNING: type inference failed for: r2v2, types: [com.google.firebase.auth.internal.zzad, com.google.firebase.auth.FirebaseAuth$zzb] */
    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.firebase.auth.internal.zzad, com.google.firebase.auth.FirebaseAuth$zzb] */
    @NonNull
    public final Task<Void> zza(@NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(authCredential);
        if (!EmailAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            return authCredential instanceof PhoneAuthCredential ? this.zzec.zzb(this.zzdz, firebaseUser, (PhoneAuthCredential) authCredential, (zzad) new zzb()) : this.zzec.zza(this.zzdz, firebaseUser, authCredential, (zzad) new zzb());
        }
        EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
        if (!"password".equals(emailAuthCredential.getSignInMethod())) {
            return this.zzec.zza(this.zzdz, firebaseUser, emailAuthCredential, (zzad) new zzb());
        }
        return this.zzec.zza(this.zzdz, firebaseUser, emailAuthCredential.getEmail(), emailAuthCredential.getPassword(), (zzad) new zzb());
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.internal.zzad, com.google.firebase.auth.FirebaseAuth$zzb] */
    @NonNull
    public final Task<Void> zza(@NonNull FirebaseUser firebaseUser, @NonNull PhoneAuthCredential phoneAuthCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(phoneAuthCredential);
        return this.zzec.zza(this.zzdz, firebaseUser, phoneAuthCredential, (zzad) new zzb());
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.internal.zzad, com.google.firebase.auth.FirebaseAuth$zzb] */
    @NonNull
    public final Task<Void> zza(@NonNull FirebaseUser firebaseUser, @NonNull UserProfileChangeRequest userProfileChangeRequest) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(userProfileChangeRequest);
        return this.zzec.zza(this.zzdz, firebaseUser, userProfileChangeRequest, (zzad) new zzb());
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.internal.zzad, com.google.firebase.auth.FirebaseAuth$zzb] */
    @NonNull
    public final Task<AuthResult> zza(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        return this.zzec.zzd(this.zzdz, firebaseUser, str, (zzad) new zzb());
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.google.firebase.auth.internal.zzad, com.google.firebase.auth.zzm] */
    @NonNull
    public final Task<GetTokenResult> zza(@Nullable FirebaseUser firebaseUser, boolean z) {
        if (firebaseUser == null) {
            return Tasks.forException(zzce.zzb(new Status(FirebaseError.ERROR_NO_SIGNED_IN_USER)));
        }
        com.google.android.gms.internal.firebase_auth.zzao zzn = this.zzed.zzn();
        return (!zzn.isValid() || z) ? this.zzec.zza(this.zzdz, firebaseUser, zzn.zzan(), (zzad) new zzm(this)) : Tasks.forResult(zzx.zzag(zzn.zzau()));
    }

    public final void zza(@NonNull FirebaseUser firebaseUser, @NonNull com.google.android.gms.internal.firebase_auth.zzao zzao, boolean z) {
        boolean z2;
        boolean z3 = true;
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzao);
        if (this.zzed == null) {
            z2 = true;
        } else {
            boolean z4 = !this.zzed.zzn().zzau().equals(zzao.zzau());
            boolean equals = this.zzed.getUid().equals(firebaseUser.getUid());
            z2 = !equals || z4;
            if (equals) {
                z3 = false;
            }
        }
        Preconditions.checkNotNull(firebaseUser);
        if (this.zzed == null) {
            this.zzed = firebaseUser;
        } else {
            this.zzed.zza(firebaseUser.isAnonymous());
            this.zzed.zza(firebaseUser.getProviderData());
        }
        if (z) {
            this.zzeg.zzg(this.zzed);
        }
        if (z2) {
            if (this.zzed != null) {
                this.zzed.zza(zzao);
            }
            zzb(this.zzed);
        }
        if (z3) {
            zzc(this.zzed);
        }
        if (z) {
            this.zzeg.zza(firebaseUser, zzao);
        }
        zzk().zzc(this.zzed.zzn());
    }

    @NonNull
    public final void zza(@NonNull String str, long j, TimeUnit timeUnit, @NonNull PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, @Nullable Activity activity, @NonNull Executor executor, boolean z) {
        long convert = TimeUnit.SECONDS.convert(j, timeUnit);
        if (convert < 0 || convert > 120) {
            throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
        }
        this.zzec.zza(this.zzdz, new zzax(str, convert, z, this.zzef), onVerificationStateChangedCallbacks, activity, executor);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.internal.zzad, com.google.firebase.auth.FirebaseAuth$zzb] */
    /* JADX WARNING: type inference failed for: r2v1, types: [com.google.firebase.auth.internal.zzad, com.google.firebase.auth.FirebaseAuth$zzb] */
    /* JADX WARNING: type inference failed for: r2v2, types: [com.google.firebase.auth.internal.zzad, com.google.firebase.auth.FirebaseAuth$zzb] */
    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.firebase.auth.internal.zzad, com.google.firebase.auth.FirebaseAuth$zzb] */
    public final Task<AuthResult> zzb(@NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(authCredential);
        if (!EmailAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            return authCredential instanceof PhoneAuthCredential ? this.zzec.zzc(this.zzdz, firebaseUser, authCredential, (zzad) new zzb()) : this.zzec.zzb(this.zzdz, firebaseUser, authCredential, (zzad) new zzb());
        }
        EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
        if (!"password".equals(emailAuthCredential.getSignInMethod())) {
            return this.zzec.zzb(this.zzdz, firebaseUser, emailAuthCredential, (zzad) new zzb());
        }
        return this.zzec.zzb(this.zzdz, firebaseUser, emailAuthCredential.getEmail(), emailAuthCredential.getPassword(), new zzb());
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.internal.zzad, com.google.firebase.auth.FirebaseAuth$zzb] */
    @NonNull
    public final Task<Void> zzb(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zzec.zzb(this.zzdz, firebaseUser, str, (zzad) new zzb());
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.internal.zzad, com.google.firebase.auth.FirebaseAuth$zzb] */
    @NonNull
    public final Task<AuthResult> zzc(@NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        return this.zzec.zzd(this.zzdz, firebaseUser, authCredential, (zzad) new zzb());
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.internal.zzad, com.google.firebase.auth.FirebaseAuth$zzb] */
    @NonNull
    public final Task<Void> zzc(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zzec.zzc(this.zzdz, firebaseUser, str, (zzad) new zzb());
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.firebase.auth.internal.zzad, com.google.firebase.auth.FirebaseAuth$zzb] */
    public final Task<Void> zzd(@NonNull FirebaseUser firebaseUser) {
        ? zzb2 = new zzb();
        Preconditions.checkNotNull(firebaseUser);
        return this.zzec.zza(this.zzdz, firebaseUser, (zzad) zzb2);
    }

    @NonNull
    public final Task<Void> zze(@NonNull FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        return this.zzec.zza(firebaseUser, (zzu) new zzn(this, firebaseUser));
    }

    public final void zzj() {
        if (this.zzed != null) {
            zzz zzz = this.zzeg;
            FirebaseUser firebaseUser = this.zzed;
            Preconditions.checkNotNull(firebaseUser);
            zzz.clear(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}));
            this.zzed = null;
        }
        this.zzeg.clear("com.google.firebase.auth.FIREBASE_USER");
        zzb((FirebaseUser) null);
        zzc((FirebaseUser) null);
    }
}
