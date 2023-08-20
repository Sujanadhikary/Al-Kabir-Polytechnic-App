package com.google.android.gms.internal.firebase_auth;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zzfb extends zzfa<FieldDescriptorType, Object> {
    zzfb(int i) {
        super(i, (zzfb) null);
    }

    public final void zzbp() {
        if (!isImmutable()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= zzgg()) {
                    break;
                }
                Map.Entry zzau = zzau(i2);
                if (((zzcu) zzau.getKey()).zzds()) {
                    zzau.setValue(Collections.unmodifiableList((List) zzau.getValue()));
                }
                i = i2 + 1;
            }
            for (Map.Entry entry : zzgh()) {
                if (((zzcu) entry.getKey()).zzds()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzbp();
    }
}
