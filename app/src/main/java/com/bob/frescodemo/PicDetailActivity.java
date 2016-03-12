package com.bob.frescodemo;

import android.app.Activity;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * 作者 bob
 * 日期 15-12-19.
 */
public class PicDetailActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picdetail_activity);
        SimpleDraweeView image = (SimpleDraweeView) findViewById(R.id.image);
        String url = getIntent().getStringExtra("url");
        image.getHierarchy().setActualImageFocusPoint(new PointF(0.5f, 0));
        image.setImageURI(Uri.parse(url));
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
