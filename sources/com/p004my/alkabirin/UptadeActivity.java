package com.p004my.alkabirin;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.support.p003v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

/* renamed from: com.my.alkabirin.UptadeActivity */
public class UptadeActivity extends AppCompatActivity {
    private Toolbar _toolbar;

    /* renamed from: a */
    private String f44a = "";

    /* renamed from: b */
    private String f45b = "";
    private Intent back12 = new Intent();
    private LinearLayout base;
    private Button button1;

    /* renamed from: c */
    private String f46c = "";
    /* access modifiers changed from: private */
    public Intent download = new Intent();
    private ImageView imageview1;
    private LinearLayout linear1;
    private LinearLayout linear2;
    private LinearLayout linear4;
    private LinearLayout linear5;
    private LinearLayout linear6;
    private LinearLayout linear7;
    private LinearLayout linear8;
    private LinearLayout linear9;
    private TextView textview1;
    private TextView textview2;
    private TextView textview3;
    private TextView textview4;

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
        setContentView(C0409R.layout.uptade);
        initialize(bundle);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this._toolbar = (Toolbar) findViewById(C0409R.C0411id._toolbar);
        setSupportActionBar(this._toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        this._toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UptadeActivity.this.onBackPressed();
            }
        });
        this.linear1 = (LinearLayout) findViewById(C0409R.C0411id.linear1);
        this.base = (LinearLayout) findViewById(C0409R.C0411id.base);
        this.imageview1 = (ImageView) findViewById(C0409R.C0411id.imageview1);
        this.textview2 = (TextView) findViewById(C0409R.C0411id.textview2);
        this.textview1 = (TextView) findViewById(C0409R.C0411id.textview1);
        this.linear9 = (LinearLayout) findViewById(C0409R.C0411id.linear9);
        this.linear8 = (LinearLayout) findViewById(C0409R.C0411id.linear8);
        this.linear4 = (LinearLayout) findViewById(C0409R.C0411id.linear4);
        this.linear2 = (LinearLayout) findViewById(C0409R.C0411id.linear2);
        this.linear6 = (LinearLayout) findViewById(C0409R.C0411id.linear6);
        this.linear5 = (LinearLayout) findViewById(C0409R.C0411id.linear5);
        this.linear7 = (LinearLayout) findViewById(C0409R.C0411id.linear7);
        this.button1 = (Button) findViewById(C0409R.C0411id.button1);
        this.textview3 = (TextView) findViewById(C0409R.C0411id.textview3);
        this.textview4 = (TextView) findViewById(C0409R.C0411id.textview4);
        this.button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SketchwareUtil.showMessage(UptadeActivity.this.getApplicationContext(), "Please Wait...");
                SketchwareUtil.showMessage(UptadeActivity.this.getApplicationContext(), "Please Wait...");
                UptadeActivity.this.download.setAction("android.intent.action.VIEW");
                UptadeActivity.this.download.setData(Uri.parse("https://drive.google.com/folderview?id=1-7N3AVf5BIVr0DjCKIR7-lYHeXW1el1c".concat("".concat("&amount=".concat("")))));
                UptadeActivity.this.startActivity(UptadeActivity.this.download);
            }
        });
    }

    private void initializeLogic() {
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        this.back12.setClass(getApplicationContext(), NeepageActivity.class);
        startActivity(this.back12);
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
