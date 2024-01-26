package cl.cvega.android.evaluacionfinal

import android.app.Application
import androidx.room.Room
import cl.cvega.android.evaluacionfinal.basedatos.BaseDatos

class Aplicacion : Application() {

    private val db by lazy { Room.databaseBuilder(this, BaseDatos::class.java, "mediciones.db").build() }
    val medicionDao by lazy { db.medicionDao() }
}