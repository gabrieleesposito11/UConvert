package com.example.myapplication515454545

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class massa_cal : AppCompatActivity() {
    private lateinit var cv_fromUnit: CardView
    private lateinit var cv_toUnit: CardView
    private lateinit var cv_convert: CardView
    private lateinit var mCLayout: RelativeLayout
    private var fromUnit = "Tonnellate"
    private var toUnit = "Libbre"
    private lateinit var tv_fromUnit: TextView
    private lateinit var tv_toUnit: TextView
    private lateinit var et_fromUnit: EditText
    private lateinit var et_toUnit: EditText
    private lateinit var buttonRobot: ImageButton // pulsante robot
    private val values = arrayOf(
        "Tonnellate",
        "Libbre",
        "Once",
        "Chilogrammi",
        "Grammi"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_massa_cal)
        cv_fromUnit = findViewById(R.id.fromUnit)
        cv_toUnit = findViewById(R.id.toUnit)
        cv_convert = findViewById(R.id.cv_convert)
        mCLayout = findViewById(R.id.massa_relativeLayout)
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
            builder.setMessage("Ciao!, Io sono 2FV,\nSapevi che per passare da grammi a kilogrammi devi dividere il valore per 1000") // Testo del messaggio
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss() // Chiudi il dialog quando si preme OK
            }
            val dialog = builder.create()
            dialog.show() // Mostra il dialog
        }

        cv_convert.setOnClickListener {
            val massInput = et_fromUnit.text.toString()
            if (massInput.isBlank()) {
                et_fromUnit.error = "Please enter some value"
            } else {
                val inputMass = massInput.toDouble()
                val convertedMass = convertMass(inputMass, fromUnit, toUnit)
                et_toUnit.setText(convertedMass)
            }
        }

        cv_toUnit.setOnClickListener {
            val builder = AlertDialog.Builder(this@massa_cal)
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
            val builder = AlertDialog.Builder(this@massa_cal)
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

    private fun convertMass(value: Double, fromUnit: String, toUnit: String): String {
        return when (fromUnit) {
            "Tonnellate" -> when (toUnit) {
                "Libbre" -> tonnellateToLibbre(value)
                "Once" -> tonnellateToOnce(value)
                "Chilogrammi" -> tonnellateToChilogrammi(value)
                "Grammi" -> tonnellateToGrammi(value)
                else -> value.toString()
            }

            "Libbre" -> when (toUnit) {
                "Tonnellate" -> libbreToTonnellate(value)
                "Once" -> libbreToOnce(value)
                "Chilogrammi" -> libbreToChilogrammi(value)
                "Grammi" -> libbreToGrammi(value)
                else -> value.toString()
            }

            "Once" -> when (toUnit) {
                "Tonnellate" -> onceToTonnellate(value)
                "Libbre" -> onceToLibbre(value)
                "Chilogrammi" -> onceToChilogrammi(value)
                "Grammi" -> onceToGrammi(value)
                else -> value.toString()
            }

            "Chilogrammi" -> when (toUnit) {
                "Tonnellate" -> chilogrammiToTonnellate(value)
                "Libbre" -> chilogrammiToLibbre(value)
                "Once" -> chilogrammiToOnce(value)
                "Grammi" -> chilogrammiToGrammi(value)
                else -> value.toString()
            }

            "Grammi" -> when (toUnit) {
                "Tonnellate" -> grammiToTonnellate(value)
                "Libbre" -> grammiToLibbre(value)
                "Once" -> grammiToOnce(value)
                "Chilogrammi" -> grammiToChilogrammi(value)
                else -> value.toString()
            }

            else -> value.toString()
        }
    }

    // Tonnellate
    private fun tonnellateToLibbre(tonnellate: Double): String {
        val libbre = tonnellate * 2204.62
        return libbre.toString()
    }

    private fun tonnellateToOnce(tonnellate: Double): String {
        val once = tonnellate * 35274
        return once.toString()
    }

    private fun tonnellateToChilogrammi(tonnellate: Double): String {
        val chilogrammi = tonnellate * 1000
        return chilogrammi.toString()
    }

    private fun tonnellateToGrammi(tonnellate: Double): String {
        val grammi = tonnellate * 1e+6
        return grammi.toString()
    }

    // Libbre
    private fun libbreToTonnellate(libre: Double): String {
        val tonnellate = libre / 2204.62
        return tonnellate.toString()
    }

    private fun libbreToOnce(libre: Double): String {
        val once = libre * 16
        return once.toString()
    }

    private fun libbreToChilogrammi(libre: Double): String {
        val chilogrammi = libre * 0.453592
        return chilogrammi.toString()
    }

    private fun libbreToGrammi(libre: Double): String {
        val grammi = libre * 453.592
        return grammi.toString()
    }

    // Once
    private fun onceToTonnellate(once: Double): String {
        val tonnellate = once / 35274
        return tonnellate.toString()
    }

    private fun onceToLibbre(once: Double): String {
        val libbre = once / 16
        return libbre.toString()
    }

    private fun onceToChilogrammi(once: Double): String {
        val chilogrammi = once * 0.0283495
        return chilogrammi.toString()
    }

    private fun onceToGrammi(once: Double): String {
        val grammi = once * 28.3495
        return grammi.toString()
    }

    // Chilogrammi
    private fun chilogrammiToTonnellate(chilogrammi: Double): String {
        val tonnellate = chilogrammi / 1000
        return tonnellate.toString()
    }

    private fun chilogrammiToLibbre(chilogrammi: Double): String {
        val libbre = chilogrammi / 0.453592
        return libbre.toString()
    }

    fun chilogrammiToOnce(chilogrammi: Double): String {
        val once = chilogrammi / 0.0283495
        return once.toString()
    }

    fun chilogrammiToGrammi(chilogrammi: Double): String {
        val grammi = chilogrammi * 1000
        return grammi.toString()
    }


    // Grammi
    fun grammiToTonnellate(grammi: Double): String {
        val tonnellate = grammi / 1e+6
        return tonnellate.toString()
    }

    fun grammiToLibbre(grammi: Double): String {
        val libbre = grammi / 453.592
        return libbre.toString()
    }

    fun grammiToOnce(grammi: Double): String {
        val once = grammi / 28.3495
        return once.toString()
    }

    fun grammiToChilogrammi(grammi: Double): String {
        val chilogrammi = grammi / 1000
        return chilogrammi.toString()
    }
}


