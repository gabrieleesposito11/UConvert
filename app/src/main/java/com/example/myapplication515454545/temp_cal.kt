package com.example.myapplication515454545

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class temp_cal : AppCompatActivity() {
    private lateinit var cv_fromUnit: CardView
    private lateinit var cv_toUnit: CardView
    private lateinit var cv_convert: CardView
    private lateinit var mCLayout: RelativeLayout
    private var fromUnit = "Celcius"
    private var toUnit = "Fahrenheit"
    private lateinit var tv_fromUnit: TextView
    private lateinit var tv_toUnit: TextView
    private lateinit var et_fromUnit: EditText
    private lateinit var et_toUnit: EditText
    private lateinit var buttonRobot: ImageButton // pulsante robot
    private val values = arrayOf(
        "Celcius",
        "Fahrenheit",
        "Kelvin",
        "Rankine",
        "Newton", "Delisle"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp_cal)
        cv_fromUnit = findViewById(R.id.fromUnit)
        cv_toUnit = findViewById(R.id.toUnit)
        cv_convert = findViewById(R.id.cv_convert)
        mCLayout = findViewById(R.id.temp_relativeLayout)
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
            builder.setTitle("Benvenuto nel menu Temperatura") // Titolo del messaggio
            builder.setMessage("Ciao!, Io sono 2FV,\nSapevi che per passare da Celsius a Fahrenheit devi moltiplicare il valore per 9/5 e sommare 32 al risultato") // Testo del messaggio
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss() // Chiudi il dialog quando si preme OK
            }
            val dialog = builder.create()
            dialog.show() // Mostra il dialog
        }


        cv_convert.setOnClickListener {
            val tempInput = et_fromUnit.text.toString()
            if (tempInput.isBlank()) {
                et_fromUnit.error = "Please enter some value"
            } else {
                val inputTemp = tempInput.toDouble()
                val convertedTemp = convertTemperature(inputTemp, fromUnit, toUnit)
                et_toUnit.setText(convertedTemp)
            }
        }

        cv_toUnit.setOnClickListener {
            val builder = AlertDialog.Builder(this@temp_cal)
            builder.setTitle("choose Unit")
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
            val builder = AlertDialog.Builder(this@temp_cal)
            builder.setTitle("choose Unit")
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

    private fun convertTemperature(value: Double, fromUnit: String, toUnit: String): String {
        return when (fromUnit) {
            "Celcius" -> when (toUnit) {
                "Fahrenheit" -> celciusToFarenheit(value)
                "Kelvin" -> celciusToKelvin(value)
                "Rankine" -> celciusToRankine(value)
                "Newton" -> celciusToNewton(value)
                "Delisle" -> celciusToDelisle(value)
                else -> value.toString()
            }
            "Fahrenheit" -> when (toUnit) {
                "Celcius" -> fahrenheitToCelcius(value)
                "Kelvin" -> fahrenheitToKelvin(value)
                "Rankine" -> fahrenheitToRankine(value)
                "Newton" -> fahrenheitToNewton(value)
                "Delisle" -> fahrenheitToDelisle(value)
                else -> value.toString()
            }
            "Kelvin" -> when (toUnit) {
                "Celcius" -> kelvinToCelcius(value)
                "Fahrenheit" -> kelvinToFahrenheit(value)
                "Rankine" -> kelvinToRankine(value)
                "Newton" -> kelvinToNewton(value)
                "Delisle" -> kelvinToDelisle(value)
                else -> value.toString()
            }
            "Rankine" -> when (toUnit) {
                "Celcius" -> rankineToCelcius(value)
                "Fahrenheit" -> rankineToFahrenheit(value)
                "Kelvin" -> rankineToKelvin(value)
                "Newton" -> rankineToNewton(value)
                "Delisle" -> rankineToDelisle(value)
                else -> value.toString()
            }
            "Newton" -> when (toUnit) {
                "Celcius" -> newtonToCelcius(value)
                "Fahrenheit" -> newtonToFahrenheit(value)
                "Kelvin" -> newtonToKelvin(value)
                "Rankine" -> newtonToRankine(value)
                "Delisle" -> newtonToDelisle(value)
                else -> value.toString()
            }
            "Delisle" -> when (toUnit) {
                "Celcius" -> delisleToCelcius(value)
                "Fahrenheit" -> delisleToFahrenheit(value)
                "Kelvin" -> delisleToKelvin(value)
                "Rankine" -> delisleToRankine(value)
                "Newton" -> delisleToNewton(value)
                else -> value.toString()
            }
            else -> value.toString()
        }
    }

    //celcius
    private fun celciusToKelvin(celsius: Double): String {
        val kelvin = celsius + 273.15
        return kelvin.toString()
    }

    private fun celciusToRankine(celsius: Double): String {
        val rankine = celsius * 1.8 + 32 + 459.67
        return rankine.toString()
    }

    private fun celciusToNewton(celsius: Double): String {
        val newton = celsius * 0.33000
        return newton.toString()
    }

    private fun celciusToDelisle(celsius: Double): String {
        val delisle = celsius * 0.33000
        return delisle.toString()
    }

    private fun celciusToFarenheit(celsius: Double): String {
        val fahrenheit = celsius * 9 / 5 + 32
        return fahrenheit.toString()
    }

    //fahrenheit
    private fun fahrenheitToKelvin(fahrenheit: Double): String {
        val kelvin = 273.5 + (fahrenheit - 32.0) * (5.0 / 9.0)
        return kelvin.toString()
    }

    private fun fahrenheitToRankine(fahrenheit: Double): String {
        val rankine = fahrenheit + 459.67
        return rankine.toString()
    }

    private fun fahrenheitToNewton(fahrenheit: Double): String {
        val newton = (fahrenheit - 32) * 0.18333
        return newton.toString()
    }

    private fun fahrenheitToDelisle(fahrenheit: Double): String {
        val delisle = (212 - fahrenheit) * 5 / 6
        return delisle.toString()
    }

    private fun fahrenheitToCelcius(fahrenheit: Double): String {
        val celcius = (fahrenheit - 32) * 5 / 9
        return celcius.toString()
    }

    //Kelvin
    private fun kelvinToRankine(kelvin: Double): String {
        val rankine = kelvin * 9 / 5
        return rankine.toString()
    }

    private fun kelvinToNewton(kelvin: Double): String {
        val newton = (kelvin - 273.15) * 0.33000
        return newton.toString()
    }

    private fun kelvinToDelisle(kelvin: Double): String {
        val delisle = (373.15 - kelvin) * 3 / 2
        return delisle.toString()
    }

    private fun kelvinToCelcius(kelvin: Double): String {
        val celcius = kelvin - 273.15
        return celcius.toString()
    }

    private fun kelvinToFahrenheit(kelvin: Double): String {
        val fahrenheit = (kelvin - 273.15) * 1.8 + 32
        return fahrenheit.toString()
    }

    //Rankine
    private fun rankineToNewton(rankine: Double): String {
        val newton = (rankine - 491.67) * 0.18333
        return newton.toString()
    }

    private fun rankineToDelisle(rankine: Double): String {
        val delisle = (671.67 - rankine) * 5 / 6
        return delisle.toString()
    }

    private fun rankineToCelcius(rankine: Double): String {
        val celcius = (rankine - 491.67) * 5 / 9
        return celcius.toString()
    }

    private fun rankineToFahrenheit(rankine: Double): String {
        val fahrenheit = rankine - 459.67
        return fahrenheit.toString()
    }

    private fun rankineToKelvin(rankine: Double): String {
        val kelvin = rankine * 5 / 9
        return kelvin.toString()
    }

    //Newton
    private fun newtonToDelisle(newton: Double): String {
        val delisle = (33 - newton) * 50 / 11
        return delisle.toString()
    }

    private fun newtonToCelcius(newton: Double): String {
        val celcius = newton * 100 / 33
        return celcius.toString()
    }

    private fun newtonToFahrenheit(newton: Double): String {
        val fahrenheit = newton * 60 / 11 + 32
        return fahrenheit.toString()
    }

    private fun newtonToKelvin(newton: Double): String {
        val kelvin = newton * 100 / 33 + 273.15
        return kelvin.toString()
    }

    private fun newtonToRankine(newton: Double): String {
        val rankine = newton * 60 / 11 + 491.67
        return rankine.toString()
    }

    //Delisle
    private fun delisleToCelcius(delisle: Double): String {
        val celcius = 100 - delisle * 2 / 3
        return celcius.toString()
    }

    private fun delisleToFahrenheit(delisle: Double): String {
        val fahrenheit = 212 - delisle * 6 / 5
        return fahrenheit.toString()
    }

    private fun delisleToKelvin(delisle: Double): String {
        val kelvin = 373.15 - delisle * 2 / 3
        return kelvin.toString()
    }

    private fun delisleToRankine(delisle: Double): String {
        val rankine = 671.67 - delisle * 6 / 5
        return rankine.toString()
    }

    private fun delisleToNewton(delisle: Double): String {
        val newton = 33 - delisle * 11 / 50
        return newton.toString()
    }
}
