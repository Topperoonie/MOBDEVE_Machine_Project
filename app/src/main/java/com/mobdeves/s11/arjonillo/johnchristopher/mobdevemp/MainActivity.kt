package com.mobdeves.s11.arjonillo.johnchristopher.mobdevemp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.mobdeves.s11.arjonillo.johnchristopher.mobdevemp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG = "MAINACTIVITY"

    init {
        Log.i(TAG, "Initializing")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.btnPlay.setOnClickListener() {
            var goToBetActivity = Intent(applicationContext, BetActivity::class.java)
            startActivity(goToBetActivity)
        }

        binding!!.btnRules.setOnClickListener() {
            var goToPokerRulesActivity = Intent(applicationContext, PokerRuleActivity::class.java)
            startActivity(goToPokerRulesActivity)
        }

        binding!!.btnWork.setOnClickListener() {
            var goToWorkActivity = Intent(applicationContext, WorkActivity::class.java)
            startActivity(goToWorkActivity)
        }

        binding!!.btnQuit.setOnClickListener() {
            onDestroy()
        }



    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "UI Loading")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "Resuming Activity Session")
//        Snackbar.make(binding.root, "Profile Loaded!", Snackbar.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "Pausing Session")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "Stopping")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "Exiting...Have a good day!")
        finish()
        System.exit(0)
    }

}