package com.example.surender.chikoopapp;

import android.content.Context;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by surender on 18/05/16.
 */
public class SwipeAdapter extends PagerAdapter {

    private  int[] sliderImages = {
            R.drawable.info1,
            R.drawable.info2,
            R.drawable.info3,
            R.drawable.info4,
            R.drawable.info5,
            R.drawable.info6
    };

    private Context cntx;
    private LayoutInflater inflater;

    @Override
    public int getCount() {
        return sliderImages.length;
    }

    public SwipeAdapter(Context context)
    {
        this.cntx = context;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        inflater = (LayoutInflater) cntx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View slideView = inflater.inflate(R.layout.intro_layout,container,false);

        ImageView img = (ImageView)slideView.findViewById(R.id.SliderImg);
        img.setImageResource(sliderImages[position]);

        container.addView(slideView);
        return slideView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);

    }
}
