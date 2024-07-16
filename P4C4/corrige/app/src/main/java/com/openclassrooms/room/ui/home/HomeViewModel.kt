package com.openclassrooms.room.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.openclassrooms.room.data.repository.AnimalsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(animalsRepository: AnimalsRepository) : ViewModel()
{

  val animals = animalsRepository.getAllAnimals()
    .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

}