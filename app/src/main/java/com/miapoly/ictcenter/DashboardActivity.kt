package com.miapoly.ictcenter

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(80,100,80,80)
        }
        
        val title = TextView(this).apply {
            text = "DASHBOARD\nMIAPOLY ICT CENTER"
            textSize = 22f
        }
        
        val btnCustomer = Button(this).apply { text = "1. Customer Registration" }
        val btnTransaction = Button(this).apply { text = "2. Services & Billing" }
        val btnReports = Button(this).apply { text = "3. Daily / Monthly Reports" }
        val btnLogout = Button(this).apply { text = "Logout" }
        
        btnCustomer.setOnClickListener { startActivity(Intent(this, CustomerActivity::class.java)) }
        btnTransaction.setOnClickListener { startActivity(Intent(this, TransactionActivity::class.java)) }
        btnReports.setOnClickListener { startActivity(Intent(this, ReportsActivity::class.java)) }
        btnLogout.setOnClickListener { finish() }
        
        layout.addView(title)
        layout.addView(btnCustomer)
        layout.addView(btnTransaction)
        layout.addView(btnReports)
        layout.addView(btnLogout)
        setContentView(layout)
    }
}