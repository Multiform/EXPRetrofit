package com.multiform.expretrofit.ui.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.fragment.app.Fragment
import com.multiform.expretrofit.MainActivity
import com.multiform.expretrofit.R
import com.multiform.expretrofit.databinding.FragmentMoviesBinding
import com.multiform.expretrofit.network.MovieApiClient
import com.multiform.expretrofit.utils.API_KEY
import com.multiform.expretrofit.utils.viewBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MoviesFragment : Fragment(R.layout.fragment_movies) {

    private val binding by viewBinding { FragmentMoviesBinding.bind(it) }

    @SuppressLint("CheckResult")
    override fun onResume() {
        super.onResume()

        binding.rcViewMain.hasFixedSize()

        val topRatedMovies = MovieApiClient.apiClient.getTopRatedMovies(API_KEY, "ru")

        topRatedMovies.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    val movies = it.results
                    binding.rcViewMain.adapter = GroupAdapter<GroupieViewHolder>().apply { addAll(movies) }
                },
                {
                    Log.e(MainActivity::class.java.simpleName, it.toString())
                }
            )
    }
}