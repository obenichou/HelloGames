package fr.epita.android.hellogames

import android.media.Image
import android.util.Log
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class ChooseGame {
    var game1: Int = 0
    var image1: Int = 0
    var game2: Int = 0
    var image2: Int = 0
    var game3: Int = 0
    var image3: Int = 0
    var game4: Int = 0
    var image4: Int = 0
    private val random = Random()
    var found: Int = 0

        init {
            while (found < 4) {
                val i: Int = random.nextInt(10) + 1
                when (found) {
                    0 -> {
                        game1 = i
                        image1 = getImage(i)
                        found++
                    }
                    1 -> if (game1 != 0 && game1 != i) {
                        game2 = i
                        image2 = getImage(i)
                        found++
                    }
                    2 -> if (game1 != 0 && game1 != i && game2 != 0 && game2 != i) {
                        game3=i
                        image3 = getImage(i)
                        found++
                    }
                    3 -> if (game1 != 0 && game1 != i && game2 != 0 && game2 != i && game3 != 0 && game3 != i) {
                        game4=i
                        image4 = getImage(i)
                        found++
                    }
                }
            }
        }
 fun getImage(i: Int) : Int {
     when (i) {
         1 -> return R.drawable.tictactoe
         2 -> return R.drawable.hangman
         3 -> return R.drawable.sudoku
         4 -> return R.drawable.battleship
         5 -> return R.drawable.minesweeper
         6 -> return R.drawable.gameoflife
         7 -> return R.drawable.memory
         8 -> return R.drawable.simon
         9 -> return R.drawable.slidingpuzzle
         10 -> return R.drawable.mastermind
     }
     return R.drawable.tictactoe
 }
}



