package cl.cvega.android.evaluacionfinal.ui.vistarRecycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.cvega.android.evaluacionfinal.R
import cl.cvega.android.evaluacionfinal.basedatos.Medicion

class MedicionAdapter(private val mediciones: List<Medicion>) : RecyclerView.Adapter<MedicionViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicionViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lista, parent, false)
        return MedicionViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MedicionViewHolder, position: Int) {
        val medicion = mediciones[position]
        holder.bind(medicion)
    }

    override fun getItemCount(): Int = mediciones.size

}