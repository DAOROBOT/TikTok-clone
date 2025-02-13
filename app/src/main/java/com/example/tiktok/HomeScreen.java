package com.example.tiktok;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.Toast;
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
    RelativeLayout share_button;
    RelativeLayout profile_button;
    RelativeLayout download_button;
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

        share_button = findViewById(R.id.share);
        share_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, ShareScreen.class);
                // Truyền URI dưới dạng string (hoặc bạn có thể putParcelable nếu muốn)
                intent.putExtra("VIDEO_URI", videoUri.toString());
                startActivity(intent);
            }
        });
        profile_button = findViewById(R.id.info_page);
        profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, ProfileScreen.class);
                startActivity(intent);
            }
        });


        download_button = findViewById(R.id.download);
        download_button.setOnClickListener(view -> {
            showDownloadDialog();
        });
    }

    // Method to show the download confirmation dialog
    private void showDownloadDialog() {
        // Create the AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(HomeScreen.this);
        builder.setTitle("Tải xuống video này")
                .setMessage("Bạn có chắc chắn muốn tải video này xuống?")
                .setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Handle "Đồng ý" button click (start download)
                        startDownload();
                    }
                })
                .setNegativeButton("Hủy bỏ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Handle "Hủy bỏ" button click (cancel download)
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }

    // Method to simulate video download
    private void startDownload() {
        // Simulate the video download process here
        // For now, you can just show a toast as a placeholder
        Toast.makeText(HomeScreen.this, "Video đang được tải xuống...", Toast.LENGTH_SHORT).show();
    }
}