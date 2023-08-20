package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.support.p000v4.util.SimpleArrayMap;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.zzi;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;

final class zzal {
    private static int zzbr = 0;
    private static PendingIntent zzcf;
    private final zzae zzal;
    @GuardedBy("responseCallbacks")
    private final SimpleArrayMap<String, TaskCompletionSource<Bundle>> zzcg = new SimpleArrayMap<>();
    private Messenger zzch;
    private Messenger zzci;
    private zzi zzcj;
    private final Context zzz;

    public zzal(Context context, zzae zzae) {
        this.zzz = context;
        this.zzal = zzae;
        this.zzch = new Messenger(new zzam(this, Looper.getMainLooper()));
    }

    private static synchronized void zza(Context context, Intent intent) {
        synchronized (zzal.class) {
            if (zzcf == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                zzcf = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", zzcf);
        }
    }

    private final void zza(String str, Bundle bundle) {
        synchronized (this.zzcg) {
            TaskCompletionSource remove = this.zzcg.remove(str);
            if (remove == null) {
                String valueOf = String.valueOf(str);
                Log.w("FirebaseInstanceId", valueOf.length() != 0 ? "Missing callback for ".concat(valueOf) : new String("Missing callback for "));
                return;
            }
            remove.setResult(bundle);
        }
    }

    private static synchronized String zzac() {
        String num;
        synchronized (zzal.class) {
            int i = zzbr;
            zzbr = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    /* access modifiers changed from: private */
    public final void zzb(Message message) {
        if (message == null || !(message.obj instanceof Intent)) {
            Log.w("FirebaseInstanceId", "Dropping invalid message");
            return;
        }
        Intent intent = (Intent) message.obj;
        intent.setExtrasClassLoader(new zzi.zza());
        if (intent.hasExtra("google.messenger")) {
            Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
            if (parcelableExtra instanceof zzi) {
                this.zzcj = (zzi) parcelableExtra;
            }
            if (parcelableExtra instanceof Messenger) {
                this.zzci = (Messenger) parcelableExtra;
            }
        }
        Intent intent2 = (Intent) message.obj;
        String action = intent2.getAction();
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
            String stringExtra = intent2.getStringExtra("registration_id");
            if (stringExtra == null) {
                stringExtra = intent2.getStringExtra("unregistered");
            }
            if (stringExtra == null) {
                String stringExtra2 = intent2.getStringExtra("error");
                if (stringExtra2 == null) {
                    String valueOf = String.valueOf(intent2.getExtras());
                    Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 49).append("Unexpected response, no error or registration id ").append(valueOf).toString());
                    return;
                }
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf2 = String.valueOf(stringExtra2);
                    Log.d("FirebaseInstanceId", valueOf2.length() != 0 ? "Received InstanceID error ".concat(valueOf2) : new String("Received InstanceID error "));
                }
                if (stringExtra2.startsWith("|")) {
                    String[] split = stringExtra2.split("\\|");
                    if (split.length <= 2 || !"ID".equals(split[1])) {
                        String valueOf3 = String.valueOf(stringExtra2);
                        Log.w("FirebaseInstanceId", valueOf3.length() != 0 ? "Unexpected structured response ".concat(valueOf3) : new String("Unexpected structured response "));
                        return;
                    }
                    String str = split[2];
                    String str2 = split[3];
                    if (str2.startsWith(":")) {
                        str2 = str2.substring(1);
                    }
                    zza(str, intent2.putExtra("error", str2).getExtras());
                    return;
                }
                synchronized (this.zzcg) {
                    for (int i = 0; i < this.zzcg.size(); i++) {
                        zza(this.zzcg.keyAt(i), intent2.getExtras());
                    }
                }
                return;
            }
            Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
            if (matcher.matches()) {
                String group = matcher.group(1);
                String group2 = matcher.group(2);
                Bundle extras = intent2.getExtras();
                extras.putString("registration_id", group2);
                zza(group, extras);
            } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf4 = String.valueOf(stringExtra);
                Log.d("FirebaseInstanceId", valueOf4.length() != 0 ? "Unexpected response string: ".concat(valueOf4) : new String("Unexpected response string: "));
            }
        } else if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf5 = String.valueOf(action);
            Log.d("FirebaseInstanceId", valueOf5.length() != 0 ? "Unexpected response action: ".concat(valueOf5) : new String("Unexpected response action: "));
        }
    }

    private final Bundle zzd(Bundle bundle) throws IOException {
        Bundle zze = zze(bundle);
        if (zze == null || !zze.containsKey("google.messenger")) {
            return zze;
        }
        Bundle zze2 = zze(bundle);
        if (zze2 == null || !zze2.containsKey("google.messenger")) {
            return zze2;
        }
        return null;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private final android.os.Bundle zze(android.os.Bundle r10) throws java.io.IOException {
        /*
            r9 = this;
            r8 = 3
            r7 = 2
            java.lang.String r1 = zzac()
            com.google.android.gms.tasks.TaskCompletionSource r0 = new com.google.android.gms.tasks.TaskCompletionSource
            r0.<init>()
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r2 = r9.zzcg
            monitor-enter(r2)
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r3 = r9.zzcg     // Catch:{ all -> 0x0024 }
            r3.put(r1, r0)     // Catch:{ all -> 0x0024 }
            monitor-exit(r2)     // Catch:{ all -> 0x0024 }
            com.google.firebase.iid.zzae r2 = r9.zzal
            int r2 = r2.zzx()
            if (r2 != 0) goto L_0x0027
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "MISSING_INSTANCEID_SERVICE"
            r0.<init>(r1)
            throw r0
        L_0x0024:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0024 }
            throw r0
        L_0x0027:
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            java.lang.String r3 = "com.google.android.gms"
            r2.setPackage(r3)
            com.google.firebase.iid.zzae r3 = r9.zzal
            int r3 = r3.zzx()
            if (r3 != r7) goto L_0x00d6
            java.lang.String r3 = "com.google.iid.TOKEN_REQUEST"
            r2.setAction(r3)
        L_0x003e:
            r2.putExtras(r10)
            android.content.Context r3 = r9.zzz
            zza((android.content.Context) r3, (android.content.Intent) r2)
            java.lang.String r3 = "kid"
            java.lang.String r4 = java.lang.String.valueOf(r1)
            int r4 = r4.length()
            int r4 = r4 + 5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r4)
            java.lang.String r4 = "|ID|"
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.StringBuilder r4 = r4.append(r1)
            java.lang.String r5 = "|"
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            r2.putExtra(r3, r4)
            java.lang.String r3 = "FirebaseInstanceId"
            boolean r3 = android.util.Log.isLoggable(r3, r8)
            if (r3 == 0) goto L_0x00a0
            java.lang.String r3 = "FirebaseInstanceId"
            android.os.Bundle r4 = r2.getExtras()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r5 = java.lang.String.valueOf(r4)
            int r5 = r5.length()
            int r5 = r5 + 8
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "Sending "
            java.lang.StringBuilder r5 = r6.append(r5)
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.String r4 = r4.toString()
            android.util.Log.d(r3, r4)
        L_0x00a0:
            java.lang.String r3 = "google.messenger"
            android.os.Messenger r4 = r9.zzch
            r2.putExtra(r3, r4)
            android.os.Messenger r3 = r9.zzci
            if (r3 != 0) goto L_0x00af
            com.google.firebase.iid.zzi r3 = r9.zzcj
            if (r3 == 0) goto L_0x00f3
        L_0x00af:
            android.os.Message r3 = android.os.Message.obtain()
            r3.obj = r2
            android.os.Messenger r4 = r9.zzci     // Catch:{ RemoteException -> 0x00e3 }
            if (r4 == 0) goto L_0x00dd
            android.os.Messenger r4 = r9.zzci     // Catch:{ RemoteException -> 0x00e3 }
            r4.send(r3)     // Catch:{ RemoteException -> 0x00e3 }
        L_0x00be:
            com.google.android.gms.tasks.Task r0 = r0.getTask()     // Catch:{ InterruptedException -> 0x010a, TimeoutException -> 0x012f, ExecutionException -> 0x0125 }
            r2 = 30000(0x7530, double:1.4822E-319)
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x010a, TimeoutException -> 0x012f, ExecutionException -> 0x0125 }
            java.lang.Object r0 = com.google.android.gms.tasks.Tasks.await(r0, r2, r4)     // Catch:{ InterruptedException -> 0x010a, TimeoutException -> 0x012f, ExecutionException -> 0x0125 }
            android.os.Bundle r0 = (android.os.Bundle) r0     // Catch:{ InterruptedException -> 0x010a, TimeoutException -> 0x012f, ExecutionException -> 0x0125 }
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r2 = r9.zzcg
            monitor-enter(r2)
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r3 = r9.zzcg     // Catch:{ all -> 0x0107 }
            r3.remove(r1)     // Catch:{ all -> 0x0107 }
            monitor-exit(r2)     // Catch:{ all -> 0x0107 }
            return r0
        L_0x00d6:
            java.lang.String r3 = "com.google.android.c2dm.intent.REGISTER"
            r2.setAction(r3)
            goto L_0x003e
        L_0x00dd:
            com.google.firebase.iid.zzi r4 = r9.zzcj     // Catch:{ RemoteException -> 0x00e3 }
            r4.send(r3)     // Catch:{ RemoteException -> 0x00e3 }
            goto L_0x00be
        L_0x00e3:
            r3 = move-exception
            java.lang.String r3 = "FirebaseInstanceId"
            boolean r3 = android.util.Log.isLoggable(r3, r8)
            if (r3 == 0) goto L_0x00f3
            java.lang.String r3 = "FirebaseInstanceId"
            java.lang.String r4 = "Messenger failed, fallback to startService"
            android.util.Log.d(r3, r4)
        L_0x00f3:
            com.google.firebase.iid.zzae r3 = r9.zzal
            int r3 = r3.zzx()
            if (r3 != r7) goto L_0x0101
            android.content.Context r3 = r9.zzz
            r3.sendBroadcast(r2)
            goto L_0x00be
        L_0x0101:
            android.content.Context r3 = r9.zzz
            r3.startService(r2)
            goto L_0x00be
        L_0x0107:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0107 }
            throw r0
        L_0x010a:
            r0 = move-exception
        L_0x010b:
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r2 = "No response"
            android.util.Log.w(r0, r2)     // Catch:{ all -> 0x011a }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x011a }
            java.lang.String r2 = "TIMEOUT"
            r0.<init>(r2)     // Catch:{ all -> 0x011a }
            throw r0     // Catch:{ all -> 0x011a }
        L_0x011a:
            r0 = move-exception
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r2 = r9.zzcg
            monitor-enter(r2)
            android.support.v4.util.SimpleArrayMap<java.lang.String, com.google.android.gms.tasks.TaskCompletionSource<android.os.Bundle>> r3 = r9.zzcg     // Catch:{ all -> 0x012c }
            r3.remove(r1)     // Catch:{ all -> 0x012c }
            monitor-exit(r2)     // Catch:{ all -> 0x012c }
            throw r0
        L_0x0125:
            r0 = move-exception
            java.io.IOException r2 = new java.io.IOException     // Catch:{ all -> 0x011a }
            r2.<init>(r0)     // Catch:{ all -> 0x011a }
            throw r2     // Catch:{ all -> 0x011a }
        L_0x012c:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x012c }
            throw r0
        L_0x012f:
            r0 = move-exception
            goto L_0x010b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzal.zze(android.os.Bundle):android.os.Bundle");
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzc(Bundle bundle) throws IOException {
        if (this.zzal.zzaa() < 12000000) {
            return zzd(bundle);
        }
        try {
            return (Bundle) Tasks.await(zzs.zzc(this.zzz).zzb(1, bundle));
        } catch (InterruptedException | ExecutionException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e);
                Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 22).append("Error making request: ").append(valueOf).toString());
            }
            if (!(e.getCause() instanceof zzac) || ((zzac) e.getCause()).getErrorCode() != 4) {
                return null;
            }
            return zzd(bundle);
        }
    }
}
