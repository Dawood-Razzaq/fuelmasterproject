package com.example.fuelmasterproject;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GenericAdapter extends RecyclerView.Adapter<GenericAdapter.ViewHolder> {

    private final List<GenericItem> items;

    public GenericAdapter(List<GenericItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GenericItem item = items.get(position);
        holder.tvTitle.setText(item.title);
        holder.tvSubtitle.setText(item.subtitle);
        holder.ivIcon.setImageResource(item.iconResId);

        if (item.chipText != null && !item.chipText.isEmpty()) {
            holder.tvChip.setVisibility(View.VISIBLE);
            holder.tvChip.setText(item.chipText);
            
            int contextColor = ContextCompat.getColor(holder.itemView.getContext(), R.color.success);
            int bgTint = ContextCompat.getColor(holder.itemView.getContext(), R.color.success_tint);

            if ("warning".equalsIgnoreCase(item.chipType)) {
                contextColor = ContextCompat.getColor(holder.itemView.getContext(), R.color.warning);
                bgTint = ContextCompat.getColor(holder.itemView.getContext(), R.color.warning_tint);
            } else if ("danger".equalsIgnoreCase(item.chipType)) {
                contextColor = ContextCompat.getColor(holder.itemView.getContext(), R.color.danger);
                bgTint = ContextCompat.getColor(holder.itemView.getContext(), R.color.danger_tint);
            } else if ("info".equalsIgnoreCase(item.chipType)) {
                contextColor = ContextCompat.getColor(holder.itemView.getContext(), R.color.info);
                bgTint = ContextCompat.getColor(holder.itemView.getContext(), R.color.info_tint);
            }

            holder.tvChip.setTextColor(contextColor);
            holder.tvChip.setBackgroundTintList(ColorStateList.valueOf(bgTint));
        } else {
            holder.tvChip.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivIcon;
        TextView tvTitle, tvSubtitle, tvChip;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivIcon = itemView.findViewById(R.id.ivIcon);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvSubtitle = itemView.findViewById(R.id.tvSubtitle);
            tvChip = itemView.findViewById(R.id.tvChip);
        }
    }
}
