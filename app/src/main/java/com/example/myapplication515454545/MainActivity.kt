package com.example.myapplication515454545

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        startService(Intent(this, MusicService::class.java))


        val videoView: VideoView = findViewById(R.id.videoView)
        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.sfondo)
        videoView.setVideoURI(videoUri)


        videoView.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = true  // Imposta il loop del video
            videoView.start()             // Avvia il video
        }

    }

    //distruzione dell'Activity
    override fun onDestroy() {
        super.onDestroy()

        // STOP il servizio per la musica di sottofondo
        stopService(Intent(this, MusicService::class.java))
    }

    // PULSANTI
    fun onSquareButtonClick1(view: View) {
        startActivity(Intent(this, temp_cal::class.java))
    }

    fun onSquareButtonClick2(view: View) {
        startActivity(Intent(this, volume_cal::class.java))
    }

    fun onSquareButtonClick3(view: View) {
        startActivity(Intent(this, area_cal::class.java))
    }

    fun onSquareButtonClick4(view: View) {
        startActivity(Intent(this, lunghezza_cal::class.java))
    }

    fun onSquareButtonClick5(view: View) {
        startActivity(Intent(this, massa_cal::class.java))
    }

    fun onSquareButtonClick6(view: View) {
        startActivity(Intent(this, dati_cal::class.java))
    }

    fun onSquareButtonClick7(view: View) {
        startActivity(Intent(this, velocita_cal::class.java))
    }

    fun onSquareButtonClick8(view: View) {
        startActivity(Intent(this, orario_cal::class.java))
    }

    fun onSquareButtonClick9(view: View) {
        startActivity(Intent(this, mancia_cal::class.java))
    }
}
