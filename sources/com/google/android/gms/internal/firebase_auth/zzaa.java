package com.google.android.gms.internal.firebase_auth;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.api.internal.zzdp;
import java.util.Set;

public final class zzaa implements zzdp<zzj> {
    private static final Logger zzdv = new Logger("EmailLinkSignInRequest", new String[0]);
    private final String zzad;
    private final String zzaf;
    private final String zzdw;

    public zzaa(@NonNull EmailAuthCredential emailAuthCredential, @Nullable String str) {
        this.zzaf = Preconditions.checkNotEmpty(emailAuthCredential.getEmail());
        this.zzdw = Preconditions.checkNotEmpty(emailAuthCredential.zzf());
        this.zzad = str;
    }

    private static String zzi(String str) {
        Uri parse = Uri.parse(str);
        try {
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames.contains("oobCode")) {
                return parse.getQueryParameter("oobCode");
            }
            if (queryParameterNames.contains("link")) {
                return Uri.parse(parse.getQueryParameter("link")).getQueryParameter("oobCode");
            }
            return null;
        } catch (UnsupportedOperationException e) {
            Logger logger = zzdv;
            Object[] objArr = new Object[1];
            String valueOf = String.valueOf(e.getMessage());
            objArr[0] = valueOf.length() != 0 ? "No oobCode in signInLink: ".concat(valueOf) : new String("No oobCode in signInLink: ");
            logger.mo8045v("EmailLinkSignInRequest", objArr);
            return null;
        }
    }

    public final /* synthetic */ zzgv zzam() {
        zzj zzj = new zzj();
        zzj.zzaf = this.zzaf;
        zzj.zzae = zzi(this.zzdw);
        zzj.zzad = this.zzad;
        return zzj;
    }
}
