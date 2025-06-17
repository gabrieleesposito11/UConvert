package com.example.myapplication515454545

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class lunghezza_cal : AppCompatActivity() {
    private lateinit var cv_fromUnit: CardView
    private lateinit var cv_toUnit: CardView
    private lateinit var cv_convert: CardView
    private lateinit var mCLayout: RelativeLayout
    private var fromUnit = "Millimetri"
    private var toUnit = "Centimetri"
    private lateinit var tv_fromUnit: TextView
    private lateinit var tv_toUnit: TextView
    private lateinit var et_fromUnit: EditText
    private lateinit var et_toUnit: EditText
    private lateinit var buttonRobot: ImageButton // pulsante robot
    private val values = arrayOf(
        "Millimetri",
        "Centimetri",
        "Metri",
        "Chilometri",
        "Pollici",
        "Piedi",
        "Iarde",
        "Miglia",
        "Miglia nautiche",
        "Mils"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lunghezza_cal)
        cv_fromUnit = findViewById(R.id.fromUnit)
        cv_toUnit = findViewById(R.id.toUnit)
        cv_convert = findViewById(R.id.cv_convert)
        mCLayout = findViewById(R.id.lunghezza_relativeLayout)
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
            builder.setTitle("Benvenuto nel menu xx") // Titolo del messaggio
            builder.setMessage("Ciao!, Io sono 2FV,\nSapevi che per passare da metri a kilometri devi dividere il valore per 1000") // Testo del messaggio
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss() // Chiudi il dialog quando si preme OK
            }
            val dialog = builder.create()
            dialog.show() // Mostra il dialog
        }

        cv_convert.setOnClickListener {
            val lengthInput = et_fromUnit.text.toString()
            if (lengthInput.isBlank()) {
                et_fromUnit.error = "Please enter some value"
            } else {
                val inputLength = lengthInput.toDouble()
                val convertedLength = convertLength(inputLength, fromUnit, toUnit)
                et_toUnit.setText(convertedLength)
            }
        }

        cv_toUnit.setOnClickListener {
            val builder = AlertDialog.Builder(this@lunghezza_cal)
            builder.setTitle("Choose Unit")
            builder.setSingleChoiceItems(values, -1) { dialogInterface, i ->
                toUnit = values[i]
                tv_toUnit.text = toUnit
                dialogInterface.dismiss()
            }
            builder.setPositiveButton("OK") { dialogInterface, _ ->
                dialogInterface.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
        }

        cv_fromUnit.setOnClickListener {
            val builder = AlertDialog.Builder(this@lunghezza_cal)
            builder.setTitle("Choose Unit")
            builder.setSingleChoiceItems(values, -1) { dialogInterface, i ->
                fromUnit = values[i]
                tv_fromUnit.text = fromUnit
                dialogInterface.dismiss()
            }
            builder.setPositiveButton("OK") { dialogInterface, _ ->
                dialogInterface.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
        }
    }

    private fun convertLength(value: Double, fromUnit: String, toUnit: String): String {
        return when (fromUnit) {
            "Millimetri" -> when (toUnit) {
                "Centimetri" -> (value * 0.1).toString()
                "Metri" -> (value * 0.001).toString()
                "Chilometri" -> (value * 1e-6).toString()
                "Pollici" -> (value * 0.0393701).toString()
                "Piedi" -> (value * 0.00328084).toString()
                "Iarde" -> (value * 0.00109361).toString()
                "Miglia" -> (value * 6.2137e-7).toString()
                "Miglia nautiche" -> (value * 5.3996e-7).toString()
                "Mils" -> (value * 39370.1).toString()
                else -> value.toString()
            }
            "Centimetri" -> when (toUnit) {
                "Millimetri" -> (value * 10).toString()
                "Metri" -> (value * 0.01).toString()
                "Chilometri" -> (value * 1e-5).toString()
                "Pollici" -> (value * 0.393701).toString()
                "Piedi" -> (value * 0.0328084).toString()
                "Iarde" -> (value * 0.0109361).toString()
                "Miglia" -> (value * 6.2137e-6).toString()
                "Miglia nautiche" -> (value * 5.3996e-6).toString()
                "Mils" -> (value * 393.701).toString()
                else -> value.toString()
            }
            "Metri" -> when (toUnit) {
                "Millimetri" -> (value * 1000).toString()
                "Centimetri" -> (value * 100).toString()
                "Chilometri" -> (value * 0.001).toString()
                "Pollici" -> (value * 39.3701).toString()
                "Piedi" -> (value * 3.28084).toString()
                "Iarde" -> (value * 1.09361).toString()
                "Miglia" -> (value * 0.000621371).toString()
                "Miglia nautiche" -> (value * 0.000539957).toString()
                "Mils" -> (value * 39370.1).toString()
                else -> value.toString()
            }
            "Chilometri" -> when (toUnit) {
                "Millimetri" -> (value * 1e+6).toString()
                "Centimetri" -> (value * 1e+5).toString()
                "Metri" -> (value * 1000).toString()
                "Pollici" -> (value * 39370.1).toString()
                "Piedi" -> (value * 3280.84).toString()
                "Iarde" -> (value * 1093.61).toString()
                "Miglia" -> (value * 0.621371).toString()
                "Miglia nautiche" -> (value * 0.539957).toString()
                "Mils" -> (value * 3.93701e+7).toString()
                else -> value.toString()
            }
            "Pollici" -> when (toUnit) {
                "Millimetri" -> (value * 25.4).toString()
                "Centimetri" -> (value * 2.54).toString()
                "Metri" -> (value * 0.0254).toString()
                "Chilometri" -> (value * 2.54e-5).toString()
                "Piedi" -> (value * 0.0833333).toString()
                "Iarde" -> (value * 0.0277778).toString()
                "Miglia" -> (value * 0.000015783).toString()
                "Miglia nautiche" -> (value * 0.0000137149).toString()
                "Mils" -> (value * 1000).toString()
                else -> value.toString()
            }
            "Piedi" -> when (toUnit) {
                "Millimetri" -> (value * 304.8).toString()
                "Centimetri" -> (value * 30.48).toString()
                "Metri" -> (value * 0.3048).toString()
                "Chilometri" -> (value * 0.0003048).toString()
                "Pollici" -> (value * 12).toString()
                "Iarde" -> (value * 0.333333).toString()
                "Miglia" -> (value * 0.000189394).toString()
                "Miglia nautiche" -> (value * 0.000164579).toString()
                "Mils" -> (value * 12000).toString()
                else -> value.toString()
            }
            "Iarde" -> when (toUnit) {
                "Millimetri" -> (value * 914.4).toString()
                "Centimetri" -> (value * 91.44).toString()
                "Metri" -> (value * 0.9144).toString()
                "Chilometri" -> (value * 0.0009144).toString()
                "Pollici" -> (value * 36).toString()
                "Piedi" -> (value * 3).toString()
                "Miglia" -> (value * 0.000568182).toString()
                "Miglia nautiche" -> (value * 0.000493737).toString()
                "Mils" -> (value * 36000).toString()
                else -> value.toString()
            }
            "Miglia" -> when (toUnit) {
                "Millimetri" -> (value * 1609344).toString()
                "Centimetri" -> (value * 160934.4).toString()
                "Metri" -> (value * 1609.34).toString()
                "Chilometri" -> (value * 1.60934).toString()
                "Pollici" -> (value * 63360).toString()
                "Piedi" -> (value * 5280).toString()
                "Iarde" -> (value * 1760).toString()
                "Miglia nautiche" -> (value * 0.868976).toString()
                "Mils" -> (value * 63360000).toString()
                else -> value.toString()
            }
            "Miglia nautiche" -> when (toUnit) {
                "Millimetri" -> (value * 1852000).toString()
                "Centimetri" -> (value * 185200).toString()
                "Metri" -> (value * 1852).toString()
                "Chilometri" -> (value * 1.852).toString()
                "Pollici" -> (value * 72913.4).toString()
                "Piedi" -> (value * 6076.12).toString()
                "Iarde" -> (value * 2025.37).toString()
                "Miglia" -> (value * 1.15078).toString()
                "Mils" -> (value * 72913360).toString()
                else -> value.toString()
            }
            "Mils" -> when (toUnit) {
                "Millimetri" -> (value * 0.0254).toString()
                "Centimetri" -> (value * 0.00254).toString()
                "Metri" -> (value * 0.0000254).toString()
                "Chilometri" -> (value * 2.54e-8).toString()
                "Pollici" -> (value * 0.001).toString()
                "Piedi" -> (value * 0.0000833333).toString()
                "Iarde" -> (value * 0.0000277778).toString()
                "Miglia" -> (value * 1.5783e-8).toString()
                "Miglia nautiche" -> (value * 1.37149e-8).toString()
                else -> value.toString()
            }
            else -> value.toString()
        }
    }
}

