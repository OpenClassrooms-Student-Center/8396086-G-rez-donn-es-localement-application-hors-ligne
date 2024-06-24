package com.openclassrooms.room.data.entity

data class Animal(
  val id: Long = 0,
  val type: Type = Type.CAT,
  val race: Race = Race.PERSIAN,
  val weight: Double = 0.0,
  val height: Int = 0,
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