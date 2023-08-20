package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzco;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class zzcz<T extends zzco> {
    private static final Logger logger = Logger.getLogger(zzci.class.getName());
    private static String zzqp = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    zzcz() {
    }

    static <T extends zzco> T zza(Class<T> cls) {
        String format;
        ClassLoader classLoader = zzcz.class.getClassLoader();
        if (cls.equals(zzco.class)) {
            format = zzqp;
        } else if (!cls.getPackage().equals(zzcz.class.getPackage())) {
            throw new IllegalArgumentException(cls.getName());
        } else {
            format = String.format("%s.BlazeGenerated%sLoader", new Object[]{cls.getPackage().getName(), cls.getSimpleName()});
        }
        try {
            return (zzco) cls.cast(((zzcz) Class.forName(format, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0])).zzdu());
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException(e3);
        } catch (InvocationTargetException e4) {
            throw new IllegalStateException(e4);
        } catch (ClassNotFoundException e5) {
            Iterator<S> it = ServiceLoader.load(zzcz.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    arrayList.add((zzco) cls.cast(((zzcz) it.next()).zzdu()));
                } catch (ServiceConfigurationError e6) {
                    Logger logger2 = logger;
                    Level level = Level.SEVERE;
                    String valueOf = String.valueOf(cls.getSimpleName());
                    logger2.logp(level, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", valueOf.length() != 0 ? "Unable to load ".concat(valueOf) : new String("Unable to load "), e6);
                }
            }
            if (arrayList.size() == 1) {
                return (zzco) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (zzco) cls.getMethod("combine", new Class[]{Collection.class}).invoke((Object) null, new Object[]{arrayList});
            } catch (NoSuchMethodException e7) {
                throw new IllegalStateException(e7);
            } catch (IllegalAccessException e8) {
                throw new IllegalStateException(e8);
            } catch (InvocationTargetException e9) {
                throw new IllegalStateException(e9);
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract T zzdu();
}
