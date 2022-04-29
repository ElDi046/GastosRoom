package edu.itesm.gastos.dao

import androidx.room.*
import edu.itesm.gastos.entities.Gasto

@Dao
interface GastoDao{
      @Query("SELECT * FROM Gasto")
      suspend fun getAllGastos():List<Gasto>

      @Query("select sum(amount) from Gasto")
      suspend fun sumAllGastos(): Double

      @Insert
      suspend fun insertGasto(gasto: Gasto)
}