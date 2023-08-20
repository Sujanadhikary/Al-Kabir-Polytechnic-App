package com.google.android.gms.internal.firebase_database;

import com.google.firebase.database.Logger;

final /* synthetic */ class zzcd {
    static final /* synthetic */ int[] zzhn = new int[Logger.Level.values().length];

    static {
        try {
            zzhn[Logger.Level.DEBUG.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            zzhn[Logger.Level.INFO.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            zzhn[Logger.Level.WARN.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            zzhn[Logger.Level.ERROR.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            zzhn[Logger.Level.NONE.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
