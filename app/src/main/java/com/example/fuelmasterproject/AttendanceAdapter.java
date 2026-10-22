package com.example.fuelmasterproject;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.ViewHolder> {

    private final List<AttendanceItem> items;

    public AttendanceAdapter(List<AttendanceItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_attendance, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AttendanceItem item = items.get(position);
        holder.tvEmpName.setText(item.name);
        holder.tvInitials.setText(item.initials);
        holder.tvAttendanceTimes.setText(item.times);
        holder.tvAttendanceStatus.setText(item.status);

        int tintColor = ContextCompat.getColor(holder.itemView.getContext(), R.color.success);
        int bgTint = ContextCompat.getColor(holder.itemView.getContext(), R.color.success_tint);

        if ("warning".equalsIgnoreCase(item.statusType)) {
            tintColor = ContextCompat.getColor(holder.itemView.getContext(), R.color.warning);
            bgTint = ContextCompat.getColor(holder.itemView.getContext(), R.color.warning_tint);
        } else if ("info".equalsIgnoreCase(item.statusType)) {
            tintColor = ContextCompat.getColor(holder.itemView.getContext(), R.color.info);
            bgTint = ContextCompat.getColor(holder.itemView.getContext(), R.color.info_tint);
        }

        holder.tvAttendanceStatus.setTextColor(tintColor);
        holder.tvAttendanceStatus.setBackgroundTintList(ColorStateList.valueOf(bgTint));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvInitials, tvEmpName, tvAttendanceTimes, tvAttendanceStatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvInitials = itemView.findViewById(R.id.tvInitials);
            tvEmpName = itemView.findViewById(R.id.tvEmpName);
            tvAttendanceTimes = itemView.findViewById(R.id.tvAttendanceTimes);
            tvAttendanceStatus = itemView.findViewById(R.id.tvAttendanceStatus);
        }
    }
}
