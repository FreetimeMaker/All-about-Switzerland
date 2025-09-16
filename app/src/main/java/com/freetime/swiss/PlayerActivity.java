package com.freetime.swiss;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PlayerActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private String streamUrl;
    private TextView stationTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        stationTitle = findViewById(R.id.stationTitle);
        streamUrl = getIntent().getStringExtra("STREAM_URL");

        String stationName = getIntent().getStringExtra("STATION_NAME");
        stationTitle.setText(stationName != null ? stationName : "Now Playing");

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try {
            mediaPlayer.setDataSource(streamUrl);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(mp -> {
                mp.start();
                Toast.makeText(this, "Streaming started", Toast.LENGTH_SHORT).show();
            });
        } catch (Exception e) {
            Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}