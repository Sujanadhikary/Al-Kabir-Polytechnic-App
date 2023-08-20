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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

/* renamed from: com.my.alkabirin.AlkabirinwebpageActivity */
public class AlkabirinwebpageActivity extends AppCompatActivity {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f27a = "";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f28b = "";
    /* access modifiers changed from: private */
    public Intent backhoga = new Intent();
    private Button button1;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f29c = "";
    /* access modifiers changed from: private */
    public Intent download = new Intent();
    private ImageView imageview1;
    private ImageView imageview2;
    private ImageView imageview3;
    private ImageView imageview4;
    private ImageView imageview5;
    private LinearLayout linear1;
    private LinearLayout linear4;
    private LinearLayout linear5;
    private LinearLayout linear6;
    private LinearLayout linear7;
    private LinearLayout linear8;
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
        setContentView(C0409R.layout.alkabirinwebpage);
        initialize(bundle);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.linear4 = (LinearLayout) findViewById(C0409R.C0411id.linear4);
        this.linear1 = (LinearLayout) findViewById(C0409R.C0411id.linear1);
        this.button1 = (Button) findViewById(C0409R.C0411id.button1);
        this.imageview1 = (ImageView) findViewById(C0409R.C0411id.imageview1);
        this.linear5 = (LinearLayout) findViewById(C0409R.C0411id.linear5);
        this.imageview2 = (ImageView) findViewById(C0409R.C0411id.imageview2);
        this.linear7 = (LinearLayout) findViewById(C0409R.C0411id.linear7);
        this.imageview3 = (ImageView) findViewById(C0409R.C0411id.imageview3);
        this.linear6 = (LinearLayout) findViewById(C0409R.C0411id.linear6);
        this.imageview4 = (ImageView) findViewById(C0409R.C0411id.imageview4);
        this.linear8 = (LinearLayout) findViewById(C0409R.C0411id.linear8);
        this.imageview5 = (ImageView) findViewById(C0409R.C0411id.imageview5);
        this.webview1 = (WebView) findViewById(C0409R.C0411id.webview1);
        this.webview1.getSettings().setJavaScriptEnabled(true);
        this.webview1.getSettings().setSupportZoom(true);
        this.button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlkabirinwebpageActivity.this.backhoga.setClass(AlkabirinwebpageActivity.this.getApplicationContext(), WebpagemainActivity.class);
                AlkabirinwebpageActivity.this.startActivity(AlkabirinwebpageActivity.this.backhoga);
            }
        });
        this.imageview1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlkabirinwebpageActivity.this.webview1.goBack();
            }
        });
        this.imageview2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlkabirinwebpageActivity.this.webview1.goForward();
            }
        });
        this.imageview3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlkabirinwebpageActivity.this.webview1.stopLoading();
            }
        });
        this.imageview4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlkabirinwebpageActivity.this.webview1.zoomIn();
            }
        });
        this.imageview5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlkabirinwebpageActivity.this.webview1.zoomOut();
            }
        });
        this.webview1.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                AlkabirinwebpageActivity.this.f27a = AlkabirinwebpageActivity.this.webview1.getUrl();
                AlkabirinwebpageActivity.this.f29c = str;
                super.onPageStarted(webView, str, bitmap);
            }

            public void onPageFinished(WebView webView, String str) {
                AlkabirinwebpageActivity.this.f28b = AlkabirinwebpageActivity.this.webview1.getUrl();
                if (AlkabirinwebpageActivity.this.f27a.equals(AlkabirinwebpageActivity.this.f28b) && !AlkabirinwebpageActivity.this.f29c.equals(AlkabirinwebpageActivity.this.f28b)) {
                    AlkabirinwebpageActivity.this.download.setAction("android.intent.action.VIEW");
                    AlkabirinwebpageActivity.this.download.setData(Uri.parse(AlkabirinwebpageActivity.this.f29c));
                    AlkabirinwebpageActivity.this.startActivity(AlkabirinwebpageActivity.this.download);
                }
                super.onPageFinished(webView, str);
            }
        });
    }

    private void initializeLogic() {
        SketchwareUtil.showMessage(getApplicationContext(), "Loading...");
        this.webview1.loadUrl("https://www.alkabir.in");
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
