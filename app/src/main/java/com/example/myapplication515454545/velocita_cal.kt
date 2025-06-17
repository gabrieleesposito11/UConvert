package com.example.myapplication515454545

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class velocita_cal : AppCompatActivity() {
    private lateinit var cv_fromUnit: CardView
    private lateinit var cv_toUnit: CardView
    private lateinit var cv_convert: CardView
    private lateinit var mCLayout: RelativeLayout
    private var fromUnit = "Metri al secondo"
    private var toUnit = "Metri al secondo"
    private lateinit var tv_fromUnit: TextView
    private lateinit var tv_toUnit: TextView
    private lateinit var et_fromUnit: EditText
    private lateinit var et_toUnit: EditText
    private lateinit var buttonRobot: ImageButton // pulsante robot
    private val values = arrayOf(
        "Metri al secondo",
        "Metri all'ora",
        "Chilometri al secondo",
        "Chilometri all'ora",
        "Pollici al secondo",
        "Pollici all'ora",
        "Piedi al secondo",
        "Piedi all'ora",
        "Miglia al secondo",
        "Miglia all'ora",
        "Nodi"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_velocita_cal)
        cv_fromUnit = findViewById(R.id.fromUnit)
        cv_toUnit = findViewById(R.id.toUnit)
        cv_convert = findViewById(R.id.cv_convert)
        mCLayout = findViewById(R.id.velocita_relativeLayout)
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
            builder.setMessage("Ciao!, Io sono 2FV,\nSapevi che per passare da cm metri al secondo a kilometri orari devi moltiplicare il valore per 3.6") // Testo del messaggio
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss() // Chiudi il dialog quando si preme OK
            }
            val dialog = builder.create()
            dialog.show() // Mostra il dialog
        }

        cv_convert.setOnClickListener {
            val velocityInput = et_fromUnit.text.toString()
            if (velocityInput.isBlank()) {
                et_fromUnit.error = "Please enter some value"
            } else {
                val inputVelocity = velocityInput.toDouble()
                val convertedVelocity = convertVelocity(inputVelocity, fromUnit, toUnit)
                et_toUnit.setText(convertedVelocity)
            }
        }

        cv_toUnit.setOnClickListener {
            val builder = AlertDialog.Builder(this@velocita_cal)
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
            val builder = AlertDialog.Builder(this@velocita_cal)
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

    private fun convertVelocity(value: Double, fromUnit: String, toUnit: String): String {
        return when (fromUnit) {
            "Metri al secondo" -> when (toUnit) {
                "Metri al secondo" -> value.toString()
                "Metri all'ora" -> metersPerSecondToMetersPerHour(value)
                "Chilometri al secondo" -> metersPerSecondToKilometersPerSecond(value)
                "Chilometri all'ora" -> metersPerSecondToKilometersPerHour(value)
                "Pollici al secondo" -> metersPerSecondToInchesPerSecond(value)
                "Pollici all'ora" -> metersPerSecondToInchesPerHour(value)
                "Piedi al secondo" -> metersPerSecondToFeetPerSecond(value)
                "Piedi all'ora" -> metersPerSecondToFeetPerHour(value)
                "Miglia al secondo" -> metersPerSecondToMilesPerSecond(value)
                "Miglia all'ora" -> metersPerSecondToMilesPerHour(value)
                "Nodi" -> metersPerSecondToKnots(value)
                else -> value.toString()
            }
            "Metri all'ora" -> when (toUnit) {
                "Metri al secondo" -> metersPerHourToMetersPerSecond(value)
                "Metri all'ora" -> value.toString()
                "Chilometri al secondo" -> metersPerHourToKilometersPerSecond(value)
                "Chilometri all'ora" -> metersPerHourToKilometersPerHour(value)
                "Pollici al secondo" -> metersPerHourToInchesPerSecond(value)
                "Pollici all'ora" -> metersPerHourToInchesPerHour(value)
                "Piedi al secondo" -> metersPerHourToFeetPerSecond(value)
                "Piedi all'ora" -> metersPerHourToFeetPerHour(value)
                "Miglia al secondo" -> metersPerHourToMilesPerSecond(value)
                "Miglia all'ora" -> metersPerHourToMilesPerHour(value)
                "Nodi" -> metersPerHourToKnots(value)
                else -> value.toString()
            }
            "Chilometri al secondo" -> when (toUnit) {
                "Metri al secondo" -> kilometersPerSecondToMetersPerSecond(value)
                "Metri all'ora" -> kilometersPerSecondToMetersPerHour(value)
                "Chilometri al secondo" -> value.toString()
                "Chilometri all'ora" -> kilometersPerSecondToKilometersPerHour(value)
                "Pollici al secondo" -> kilometersPerSecondToInchesPerSecond(value)
                "Pollici all'ora" -> kilometersPerSecondToInchesPerHour(value)
                "Piedi al secondo" -> kilometersPerSecondToFeetPerSecond(value)
                "Piedi all'ora" -> kilometersPerSecondToFeetPerHour(value)
                "Miglia al secondo" -> kilometersPerSecondToMilesPerSecond(value)
                "Miglia all'ora" -> kilometersPerSecondToMilesPerHour(value)
                "Nodi" -> kilometersPerSecondToKnots(value)
                else -> value.toString()
            }
            "Chilometri all'ora" -> when (toUnit) {
                "Metri al secondo" -> kilometersPerHourToMetersPerSecond(value)
                "Metri all'ora" -> kilometersPerHourToMetersPerHour(value)
                "Chilometri al secondo" -> kilometersPerHourToKilometersPerSecond(value)
                "Chilometri all'ora" -> value.toString()
                "Pollici al secondo" -> kilometersPerHourToInchesPerSecond(value)
                "Pollici all'ora" -> kilometersPerHourToInchesPerHour(value)
                "Piedi al secondo" -> kilometersPerHourToFeetPerSecond(value)
                "Piedi all'ora" -> kilometersPerHourToFeetPerHour(value)
                "Miglia al secondo" -> kilometersPerHourToMilesPerSecond(value)
                "Miglia all'ora" -> kilometersPerHourToMilesPerHour(value)
                "Nodi" -> kilometersPerHourToKnots(value)
                else -> value.toString()
            }
            "Pollici al secondo" -> when (toUnit) {
                "Metri al secondo" -> inchesPerSecondToMetersPerSecond(value)
                "Metri all'ora" -> inchesPerSecondToMetersPerHour(value)
                "Chilometri al secondo" -> inchesPerSecondToKilometersPerSecond(value)
                "Chilometri all'ora" -> inchesPerSecondToKilometersPerHour(value)
                "Pollici al secondo" -> value.toString()
                "Pollici all'ora" -> inchesPerSecondToInchesPerHour(value)
                "Piedi al secondo" -> inchesPerSecondToFeetPerSecond(value)
                "Piedi all'ora" -> inchesPerSecondToFeetPerHour(value)
                "Miglia al secondo" -> inchesPerSecondToMilesPerSecond(value)
                "Miglia all'ora" -> inchesPerSecondToMilesPerHour(value)
                "Nodi" -> inchesPerSecondToKnots(value)
                else -> value.toString()
            }
            "Pollici all'ora" -> when (toUnit) {
                "Metri al secondo" -> inchesPerHourToMetersPerSecond(value)
                "Metri all'ora" -> inchesPerHourToMetersPerHour(value)
                "Chilometri al secondo" -> inchesPerHourToKilometersPerSecond(value)
                "Chilometri all'ora" -> inchesPerHourToKilometersPerHour(value)
                "Pollici al secondo" -> inchesPerHourToInchesPerSecond(value)
                "Pollici all'ora" -> value.toString()
                "Piedi al secondo" -> inchesPerHourToFeetPerSecond(value)
                "Piedi all'ora" -> inchesPerHourToFeetPerHour(value)
                "Miglia al secondo" -> inchesPerHourToMilesPerSecond(value)
                "Miglia all'ora" -> inchesPerHourToMilesPerHour(value)
                "Nodi" -> inchesPerHourToKnots(value)
                else -> value.toString()
            }
            "Piedi al secondo" -> when (toUnit) {
                "Metri al secondo" -> feetPerSecondToMetersPerSecond(value)
                "Metri all'ora" -> feetPerSecondToMetersPerHour(value)
                "Chilometri al secondo" -> feetPerSecondToKilometersPerSecond(value)
                "Chilometri all'ora" -> feetPerSecondToKilometersPerHour(value)
                "Pollici al secondo" -> feetPerSecondToInchesPerSecond(value)
                "Pollici all'ora" -> feetPerSecondToInchesPerHour(value)
                "Piedi al secondo" -> value.toString()
                "Piedi all'ora" -> feetPerSecondToFeetPerHour(value)
                "Miglia al secondo" -> feetPerSecondToMilesPerSecond(value)
                "Miglia all'ora" -> feetPerSecondToMilesPerHour(value)
                "Nodi" -> feetPerSecondToKnots(value)
                else -> value.toString()
            }
            "Piedi all'ora" -> when (toUnit) {
                "Metri al secondo" -> feetPerHourToMetersPerSecond(value)
                "Metri all'ora" -> feetPerHourToMetersPerHour(value)
                "Chilometri al secondo" -> feetPerHourToKilometersPerSecond(value)
                "Chilometri all'ora" -> feetPerHourToKilometersPerHour(value)
                "Pollici al secondo" -> feetPerHourToInchesPerSecond(value)
                "Pollici all'ora" -> feetPerHourToInchesPerHour(value)
                "Piedi al secondo" -> feetPerHourToFeetPerSecond(value)
                "Piedi all'ora" -> value.toString()
                "Miglia al secondo" -> feetPerHourToMilesPerSecond(value)
                "Miglia all'ora" -> feetPerHourToMilesPerHour(value)
                "Nodi" -> feetPerHourToKnots(value)
                else -> value.toString()
            }
            "Miglia al secondo" -> when (toUnit) {
                "Metri al secondo" -> milesPerSecondToMetersPerSecond(value)
                "Metri all'ora" -> milesPerSecondToMetersPerHour(value)
                "Chilometri al secondo" -> milesPerSecondToKilometersPerSecond(value)
                "Chilometri all'ora" -> milesPerSecondToKilometersPerHour(value)
                "Pollici al secondo" -> milesPerSecondToInchesPerSecond(value)
                "Pollici all'ora" -> milesPerSecondToInchesPerHour(value)
                "Piedi al secondo" -> milesPerSecondToFeetPerSecond(value)
                "Piedi all'ora" -> milesPerSecondToFeetPerHour(value)
                "Miglia al secondo" -> value.toString()
                "Miglia all'ora" -> milesPerSecondToMilesPerHour(value)
                "Nodi" -> milesPerSecondToKnots(value)
                else -> value.toString()
            }
            "Miglia all'ora" -> when (toUnit) {
                "Metri al secondo" -> milesPerHourToMetersPerSecond(value)
                "Metri all'ora" -> milesPerHourToMetersPerHour(value)
                "Chilometri al secondo" -> milesPerHourToKilometersPerSecond(value)
                "Chilometri all'ora" -> milesPerHourToKilometersPerHour(value)
                "Pollici al secondo" -> milesPerHourToInchesPerSecond(value)
                "Pollici all'ora" -> milesPerHourToInchesPerHour(value)
                "Piedi al secondo" -> milesPerHourToFeetPerSecond(value)
                "Piedi all'ora" -> milesPerHourToFeetPerHour(value)
                "Miglia al secondo" -> milesPerHourToMilesPerSecond(value)
                "Miglia all'ora" -> value.toString()
                "Nodi" -> milesPerHourToKnots(value)
                else -> value.toString()
            }
            "Nodi" -> when (toUnit) {
                "Metri al secondo" -> knotsToMetersPerSecond(value)
                "Metri all'ora" -> knotsToMetersPerHour(value)
                "Chilometri al secondo" -> knotsToKilometersPerSecond(value)
                "Chilometri all'ora" -> knotsToKilometersPerHour(value)
                "Pollici al secondo" -> knotsToInchesPerSecond(value)
                "Pollici all'ora" -> knotsToInchesPerHour(value)
                "Piedi al secondo" -> knotsToFeetPerSecond(value)
                "Piedi all'ora" -> knotsToFeetPerHour(value)
                "Miglia al secondo" -> knotsToMilesPerSecond(value)
                "Miglia all'ora" -> knotsToMilesPerHour(value)
                "Nodi" -> value.toString()
                else -> value.toString()
            }
            else -> value.toString()
        }
    }

    // Conversion functions

    // Meters per second
    private fun metersPerSecondToMetersPerHour(mps: Double): String {
        return (mps * 3600).toString()
    }

    private fun metersPerSecondToKilometersPerSecond(mps: Double): String {
        return (mps / 1000).toString()
    }

    private fun metersPerSecondToKilometersPerHour(mps: Double): String {
        return (mps * 3.6).toString()
    }

    private fun metersPerSecondToInchesPerSecond(mps: Double): String {
        return (mps * 39.3701).toString()
    }

    private fun metersPerSecondToInchesPerHour(mps: Double): String {
        return (mps * 141732.2835).toString()
    }

    private fun metersPerSecondToFeetPerSecond(mps: Double): String {
        return (mps * 3.28084).toString()
    }

    private fun metersPerSecondToFeetPerHour(mps: Double): String {
        return (mps * 11811.0236).toString()
    }

    private fun metersPerSecondToMilesPerSecond(mps: Double): String {
        return (mps * 0.000621371).toString()
    }

    private fun metersPerSecondToMilesPerHour(mps: Double): String {
        return (mps * 2.23694).toString()
    }

    private fun metersPerSecondToKnots(mps: Double): String {
        return (mps * 1.94384).toString()
    }

    // Meters per hour
    private fun metersPerHourToMetersPerSecond(mph: Double): String {
        return (mph / 3600).toString()
    }

    private fun metersPerHourToKilometersPerSecond(mph: Double): String {
        return (mph / 3600000).toString()
    }

    private fun metersPerHourToKilometersPerHour(mph: Double): String {
        return (mph / 1000).toString()
    }

    private fun metersPerHourToInchesPerSecond(mph: Double): String {
        return (mph / 3600 * 39.3701).toString()
    }

    private fun metersPerHourToInchesPerHour(mph: Double): String {
        return (mph * 39.3701).toString()
    }

    private fun metersPerHourToFeetPerSecond(mph: Double): String {
        return (mph / 3600 * 3.28084).toString()
    }

    private fun metersPerHourToFeetPerHour(mph: Double): String {
        return (mph * 3.28084).toString()
    }

    private fun metersPerHourToMilesPerSecond(mph: Double): String {
        return (mph / 3600 * 0.000621371).toString()
    }

    private fun metersPerHourToMilesPerHour(mph: Double): String {
        return (mph / 3600 * 2.23694).toString()
    }

    private fun metersPerHourToKnots(mph: Double): String {
        return (mph / 3600 * 1.94384).toString()
    }

    // Kilometers per second
    private fun kilometersPerSecondToMetersPerSecond(kps: Double): String {
        return (kps * 1000).toString()
    }

    private fun kilometersPerSecondToMetersPerHour(kps: Double): String {
        return (kps * 3600000).toString()
    }

    private fun kilometersPerSecondToKilometersPerSecond(kps: Double): String {
        return kps.toString()
    }

    private fun kilometersPerSecondToKilometersPerHour(kps: Double): String {
        return (kps * 3600).toString()
    }

    private fun kilometersPerSecondToInchesPerSecond(kps: Double): String {
        return (kps * 39370.1).toString()
    }

    private fun kilometersPerSecondToInchesPerHour(kps: Double): String {
        return (kps * 39370078.7).toString()
    }

    private fun kilometersPerSecondToFeetPerSecond(kps: Double): String {
        return (kps * 3280.84).toString()
    }

    private fun kilometersPerSecondToFeetPerHour(kps: Double): String {
        return (kps * 11811023.6).toString()
    }

    private fun kilometersPerSecondToMilesPerSecond(kps: Double): String {
        return (kps * 0.621371).toString()
    }

    private fun kilometersPerSecondToMilesPerHour(kps: Double): String {
        return (kps * 2236.94).toString()
    }

    private fun kilometersPerSecondToKnots(kps: Double): String {
        return (kps * 1943.84).toString()
    }

    // Kilometers per Hour
    private fun kilometersPerHourToMetersPerSecond(kph: Double): String {
        return (kph / 3.6).toString()
    }

    private fun kilometersPerHourToMetersPerHour(kph: Double): String {
        return (kph * 1000).toString()
    }

    private fun kilometersPerHourToKilometersPerSecond(kph: Double): String {
        return (kph / 3600).toString()
    }

    private fun kilometersPerHourToInchesPerSecond(kph: Double): String {
        return (kph * 39370.1 / 3600).toString()
    }

    private fun kilometersPerHourToInchesPerHour(kph: Double): String {
        return (kph * 39370.1).toString()
    }

    private fun kilometersPerHourToFeetPerSecond(kph: Double): String {
        return (kph * 0.911344).toString()
    }

    private fun kilometersPerHourToFeetPerHour(kph: Double): String {
        return (kph * 3280.84).toString()
    }

    private fun kilometersPerHourToMilesPerSecond(kph: Double): String {
        return (kph * 0.000277778).toString()
    }

    private fun kilometersPerHourToMilesPerHour(kph: Double): String {
        return (kph * 0.621371).toString()
    }

    private fun kilometersPerHourToKnots(kph: Double): String {
        return (kph * 0.539957).toString()
    }


    // Inches per second
    private fun inchesPerSecondToMetersPerSecond(ips: Double): String {
        return (ips * 0.0254).toString()
    }

    private fun inchesPerSecondToMetersPerHour(ips: Double): String {
        return (ips * 0.0254 * 3600).toString()
    }

    private fun inchesPerSecondToKilometersPerSecond(ips: Double): String {
        return (ips * 0.0000254).toString()
    }

    private fun inchesPerSecondToKilometersPerHour(ips: Double): String {
        return (ips * 0.0254 * 3600).toString()
    }

    private fun inchesPerSecondToInchesPerHour(ips: Double): String {
        return (ips * 3600).toString()
    }

    private fun inchesPerSecondToFeetPerSecond(ips: Double): String {
        return (ips * 0.0833333).toString()
    }

    private fun inchesPerSecondToFeetPerHour(ips: Double): String {
        return (ips * 0.0833333 * 3600).toString()
    }

    private fun inchesPerSecondToMilesPerSecond(ips: Double): String {
        return (ips * 0.000015783).toString()
    }

    private fun inchesPerSecondToMilesPerHour(ips: Double): String {
        return (ips * 0.0568182).toString()
    }

    private fun inchesPerSecondToKnots(ips: Double): String {
        return (ips * 0.0488254).toString()
    }

    // Inches per hour
    private fun inchesPerHourToMetersPerSecond(iph: Double): String {
        return (iph * 0.00000705556).toString()
    }

    private fun inchesPerHourToMetersPerHour(iph: Double): String {
        return (iph * 0.0254).toString()
    }

    private fun inchesPerHourToKilometersPerSecond(iph: Double): String {
        return (iph * 0.00000000705556).toString()
    }

    private fun inchesPerHourToKilometersPerHour(iph: Double): String {
        return (iph * 0.0254).toString()
    }

    private fun inchesPerHourToInchesPerSecond(iph: Double): String {
        return (iph * 0.000277778).toString()
    }

    private fun inchesPerHourToFeetPerSecond(iph: Double): String {
        return (iph * 0.0000694444).toString()
    }

    private fun inchesPerHourToFeetPerHour(iph: Double): String {
        return (iph * 0.0833333).toString()
    }

    private fun inchesPerHourToMilesPerSecond(iph: Double): String {
        return (iph * 0.0000000044704).toString()
    }

    private fun inchesPerHourToMilesPerHour(iph: Double): String {
        return (iph * 0.000016).toString()
    }

    private fun inchesPerHourToKnots(iph: Double): String {
        return (iph * 0.0000145579).toString()
    }

    // Feet per second
    private fun feetPerSecondToMetersPerSecond(fps: Double): String {
        return (fps * 0.3048).toString()
    }

    private fun feetPerSecondToMetersPerHour(fps: Double): String {
        return (fps * 0.3048 * 3600).toString()
    }

    private fun feetPerSecondToKilometersPerSecond(fps: Double): String {
        return (fps * 0.0003048).toString()
    }

    private fun feetPerSecondToKilometersPerHour(fps: Double): String {
        return (fps * 0.00109728).toString()
    }

    private fun feetPerSecondToInchesPerSecond(fps: Double): String {
        return (fps * 12).toString()
    }

    private fun feetPerSecondToInchesPerHour(fps: Double): String {
        return (fps * 12 * 3600).toString()
    }

    private fun feetPerSecondToFeetPerHour(fps: Double): String {
        return (fps * 3600).toString()
    }

    private fun feetPerSecondToMilesPerSecond(fps: Double): String {
        return (fps * 0.000189394).toString()
    }

    private fun feetPerSecondToMilesPerHour(fps: Double): String {
        return (fps * 0.681818).toString()
    }

    private fun feetPerSecondToKnots(fps: Double): String {
        return (fps * 0.592484).toString()
    }

    // Feet per hour
    private fun feetPerHourToMetersPerSecond(fph: Double): String {
        return (fph * 0.0000846667).toString()
    }

    private fun feetPerHourToMetersPerHour(fph: Double): String {
        return (fph * 0.0003048).toString()
    }

    private fun feetPerHourToKilometersPerSecond(fph: Double): String {
        return (fph * 0.0000000846667).toString()
    }

    private fun feetPerHourToKilometersPerHour(fph: Double): String {
        return (fph * 0.0003048).toString()
    }

    private fun feetPerHourToInchesPerSecond(fph: Double): String {
        return (fph * 0.000277778).toString()
    }

    private fun feetPerHourToInchesPerHour(fph: Double): String {
        return (fph * 0.0833333).toString()
    }

    private fun feetPerHourToFeetPerSecond(fph: Double): String {
        return (fph * 0.000277778).toString()
    }

    private fun feetPerHourToMilesPerSecond(fph: Double): String {
        return (fph * 0.000000145788).toString()
    }

    private fun feetPerHourToMilesPerHour(fph: Double): String {
        return (fph * 0.00052153).toString()
    }

    private fun feetPerHourToKnots(fph: Double): String {
        return (fph * 0.000450728).toString()
    }

    // Miles per second
    private fun milesPerSecondToMetersPerSecond(mps: Double): String {
        return (mps * 1609.34).toString()
    }

    private fun milesPerSecondToMetersPerHour(mps: Double): String {
        return (mps * 1609.34 * 3600).toString()
    }

    private fun milesPerSecondToKilometersPerSecond(mps: Double): String {
        return (mps * 1.60934).toString()
    }

    private fun milesPerSecondToKilometersPerHour(mps: Double): String {
        return (mps * 5793.64).toString()
    }

    private fun milesPerSecondToInchesPerSecond(mps: Double): String {
        return (mps * 63360).toString()
    }

    private fun milesPerSecondToInchesPerHour(mps: Double): String {
        return (mps * 63360 * 3600).toString()
    }

    private fun milesPerSecondToFeetPerSecond(mps: Double): String {
        return (mps * 5280).toString()
    }

    private fun milesPerSecondToFeetPerHour(mps: Double): String {
        return (mps * 5280 * 3600).toString()
    }

    private fun milesPerSecondToMilesPerHour(mps: Double): String {
        return (mps * 3600).toString()
    }

    private fun milesPerSecondToKnots(mps: Double): String {
        return (mps * 1943.84).toString()
    }

    // Miles per hour
    private fun milesPerHourToMetersPerSecond(mph: Double): String {
        return (mph * 0.44704).toString()
    }

    private fun milesPerHourToMetersPerHour(mph: Double): String {
        return (mph * 1609.34).toString()
    }

    private fun milesPerHourToKilometersPerSecond(mph: Double): String {
        return (mph * 0.00044704).toString()
    }

    private fun milesPerHourToKilometersPerHour(mph: Double): String {
        return (mph * 1.60934).toString()
    }

    private fun milesPerHourToInchesPerSecond(mph: Double): String {
        return (mph * 17.6).toString()
    }

    private fun milesPerHourToInchesPerHour(mph: Double): String {
        return (mph * 17.6 * 3600).toString()
    }

    private fun milesPerHourToFeetPerSecond(mph: Double): String {
        return (mph * 1.46667).toString()
    }

    private fun milesPerHourToFeetPerHour(mph: Double): String {
        return (mph * 5280).toString()
    }

    private fun milesPerHourToMilesPerSecond(mph: Double): String {
        return (mph * 0.000277778).toString()
    }

    private fun milesPerHourToKnots(mph: Double): String {
        return (mph * 0.868976).toString()
    }

    // Knots
    private fun knotsToMetersPerSecond(knots: Double): String {
        return (knots * 0.514444).toString()
    }

    private fun knotsToMetersPerHour(knots: Double): String {
        return (knots * 1852).toString()
    }

    private fun knotsToKilometersPerSecond(knots: Double): String {
        return (knots * 0.000514444).toString()
    }

    private fun knotsToKilometersPerHour(knots: Double): String {
        return (knots * 1.852).toString()
    }

    private fun knotsToInchesPerSecond(knots: Double): String {
        return (knots * 63360 / 3600).toString()
    }

    private fun knotsToInchesPerHour(knots: Double): String {
        return (knots * 63360).toString()
    }

    private fun knotsToFeetPerSecond(knots: Double): String {
        return (knots * 1.68781).toString()
    }

    private fun knotsToFeetPerHour(knots: Double): String {
        return (knots * 6076.12).toString()
    }

    private fun knotsToMilesPerSecond(knots: Double): String {
        return (knots * 0.000319661).toString()
    }

    private fun knotsToMilesPerHour(knots: Double): String {
        return (knots * 1.15078).toString()
    }
}




