package cl.cvega.android.evaluacionfinal.ui.vistarRecycler

import androidx.lifecycle.LiveData
import cl.cvega.android.evaluacionfinal.basedatos.Medicion
import cl.cvega.android.evaluacionfinal.basedatos.MedicionDao

class MedicionRepository(medicionDao: MedicionDao) {
    val mediciones: LiveData<List<Medicion>> = medicionDao.obtenerTodos()

}