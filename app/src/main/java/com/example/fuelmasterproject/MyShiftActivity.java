package com.example.fuelmasterproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MyShiftActivity extends AppCompatActivity {

    private UserSessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        sessionManager = new UserSessionManager(this);
        if (!sessionManager.isLoggedIn()) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        setContentView(R.layout.activity_my_shift);

        Toolbar toolbar = findViewById(R.id.toolbarMyShift);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("My Shift");
            getSupportActionBar().setSubtitle("Dawood Fuel Station - Morning Shift");
        }

        TextView tvEmpName = findViewById(R.id.tvEmpName);
        TextView tvEmpRole = findViewById(R.id.tvEmpRole);
        tvEmpName.setText("Welcome, " + sessionManager.getLoggedInName());
        tvEmpRole.setText("Dawood Fuel Station - Morning Shift");

        Button btnShiftReconciliation = findViewById(R.id.btnShiftReconciliation);
        btnShiftReconciliation.setOnClickListener(v -> {
            startActivity(new Intent(this, ShiftReconciliationActivity.class));
        });

        Button btnLogoutEmp = findViewById(R.id.btnLogoutEmp);
        btnLogoutEmp.setOnClickListener(v -> {
            sessionManager.logout();
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }
}
