package cl.cvega.android.evaluacionfinal.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import cl.cvega.android.evaluacionfinal.basedatos.Medicion
import cl.cvega.android.evaluacionfinal.ui.vistarRecycler.MedicionRepository

class ListaMedicionesViewModel (repository: MedicionRepository) : ViewModel(){

    val mediciones: LiveData<List<Medicion>> = repository.mediciones
}