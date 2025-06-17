package com.example.myapplication515454545

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class volume_cal : AppCompatActivity() {
    private lateinit var cv_fromUnit: CardView
    private lateinit var cv_toUnit: CardView
    private lateinit var cv_convert: CardView
    private lateinit var mCLayout: RelativeLayout
    private var fromUnit = "Litri"
    private var toUnit = "Millilitri"
    private lateinit var tv_fromUnit: TextView
    private lateinit var tv_toUnit: TextView
    private lateinit var et_fromUnit: EditText
    private lateinit var et_toUnit: EditText
    private lateinit var buttonRobot: ImageButton // pulsante robot
    private val values = arrayOf(
        "Litri",
        "Millilitri",
        "Centimetri cubi",
        "Metri cubi",
        "Pollici cubi",
        "Piedi cubi"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volume_cal)
        cv_fromUnit = findViewById(R.id.fromUnit)
        cv_toUnit = findViewById(R.id.toUnit)
        cv_convert = findViewById(R.id.cv_convert)
        mCLayout = findViewById(R.id.volume_relativeLayout)
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
            builder.setMessage("Ciao!, Io sono 2FV,\nSapevi che per passare da cm cubici a litri devi dividere il valore per 1000") // Testo del messaggio
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss() // Chiudi il dialog quando si preme OK
            }
            val dialog = builder.create()
            dialog.show() // Mostra il dialog
        }

        cv_convert.setOnClickListener {
            val volumeInput = et_fromUnit.text.toString()
            if (volumeInput.isBlank()) {
                et_fromUnit.error = "Please enter some value"
            } else {
                val inputVolume = volumeInput.toDouble()
                val convertedVolume = convertVolume(inputVolume, fromUnit, toUnit)
                et_toUnit.setText(convertedVolume)
            }
        }

        cv_toUnit.setOnClickListener {
            val builder = AlertDialog.Builder(this@volume_cal)
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
            val builder = AlertDialog.Builder(this@volume_cal)
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

    private fun convertVolume(value: Double, fromUnit: String, toUnit: String): String {
        return when (fromUnit) {
            "Litri" -> when (toUnit) {
                "Millilitri" -> litriToMillilitri(value)
                "Centimetri cubi" -> litriToCentimetriCubi(value)
                "Metri cubi" -> litriToMetriCubi(value)
                "Pollici cubi" -> litriToPolliciCubi(value)
                "Piedi cubi" -> litriToPiediCubi(value)
                else -> value.toString()
            }
            "Millilitri" -> when (toUnit) {
                "Litri" -> millilitriToLitri(value)
                "Centimetri cubi" -> millilitriToCentimetriCubi(value)
                "Metri cubi" -> millilitriToMetriCubi(value)
                "Pollici cubi" -> millilitriToPolliciCubi(value)
                "Piedi cubi" -> millilitriToPiediCubi(value)
                else -> value.toString()
            }
            "Centimetri cubi" -> when (toUnit) {
                "Litri" -> centimetriCubiToLitri(value)
                "Millilitri" -> centimetriCubiToMillilitri(value)
                "Metri cubi" -> centimetriCubiToMetriCubi(value)
                "Pollici cubi" -> centimetriCubiToPolliciCubi(value)
                "Piedi cubi" -> centimetriCubiToPiediCubi(value)
                else -> value.toString()
            }
            "Metri cubi" -> when (toUnit) {
                "Litri" -> metriCubiToLitri(value)
                "Millilitri" -> metriCubiToMillilitri(value)
                "Centimetri cubi" -> metriCubiToCentimetriCubi(value)
                "Pollici cubi" -> metriCubiToPolliciCubi(value)
                "Piedi cubi" -> metriCubiToPiediCubi(value)
                else -> value.toString()
            }
            "Pollici cubi" -> when (toUnit) {
                "Litri" -> polliciCubiToLitri(value)
                "Millilitri" -> polliciCubiToMillilitri(value)
                "Centimetri cubi" -> polliciCubiToCentimetriCubi(value)
                "Metri cubi" -> polliciCubiToMetriCubi(value)
                "Piedi cubi" -> polliciCubiToPiediCubi(value)
                else -> value.toString()
            }
            "Piedi cubi" -> when (toUnit) {
                "Litri" -> piediCubiToLitri(value)
                "Millilitri" -> piediCubiToMillilitri(value)
                "Centimetri cubi" -> piediCubiToCentimetriCubi(value)
                "Metri cubi" -> piediCubiToMetriCubi(value)
                "Pollici cubi" -> piediCubiToPolliciCubi(value)
                else -> value.toString()
            }
            else -> value.toString()
        }
    }

    // Litri
    private fun litriToMillilitri(litri: Double): String {
        val millilitri = litri * 1000
        return millilitri.toString()
    }

    private fun litriToCentimetriCubi(litri: Double): String {
        val centimetriCubi = litri * 1000
        return centimetriCubi.toString()
    }

    private fun litriToMetriCubi(litri: Double): String {
        val metriCubi = litri / 1000
        return metriCubi.toString()
    }

    private fun litriToPolliciCubi(litri: Double): String {
        val polliciCubi = litri * 61.0237
        return polliciCubi.toString()
    }

    private fun litriToPiediCubi(litri: Double): String {
        val piediCubi = litri / 28.3168
        return piediCubi.toString()
    }

    // Millilitri
    private fun millilitriToLitri(millilitri: Double): String {
        val litri = millilitri / 1000
        return litri.toString()
    }

    private fun millilitriToCentimetriCubi(millilitri: Double): String {
        val centimetriCubi = millilitri
        return centimetriCubi.toString()
    }

    private fun millilitriToMetriCubi(millilitri: Double): String {
        val metriCubi = millilitri / 1e+6
        return metriCubi.toString()
    }

    private fun millilitriToPolliciCubi(millilitri: Double): String {
        val polliciCubi = millilitri / 16.387
        return polliciCubi.toString()
    }

    private fun millilitriToPiediCubi(millilitri: Double): String {
        val piediCubi = millilitri / 28316.8
        return piediCubi.toString()
    }

    // Centimetri cubi
    private fun centimetriCubiToLitri(centimetriCubi: Double): String {
        val litri = centimetriCubi / 1000
        return litri.toString()
    }

    private fun centimetriCubiToMillilitri(centimetriCubi: Double): String {
        val millilitri = centimetriCubi
        return millilitri.toString()
    }

    private fun centimetriCubiToMetriCubi(centimetriCubi: Double): String {
        val metriCubi = centimetriCubi / 1e+6
        return metriCubi.toString()
    }

    private fun centimetriCubiToPolliciCubi(centimetriCubi: Double): String {
        val polliciCubi = centimetriCubi / 16.387
        return polliciCubi.toString()
    }

    private fun centimetriCubiToPiediCubi(centimetriCubi: Double): String {
        val piediCubi = centimetriCubi / 28316.8
        return piediCubi.toString()
    }

    // Metri cubi
    private fun metriCubiToLitri(metriCubi: Double): String {
        val litri = metriCubi * 1000
        return litri.toString()
    }

    private fun metriCubiToMillilitri(metriCubi: Double): String {
        val millilitri = metriCubi * 1e+6
        return millilitri.toString()
    }

    private fun metriCubiToCentimetriCubi(metriCubi: Double): String {
        val centimetriCubi = metriCubi * 1e+6
        return centimetriCubi.toString()
    }

    private fun metriCubiToPolliciCubi(metriCubi: Double): String {
        val polliciCubi = metriCubi * 61023.7
        return polliciCubi.toString()
    }

    private fun metriCubiToPiediCubi(metriCubi: Double): String {
        val piediCubi = metriCubi * 35.3147
        return piediCubi.toString()
    }

    // Pollici cubi
    private fun polliciCubiToLitri(polliciCubi: Double): String {
        val litri = polliciCubi / 61.0237
        return litri.toString()
    }

    private fun polliciCubiToMillilitri(polliciCubi: Double): String {
        val millilitri = polliciCubi * 16.387
        return millilitri.toString()
    }

    private fun polliciCubiToCentimetriCubi(polliciCubi: Double): String {
        val centimetriCubi = polliciCubi * 16.387
        return centimetriCubi.toString()
    }

    private fun polliciCubiToMetriCubi(polliciCubi: Double): String {
        val metriCubi = polliciCubi / 61023.7
        return metriCubi.toString()
    }

    private fun polliciCubiToPiediCubi(polliciCubi: Double): String {
        val piediCubi = polliciCubi / 1728
        return piediCubi.toString()
    }

    // Piedi cubi
    private fun piediCubiToLitri(piediCubi: Double): String {
        val litri = piediCubi * 28.3168
        return litri.toString()
    }

    private fun piediCubiToMillilitri(piediCubi: Double): String {
        val millilitri = piediCubi * 28316.8
        return millilitri.toString()
    }

    private fun piediCubiToCentimetriCubi(piediCubi: Double): String {
        val centimetriCubi = piediCubi * 28316.8
        return centimetriCubi.toString()
    }

    private fun piediCubiToMetriCubi(piediCubi: Double): String {
        val metriCubi = piediCubi / 35.3147
        return metriCubi.toString()
    }

    private fun piediCubiToPolliciCubi(piediCubi: Double): String {
        val polliciCubi = piediCubi * 1728
        return polliciCubi.toString()
    }
}
