package com.p004my.alkabirin;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import java.util.ArrayList;
import java.util.Random;

/* renamed from: com.my.alkabirin.ForgetpasswordActivity */
public class ForgetpasswordActivity extends AppCompatActivity {
    private OnCompleteListener<AuthResult> _auth_create_user_listener;
    private OnCompleteListener<Void> _auth_reset_password_listener;
    private OnCompleteListener<AuthResult> _auth_sign_in_listener;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f30a = "";
    private FirebaseAuth auth;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f31b = "";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f32c = "";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Intent f33e = new Intent();
    private LinearLayout linear11;
    private TextView textview2;
    /* access modifiers changed from: private */
    public WebView webview1;

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0409R.layout.forgetpassword);
        initialize(bundle);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.textview2 = (TextView) findViewById(C0409R.C0411id.textview2);
        this.linear11 = (LinearLayout) findViewById(C0409R.C0411id.linear11);
        this.webview1 = (WebView) findViewById(C0409R.C0411id.webview1);
        this.webview1.getSettings().setJavaScriptEnabled(true);
        this.webview1.getSettings().setSupportZoom(true);
        this.auth = FirebaseAuth.getInstance();
        this.webview1.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                ForgetpasswordActivity.this.f30a = ForgetpasswordActivity.this.webview1.getUrl();
                ForgetpasswordActivity.this.f32c = str;
                super.onPageStarted(webView, str, bitmap);
            }

            public void onPageFinished(WebView webView, String str) {
                ForgetpasswordActivity.this.f31b = ForgetpasswordActivity.this.webview1.getUrl();
                if (ForgetpasswordActivity.this.f30a.equals(ForgetpasswordActivity.this.f31b) && !ForgetpasswordActivity.this.f32c.equals(ForgetpasswordActivity.this.f31b)) {
                    ForgetpasswordActivity.this.f33e.setAction("android.intent.action.VIEW");
                    ForgetpasswordActivity.this.f33e.setData(Uri.parse(ForgetpasswordActivity.this.f32c));
                }
                super.onPageFinished(webView, str);
            }
        });
        this._auth_create_user_listener = new OnCompleteListener<AuthResult>() {
            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this._auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
            public void onComplete(Task<AuthResult> task) {
                task.isSuccessful();
                if (task.getException() != null) {
                    task.getException().getMessage();
                }
            }
        };
        this._auth_reset_password_listener = new OnCompleteListener<Void>() {
            public void onComplete(Task<Void> task) {
                if (task.isSuccessful()) {
                    SketchwareUtil.showMessage(ForgetpasswordActivity.this.getApplicationContext(), "Password reset email sent.");
                } else {
                    SketchwareUtil.showMessage(ForgetpasswordActivity.this.getApplicationContext(), "Error!!! Password reset email could not be sent.");
                }
            }
        };
    }

    private void initializeLogic() {
        SketchwareUtil.showMessage(getApplicationContext(), "Loading...");
        this.webview1.loadUrl("https://drive.google.com/folderview?id=1RGC4bVCZ0K4E4CH8-GH_N2qF1BVeqnoV");
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (this.webview1.canGoBack()) {
            this.webview1.goBack();
        } else {
            finish();
        }
    }

    @Deprecated
    public void showMessage(String str) {
        Toast.makeText(getApplicationContext(), str, 0).show();
    }

    @Deprecated
    public int getLocationX(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[0];
    }

    @Deprecated
    public int getLocationY(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[1];
    }

    @Deprecated
    public int getRandom(int i, int i2) {
        return new Random().nextInt((i2 - i) + 1) + i;
    }

    @Deprecated
    public ArrayList<Double> getCheckedItemPositionsToArray(ListView listView) {
        ArrayList<Double> arrayList = new ArrayList<>();
        SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
        for (int i = 0; i < checkedItemPositions.size(); i++) {
            if (checkedItemPositions.valueAt(i)) {
                arrayList.add(Double.valueOf((double) checkedItemPositions.keyAt(i)));
            }
        }
        return arrayList;
    }

    @Deprecated
    public float getDip(int i) {
        return TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    @Deprecated
    public int getDisplayWidthPixels() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    @Deprecated
    public int getDisplayHeightPixels() {
        return getResources().getDisplayMetrics().heightPixels;
    }
}
