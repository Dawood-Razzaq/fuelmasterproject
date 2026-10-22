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

public class EmployeeManagementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_list);

        Toolbar toolbar = findViewById(R.id.toolbarList);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Employee Management");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        TextView tvEmptyMessage = findViewById(R.id.tvEmptyMessage);
        FloatingActionButton fabAdd = findViewById(R.id.fabAdd);

        tvEmptyMessage.setText("No employees found");

        List<GenericItem> items = Arrays.asList(
                new GenericItem("Rai Dawood", "Owner (Admin)", "Active", "success", R.drawable.ic_people),
                new GenericItem("Ali Ahmed", "Station Manager", "Active", "success", R.drawable.ic_people),
                new GenericItem("Usman Khan", "Cashier / Pump Operator", "Active", "success", R.drawable.ic_people),
                new GenericItem("Bilal Ahmed", "Cashier / Pump Operator", "Active", "success", R.drawable.ic_people),
                new GenericItem("Hamza Ali", "Forecourt Attendant", "On Leave", "info", R.drawable.ic_people)
        );

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new GenericAdapter(items));

        fabAdd.setOnClickListener(v -> Toast.makeText(this, "Add New Employee", Toast.LENGTH_SHORT).show());
    }
}
