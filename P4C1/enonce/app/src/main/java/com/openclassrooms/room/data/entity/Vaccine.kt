package com.openclassrooms.room.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
  tableName = "vaccine",
  foreignKeys = [
    androidx.room.ForeignKey(
      entity = Animal::class,
      parentColumns = ["id"],
      childColumns = ["animalId"]
    )
  ]
)
data class Vaccine(
  @PrimaryKey(autoGenerate = true)
  val id: Long = 0,

  @ColumnInfo(name = "name")
  val name: String = "",

  @ColumnInfo(name = "injectionDate")
  val injectionDate: Date = Date(),

  @ColumnInfo(name = "animalId")
  val animalId: Long = 0
)