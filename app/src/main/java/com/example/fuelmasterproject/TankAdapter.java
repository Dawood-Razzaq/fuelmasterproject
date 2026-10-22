package com.example.fuelmasterproject;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TankAdapter extends RecyclerView.Adapter<TankAdapter.ViewHolder> {

    private final List<TankItem> items;

    public TankAdapter(List<TankItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tank, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TankItem item = items.get(position);
        holder.tvTankName.setText(item.name);
        holder.tvTankVolume.setText(item.volume);
        holder.tvTankPercent.setText(item.percent + "%");
        holder.pbTankProgress.setProgress(item.percent);
        holder.tvTankStatusChip.setText(item.status);

        int tintColor = ContextCompat.getColor(holder.itemView.getContext(), R.color.success);
        int bgTint = ContextCompat.getColor(holder.itemView.getContext(), R.color.success_tint);
        int barColor = ContextCompat.getColor(holder.itemView.getContext(), R.color.primary_blue);

        if (item.percent < 35) {
            barColor = ContextCompat.getColor(holder.itemView.getContext(), R.color.accent_orange);
        } else if (item.percent < 50) {
            barColor = ContextCompat.getColor(holder.itemView.getContext(), R.color.warning);
        }

        if ("warning".equalsIgnoreCase(item.statusType)) {
            tintColor = ContextCompat.getColor(holder.itemView.getContext(), R.color.warning);
            bgTint = ContextCompat.getColor(holder.itemView.getContext(), R.color.warning_tint);
        }

        holder.tvTankStatusChip.setTextColor(tintColor);
        holder.tvTankStatusChip.setBackgroundTintList(ColorStateList.valueOf(bgTint));
        holder.pbTankProgress.setProgressTintList(ColorStateList.valueOf(barColor));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTankName, tvTankVolume, tvTankPercent, tvTankStatusChip;
        ProgressBar pbTankProgress;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTankName = itemView.findViewById(R.id.tvTankName);
            tvTankVolume = itemView.findViewById(R.id.tvTankVolume);
            tvTankPercent = itemView.findViewById(R.id.tvTankPercent);
            tvTankStatusChip = itemView.findViewById(R.id.tvTankStatusChip);
            pbTankProgress = itemView.findViewById(R.id.pbTankProgress);
        }
    }
}
