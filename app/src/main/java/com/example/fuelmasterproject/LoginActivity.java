package com.example.fuelmasterproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText etUsername, etPassword;
    private Button btnLogin;
    private TextView tvLoginError, tvCreateAccount;
    private UserSessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManager = new UserSessionManager(this);

        if (sessionManager.isLoggedIn()) {
            openDashboard();
            finish();
            return;
        }

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvLoginError = findViewById(R.id.tvLoginError);
        tvCreateAccount = findViewById(R.id.tvCreateAccount);

        if (savedInstanceState != null) {
            if (etUsername != null) etUsername.setText(savedInstanceState.getString("saved_username", ""));
            if (etPassword != null) etPassword.setText(savedInstanceState.getString("saved_password", ""));
        }

        btnLogin.setOnClickListener(v -> handleLogin());
        tvCreateAccount.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, SignupActivity.class));
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (etUsername != null && etUsername.getText() != null) {
            outState.putString("saved_username", etUsername.getText().toString());
        }
        if (etPassword != null && etPassword.getText() != null) {
            outState.putString("saved_password", etPassword.getText().toString());
        }
    }

    private void handleLogin() {
        tvLoginError.setVisibility(View.GONE);
        String username = etUsername.getText() != null ? etUsername.getText().toString().trim() : "";
        String password = etPassword.getText() != null ? etPassword.getText().toString() : "";

        if (username.isEmpty() || password.isEmpty()) {
            showError(getString(R.string.error_empty_fields));
            return;
        }

        String passwordHash = PasswordUtils.hashPassword(password);
        if (sessionManager.validateUser(username, passwordHash)) {
            sessionManager.createSession(username);
            openDashboard();
            finish();
        } else {
            showError(getString(R.string.error_invalid_credentials));
        }
    }

    private void showError(String msg) {
        tvLoginError.setText(msg);
        tvLoginError.setVisibility(View.VISIBLE);
    }

    private void openDashboard() {
        Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
        startActivity(intent);
    }
}
