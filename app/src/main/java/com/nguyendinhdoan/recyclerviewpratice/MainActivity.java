package com.nguyendinhdoan.recyclerviewpratice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ImageModel> imageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initImageBitmaps();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(imageList, this);
        recyclerView.setAdapter(adapter);
    }

    private void initImageBitmaps() {
        imageList = new ArrayList<>();
        imageList.add(new ImageModel("Havasu Falls", "https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg"));
        imageList.add(new ImageModel("Trondheim", "https://i.redd.it/tpsnoz5bzo501.jpg"));
        imageList.add(new ImageModel("Portugal", "https://i.redd.it/qn7f9oqu7o501.jpg"));
        imageList.add(new ImageModel("Rocky Mountain National Park", "https://i.redd.it/j6myfqglup501.jpg"));
    }
}
