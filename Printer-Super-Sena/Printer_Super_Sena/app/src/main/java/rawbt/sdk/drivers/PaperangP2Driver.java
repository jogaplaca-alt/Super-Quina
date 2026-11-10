package rawbt.sdk.drivers;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.ArrayList;
import rawbt.api.attributes.AttributesImage;
import rawbt.sdk.dao.PrinterEntity;
import rawbt.sdk.drivers.responses.BatteryResponse;
import rawbt.sdk.drivers.responses.IResponse;
import rawbt.sdk.drivers.responses.ModelResponse;
import rawbt.sdk.drivers.responses.ModelVersionResponse;
import rawbt.sdk.drivers.responses.SerialNumberResponse;
import rawbt.sdk.drivers.responses.StatusResponse;
import rawbt.sdk.drivers.responses.WrongResponse;

/* JADX INFO: loaded from: classes.dex */
public class PaperangP2Driver extends PaperangP1Driver {
    public PaperangP2Driver(PrinterEntity printerEntity, Context context) {
        super(printerEntity, context);
    }

    private long crc32(byte[] bArr, int i3) {
        return crc32(896963873L, bArr, i3);
    }

    public static byte[] cutBytes(byte[] bArr, int i3, int i4) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, i3, bArr2, 0, i4);
        return bArr2;
    }

    public static ArrayList<IResponse> parseResponse(byte[] bArr) {
        int i3;
        ArrayList<IResponse> arrayList = new ArrayList<>();
        int length = bArr.length;
        int i4 = 0;
        while (i4 < length) {
            try {
                if (bArr[i4] == -91) {
                    i3 = bArr[i4 + 2] & (((bArr[i4 + 3] & 255) << 8) + 255);
                    try {
                        if (bArr[i4 + i3 + 8] != 90) {
                            arrayList.add(new WrongResponse());
                            return arrayList;
                        }
                        byte b3 = bArr[i4 + 4];
                        byte b4 = bArr[i4 + 5];
                        if (b3 != 1) {
                            if (b3 == 5 && b4 == 15) {
                                arrayList.add(new StatusResponse(0));
                            }
                        } else if (b4 == 2) {
                            arrayList.add(new SerialNumberResponse(new String(cutBytes(bArr, i4 + 12, (bArr[i4 + 10] & 255) + ((bArr[i4 + 11] & 255) << 8)))));
                        } else if (b4 == 7) {
                            arrayList.add(new ModelVersionResponse(new String(cutBytes(bArr, i4 + 12, (bArr[i4 + 10] & 255) + ((bArr[i4 + 11] & 255) << 8)))));
                            arrayList.add(new ModelResponse("Paperang (0xA5..0x5A)"));
                        } else if (b4 == 11 && bArr[i4 + 9] == 1) {
                            arrayList.add(new BatteryResponse(((bArr[i4 + 12] & 255) + ((bArr[i4 + 13] & 255) << 8)) / 10));
                        }
                    } catch (Exception unused) {
                        arrayList.add(new WrongResponse());
                    }
                } else {
                    arrayList.add(new WrongResponse());
                    i3 = length;
                }
            } catch (Exception unused2) {
                i3 = length;
            }
            i4 += i3 + 9;
        }
        return arrayList;
    }

    private void sendPacket(byte[] bArr) {
        try {
            int length = bArr.length;
            byte[] bArr2 = new byte[length + 9];
            bArr2[0] = -91;
            bArr2[1] = 1;
            bArr2[2] = (byte) (length & 255);
            bArr2[3] = (byte) ((length >>> 8) & 255);
            int i3 = 4;
            for (byte b3 : bArr) {
                bArr2[i3] = b3;
                i3++;
            }
            int iCrc32 = (int) crc32(bArr, length);
            bArr2[i3] = (byte) (iCrc32 & 255);
            bArr2[i3 + 1] = (byte) ((iCrc32 >>> 8) & 255);
            bArr2[i3 + 2] = (byte) ((iCrc32 >>> 16) & 255);
            bArr2[i3 + 3] = (byte) ((iCrc32 >>> 24) & 255);
            bArr2[i3 + 4] = 90;
            transport_write(bArr2);
        } catch (Exception e3) {
            e3.printStackTrace();
            transportError(e3.getLocalizedMessage());
        }
    }

    private void waitWhileDo() throws Exception {
        setStatus(-1);
        sendPacket(new byte[]{5, 15, 1, 0, 0, 0});
        long jCurrentTimeMillis = System.currentTimeMillis() + 10000;
        while (System.currentTimeMillis() < jCurrentTimeMillis && getStatus() == -1) {
            try {
                Thread.sleep(1L);
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
        }
        if (getStatus() != -1) {
            return;
        }
        setErrorMessage("Printer not response");
        throw new Exception("Printer not response");
    }

    @Override // rawbt.sdk.drivers.PaperangP1Driver, rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void finish() {
        sendPacket(new byte[]{5, 22, 1, 2, 0, 0, 0});
    }

    @Override // rawbt.sdk.drivers.PaperangP1Driver
    public void getBattery() {
        sendPacket(new byte[]{1, 11, 1, 0, 0});
    }

    @Override // rawbt.sdk.drivers.PaperangP1Driver
    public void getHardwareModel() {
    }

    @Override // rawbt.sdk.drivers.PaperangP1Driver
    public void getHardwareVersion() {
        sendPacket(new byte[]{1, 7, 1, 0, 0});
    }

    @Override // rawbt.sdk.drivers.PaperangP1Driver
    public void getSerialNumber() {
        sendPacket(new byte[]{1, 2, 1, 0, 0});
    }

    @Override // rawbt.sdk.drivers.PaperangP1Driver, rawbt.sdk.drivers.AbstractDriver
    public void graphics(byte[] bArr, int i3, int i4) throws Exception {
        int i5 = i3;
        char c3 = 2;
        waitWhileDo();
        int i6 = i5 / 8;
        int i7 = i4 * i6;
        byte[] bArr2 = new byte[i7];
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < i4; i10++) {
            for (int i11 = 0; i11 < i5; i11 += 8) {
                int i12 = i8 + i11;
                bArr2[i9] = (byte) (PaperangP1Driver.f11187p0[bArr[i12]] + PaperangP1Driver.f11188p1[bArr[i12 + 1]] + PaperangP1Driver.f11189p2[bArr[i12 + 2]] + PaperangP1Driver.p3[bArr[i12 + 3]] + PaperangP1Driver.p4[bArr[i12 + 4]] + PaperangP1Driver.p5[bArr[i12 + 5]] + PaperangP1Driver.p6[bArr[i12 + 6]] + bArr[i12 + 7]);
                i9++;
            }
            i8 += i5;
        }
        if (i5 >= 1024) {
            i5 = 1024;
        }
        int i13 = i7 / i5;
        int i14 = i7 % i5;
        sendPacket(new byte[]{5, 25, 1, 0, 0});
        int i15 = 0;
        int i16 = 1;
        int i17 = 0;
        while (i15 < i13) {
            byte[] bArr3 = new byte[i5 + 17];
            bArr3[0] = 5;
            bArr3[1] = 27;
            bArr3[c3] = 1;
            int i18 = i5 + 12;
            bArr3[3] = (byte) (i18 & 255);
            bArr3[4] = (byte) ((i18 >> 8) & 255);
            bArr3[5] = (byte) (i16 & 255);
            bArr3[6] = (byte) ((i16 >> 8) & 255);
            int i19 = i5 + 8;
            bArr3[7] = (byte) (i19 & 255);
            bArr3[8] = (byte) ((i19 >> 8) & 255);
            bArr3[9] = 1;
            bArr3[10] = (byte) i6;
            bArr3[11] = 0;
            bArr3[12] = 0;
            bArr3[13] = 0;
            bArr3[14] = 0;
            bArr3[15] = (byte) (i5 & 255);
            bArr3[16] = (byte) ((i5 >> 8) & 255);
            if (i5 >= 0) {
                System.arraycopy(bArr2, i17, bArr3, 17, i5);
            }
            sendPacket(bArr3);
            i16++;
            i17 += i5;
            waitWhileDo();
            i15++;
            c3 = 2;
        }
        if (i14 > 0) {
            byte[] bArr4 = new byte[i14 + 17];
            bArr4[0] = 5;
            bArr4[1] = 27;
            bArr4[2] = 3;
            int i20 = i14 + 12;
            bArr4[3] = (byte) (i20 & 255);
            bArr4[4] = (byte) ((i20 >> 8) & 255);
            bArr4[5] = (byte) (i16 & 255);
            bArr4[6] = (byte) ((i16 >> 8) & 255);
            int i21 = i14 + 8;
            bArr4[7] = (byte) (i21 & 255);
            bArr4[8] = (byte) ((i21 >> 8) & 255);
            bArr4[9] = 1;
            bArr4[10] = (byte) i6;
            bArr4[11] = 0;
            bArr4[12] = 0;
            bArr4[13] = 0;
            bArr4[14] = 0;
            bArr4[15] = (byte) (i14 & 255);
            bArr4[16] = (byte) ((i14 >> 8) & 255);
            System.arraycopy(bArr2, i17, bArr4, 17, i14);
            sendPacket(bArr4);
        }
        waitWhileDo();
    }

    @Override // rawbt.sdk.drivers.PaperangP1Driver, rawbt.sdk.transport.Transport.CallBack
    public void receiveFromDevice(byte[] bArr) {
        PosDriverInterface.TaskForTransport taskForTransport = this.jobTask;
        if (taskForTransport != null) {
            taskForTransport.receiveFromDevice(bArr);
        }
        for (IResponse iResponse : parseResponse(bArr)) {
            if (iResponse instanceof StatusResponse) {
                setStatus(((StatusResponse) iResponse).getStatus());
            }
        }
    }

    @Override // rawbt.sdk.drivers.PaperangP1Driver
    public void registerCrcKey() {
    }

    @Override // rawbt.sdk.drivers.PaperangP1Driver, rawbt.sdk.drivers.AbstractDriver, rawbt.sdk.drivers.PosDriverInterface
    public void scrollPaper(int i3) {
        if (i3 > 0) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.printerProfile.getDots_per_line(), i3 * 32, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.eraseColor(-1);
            printImage(bitmapCreateBitmap, new AttributesImage(0).setDoScale(false));
        }
    }

    @Override // rawbt.sdk.drivers.PaperangP1Driver
    public void setDensity(byte b3) {
        sendPacket(new byte[]{5, 17, 3, 2, 0, 95, 0});
    }

    @Override // rawbt.sdk.drivers.PaperangP1Driver
    public void setPaperType(byte b3) {
        sendPacket(new byte[]{5, 47, 1, 0, 0});
        sendPacket(new byte[]{5, 32, 3, 2, 0, 0, 0});
    }

    @Override // rawbt.sdk.drivers.PaperangP1Driver
    public void testPage() {
    }
}
