package fr.epita.android.hellogames

import android.content.Context
import android.content.Intent
import android.content.Intent.*
import android.graphics.drawable.Drawable
import android.graphics.drawable.DrawableContainer
import android.net.Uri
import kotlinx.android.synthetic.main.activity_hello_games.*

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HelloGames : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_games)
        val baseURL = "https://androidlessonsapi.herokuapp.com/"
        var gameFocus : Int = 0
        val jsonConverter = GsonConverterFactory.create(GsonBuilder().create())
        val retrofitClient = Retrofit.Builder()
            .baseUrl(baseURL)!!
            .addConverterFactory(jsonConverter)
            .build()!!
        val service: WebServiceInterface = retrofitClient.create(WebServiceInterface::class.java)!!
        val callback = object : Callback<Game> {
            override fun onResponse(call: Call<Game>, response: Response<Game>) {
                if (response.code() == 200) {
                    val data:Game = response.body()!!

                    //
                    val myIntent = Intent(this@HelloGames, DetailsActivity::class.java)
                    myIntent.putExtra("id", data.id)
                    myIntent.putExtra("name", data.name)
                    myIntent.putExtra("type",data.type)
                    myIntent.putExtra("players", data.players)
                    myIntent.putExtra("url", data.url)
                    myIntent.putExtra("year", data.year)
                    myIntent.putExtra("description_en", data.description_en)
                    startActivity(myIntent)
                }
                else {
                    Log.d("Response code", response.code().toString())
                    Log.d("Response Body", response.body().toString())
                }
            }

            override fun onFailure(call: Call<Game>, t: Throwable) {
                Log.d("Connect API", "The Application HelloGames failed to contact the api")
                Log.d("Connect API", call.request().toString())
            }
        }
        var chooseGame= ChooseGame()
        game1!!.setImageResource(chooseGame.image1)
        game2!!.setImageResource(chooseGame.image2)
        game3!!.setImageResource(chooseGame.image3)
        game4!!.setImageResource(chooseGame.image4)

        game1.setOnClickListener {
            service.GetGame(chooseGame.game1).enqueue(callback)
            gameFocus = chooseGame.image1
        }

        game2.setOnClickListener {
            service.GetGame(chooseGame.game2).enqueue(callback)
            gameFocus = chooseGame.image2
        }
        game3.setOnClickListener {
            service.GetGame(chooseGame.game3).enqueue(callback)
            gameFocus = chooseGame.image3
        }
        game4.setOnClickListener {
            service.GetGame(chooseGame.game4).enqueue(callback)
            gameFocus = chooseGame.image4
        }
    }

}


