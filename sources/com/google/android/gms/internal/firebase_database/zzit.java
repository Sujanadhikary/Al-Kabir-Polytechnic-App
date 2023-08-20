package com.google.android.gms.internal.firebase_database;

import com.google.firebase.database.collection.ImmutableSortedSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public final class zzit implements Iterable<zziz> {
    private static final ImmutableSortedSet<zziz> zzrx = new ImmutableSortedSet<>(Collections.emptyList(), (Comparator) null);
    private final zzis zzpe;
    private final zzja zzry;
    private ImmutableSortedSet<zziz> zzrz;

    private zzit(zzja zzja, zzis zzis) {
        this.zzpe = zzis;
        this.zzry = zzja;
        this.zzrz = null;
    }

    private zzit(zzja zzja, zzis zzis, ImmutableSortedSet<zziz> immutableSortedSet) {
        this.zzpe = zzis;
        this.zzry = zzja;
        this.zzrz = immutableSortedSet;
    }

    public static zzit zza(zzja zzja, zzis zzis) {
        return new zzit(zzja, zzis);
    }

    private final void zzfy() {
        if (this.zzrz == null) {
            if (!this.zzpe.equals(zziu.zzgb())) {
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                for (zziz zziz : this.zzry) {
                    z = z || this.zzpe.zzi(zziz.zzd());
                    arrayList.add(new zziz(zziz.zzge(), zziz.zzd()));
                }
                if (z) {
                    this.zzrz = new ImmutableSortedSet<>(arrayList, this.zzpe);
                    return;
                }
            }
            this.zzrz = zzrx;
        }
    }

    public static zzit zzj(zzja zzja) {
        return new zzit(zzja, zzjf.zzgf());
    }

    public final Iterator<zziz> iterator() {
        zzfy();
        return this.zzrz == zzrx ? this.zzry.iterator() : this.zzrz.iterator();
    }

    public final Iterator<zziz> reverseIterator() {
        zzfy();
        return this.zzrz == zzrx ? this.zzry.reverseIterator() : this.zzrz.reverseIterator();
    }

    public final zzid zza(zzid zzid, zzja zzja, zzis zzis) {
        if (this.zzpe.equals(zziu.zzgb()) || this.zzpe.equals(zzis)) {
            zzfy();
            if (this.zzrz == zzrx) {
                return this.zzry.zzl(zzid);
            }
            zziz predecessorEntry = this.zzrz.getPredecessorEntry(new zziz(zzid, zzja));
            if (predecessorEntry != null) {
                return predecessorEntry.zzge();
            }
            return null;
        }
        throw new IllegalArgumentException("Index not available in IndexedNode!");
    }

    public final zzja zzd() {
        return this.zzry;
    }

    public final zziz zzfz() {
        if (!(this.zzry instanceof zzif)) {
            return null;
        }
        zzfy();
        if (this.zzrz != zzrx) {
            return this.zzrz.getMinEntry();
        }
        zzid zzfm = ((zzif) this.zzry).zzfm();
        return new zziz(zzfm, this.zzry.zzm(zzfm));
    }

    public final zzit zzg(zzid zzid, zzja zzja) {
        zzja zze = this.zzry.zze(zzid, zzja);
        if (this.zzrz == zzrx && !this.zzpe.zzi(zzja)) {
            return new zzit(zze, this.zzpe, zzrx);
        }
        if (this.zzrz == null || this.zzrz == zzrx) {
            return new zzit(zze, this.zzpe, (ImmutableSortedSet<zziz>) null);
        }
        ImmutableSortedSet<zziz> remove = this.zzrz.remove(new zziz(zzid, this.zzry.zzm(zzid)));
        if (!zzja.isEmpty()) {
            remove = remove.insert(new zziz(zzid, zzja));
        }
        return new zzit(zze, this.zzpe, remove);
    }

    public final zziz zzga() {
        if (!(this.zzry instanceof zzif)) {
            return null;
        }
        zzfy();
        if (this.zzrz != zzrx) {
            return this.zzrz.getMaxEntry();
        }
        zzid zzfn = ((zzif) this.zzry).zzfn();
        return new zziz(zzfn, this.zzry.zzm(zzfn));
    }

    public final zzit zzk(zzja zzja) {
        return new zzit(this.zzry.zzf(zzja), this.zzpe, this.zzrz);
    }
}
