package com.openclassrooms.room.ui.vaccine

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.openclassrooms.room.data.repository.VaccinesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class VaccineViewModel @Inject constructor(
  vaccinesRepository: VaccinesRepository,
  savedStateHandle: SavedStateHandle
) : ViewModel()
{

  val animals =
    vaccinesRepository.getAllVaccines(savedStateHandle.get<Long>(VaccineActivity.ANIMAL_ID) ?: 0)
      .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

}