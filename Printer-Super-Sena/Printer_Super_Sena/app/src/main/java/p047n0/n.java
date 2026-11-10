package p047n0;

import android.util.JsonReader;
import android.util.JsonToken;
import java.io.IOException;
import java.io.Reader;

/* JADX INFO: loaded from: classes.dex */
public abstract class n {
    static n a(long j3) {
        return new h(j3);
    }

    public static n b(Reader reader) throws IOException {
        JsonReader jsonReader = new JsonReader(reader);
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (jsonReader.nextName().equals("nextRequestWaitMillis")) {
                    if (jsonReader.peek() == JsonToken.STRING) {
                        n nVarA = a(Long.parseLong(jsonReader.nextString()));
                        jsonReader.close();
                        return nVarA;
                    }
                    n nVarA2 = a(jsonReader.nextLong());
                    jsonReader.close();
                    return nVarA2;
                }
                jsonReader.skipValue();
            }
            throw new IOException("Response is missing nextRequestWaitMillis field.");
        } catch (Throwable th) {
            jsonReader.close();
            throw th;
        }
    }

    public abstract long c();
}
