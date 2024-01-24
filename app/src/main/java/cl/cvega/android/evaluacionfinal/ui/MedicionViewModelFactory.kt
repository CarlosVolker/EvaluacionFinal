package cl.cvega.android.evaluacionfinal.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cl.cvega.android.evaluacionfinal.ui.vistarRecycler.MedicionRepository

class MedicionViewModelFactory (private val repository: MedicionRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListaMedicionesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ListaMedicionesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}