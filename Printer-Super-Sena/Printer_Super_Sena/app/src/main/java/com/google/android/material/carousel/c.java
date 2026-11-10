package com.google.android.material.carousel;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f7889a;

    class a extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CarouselLayoutManager f7890b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i3, CarouselLayoutManager carouselLayoutManager) {
            super(i3, null);
            this.f7890b = carouselLayoutManager;
        }

        @Override // com.google.android.material.carousel.c
        public float d(RecyclerView.p pVar) {
            return ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // com.google.android.material.carousel.c
        int e() {
            return this.f7890b.b0();
        }

        @Override // com.google.android.material.carousel.c
        int f() {
            return e();
        }

        @Override // com.google.android.material.carousel.c
        int g() {
            return this.f7890b.i0();
        }

        @Override // com.google.android.material.carousel.c
        int h() {
            return this.f7890b.s0() - this.f7890b.j0();
        }

        @Override // com.google.android.material.carousel.c
        int i() {
            return j();
        }

        @Override // com.google.android.material.carousel.c
        int j() {
            return 0;
        }

        @Override // com.google.android.material.carousel.c
        public void k(View view, int i3, int i4) {
            int iG = g();
            this.f7890b.D0(view, iG, i3, iG + m(view), i4);
        }

        @Override // com.google.android.material.carousel.c
        public void l(View view, Rect rect, float f3, float f4) {
            view.offsetTopAndBottom((int) (f4 - (rect.top + f3)));
        }

        int m(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f7890b.X(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }
    }

    class b extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CarouselLayoutManager f7891b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i3, CarouselLayoutManager carouselLayoutManager) {
            super(i3, null);
            this.f7891b = carouselLayoutManager;
        }

        @Override // com.google.android.material.carousel.c
        public float d(RecyclerView.p pVar) {
            return ((ViewGroup.MarginLayoutParams) pVar).rightMargin + ((ViewGroup.MarginLayoutParams) pVar).leftMargin;
        }

        @Override // com.google.android.material.carousel.c
        int e() {
            return this.f7891b.b0() - this.f7891b.h0();
        }

        @Override // com.google.android.material.carousel.c
        int f() {
            return this.f7891b.F2() ? g() : h();
        }

        @Override // com.google.android.material.carousel.c
        int g() {
            return 0;
        }

        @Override // com.google.android.material.carousel.c
        int h() {
            return this.f7891b.s0();
        }

        @Override // com.google.android.material.carousel.c
        int i() {
            return this.f7891b.F2() ? h() : g();
        }

        @Override // com.google.android.material.carousel.c
        int j() {
            return this.f7891b.k0();
        }

        @Override // com.google.android.material.carousel.c
        public void k(View view, int i3, int i4) {
            int iJ = j();
            this.f7891b.D0(view, i3, iJ, i4, iJ + m(view));
        }

        @Override // com.google.android.material.carousel.c
        public void l(View view, Rect rect, float f3, float f4) {
            view.offsetLeftAndRight((int) (f4 - (rect.left + f3)));
        }

        int m(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f7891b.W(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }
    }

    /* synthetic */ c(int i3, a aVar) {
        this(i3);
    }

    private static c a(CarouselLayoutManager carouselLayoutManager) {
        return new b(0, carouselLayoutManager);
    }

    static c b(CarouselLayoutManager carouselLayoutManager, int i3) {
        if (i3 == 0) {
            return a(carouselLayoutManager);
        }
        if (i3 == 1) {
            return c(carouselLayoutManager);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    private static c c(CarouselLayoutManager carouselLayoutManager) {
        return new a(1, carouselLayoutManager);
    }

    abstract float d(RecyclerView.p pVar);

    abstract int e();

    abstract int f();

    abstract int g();

    abstract int h();

    abstract int i();

    abstract int j();

    abstract void k(View view, int i3, int i4);

    abstract void l(View view, Rect rect, float f3, float f4);

    private c(int i3) {
        this.f7889a = i3;
    }
}
