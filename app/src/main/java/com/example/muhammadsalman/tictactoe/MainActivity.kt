package com.example.muhammadsalman.tictactoe

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    var winner = -1
    var btnPressCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    override fun onPause() {
        finish()
        super.onPause()
    }



        fun buClick(view:View){

        var buSelected = view as Button
        var cellID = 0
        when(buSelected.id) {

            R.id.bu1-> cellID=1
            R.id.bu2-> cellID=2
            R.id.bu3-> cellID=3
            R.id.bu4-> cellID=4
            R.id.bu5-> cellID=5
            R.id.bu6-> cellID=6
            R.id.bu7-> cellID=7
            R.id.bu8-> cellID=8
            R.id.bu9-> cellID=9


        }
        if (ActivePlayer==1){
            buSelected.text="X"
            buSelected.setBackgroundColor(Color.GREEN)
            player1.add(cellID)
            ActivePlayer = 2

        }
        else{
            buSelected.text="0"
            buSelected.setBackgroundColor(Color.BLUE)
            player2.add(cellID)
            ActivePlayer = 1
        }

            PlayGame(cellID, buSelected)


    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var ActivePlayer = 1

    fun PlayGame(cellID:Int, buSelected:Button){
        buSelected.isEnabled=false

            checkWiner()


    }
    fun moveToSecondActivity(){

        var intent = Intent(this@MainActivity, ResultScreen::class.java)
        intent.putExtra("String",winner )
        startActivity(intent)
    }

    fun checkWiner(){

        btnPressCount++
        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {

            winner = 1
            moveToSecondActivity()
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {

            winner = 2
            moveToSecondActivity()
        }


        //row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {

            winner = 1
            moveToSecondActivity()
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {

            winner = 2
            moveToSecondActivity()
        }



        //row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {

            winner = 1
            moveToSecondActivity()
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {

            winner = 2
            moveToSecondActivity()
        }



        //col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {

            winner = 1
            moveToSecondActivity()
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {

            winner = 2
            moveToSecondActivity()
        }



        //col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {

            winner = 1
            moveToSecondActivity()
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {

            winner = 2
            moveToSecondActivity()
        }



        //col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {

            winner = 1
            moveToSecondActivity()

        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {

            winner = 2
            moveToSecondActivity()
        }



        //for col and row left to right 1 5 9
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {

            winner = 1
            moveToSecondActivity()
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {

            winner = 2
            moveToSecondActivity()
        }



        //for col and row right to left 3 5 7
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {

            winner = 1
            moveToSecondActivity()
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {

            winner = 2
            moveToSecondActivity()
        }

        if (btnPressCount==9){
            moveToSecondActivity()
        }


    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
                .setMessage("Quit ?")
                .setPositiveButton(android.R.string.ok) { dialog, whichButton ->
                    moveTaskToBack(true)
                    exitProcess(-1)
                }
                .setNegativeButton(android.R.string.cancel) { dialog, whichButton ->

                }
                .show()
    }
}
