package com.app.gaohailong.toolbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;

/**
 * Created by Admin on 2015/11/5.
 */
public class NewDetails extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_details);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        final CollapsingToolbarLayout cTl = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        cTl.setTitle("COLL UI");

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.top_image);

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch swatch = palette.getDarkMutedSwatch();
                if (swatch != null){
                    cTl.setContentScrimColor(swatch.getRgb());
                    cTl.setCollapsedTitleTextColor(swatch.getTitleTextColor());
                }
            }
        });
    }
}
