package com.openclassrooms.room.data.dao

import com.openclassrooms.room.data.entity.Vaccine
import kotlinx.coroutines.flow.Flow

interface VaccineDao {
  
  fun getAllVaccinesByAnimalId(animalId: Long): Flow<List<Vaccine>>
  
  suspend fun addVaccine(vaccine: Vaccine)
  
  suspend fun deleteVaccine(vaccine: Vaccine)

}