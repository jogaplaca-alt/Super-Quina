package ru.a402d.rawbtprinter;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.d;
import androidx.databinding.e;
import androidx.databinding.h;
import java.util.ArrayList;
import java.util.List;
import t2.f;
import t2.i;

/* JADX INFO: loaded from: classes.dex */
public class DataBinderMapperImpl extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f11262a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(3);
        f11262a = sparseIntArray;
        sparseIntArray.put(R.layout.fragment_editor, 1);
        sparseIntArray.put(R.layout.fragment_editor_bottom, 2);
        sparseIntArray.put(R.layout.fragment_file, 3);
    }

    @Override // androidx.databinding.d
    public List a() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.d
    public h b(e eVar, View view, int i3) {
        int i4 = f11262a.get(i3);
        if (i4 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        if (i4 == 1) {
            if ("layout/fragment_editor_0".equals(tag)) {
                return new t2.d(eVar, view);
            }
            throw new IllegalArgumentException("The tag for fragment_editor is invalid. Received: " + tag);
        }
        if (i4 == 2) {
            if ("layout/fragment_editor_bottom_0".equals(tag)) {
                return new f(eVar, view);
            }
            throw new IllegalArgumentException("The tag for fragment_editor_bottom is invalid. Received: " + tag);
        }
        if (i4 != 3) {
            return null;
        }
        if ("layout/fragment_file_0".equals(tag)) {
            return new i(eVar, view);
        }
        throw new IllegalArgumentException("The tag for fragment_file is invalid. Received: " + tag);
    }

    @Override // androidx.databinding.d
    public h c(e eVar, View[] viewArr, int i3) {
        if (viewArr == null || viewArr.length == 0 || f11262a.get(i3) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
