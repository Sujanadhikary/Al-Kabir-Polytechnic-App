package com.google.android.gms.internal.measurement;

import android.support.p003v7.app.AppCompatDelegate;
import java.io.IOException;

public final class zzabx extends IOException {
    zzabx(int i, int i2) {
        super(new StringBuilder(AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR).append("CodedOutputStream was writing to a flat byte array and ran out of space (pos ").append(i).append(" limit ").append(i2).append(").").toString());
    }
}
