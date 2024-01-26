package cl.cvega.android.evaluacionfinal.basedatos

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
class Medicion (
    @PrimaryKey(autoGenerate = true) var id:Long? = null,
    var tipoMedicion : String,
    var valorMedicion : String,
    var fechaMedicion : LocalDate?
)