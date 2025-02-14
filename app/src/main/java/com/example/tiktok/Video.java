package com.example.tiktok;

import android.net.Uri;

public class Video {
    private String title;
    private Uri thumbnailUrl;

    public Video(String title, Uri thumbnailUrl) {
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getTitle() {
        return title;
    }

    public Uri getThumbnailUrl() {
        return thumbnailUrl;
    }
}
