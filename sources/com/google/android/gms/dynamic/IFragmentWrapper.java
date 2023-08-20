package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.p000v4.view.MotionEventCompat;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;

public interface IFragmentWrapper extends IInterface {

    public static abstract class Stub extends zzb implements IFragmentWrapper {

        public static class Proxy extends zza implements IFragmentWrapper {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IFragmentWrapper");
            }

            public IObjectWrapper getActivity() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }

            public Bundle getArguments() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken());
                Bundle bundle = (Bundle) zzc.zza(transactAndReadException, Bundle.CREATOR);
                transactAndReadException.recycle();
                return bundle;
            }

            public int getId() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken());
                int readInt = transactAndReadException.readInt();
                transactAndReadException.recycle();
                return readInt;
            }

            public IFragmentWrapper getParentFragment() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken());
                IFragmentWrapper asInterface = Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }

            public IObjectWrapper getResources() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(6, obtainAndWriteInterfaceToken());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }

            public boolean getRetainInstance() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(7, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                return zza;
            }

            public String getTag() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(8, obtainAndWriteInterfaceToken());
                String readString = transactAndReadException.readString();
                transactAndReadException.recycle();
                return readString;
            }

            public IFragmentWrapper getTargetFragment() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(9, obtainAndWriteInterfaceToken());
                IFragmentWrapper asInterface = Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }

            public int getTargetRequestCode() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(10, obtainAndWriteInterfaceToken());
                int readInt = transactAndReadException.readInt();
                transactAndReadException.recycle();
                return readInt;
            }

            public boolean getUserVisibleHint() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(11, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                return zza;
            }

            public IObjectWrapper getView() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(12, obtainAndWriteInterfaceToken());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                return asInterface;
            }

            public boolean isAdded() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(13, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                return zza;
            }

            public boolean isDetached() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(14, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                return zza;
            }

            public boolean isHidden() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(15, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                return zza;
            }

            public boolean isInLayout() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(16, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                return zza;
            }

            public boolean isRemoving() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(17, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                return zza;
            }

            public boolean isResumed() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(18, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                return zza;
            }

            public boolean isVisible() throws RemoteException {
                Parcel transactAndReadException = transactAndReadException(19, obtainAndWriteInterfaceToken());
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                return zza;
            }

            public void registerForContextMenu(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
                transactAndReadExceptionReturnVoid(20, obtainAndWriteInterfaceToken);
            }

            public void setHasOptionsMenu(boolean z) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(21, obtainAndWriteInterfaceToken);
            }

            public void setMenuVisibility(boolean z) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(22, obtainAndWriteInterfaceToken);
            }

            public void setRetainInstance(boolean z) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(23, obtainAndWriteInterfaceToken);
            }

            public void setUserVisibleHint(boolean z) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(24, obtainAndWriteInterfaceToken);
            }

            public void startActivity(Intent intent) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) intent);
                transactAndReadExceptionReturnVoid(25, obtainAndWriteInterfaceToken);
            }

            public void startActivityForResult(Intent intent, int i) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) intent);
                obtainAndWriteInterfaceToken.writeInt(i);
                transactAndReadExceptionReturnVoid(26, obtainAndWriteInterfaceToken);
            }

            public void unregisterForContextMenu(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
                transactAndReadExceptionReturnVoid(27, obtainAndWriteInterfaceToken);
            }
        }

        public Stub() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }

        public static IFragmentWrapper asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            return queryLocalInterface instanceof IFragmentWrapper ? (IFragmentWrapper) queryLocalInterface : new Proxy(iBinder);
        }

        /* access modifiers changed from: protected */
        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 2:
                    IObjectWrapper activity = getActivity();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, (IInterface) activity);
                    break;
                case 3:
                    Bundle arguments = getArguments();
                    parcel2.writeNoException();
                    zzc.zzb(parcel2, arguments);
                    break;
                case 4:
                    int id = getId();
                    parcel2.writeNoException();
                    parcel2.writeInt(id);
                    break;
                case 5:
                    IFragmentWrapper parentFragment = getParentFragment();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, (IInterface) parentFragment);
                    break;
                case 6:
                    IObjectWrapper resources = getResources();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, (IInterface) resources);
                    break;
                case 7:
                    boolean retainInstance = getRetainInstance();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, retainInstance);
                    break;
                case 8:
                    String tag = getTag();
                    parcel2.writeNoException();
                    parcel2.writeString(tag);
                    break;
                case 9:
                    IFragmentWrapper targetFragment = getTargetFragment();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, (IInterface) targetFragment);
                    break;
                case 10:
                    int targetRequestCode = getTargetRequestCode();
                    parcel2.writeNoException();
                    parcel2.writeInt(targetRequestCode);
                    break;
                case 11:
                    boolean userVisibleHint = getUserVisibleHint();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, userVisibleHint);
                    break;
                case 12:
                    IObjectWrapper view = getView();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, (IInterface) view);
                    break;
                case 13:
                    boolean isAdded = isAdded();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, isAdded);
                    break;
                case 14:
                    boolean isDetached = isDetached();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, isDetached);
                    break;
                case 15:
                    boolean isHidden = isHidden();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, isHidden);
                    break;
                case 16:
                    boolean isInLayout = isInLayout();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, isInLayout);
                    break;
                case 17:
                    boolean isRemoving = isRemoving();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, isRemoving);
                    break;
                case 18:
                    boolean isResumed = isResumed();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, isResumed);
                    break;
                case 19:
                    boolean isVisible = isVisible();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, isVisible);
                    break;
                case 20:
                    registerForContextMenu(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 21:
                    setHasOptionsMenu(zzc.zza(parcel));
                    parcel2.writeNoException();
                    break;
                case MotionEventCompat.AXIS_GAS:
                    setMenuVisibility(zzc.zza(parcel));
                    parcel2.writeNoException();
                    break;
                case 23:
                    setRetainInstance(zzc.zza(parcel));
                    parcel2.writeNoException();
                    break;
                case MotionEventCompat.AXIS_DISTANCE:
                    setUserVisibleHint(zzc.zza(parcel));
                    parcel2.writeNoException();
                    break;
                case 25:
                    startActivity((Intent) zzc.zza(parcel, Intent.CREATOR));
                    parcel2.writeNoException();
                    break;
                case MotionEventCompat.AXIS_SCROLL:
                    startActivityForResult((Intent) zzc.zza(parcel, Intent.CREATOR), parcel.readInt());
                    parcel2.writeNoException();
                    break;
                case MotionEventCompat.AXIS_RELATIVE_X:
                    unregisterForContextMenu(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    IObjectWrapper getActivity() throws RemoteException;

    Bundle getArguments() throws RemoteException;

    int getId() throws RemoteException;

    IFragmentWrapper getParentFragment() throws RemoteException;

    IObjectWrapper getResources() throws RemoteException;

    boolean getRetainInstance() throws RemoteException;

    String getTag() throws RemoteException;

    IFragmentWrapper getTargetFragment() throws RemoteException;

    int getTargetRequestCode() throws RemoteException;

    boolean getUserVisibleHint() throws RemoteException;

    IObjectWrapper getView() throws RemoteException;

    boolean isAdded() throws RemoteException;

    boolean isDetached() throws RemoteException;

    boolean isHidden() throws RemoteException;

    boolean isInLayout() throws RemoteException;

    boolean isRemoving() throws RemoteException;

    boolean isResumed() throws RemoteException;

    boolean isVisible() throws RemoteException;

    void registerForContextMenu(IObjectWrapper iObjectWrapper) throws RemoteException;

    void setHasOptionsMenu(boolean z) throws RemoteException;

    void setMenuVisibility(boolean z) throws RemoteException;

    void setRetainInstance(boolean z) throws RemoteException;

    void setUserVisibleHint(boolean z) throws RemoteException;

    void startActivity(Intent intent) throws RemoteException;

    void startActivityForResult(Intent intent, int i) throws RemoteException;

    void unregisterForContextMenu(IObjectWrapper iObjectWrapper) throws RemoteException;
}
