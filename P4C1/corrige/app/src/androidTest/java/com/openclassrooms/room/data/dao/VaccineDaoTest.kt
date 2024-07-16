package com.openclassrooms.room.data.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import app.cash.turbine.test
import com.openclassrooms.room.data.database.PETiSoinDatabase
import com.openclassrooms.room.data.entity.Animal
import com.openclassrooms.room.data.entity.Race
import com.openclassrooms.room.data.entity.Type
import com.openclassrooms.room.data.entity.Vaccine
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.Date

@RunWith(AndroidJUnit4::class)
class VaccineDaoTest
{

  private lateinit var database: PETiSoinDatabase

  @Before
  fun createDb()
  {
    database = Room
      .inMemoryDatabaseBuilder(
        ApplicationProvider.getApplicationContext(),
        PETiSoinDatabase::class.java
      )
      .allowMainThreadQueries()
      .build()
  }

  @After
  fun closeDb()
  {
    database.close()
  }

}