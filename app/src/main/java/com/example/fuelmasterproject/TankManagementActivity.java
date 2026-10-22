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

public class TankManagementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_list);

        Toolbar toolbar = findViewById(R.id.toolbarList);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Tank Management");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        TextView tvEmptyMessage = findViewById(R.id.tvEmptyMessage);
        FloatingActionButton fabAdd = findViewById(R.id.fabAdd);

        tvEmptyMessage.setText("No tanks configured");

        List<TankItem> tanks = Arrays.asList(
                new TankItem("Petrol Tank 1", "12,500 L / 15,000 L", 83, "Active", "success"),
                new TankItem("Petrol Tank 2", "3,200 L / 10,000 L", 32, "Low Alert", "warning"),
                new TankItem("Diesel Tank 1", "8,400 L / 15,000 L", 56, "Active", "success"),
                new TankItem("Diesel Tank 2", "7,100 L / 10,000 L", 71, "Active", "success")
        );

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new TankAdapter(tanks));

        fabAdd.setOnClickListener(v -> Toast.makeText(this, "Log Tank Fill", Toast.LENGTH_SHORT).show());
    }
}
