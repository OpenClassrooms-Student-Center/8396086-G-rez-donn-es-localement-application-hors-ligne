package com.openclassrooms.room.data.entity

import java.util.Date

data class Vaccine(
  val id: Long = 0,
  val name: String = "",
  val injectionDate: Date = Date(),
  val animalId: Long = 0
)