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

public class SupplierManagementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_list);

        Toolbar toolbar = findViewById(R.id.toolbarList);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Supplier Management");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        TextView tvEmptyMessage = findViewById(R.id.tvEmptyMessage);
        FloatingActionButton fabAdd = findViewById(R.id.fabAdd);

        tvEmptyMessage.setText("No suppliers added");

        List<GenericItem> items = Arrays.asList(
                new GenericItem("Pakistan State Oil (PSO)", "Primary Fuel Supplier", "Active", "success", R.drawable.ic_supplier),
                new GenericItem("Attock Petroleum", "Fuel Supplier", "Active", "success", R.drawable.ic_supplier),
                new GenericItem("Shell Pakistan", "Premium Fuels", "Active", "success", R.drawable.ic_supplier),
                new GenericItem("Total Parco", "Lubricants & Fuel", "Active", "success", R.drawable.ic_supplier)
        );

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new GenericAdapter(items));

        fabAdd.setOnClickListener(v -> Toast.makeText(this, "Add Supplier", Toast.LENGTH_SHORT).show());
    }
}
