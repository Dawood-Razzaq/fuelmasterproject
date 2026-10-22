package com.example.fuelmasterproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class DashboardActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navView;
    private UserSessionManager sessionManager;
    private boolean isUrdu = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        sessionManager = new UserSessionManager(this);
        if (!sessionManager.isLoggedIn()) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        if ("Employee".equalsIgnoreCase(sessionManager.getLoggedInRole())) {
            startActivity(new Intent(this, MyShiftActivity.class));
            finish();
            return;
        }

        setContentView(R.layout.activity_dashboard);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerLayout);
        navView = findViewById(R.id.navView);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        View headerView = navView.getHeaderView(0);
        TextView tvNavHeaderUser = headerView.findViewById(R.id.tvNavHeaderUser);
        TextView tvNavHeaderRole = headerView.findViewById(R.id.tvNavHeaderRole);
        TextView tvNavInitials = headerView.findViewById(R.id.tvNavInitials);
        
        String name = sessionManager.getLoggedInName();
        String role = sessionManager.getLoggedInRole();
        
        tvNavHeaderUser.setText(name);
        tvNavHeaderRole.setText(role);
        
        String initials = "RD";
        if (name != null && !name.isEmpty()) {
            String[] parts = name.split(" ");
            if (parts.length >= 2) {
                initials = ("" + parts[0].charAt(0) + parts[1].charAt(0)).toUpperCase();
            } else if (name.length() >= 2) {
                initials = name.substring(0, 2).toUpperCase();
            }
        }
        tvNavInitials.setText(initials);

        TextView tvWelcomeUser = findViewById(R.id.tvWelcomeUser);
        TextView tvUserRoleBadge = findViewById(R.id.tvUserRoleBadge);
        tvWelcomeUser.setText("Welcome, " + name);
        tvUserRoleBadge.setText(role);

        Button btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(v -> {
            sessionManager.logout();
            Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

        Button btnLangToggle = findViewById(R.id.btnLangToggle);
        btnLangToggle.setOnClickListener(v -> {
            isUrdu = !isUrdu;
            Toast.makeText(this, isUrdu ? "اردو موڈ فعال (Urdu mode active)" : "English mode active", Toast.LENGTH_SHORT).show();
            btnLangToggle.setText(isUrdu ? "English" : "اردو");
        });

        findViewById(R.id.btnNavFuelInventory).setOnClickListener(v -> startActivity(new Intent(this, FuelInventoryActivity.class)));
        findViewById(R.id.btnNavShiftReconciliation).setOnClickListener(v -> startActivity(new Intent(this, ShiftReconciliationActivity.class)));
        findViewById(R.id.btnNavEmployeeManagement).setOnClickListener(v -> startActivity(new Intent(this, EmployeeManagementActivity.class)));
        findViewById(R.id.btnNavAttendance).setOnClickListener(v -> startActivity(new Intent(this, AttendanceActivity.class)));

        navView.setNavigationItemSelectedListener(item -> {
            drawerLayout.closeDrawers();
            int id = item.getItemId();
            if (id == R.id.nav_dashboard) {
                // already here
            } else if (id == R.id.nav_fuel_inventory) {
                startActivity(new Intent(this, FuelInventoryActivity.class));
            } else if (id == R.id.nav_tank_management) {
                startActivity(new Intent(this, TankManagementActivity.class));
            } else if (id == R.id.nav_pump_nozzle) {
                startActivity(new Intent(this, PumpNozzleActivity.class));
            } else if (id == R.id.nav_shift_reconciliation) {
                startActivity(new Intent(this, ShiftReconciliationActivity.class));
            } else if (id == R.id.nav_employee_management) {
                startActivity(new Intent(this, EmployeeManagementActivity.class));
            } else if (id == R.id.nav_attendance) {
                startActivity(new Intent(this, AttendanceActivity.class));
            } else if (id == R.id.nav_crm) {
                startActivity(new Intent(this, CrmActivity.class));
            } else if (id == R.id.nav_supplier_management) {
                startActivity(new Intent(this, SupplierManagementActivity.class));
            } else if (id == R.id.nav_purchase_management) {
                startActivity(new Intent(this, PurchaseManagementActivity.class));
            } else if (id == R.id.nav_expense_management) {
                startActivity(new Intent(this, ExpenseManagementActivity.class));
            } else if (id == R.id.nav_reports) {
                startActivity(new Intent(this, ReportsActivity.class));
            } else if (id == R.id.nav_audit_logs) {
                startActivity(new Intent(this, AuditLogsActivity.class));
            } else if (id == R.id.nav_settings) {
                startActivity(new Intent(this, SettingsActivity.class));
            }
            return true;
        });
    }
}
