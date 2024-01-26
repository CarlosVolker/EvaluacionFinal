package cl.cvega.android.evaluacionfinal

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cl.cvega.android.evaluacionfinal.basedatos.Medicion
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

class AgregarMedicionActivity : AppCompatActivity(){

    //Variables
    private lateinit var etValorMedicion: EditText
    private lateinit var etFechaMedicion: EditText
    private lateinit var radioGroupServicio: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro_medidor)

        //Vinculamos las vistas a las variables
        etValorMedicion = findViewById(R.id.etMedidor)
        etFechaMedicion = findViewById(R.id.etFecha)
        radioGroupServicio = findViewById(R.id.radioGroup)

        //Accion al presionar BOTON
        findViewById<Button>(R.id.btnAgregar).setOnClickListener {
            guardarMedicionEnBaseDeDatos()
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun guardarMedicionEnBaseDeDatos() {
        val tipoMedicion = obtenerTipoServicioSeleccionado()
        val valorMedicion = etValorMedicion.text.toString()
        val fechaMedicion = etFechaMedicion.text.toString()


        //Verificamos que los campos no esten vacios
        if (valorMedicion.isNotEmpty() && fechaMedicion.isNotEmpty()){

        //fecha en un formato especifico
            val fechaLocalData: LocalDate? =
            try{
                LocalDate.parse(fechaMedicion, DateTimeFormatter.ofPattern("dd-MM-yyyy"))
            } catch (e: DateTimeParseException){
                try {
                    LocalDate.parse(fechaMedicion, DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                } catch (e: DateTimeParseException){
                    Toast.makeText(this, getString(R.string.formato_fecha_erroneo), Toast.LENGTH_SHORT).show()
                    return
                }
            }

            val aplicacion = application as Aplicacion
            val medicionDao = aplicacion.medicionDao

            //Creamos variable con los valores obtenidos del formulario, usando la estructura de la clase Medicion
            val medicion = Medicion(
                tipoMedicion = tipoMedicion,
                valorMedicion = valorMedicion,
                fechaMedicion = fechaLocalData,
            )
            // Insertar la medición en la base de datos
            GlobalScope.launch (Dispatchers.IO){
                medicionDao.insertar(medicion)
            }
            finish()
        } else {
            // Mostrar un mensaje de error si hay campos vacíos
            Toast.makeText(this, getString(R.string.mensaje_texto_obligatorio), Toast.LENGTH_SHORT).show()
        }
    }

    //Obtenemos el tipo de servicio segun la opcion que seleccionemos
    private fun obtenerTipoServicioSeleccionado(): String{
        return when (radioGroupServicio.checkedRadioButtonId){
            R.id.rbAgua -> "AGUA"
            R.id.rbLuz -> "LUZ"
            R.id.rbGas  -> "GAS"
            else    -> ""
        }
    }
}