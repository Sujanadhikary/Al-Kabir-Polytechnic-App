package com.google.firebase.auth.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.firebase_auth.zzbf;

@KeepName
public class FederatedSignInActivity extends FragmentActivity {
    private static boolean zzlj = false;
    private boolean zzlk = false;

    private final void zza(int i, Intent intent) {
        zzlj = false;
        setResult(-1, intent);
        finish();
    }

    private final void zze(int i) {
        zzlj = false;
        this.zzlk = false;
        setResult(0);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if (!"com.google.firebase.auth.internal.SIGN_IN".equals(action) && !"com.google.firebase.auth.internal.GET_CRED".equals(action)) {
            String valueOf = String.valueOf(action);
            Log.e("IdpSignInActivity", valueOf.length() != 0 ? "Unknown action: ".concat(valueOf) : new String("Unknown action: "));
            setResult(0);
            finish();
        } else if (zzlj) {
            setResult(0);
            finish();
        } else {
            zzlj = true;
            if (bundle != null) {
                this.zzlk = bundle.getBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN");
            }
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        boolean z;
        super.onResume();
        if (!this.zzlk) {
            Intent intent = new Intent("com.google.firebase.auth.api.gms.ui.START_WEB_SIGN_IN");
            intent.setPackage("com.google.android.gms");
            intent.putExtras(getIntent().getExtras());
            intent.putExtra("com.google.firebase.auth.internal.OPERATION", getIntent().getAction());
            try {
                startActivityForResult(intent, 40963);
            } catch (ActivityNotFoundException e) {
                Log.w("IdpSignInActivity", "Could not launch web sign-in Intent. Google Play service is unavailable");
                zze(0);
            }
            this.zzlk = true;
            return;
        }
        Intent intent2 = getIntent();
        if ("com.google.firebase.auth.internal.WEB_SIGN_IN_FAILED".equals(intent2.getAction())) {
            Log.e("IdpSignInActivity", "Web sign-in failed, finishing");
            if (zzae.zza(intent2)) {
                Status zzb = zzae.zzb(intent2);
                zzlj = false;
                Intent intent3 = new Intent();
                zzae.zza(intent3, zzb);
                setResult(-1, intent3);
                finish();
                z = true;
            } else {
                zze(0);
                z = true;
            }
        } else if (!intent2.hasExtra("com.google.firebase.auth.internal.OPERATION") || !intent2.hasExtra("com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST")) {
            z = false;
        } else {
            String stringExtra = intent2.getStringExtra("com.google.firebase.auth.internal.OPERATION");
            if ("com.google.firebase.auth.internal.SIGN_IN".equals(stringExtra)) {
                Intent intent4 = new Intent();
                SafeParcelableSerializer.serializeToIntentExtra((zzbf) SafeParcelableSerializer.deserializeFromIntentExtra(intent2, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST", zzbf.CREATOR), intent4, "com.google.firebase.auth.internal.CREDENTIAL_FOR_AUTH_RESULT");
                zza(-1, intent4);
                z = true;
            } else if ("com.google.firebase.auth.internal.GET_CRED".equals(stringExtra)) {
                Intent intent5 = new Intent();
                intent5.putExtra("com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST", intent2.getByteArrayExtra("com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST"));
                zza(-1, intent5);
                z = true;
            } else {
                z = false;
            }
        }
        if (!z) {
            zze(0);
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN", this.zzlk);
    }
}
