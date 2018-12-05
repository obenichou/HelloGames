package fr.epita.android.hellogames

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.details.*

class DetailsActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details)

        var id : Int = intent.getIntExtra("id",1)
        var year : Int = intent.getIntExtra("year",1999)
        var players : Int = intent.getIntExtra("players", 2)
        val name : String = intent.getStringExtra("name")
        val description_en : String = intent.getStringExtra("description_en")
        val type : String =  intent.getStringExtra("type")
        val url : String = intent.getStringExtra("url")
        val data_game: TextView? = findViewById(R.id.data_game!!)
        val details_game: TextView? = findViewById(R.id.details_game!!)
        val know_more: Button?= findViewById(R.id.know_more)
        data_game!!.setText("Name: " + name
                + "\nType: " + type
                + "\nNb Player: " + players.toString()
                + "\nYear: " + year.toString())
        details_game!!.setText(description_en)

        focusgame!!.setImageResource(ChooseGame().getImage(id))
        know_more!!.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(browserIntent)
        }

    }
}
