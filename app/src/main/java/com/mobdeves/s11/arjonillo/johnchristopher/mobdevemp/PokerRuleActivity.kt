package com.mobdeves.s11.arjonillo.johnchristopher.mobdevemp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobdeves.s11.arjonillo.johnchristopher.mobdevemp.databinding.ActivityMainBinding
import com.mobdeves.s11.arjonillo.johnchristopher.mobdevemp.databinding.ActivityPokerruleBinding

class PokerRuleActivity : AppCompatActivity () {

    private lateinit var binding: ActivityPokerruleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokerruleBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.btnBack.setOnClickListener() {
//            var goToMainActivity = Intent(applicationContext, MainActivity::class.java)
//            startActivity(goToMainActivity)
            finish()
        }
    }

}