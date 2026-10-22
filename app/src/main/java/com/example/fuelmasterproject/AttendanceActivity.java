package com.example.fuelmasterproject;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Arrays;
import java.util.List;

public class AttendanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_list);

        Toolbar toolbar = findViewById(R.id.toolbarList);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Attendance");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        TextView tvEmptyMessage = findViewById(R.id.tvEmptyMessage);
        FloatingActionButton fabAdd = findViewById(R.id.fabAdd);

        tvEmptyMessage.setText("No attendance records");

        List<AttendanceItem> attendance = Arrays.asList(
                new AttendanceItem("Usman Khan", "UK", "In: 05:55 AM | Out: --", "On Time", "success"),
                new AttendanceItem("Bilal Ahmed", "BA", "In: 06:02 AM | Out: --", "On Time", "success"),
                new AttendanceItem("Hamza Ali", "HA", "Status: On Leave (Approved)", "On Leave", "info"),
                new AttendanceItem("Zahid Ahmed", "ZA", "In: 06:35 AM | Out: --", "Late", "warning")
        );

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AttendanceAdapter(attendance));

        fabAdd.setOnClickListener(v -> Toast.makeText(this, "Mark Attendance", Toast.LENGTH_SHORT).show());
    }
}
