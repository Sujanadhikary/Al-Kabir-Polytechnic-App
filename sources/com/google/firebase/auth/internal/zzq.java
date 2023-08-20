package com.google.firebase.auth.internal;

import com.google.firebase.auth.SignInMethodQueryResult;
import java.util.List;

public final class zzq implements SignInMethodQueryResult {
    private final List<String> zzjc;

    public zzq(List<String> list) {
        this.zzjc = list;
    }

    public final List<String> getSignInMethods() {
        return this.zzjc;
    }
}
