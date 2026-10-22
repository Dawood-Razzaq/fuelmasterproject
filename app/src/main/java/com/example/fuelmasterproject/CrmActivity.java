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

public class CrmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_list);

        Toolbar toolbar = findViewById(R.id.toolbarList);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("CRM");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        TextView tvEmptyMessage = findViewById(R.id.tvEmptyMessage);
        FloatingActionButton fabAdd = findViewById(R.id.fabAdd);

        tvEmptyMessage.setText("No corporate accounts yet");

        List<GenericItem> items = Arrays.asList(
                new GenericItem("Daewoo Express Fleet", "Credit Limit: Rs. 500,000 | Balance: Rs. 1,42,000", "Active", "success", R.drawable.ic_supplier),
                new GenericItem("Metro Bus Lahore", "Credit Limit: Rs. 1,000,000 | Balance: Rs. 3,80,000", "Active", "success", R.drawable.ic_supplier),
                new GenericItem("Uber Partner Fleet", "Credit Limit: Rs. 200,000 | Balance: Rs. 45,000", "Active", "success", R.drawable.ic_supplier)
        );

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new GenericAdapter(items));

        fabAdd.setOnClickListener(v -> Toast.makeText(this, "Add Corporate Client", Toast.LENGTH_SHORT).show());
    }
}
