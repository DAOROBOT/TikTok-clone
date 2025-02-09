package com.example.tiktok_clone;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private VideoAdapter videoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        List<String> videoUrls = new ArrayList<>();
        videoUrls.add("android.resource://" + getPackageName() + "/" + R.raw.video1);
        videoUrls.add("android.resource://" + getPackageName() + "/" + R.raw.video2);
        videoUrls.add("android.resource://" + getPackageName() + "/" + R.raw.video3);

        videoAdapter = new VideoAdapter(videoUrls);
        viewPager.setAdapter(videoAdapter);

        // Tự động phát video khi chuyển trang
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                videoAdapter.playVideo(position);
            }
        });
    }
}
