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
            setPadding(80, 200, 80, 80)
        }
        
        val title = TextView(this).apply {
            text = "MIAPOLY\nICT CENTER\nManagement System"
            textSize = 24f
            setPadding(0,0,100)
        }
        
        val userInput = EditText(this).apply { hint = "Username (admin)" }
        val passInput = EditText(this).apply { 
            hint = "Password (admin123)"
            inputType = android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
        }
        
        val loginBtn = Button(this).apply { text = "LOGIN" }
        val info = TextView(this).apply { text = "\nDefault: admin / admin123\nAhmad M. Kareto Project"; textSize = 12f }
        
        loginBtn.setOnClickListener {
            if(userInput.text.toString() == "admin" && passInput.text.toString() == "admin123") {
                startActivity(Intent(this, DashboardActivity::class.java))
            } else {
                Toast.makeText(this, "Invalid! Use admin / admin123", Toast.LENGTH_LONG).show()
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