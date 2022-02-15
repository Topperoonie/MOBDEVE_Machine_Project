package com.mobdeves.s11.arjonillo.johnchristopher.mobdevemp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.mobdeves.s11.arjonillo.johnchristopher.mobdevemp.databinding.ActivityPokerMainBinding
import java.util.*

class PokerMain : AppCompatActivity() {

    private lateinit var binding: ActivityPokerMainBinding

    private var money = 5000
    private var winnings = 0
    private var bet = 0
    var pairs = 0
    var higherOrLower = false

//    val pokerHand = arrayOf<Int>()
//
//    var s1 = 0
//    var n1 = 0
//    var suit1 = 0
//    var number1 = 0

    // Standard deck of 52 cards
    // Arranged from 1(ace) - 13(king)
    // Clubs, Spades, Hearts, Diamonds (1, 2, 3, 4)

    private var deckIndex = 0
    private val imageArray = arrayOf(
//        -------------------------- CLUBS ------------------------------------
                                        R.drawable.pc_1_1,
                                        R.drawable.pc_1_2,
                                        R.drawable.pc_1_3,
                                        R.drawable.pc_1_4,
                                        R.drawable.pc_1_5,
                                        R.drawable.pc_1_6,
                                        R.drawable.pc_1_7,
                                        R.drawable.pc_1_8,
                                        R.drawable.pc_1_9,
                                        R.drawable.pc_1_10,
                                        R.drawable.pc_1_11,
                                        R.drawable.pc_1_12,
                                        R.drawable.pc_1_13,
//        -------------------------- SPADES ------------------------------
                                        R.drawable.pc_2_1,
                                        R.drawable.pc_2_2,
                                        R.drawable.pc_2_3,
                                        R.drawable.pc_2_4,
                                        R.drawable.pc_2_5,
                                        R.drawable.pc_2_6,
                                        R.drawable.pc_2_7,
                                        R.drawable.pc_2_8,
                                        R.drawable.pc_2_9,
                                        R.drawable.pc_2_10,
                                        R.drawable.pc_2_11,
                                        R.drawable.pc_2_12,
                                        R.drawable.pc_2_13,
//    ------------------------------ HEARTS ------------------------------------
                                        R.drawable.pc_3_1,
                                        R.drawable.pc_3_2,
                                        R.drawable.pc_3_3,
                                        R.drawable.pc_3_4,
                                        R.drawable.pc_3_5,
                                        R.drawable.pc_3_6,
                                        R.drawable.pc_3_7,
                                        R.drawable.pc_3_8,
                                        R.drawable.pc_3_9,
                                        R.drawable.pc_3_10,
                                        R.drawable.pc_3_11,
                                        R.drawable.pc_3_12,
                                        R.drawable.pc_3_13,
//    ----------------------------- DIAMONDS ----------------------------------
                                        R.drawable.pc_4_1,
                                        R.drawable.pc_4_2,
                                        R.drawable.pc_4_3,
                                        R.drawable.pc_4_4,
                                        R.drawable.pc_4_5,
                                        R.drawable.pc_4_6,
                                        R.drawable.pc_4_7,
                                        R.drawable.pc_4_8,
                                        R.drawable.pc_4_9,
                                        R.drawable.pc_4_10,
                                        R.drawable.pc_4_11,
                                        R.drawable.pc_4_12,
                                        R.drawable.pc_4_13)

    var startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->

        if(result.resultCode == Activity.RESULT_OK) {
            // receive data
            var bundle = result.data!!.extras
            winnings = bundle!!.getInt("winnings", 0)
            money = money + winnings
            // Apply to ui
            binding!!.tvMoney.setText("Money: $money\nCurrent Bet: $bet")
            // check for inputs
            Log.i("POKERMAINACTIVITY", "WINNINGS: $winnings")

        }

        else {
            Snackbar.make(binding.root, "Error! Application Bug...", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokerMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        var bundle = intent.extras
        bet = bundle!!.getInt("currBet", 10)
        Log.i("POKERMAINACTIVITY", "BET: $bet")
        binding!!.tvMoney.setText("Money: $money\nCurrent Bet: $bet")

        binding!!.btnDeal.setOnClickListener() {
            money = money - bet
            binding!!.tvMoney.setText("Money: $money\nCurrent Bet: $bet")
            drawUniqueCards()

        }

//        binding!!.ivCard1.setOnClickListener() {
//
//        }

        binding!!.btnBack.setOnClickListener() {
            finish()
        }

    }

    fun drawUniqueCards() {
        // Card 1--------------------------------------------------------------------------
        var s1 = (1..4).random()
        var n1 = (1..13).random()
        var suit1 = s1
        var number1 = n1
//        var number1 = 1
//        var suit1 = 1

        // Set the card in the UI
        var cardName1 = "pc_" + suit1 + "_" + number1
//        var cardName1 = "pc_1_1"
        binding!!.ivCard1.setImageDrawable(resources.getDrawable(resources.getIdentifier("@drawable/$cardName1", null, packageName)))

        // Card 2-------------------------------------------------------------------------
        var s2 = (1..4).random()
        var n2 = (1..13).random()
        var suit2 = s2
        var number2 = n2
//        var number2 = 12
//        var suit2 = 1

        // Check for card repeat
        while(suit2 == suit1 && number2 == number1) {
            s2 = (1..4).random()
            n2 = (1..13).random()
            suit2 = s2
            number2 = n2
        }

        // Set the card in the UI
        var cardName2 = "pc_" + suit2 + "_" + number2
//        var cardName2 = "pc_1_12"
        binding!!.ivCard2.setImageDrawable(resources.getDrawable(resources.getIdentifier("@drawable/$cardName2", null, packageName)))

        // Card 3------------------------------------------------------------------------------
        var s3 = (1..4).random()
        var n3 = (1..13).random()
        var suit3 = s3
        var number3 = n3
//        var number3 = 11
//        var suit3 = 1

        // Check for card repeat
        while(suit3 == suit1 && number3 == number1 || suit3 == suit2 && number3 == number2) {
            s3 = (1..4).random()
            n3 = (1..13).random()
            suit3 = s3
            number3 = n3
        }

        // Set the card in the UI
        var cardName3 = "pc_" + suit3 + "_" + number3
//        var cardName3 = "pc_1_11"
        binding!!.ivCard3.setImageDrawable(resources.getDrawable(resources.getIdentifier("@drawable/$cardName3", null, packageName)))

        // Card 4------------------------------------------------------------------------------
        var s4 = (1..4).random()
        var n4 = (1..13).random()
        var suit4 = s4
        var number4 = n4
//        var number4 = 13
//        var suit4 = 1

        // Check for card repeat
        while(suit4 == suit1 && number4 == number1 || suit4 == suit2 && number4 == number2 || suit4 == suit3 && number4 == number3) {
            s4 = (1..4).random()
            n4 = (1..13).random()
            suit4 = s4
            number4 = n4
        }

        // Set the card in the UI
        var cardName4 = "pc_" + suit4 + "_" + number4
//        var cardName4 = "pc_1_13"
        binding!!.ivCard4.setImageDrawable(resources.getDrawable(resources.getIdentifier("@drawable/$cardName4", null, packageName)))

        // Card 5---------------------------------------------------------------------------
        var s5 = (1..4).random()
        var n5 = (1..13).random()
        var suit5 = s5
        var number5 = n5
//        var number5 = 10
//        var suit5 = 1

        // Check for card repeat
        while(suit5 == suit1 && number5 == number1 || suit5 == suit2 && number5 == number2 || suit5 == suit3 && number5 == number3 || suit5 == suit4 && number5 == number4) {
            s5 = (1..4).random()
            n5 = (1..13).random()
            suit5 = s5
            number5 = n5
        }

        // Set the card in the UI
        var cardName5 = "pc_" + suit5 + "_" + number5
//        var cardName5 = "pc_1_10"
        binding!!.ivCard5.setImageDrawable(resources.getDrawable(resources.getIdentifier("@drawable/$cardName5", null, packageName)))

        // Check for win conditions
        var pokerHand = arrayOf(number1, number2, number3, number4, number5)
        pokerHand.sort()
        var high1 = pokerHand[4]
        var high2 = pokerHand[3]
        var high3 = pokerHand[2]
        var high4 = pokerHand[1]
        var high5 = pokerHand[0]
        Log.i("POKERMAINACTIVITY", pokerHand.contentToString())
        pairs = 0
        checkPairs(pokerHand)
        Log.i("POKERMAINACTIVITY", "Number of pairs: $pairs")
        checkWin(suit1, suit2, suit3, suit4, suit5, high1, high2, high3, high4, high5)

        // Pops up a dialog if player wins
        if(higherOrLower) {
            higherOrLower = false
            val builder = AlertDialog.Builder(this)
            // Set alert title
            builder.setTitle("Double or Nothing")
            // Set alert message
            builder.setMessage("Chance to double your winnings?")

            // When "Yes" is selected
            builder.setPositiveButton("Yes") {dialogInterface, which ->
                var bundle = Bundle()
                bundle.putInt("winnings", winnings)

                var goToDoubleNothingActivity = Intent(applicationContext, DoubleNothingActivity::class.java)
                goToDoubleNothingActivity.putExtras(bundle)
                startForResult.launch(goToDoubleNothingActivity)
            }

            // When "No" is selected
            builder.setNegativeButton("No") {dialogInterface, which ->
                Snackbar.make(binding.root, "Continuing Poker Game...", Snackbar.LENGTH_SHORT).show()
            }

            // Creating the AlertDialog
            val alertDialog: AlertDialog = builder.create()
            // Setting other AlertDialog properties
            alertDialog.show()
        }
    }

    fun checkWin(suit1: Int, suit2: Int, suit3: Int, suit4: Int, suit5: Int, high1: Int, high2: Int, high3: Int, high4: Int, high5: Int) {
        // FLUSH WIN CONDITIONS
        if(suit1 == suit2 && suit2 == suit3 && suit3 == suit4 && suit4 == suit5) {
            // Straight Flush
            // Includes possibility of royal straight flush
            if(high1 == (high2 + 1) && high1 == (high3 + 2) && high1 == (high4 + 3) && (high1 == (high5 + 4) || high1 == (high5 + 12))) {
                if(high5 == 1) {
                    Log.i("POKERMAINACTIVITY", "ROYAL FLUSH!!!")
                    higherOrLower = true
                    winnings = winnings + (bet * 250)
//                    binding!!.tvMoney.setText("Money: $money")
                    binding!!.tvWinText.setText("Fortune Doesn't Favor Fools!\nROYAL FLUSH!")
                }

                else {
                    Log.i("POKERMAINACTIVITY", "STRAIGHT FLUSH!!!")
                    higherOrLower = true
                    winnings = winnings + (bet * 25)
//                    binding!!.tvMoney.setText("Money: $money")
                    binding!!.tvWinText.setText("Fortune Doesn't Favor Fools!\nSTRAIGHT FLUSH!")
                }
            }
            // Regular Flush
            else {
                Log.i("POKERMAINACTIVITY", "FLUSH!!!")
                higherOrLower = true
                winnings = winnings + (bet * 4)
//                binding!!.tvMoney.setText("Money: $money")
                binding!!.tvWinText.setText("Fortune Doesn't Favor Fools!\nFLUSH!")
            }
        }
        // Straight
        else if(high1 == (high2 + 1) && high1 == (high3 + 2) && high1 == (high4 + 3) && (high1 == (high5 + 4) || high1 == (high5 + 12))) {
            Log.i("POKERMAINACTIVITY", "STRAIGHT!!!")
            higherOrLower = true
            winnings = winnings + (bet * 3)
//            binding!!.tvMoney.setText("Money: $money")
            binding!!.tvWinText.setText("Fortune Doesn't Favor Fools!\nSTRAIGHT!")
        }

        // One Pair
        if(pairs == 1) {
            Log.i("POKERMAINACTIVITY", "ONE PAIR!!!")
            higherOrLower = true
            winnings = winnings + (bet * 0)
//            binding!!.tvMoney.setText("Money: $money")
            binding!!.tvWinText.setText("Fortune Doesn't Favor Fools!\nONE PAIR!")
        }

        // Two Pair
        if(pairs == 2) {
            Log.i("POKERMAINACTIVITY", "TWO PAIR!!!")
            higherOrLower = true
            winnings = winnings + (bet * 1)
//            binding!!.tvMoney.setText("Money: $money")
            binding!!.tvWinText.setText("Fortune Doesn't Favor Fools!\nTWO PAIR!")
        }

        // Three of a Kind
        if(pairs == 3) {
            Log.i("POKERMAINACTIVITY", "THREE OF A KIND!!!")
            higherOrLower = true
            winnings = winnings + (bet * 1)
//            binding!!.tvMoney.setText("Money: $money")
            binding!!.tvWinText.setText("Fortune Doesn't Favor Fools!\nTHREE OF A KIND!")
        }

        // Full House
        if(pairs == 4) {
            Log.i("POKERMAINACTIVITY", "FULL HOUSE!!!")
            higherOrLower = true
            winnings = winnings + (bet * 10)
//            binding!!.tvMoney.setText("Money: $money")
            binding!!.tvWinText.setText("Fortune Doesn't Favor Fools!\nFULL HOUSE!")
        }

        // Four of a Kind
        if(pairs == 6) {
            Log.i("POKERMAINACTIVITY", "FOUR OF A KIND!!!")
            higherOrLower = true
            winnings = winnings + (bet * 20)
//            binding!!.tvMoney.setText("Money: $money")
            binding!!.tvWinText.setText("Fortune Doesn't Favor Fools!\nFOUR OF A KIND!")
        }

    }

    fun checkPairs(pokerHand: Array<Int>) {
        var startingIndex = 0

        // Check each card in array if it has a pair
        // Can be a double for loop but this is easier to understand eheheh....
        for(i in startingIndex + 1 until pokerHand.size) {
            if(pokerHand[0] == pokerHand[i])
                pairs += 1
        }

        for(i in startingIndex + 2 until pokerHand.size) {
            if(pokerHand[1] == pokerHand[i])
                pairs += 1
        }

        for(i in startingIndex + 3 until pokerHand.size) {
            if(pokerHand[2] == pokerHand[i])
                pairs += 1
        }

        for(i in startingIndex + 4 until pokerHand.size) {
            if(pokerHand[3] == pokerHand[i])
                pairs += 1
        }
    }
    
}