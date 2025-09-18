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
            intent.putExtra("STREAM_URL", "" + "https://chmedia.streamabc.net/79-rsunshine-mp3-192-4746851?sABC=68poqpn2%231%231699795900047_8633080%23puzrqvn-enqvb-jro&aw_0_1st.playerid=chmedia-radio-web&amsparams=playerid:chmedia-radio-web;skey:1758190754");
            intent.putExtra("STATION_NAME", "Sunshine Radio");
            startActivity(intent);
        });

        Button btnLisRP = findViewById(R.id.btnLisRP);
        btnLisRP.setOnClickListener(v -> {
            Intent intent = new Intent(this, PlayerActivity.class);
            intent.putExtra("STREAM_URL", "https://chmedia.streamabc.net/79-pilatus-mp3-192-4664468?sABC=68pons12%230%23q7s809s74070n543n7p5213q6qr39235%23puzrqvn&aw_0_1st.playerid=chmedia&amsparams=playerid:chmedia;skey:1758179090");
            intent.putExtra("STATION_NAME", "Radio Pilatus");
            startActivity(intent);
        });

        Button btnLisSRF3 = findViewById(R.id.btnLisSRF3);
        btnLisSRF3.setOnClickListener(v -> {
            Intent intent = new Intent(this, PlayerActivity.class);
            intent.putExtra("STREAM_URL", "http://livestreaming-node-4.srg-ssr.ch/srgssr/srf3/mp3/128");
            intent.putExtra("STATION_NAME", "SRF 3");
            startActivity(intent);
        });

        Button btnLisSRF1 = findViewById(R.id.btnLisSRF1);
        btnLisSRF1.setOnClickListener(v -> {
            Intent intent = new Intent(this, PlayerActivity.class);
            intent.putExtra("STREAM_URL", "http://livestreaming-node-1.srg-ssr.ch/srgssr/srf1/mp3/128");
            intent.putExtra("STATION_NAME", "SRF 1");
            startActivity(intent);
        });
    }
}
