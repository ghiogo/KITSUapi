package com.example.kitsuapi.ui.fragments.manga

import androidx.lifecycle.ViewModel
import com.example.kitsuapi.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(
    private val mangaRepository: MangaRepository
) : ViewModel() {

    fun fetchManga() = mangaRepository.fetchManga() }