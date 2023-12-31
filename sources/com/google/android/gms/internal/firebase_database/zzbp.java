package com.google.android.gms.internal.firebase_database;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

public final class zzbp extends Reader {
    private boolean closed;
    private List<String> zzgn;
    private int zzgo;
    private int zzgp;
    private int zzgq;
    private int zzgr;
    private boolean zzgs;

    public zzbp() {
        this.zzgn = null;
        this.closed = false;
        this.zzgq = this.zzgo;
        this.zzgr = this.zzgp;
        this.zzgs = false;
        this.zzgn = new ArrayList();
    }

    private final String zzbb() {
        if (this.zzgp < this.zzgn.size()) {
            return this.zzgn.get(this.zzgp);
        }
        return null;
    }

    private final int zzbc() {
        String zzbb = zzbb();
        if (zzbb == null) {
            return 0;
        }
        return zzbb.length() - this.zzgo;
    }

    private final void zzbd() throws IOException {
        if (this.closed) {
            throw new IOException("Stream already closed");
        } else if (!this.zzgs) {
            throw new IOException("Reader needs to be frozen before read operations can be called");
        }
    }

    private final long zzj(long j) {
        long j2 = 0;
        while (this.zzgp < this.zzgn.size() && j2 < j) {
            int zzbc = zzbc();
            long j3 = j - j2;
            if (j3 < ((long) zzbc)) {
                this.zzgo = (int) (((long) this.zzgo) + j3);
                j2 += j3;
            } else {
                j2 += (long) zzbc;
                this.zzgo = 0;
                this.zzgp++;
            }
        }
        return j2;
    }

    public final void close() throws IOException {
        zzbd();
        this.closed = true;
    }

    public final void mark(int i) throws IOException {
        zzbd();
        this.zzgq = this.zzgo;
        this.zzgr = this.zzgp;
    }

    public final boolean markSupported() {
        return true;
    }

    public final int read() throws IOException {
        zzbd();
        String zzbb = zzbb();
        if (zzbb == null) {
            return -1;
        }
        char charAt = zzbb.charAt(this.zzgo);
        zzj(1);
        return charAt;
    }

    public final int read(CharBuffer charBuffer) throws IOException {
        zzbd();
        int remaining = charBuffer.remaining();
        int i = 0;
        String zzbb = zzbb();
        while (remaining > 0 && zzbb != null) {
            int min = Math.min(zzbb.length() - this.zzgo, remaining);
            charBuffer.put(this.zzgn.get(this.zzgp), this.zzgo, this.zzgo + min);
            remaining -= min;
            i += min;
            zzj((long) min);
            zzbb = zzbb();
        }
        if (i > 0 || zzbb != null) {
            return i;
        }
        return -1;
    }

    public final int read(char[] cArr, int i, int i2) throws IOException {
        zzbd();
        int i3 = 0;
        String zzbb = zzbb();
        while (zzbb != null && i3 < i2) {
            int min = Math.min(zzbc(), i2 - i3);
            zzbb.getChars(this.zzgo, this.zzgo + min, cArr, i + i3);
            zzj((long) min);
            i3 += min;
            zzbb = zzbb();
        }
        if (i3 > 0 || zzbb != null) {
            return i3;
        }
        return -1;
    }

    public final boolean ready() throws IOException {
        zzbd();
        return true;
    }

    public final void reset() throws IOException {
        this.zzgo = this.zzgq;
        this.zzgp = this.zzgr;
    }

    public final long skip(long j) throws IOException {
        zzbd();
        return zzj(j);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String append : this.zzgn) {
            sb.append(append);
        }
        return sb.toString();
    }

    public final void zzba() {
        if (this.zzgs) {
            throw new IllegalStateException("Trying to freeze frozen StringListReader");
        }
        this.zzgs = true;
    }

    public final void zzn(String str) {
        if (this.zzgs) {
            throw new IllegalStateException("Trying to add string after reading");
        } else if (str.length() > 0) {
            this.zzgn.add(str);
        }
    }
}
