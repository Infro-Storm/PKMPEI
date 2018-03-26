package ru.pkmpei.mpei_pk.adapters;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import ru.pkmpei.mpei_pk.R;

/**
 * Created by infrostorm on 19.12.2017.
 */

public class PhotosPreviewAdapter extends RecyclerView.Adapter<PhotosPreviewAdapter.ViewHolder> {
File file;
Context context;
    public PhotosPreviewAdapter(Context context) {
        file =  context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView imageView;
        public TextView textView;
        public ViewHolder(View view) {
            super(view);
            //textView =  view.findViewById(R.id.nameView);
            imageView =  view.findViewById(R.id.photoView);

        }
    }

    @Override
    public PhotosPreviewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.photos_preview_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setImageBitmap(BitmapFactory.decodeFile(file.listFiles()[position].getAbsolutePath()));
   //     holder.textView.setText(file.listFiles()[position].getName());
    }


    @Override
    public int getItemCount() {
        //Toast.makeText(context, "Len: " + file.listFiles().length, Toast.LENGTH_LONG).show();
        if (file.listFiles()==null) return 0;
        return file.listFiles().length;
    }
}
