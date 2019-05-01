package com.nguyendinhdoan.recyclerviewpratice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class GalleryActivity extends AppCompatActivity {

    private static final String TAG = GalleryActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        Log.d(TAG, "onCreate: started");

        getInCommingIntent();
    }

    private void getInCommingIntent() {
        Log.d(TAG, "getIncomingIntent: checking for incoming intent");
        if (getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name")) {
            Log.d(TAG, "getIncomingIntent: found intent extras.");

            String imageName = getIntent().getStringExtra("image_url");
            String imageUrl = getIntent().getStringExtra("image_name");

            setImage(imageName, imageUrl);
        }
    }

    private void setImage(String imageName, String imageUrl) {
        Log.d(TAG, "setImage: setting image to image and name to widgets");

        // set name
        TextView nameTextView = findViewById(R.id.image_description);
        nameTextView.setText(imageName);

        // set image url
        ImageView image = findViewById(R.id.image_url);
        Glide.with(this).asBitmap().load(imageUrl).into(image);

    }
}
