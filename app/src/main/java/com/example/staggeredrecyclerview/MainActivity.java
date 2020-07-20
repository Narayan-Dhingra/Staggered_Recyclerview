package com.example.staggeredrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int NUM_COL = 2;

    private ArrayList<String> images = new ArrayList<>();
    private ArrayList<String> names = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBitmaps();
    }

    private void initBitmaps() {

        images.add("https://www.gstatic.com/webp/gallery/1.jpg");
        names.add("tab");

        images.add("https://www.gstatic.com/webp/gallery/3.jpg");
        names.add("Harry Potter Villa");

        images.add("http://tineye.com/images/widgets/mona.jpg");
        names.add("Girl Pose");

        images.add("https://picsum.photos/id/237/200/300");
        names.add("Bud");

        images.add("https://picsum.photos/seed/picsum/200/300");
        names.add("Building");

        images.add("https://picsum.photos/200/300?grayscale");
        names.add("Basket ball");

        images.add("https://picsum.photos/200/300/?blur");
        names.add("Good food Good Life");

        setRvView();
    }

    private void setRvView() {

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RvAdapter rvAdapter = new RvAdapter(images, names, this);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(NUM_COL, LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(rvAdapter);

    }
}
