package com.example.muhammadsalman.tictactoe

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.system.exitProcess

class ResultScreen : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_screen)

        recievingValue()
    }
    
    fun startBut(view: View){
        var newintent = Intent(this@ResultScreen,MainActivity::class.java)
        startActivity(newintent)
    }
    fun finishBut(view: View){

        moveTaskToBack(true)
        exitProcess(-1)


        //this.finish()
    }


    override fun onBackPressed() {
        AlertDialog.Builder(this)
                .setMessage("Play Again")
                .setPositiveButton(android.R.string.ok) { dialog, whichButton ->
                    var intent1 = Intent(this@ResultScreen,MainActivity::class.java)
                    startActivity(intent1)
                    super.onBackPressed()
                }
                .setNegativeButton(android.R.string.cancel) { dialog, whichButton ->

                }
                .show()
    }


    fun recievingValue(){

        val intent:Intent = intent
        var value = intent.getIntExtra("String",1)

        var textView :TextView = findViewById(R.id.ResultToShow) as TextView

        if (value==1){

           textView.text = "Player 1 Won"

        }
        else if (value==2){
            textView.text = "Player 2 Won"

        }
        else if (value==-1)
        {
            textView.text = "Withdraw"
        }
    }
}
