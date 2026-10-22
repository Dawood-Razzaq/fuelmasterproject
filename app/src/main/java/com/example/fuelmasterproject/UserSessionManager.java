package com.example.fuelmasterproject;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONException;
import org.json.JSONObject;

public class UserSessionManager {
    private static final String PREF_NAME = "FuelMasterPrefs";
    private static final String KEY_LOGGED_IN_USER = "logged_in_user";
    private static final String KEY_LOGGED_IN_ROLE = "logged_in_role";
    private static final String KEY_LOGGED_IN_NAME = "logged_in_name";
    private static final String KEY_IS_LOGGED_IN = "is_logged_in";

    private final SharedPreferences prefs;

    public UserSessionManager(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        seedDefaultUsers();
    }

    private void seedDefaultUsers() {
        // Seed default accounts if not already present
        if (!prefs.contains("user_admin")) {
            registerUser("admin", PasswordUtils.hashPassword("admin123"), "Admin", "Rai Dawood (Owner)");
        }
        if (!prefs.contains("user_manager")) {
            registerUser("manager", PasswordUtils.hashPassword("mgr123"), "Station Manager", "Ali Ahmed (Manager)");
        }
        if (!prefs.contains("user_employee")) {
            registerUser("employee", PasswordUtils.hashPassword("emp123"), "Employee", "Usman Khan (Cashier)");
        }
    }

    public boolean registerUser(String username, String passwordHash, String role, String fullName) {
        String key = "user_" + username.toLowerCase().trim();
        if (prefs.contains(key)) {
            return false; // User already exists
        }
        try {
            JSONObject obj = new JSONObject();
            obj.put("username", username);
            obj.put("password", passwordHash);
            obj.put("role", role);
            obj.put("fullName", fullName);
            prefs.edit().putString(key, obj.toString()).apply();
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean validateUser(String username, String passwordHash) {
        String key = "user_" + username.toLowerCase().trim();
        String jsonStr = prefs.getString(key, null);
        if (jsonStr == null) return false;
        try {
            JSONObject obj = new JSONObject(jsonStr);
            String storedHash = obj.getString("password");
            return storedHash.equals(passwordHash);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public UserInfo getUserInfo(String username) {
        String key = "user_" + username.toLowerCase().trim();
        String jsonStr = prefs.getString(key, null);
        if (jsonStr == null) return null;
        try {
            JSONObject obj = new JSONObject(jsonStr);
            return new UserInfo(
                    obj.getString("username"),
                    obj.getString("role"),
                    obj.getString("fullName")
            );
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void createSession(String username) {
        UserInfo info = getUserInfo(username);
        if (info != null) {
            prefs.edit()
                    .putBoolean(KEY_IS_LOGGED_IN, true)
                    .putString(KEY_LOGGED_IN_USER, info.username)
                    .putString(KEY_LOGGED_IN_ROLE, info.role)
                    .putString(KEY_LOGGED_IN_NAME, info.fullName)
                    .apply();
        }
    }

    public boolean isLoggedIn() {
        return prefs.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    public void logout() {
        prefs.edit()
                .putBoolean(KEY_IS_LOGGED_IN, false)
                .remove(KEY_LOGGED_IN_USER)
                .remove(KEY_LOGGED_IN_ROLE)
                .remove(KEY_LOGGED_IN_NAME)
                .apply();
    }

    public String getLoggedInUser() {
        return prefs.getString(KEY_LOGGED_IN_USER, "");
    }

    public String getLoggedInRole() {
        return prefs.getString(KEY_LOGGED_IN_ROLE, "Admin");
    }

    public String getLoggedInName() {
        return prefs.getString(KEY_LOGGED_IN_NAME, "Rai Dawood");
    }

    public static class UserInfo {
        public String username;
        public String role;
        public String fullName;

        public UserInfo(String username, String role, String fullName) {
            this.username = username;
            this.role = role;
            this.fullName = fullName;
        }
    }
}
