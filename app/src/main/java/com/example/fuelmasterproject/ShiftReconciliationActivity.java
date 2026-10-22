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

public class ShiftReconciliationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_list);

        Toolbar toolbar = findViewById(R.id.toolbarList);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Shift Reconciliation");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        TextView tvEmptyMessage = findViewById(R.id.tvEmptyMessage);
        FloatingActionButton fabAdd = findViewById(R.id.fabAdd);

        tvEmptyMessage.setText("No pending shifts");

        List<GenericItem> items = Arrays.asList(
                new GenericItem("Shift 2", "Cashier: Usman Khan | Sales: Rs. 86,250", "Pending", "warning", R.drawable.ic_shift),
                new GenericItem("Shift 1", "Cashier: Bilal Ahmed | Sales: Rs. 1,41,200", "Reconciled", "success", R.drawable.ic_shift),
                new GenericItem("Shift 3", "Cashier: Hamza Ali | Sales: Rs. 98,000", "Pending", "warning", R.drawable.ic_shift)
        );

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new GenericAdapter(items));

        fabAdd.setOnClickListener(v -> Toast.makeText(this, "Start New Shift", Toast.LENGTH_SHORT).show());
    }
}
