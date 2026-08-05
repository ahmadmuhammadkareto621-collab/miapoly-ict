package com.miapoly.ictcenter

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(100, 200, 100, 100)
        }
        val title = TextView(this).apply {
            text = "MIAPOLY ICT CENTER\nManagement System"
            textSize = 20f
        }
        val userInput = EditText(this).apply { hint = "Username" }
        val passInput = EditText(this).apply {
            hint = "Password"
            inputType = android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
        }
        val loginBtn = Button(this).apply { text = "Login" }
        val info = TextView(this).apply { text = "Use: admin / admin123" }

        loginBtn.setOnClickListener {
            val u = userInput.text.toString()
            val p = passInput.text.toString()
            if (u == "admin" && p == "admin123") {
                startActivity(Intent(this, DashboardActivity::class.java))
            } else {
                Toast.makeText(this, "Invalid login", Toast.LENGTH_SHORT).show()
            }
        }

        layout.addView(title)
        layout.addView(userInput)
        layout.addView(passInput)
        layout.addView(loginBtn)
        layout.addView(info)
        setContentView(layout)
    }
}