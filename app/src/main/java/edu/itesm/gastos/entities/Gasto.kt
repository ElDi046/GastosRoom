package edu.itesm.gastos.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Gasto(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val description: String,
    val amount: Double
  ): Serializable



