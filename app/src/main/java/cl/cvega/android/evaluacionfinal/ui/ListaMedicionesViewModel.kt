package cl.cvega.android.evaluacionfinal.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.cvega.android.evaluacionfinal.basedatos.Medicion
import cl.cvega.android.evaluacionfinal.ui.vistarRecycler.MedicionRepository
import kotlinx.coroutines.launch

class ListaMedicionesViewModel (private val repository: MedicionRepository) : ViewModel(){

    val mediciones: LiveData<List<Medicion>> = repository.mediciones

    fun insert (medicion: Medicion) = viewModelScope.launch {
        repository.insert(medicion)
    }

}