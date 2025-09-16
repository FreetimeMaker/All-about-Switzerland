package com.freetime.swiss.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.freetime.swiss.R;
import com.freetime.swiss.RadioStation;

import java.util.List;

public class RadioStationAdapter extends RecyclerView.Adapter<RadioStationAdapter.RadioViewHolder> {

    private List<RadioStation> stationList;
    private OnStationClickListener listener;

    public interface OnStationClickListener {
        void onStationClick(RadioStation station);
    }

    public RadioStationAdapter(List<RadioStation> stationList, OnStationClickListener listener) {
        this.stationList = stationList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RadioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_radio_station, parent, false);
        return new RadioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RadioViewHolder holder, int position) {
        RadioStation station = stationList.get(position);
        holder.stationName.setText(station.getName());
        holder.itemView.setOnClickListener(v -> listener.onStationClick(station));
    }

    @Override
    public int getItemCount() {
        return stationList.size();
    }

    static class RadioViewHolder extends RecyclerView.ViewHolder {
        TextView stationName;

        public RadioViewHolder(@NonNull View itemView) {
            super(itemView);
            stationName = itemView.findViewById(R.id.stationName);
        }
    }
}

