package com.mobdeves.s11.arjonillo.johnchristopher.mobdevemp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.mobdeves.s11.arjonillo.johnchristopher.mobdevemp.databinding.ActivityDoubleNothingBinding

class DoubleNothingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDoubleNothingBinding
    private var winLose = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoubleNothingBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        winLose = false
        var winnings = intent.getIntExtra("winnings", 0)
        var bundle = Bundle()
        var intent = Intent()

        // Left Card
        var s1 = (1..4).random()
        var n1 = (1..13).random()
        var leftSuit = s1
        var leftNumber = n1
        Log.i("DOUBLENOTHINGACTIVITY", "LEFTSUIT: $leftSuit")
        Log.i("DOUBLENOTHINGACTIVITY", "LEFTNUMBER: $leftNumber")

        // Set the card in the UI
        var cardName1 = "pc_" + leftSuit + "_" + leftNumber
        binding!!.ivLeftCard.setImageDrawable(resources.getDrawable(resources.getIdentifier("@drawable/$cardName1", null, packageName)))

        binding!!.btnHigher.setOnClickListener() {
            // Right Card
            var s2 = (1..4).random()
            var n2 = (1..13).random()
            var rightSuit = s2
            var rightNumber = n2
            Log.i("DOUBLENOTHINGACTIVITY", "RIGHTSUIT: $rightSuit")
            Log.i("DOUBLENOTHINGACTIVITY", "RIGHTNUMBER: $rightNumber")
            // Set the card in the UI
            var cardName2 = "pc_" + rightSuit + "_" + rightNumber
            binding!!.ivRightCard.setImageDrawable(resources.getDrawable(resources.getIdentifier("@drawable/$cardName2", null, packageName)))

//            // If the right card's suit is higher
//            if(rightSuit >= leftSuit) {
                // If right card's value is higher
                // Aces are the highest; 2's are the lowest
                if(rightNumber > leftNumber || rightNumber == 1) {
                    winnings *= 2
                    winLose = true
                    bundle.putInt("winnings", winnings)
                    intent.putExtras(bundle)
                }
                // If the right card's number is NOT higher
                else {
                    winnings = 0
                    bundle.putInt("winnings", winnings)
                    intent.putExtras(bundle)
                }
//            }

//            // If the right card's suit is NOT higher
//            else {
//                winnings = 0
//                bundle.putInt("winnings", winnings)
//                intent.putExtras(bundle)
//            }

            if(winLose) {
                Log.i("DOUBLENOTHINGACTIVITY", "CHECKCHECKCHECK")
                val builder1 = AlertDialog.Builder(this)
                // Set alert title
                builder1.setTitle("Returning to Poker Game")
                // Set alert message
                builder1.setMessage("YOU WON!")

                // When "Yes" is selected
                builder1.setPositiveButton("Ok") {dialogInterface, which ->
                    setResult(RESULT_OK, intent)
                    finish()
                }

                // Creating the AlertDialog
                val alertDialog: AlertDialog = builder1.create()
                // Setting other AlertDialog properties
                alertDialog.show()
            }

            else {
                Log.i("DOUBLENOTHINGACTIVITY", "CHECKCHECKCHECK")
                val builder1 = AlertDialog.Builder(this)
                // Set alert title
                builder1.setTitle("Returning to Poker Game")
                // Set alert message
                builder1.setMessage("YOU LOST!")

                // When "Yes" is selected
                builder1.setPositiveButton("Ok") {dialogInterface, which ->
                    setResult(RESULT_OK, intent)
                    finish()
                }

                // Creating the AlertDialog
                val alertDialog: AlertDialog = builder1.create()
                // Setting other AlertDialog properties
                alertDialog.show()
            }
        }

        binding!!.btnLower.setOnClickListener() {
            // Right Card
            var s2 = (1..4).random()
            var n2 = (1..13).random()
            var rightSuit = s2
            var rightNumber = n2
            Log.i("DOUBLENOTHINGACTIVITY", "RIGHTSUIT: $rightSuit")
            Log.i("DOUBLENOTHINGACTIVITY", "RIGHTNUMBER: $rightNumber")
            // Set the card in the UI
            var cardName2 = "pc_" + rightSuit + "_" + rightNumber
            binding!!.ivRightCard.setImageDrawable(resources.getDrawable(resources.getIdentifier("@drawable/$cardName2", null, packageName)))

//            // If the right card's suit is lower
//            if(rightSuit <= leftSuit) {
                // If right card's value is lower
                // Aces are the highest; 2's are the lowest
                if(rightNumber < leftNumber || rightNumber == 2) {
                    winnings *= 2
                    bundle.putInt("winnings", winnings)
                    intent.putExtras(bundle)
                }

                // If the right card's number is NOT lower
                else {
                    winnings = 0
                    bundle.putInt("winnings", winnings)
                    intent.putExtras(bundle)
                }
//            }

//            // If the right card's suit is NOT lower
//            else {
//                winnings = 0
//                bundle.putInt("winnings", winnings)
//                intent.putExtras(bundle)
//            }

            if(winLose) {
                Log.i("DOUBLENOTHINGACTIVITY", "CHECKCHECKCHECK")
                val builder2 = AlertDialog.Builder(this)
                // Set alert title
                builder2.setTitle("Returning to Poker Game")
                // Set alert message
                builder2.setMessage("YOU WON!")

                // When "Yes" is selected
                builder2.setPositiveButton("Ok") {dialogInterface, which ->
                    setResult(RESULT_OK, intent)
                    finish()
                }

                // Creating the AlertDialog
                val alertDialog: AlertDialog = builder2.create()
                // Setting other AlertDialog properties
                alertDialog.show()
            }

            else {
                Log.i("DOUBLENOTHINGACTIVITY", "CHECKCHECKCHECK")
                val builder2 = AlertDialog.Builder(this)
                // Set alert title
                builder2.setTitle("Returning to Poker Game")
                // Set alert message
                builder2.setMessage("YOU LOST!")

                // When "Yes" is selected
                builder2.setPositiveButton("Ok") {dialogInterface, which ->
                    setResult(RESULT_OK, intent)
                    finish()
                }

                // Creating the AlertDialog
                val alertDialog: AlertDialog = builder2.create()
                // Setting other AlertDialog properties
                alertDialog.show()
            }
        }

    }
}