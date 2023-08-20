package com.p004my.alkabirin;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
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

/* renamed from: com.my.alkabirin.NeepageActivity */
public class NeepageActivity extends AppCompatActivity {
    private LinearLayout base;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private AlertDialog.Builder dialogue;
    private ImageView imageview1;
    /* access modifiers changed from: private */
    public Intent newpage = new Intent();
    private TextView textview1;
    private TextView textview2;
    private TextView textview3;
    private TextView textview4;
    private TextView textview5;
    /* access modifiers changed from: private */
    public Intent webpage = new Intent();

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
        setContentView(C0409R.layout.neepage);
        initialize(bundle);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.base = (LinearLayout) findViewById(C0409R.C0411id.base);
        this.imageview1 = (ImageView) findViewById(C0409R.C0411id.imageview1);
        this.textview2 = (TextView) findViewById(C0409R.C0411id.textview2);
        this.textview1 = (TextView) findViewById(C0409R.C0411id.textview1);
        this.button1 = (Button) findViewById(C0409R.C0411id.button1);
        this.button3 = (Button) findViewById(C0409R.C0411id.button3);
        this.button2 = (Button) findViewById(C0409R.C0411id.button2);
        this.button4 = (Button) findViewById(C0409R.C0411id.button4);
        this.textview3 = (TextView) findViewById(C0409R.C0411id.textview3);
        this.textview4 = (TextView) findViewById(C0409R.C0411id.textview4);
        this.button5 = (Button) findViewById(C0409R.C0411id.button5);
        this.textview5 = (TextView) findViewById(C0409R.C0411id.textview5);
        this.dialogue = new AlertDialog.Builder(this);
        this.button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NeepageActivity.this.webpage.setClass(NeepageActivity.this.getApplicationContext(), SyllabusActivity.class);
                NeepageActivity.this.startActivity(NeepageActivity.this.webpage);
            }
        });
        this.button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NeepageActivity.this.webpage.setClass(NeepageActivity.this.getApplicationContext(), UptadeActivity.class);
                NeepageActivity.this.startActivity(NeepageActivity.this.webpage);
            }
        });
        this.button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NeepageActivity.this.webpage.setClass(NeepageActivity.this.getApplicationContext(), WebpagemainActivity.class);
                NeepageActivity.this.startActivity(NeepageActivity.this.webpage);
            }
        });
        this.button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NeepageActivity.this.newpage.setClass(NeepageActivity.this.getApplicationContext(), AboutpageActivity.class);
                NeepageActivity.this.startActivity(NeepageActivity.this.newpage);
            }
        });
        this.button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NeepageActivity.this.newpage.setAction("android.intent.action.VIEW");
                NeepageActivity.this.newpage.setData(Uri.parse("http://m.p-y.tm/requestPayment?recipient=8789211749".concat("".concat("&amount=".concat("")))));
                NeepageActivity.this.startActivity(NeepageActivity.this.newpage);
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
        this.dialogue.setTitle("Do you really want to leave the app?");
        this.dialogue.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                NeepageActivity.this.finishAffinity();
            }
        });
        this.dialogue.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        this.dialogue.create().show();
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
