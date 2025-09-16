package com.freetime.swiss;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.freetime.swiss.adapter.RadioStationAdapter;

import java.util.Arrays;
import java.util.List;

public class RadioActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_radio);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnToMA = findViewById(R.id.btnToMA);
        btnToMA.setOnClickListener(v -> {
            Intent intent = new Intent(RadioActivity.this, MainActivity.class);
            startActivity(intent);
        });

        Button btnLisSR = findViewById(R.id.btnLisSR);
        btnLisSR.setOnClickListener(v -> {
            Intent intent = new Intent(this, PlayerActivity.class);
            intent.putExtra("STREAM_URL", "https://stream.sunshine.ch/sunshine-high.mp3");
            intent.putExtra("STATION_NAME", "Sunshine Radio");
            startActivity(intent);
        });

        Button btnLisRP = findViewById(R.id.btnLisRP);
        btnLisRP.setOnClickListener(v -> {
            Intent intent = new Intent(this, PlayerActivity.class);
            intent.putExtra("STREAM_URL", "https://radiopilatus.ice.infomaniak.ch/radiopilatus-high.mp3");
            intent.putExtra("STATION_NAME", "Radio Pilatus");
            startActivity(intent);
        });

        Button btnLisSRF3 = findViewById(R.id.btnLisSRF3);
        btnLisSRF3.setOnClickListener(v -> {
            Intent intent = new Intent(this, PlayerActivity.class);
            intent.putExtra("STREAM_URL", "https://stream.srg-ssr.ch/m/srf3/aacp_96");
            intent.putExtra("STATION_NAME", "SRF 3");
            startActivity(intent);
        });

        Button btnLisSRF1 = findViewById(R.id.btnLisSRF1);
        btnLisSRF1.setOnClickListener(v -> {
            Intent intent = new Intent(this, PlayerActivity.class);
            intent.putExtra("STREAM_URL", "https://stream.srg-ssr.ch/m/rsr1/aacp_96");
            intent.putExtra("STATION_NAME", "SRF 1");
            startActivity(intent);
        });
    }
}
