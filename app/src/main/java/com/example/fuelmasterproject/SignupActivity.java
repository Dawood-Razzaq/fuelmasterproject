package com.example.fuelmasterproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class SignupActivity extends AppCompatActivity {

    private TextInputEditText etFullName, etUsername, etPassword, etConfirmPassword;
    private Spinner spinnerRole;
    private Button btnSignup;
    private TextView tvSignupError, tvLoginLink;
    private UserSessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        sessionManager = new UserSessionManager(this);

        etFullName = findViewById(R.id.etFullName);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etConfirmPassword = findViewById(R.id.etConfirmPassword);
        spinnerRole = findViewById(R.id.spinnerRole);
        btnSignup = findViewById(R.id.btnSignup);
        tvSignupError = findViewById(R.id.tvSignupError);
        tvLoginLink = findViewById(R.id.tvLoginLink);

        String[] roles = {"Admin", "Station Manager", "Employee"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, roles);
        spinnerRole.setAdapter(adapter);

        if (savedInstanceState != null) {
            if (etFullName != null) etFullName.setText(savedInstanceState.getString("saved_fullname", ""));
            if (etUsername != null) etUsername.setText(savedInstanceState.getString("saved_username", ""));
            if (etPassword != null) etPassword.setText(savedInstanceState.getString("saved_password", ""));
            if (etConfirmPassword != null) etConfirmPassword.setText(savedInstanceState.getString("saved_confirm", ""));
            if (spinnerRole != null) spinnerRole.setSelection(savedInstanceState.getInt("saved_role_index", 0));
        }

        btnSignup.setOnClickListener(v -> handleSignup());
        tvLoginLink.setOnClickListener(v -> finish());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (etFullName != null && etFullName.getText() != null) outState.putString("saved_fullname", etFullName.getText().toString());
        if (etUsername != null && etUsername.getText() != null) outState.putString("saved_username", etUsername.getText().toString());
        if (etPassword != null && etPassword.getText() != null) outState.putString("saved_password", etPassword.getText().toString());
        if (etConfirmPassword != null && etConfirmPassword.getText() != null) outState.putString("saved_confirm", etConfirmPassword.getText().toString());
        if (spinnerRole != null) outState.putInt("saved_role_index", spinnerRole.getSelectedItemPosition());
    }

    private void handleSignup() {
        tvSignupError.setVisibility(View.GONE);
        String fullName = etFullName.getText() != null ? etFullName.getText().toString().trim() : "";
        String username = etUsername.getText() != null ? etUsername.getText().toString().trim() : "";
        String password = etPassword.getText() != null ? etPassword.getText().toString() : "";
        String confirmPassword = etConfirmPassword.getText() != null ? etConfirmPassword.getText().toString() : "";
        String role = spinnerRole.getSelectedItem() != null ? spinnerRole.getSelectedItem().toString() : "Employee";

        if (fullName.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            showError(getString(R.string.error_empty_fields));
            return;
        }

        if (password.length() < 6) {
            showError(getString(R.string.error_password_length));
            return;
        }

        if (!password.equals(confirmPassword)) {
            showError(getString(R.string.error_password_mismatch));
            return;
        }

        String passwordHash = PasswordUtils.hashPassword(password);
        boolean success = sessionManager.registerUser(username, passwordHash, role, fullName);
        if (success) {
            sessionManager.createSession(username);
            Intent intent = new Intent(SignupActivity.this, DashboardActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        } else {
            showError(getString(R.string.error_username_taken));
        }
    }

    private void showError(String msg) {
        tvSignupError.setText(msg);
        tvSignupError.setVisibility(View.VISIBLE);
    }
}
