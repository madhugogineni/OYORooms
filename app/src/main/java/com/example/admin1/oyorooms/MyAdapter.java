package com.example.admin1.oyorooms;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<String> values;
    private List<Integer> icons;
    private Context context;
    Intent intent;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public ImageView imageView;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.text_list_item);
            imageView = (ImageView)v.findViewById(R.id.city_icon);
            context = v.getContext();
        }
    }

    public void add(int position, String item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        icons.remove(position);
        notifyItemRemoved(position);
    }

    public MyAdapter(List<String> myDataset,List<Integer> cityImages) {
        icons = cityImages;
        values = myDataset;

    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent,
                                                   int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String name = values.get(position);
        holder.txtHeader.setText(name);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),icons.get(position));
        Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap,100,100,true);
        Bitmap finalBitmap = getRoundedBitmap(bitmap1,100);
        holder.imageView.setImageBitmap(finalBitmap);
        intent = new Intent(context,HotelsDisplay.class);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Msg","position is: "+position+" "+values.get(position));
                intent.putExtra("cityName",values.get(position));
                context.startActivity(intent);
            }
        });

    }
    public Bitmap getRoundedBitmap(Bitmap bitmap1,int pixel) {
        Bitmap finalBitmap=null;
        try {
            finalBitmap = Bitmap.createBitmap(100,100, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(finalBitmap);

            int color = 0xff424242;
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, 70, 70);
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(color);
            canvas.drawCircle(50,50,50, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap1, rect, rect, paint);

        } catch (NullPointerException e) {
        } catch (OutOfMemoryError o) {
        }
        return finalBitmap;
    }
    @Override
    public int getItemCount() {
        return values.size();
    }

}
