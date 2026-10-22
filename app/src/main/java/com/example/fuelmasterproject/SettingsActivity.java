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

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_list);

        Toolbar toolbar = findViewById(R.id.toolbarList);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Settings");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        TextView tvEmptyMessage = findViewById(R.id.tvEmptyMessage);
        FloatingActionButton fabAdd = findViewById(R.id.fabAdd);

        tvEmptyMessage.setText("No settings found");

        List<GenericItem> items = Arrays.asList(
                new GenericItem("Station Name", "Fuel Master AI Station #01 (Lahore Bypass)", "Active", "success", R.drawable.ic_settings),
                new GenericItem("Currency & Units", "Pakistani Rupee (PKR) & Litres (L)", "Default", "info", R.drawable.ic_settings),
                new GenericItem("FBR Integration", "NITB API Connection", "Enabled", "success", R.drawable.ic_settings),
                new GenericItem("App Version", "v2.5.0 (Production Build)", "Latest", "success", R.drawable.ic_settings)
        );

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new GenericAdapter(items));

        fabAdd.setOnClickListener(v -> Toast.makeText(this, "Save Settings", Toast.LENGTH_SHORT).show());
    }
}
