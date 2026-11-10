package s2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import rawbt.sdk.dao.PrinterEntity;
import ru.a402d.rawbtprinter.R;

/* JADX INFO: loaded from: classes.dex */
public class b extends RecyclerView.g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LayoutInflater f11714d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f11713c = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f11715e = null;

    public interface a {
        void a(PrinterEntity printerEntity);
    }

    /* JADX INFO: renamed from: s2.b$b, reason: collision with other inner class name */
    public class C0134b extends RecyclerView.D {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private PrinterEntity f11716t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final ImageView f11717u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final TextView f11718v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private final TextView f11719w;

        public C0134b(View view) {
            super(view);
            this.f11717u = (ImageView) view.findViewById(R.id.imgPip);
            this.f11718v = (TextView) view.findViewById(R.id.txtBold);
            this.f11719w = (TextView) view.findViewById(R.id.txtNormal);
            view.setOnClickListener(new View.OnClickListener() { // from class: s2.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f11721a.O(view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void O(View view) {
            if (b.this.f11715e != null) {
                b.this.f11715e.a(this.f11716t);
            }
        }

        public void N(PrinterEntity printerEntity) {
            this.f11716t = printerEntity;
            this.f11719w.setText(printerEntity.getName());
            this.f11718v.setText(this.f11716t.getDescription());
            if (this.f11716t.isCurrent()) {
                this.f11717u.setImageResource(R.drawable.ic_circle_checked);
            } else {
                this.f11717u.setImageResource(R.drawable.ic_circle);
            }
        }
    }

    public b(Context context) {
        this.f11714d = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public void A(a aVar) {
        this.f11715e = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e() {
        return this.f11713c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void l(C0134b c0134b, int i3) {
        c0134b.N((PrinterEntity) this.f11713c.get(i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public C0134b n(ViewGroup viewGroup, int i3) {
        return new C0134b(this.f11714d.inflate(R.layout.item_printer, viewGroup, false));
    }

    public void z(List list) {
        List list2 = this.f11713c;
        if (list2 == null) {
            this.f11713c = list;
            return;
        }
        list2.clear();
        this.f11713c.addAll(list);
        j();
    }
}
