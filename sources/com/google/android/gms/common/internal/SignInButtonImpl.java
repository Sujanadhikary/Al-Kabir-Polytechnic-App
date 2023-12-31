package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.p000v4.graphics.drawable.DrawableCompat;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.base.C0366R;
import com.google.android.gms.common.util.DeviceProperties;

public final class SignInButtonImpl extends Button {
    public SignInButtonImpl(Context context) {
        this(context, (AttributeSet) null);
    }

    public SignInButtonImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    private static int zza(int i, int i2, int i3, int i4) {
        switch (i) {
            case 0:
                return i2;
            case 1:
                return i3;
            case 2:
                return i4;
            default:
                throw new IllegalStateException(new StringBuilder(33).append("Unknown color scheme: ").append(i).toString());
        }
    }

    public final void configure(Resources resources, int i, int i2) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        float f = resources.getDisplayMetrics().density;
        setMinHeight((int) ((f * 48.0f) + 0.5f));
        setMinWidth((int) ((f * 48.0f) + 0.5f));
        int zza = zza(i2, C0366R.C0367drawable.common_google_signin_btn_icon_dark, C0366R.C0367drawable.common_google_signin_btn_icon_light, C0366R.C0367drawable.common_google_signin_btn_icon_light);
        int zza2 = zza(i2, C0366R.C0367drawable.common_google_signin_btn_text_dark, C0366R.C0367drawable.common_google_signin_btn_text_light, C0366R.C0367drawable.common_google_signin_btn_text_light);
        switch (i) {
            case 0:
            case 1:
                break;
            case 2:
                zza2 = zza;
                break;
            default:
                throw new IllegalStateException(new StringBuilder(32).append("Unknown button size: ").append(i).toString());
        }
        Drawable wrap = DrawableCompat.wrap(resources.getDrawable(zza2));
        DrawableCompat.setTintList(wrap, resources.getColorStateList(C0366R.color.common_google_signin_btn_tint));
        DrawableCompat.setTintMode(wrap, PorterDuff.Mode.SRC_ATOP);
        setBackgroundDrawable(wrap);
        setTextColor((ColorStateList) Preconditions.checkNotNull(resources.getColorStateList(zza(i2, C0366R.color.common_google_signin_btn_text_dark, C0366R.color.common_google_signin_btn_text_light, C0366R.color.common_google_signin_btn_text_light))));
        switch (i) {
            case 0:
                setText(resources.getString(C0366R.string.common_signin_button_text));
                break;
            case 1:
                setText(resources.getString(C0366R.string.common_signin_button_text_long));
                break;
            case 2:
                setText((CharSequence) null);
                break;
            default:
                throw new IllegalStateException(new StringBuilder(32).append("Unknown button size: ").append(i).toString());
        }
        setTransformationMethod((TransformationMethod) null);
        if (DeviceProperties.isWearable(getContext())) {
            setGravity(19);
        }
    }

    public final void configure(Resources resources, SignInButtonConfig signInButtonConfig) {
        configure(resources, signInButtonConfig.getButtonSize(), signInButtonConfig.getColorScheme());
    }
}
