package F0;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: renamed from: F0.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC0215i extends IInterface {

    /* JADX INFO: renamed from: F0.i$a */
    public static abstract class a extends N0.b implements InterfaceC0215i {
        public static InterfaceC0215i d(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return iInterfaceQueryLocalInterface instanceof InterfaceC0215i ? (InterfaceC0215i) iInterfaceQueryLocalInterface : new j0(iBinder);
        }
    }

    Account a();
}
