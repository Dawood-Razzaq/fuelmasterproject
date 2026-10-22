# ⛽ Fuel Master - Smart Fuel Station ERP & Management System

Fuel Master is a modern, high-performance Android Enterprise Resource Planning (ERP) and station management application built with **Java** and **Jetpack Material Components**, designed for fuel station owners, station managers, and forecourt cashiers/attendants.

---

## ✨ Key Features & Modules

- **📊 Live Dashboard (Admin / Manager):** Real-time KPI tracking (Revenue, Petrol/Diesel Sold, Active Employees), warning/success alert banners, Canvas-drawn Today's Hourly Sales chart, and interactive Underground Tank Level indicators with dynamic progress bars.
- **🏢 Tank & Inventory Management:** Monitor underground fuel tanks (`Petrol T1/T2`, `Diesel T1/T2`) with capacity, percentage thresholds, and reorder warnings.
- **👥 Employee & Attendance Tracking:** Staff management, role assignments, circular avatar initials, and attendance status chips (`On Time`, `Late`, `On Leave`).
- **⛽ Pump & Nozzle Management:** Track nozzle status, active operations, and maintenance schedules.
- **💼 Shift Reconciliation:** Manage cashier shifts, sales totals, cash reconciliation, and handovers.
- **📈 Commercial & Reporting:** CRM for corporate/fleet clients (Daewoo Express, Metro Bus, Uber), supplier management (PSO, Attock, Shell, Total Parco), purchase orders, expense tracking, FBR-compliant tax reports, and audit logs.
- **🌐 Bilingual Support:** Built-in English and Urdu (اردو) language toggle.
- **📱 Responsive & Robust UI:** Designed with Material 3 light theme (`#0B2447` Navy, `#1D4ED8` Primary Blue, `#F97316` Accent Orange, `#F1F5F9` Background), beautiful MaterialCardView cards, status chips, floating action buttons, and complete landscape rotation support with state restoration.

---

## 🛠️ Tech Stack

- **Language:** Java
- **UI Architecture:** ConstraintLayout, Material Components (Material3 Light Theme), RecyclerView, Custom Canvas Views (`HourlySalesView`)
- **Navigation:** Navigation Drawer with structured section headers (`OVERVIEW`, `FUEL OPERATIONS`, `OPERATIONS`, `COMMERCIAL`, `REPORTING`)
- **State Management & Storage:** SharedPreferences (User session handling and persistent multi-role authentication)
- **Compatibility:** Optimized for both portrait and landscape orientations with full state preservation (`onSaveInstanceState`).

---

## 🚀 Getting Started

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/FuelMasterproject.git
   ```
2. Open the project in **Android Studio**.
3. Sync Gradle and run the app on an Android emulator or physical device.

---

## 👨‍💻 Author
**Rai Dawood**
