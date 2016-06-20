package com.example.surender.chikoopapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by surender on 16/06/16.
 */
public class MyCouponAdapter extends BaseAdapter
{
    Context context;
    String[] titles;
    String[] offerTags;
    String[] expDates;
    int[] offerImages;
    LayoutInflater inflater;

    MyCouponAdapter(Context context,String[] title,String[] offerTag,String[] expDate, int[] offerImg)
    {
        this.context = context;
        this.titles = title;
        this.offerTags = offerTag;
        this.expDates = expDate;
        this.offerImages = offerImg;

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return this.titles.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class  Holder
    {
        ImageView backImg;
        TextView title;
        TextView offerTagValue;
        TextView expiryDate;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder ;
        if (convertView ==null)
        {
            holder = new Holder();
            convertView = inflater.inflate(R.layout.my_coupon_adapter,null);
            holder.backImg = (ImageView) convertView.findViewById(R.id.coupon_backimg);
            holder.title = (TextView) convertView.findViewById(R.id.coupon_img_title);
            holder.offerTagValue = (TextView) convertView.findViewById(R.id.coupon_offerTag);
            holder.expiryDate = (TextView) convertView.findViewById(R.id.coupon_expireDateValue);

            convertView.setTag(holder);
        }
        else
        holder = (Holder)convertView.getTag();

        holder.backImg.setImageResource(offerImages[position]);
        holder.title.setText(titles[position]);
        holder.offerTagValue.setText(offerTags[position]);
        holder.expiryDate.setText(expDates[position]);

        return convertView;
    }
}
