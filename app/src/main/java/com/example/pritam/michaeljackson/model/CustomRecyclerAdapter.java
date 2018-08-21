package com.example.pritam.michaeljackson.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.pritam.michaeljackson.R;
import com.example.pritam.michaeljackson.activities.DetailedInfoActivity;
import com.example.pritam.michaeljackson.init.JacksonAppContext;

import java.io.InputStream;
import java.util.List;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder>  {

    private Context context;
    private List<Result> michaelResponseList;
    public CustomRecyclerAdapter(Context context, List michaelResponseList) {
        this.context = context;
        this.michaelResponseList = michaelResponseList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setTag(michaelResponseList.get(position));
        new DownloadImageTask(holder.imageView).execute(michaelResponseList.get (position).getArtworkUrl100 ());
    }
    @Override
    public int getItemCount() {
        return michaelResponseList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView =(ImageView) itemView.findViewById (R.id.userImg);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {

            MichaelResponse cpu = new MichaelResponse();
            Intent intent =new Intent (JacksonAppContext.getAppContext (),DetailedInfoActivity.class);
            Log.d("TAG","Pritam : "+michaelResponseList.get (this.getPosition ()).toString ());
            Bundle bundle=new Bundle ();
            bundle.putSerializable ("object", michaelResponseList.get (this.getPosition()));

            intent.putExtras(bundle);
            context.startActivity (intent);
        }
    }
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
                ImageView bmImage;
                public DownloadImageTask(ImageView bmImage) {
                    this.bmImage = bmImage;
                }
                protected Bitmap doInBackground(String... urls) {
                    String urldisplay = urls[0];
                    Bitmap mIcon = null;
                    try {
                        InputStream in = new java.net.URL(urldisplay).openStream();
                        mIcon = BitmapFactory.decodeStream(in);
                    } catch (Exception e) {
                        Log.e("Error", e.getMessage());
                        e.printStackTrace();
                        return null;
                    }
                    return mIcon;
                }
                protected void onPostExecute(Bitmap result) {
                    bmImage.setImageBitmap(result);
                }
            }
}
