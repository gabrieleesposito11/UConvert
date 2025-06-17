package com.example.myapplication515454545

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView


class area_cal : AppCompatActivity() {
    private lateinit var cv_fromUnit: CardView
    private lateinit var cv_toUnit: CardView
    private lateinit var cv_convert: CardView
    private lateinit var mCLayout: RelativeLayout
    private var fromUnit = "Metri quadrati"
    private var toUnit = "Piedi quadrati"
    private lateinit var tv_fromUnit: TextView
    private lateinit var tv_toUnit: TextView
    private lateinit var et_fromUnit: EditText
    private lateinit var et_toUnit: EditText
    private lateinit var buttonRobot: ImageButton // pulsante robot
    private val units = arrayOf(
        "Acri",
        "Are",
        "Ettari",
        "Centimetri quadrati",
        "Piedi quadrati",
        "Pollici quadrati",
        "Metri quadrati"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_area_cal)
        cv_fromUnit = findViewById(R.id.fromUnit)
        cv_toUnit = findViewById(R.id.toUnit)
        cv_convert = findViewById(R.id.cv_convert)
        mCLayout = findViewById(R.id.area_relativeLayout)
        tv_fromUnit = findViewById(R.id.tv_fromUnit)
        tv_toUnit = findViewById(R.id.tv_toUnit)
        tv_fromUnit.text = fromUnit
        tv_toUnit.text = toUnit
        et_fromUnit = findViewById(R.id.et_fromUnit)
        et_toUnit = findViewById(R.id.et_toUnit)
        buttonRobot = findViewById(R.id.button_robot) // Riferimento all'pulsante robot nel layout

        buttonRobot.setOnClickListener {
            // Mostra un AlertDialog quando si preme sull'ImageButton
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Benvenuto nel menu Area") // Titolo del messaggio
            builder.setMessage("Ciao!, Io sono 2FV,\nSapevi che per passare da cm quadrati a m quadrati devi moltiplicare il valore per 0.0001") // Testo del messaggio
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss() // Chiudi il dialog quando si preme OK
            }
            val dialog = builder.create()
            dialog.show() // Mostra il dialog
        }

        cv_convert.setOnClickListener {
            val areaInput = et_fromUnit.text.toString()
            if (areaInput.isBlank()) {
                et_fromUnit.error = "Please enter some value"
            } else {
                val inputArea = areaInput.toDouble()
                val convertedArea = convertArea(inputArea, fromUnit, toUnit)
                et_toUnit.setText(convertedArea)
            }
        }

        cv_toUnit.setOnClickListener {
            showUnitSelectionDialog(true)
        }

        cv_fromUnit.setOnClickListener {
            showUnitSelectionDialog(false)
        }
    }

    private fun showUnitSelectionDialog(isToUnit: Boolean) {
        val builder = AlertDialog.Builder(this@area_cal)
        val title = if (isToUnit) "Select To Unit" else "Select From Unit"
        builder.setTitle(title)
        val selectedItem = if (isToUnit) units.indexOf(toUnit) else units.indexOf(fromUnit)
        builder.setSingleChoiceItems(units, selectedItem) { dialogInterface, i ->
            if (isToUnit) {
                toUnit = units[i]
                tv_toUnit.text = toUnit
            } else {
                fromUnit = units[i]
                tv_fromUnit.text = fromUnit
            }
            dialogInterface.dismiss()
        }
        builder.setPositiveButton("OK") { dialogInterface, _ ->
            dialogInterface.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }

    private fun convertArea(value: Double, fromUnit: String, toUnit: String): String {
        return when (fromUnit) {
            "Acri" -> when (toUnit) {
                "Are" -> (value * 40.4686).toString()
                "Ettari" -> (value * 0.404686).toString()
                "Centimetri quadrati" -> (value * 40468564.2).toString()
                "Piedi quadrati" -> (value * 43560).toString()
                "Pollici quadrati" -> (value * 6272640).toString()
                "Metri quadrati" -> (value * 4046.86).toString()
                else -> value.toString()
            }
            "Are" -> when (toUnit) {
                "Acri" -> (value * 0.0247105).toString()
                "Ettari" -> (value * 0.01).toString()
                "Centimetri quadrati" -> (value * 1000000).toString()
                "Piedi quadrati" -> (value * 1076.39).toString()
                "Pollici quadrati" -> (value * 155000.31).toString()
                "Metri quadrati" -> (value * 100).toString()
                else -> value.toString()
            }
            "Ettari" -> when (toUnit) {
                "Acri" -> (value * 2.47105).toString()
                "Are" -> (value * 100).toString()
                "Centimetri quadrati" -> (value * 100000000).toString()
                "Piedi quadrati" -> (value * 107639.1).toString()
                "Pollici quadrati" -> (value * 15500031).toString()
                "Metri quadrati" -> (value * 10000).toString()
                else -> value.toString()
            }
            "Centimetri quadrati" -> when (toUnit) {
                "Acri" -> (value * 2.47105e-8).toString()
                "Are" -> (value * 1e-4).toString()
                "Ettari" -> (value * 1e-8).toString()
                "Piedi quadrati" -> (value * 0.00107639).toString()
                "Pollici quadrati" -> (value * 0.155).toString()
                "Metri quadrati" -> (value * 0.0001).toString()
                else -> value.toString()
            }
            "Piedi quadrati" -> when (toUnit) {
                "Acri" -> (value * 2.29568e-5).toString()
                "Are" -> (value * 9.2903e-2).toString()
                "Ettari" -> (value * 9.2903e-3).toString()
                "Centimetri quadrati" -> (value * 929.03).toString()
                "Pollici quadrati" -> (value * 144).toString()
                "Metri quadrati" -> (value * 0.092903).toString()
                else -> value.toString()
            }
            "Pollici quadrati" -> when (toUnit) {
                "Acri" -> (value * 1.59423e-7).toString()
                "Are" -> (value * 6.4516e-4).toString()
                "Ettari" -> (value * 6.4516e-5).toString()
                "Centimetri quadrati" -> (value * 6.4516).toString()
                "Piedi quadrati" -> (value * 0.00694444).toString()
                "Metri quadrati" -> (value * 0.00064516).toString()
                else -> value.toString()
            }
            "Metri quadrati" -> when (toUnit) {
                "Acri" -> (value * 0.000247105).toString()
                "Are" -> (value * 100).toString()
                "Ettari" -> (value * 0.01).toString()
                "Centimetri quadrati" -> (value * 10000).toString()
                "Piedi quadrati" -> (value * 10.7639).toString()
                "Pollici quadrati" -> (value * 1550.0031).toString()
                else -> value.toString()
            }
            else -> value.toString()
        }
    }
}
