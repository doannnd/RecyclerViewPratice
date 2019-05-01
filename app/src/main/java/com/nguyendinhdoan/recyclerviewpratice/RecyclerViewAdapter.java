package com.nguyendinhdoan.recyclerviewpratice;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String LOG_TAG = RecyclerViewAdapter.class.getSimpleName();
    private List<ImageModel> mImageList;
    private Context mContext;

    public RecyclerViewAdapter(List<ImageModel> mImageList, Context mContext) {
        this.mImageList = mImageList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_recycler_view, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        final ImageModel imageModel = mImageList.get(position);

        RequestOptions requestOptions = new RequestOptions().placeholder(R.drawable.ic_launcher_background);

        // load image
        Glide.with(mContext).asBitmap().load(imageModel.getImageUrl())
                .apply(requestOptions)
                .into(viewHolder.image);

        // load image name
        viewHolder.imageName.setText(imageModel.getImageName());

        // event
        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(LOG_TAG, "onclick: " + position);
                Toast.makeText(mContext, "name: " + imageModel.getImageName(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, GalleryActivity.class);
                intent.putExtra("image_url", imageModel.getImageName());
                intent.putExtra("image_name", imageModel.getImageUrl());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView image;
        private TextView imageName;
        private RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);
        }
    }
}
