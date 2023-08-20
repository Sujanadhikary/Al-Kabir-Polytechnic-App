package com.google.android.gms.common.net;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.security.PrivateKey;
import javax.net.SocketFactory;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class SSLCertificateSocketFactory extends SSLSocketFactory {
    private static final TrustManager[] zzvf = {new zza()};
    @VisibleForTesting
    private final Context mContext;
    @VisibleForTesting
    private SSLSocketFactory zzvg = null;
    @VisibleForTesting
    private SSLSocketFactory zzvh = null;
    @VisibleForTesting
    private TrustManager[] zzvi = null;
    @VisibleForTesting
    private KeyManager[] zzvj = null;
    @VisibleForTesting
    private byte[] zzvk = null;
    @VisibleForTesting
    private byte[] zzvl = null;
    @VisibleForTesting
    private PrivateKey zzvm = null;
    @VisibleForTesting
    private final int zzvn;
    @VisibleForTesting
    private final boolean zzvo;
    @VisibleForTesting
    private final boolean zzvp;
    @VisibleForTesting
    private final String zzvq;

    private SSLCertificateSocketFactory(Context context, int i, boolean z, boolean z2, String str) {
        this.mContext = context.getApplicationContext();
        this.zzvn = i;
        this.zzvo = z;
        this.zzvp = z2;
        this.zzvq = str;
    }

    public static SocketFactory getDefault(Context context, int i) {
        return new SSLCertificateSocketFactory(context, i, false, true, (String) null);
    }

    public static SSLSocketFactory getDefaultWithCacheDir(int i, Context context, String str) {
        return new SSLCertificateSocketFactory(context, i, true, true, str);
    }

    public static SSLSocketFactory getDefaultWithSessionCache(int i, Context context) {
        return new SSLCertificateSocketFactory(context, i, true, true, (String) null);
    }

    public static SSLSocketFactory getInsecure(Context context, int i, boolean z) {
        return new SSLCertificateSocketFactory(context, i, z, false, (String) null);
    }

    public static void verifyHostname(Socket socket, String str) throws IOException {
        if (!(socket instanceof SSLSocket)) {
            throw new IllegalArgumentException("Attempt to verify non-SSL socket");
        }
        SSLSocket sSLSocket = (SSLSocket) socket;
        sSLSocket.startHandshake();
        SSLSession session = sSLSocket.getSession();
        if (session == null) {
            throw new SSLException("Cannot verify SSL socket without session");
        } else if (!HttpsURLConnection.getDefaultHostnameVerifier().verify(str, session)) {
            String valueOf = String.valueOf(str);
            throw new SSLPeerUnverifiedException(valueOf.length() != 0 ? "Cannot verify hostname: ".concat(valueOf) : new String("Cannot verify hostname: "));
        }
    }

    @VisibleForTesting
    private static void zza(Socket socket, int i) {
        if (socket != null) {
            try {
                socket.getClass().getMethod("setHandshakeTimeout", new Class[]{Integer.TYPE}).invoke(socket, new Object[]{Integer.valueOf(i)});
            } catch (InvocationTargetException e) {
                InvocationTargetException invocationTargetException = e;
                Throwable cause = invocationTargetException.getCause();
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                String valueOf = String.valueOf(socket.getClass());
                throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 46).append("Failed to invoke setSocketHandshakeTimeout on ").append(valueOf).toString(), invocationTargetException);
            } catch (IllegalAccessException | NoSuchMethodException e2) {
                String valueOf2 = String.valueOf(socket.getClass());
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 45).append(valueOf2).append(" does not implement setSocketHandshakeTimeout").toString(), e2);
            }
        }
    }

    @VisibleForTesting
    private static void zza(Socket socket, PrivateKey privateKey) {
        if (socket != null) {
            try {
                socket.getClass().getMethod("setChannelIdPrivateKey", new Class[]{PrivateKey.class}).invoke(socket, new Object[]{privateKey});
            } catch (InvocationTargetException e) {
                InvocationTargetException invocationTargetException = e;
                Throwable cause = invocationTargetException.getCause();
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                String valueOf = String.valueOf(socket.getClass());
                throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 43).append("Failed to invoke setChannelIdPrivateKey on ").append(valueOf).toString(), invocationTargetException);
            } catch (IllegalAccessException | NoSuchMethodException e2) {
                String valueOf2 = String.valueOf(socket.getClass());
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 42).append(valueOf2).append(" does not implement setChannelIdPrivateKey").toString(), e2);
            }
        }
    }

    @VisibleForTesting
    private static void zza(Socket socket, byte[] bArr) {
        if (socket != null) {
            try {
                socket.getClass().getMethod("setNpnProtocols", new Class[]{byte[].class}).invoke(socket, new Object[]{bArr});
            } catch (InvocationTargetException e) {
                InvocationTargetException invocationTargetException = e;
                Throwable cause = invocationTargetException.getCause();
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                String valueOf = String.valueOf(socket.getClass());
                throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Failed to invoke setNpnProtocols on ").append(valueOf).toString(), invocationTargetException);
            } catch (IllegalAccessException | NoSuchMethodException e2) {
                String valueOf2 = String.valueOf(socket.getClass());
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 35).append(valueOf2).append(" does not implement setNpnProtocols").toString(), e2);
            }
        }
    }

    private static byte[] zza(byte[]... bArr) {
        if (bArr.length == 0) {
            throw new IllegalArgumentException("items.length == 0");
        }
        int i = 0;
        for (byte[] bArr2 : bArr) {
            if (bArr2.length == 0 || bArr2.length > 255) {
                throw new IllegalArgumentException(new StringBuilder(44).append("s.length == 0 || s.length > 255: ").append(bArr2.length).toString());
            }
            i += bArr2.length + 1;
        }
        byte[] bArr3 = new byte[i];
        int i2 = 0;
        for (byte[] bArr4 : bArr) {
            bArr3[i2] = (byte) bArr4.length;
            int length = bArr4.length;
            i2++;
            int i3 = 0;
            while (i3 < length) {
                bArr3[i2] = bArr4[i3];
                i3++;
                i2++;
            }
        }
        return bArr3;
    }

    @VisibleForTesting
    private static void zzb(Socket socket, byte[] bArr) {
        if (socket != null) {
            try {
                socket.getClass().getMethod("setAlpnProtocols", new Class[]{byte[].class}).invoke(socket, new Object[]{bArr});
            } catch (InvocationTargetException e) {
                InvocationTargetException invocationTargetException = e;
                Throwable cause = invocationTargetException.getCause();
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                String valueOf = String.valueOf(socket.getClass());
                throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 37).append("Failed to invoke setAlpnProtocols on ").append(valueOf).toString(), invocationTargetException);
            } catch (IllegalAccessException | NoSuchMethodException e2) {
                String valueOf2 = String.valueOf(socket.getClass());
                throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 36).append(valueOf2).append(" does not implement setAlpnProtocols").toString(), e2);
            }
        }
    }

    @VisibleForTesting
    private final synchronized SSLSocketFactory zzcx() {
        SSLSocketFactory sSLSocketFactory;
        if (!this.zzvp) {
            if (this.zzvg == null) {
                Log.w("SSLCertificateSocketFactory", "Bypassing SSL security checks at caller's request");
                this.zzvg = SocketFactoryCreator.getInstance().makeSocketFactory(this.mContext, this.zzvj, zzvf, this.zzvo);
            }
            sSLSocketFactory = this.zzvg;
        } else {
            if (this.zzvq != null) {
                if (this.zzvh == null) {
                    this.zzvh = SocketFactoryCreator.getInstance().makeSocketFactoryWithCacheDir(this.mContext, this.zzvj, this.zzvi, this.zzvq);
                }
            } else if (this.zzvh == null) {
                this.zzvh = SocketFactoryCreator.getInstance().makeSocketFactory(this.mContext, this.zzvj, this.zzvi, this.zzvo);
            }
            sSLSocketFactory = this.zzvh;
        }
        return sSLSocketFactory;
    }

    public Socket createSocket() throws IOException {
        Socket createSocket = zzcx().createSocket();
        zza(createSocket, this.zzvk);
        zzb(createSocket, this.zzvl);
        zza(createSocket, this.zzvn);
        zza(createSocket, this.zzvm);
        return createSocket;
    }

    public Socket createSocket(String str, int i) throws IOException {
        Socket createSocket = zzcx().createSocket(str, i);
        zza(createSocket, this.zzvk);
        zzb(createSocket, this.zzvl);
        zza(createSocket, this.zzvn);
        zza(createSocket, this.zzvm);
        if (this.zzvp) {
            verifyHostname(createSocket, str);
        }
        return createSocket;
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        Socket createSocket = zzcx().createSocket(str, i, inetAddress, i2);
        zza(createSocket, this.zzvk);
        zzb(createSocket, this.zzvl);
        zza(createSocket, this.zzvn);
        zza(createSocket, this.zzvm);
        if (this.zzvp) {
            verifyHostname(createSocket, str);
        }
        return createSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        Socket createSocket = zzcx().createSocket(inetAddress, i);
        zza(createSocket, this.zzvk);
        zzb(createSocket, this.zzvl);
        zza(createSocket, this.zzvn);
        zza(createSocket, this.zzvm);
        return createSocket;
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        Socket createSocket = zzcx().createSocket(inetAddress, i, inetAddress2, i2);
        zza(createSocket, this.zzvk);
        zzb(createSocket, this.zzvl);
        zza(createSocket, this.zzvn);
        zza(createSocket, this.zzvm);
        return createSocket;
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        Socket createSocket = zzcx().createSocket(socket, str, i, z);
        zza(createSocket, this.zzvk);
        zzb(createSocket, this.zzvl);
        zza(createSocket, this.zzvn);
        zza(createSocket, this.zzvm);
        if (this.zzvp) {
            verifyHostname(createSocket, str);
        }
        return createSocket;
    }

    public byte[] getAlpnSelectedProtocol(Socket socket) {
        try {
            return (byte[]) socket.getClass().getMethod("getAlpnSelectedProtocol", new Class[0]).invoke(socket, new Object[0]);
        } catch (InvocationTargetException e) {
            InvocationTargetException invocationTargetException = e;
            Throwable cause = invocationTargetException.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            String valueOf = String.valueOf(socket.getClass());
            throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 44).append("Failed to invoke getAlpnSelectedProtocol on ").append(valueOf).toString(), invocationTargetException);
        } catch (IllegalAccessException | NoSuchMethodException e2) {
            String valueOf2 = String.valueOf(socket.getClass());
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 43).append(valueOf2).append(" does not implement getAlpnSelectedProtocol").toString(), e2);
        }
    }

    public String[] getDefaultCipherSuites() {
        return zzcx().getDefaultCipherSuites();
    }

    public byte[] getNpnSelectedProtocol(Socket socket) {
        try {
            return (byte[]) socket.getClass().getMethod("getNpnSelectedProtocol", new Class[0]).invoke(socket, new Object[0]);
        } catch (InvocationTargetException e) {
            InvocationTargetException invocationTargetException = e;
            Throwable cause = invocationTargetException.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            String valueOf = String.valueOf(socket.getClass());
            throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 43).append("Failed to invoke getNpnSelectedProtocol on ").append(valueOf).toString(), invocationTargetException);
        } catch (IllegalAccessException | NoSuchMethodException e2) {
            String valueOf2 = String.valueOf(socket.getClass());
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 42).append(valueOf2).append(" does not implement getNpnSelectedProtocol").toString(), e2);
        }
    }

    public String[] getSupportedCipherSuites() {
        return zzcx().getSupportedCipherSuites();
    }

    public void setAlpnProtocols(byte[][] bArr) {
        this.zzvl = zza(bArr);
    }

    public void setChannelIdPrivateKey(PrivateKey privateKey) {
        this.zzvm = privateKey;
    }

    public void setHostname(Socket socket, String str) {
        try {
            socket.getClass().getMethod("setHostname", new Class[]{String.class}).invoke(socket, new Object[]{str});
        } catch (InvocationTargetException e) {
            InvocationTargetException invocationTargetException = e;
            Throwable cause = invocationTargetException.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            String valueOf = String.valueOf(socket.getClass());
            throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 32).append("Failed to invoke setHostname on ").append(valueOf).toString(), invocationTargetException);
        } catch (IllegalAccessException | NoSuchMethodException e2) {
            String valueOf2 = String.valueOf(socket.getClass());
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 31).append(valueOf2).append(" does not implement setHostname").toString(), e2);
        }
    }

    public void setKeyManagers(KeyManager[] keyManagerArr) {
        this.zzvj = keyManagerArr;
        this.zzvh = null;
        this.zzvg = null;
    }

    public void setNpnProtocols(byte[][] bArr) {
        this.zzvk = zza(bArr);
    }

    public void setSoWriteTimeout(Socket socket, int i) throws SocketException {
        try {
            socket.getClass().getMethod("setSoWriteTimeout", new Class[]{Integer.TYPE}).invoke(socket, new Object[]{Integer.valueOf(i)});
        } catch (InvocationTargetException e) {
            InvocationTargetException invocationTargetException = e;
            Throwable cause = invocationTargetException.getCause();
            if (cause instanceof SocketException) {
                throw ((SocketException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                String valueOf = String.valueOf(socket.getClass());
                throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 38).append("Failed to invoke setSoWriteTimeout on ").append(valueOf).toString(), invocationTargetException);
            }
        } catch (IllegalAccessException | NoSuchMethodException e2) {
            String valueOf2 = String.valueOf(socket.getClass());
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 37).append(valueOf2).append(" does not implement setSoWriteTimeout").toString(), e2);
        }
    }

    public void setTrustManagers(TrustManager[] trustManagerArr) {
        this.zzvi = trustManagerArr;
        this.zzvh = null;
    }

    public void setUseSessionTickets(Socket socket, boolean z) {
        try {
            socket.getClass().getMethod("setUseSessionTickets", new Class[]{Boolean.TYPE}).invoke(socket, new Object[]{Boolean.valueOf(z)});
        } catch (InvocationTargetException e) {
            InvocationTargetException invocationTargetException = e;
            Throwable cause = invocationTargetException.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            String valueOf = String.valueOf(socket.getClass());
            throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 41).append("Failed to invoke setUseSessionTickets on ").append(valueOf).toString(), invocationTargetException);
        } catch (IllegalAccessException | NoSuchMethodException e2) {
            String valueOf2 = String.valueOf(socket.getClass());
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf2).length() + 40).append(valueOf2).append(" does not implement setUseSessionTickets").toString(), e2);
        }
    }
}
