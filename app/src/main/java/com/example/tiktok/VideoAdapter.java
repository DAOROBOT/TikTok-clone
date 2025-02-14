package com.example.tiktok;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    private List<Video> videoList;

    public VideoAdapter(List<Video> videoList) {
        this.videoList = videoList;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        // Get the width of the RecyclerView and set the width of each item to 1/3 of that width
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) holder.itemView.getLayoutParams();
        int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        int itemWidth = screenWidth / 3; // Set width to 1/3 of the screen width
        layoutParams.width = itemWidth; // Set the width of the item

        holder.itemView.setLayoutParams(layoutParams);

        Video video = videoList.get(position);
        holder.videoTitle.setText(video.getTitle());
        // Load video thumbnail using Glide or Picasso (if needed)
        // Glide.with(holder.itemView.getContext()).load(video.getThumbnailUrl()).into(holder.videoThumbnail);
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {
        ImageView videoThumbnail;
        TextView videoTitle;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoThumbnail = itemView.findViewById(R.id.videoThumbnail);
            videoTitle = itemView.findViewById(R.id.videoTitle);
        }
    }
}
