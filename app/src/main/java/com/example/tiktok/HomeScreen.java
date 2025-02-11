package com.example.tiktok;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeScreen extends AppCompatActivity {

    VideoView mainVideo;
    RelativeLayout comment_button;
    RelativeLayout search_button;
    RelativeLayout plus_button;
    RelativeLayout noti_button;

//    RelativeLayout profile_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_screen);

        mainVideo = findViewById(R.id.video);
        mainVideo.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.main_video));
        mainVideo.start();
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.main_video);

//        MediaController media_controller = new MediaController(this);
//        media_controller.setMediaPlayer(mainVideo);
//        mainVideo.setMediaController(media_controller);

        comment_button = findViewById(R.id.comment);
        comment_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, CommentScreen.class);

                // Truyền URI dưới dạng string (hoặc bạn có thể putParcelable nếu muốn)
                intent.putExtra("VIDEO_URI", videoUri.toString());

                startActivity(intent);
            }
        });

        search_button = findViewById(R.id.search_page);
        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, SearchScreen.class);
                startActivity(intent);
            }
        });


        plus_button = findViewById(R.id.upload_page);
        plus_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, CameraScreen.class);
                startActivity(intent);
            }
        });

        noti_button = findViewById(R.id.notifi_page);
        noti_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, NotificationScreen.class);
                startActivity(intent);
            }
        });
//        RelativeLayout profile_button = findViewById(R.id.info_page);
//        profile_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(HomeScreen.this, ProfileScreen.class);
//                startActivity(intent);
//            }
//        });

    }
}