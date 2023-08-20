package com.google.android.gms.internal.firebase_database;

import java.util.ArrayList;
import java.util.List;

final class zzjl implements zzjm {
    private List<byte[]> zzst = new ArrayList();
    private int zzsu = 0;

    zzjl() {
    }

    public final boolean zzb(byte[] bArr) {
        this.zzst.add(bArr);
        this.zzsu += bArr.length;
        return true;
    }

    public final zzjz zzgh() {
        byte[] bArr = new byte[this.zzsu];
        int i = 0;
        for (int i2 = 0; i2 < this.zzst.size(); i2++) {
            byte[] bArr2 = this.zzst.get(i2);
            System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
            i += bArr2.length;
        }
        return new zzjz(bArr);
    }
}
