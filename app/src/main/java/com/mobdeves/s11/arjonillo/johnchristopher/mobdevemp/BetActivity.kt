package com.mobdeves.s11.arjonillo.johnchristopher.mobdevemp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.mobdeves.s11.arjonillo.johnchristopher.mobdevemp.databinding.ActivityBetBinding
import com.mobdeves.s11.arjonillo.johnchristopher.mobdevemp.databinding.ActivityPokerruleBinding

class BetActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBetBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.btnBet10.setOnClickListener() {
            Snackbar.make(binding.root, "Current bet set to 10chips", Snackbar.LENGTH_SHORT).show()

            var bundle = Bundle()
            bundle.putInt("currBet", 10)
            var goToPokerMainActivity = Intent(applicationContext, PokerMain::class.java)
            goToPokerMainActivity.putExtras(bundle)
            startActivity(goToPokerMainActivity)

            finish()
        }

        binding!!.btnBet100.setOnClickListener() {
            Snackbar.make(binding.root, "Current bet set to 100chips", Snackbar.LENGTH_SHORT).show()

            var bundle = Bundle()
            var intent = Intent()

            bundle.putInt("currBet", 100)
            intent.putExtras(bundle)
            var goToPokerMainActivity = Intent(applicationContext, PokerMain::class.java)
            goToPokerMainActivity.putExtras(intent)
            startActivity(goToPokerMainActivity)

            finish()
        }

        binding!!.btnBet1000.setOnClickListener() {
            Snackbar.make(binding.root, "Current bet set to 1000chips", Snackbar.LENGTH_SHORT).show()

            var bundle = Bundle()
            var intent = Intent()

            bundle.putInt("currBet", 1000)
            intent.putExtras(bundle)
            var goToPokerMainActivity = Intent(applicationContext, PokerMain::class.java)
            goToPokerMainActivity.putExtras(intent)
            startActivity(goToPokerMainActivity)

            finish()
        }

        binding!!.btnBack.setOnClickListener() {
//            var goToMainActivity = Intent(applicationContext, MainActivity::class.java)
//            startActivity(goToMainActivity)
            finish()
        }




    }
}