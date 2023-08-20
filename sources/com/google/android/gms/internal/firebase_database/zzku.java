package com.google.android.gms.internal.firebase_database;

import android.util.Log;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.PropertyName;
import com.google.firebase.database.ThrowOnExtraProperties;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

final class zzku<T> {
    /* access modifiers changed from: private */
    public final Class<T> zzuw;
    private final Constructor<T> zzux;
    private final boolean zzuy;
    private final boolean zzuz;
    private final Map<String, String> zzva;
    private final Map<String, Method> zzvb;
    private final Map<String, Method> zzvc;
    private final Map<String, Field> zzvd;

    public zzku(Class<T> cls) {
        Constructor<T> constructor;
        this.zzuw = cls;
        this.zzuy = cls.isAnnotationPresent(ThrowOnExtraProperties.class);
        this.zzuz = !cls.isAnnotationPresent(IgnoreExtraProperties.class);
        this.zzva = new HashMap();
        this.zzvc = new HashMap();
        this.zzvb = new HashMap();
        this.zzvd = new HashMap();
        try {
            constructor = cls.getDeclaredConstructor(new Class[0]);
            constructor.setAccessible(true);
        } catch (NoSuchMethodException e) {
            constructor = null;
        }
        this.zzux = constructor;
        for (Method method : cls.getMethods()) {
            if ((method.getName().startsWith("get") || method.getName().startsWith("is")) ? method.getDeclaringClass().equals(Object.class) ? false : !Modifier.isPublic(method.getModifiers()) ? false : Modifier.isStatic(method.getModifiers()) ? false : method.getReturnType().equals(Void.TYPE) ? false : method.getParameterTypes().length != 0 ? false : !method.isAnnotationPresent(Exclude.class) : false) {
                String zza = zza(method);
                zzae(zza);
                method.setAccessible(true);
                if (this.zzvb.containsKey(zza)) {
                    String valueOf = String.valueOf(method.getName());
                    throw new DatabaseException(valueOf.length() != 0 ? "Found conflicting getters for name: ".concat(valueOf) : new String("Found conflicting getters for name: "));
                }
                this.zzvb.put(zza, method);
            }
        }
        for (Field field : cls.getFields()) {
            if (field.getDeclaringClass().equals(Object.class) ? false : !Modifier.isPublic(field.getModifiers()) ? false : Modifier.isStatic(field.getModifiers()) ? false : Modifier.isTransient(field.getModifiers()) ? false : !field.isAnnotationPresent(Exclude.class)) {
                zzae(zza(field));
            }
        }
        Class<? super T> cls2 = cls;
        while (true) {
            for (Method method2 : cls2.getDeclaredMethods()) {
                if (!method2.getName().startsWith("set") ? false : method2.getDeclaringClass().equals(Object.class) ? false : Modifier.isStatic(method2.getModifiers()) ? false : !method2.getReturnType().equals(Void.TYPE) ? false : method2.getParameterTypes().length != 1 ? false : !method2.isAnnotationPresent(Exclude.class)) {
                    String zza2 = zza(method2);
                    String str = this.zzva.get(zza2.toLowerCase());
                    if (str == null) {
                        continue;
                    } else if (!str.equals(zza2)) {
                        String valueOf2 = String.valueOf(method2.getName());
                        throw new DatabaseException(valueOf2.length() != 0 ? "Found setter with invalid case-sensitive name: ".concat(valueOf2) : new String("Found setter with invalid case-sensitive name: "));
                    } else {
                        Method method3 = this.zzvc.get(zza2);
                        if (method3 == null) {
                            method2.setAccessible(true);
                            this.zzvc.put(zza2, method2);
                        } else {
                            zzkq.zza(method2.getDeclaringClass().isAssignableFrom(method3.getDeclaringClass()), "Expected override from a base class");
                            zzkq.zza(method2.getReturnType().equals(Void.TYPE), "Expected void return type");
                            zzkq.zza(method3.getReturnType().equals(Void.TYPE), "Expected void return type");
                            Class[] parameterTypes = method2.getParameterTypes();
                            Class[] parameterTypes2 = method3.getParameterTypes();
                            zzkq.zza(parameterTypes.length == 1, "Expected exactly one parameter");
                            zzkq.zza(parameterTypes2.length == 1, "Expected exactly one parameter");
                            if (!(method2.getName().equals(method3.getName()) && parameterTypes[0].equals(parameterTypes2[0]))) {
                                String name = method2.getName();
                                String name2 = method3.getName();
                                String name3 = method3.getDeclaringClass().getName();
                                throw new DatabaseException(new StringBuilder(String.valueOf(name).length() + 69 + String.valueOf(name2).length() + String.valueOf(name3).length()).append("Found a conflicting setters with name: ").append(name).append(" (conflicts with ").append(name2).append(" defined on ").append(name3).append(")").toString());
                            }
                        }
                    }
                }
            }
            for (Field field2 : cls2.getDeclaredFields()) {
                String zza3 = zza(field2);
                if (this.zzva.containsKey(zza3.toLowerCase()) && !this.zzvd.containsKey(zza3)) {
                    field2.setAccessible(true);
                    this.zzvd.put(zza3, field2);
                }
            }
            Class<? super T> superclass = cls2.getSuperclass();
            if (superclass != null && !superclass.equals(Object.class)) {
                cls2 = superclass;
            }
        }
        if (this.zzva.isEmpty()) {
            String valueOf3 = String.valueOf(cls.getName());
            throw new DatabaseException(valueOf3.length() != 0 ? "No properties to serialize found on class ".concat(valueOf3) : new String("No properties to serialize found on class "));
        }
    }

    private static String zza(AccessibleObject accessibleObject) {
        if (accessibleObject.isAnnotationPresent(PropertyName.class)) {
            return ((PropertyName) accessibleObject.getAnnotation(PropertyName.class)).value();
        }
        return null;
    }

    private static String zza(Field field) {
        String zza = zza((AccessibleObject) field);
        return zza != null ? zza : field.getName();
    }

    private static String zza(Method method) {
        String zza = zza((AccessibleObject) method);
        if (zza != null) {
            return zza;
        }
        String name = method.getName();
        String[] strArr = {"get", "set", "is"};
        String str = null;
        int i = 0;
        while (i < 3) {
            String str2 = strArr[i];
            if (!name.startsWith(str2)) {
                str2 = str;
            }
            i++;
            str = str2;
        }
        if (str == null) {
            String valueOf = String.valueOf(name);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unknown Bean prefix for method: ".concat(valueOf) : new String("Unknown Bean prefix for method: "));
        }
        char[] charArray = name.substring(str.length()).toCharArray();
        int i2 = 0;
        while (i2 < charArray.length && Character.isUpperCase(charArray[i2])) {
            charArray[i2] = Character.toLowerCase(charArray[i2]);
            i2++;
        }
        return new String(charArray);
    }

    private static Type zza(Type type, Map<TypeVariable<Class<T>>, Type> map) {
        if (!(type instanceof TypeVariable)) {
            return type;
        }
        Type type2 = map.get(type);
        if (type2 != null) {
            return type2;
        }
        String valueOf = String.valueOf(type);
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 23).append("Could not resolve type ").append(valueOf).toString());
    }

    private final void zzae(String str) {
        String put = this.zzva.put(str.toLowerCase(), str);
        if (put != null && !str.equals(put)) {
            String valueOf = String.valueOf(str.toLowerCase());
            throw new DatabaseException(valueOf.length() != 0 ? "Found two getters or fields with conflicting case sensitivity for property: ".concat(valueOf) : new String("Found two getters or fields with conflicting case sensitivity for property: "));
        }
    }

    public final T zza(Map<String, Object> map, Map<TypeVariable<Class<T>>, Type> map2) {
        if (this.zzux == null) {
            String name = this.zzuw.getName();
            throw new DatabaseException(new StringBuilder(String.valueOf(name).length() + 123).append("Class ").append(name).append(" does not define a no-argument constructor. If you are using ProGuard, make sure these constructors are not stripped.").toString());
        }
        try {
            T newInstance = this.zzux.newInstance(new Object[0]);
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                if (this.zzvc.containsKey(str)) {
                    Method method = this.zzvc.get(str);
                    Type[] genericParameterTypes = method.getGenericParameterTypes();
                    if (genericParameterTypes.length != 1) {
                        throw new IllegalStateException("Setter does not have exactly one parameter");
                    }
                    try {
                        method.invoke(newInstance, new Object[]{zzkt.zza(next.getValue(), zza(genericParameterTypes[0], map2))});
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e2) {
                        throw new RuntimeException(e2);
                    }
                } else if (this.zzvd.containsKey(str)) {
                    Field field = this.zzvd.get(str);
                    try {
                        field.set(newInstance, zzkt.zza(next.getValue(), zza(field.getGenericType(), map2)));
                    } catch (IllegalAccessException e3) {
                        throw new RuntimeException(e3);
                    }
                } else {
                    String name2 = this.zzuw.getName();
                    String sb = new StringBuilder(String.valueOf(str).length() + 36 + String.valueOf(name2).length()).append("No setter/field for ").append(str).append(" found on class ").append(name2).toString();
                    if (this.zzva.containsKey(str.toLowerCase())) {
                        sb = String.valueOf(sb).concat(" (fields/setters are case sensitive!)");
                    }
                    if (this.zzuy) {
                        throw new DatabaseException(sb);
                    } else if (this.zzuz) {
                        Log.w("ClassMapper", sb);
                    }
                }
            }
            return newInstance;
        } catch (InstantiationException e4) {
            throw new RuntimeException(e4);
        } catch (IllegalAccessException e5) {
            throw new RuntimeException(e5);
        } catch (InvocationTargetException e6) {
            throw new RuntimeException(e6);
        }
    }

    public final Map<String, Object> zzm(T t) {
        Object obj;
        if (!this.zzuw.isAssignableFrom(t.getClass())) {
            String valueOf = String.valueOf(t.getClass());
            String valueOf2 = String.valueOf(this.zzuw);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 59 + String.valueOf(valueOf2).length()).append("Can't serialize object of class ").append(valueOf).append(" with BeanMapper for class ").append(valueOf2).toString());
        }
        HashMap hashMap = new HashMap();
        for (String next : this.zzva.values()) {
            if (this.zzvb.containsKey(next)) {
                try {
                    obj = this.zzvb.get(next).invoke(t, new Object[0]);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e2) {
                    throw new RuntimeException(e2);
                }
            } else {
                Field field = this.zzvd.get(next);
                if (field == null) {
                    String valueOf3 = String.valueOf(next);
                    throw new IllegalStateException(valueOf3.length() != 0 ? "Bean property without field or getter:".concat(valueOf3) : new String("Bean property without field or getter:"));
                }
                try {
                    obj = field.get(t);
                } catch (IllegalAccessException e3) {
                    throw new RuntimeException(e3);
                }
            }
            hashMap.put(next, zzkt.zzi(obj));
        }
        return hashMap;
    }
}
