package edu.itesm.gastos.mvvm
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import edu.itesm.gastos.dao.GastoDao
import edu.itesm.gastos.database.GastosDB
import edu.itesm.gastos.entities.Gasto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.random.Random


class MainActivityViewModel : ViewModel(){
     var liveData: MutableLiveData<List<Gasto>>
     var liveData1: MutableLiveData<Double>

    init {
        liveData = MutableLiveData()
        liveData1 = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<Gasto>>{
        return liveData
    }

    fun getLiveData1Observer(): MutableLiveData<Double>
    {
        return liveData1
    }

    fun getGastos(gastoDao: GastoDao){
        CoroutineScope(Dispatchers.IO).launch{
            for(i in 0..5){
                gastoDao.insertGasto(Gasto(0,"Gasto ${i}", Random.nextDouble() * 100))
            }
            liveData.postValue(gastoDao.getAllGastos())
        }
    }

    fun insetaGastos(gastoDao: GastoDao, gasto: Gasto){
        CoroutineScope(Dispatchers.IO).launch{
            gastoDao.insertGasto(Gasto(0, gasto.description,  gasto.amount))
            liveData.postValue(gastoDao.getAllGastos())
        }
    }

    fun sumaGastos(gastoDao: GastoDao){
        CoroutineScope(Dispatchers.IO).launch {
            liveData1.postValue((gastoDao.sumAllGastos())).toString()
        }
    }
}