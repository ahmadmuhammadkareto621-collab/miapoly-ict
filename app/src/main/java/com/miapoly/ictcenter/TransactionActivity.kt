package com.miapoly.ictcenter

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class TransactionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(60,60,60,60)
        }
        
        val title = TextView(this).apply { text = "Services & Billing\n(Payment & Receipt Generation)"; textSize = 18f }
        val services = arrayOf("Printing - N50/page", "Photocopy - N20/page", "Scanning - N100", "Typing - N200/page", "Browsing - N300/hr", "Training - N5000", "Lamination - N200", "Passport Photo - N500", "Graphic Design - N2000")
        val spinner = Spinner(this).apply {
            adapter = ArrayAdapter(this@TransactionActivity, android.R.layout.simple_spinner_dropdown_item, services)
        }
        val qtyInput = EditText(this).apply { hint = "Quantity / Pages / Hours"; inputType = android.text.InputType.TYPE_CLASS_NUMBER }
        val calcBtn = Button(this).apply { text = "Calculate & Generate Receipt" }
        val receiptView = TextView(this).apply { text = "\nReceipt will appear here"; textSize = 14f }
        
        calcBtn.setOnClickListener {
            val prices = intArrayOf(50,20,100,200,300,5000,200,500,2000)
            val pos = spinner.selectedItemPosition
            val qty = qtyInput.text.toString().toIntOrNull() ?: 1
            val total = prices[pos] * qty
            val date = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault()).format(Date())
            val receipt = """
                --- MIAPOLY ICT CENTER RECEIPT ---
                Date: $date
                Service: ${services[pos]}
                Qty: $qty
                Total: N$total
                Status: PAID
                Staff: Admin

                Thank you for patronizing!
                Project by Ahmad M. Kareto
            """.trimIndent()
            receiptView.text = receipt
        }
        
        layout.addView(title); layout.addView(spinner); layout.addView(qtyInput); layout.addView(calcBtn); layout.addView(receiptView)
        setContentView(ScrollView(this).apply { addView(layout) })
    }
}