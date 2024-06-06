package com.openclassrooms.room.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.openclassrooms.room.data.entity.Animal
import kotlinx.coroutines.flow.Flow

@Dao
interface AnimalDao {

  @Query("SELECT * FROM animal WHERE id = :id")
  suspend fun getAnimalById(id: Int): Animal
  
  @Query("SELECT * FROM animal")
  fun getAllAnimals(): Flow<List<Animal>>
  
  @Upsert
  suspend fun addAnimal(animal: Animal)
  
  @Delete
  suspend fun deleteAnimal(animal: Animal)

}