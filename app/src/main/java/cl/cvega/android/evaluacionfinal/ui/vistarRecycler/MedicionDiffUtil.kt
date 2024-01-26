package cl.cvega.android.evaluacionfinal.ui.vistarRecycler

import androidx.recyclerview.widget.DiffUtil
import cl.cvega.android.evaluacionfinal.basedatos.Medicion


//clase DiffUtil para poder actualizar los valores del recycler
class MedicionDiffUtil (
    private val oldList: List<Medicion>,
    private val newList: List<Medicion>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}