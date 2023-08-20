package com.p004my.alkabirin;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

/* renamed from: com.my.alkabirin.MainActivity */
public class MainActivity extends AppCompatActivity {
    /* access modifiers changed from: private */
    public Intent Newpage = new Intent();
    private OnCompleteListener<AuthResult> _auth_create_user_listener;
    private OnCompleteListener<Void> _auth_reset_password_listener;
    /* access modifiers changed from: private */
    public OnCompleteListener<AuthResult> _auth_sign_in_listener;
    /* access modifiers changed from: private */
    public FirebaseAuth auth;
    private Button button1;
    private AlertDialog.Builder dialogue;
    /* access modifiers changed from: private */
    public EditText edittext1;
    /* access modifiers changed from: private */
    public EditText edittext2;
    private LinearLayout linear4;
    private LinearLayout linear5;
    private TextView textview1;
    private TextView textview3;
    private TextView textview4;
    private TextView textview5;

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
        setContentView(C0409R.layout.main);
        initialize(bundle);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.linear4 = (LinearLayout) findViewById(C0409R.C0411id.linear4);
        this.linear5 = (LinearLayout) findViewById(C0409R.C0411id.linear5);
        this.textview3 = (TextView) findViewById(C0409R.C0411id.textview3);
        this.edittext1 = (EditText) findViewById(C0409R.C0411id.edittext1);
        this.textview4 = (TextView) findViewById(C0409R.C0411id.textview4);
        this.edittext2 = (EditText) findViewById(C0409R.C0411id.edittext2);
        this.button1 = (Button) findViewById(C0409R.C0411id.button1);
        this.textview5 = (TextView) findViewById(C0409R.C0411id.textview5);
        this.textview1 = (TextView) findViewById(C0409R.C0411id.textview1);
        this.dialogue = new AlertDialog.Builder(this);
        this.auth = FirebaseAuth.getInstance();
        this.button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.auth.signInWithEmailAndPassword(MainActivity.this.edittext1.getText().toString(), MainActivity.this.edittext2.getText().toString()).addOnCompleteListener((Activity) MainActivity.this, MainActivity.this._auth_sign_in_listener);
            }
        });
        this.textview5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.Newpage.setClass(MainActivity.this.getApplicationContext(), ForgetpasswordActivity.class);
                MainActivity.this.startActivity(MainActivity.this.Newpage);
            }
        });
        this.textview1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.Newpage.setClass(MainActivity.this.getApplicationContext(), RegisterActivity.class);
                MainActivity.this.startActivity(MainActivity.this.Newpage);
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
                boolean isSuccessful = task.isSuccessful();
                String message = task.getException() != null ? task.getException().getMessage() : "";
                if (isSuccessful) {
                    MainActivity.this.Newpage.setClass(MainActivity.this.getApplicationContext(), NeepageActivity.class);
                    MainActivity.this.startActivity(MainActivity.this.Newpage);
                    return;
                }
                SketchwareUtil.showMessage(MainActivity.this.getApplicationContext(), message);
            }
        };
        this._auth_reset_password_listener = new OnCompleteListener<Void>() {
            public void onComplete(Task<Void> task) {
                task.isSuccessful();
            }
        };
    }

    private void initializeLogic() {
        this.Newpage.setClass(getApplicationContext(), NeepageActivity.class);
        startActivity(this.Newpage);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        this.dialogue.setTitle("Do you really want to leave the app?");
        this.dialogue.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finishAffinity();
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
