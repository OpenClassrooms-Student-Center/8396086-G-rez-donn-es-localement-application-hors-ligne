package com.openclassrooms.room.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "animal")
data class Animal(
  @PrimaryKey(autoGenerate = true)
  val id: Long = 0,

  @ColumnInfo(name = "type")
  val type: Type = Type.CAT,

  @ColumnInfo(name = "race")
  val race: Race = Race.PERSIAN,

  @ColumnInfo(name = "weight")
  val weight: Double = 0.0,

  @ColumnInfo(name = "height")
  val height: Int = 0,

  @ColumnInfo(name = "color")
  val color: String = ""
)

enum class Type {
  CAT, DOG, RABBIT
}

enum class Race {
  PERSIAN, SIEMESE,
  GERMAN_SHEPHERD, GOLDEN_RETRIEVER,
  DWARF_RABBIT, FLEMISH_RABBIT
}