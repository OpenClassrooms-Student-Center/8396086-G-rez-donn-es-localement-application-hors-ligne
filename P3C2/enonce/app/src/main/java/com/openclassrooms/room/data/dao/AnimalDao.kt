package com.openclassrooms.room.data.dao

import com.openclassrooms.room.data.entity.Animal
import kotlinx.coroutines.flow.Flow

interface AnimalDao {

  suspend fun getAnimalById(id: Long): Animal
  
  fun getAllAnimals(): Flow<List<Animal>>
  
  suspend fun addAnimal(animal: Animal)
  
  suspend fun deleteAnimal(animal: Animal)

}