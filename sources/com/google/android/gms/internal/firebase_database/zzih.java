package com.google.android.gms.internal.firebase_database;

import com.google.firebase.database.collection.LLRBNode;

final class zzih extends LLRBNode.NodeVisitor<zzid, zzja> {
    private boolean zzrg = false;
    private final /* synthetic */ zzii zzrh;
    private final /* synthetic */ zzif zzri;

    zzih(zzif zzif, zzii zzii) {
        this.zzri = zzif;
        this.zzrh = zzii;
    }

    public final /* synthetic */ void visitEntry(Object obj, Object obj2) {
        zzid zzid = (zzid) obj;
        zzja zzja = (zzja) obj2;
        if (!this.zzrg && zzid.compareTo(zzid.zzfe()) > 0) {
            this.zzrg = true;
            this.zzrh.visitEntry(zzid.zzfe(), this.zzri.zzfl());
        }
        this.zzrh.visitEntry(zzid, zzja);
    }
}
