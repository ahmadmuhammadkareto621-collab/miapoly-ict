package com.miapoly.ictcenter

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class CustomerActivity : AppCompatActivity() {
    private val customers = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(60,60,60,60)
        }
        
        val title = TextView(this).apply { text = "Customer Registration\n(Section 3.5)"; textSize = 20f }
        val idInput = EditText(this).apply { hint = "Customer ID (CUST001)" }
        val nameInput = EditText(this).apply { hint = "Customer Name" }
        val phoneInput = EditText(this).apply { hint = "Phone Number" }
        val emailInput = EditText(this).apply { hint = "Email (optional)" }
        val saveBtn = Button(this).apply { text = "Save Customer" }
        val listView = TextView(this).apply { text = "\nSaved Customers:\n"; textSize = 14f }
        
        saveBtn.setOnClickListener {
            val data = "${idInput.text} - ${nameInput.text} - ${phoneInput.text}"
            if(nameInput.text.isNotEmpty()){
                customers.add(data)
                listView.text = "Saved Customers:\n" + customers.joinToString("\n")
                idInput.text.clear(); nameInput.text.clear(); phoneInput.text.clear(); emailInput.text.clear()
                Toast.makeText(this, "Customer Saved!", Toast.LENGTH_SHORT).show()
            }
        }
        
        layout.addView(title); layout.addView(idInput); layout.addView(nameInput)
        layout.addView(phoneInput); layout.addView(emailInput); layout.addView(saveBtn); layout.addView(listView)
        setContentView(ScrollView(this).apply { addView(layout) })
    }
}