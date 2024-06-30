package com.openclassrooms.room.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.openclassrooms.room.data.converter.Converters
import com.openclassrooms.room.data.dao.AnimalDao
import com.openclassrooms.room.data.dao.VaccineDao
import com.openclassrooms.room.data.entity.Animal
import com.openclassrooms.room.data.entity.Vaccine

@Database(entities = [Animal::class, Vaccine::class], version = 2, exportSchema = true)
@TypeConverters(Converters::class)
abstract class PETiSoinDatabase : RoomDatabase() {
  
  abstract fun animalDao(): AnimalDao
  
  abstract fun vaccineDao(): VaccineDao

}