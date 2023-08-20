package com.p004my.alkabirin;

import android.app.Activity;
import android.content.Context;
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
import android.widget.ImageView;
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

/* renamed from: com.my.alkabirin.RegisterActivity */
public class RegisterActivity extends AppCompatActivity {
    /* access modifiers changed from: private */
    public OnCompleteListener<AuthResult> _auth_create_user_listener;
    private OnCompleteListener<Void> _auth_reset_password_listener;
    private OnCompleteListener<AuthResult> _auth_sign_in_listener;
    /* access modifiers changed from: private */
    public FirebaseAuth auth;
    private LinearLayout base;
    private Button button1;
    /* access modifiers changed from: private */
    public EditText edittext1;
    /* access modifiers changed from: private */
    public EditText edittext3;
    private ImageView imageview1;
    /* access modifiers changed from: private */
    public Intent intent = new Intent();
    private LinearLayout linear2;
    private LinearLayout linear4;
    private LinearLayout linear5;
    private LinearLayout linear6;
    private LinearLayout linear7;
    private LinearLayout linear8;
    private LinearLayout linear9;
    private TextView textview3;
    private TextView textview4;
    private TextView textview5;
    private TextView txt_email;

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ void startActivityForResult(Intent intent2, int i, Bundle bundle) {
        super.startActivityForResult(intent2, i, bundle);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent2, int i2, int i3, int i4) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent2, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent2, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i, intent2, i2, i3, i4, bundle);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0409R.layout.register);
        initialize(bundle);
        initializeLogic();
    }

    private void initialize(Bundle bundle) {
        this.base = (LinearLayout) findViewById(C0409R.C0411id.base);
        this.imageview1 = (ImageView) findViewById(C0409R.C0411id.imageview1);
        this.linear9 = (LinearLayout) findViewById(C0409R.C0411id.linear9);
        this.linear8 = (LinearLayout) findViewById(C0409R.C0411id.linear8);
        this.linear4 = (LinearLayout) findViewById(C0409R.C0411id.linear4);
        this.linear2 = (LinearLayout) findViewById(C0409R.C0411id.linear2);
        this.linear6 = (LinearLayout) findViewById(C0409R.C0411id.linear6);
        this.linear5 = (LinearLayout) findViewById(C0409R.C0411id.linear5);
        this.linear7 = (LinearLayout) findViewById(C0409R.C0411id.linear7);
        this.textview3 = (TextView) findViewById(C0409R.C0411id.textview3);
        this.textview4 = (TextView) findViewById(C0409R.C0411id.textview4);
        this.edittext3 = (EditText) findViewById(C0409R.C0411id.edittext3);
        this.txt_email = (TextView) findViewById(C0409R.C0411id.txt_email);
        this.edittext1 = (EditText) findViewById(C0409R.C0411id.edittext1);
        this.button1 = (Button) findViewById(C0409R.C0411id.button1);
        this.textview5 = (TextView) findViewById(C0409R.C0411id.textview5);
        this.auth = FirebaseAuth.getInstance();
        this.textview3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SketchwareUtil.showMessage(RegisterActivity.this.getApplicationContext(), "Please login");
                RegisterActivity.this.intent.setClass(RegisterActivity.this.getApplicationContext(), MainActivity.class);
                RegisterActivity.this.startActivity(RegisterActivity.this.intent);
            }
        });
        this.button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RegisterActivity.this.auth.createUserWithEmailAndPassword(RegisterActivity.this.edittext3.getText().toString(), RegisterActivity.this.edittext1.getText().toString()).addOnCompleteListener((Activity) RegisterActivity.this, RegisterActivity.this._auth_create_user_listener);
            }
        });
        this.textview5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RegisterActivity.this.intent.setClass(RegisterActivity.this.getApplicationContext(), ForgetpasswordActivity.class);
                RegisterActivity.this.startActivity(RegisterActivity.this.intent);
            }
        });
        this._auth_create_user_listener = new OnCompleteListener<AuthResult>() {
            public void onComplete(Task<AuthResult> task) {
                boolean isSuccessful = task.isSuccessful();
                String message = task.getException() != null ? task.getException().getMessage() : "";
                if (isSuccessful) {
                    RegisterActivity.this.finish();
                } else {
                    SketchwareUtil.showMessage(RegisterActivity.this.getApplicationContext(), message);
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
                task.isSuccessful();
            }
        };
    }

    private void initializeLogic() {
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent2) {
        super.onActivityResult(i, i2, intent2);
    }

    public void onBackPressed() {
        this.intent.setClass(getApplicationContext(), MainActivity.class);
        startActivity(this.intent);
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
