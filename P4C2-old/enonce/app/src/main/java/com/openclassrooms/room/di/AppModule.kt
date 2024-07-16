package com.openclassrooms.room.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.openclassrooms.room.data.dao.AnimalDao
import com.openclassrooms.room.data.database.PETiSoinDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule
{

  @Provides
  @Singleton
  fun provideDatabase(@ApplicationContext context: Context): PETiSoinDatabase
  {
    return Room
      .databaseBuilder(context, PETiSoinDatabase::class.java, "PETiSoinDatabase")
      .addCallback(object : RoomDatabase.Callback()
      {
        override fun onCreate(db: SupportSQLiteDatabase)
        {
          super.onCreate(db)

          db.execSQL("INSERT INTO Animal VALUES (1, 'CAT', 'PERSIAN', 5.2, 2, 'black')")
          db.execSQL("INSERT INTO Animal VALUES (2, 'DOG', 'GERMAN_SHEPHERD', 7.4,  10, 'grey')")
          db.execSQL("INSERT INTO Animal VALUES (3, 'RABBIT', 'FLEMISH_RABBIT', 10.5, 15, 'brown')")

          db.execSQL("INSERT INTO Vaccine VALUES (1, 'Vaccin 1', 1720958660, 1)")
          db.execSQL("INSERT INTO Vaccine VALUES (2, 'Vaccin 2', 1715688260, 1)")
          db.execSQL("INSERT INTO Vaccine VALUES (3, 'Vaccin 3', 1684065860, 2)")
        }
      })
      .build()
  }

  @Provides
  fun provideAnimalDao(database: PETiSoinDatabase): AnimalDao =
    database.animalDao()

}