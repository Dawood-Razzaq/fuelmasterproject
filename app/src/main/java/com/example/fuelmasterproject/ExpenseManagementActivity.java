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

public class ExpenseManagementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_list);

        Toolbar toolbar = findViewById(R.id.toolbarList);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Expense Management");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        TextView tvEmptyMessage = findViewById(R.id.tvEmptyMessage);
        FloatingActionButton fabAdd = findViewById(R.id.fabAdd);

        tvEmptyMessage.setText("No expenses recorded");

        List<GenericItem> items = Arrays.asList(
                new GenericItem("Electricity Bill", "WAPDA Meter #4201 — June 2024", "Rs. 85,000", "warning", R.drawable.ic_expense),
                new GenericItem("Generator Maintenance", "Diesel & Filters Replacement", "Rs. 18,500", "success", R.drawable.ic_expense),
                new GenericItem("Stationary & Supplies", "Receipt Rolls & Office Items", "Rs. 4,200", "success", R.drawable.ic_expense)
        );

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new GenericAdapter(items));

        fabAdd.setOnClickListener(v -> Toast.makeText(this, "Add Expense Record", Toast.LENGTH_SHORT).show());
    }
}
