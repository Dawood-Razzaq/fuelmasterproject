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

public class PumpNozzleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_list);

        Toolbar toolbar = findViewById(R.id.toolbarList);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Pump & Nozzle");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        TextView tvEmptyMessage = findViewById(R.id.tvEmptyMessage);
        FloatingActionButton fabAdd = findViewById(R.id.fabAdd);

        tvEmptyMessage.setText("No pumps configured");

        List<GenericItem> items = Arrays.asList(
                new GenericItem("Pump 01", "Nozzle A & B (Petrol)", "Active", "success", R.drawable.ic_pump),
                new GenericItem("Pump 02", "Nozzle A & B (Diesel)", "Active", "success", R.drawable.ic_pump),
                new GenericItem("Pump 03", "Nozzle A (Petrol)", "Active", "success", R.drawable.ic_pump),
                new GenericItem("Pump 04", "Nozzle A & B (Diesel)", "Maintenance", "warning", R.drawable.ic_pump)
        );

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new GenericAdapter(items));

        fabAdd.setOnClickListener(v -> Toast.makeText(this, "Add New Pump", Toast.LENGTH_SHORT).show());
    }
}
