package cl.cvega.android.evaluacionfinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.cvega.android.evaluacionfinal.ui.vistarRecycler.MedicionAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.listaCuentas)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = MedicionAdapter(emptyList()) // Inicialmente, la lista está vacía
        recyclerView.adapter = adapter




        findViewById<Button>(R.id.btnIrAAgregar).setOnClickListener {
            startActivity(Intent(this, AgregarMedicionActivity::class.java))
        }

    }
}

