package com.openclassrooms.room.data.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import app.cash.turbine.test
import com.openclassrooms.room.data.database.PETiSoinDatabase
import com.openclassrooms.room.data.entity.Animal
import com.openclassrooms.room.data.entity.Race
import com.openclassrooms.room.data.entity.Type
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AnimalDaoTest
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
  fun testShouldInsertAnimalIntoDatabaseSuccessfully() = runTest {
    val animal = Animal(
      id = 1,
      type = Type.CAT,
      race = Race.PERSIAN,
      weight = 12.0,
      height = 120,
      color = "black"
    )

    database.animalDao().addAnimal(animal)

    val insertedAnimal = database.animalDao().getAnimalById(1)

    assertEquals(animal, insertedAnimal)
  }

  @Test
  fun testShouldUpdateAnimalIntoDatabaseSuccessfully() = runTest {
    var animal = Animal(
      id = 1,
      type = Type.CAT,
      race = Race.PERSIAN,
      weight = 12.0,
      height = 120,
      color = "black"
    )

    database.animalDao().addAnimal(animal)

    animal = animal.copy(race = Race.SIEMESE)

    database.animalDao().addAnimal(animal)

    val updatedAnimal = database.animalDao().getAnimalById(1)

    assertEquals(animal, updatedAnimal)
  }

  @Test
  fun testShouldDeleteAnimalFromDatabaseSuccessfully() = runTest {
    val animal = Animal(
      id = 1,
      type = Type.CAT,
      race = Race.PERSIAN,
      weight = 12.0,
      height = 120,
      color = "black"
    )

    database.animalDao().addAnimal(animal)

    database.animalDao().deleteAnimal(animal)

    val deletedAnimal = database.animalDao().getAnimalById(1)

    assertNull(deletedAnimal)
  }

  @Test
  fun testGetAllAnimalsShouldReturnEmptyList() = runTest {
    database.animalDao().getAllAnimals().test {
      val animals = awaitItem()
      assertTrue(animals.isEmpty())
      cancel()
    }
  }

  @Test
  fun testGetAllAnimalsShouldReturnNonEmptyList() = runTest {
    val animals = listOf(
      Animal(
        id = 1,
        type = Type.CAT,
        race = Race.PERSIAN,
        weight = 1.8,
        height = 10,
        color = "grey"
      ),
      Animal(
        id = 2,
        type = Type.DOG,
        race = Race.GOLDEN_RETRIEVER,
        weight = 10.8,
        height = 100,
        color = "black"
      )
    )

    animals.forEach {
      database.animalDao().addAnimal(it)
    }

    database.animalDao().getAllAnimals().test {
      val results = awaitItem()
      assertEquals(animals.size, results.size)
      cancel()
    }
  }


}