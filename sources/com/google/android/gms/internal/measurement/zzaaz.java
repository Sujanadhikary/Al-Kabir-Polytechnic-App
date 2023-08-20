package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zzaaz extends zzaay<FieldDescriptorType, Object> {
    zzaaz(int i) {
        super(i, (zzaaz) null);
    }

    public final void zzrg() {
        if (!isImmutable()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= zzuj()) {
                    break;
                }
                Map.Entry zzah = zzah(i2);
                if (((zzzo) zzah.getKey()).zztk()) {
                    zzah.setValue(Collections.unmodifiableList((List) zzah.getValue()));
                }
                i = i2 + 1;
            }
            for (Map.Entry entry : zzuk()) {
                if (((zzzo) entry.getKey()).zztk()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzrg();
    }
}
