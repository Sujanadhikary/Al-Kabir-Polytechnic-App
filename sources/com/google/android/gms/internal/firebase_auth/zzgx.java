package com.google.android.gms.internal.firebase_auth;

import java.util.Arrays;

final class zzgx {
    final int tag;
    final byte[] zzmj;

    zzgx(int i, byte[] bArr) {
        this.tag = i;
        this.zzmj = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgx)) {
            return false;
        }
        zzgx zzgx = (zzgx) obj;
        return this.tag == zzgx.tag && Arrays.equals(this.zzmj, zzgx.zzmj);
    }

    public final int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.zzmj);
    }
}
