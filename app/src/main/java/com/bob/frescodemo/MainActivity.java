package com.bob.frescodemo;

import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PointF focusPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        focusPoint = new PointF(0.5f, 0);
        initView();
    }

    private void initView() {
        RecyclerView rv_container = (RecyclerView) findViewById(R.id.rv_container);
        rv_container.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        List<String> girl_list = new ArrayList<String>();
        addDatas(girl_list);
        //设置adapter
        GirlsAdapter adapter = new GirlsAdapter(girl_list);
        rv_container.setAdapter(adapter);
    }

    /**
     * RecycleView 的adapter
     */
    class GirlsAdapter extends RecyclerView.Adapter<GirlItemView> {

        private List<String> list;
        public GirlsAdapter(List<String> list) {
            this.list = list;
        }

        @Override
        public GirlItemView onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.girl_item, parent, false);
            return new GirlItemView(view);
        }

        @Override
        public void onBindViewHolder(GirlItemView holder, final int position) {
            holder.imageView.getHierarchy().setActualImageFocusPoint(focusPoint);
            holder.imageView.setImageURI(Uri.parse(list.get(position)));
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this,PicDetailActivity.class);
                    intent.putExtra("url",list.get(position));
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    public static class GirlItemView extends RecyclerView.ViewHolder {

        SimpleDraweeView imageView;

        public GirlItemView(View itemView) {
            super(itemView);
            imageView = (SimpleDraweeView) itemView.findViewById(R.id.item_img);
        }

    }

    private void addDatas(List<String> girl_list) {
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/43/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/43/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/43/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/43/05.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/42/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/42/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/42/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/42/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/42/05.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/42/06.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/41/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/41/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/41/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/41/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/41/05.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/41/06.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/41/07.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/40/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/40/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/40/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/40/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/40/05.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/40/06.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/40/07.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/40/08.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/40/09.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/40/10.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/39/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/39/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/39/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/39/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/39/05.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/39/06.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/39/07.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/39/08.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/39/09.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/39/10.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/38/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/38/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/38/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/38/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/38/05.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/38/06.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/37/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/37/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/37/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/37/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/37/05.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/37/06.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/37/07.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/36/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/36/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/36/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/36/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/36/05.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/36/06.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/36/07.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/35/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/35/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/35/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/35/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/35/05.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/35/06.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/35/07.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/34/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/34/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/34/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/34/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/34/05.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/34/06.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/34/07.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/34/08.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/33/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/33/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/33/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/33/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/33/05.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/33/06.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/32/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/32/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/32/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/32/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/32/05.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/32/06.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/31/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/31/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/31/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/31/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/31/05.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/31/06.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/30/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/30/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/30/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/30/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/30/05.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/30/06.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/29/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/29/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/29/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/29/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/29/05.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/29/06.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/29/07.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/29/08.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/28/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/28/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/28/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/28/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/27/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/27/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/27/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/27/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/27/05.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/26/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/26/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/26/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/26/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/26/05.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/25/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/25/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/25/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/25/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/24/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/24/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/24/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/24/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/24/05.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/24/06.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/24/07.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/24/08.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/24/09.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/23/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/23/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/23/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/23/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/23/05.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/23/06.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/23/07.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/23/08.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/23/09.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/22/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/22/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/22/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/22/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/22/05.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/22/06.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/21/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/21/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/21/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/21/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/21/05.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/21/06.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/21/07.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/21/08.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/21/09.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/20/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/20/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/20/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/20/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/20/05.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/20/06.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/20/07.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/20/08.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/20/09.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/20/10.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/19/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/19/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/19/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/19/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/19/05.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/19/06.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/19/07.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/18/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/18/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/18/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/18/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/18/05.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/18/06.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/18/07.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/18/08.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/18/09.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/17/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/17/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/17/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/17/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/17/05.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/17/06.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/17/07.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/16/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/16/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/16/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/16/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/16/05.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/15/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/15/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/15/03.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/15/04.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/15/05.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/15/06.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/15/07.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/15/08.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/15/09.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/14/01.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/14/02.jpg");
        girl_list.add("http://pic.meizitu.com/wp-content/uploads/2015a/03/14/03.jpg");
    }
}
