package test.dapuk.backgroundmusicapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var isPlaying = false
    private lateinit var tombolPlayPause: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tombolPlayPause = findViewById(R.id.play)
        tombolPlayPause.setOnClickListener {
            if (isPlaying) {
                stopMusic()
            } else {
                startMusic()
            }
            isPlaying = !isPlaying
            updateButtonImage()
        }
    }
    private fun startMusic() {
        val intent = Intent(this, MusicService::class.java)
        intent.action = "START"
        startService(intent)
    }

    private fun stopMusic() {
        val intent = Intent(this, MusicService::class.java)
        intent.action = "STOP"
        startService(intent)
    }

    private fun updateButtonImage() {
        if (isPlaying) {
            tombolPlayPause.setImageResource(R.drawable.pause)
        } else {
            tombolPlayPause.setImageResource(R.drawable.mulai)
        }
    }
    }


