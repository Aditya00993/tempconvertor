package com.example.tempconvertor

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private  lateinit var selectedUnitLayout: LinearLayout
    private lateinit var selectedUnitText:TextView
    private lateinit var editinput:EditText
    private lateinit var textResult: TextView
    private lateinit var textResultType: TextView



    private var selectedUnit:String = "Fahrenheit"



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        selectedUnitLayout = findViewById(R.id.selecttype)
        selectedUnitText = findViewById(R.id.textselect)
        editinput = findViewById(R.id.editinput)
        textResult = findViewById(R.id.textResult)
        textResultType = findViewById(R.id.textResultType)




        selectedUnitLayout.setOnClickListener() {
            showAlertDialog()

        }
        editinput.addTextChangedListener() {
            var resultText: String = ""
            var inputval = editinput.text.toString()
            val df = DecimalFormat("#.##")



            if (inputval.isNotEmpty()) {
                val doubleInput = inputval.toDouble()
                if (selectedUnit == "Fahrenheit") {


                    resultText = df.format((doubleInput - 32) * 5 / 9)
                    textResult.text = "Celsius"}
                else {
                    resultText = df.format((doubleInput * 9 / 5 + 32))
                    textResult.text = "Fahrenheit"
                }
                textResult.text = resultText


                }
            }
        }

   private fun showAlertDialog() {
        var alertDialog:AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
alertDialog.setTitle("Selectg Input Unit")
   val items = arrayOf("Fahrenheit","Celsius")
var checkedItem = -1
alertDialog.setSingleChoiceItems(items,checkedItem,DialogInterface.OnClickListener() { dialog, which ->
    selectedUnit = items[which]
    selectedUnitText.setText(selectedUnit)
})
        alertDialog.setPositiveButton(android.R.string.ok,DialogInterface.OnClickListener(){dialog, which ->
            dialog.dismiss()
        })
        val  alert = alertDialog
        alertDialog.show()
    }

}

