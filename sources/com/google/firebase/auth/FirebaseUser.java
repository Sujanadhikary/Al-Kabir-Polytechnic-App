package com.google.firebase.auth;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import java.util.List;

public abstract class FirebaseUser extends AbstractSafeParcelable implements UserInfo {
    @NonNull
    public Task<Void> delete() {
        return FirebaseAuth.getInstance(zzm()).zze(this);
    }

    @Nullable
    public abstract String getDisplayName();

    @Nullable
    public abstract String getEmail();

    @NonNull
    public Task<GetTokenResult> getIdToken(boolean z) {
        return FirebaseAuth.getInstance(zzm()).zza(this, z);
    }

    @Nullable
    public abstract FirebaseUserMetadata getMetadata();

    @Nullable
    public abstract String getPhoneNumber();

    @Nullable
    public abstract Uri getPhotoUrl();

    @NonNull
    public abstract List<? extends UserInfo> getProviderData();

    @NonNull
    public abstract String getProviderId();

    @Nullable
    public abstract List<String> getProviders();

    @Deprecated
    @NonNull
    public Task<GetTokenResult> getToken(boolean z) {
        return getIdToken(z);
    }

    @NonNull
    public abstract String getUid();

    public abstract boolean isAnonymous();

    @NonNull
    public Task<AuthResult> linkWithCredential(@NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        return FirebaseAuth.getInstance(zzm()).zzc(this, authCredential);
    }

    public Task<Void> reauthenticate(@NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        return FirebaseAuth.getInstance(zzm()).zza(this, authCredential);
    }

    public Task<AuthResult> reauthenticateAndRetrieveData(@NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        return FirebaseAuth.getInstance(zzm()).zzb(this, authCredential);
    }

    @NonNull
    public Task<Void> reload() {
        return FirebaseAuth.getInstance(zzm()).zzd(this);
    }

    @NonNull
    public Task<Void> sendEmailVerification() {
        return FirebaseAuth.getInstance(zzm()).zza(this, false).continueWithTask(new zzo(this));
    }

    @NonNull
    public Task<Void> sendEmailVerification(ActionCodeSettings actionCodeSettings) {
        return FirebaseAuth.getInstance(zzm()).zza(this, false).continueWithTask(new zzp(this, actionCodeSettings));
    }

    public Task<AuthResult> unlink(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return FirebaseAuth.getInstance(zzm()).zza(this, str);
    }

    @NonNull
    public Task<Void> updateEmail(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return FirebaseAuth.getInstance(zzm()).zzb(this, str);
    }

    @NonNull
    public Task<Void> updatePassword(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return FirebaseAuth.getInstance(zzm()).zzc(this, str);
    }

    public Task<Void> updatePhoneNumber(@NonNull PhoneAuthCredential phoneAuthCredential) {
        return FirebaseAuth.getInstance(zzm()).zza(this, phoneAuthCredential);
    }

    @NonNull
    public Task<Void> updateProfile(@NonNull UserProfileChangeRequest userProfileChangeRequest) {
        Preconditions.checkNotNull(userProfileChangeRequest);
        return FirebaseAuth.getInstance(zzm()).zza(this, userProfileChangeRequest);
    }

    @NonNull
    public abstract FirebaseUser zza(@NonNull List<? extends UserInfo> list);

    public abstract FirebaseUser zza(boolean z);

    public abstract void zza(@NonNull zzao zzao);

    @NonNull
    public abstract FirebaseApp zzm();

    @NonNull
    public abstract zzao zzn();

    @NonNull
    public abstract String zzo();

    @NonNull
    public abstract String zzp();
}
