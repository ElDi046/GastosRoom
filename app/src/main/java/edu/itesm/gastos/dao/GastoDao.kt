package edu.itesm.gastos.dao

import androidx.room.*
import edu.itesm.gastos.entities.Gasto

@Dao
interface GastoDao{
      @Query("SELECT * FROM Gasto")
      suspend fun getAllGastos():List<Gasto>

      //"select sum(amount) from Gasto" <--- Saca la sumatoria de los valores de la columna

      @Insert
      suspend fun insertGasto(gasto: Gasto)
}