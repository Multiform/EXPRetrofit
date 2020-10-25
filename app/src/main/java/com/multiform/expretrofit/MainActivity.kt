package com.multiform.expretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.multiform.expretrofit.network.MovieApiClient
import com.multiform.expretrofit.network.models.MoviesResponse
import com.multiform.expretrofit.utils.API_KEY
import com.multiform.expretrofit.utils.APP_ACTIVITY
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        APP_ACTIVITY = this

        val call = MovieApiClient.apiClient.getTopRatedMovies(API_KEY, "ru")

        call.enqueue(object : Callback<MoviesResponse> {
            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                Log.e(TAG, t.toString())
            }

            override fun onResponse(
                call: Call<MoviesResponse>,
                response: Response<MoviesResponse>
            ) {
                val movies = response.body()!!.results
                movies.forEach { Log.d(TAG, it.title.orEmpty()) }
            }
        })
    }
}