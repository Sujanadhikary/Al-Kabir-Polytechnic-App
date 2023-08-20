package com.google.firebase.auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.logging.Logger;

@SafeParcelable.Class(creator = "EmailAuthCredentialCreator")
public class EmailAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<EmailAuthCredential> CREATOR = new zzf();
    private static final Logger zzdv = new Logger("EmailAuthCredential", new String[0]);
    @SafeParcelable.Field(getter = "getEmail", mo8007id = 1)
    private String zzaf;
    @SafeParcelable.Field(getter = "getPassword", mo8007id = 2)
    private String zzbg;
    @SafeParcelable.Field(getter = "getSignInLink", mo8007id = 3)
    private final String zzdw;
    @SafeParcelable.Field(getter = "getCachedState", mo8007id = 4)
    private String zzdx;
    @SafeParcelable.Field(getter = "isForLinking", mo8007id = 5)
    private boolean zzdy;

    EmailAuthCredential(String str, String str2) {
        this(str, str2, (String) null, (String) null, false);
    }

    @SafeParcelable.Constructor
    EmailAuthCredential(@SafeParcelable.Param(mo8010id = 1) @NonNull String str, @SafeParcelable.Param(mo8010id = 2) @NonNull String str2, @SafeParcelable.Param(mo8010id = 3) @NonNull String str3, @SafeParcelable.Param(mo8010id = 4) @NonNull String str4, @SafeParcelable.Param(mo8010id = 5) @NonNull boolean z) {
        this.zzaf = Preconditions.checkNotEmpty(str);
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            this.zzbg = str2;
            this.zzdw = str3;
            this.zzdx = str4;
            this.zzdy = z;
            return;
        }
        throw new IllegalArgumentException("Cannot create an EmailAuthCredential without a password or emailLink.");
    }

    public static boolean isSignInWithEmailLink(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (!zzb(str)) {
                return zzb(Uri.parse(str).getQueryParameter("link"));
            }
            return true;
        } catch (UnsupportedOperationException e) {
            Logger logger = zzdv;
            Object[] objArr = new Object[1];
            String valueOf = String.valueOf(e.getMessage());
            objArr[0] = valueOf.length() != 0 ? "isSignInWithEmailLink returned an UnsupportedOperationException: ".concat(valueOf) : new String("isSignInWithEmailLink returned an UnsupportedOperationException: ");
            logger.mo8045v("EmailAuthCredential", objArr);
            return false;
        }
    }

    private static boolean zzb(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("oobCode");
        String queryParameter2 = parse.getQueryParameter("mode");
        return !TextUtils.isEmpty(queryParameter) && !TextUtils.isEmpty(queryParameter2) && queryParameter2.equals("signIn");
    }

    @NonNull
    public final String getEmail() {
        return this.zzaf;
    }

    @NonNull
    public final String getPassword() {
        return this.zzbg;
    }

    @NonNull
    public String getProvider() {
        return "password";
    }

    public String getSignInMethod() {
        return !TextUtils.isEmpty(this.zzbg) ? "password" : EmailAuthProvider.EMAIL_LINK_SIGN_IN_METHOD;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzaf, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzbg, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzdw, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzdx, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzdy);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final EmailAuthCredential zza(@Nullable FirebaseUser firebaseUser) {
        this.zzdx = firebaseUser.zzo();
        this.zzdy = true;
        return this;
    }

    @NonNull
    public final String zzf() {
        return this.zzdw;
    }

    @Nullable
    public final String zzg() {
        return this.zzdx;
    }

    public final boolean zzh() {
        return this.zzdy;
    }

    public final boolean zzi() {
        return !TextUtils.isEmpty(this.zzdw);
    }
}
