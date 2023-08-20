package com.p004my.alkabirin;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.support.p003v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

/* renamed from: com.my.alkabirin.WebpagemainActivity */
public class WebpagemainActivity extends AppCompatActivity {
    private Toolbar _toolbar;
    private LinearLayout base;
    private Button button2;
    private Button button3;
    private Button button4;
    /* access modifiers changed from: private */
    public Intent change = new Intent();
    private LinearLayout linear1;
    private LinearLayout linear2;
    private LinearLayout linear3;
    private TextView textview1;

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
        setContentView(C0409R.layout.webpagemain);
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
                WebpagemainActivity.this.onBackPressed();
            }
        });
        this.base = (LinearLayout) findViewById(C0409R.C0411id.base);
        this.button2 = (Button) findViewById(C0409R.C0411id.button2);
        this.button3 = (Button) findViewById(C0409R.C0411id.button3);
        this.button4 = (Button) findViewById(C0409R.C0411id.button4);
        this.linear1 = (LinearLayout) findViewById(C0409R.C0411id.linear1);
        this.linear2 = (LinearLayout) findViewById(C0409R.C0411id.linear2);
        this.linear3 = (LinearLayout) findViewById(C0409R.C0411id.linear3);
        this.textview1 = (TextView) findViewById(C0409R.C0411id.textview1);
        this.button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WebpagemainActivity.this.change.setClass(WebpagemainActivity.this.getApplicationContext(), AlkabirinwebpageActivity.class);
                WebpagemainActivity.this.startActivity(WebpagemainActivity.this.change);
            }
        });
        this.button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WebpagemainActivity.this.change.setClass(WebpagemainActivity.this.getApplicationContext(), SbtewebpageActivity.class);
                WebpagemainActivity.this.startActivity(WebpagemainActivity.this.change);
            }
        });
        this.button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WebpagemainActivity.this.change.setClass(WebpagemainActivity.this.getApplicationContext(), GyanjyotiActivity.class);
                WebpagemainActivity.this.startActivity(WebpagemainActivity.this.change);
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
        this.change.setClass(getApplicationContext(), NeepageActivity.class);
        startActivity(this.change);
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
