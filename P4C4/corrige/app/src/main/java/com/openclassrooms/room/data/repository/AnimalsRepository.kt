package com.openclassrooms.room.data.repository

import com.openclassrooms.room.data.dao.AnimalDao
import com.openclassrooms.room.data.entity.Animal
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AnimalsRepository @Inject constructor(private val animalDao: AnimalDao)
{

  fun getAllAnimals(): Flow<List<Animal>> =
    animalDao.getAllAnimals()

}