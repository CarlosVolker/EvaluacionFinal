package cl.cvega.android.evaluacionfinal.ui.vistarRecycler

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.cvega.android.evaluacionfinal.R
import cl.cvega.android.evaluacionfinal.basedatos.Medicion

class MedicionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val tipoMedicionTextView: TextView = itemView.findViewById(R.id.tvServicio)
    val valorMedicionTextView: TextView = itemView.findViewById(R.id.tvMedidor)
    val fechaMedicionTextView: TextView = itemView.findViewById(R.id.tvFecha)
    val iconoServicioImage: ImageView = itemView.findViewById(R.id.ivIcono)

    fun bind(medicion: Medicion){
        tipoMedicionTextView.text = medicion.tipoMedicion
        valorMedicionTextView.text = medicion.valorMedicion
        fechaMedicionTextView.text = medicion.fechaMedicion
        //iconoServicioImage.
    }
}