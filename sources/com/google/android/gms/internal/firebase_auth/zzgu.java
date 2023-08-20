package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;

public final class zzgu extends IOException {
    public zzgu(String str) {
        super(str);
    }

    static zzgu zzhh() {
        return new zzgu("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzgu zzhi() {
        return new zzgu("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzgu zzhj() {
        return new zzgu("CodedInputStream encountered a malformed varint.");
    }
}
