package com.google.firebase.database.collection;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Stack;

@KeepForSdk
public class ImmutableSortedMapIterator<K, V> implements Iterator<Map.Entry<K, V>> {
    private final Stack<LLRBValueNode<K, V>> zzi = new Stack<>();
    private final boolean zzj;

    ImmutableSortedMapIterator(LLRBNode<K, V> lLRBNode, K k, Comparator<K> comparator, boolean z) {
        this.zzj = z;
        LLRBNode<K, V> lLRBNode2 = lLRBNode;
        while (!lLRBNode2.isEmpty()) {
            int compare = k != null ? z ? comparator.compare(k, lLRBNode2.getKey()) : comparator.compare(lLRBNode2.getKey(), k) : 1;
            if (compare < 0) {
                if (!z) {
                    lLRBNode2 = lLRBNode2.getRight();
                }
            } else if (compare == 0) {
                this.zzi.push((LLRBValueNode) lLRBNode2);
                return;
            } else {
                this.zzi.push((LLRBValueNode) lLRBNode2);
                if (z) {
                    lLRBNode2 = lLRBNode2.getRight();
                }
            }
            lLRBNode2 = lLRBNode2.getLeft();
        }
    }

    @KeepForSdk
    public boolean hasNext() {
        return this.zzi.size() > 0;
    }

    @KeepForSdk
    public Map.Entry<K, V> next() {
        try {
            LLRBValueNode pop = this.zzi.pop();
            AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry(pop.getKey(), pop.getValue());
            if (this.zzj) {
                for (LLRBNode left = pop.getLeft(); !left.isEmpty(); left = left.getRight()) {
                    this.zzi.push((LLRBValueNode) left);
                }
            } else {
                for (LLRBNode right = pop.getRight(); !right.isEmpty(); right = right.getLeft()) {
                    this.zzi.push((LLRBValueNode) right);
                }
            }
            return simpleEntry;
        } catch (EmptyStackException e) {
            throw new NoSuchElementException();
        }
    }

    @KeepForSdk
    public void remove() {
        throw new UnsupportedOperationException("remove called on immutable collection");
    }
}
