package cl.cvega.android.evaluacionfinal

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import cl.cvega.android.evaluacionfinal.basedatos.Medicion
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AgregarMedicionActivity : AppCompatActivity(){

    private lateinit var etValorMedicion: EditText
    private lateinit var etFechaMedicion: EditText
    private lateinit var radioGroupServicio: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro_medidor)

        //Vinculamos las vistas
        etValorMedicion = findViewById(R.id.etMedidor)
        etFechaMedicion = findViewById(R.id.etFecha)
        radioGroupServicio = findViewById(R.id.radioGroup)

        //Al Presionar BOTON
        findViewById<Button>(R.id.btnAgregar).setOnClickListener {
            guardarMedicionEnBaseDeDatos()
        }
    }

    fun guardarMedicionEnBaseDeDatos() {
        val tipoMedicion = obtenerTipoServicioSeleccionado()
        val valorMedicion = etValorMedicion.text.toString()
        val fechaMedicion = etFechaMedicion.text.toString()

        //Verificamos que los campos no esten vacios
        if (tipoMedicion != null && valorMedicion.isNotEmpty() && fechaMedicion.isNotEmpty()){
            //val iconoServicio = obtenerNombreRecursoIcono(tipoMedicion)
            val aplicacion = application as Aplicacion
            val medicionDao = aplicacion.medicionDao

            val medicion = Medicion(
                tipoMedicion = tipoMedicion,
                valorMedicion = valorMedicion,
                fechaMedicion = fechaMedicion,
                //iconoMedicion = iconoServicio
            )

            // Insertar la medición en la base de datos
            GlobalScope.launch (Dispatchers.IO){
                medicionDao.insertar(medicion)
            }
            finish()
        } else {
            // Mostrar un mensaje de error si hay campos vacíos
            Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
        }
    }


    //Obtenemos el tipo de servicio segun la opcion que seleccionemos
    private fun obtenerTipoServicioSeleccionado(): String{
        val valorSeleccionado = radioGroupServicio?.checkedRadioButtonId
        return when (valorSeleccionado){
            R.id.rbAgua -> "AGUA"
            R.id.rbLuz -> "LUZ"
            R.id.rbGas  -> "GAS"
            else    -> ""
        }
    }
}