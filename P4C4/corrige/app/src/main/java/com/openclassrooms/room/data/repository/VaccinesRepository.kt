package com.openclassrooms.room.data.repository

import com.openclassrooms.room.data.dao.VaccineDao
import com.openclassrooms.room.data.entity.Vaccine
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VaccinesRepository @Inject constructor(private val vaccineDao: VaccineDao)
{

  fun getAllVaccines(animalId: Long): Flow<List<Vaccine>> =
    vaccineDao.getAllVaccinesByAnimalId(animalId)

}