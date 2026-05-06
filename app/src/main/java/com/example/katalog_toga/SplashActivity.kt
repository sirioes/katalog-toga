package com.example.katalog_toga

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "42430001"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Log.d(TAG, "SplashActivity: onCreate - aplikasi dimulai")

        try {
            Handler(Looper.getMainLooper()).postDelayed({
                try {
                    Log.i(TAG, "SplashActivity: berpindah ke MainActivity")
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } catch (e: Exception) {
                    Log.e(TAG, "SplashActivity: gagal membuka MainActivity - ${e.message}", e)
                }
            }, 2000)
        } catch (e: Exception) {
            Log.e(TAG, "SplashActivity: error pada Handler postDelayed - ${e.message}", e)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "SplashActivity: onDestroy")
    }
}
