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

  @Test
  fun testShouldInsertVaccineIntoDatabaseSuccessfully() = runTest {
    //We first insert an animal
    val animal = Animal(
      id = 1,
      type = Type.CAT,
      race = Race.PERSIAN,
      weight = 12.0,
      height = 120,
      color = "black"
    )

    database.animalDao().addAnimal(animal)

    //then a vaccine
    val vaccine = Vaccine(
      id = 1,
      name = "leucose",
      injectionDate = Date(),
      animalId = 1
    )

    database.vaccineDao().addVaccine(vaccine)

    database.vaccineDao().getAllVaccinesByAnimalId(1).test {
      val insertedVaccine = awaitItem()
      assertEquals(1, insertedVaccine.size)
      assertEquals(vaccine, insertedVaccine[0])
      cancel()
    }
  }

  @Test
  fun testShouldUpdateVaccineIntoDatabaseSuccessfully() = runTest {
    //We first insert an animal
    val animal = Animal(
      id = 1,
      type = Type.CAT,
      race = Race.PERSIAN,
      weight = 12.0,
      height = 120,
      color = "black"
    )

    database.animalDao().addAnimal(animal)

    //then a vaccine
    var vaccine = Vaccine(
      id = 1,
      name = "leucose",
      injectionDate = Date(),
      animalId = 1
    )

    database.vaccineDao().addVaccine(vaccine)

    //Update the date with Monday 8 January 2024 21:26:38
    vaccine = vaccine.copy(injectionDate = Date(1704749198 * 1000L))

    database.vaccineDao().addVaccine(vaccine)

    database.vaccineDao().getAllVaccinesByAnimalId(1).test {
      val updatedVaccine = awaitItem()
      assertEquals(1, updatedVaccine.size)
      assertEquals(vaccine, updatedVaccine[0])
      cancel()
    }
  }

  @Test
  fun testShouldDeleteAnimalFromDatabaseSuccessfully() = runTest {
    //We first insert an animal
    val animal = Animal(
      id = 1,
      type = Type.CAT,
      race = Race.PERSIAN,
      weight = 12.0,
      height = 120,
      color = "black"
    )

    database.animalDao().addAnimal(animal)

    //then a vaccine
    val vaccine = Vaccine(
      id = 1,
      name = "leucose",
      injectionDate = Date(),
      animalId = 1
    )

    database.vaccineDao().addVaccine(vaccine)

    database.vaccineDao().deleteVaccine(vaccine)

    database.vaccineDao().getAllVaccinesByAnimalId(1).test {
      val deletedVaccine = awaitItem()
      assertTrue(deletedVaccine.isEmpty())
      cancel()
    }
  }

}