package com.example.tiktok;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;


public class ProfileScreen extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VideoAdapter videoAdapter;
    private List<Video> videoList;
    RelativeLayout home_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_screen);

        recyclerView = findViewById(R.id.recyclerViewProfile);

        // Sử dụng GridLayoutManager với 3 cột và hướng cuộn ngang
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, true);
        recyclerView.setLayoutManager(layoutManager);

        // Khởi tạo danh sách video
        videoList = new ArrayList<>();
        videoList.add(new Video("Video 1", Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.main_video)));
        videoList.add(new Video("Video 2", Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.main_video)));
        videoList.add(new Video("Video 3", Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.main_video)));
        videoList.add(new Video("Video 4", Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.main_video)));
        videoList.add(new Video("Video 5", Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.main_video)));
        videoList.add(new Video("Video 6", Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.main_video)));

        // Thiết lập Adapter
        videoAdapter = new VideoAdapter(videoList);
        recyclerView.setAdapter(videoAdapter);

        home_button = findViewById(R.id.home_page);
        home_button.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileScreen.this, HomeScreen.class);
            startActivity(intent);
        });
    }
}
