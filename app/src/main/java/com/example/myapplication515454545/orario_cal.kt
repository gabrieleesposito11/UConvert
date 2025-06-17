package com.example.myapplication515454545

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class orario_cal : AppCompatActivity() {
    private lateinit var cv_fromUnit: CardView
    private lateinit var cv_toUnit: CardView
    private lateinit var cv_convert: CardView
    private lateinit var mCLayout: RelativeLayout
    private var fromUnit = "Milliseconds"
    private var toUnit = "Seconds"
    private lateinit var tv_fromUnit: TextView
    private lateinit var tv_toUnit: TextView
    private lateinit var et_fromUnit: EditText
    private lateinit var et_toUnit: EditText
    private lateinit var buttonRobot: ImageButton // pulsante robot
    private val timeUnits = arrayOf(
        "Milliseconds",
        "Seconds",
        "Minutes",
        "Hours",
        "Days",
        "Weeks"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orario_cal)
        cv_fromUnit = findViewById(R.id.fromUnit)
        cv_toUnit = findViewById(R.id.toUnit)
        cv_convert = findViewById(R.id.cv_convert)
        mCLayout = findViewById(R.id.orario_relativeLayout)
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
            builder.setMessage("Ciao!, Io sono 2FV,\nSapevi che per passare da secondi a ore devi dividere il valore per 3600") // Testo del messaggio
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss() // Chiudi il dialog quando si preme OK
            }
            val dialog = builder.create()
            dialog.show() // Mostra il dialog
        }

        cv_convert.setOnClickListener {
            val timeInput = et_fromUnit.text.toString()
            if (timeInput.isBlank()) {
                et_fromUnit.error = "Please enter some value"
            } else {
                val inputTime = timeInput.toDouble()
                val convertedTime = convertTime(inputTime, fromUnit, toUnit)
                et_toUnit.setText(convertedTime)
            }
        }

        cv_toUnit.setOnClickListener {
            val builder = AlertDialog.Builder(this@orario_cal)
            builder.setTitle("Choose Unit")
            builder.setSingleChoiceItems(timeUnits, -1) { dialogInterface, i ->
                toUnit = timeUnits[i]
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
            val builder = AlertDialog.Builder(this@orario_cal)
            builder.setTitle("Choose Unit")
            builder.setSingleChoiceItems(timeUnits, -1) { dialogInterface, i ->
                fromUnit = timeUnits[i]
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

    private fun convertTime(value: Double, fromUnit: String, toUnit: String): String {
        return when (fromUnit) {
            "Milliseconds" -> when (toUnit) {
                "Seconds" -> millisecondsToSeconds(value.toLong()).toString()
                "Minutes" -> millisecondsToMinutes(value.toLong()).toString()
                "Hours" -> millisecondsToHours(value.toLong()).toString()
                "Days" -> millisecondsToDays(value.toLong()).toString()
                "Weeks" -> millisecondsToWeeks(value.toLong()).toString()
                else -> value.toString()
            }
            "Seconds" -> when (toUnit) {
                "Milliseconds" -> secondsToMilliseconds(value).toString()
                "Minutes" -> secondsToMinutes(value).toString()
                "Hours" -> secondsToHours(value).toString()
                "Days" -> secondsToDays(value).toString()
                "Weeks" -> secondsToWeeks(value).toString()
                else -> value.toString()
            }
            "Minutes" -> when (toUnit) {
                "Milliseconds" -> minutesToMilliseconds(value).toString()
                "Seconds" -> minutesToSeconds(value).toString()
                "Hours" -> minutesToHours(value).toString()
                "Days" -> minutesToDays(value).toString()
                "Weeks" -> minutesToWeeks(value).toString()
                else -> value.toString()
            }
            "Hours" -> when (toUnit) {
                "Milliseconds" -> hoursToMilliseconds(value).toString()
                "Seconds" -> hoursToSeconds(value).toString()
                "Minutes" -> hoursToMinutes(value).toString()
                "Days" -> hoursToDays(value).toString()
                "Weeks" -> hoursToWeeks(value).toString()
                else -> value.toString()
            }
            "Days" -> when (toUnit) {
                "Milliseconds" -> daysToMilliseconds(value).toString()
                "Seconds" -> daysToSeconds(value).toString()
                "Minutes" -> daysToMinutes(value).toString()
                "Hours" -> daysToHours(value).toString()
                "Weeks" -> daysToWeeks(value).toString()
                else -> value.toString()
            }
            "Weeks" -> when (toUnit) {
                "Milliseconds" -> weeksToMilliseconds(value).toString()
                "Seconds" -> weeksToSeconds(value).toString()
                "Minutes" -> weeksToMinutes(value).toString()
                "Hours" -> weeksToHours(value).toString()
                "Days" -> weeksToDays(value).toString()
                else -> value.toString()
            }
            else -> value.toString()
        }
    }

    // Conversion functions for milliseconds
    private fun millisecondsToSeconds(milliseconds: Long): Double {
        return milliseconds / 1000.0
    }

    private fun millisecondsToMinutes(milliseconds: Long): Double {
        return milliseconds / (1000.0 * 60)
    }

    private fun millisecondsToHours(milliseconds: Long): Double {
        return milliseconds / (1000.0 * 60 * 60)
    }

    private fun millisecondsToDays(milliseconds: Long): Double {
        return milliseconds / (1000.0 * 60 *    60 * 24)
    }

    private fun millisecondsToWeeks(milliseconds: Long): Double {
        return milliseconds / (1000.0 * 60 * 60 * 24 * 7)
    }

    // Conversion functions for seconds
    private fun secondsToMilliseconds(seconds: Double): Long {
        return (seconds * 1000).toLong()
    }

    private fun secondsToMinutes(seconds: Double): Double {
        return seconds / 60
    }

    private fun secondsToHours(seconds: Double): Double {
        return seconds / (60 * 60)
    }

    private fun secondsToDays(seconds: Double): Double {
        return seconds / (60 * 60 * 24)
    }

    private fun secondsToWeeks(seconds: Double): Double {
        return seconds / (60 * 60 * 24 * 7)
    }

    // Conversion functions for minutes
    private fun minutesToMilliseconds(minutes: Double): Long {
        return (minutes * 60 * 1000).toLong()
    }

    private fun minutesToSeconds(minutes: Double): Double {
        return minutes * 60
    }

    private fun minutesToHours(minutes: Double): Double {
        return minutes / 60
    }

    private fun minutesToDays(minutes: Double): Double {
        return minutes / (60 * 24)
    }

    private fun minutesToWeeks(minutes: Double): Double {
        return minutes / (60 * 24 * 7)
    }

    // Conversion functions for hours
    private fun hoursToMilliseconds(hours: Double): Long {
        return (hours * 60 * 60 * 1000).toLong()
    }

    private fun hoursToSeconds(hours: Double): Double {
        return hours * 60 * 60
    }

    private fun hoursToMinutes(hours: Double): Double {
        return hours * 60
    }

    private fun hoursToDays(hours: Double): Double {
        return hours / 24
    }

    private fun hoursToWeeks(hours: Double): Double {
        return hours / (24 * 7)
    }

    // Conversion functions for days
    private fun daysToMilliseconds(days: Double): Long {
        return (days * 24 * 60 * 60 * 1000).toLong()
    }

    private fun daysToSeconds(days: Double): Double {
        return days * 24 * 60 * 60
    }

    private fun daysToMinutes(days: Double): Double {
        return days * 24 * 60
    }

    private fun daysToHours(days: Double): Double {
        return days * 24
    }

    private fun daysToWeeks(days: Double): Double {
        return days / 7
    }

    // Conversion functions for weeks
    private fun weeksToMilliseconds(weeks: Double): Long {
        return (weeks * 7 * 24 * 60 * 60 * 1000).toLong()
    }

    private fun weeksToSeconds(weeks: Double): Double {
        return weeks * 7 * 24 * 60 * 60
    }

    private fun weeksToMinutes(weeks: Double): Double {
        return weeks * 7 * 24 * 60
    }

    private fun weeksToHours(weeks: Double): Double {
        return weeks * 7 * 24
    }

    private fun weeksToDays(weeks: Double): Double {
        return weeks * 7
    }
}

