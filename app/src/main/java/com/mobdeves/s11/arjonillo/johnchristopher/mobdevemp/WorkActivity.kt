package com.mobdeves.s11.arjonillo.johnchristopher.mobdevemp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.mobdeves.s11.arjonillo.johnchristopher.mobdevemp.databinding.ActivityWorkBinding


class WorkActivity : AppCompatActivity() {

    private val TAG = "WORKACTIVITY"
    private lateinit var binding: ActivityWorkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.btnBack.setOnClickListener() {
//            var goToMainActivity = Intent(applicationContext, MainActivity::class.java)
//            startActivity(goToMainActivity)
            finish()
        }
    }

//    override fun onResume() {
//        super.onResume()
//        Log.i(TAG, "Resuming Activity Session")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.i(TAG, "Pausing Session")
//    }
}