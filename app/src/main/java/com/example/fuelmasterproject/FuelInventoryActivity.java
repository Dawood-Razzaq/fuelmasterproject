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

public class FuelInventoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_list);

        Toolbar toolbar = findViewById(R.id.toolbarList);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Fuel Inventory");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        TextView tvEmptyMessage = findViewById(R.id.tvEmptyMessage);
        FloatingActionButton fabAdd = findViewById(R.id.fabAdd);

        tvEmptyMessage.setText("No fuel purchases recorded yet");

        List<GenericItem> items = Arrays.asList(
                new GenericItem("PSO — Petrol", "5,000 L @ Rs. 250", "Delivered", "success", R.drawable.ic_fuel),
                new GenericItem("Attock — Diesel", "8,000 L @ Rs. 248", "Delivered", "success", R.drawable.ic_fuel),
                new GenericItem("Shell — Petrol", "6,000 L @ Rs. 250", "Delivered", "success", R.drawable.ic_fuel)
        );

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new GenericAdapter(items));

        fabAdd.setOnClickListener(v -> Toast.makeText(this, "Add new fuel purchase record", Toast.LENGTH_SHORT).show());
    }
}
