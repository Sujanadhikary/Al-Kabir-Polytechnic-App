package com.google.android.gms.internal.firebase_database;

import java.util.Collections;
import java.util.List;

public final class zzik {
    private final List<zzch> zzbz;
    private final List<String> zzca;

    private zzik(List<zzch> list, List<String> list2) {
        if (list.size() != list2.size() - 1) {
            throw new IllegalArgumentException("Number of posts need to be n-1 for n hashes in CompoundHash");
        }
        this.zzbz = list;
        this.zzca = list2;
    }

    /* access modifiers changed from: private */
    public static void zza(zzja zzja, zzim zzim) {
        if (zzja.zzfk()) {
            zzim.zzb((zziv<?>) (zziv) zzja);
        } else if (zzja.isEmpty()) {
            throw new IllegalArgumentException("Can't calculate hash on empty node!");
        } else if (!(zzja instanceof zzif)) {
            String valueOf = String.valueOf(zzja);
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Expected children node, but got: ").append(valueOf).toString());
        } else {
            ((zzif) zzja).zza((zzii) new zzil(zzim), true);
        }
    }

    public static zzik zzh(zzja zzja) {
        zzin zzin = new zzin(zzja);
        if (zzja.isEmpty()) {
            return new zzik(Collections.emptyList(), Collections.singletonList(""));
        }
        zzim zzim = new zzim(zzin);
        zza(zzja, zzim);
        zzim.zzft();
        return new zzik(zzim.zzrq, zzim.zzrr);
    }

    public final List<zzch> zzo() {
        return Collections.unmodifiableList(this.zzbz);
    }

    public final List<String> zzp() {
        return Collections.unmodifiableList(this.zzca);
    }
}
