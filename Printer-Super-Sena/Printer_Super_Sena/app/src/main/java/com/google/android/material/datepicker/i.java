package com.google.android.material.datepicker;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
class i extends BaseAdapter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f8048d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Calendar f8049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f8050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f8051c;

    static {
        f8048d = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public i() {
        Calendar calendarK = z.k();
        this.f8049a = calendarK;
        this.f8050b = calendarK.getMaximum(7);
        this.f8051c = calendarK.getFirstDayOfWeek();
    }

    private int b(int i3) {
        int i4 = i3 + this.f8051c;
        int i5 = this.f8050b;
        return i4 > i5 ? i4 - i5 : i4;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer getItem(int i3) {
        if (i3 >= this.f8050b) {
            return null;
        }
        return Integer.valueOf(b(i3));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f8050b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(S0.g.f1678s, viewGroup, false);
        }
        this.f8049a.set(7, b(i3));
        textView.setText(this.f8049a.getDisplayName(7, f8048d, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(S0.i.f1704q), this.f8049a.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    public i(int i3) {
        Calendar calendarK = z.k();
        this.f8049a = calendarK;
        this.f8050b = calendarK.getMaximum(7);
        this.f8051c = i3;
    }
}
