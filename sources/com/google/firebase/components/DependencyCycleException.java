package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;

@KeepForSdk
public class DependencyCycleException extends DependencyException {
    private final List<Component<?>> zzap;

    /* JADX WARNING: Illegal instructions before constructor call */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DependencyCycleException(java.util.List<com.google.firebase.components.Component<?>> r4) {
        /*
            r3 = this;
            java.lang.String r1 = "Dependency cycle detected: "
            java.lang.Object[] r0 = r4.toArray()
            java.lang.String r0 = java.util.Arrays.toString(r0)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r2 = r0.length()
            if (r2 == 0) goto L_0x001e
            java.lang.String r0 = r1.concat(r0)
        L_0x0018:
            r3.<init>(r0)
            r3.zzap = r4
            return
        L_0x001e:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r1)
            goto L_0x0018
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.DependencyCycleException.<init>(java.util.List):void");
    }

    @KeepForSdk
    public List<Component<?>> getComponentsInCycle() {
        return this.zzap;
    }
}
