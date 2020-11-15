package com.multiform.expretrofit.ui.screens

import androidx.fragment.app.Fragment
import com.multiform.expretrofit.R
import com.multiform.expretrofit.databinding.FragmentRuMoviesBinding
import com.multiform.expretrofit.utils.viewBinding

class RuMoviesFragment : Fragment(R.layout.fragment_ru_movies) {

    private val binding by viewBinding { FragmentRuMoviesBinding.bind(it) }
}