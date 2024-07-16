package com.openclassrooms.room.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.openclassrooms.room.data.entity.Vaccine
import kotlinx.coroutines.flow.Flow

@Dao
interface VaccineDao {
  
  @Query("SELECT * FROM vaccine WHERE animalId = :animalId")
  fun getAllVaccinesByAnimalId(animalId: Long): Flow<List<Vaccine>>
  
  @Upsert
  suspend fun addVaccine(vaccine: Vaccine)
  
  @Delete
  suspend fun deleteVaccine(vaccine: Vaccine)

}