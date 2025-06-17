package com.example.myapplication515454545

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class dati_cal : AppCompatActivity() {
    private lateinit var cv_fromUnit: CardView
    private lateinit var cv_toUnit: CardView
    private lateinit var cv_convert: CardView
    private lateinit var mCLayout: RelativeLayout
    private var fromUnit = "Bit"
    private var toUnit = "Byte"
    private lateinit var tv_fromUnit: TextView
    private lateinit var tv_toUnit: TextView
    private lateinit var et_fromUnit: EditText
    private lateinit var et_toUnit: EditText
    private lateinit var buttonRobot: ImageButton // pulsante robot
    private val values = arrayOf(
        "Bit",
        "Byte",
        "Kilobyte",
        "Kibibyte",
        "Megabyte",
        "Mebibyte",
        "Gigabyte",
        "Gibibyte",
        "Terabyte",
        "Tebibyte"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dati_cal)
        cv_fromUnit = findViewById(R.id.fromUnit)
        cv_toUnit = findViewById(R.id.toUnit)
        cv_convert = findViewById(R.id.cv_convert)
        mCLayout = findViewById(R.id.dati_relativeLayout)
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
            builder.setMessage("Ciao!, Io sono 2FV,\nSapevi che per passare da Byte a Kilobyte devi dividere il valore per 1000") // Testo del messaggio
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss() // Chiudi il dialog quando si preme OK
            }
            val dialog = builder.create()
            dialog.show() // Mostra il dialog
        }

        cv_convert.setOnClickListener {
            val dataInput = et_fromUnit.text.toString()
            if (dataInput.isBlank()) {
                et_fromUnit.error = "Please enter some value"
            } else {
                val inputData = dataInput.toDouble()
                val convertedData = convertData(inputData, fromUnit, toUnit)
                et_toUnit.setText(convertedData)
            }
        }

        cv_toUnit.setOnClickListener {
            val builder = AlertDialog.Builder(this@dati_cal)
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
            val builder = AlertDialog.Builder(this@dati_cal)
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

    private fun convertData(value: Double, fromUnit: String, toUnit: String): String {
        return when (fromUnit) {
            "Bit" -> when (toUnit) {
                "Byte" -> bitToByte(value)
                "Kilobyte" -> bitToKilobyte(value)
                "Kibibyte" -> bitToKibibyte(value)
                "Megabyte" -> bitToMegabyte(value)
                "Mebibyte" -> bitToMebibyte(value)
                "Gigabyte" -> bitToGigabyte(value)
                "Gibibyte" -> bitToGibibyte(value)
                "Terabyte" -> bitToTerabyte(value)
                "Tebibyte" -> bitToTebibyte(value)
                else -> value.toString()
            }

            "Byte" -> when (toUnit) {
                "Bit" -> byteToBit(value)
                "Kilobyte" -> byteToKilobyte(value)
                "Kibibyte" -> byteToKibibyte(value)
                "Megabyte" -> byteToMegabyte(value)
                "Mebibyte" -> byteToMebibyte(value)
                "Gigabyte" -> byteToGigabyte(value)
                "Gibibyte" -> byteToGibibyte(value)
                "Terabyte" -> byteToTerabyte(value)
                "Tebibyte" -> byteToTebibyte(value)
                else -> value.toString()
            }

            "Kilobyte" -> when (toUnit) {
                "Bit" -> kilobyteToBit(value)
                "Byte" -> kilobyteToByte(value)
                "Kibibyte" -> kilobyteToKibibyte(value)
                "Megabyte" -> kilobyteToMegabyte(value)
                "Mebibyte" -> kilobyteToMebibyte(value)
                "Gigabyte" -> kilobyteToGigabyte(value)
                "Gibibyte" -> kilobyteToGibibyte(value)
                "Terabyte" -> kilobyteToTerabyte(value)
                "Tebibyte" -> kilobyteToTebibyte(value)
                else -> value.toString()
            }

            "Kibibyte" -> when (toUnit) {
                "Bit" -> kibibyteToBit(value)
                "Byte" -> kibibyteToByte(value)
                "Kilobyte" -> kibibyteToKilobyte(value)
                "Megabyte" -> kibibyteToMegabyte(value)
                "Mebibyte" -> kibibyteToMebibyte(value)
                "Gigabyte" -> kibibyteToGigabyte(value)
                "Gibibyte" -> kibibyteToGibibyte(value)
                "Terabyte" -> kibibyteToTerabyte(value)
                "Tebibyte" -> kibibyteToTebibyte(value)
                else -> value.toString()
            }

            "Megabyte" -> when (toUnit) {
                "Bit" -> megabyteToBit(value)
                "Byte" -> megabyteToByte(value)
                "Kilobyte" -> megabyteToKilobyte(value)
                "Kibibyte" -> megabyteToKibibyte(value)
                "Mebibyte" -> megabyteToMebibyte(value)
                "Gigabyte" -> megabyteToGigabyte(value)
                "Gibibyte" -> megabyteToGibibyte(value)
                "Terabyte" -> megabyteToTerabyte(value)
                "Tebibyte" -> megabyteToTebibyte(value)
                else -> value.toString()
            }

            "Mebibyte" -> when (toUnit) {
                "Bit" -> mebibyteToBit(value)
                "Byte" -> mebibyteToByte(value)
                "Kilobyte" -> mebibyteToKilobyte(value)
                "Kibibyte" -> mebibyteToKibibyte(value)
                "Megabyte" -> mebibyteToMegabyte(value)
                "Gigabyte" -> mebibyteToGigabyte(value)
                "Gibibyte" -> mebibyteToGibibyte(value)
                "Terabyte" -> mebibyteToTerabyte(value)
                "Tebibyte" -> mebibyteToTebibyte(value)
                else -> value.toString()
            }

            "Gigabyte" -> when (toUnit) {
                "Bit" -> gigabyteToBit(value)
                "Byte" -> gigabyteToByte(value)
                "Kilobyte" -> gigabyteToKilobyte(value)
                "Kibibyte" -> gigabyteToKibibyte(value)
                "Megabyte" -> gigabyteToMegabyte(value)
                "Mebibyte" -> gigabyteToMebibyte(value)
                "Gibibyte" -> gigabyteToGibibyte(value)
                "Terabyte" -> gigabyteToTerabyte(value)
                "Tebibyte" -> gigabyteToTebibyte(value)
                else -> value.toString()
            }

            "Gibibyte" -> when (toUnit) {
                "Bit" -> gibibyteToBit(value)
                "Byte" -> gibibyteToByte(value)
                "Kilobyte" -> gibibyteToKilobyte(value)
                "Kibibyte" -> gibibyteToKibibyte(value)
                "Megabyte" -> gibibyteToMegabyte(value)
                "Mebibyte" -> gibibyteToMebibyte(value)
                "Gigabyte" -> gibibyteToGigabyte(value)
                "Terabyte" -> gibibyteToTerabyte(value)
                "Tebibyte" -> gibibyteToTebibyte(value)
                else -> value.toString()
            }

            "Terabyte" -> when (toUnit) {
                "Bit" -> terabyteToBit(value)
                "Byte" -> terabyteToByte(value)
                "Kilobyte" -> terabyteToKilobyte(value)
                "Kibibyte" -> terabyteToKibibyte(value)
                "Megabyte" -> terabyteToMegabyte(value)
                "Mebibyte" -> terabyteToMebibyte(value)
                "Gigabyte" -> terabyteToGigabyte(value)
                "Gibibyte" -> terabyteToGibibyte(value)
                "Tebibyte" -> terabyteToTebibyte(value)
                else -> value.toString()
            }

            "Tebibyte" -> when (toUnit) {
                "Bit" -> tebibyteToBit(value)
                "Byte" -> tebibyteToByte(value)
                "Kilobyte" -> tebibyteToKilobyte(value)
                "Kibibyte" -> tebibyteToKibibyte(value)
                "Megabyte" -> tebibyteToMegabyte(value)
                "Mebibyte" -> tebibyteToMebibyte(value)
                "Gigabyte" -> tebibyteToGigabyte(value)
                "Gibibyte" -> tebibyteToGibibyte(value)
                "Terabyte" -> tebibyteToTerabyte(value)
                else -> value.toString()
            }

            else -> value.toString()
        }
    }

    // Bit to other units
    private fun bitToByte(bit: Double): String {
        return (bit / 8).toString()
    }

    private fun bitToKilobyte(bit: Double): String {
        return (bit / 8000).toString()
    }

    private fun bitToKibibyte(bit: Double): String {
        return (bit / 8192).toString()
    }

    private fun bitToMegabyte(bit: Double): String {
        return (bit / 8e+6).toString()
    }

    private fun bitToMebibyte(bit: Double): String {
        return (bit / 8.389e+6).toString()
    }

    private fun bitToGigabyte(bit: Double): String {
        return (bit / 8e+9).toString()
    }

    private fun bitToGibibyte(bit: Double): String {
        return (bit / 8.59e+9).toString()
    }

    private fun bitToTerabyte(bit: Double): String {
        return (bit / 8e+12).toString()
    }

    private fun bitToTebibyte(bit: Double): String {
        return (bit / 8.796e+12).toString()
    }

    // Byte to other units
    private fun byteToBit(byte: Double): String {
        return (byte * 8).toString()
    }

    private fun byteToKilobyte(byte: Double): String {
        return (byte / 1000).toString()
    }

    private fun byteToKibibyte(byte: Double): String {
        return (byte / 1024).toString()
    }

    private fun byteToMegabyte(byte: Double): String {
        return (byte / 1e+6).toString()
    }

    private fun byteToMebibyte(byte: Double): String {
        return (byte / 1.049e+6).toString()
    }

    private fun byteToGigabyte(byte: Double): String {
        return (byte / 1e+9).toString()
    }

    private fun byteToGibibyte(byte: Double): String {
        return (byte / 1.074e+9).toString()
    }

    private fun byteToTerabyte(byte: Double): String {
        return (byte / 1e+12).toString()
    }

    private fun byteToTebibyte(byte: Double): String {
        return (byte / 1.1e+12).toString()
    }

    // Kilobyte to other units
    private fun kilobyteToBit(kilobyte: Double): String {
        return (kilobyte * 8000).toString()
    }

    private fun kilobyteToByte(kilobyte: Double): String {
        return (kilobyte * 1000).toString()
    }

    private fun kilobyteToKibibyte(kilobyte: Double): String {
        return (kilobyte / 0.976563).toString()
    }

    private fun kilobyteToMegabyte(kilobyte: Double): String {
        return (kilobyte / 1000).toString()
    }

    private fun kilobyteToMebibyte(kilobyte: Double): String {
        return (kilobyte / 1024).toString()
    }

    private fun kilobyteToGigabyte(kilobyte: Double): String {
        return (kilobyte / 1e+6).toString()
    }

    private fun kilobyteToGibibyte(kilobyte: Double): String {
        return (kilobyte / 1.049e+6).toString()
    }

    private fun kilobyteToTerabyte(kilobyte: Double): String {
        return (kilobyte / 1e+9).toString()
    }

    private fun kilobyteToTebibyte(kilobyte: Double): String {
        return (kilobyte / 1.1e+9).toString()
    }

    // Kibibyte to other units
    private fun kibibyteToBit(kibibyte: Double): String {
        return (kibibyte * 8192).toString()
    }

    private fun kibibyteToByte(kibibyte: Double): String {
        return (kibibyte * 1024).toString()
    }

    private fun kibibyteToKilobyte(kibibyte: Double): String {
        return (kibibyte * 0.976563).toString()
    }

    private fun kibibyteToMegabyte(kibibyte: Double): String {
        return (kibibyte / 977).toString()
    }

    private fun kibibyteToMebibyte(kibibyte: Double): String {
        return (kibibyte / 1024).toString()
    }

    private fun kibibyteToGigabyte(kibibyte: Double): String {
        return (kibibyte / 976563).toString()
    }

    private fun kibibyteToGibibyte(kibibyte: Double): String {
        return (kibibyte / 1.074e+9).toString()
    }

    private fun kibibyteToTerabyte(kibibyte: Double): String {
        return (kibibyte / 9.766e+8).toString()
    }

    private fun kibibyteToTebibyte(kibibyte: Double): String {
        return (kibibyte / 1.1e+9).toString()
    }

    // Megabyte to other units
    private fun megabyteToBit(megabyte: Double): String {
        return (megabyte * 8e+6).toString()
    }

    private fun megabyteToByte(megabyte: Double): String {
        return (megabyte * 1e+6).toString()
    }

    private fun megabyteToKilobyte(megabyte: Double): String {
        return (megabyte * 1000).toString()
    }

    private fun megabyteToKibibyte(megabyte: Double): String {
        return (megabyte * 977).toString()
    }

    private fun megabyteToMebibyte(megabyte: Double): String {
        return (megabyte / 1.049).toString()
    }

    private fun megabyteToGigabyte(megabyte: Double): String {
        return (megabyte / 1000).toString()
    }

    private fun megabyteToGibibyte(megabyte: Double): String {
        return (megabyte / 1.074).toString()
    }

    private fun megabyteToTerabyte(megabyte: Double): String {
        return (megabyte / 1e+6).toString()
    }

    private fun megabyteToTebibyte(megabyte: Double): String {
        return (megabyte / 1.1e+6).toString()
    }

    // Mebibyte to other units
    private fun mebibyteToBit(mebibyte: Double): String {
        return (mebibyte * 8.389e+6).toString()
    }

    private fun mebibyteToByte(mebibyte: Double): String {
        return (mebibyte * 1.049e+6).toString()
    }

    private fun mebibyteToKilobyte(mebibyte: Double): String {
        return (mebibyte * 1024).toString()
    }

    private fun mebibyteToKibibyte(mebibyte: Double): String {
        return (mebibyte * 1024).toString()
    }

    private fun mebibyteToMegabyte(mebibyte: Double): String {
        return (mebibyte * 1.049).toString()
    }

    private fun mebibyteToGigabyte(mebibyte: Double): String {
        return (mebibyte / 953).toString()
    }

    private fun mebibyteToGibibyte(mebibyte: Double): String {
        return (mebibyte / 1.074).toString()
    }

    private fun mebibyteToTerabyte(mebibyte: Double): String {
        return (mebibyte / 9.766e+5).toString()
    }

    private fun mebibyteToTebibyte(mebibyte: Double): String {
        return (mebibyte / 1.1e+6).toString()
    }

    // Gigabyte to other units
    private fun gigabyteToBit(gigabyte: Double): String {
        return (gigabyte * 8e+9).toString()
    }

    private fun gigabyteToByte(gigabyte: Double): String {
        return (gigabyte * 1e+9).toString()
    }

    private fun gigabyteToKilobyte(gigabyte: Double): String {
        return (gigabyte * 1e+6).toString()
    }

    private fun gigabyteToKibibyte(gigabyte: Double): String {
        return (gigabyte * 976563).toString()
    }

    private fun gigabyteToMegabyte(gigabyte: Double): String {
        return (gigabyte * 1000).toString()
    }
    private fun gigabyteToMebibyte(gigabyte: Double): String {
        return (gigabyte * 953.674).toString()
    }


    private fun gigabyteToGibibyte(gigabyte: Double): String {
        return (gigabyte / 1.074).toString()
    }

    private fun gigabyteToTerabyte(gigabyte: Double): String {
        return (gigabyte / 1000).toString()
    }

    private fun gigabyteToTebibyte(gigabyte: Double): String {
        return (gigabyte / 1.1e+6).toString()
    }

    // Gibibyte to other units
    private fun gibibyteToBit(gibibyte: Double): String {
        return (gibibyte * 8.59e+9).toString()
    }

    private fun gibibyteToByte(gibibyte: Double): String {
        return (gibibyte * 1.074e+9).toString()
    }

    private fun gibibyteToKilobyte(gibibyte: Double): String {
        return (gibibyte * 1.049e+6).toString()
    }

    private fun gibibyteToKibibyte(gibibyte: Double): String {
        return (gibibyte * 1.074e+6).toString()
    }

    private fun gibibyteToMegabyte(gibibyte: Double): String {
        return (gibibyte * 1.074).toString()
    }

    private fun gibibyteToMebibyte(gibibyte: Double): String {
        return (gibibyte * 1024).toString()
    }


    private fun gibibyteToGigabyte(gibibyte: Double): String {
        return (gibibyte * 1.074).toString()
    }

    private fun gibibyteToTerabyte(gibibyte: Double): String {
        return (gibibyte / 931).toString()
    }

    private fun gibibyteToTebibyte(gibibyte: Double): String {
        return (gibibyte / 1074).toString()
    }

    // Terabyte to other units
    private fun terabyteToBit(terabyte: Double): String {
        return (terabyte * 8e+12).toString()
    }

    private fun terabyteToByte(terabyte: Double): String {
        return (terabyte * 1e+12).toString()
    }

    private fun terabyteToKilobyte(terabyte: Double): String {
        return (terabyte * 1e+9).toString()
    }

    private fun terabyteToKibibyte(terabyte: Double): String {
        return (terabyte * 9.766e+8).toString()
    }

    private fun terabyteToMegabyte(terabyte: Double): String {
        return (terabyte * 1e+6).toString()
    }

    private fun terabyteToMebibyte(terabyte: Double): String {
        return (terabyte * 953674).toString()
    }

    private fun terabyteToGigabyte(terabyte: Double): String {
        return (terabyte * 1000).toString()
    }

    private fun terabyteToGibibyte(terabyte: Double): String {
        return (terabyte * 931.323).toString()
    }

    private fun terabyteToTebibyte(terabyte: Double): String {
        return (terabyte / 1.1).toString()
    }

    // Tebibyte to other units
    private fun tebibyteToBit(tebibyte: Double): String {
        return (tebibyte * 8.796e+12).toString()
    }

    private fun tebibyteToByte(tebibyte: Double): String {
        return (tebibyte * 1.1e+12).toString()
    }

    private fun tebibyteToKilobyte(tebibyte: Double): String {
        return (tebibyte * 1.1e+9).toString()
    }

    private fun tebibyteToKibibyte(tebibyte: Double): String {
        return (tebibyte * 1.1e+9).toString()
    }

    private fun tebibyteToMegabyte(tebibyte: Double): String {
        return (tebibyte * 1.1e+6).toString()
    }

    private fun tebibyteToMebibyte(tebibyte: Double): String {
        return (tebibyte * 1.074e+6).toString()
    }

    private fun tebibyteToGigabyte(tebibyte: Double): String {
        return (tebibyte * 1.1e+3).toString()
    }

    private fun tebibyteToGibibyte(tebibyte: Double): String {
        return (tebibyte * 1.074).toString()
    }

    private fun tebibyteToTerabyte(tebibyte: Double): String {
        return (tebibyte * 1.1).toString()
    }
}





