package com.example.myapplication515454545

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MusicService : Service() {

    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.music)
        mediaPlayer.isLooping = true // Riproduzione in loop
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer.start() // Avvia la riproduzione della musica
        return START_STICKY // Il servizio viene riavviato se termina in modo anomalo
    }

    override fun onDestroy() {
        mediaPlayer.stop() // Ferma la riproduzione della musica
        mediaPlayer.release() // Rilascia le risorse del MediaPlayer
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
