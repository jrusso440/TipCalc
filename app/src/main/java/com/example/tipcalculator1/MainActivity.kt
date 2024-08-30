package com.example.tipcalculator1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val billAmountEditText = findViewById<EditText>(R.id.billAmountEditText)
        val tipRadioGroup = findViewById<RadioGroup>(R.id.tipRadioGroup)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val tipAmountTextView = findViewById<TextView>(R.id.tipAmountTextView)
        val totalAmountTextView = findViewById<TextView>(R.id.totalAmountTextView)

        calculateButton.setOnClickListener {
            val billAmountString = billAmountEditText.text.toString()
            if (billAmountString.isEmpty()) {
                tipAmountTextView.text = "Please enter a bill amount"
                totalAmountTextView.text = ""
                return@setOnClickListener
            }

            val billAmount = billAmountString.toDouble()
            val selectedTipId = tipRadioGroup.checkedRadioButtonId
            val tipPercentage = when (selectedTipId) {
                R.id.tip10 -> 0.10
                R.id.tip15 -> 0.15
                R.id.tip20 -> 0.20
                else -> 0.0
            }

            val tipAmount = billAmount * tipPercentage
            val totalAmount = billAmount + tipAmount

            tipAmountTextView.text = "Tip amount: $%.2f".format(tipAmount)
            totalAmountTextView.text = "Total amount: $%.2f".format(totalAmount)
        }
    }
}
