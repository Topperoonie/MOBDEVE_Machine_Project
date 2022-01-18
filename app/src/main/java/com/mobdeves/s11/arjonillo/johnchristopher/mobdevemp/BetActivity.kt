package com.mobdeves.s11.arjonillo.johnchristopher.mobdevemp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobdeves.s11.arjonillo.johnchristopher.mobdevemp.databinding.ActivityBetBinding
import com.mobdeves.s11.arjonillo.johnchristopher.mobdevemp.databinding.ActivityPokerruleBinding

class BetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBetBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.btnBack.setOnClickListener() {
//            var goToMainActivity = Intent(applicationContext, MainActivity::class.java)
//            startActivity(goToMainActivity)
            finish()
        }


    }
}