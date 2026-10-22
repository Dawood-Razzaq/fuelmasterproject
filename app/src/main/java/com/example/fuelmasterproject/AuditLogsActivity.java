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

public class AuditLogsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_list);

        Toolbar toolbar = findViewById(R.id.toolbarList);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Audit Logs");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        TextView tvEmptyMessage = findViewById(R.id.tvEmptyMessage);
        FloatingActionButton fabAdd = findViewById(R.id.fabAdd);

        tvEmptyMessage.setText("No audit logs recorded");

        List<GenericItem> items = Arrays.asList(
                new GenericItem("Admin Login", "Rai Dawood logged in from IP 192.168.1.10", "Success", "success", R.drawable.ic_log),
                new GenericItem("Tank Fill Logged", "Petrol Tank 1 refilled by 5,000 L", "Recorded", "success", R.drawable.ic_log),
                new GenericItem("Price Update", "Petrol price updated to Rs. 250 / L", "Authorized", "info", R.drawable.ic_log)
        );

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new GenericAdapter(items));

        fabAdd.setOnClickListener(v -> Toast.makeText(this, "Export Audit Logs", Toast.LENGTH_SHORT).show());
    }
}
