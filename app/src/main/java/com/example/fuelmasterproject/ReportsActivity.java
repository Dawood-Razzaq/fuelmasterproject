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

public class ReportsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_list);

        Toolbar toolbar = findViewById(R.id.toolbarList);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Reports & Analytics");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        TextView tvEmptyMessage = findViewById(R.id.tvEmptyMessage);
        FloatingActionButton fabAdd = findViewById(R.id.fabAdd);

        tvEmptyMessage.setText("No reports available");

        List<GenericItem> items = Arrays.asList(
                new GenericItem("Daily Sales Summary", "June 2024 (Total: Rs. 94,50,000)", "Ready", "success", R.drawable.ic_chart),
                new GenericItem("FBR Tax Compliance Report", "Q2 2024 Filing", "Filed ✓", "success", R.drawable.ic_chart),
                new GenericItem("Shift Reconciliation Audit", "All shifts verified & balanced", "Verified", "success", R.drawable.ic_chart),
                new GenericItem("Tank Stock Consumption", "AI Prediction & Forecast Report", "Generated", "info", R.drawable.ic_chart)
        );

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new GenericAdapter(items));

        fabAdd.setOnClickListener(v -> Toast.makeText(this, "Export Report (PDF / Excel)", Toast.LENGTH_SHORT).show());
    }
}
