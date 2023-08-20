package com.google.firebase.database.collection;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.database.collection.LLRBNode;

@KeepForSdk
public class LLRBBlackValueNode<K, V> extends LLRBValueNode<K, V> {
    private int size = -1;

    LLRBBlackValueNode(K k, V v, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        super(k, v, lLRBNode, lLRBNode2);
    }

    @KeepForSdk
    public boolean isRed() {
        return false;
    }

    @KeepForSdk
    public int size() {
        if (this.size == -1) {
            this.size = getLeft().size() + 1 + getRight().size();
        }
        return this.size;
    }

    /* access modifiers changed from: protected */
    public final LLRBNode.Color zza() {
        return LLRBNode.Color.BLACK;
    }

    /* access modifiers changed from: protected */
    public final LLRBValueNode<K, V> zza(K k, V v, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        if (k == null) {
            k = getKey();
        }
        if (v == null) {
            v = getValue();
        }
        if (lLRBNode == null) {
            lLRBNode = getLeft();
        }
        if (lLRBNode2 == null) {
            lLRBNode2 = getRight();
        }
        return new LLRBBlackValueNode(k, v, lLRBNode, lLRBNode2);
    }

    /* access modifiers changed from: package-private */
    public final void zza(LLRBNode<K, V> lLRBNode) {
        if (this.size != -1) {
            throw new IllegalStateException("Can't set left after using size");
        }
        super.zza(lLRBNode);
    }
}
