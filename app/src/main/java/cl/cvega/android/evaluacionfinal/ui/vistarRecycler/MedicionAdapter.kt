package cl.cvega.android.evaluacionfinal.ui.vistarRecycler

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import cl.cvega.android.evaluacionfinal.R
import cl.cvega.android.evaluacionfinal.basedatos.Medicion

class MedicionAdapter(var mediciones: List<Medicion>) : RecyclerView.Adapter<MedicionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicionViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lista, parent, false)
        return MedicionViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MedicionViewHolder, position: Int) {
        val medicion = mediciones[position]

        //obtenemos icono basado en el tipo de medicion
        val iconoServicio: Drawable? = obtenerIconoPorTipo(holder.itemView.context, medicion.tipoMedicion)

        holder.iconoServicioImage.setImageDrawable(iconoServicio)
        holder.bind(medicion)
    }

    //metodo que define el icono a utilizar dependiendo de la seleccion que realicemos
    private fun obtenerIconoPorTipo(context: Context, tipoMedicion: String): Drawable? {
        return when (tipoMedicion) {
            "LUZ" -> ContextCompat.getDrawable(context, R.drawable.ic_luz)
            "AGUA" -> ContextCompat.getDrawable(context, R.drawable.ic_water)
            "GAS" -> ContextCompat.getDrawable(context, R.drawable.ic_gas)
            else -> null
        }
    }


    override fun getItemCount(): Int = mediciones.size

}