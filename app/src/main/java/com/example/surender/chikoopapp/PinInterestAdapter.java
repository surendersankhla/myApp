package com.example.surender.chikoopapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

/**
 * Created by surender on 12/06/16.
 */
public class PinInterestAdapter extends BaseAdapter
{

    String[] Titels;
    int[] Icons;
    Context MyContext;
    LayoutInflater layoutInflater;
    String BtnText;

    PinInterestAdapter(Context context,String[] title,int[] icon,String btnText)
    {
        this.MyContext = context;
        this.Titels = title;
        this.Icons = icon;
        this.BtnText = btnText;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return this.Titels.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class Holder
    {
        ImageView img;
        TextView txtv;
        TextView btn;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Holder holder;

        if (convertView == null)
        {
            holder = new Holder();
            convertView = layoutInflater.inflate(R.layout.pin_interest_layout,null);

            holder.img = (ImageView) convertView.findViewById(R.id.pinAdapter_icon);
            holder.txtv = (TextView) convertView.findViewById(R.id.pinAdapter_iconTitle);
            holder.btn = (TextView) convertView.findViewById(R.id.pinAdapter_pinIT);
            holder.btn.setText(BtnText);
            convertView.setTag(holder);
        }
        else

        holder = (Holder)convertView.getTag();

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyContext,"Row "+Titels[position]+" pined ",Toast.LENGTH_SHORT).show();
            }
        });

        holder.img.setImageResource(Icons[position]);
        holder.txtv.setText(Titels[position]);

        return convertView;
    }
}
