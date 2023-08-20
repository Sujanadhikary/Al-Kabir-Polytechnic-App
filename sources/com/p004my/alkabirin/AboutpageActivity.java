package com.p004my.alkabirin;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

/* renamed from: com.my.alkabirin.AboutpageActivity */
public class AboutpageActivity extends AppCompatActivity {
    private LinearLayout base;
    private LinearLayout center_container;
    private TextView dial_menu_name;
    private ImageView facebook;
    private LinearLayout linear2;
    private LinearLayout linear3;
    private ScrollView scroll;
    private LinearLayout scroll_container;
    private LinearLayout sp_r1_c1;
    private LinearLayout sp_r1_c2;
    private LinearLayout sp_r1_c4;
    private LinearLayout sp_r_1;
    private LinearLayout speed_dials;
    private TextView textview1;
    private TextView textview10;
    private TextView textview11;
    private TextView textview12;
    private TextView textview13;
    private TextView textview14;
    private TextView textview15;
    private TextView textview16;
    private TextView textview17;
    private TextView textview18;
    private TextView textview19;
    private TextView textview2;
    private TextView textview20;
    private TextView textview21;
    private TextView textview22;
    private TextView textview24;
    private TextView textview25;
    private TextView textview26;
    private TextView textview27;
    private TextView textview28;
    private TextView textview29;
    private TextView textview3;
    private TextView textview30;
    private TextView textview31;
    private TextView textview32;
    private TextView textview33;
    private TextView textview34;
    private TextView textview35;
    private TextView textview36;
    private TextView textview37;
    private TextView textview4;
    private TextView textview5;
    private TextView textview6;
    private TextView textview7;
    private TextView textview8;
    private ImageView twitter;
    private ImageView youtube;

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
        setContentView(C0409R.layout.aboutpage);
        initialize(bundle);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.base = (LinearLayout) findViewById(C0409R.C0411id.base);
        this.center_container = (LinearLayout) findViewById(C0409R.C0411id.center_container);
        this.scroll = (ScrollView) findViewById(C0409R.C0411id.scroll);
        this.scroll_container = (LinearLayout) findViewById(C0409R.C0411id.scroll_container);
        this.speed_dials = (LinearLayout) findViewById(C0409R.C0411id.speed_dials);
        this.dial_menu_name = (TextView) findViewById(C0409R.C0411id.dial_menu_name);
        this.sp_r_1 = (LinearLayout) findViewById(C0409R.C0411id.sp_r_1);
        this.linear2 = (LinearLayout) findViewById(C0409R.C0411id.linear2);
        this.textview10 = (TextView) findViewById(C0409R.C0411id.textview10);
        this.textview8 = (TextView) findViewById(C0409R.C0411id.textview8);
        this.textview7 = (TextView) findViewById(C0409R.C0411id.textview7);
        this.linear3 = (LinearLayout) findViewById(C0409R.C0411id.linear3);
        this.sp_r1_c1 = (LinearLayout) findViewById(C0409R.C0411id.sp_r1_c1);
        this.sp_r1_c2 = (LinearLayout) findViewById(C0409R.C0411id.sp_r1_c2);
        this.sp_r1_c4 = (LinearLayout) findViewById(C0409R.C0411id.sp_r1_c4);
        this.facebook = (ImageView) findViewById(C0409R.C0411id.facebook);
        this.textview1 = (TextView) findViewById(C0409R.C0411id.textview1);
        this.twitter = (ImageView) findViewById(C0409R.C0411id.twitter);
        this.textview3 = (TextView) findViewById(C0409R.C0411id.textview3);
        this.youtube = (ImageView) findViewById(C0409R.C0411id.youtube);
        this.textview2 = (TextView) findViewById(C0409R.C0411id.textview2);
        this.textview5 = (TextView) findViewById(C0409R.C0411id.textview5);
        this.textview4 = (TextView) findViewById(C0409R.C0411id.textview4);
        this.textview6 = (TextView) findViewById(C0409R.C0411id.textview6);
        this.textview11 = (TextView) findViewById(C0409R.C0411id.textview11);
        this.textview12 = (TextView) findViewById(C0409R.C0411id.textview12);
        this.textview13 = (TextView) findViewById(C0409R.C0411id.textview13);
        this.textview14 = (TextView) findViewById(C0409R.C0411id.textview14);
        this.textview15 = (TextView) findViewById(C0409R.C0411id.textview15);
        this.textview16 = (TextView) findViewById(C0409R.C0411id.textview16);
        this.textview17 = (TextView) findViewById(C0409R.C0411id.textview17);
        this.textview18 = (TextView) findViewById(C0409R.C0411id.textview18);
        this.textview19 = (TextView) findViewById(C0409R.C0411id.textview19);
        this.textview20 = (TextView) findViewById(C0409R.C0411id.textview20);
        this.textview21 = (TextView) findViewById(C0409R.C0411id.textview21);
        this.textview22 = (TextView) findViewById(C0409R.C0411id.textview22);
        this.textview24 = (TextView) findViewById(C0409R.C0411id.textview24);
        this.textview25 = (TextView) findViewById(C0409R.C0411id.textview25);
        this.textview26 = (TextView) findViewById(C0409R.C0411id.textview26);
        this.textview27 = (TextView) findViewById(C0409R.C0411id.textview27);
        this.textview28 = (TextView) findViewById(C0409R.C0411id.textview28);
        this.textview29 = (TextView) findViewById(C0409R.C0411id.textview29);
        this.textview30 = (TextView) findViewById(C0409R.C0411id.textview30);
        this.textview31 = (TextView) findViewById(C0409R.C0411id.textview31);
        this.textview32 = (TextView) findViewById(C0409R.C0411id.textview32);
        this.textview33 = (TextView) findViewById(C0409R.C0411id.textview33);
        this.textview34 = (TextView) findViewById(C0409R.C0411id.textview34);
        this.textview35 = (TextView) findViewById(C0409R.C0411id.textview35);
        this.textview36 = (TextView) findViewById(C0409R.C0411id.textview36);
        this.textview37 = (TextView) findViewById(C0409R.C0411id.textview37);
        this.facebook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
    }

    private void initializeLogic() {
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
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
