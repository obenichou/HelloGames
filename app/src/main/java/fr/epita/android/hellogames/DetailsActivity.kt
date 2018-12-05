package fr.epita.android.hellogames

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView

class DetailsActivity(text: String): AppCompatActivity() {

    val _text :String="defaut"
    init {
        val _text = text

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details)
        val detail: TextView? = findViewById(R.id.data_game!!)
    }
}
