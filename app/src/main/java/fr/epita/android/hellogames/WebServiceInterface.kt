package fr.epita.android.hellogames

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServiceInterface {
    @GET("api/game/details")
    fun GetGame(@Query("game_id") game_id: Int): Call<Game>

}