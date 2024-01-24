package cl.cvega.android.evaluacionfinal.basedatos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MedicionDao {

    @Query("SELECT * FROM Medicion ORDER BY fechaMedicion DESC")
    fun obtenerTodos(): LiveData<List<Medicion>>

    @Insert
    suspend fun insertar(medicion : Medicion)

    @Update
    suspend fun modificar(medicion : Medicion)

}