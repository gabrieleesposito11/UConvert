package com.example.myapplication515454545

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class mancia_cal : AppCompatActivity() {
    private lateinit var cv_percentuale: CardView
    private lateinit var cv_persone: CardView
    private lateinit var cv_calcolaMancia: CardView
    private lateinit var mCLayout: RelativeLayout
    private var percentuale = 15
    private var numeroPersone = 1
    private lateinit var tv_percentuale: TextView
    private lateinit var tv_numeroPersone: TextView
    private lateinit var et_totaleConto: EditText
    private lateinit var et_totaleMancia: EditText
    private lateinit var buttonRobot: ImageButton // pulsante robot
    private val percentuali = Array(99) { "${it + 1}%" }
    private val persone = Array(99) { "${it + 1}" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mancia_cal)

        cv_percentuale = findViewById(R.id.cv_percentuale)
        cv_persone = findViewById(R.id.cv_persone)
        cv_calcolaMancia = findViewById(R.id.cv_calcolaMancia)
        mCLayout = findViewById(R.id.mancia_relativeLayout)
        tv_percentuale = findViewById(R.id.tv_percentuale)
        tv_numeroPersone = findViewById(R.id.tv_numeroPersone)
        tv_percentuale.text = "${percentuale}%"
        tv_numeroPersone.text = "$numeroPersone"
        et_totaleConto = findViewById(R.id.et_totaleConto)
        et_totaleMancia = findViewById(R.id.et_totaleMancia)
        buttonRobot = findViewById(R.id.button_robot) // Riferimento all'ImageButton nel layout

        buttonRobot.setOnClickListener {
            // Mostra un AlertDialog quando si preme sull'ImageButton
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Benvenuto nel calcolatore di mancia") // Titolo del messaggio
            builder.setMessage("Ciao! Sono qui per aiutarti a calcolare la mancia.\nInserisci il totale del conto, seleziona la percentuale di mancia e il numero di persone.") // Testo del messaggio
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss() // Chiudi il dialog quando si preme OK
            }
            val dialog = builder.create()
            dialog.show() // Mostra il dialog
        }

        cv_calcolaMancia.setOnClickListener {
            val totaleContoInput = et_totaleConto.text.toString()
            if (totaleContoInput.isBlank()) {
                et_totaleConto.error = "Inserisci il totale del conto"
            } else {
                val totaleConto = totaleContoInput.toDouble()
                val totaleMancia = calcolaMancia(totaleConto, percentuale, numeroPersone)
                et_totaleMancia.setText(String.format("%.2f", totaleMancia))
            }
        }

        cv_percentuale.setOnClickListener {
            showSelectionDialog(true)
        }

        cv_persone.setOnClickListener {
            showSelectionDialog(false)
        }
    }

    private fun showSelectionDialog(isPercentuale: Boolean) {
        val builder = AlertDialog.Builder(this@mancia_cal)
        val title = if (isPercentuale) "Seleziona la percentuale di mancia" else "Seleziona il numero di persone"
        builder.setTitle(title)
        val selectedItem = if (isPercentuale) percentuale - 1 else numeroPersone - 1
        val items = if (isPercentuale) percentuali else persone
        builder.setSingleChoiceItems(items, selectedItem) { dialogInterface, i ->
            if (isPercentuale) {
                percentuale = i + 1
                tv_percentuale.text = "${percentuale}%"
            } else {
                numeroPersone = i + 1
                tv_numeroPersone.text = "$numeroPersone"
            }
            dialogInterface.dismiss()
        }
        builder.setPositiveButton("OK") { dialogInterface, _ ->
            dialogInterface.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }

    private fun calcolaMancia(totaleConto: Double, percentuale: Int, numeroPersone: Int): Double {
        val manciaPerPersona = (totaleConto * percentuale / 100) / numeroPersone
        return manciaPerPersona
    }
}
