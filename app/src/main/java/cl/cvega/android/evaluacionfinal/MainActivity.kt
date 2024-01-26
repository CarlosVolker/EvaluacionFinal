package cl.cvega.android.evaluacionfinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.cvega.android.evaluacionfinal.ui.ListaMedicionesViewModel
import cl.cvega.android.evaluacionfinal.ui.MedicionViewModelFactory
import cl.cvega.android.evaluacionfinal.ui.vistarRecycler.MedicionAdapter
import cl.cvega.android.evaluacionfinal.ui.vistarRecycler.MedicionDiffUtil
import cl.cvega.android.evaluacionfinal.ui.vistarRecycler.MedicionRepository

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ListaMedicionesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val medicionDao = (applicationContext as Aplicacion).medicionDao
        val repository = MedicionRepository(medicionDao)
        val viewModelFactory = MedicionViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ListaMedicionesViewModel::class.java)

        val recyclerView = findViewById<RecyclerView>(R.id.listaCuentas)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = MedicionAdapter(emptyList())
        recyclerView.adapter = adapter

        viewModel.mediciones.observe(this) {mediciones ->
            val oldList = adapter.mediciones
            adapter.mediciones = mediciones
            val diffResult = DiffUtil.calculateDiff(MedicionDiffUtil(oldList, mediciones))
            diffResult.dispatchUpdatesTo(adapter)
        }

        findViewById<Button>(R.id.btnIrAAgregar).setOnClickListener {
            startActivity(Intent(this, AgregarMedicionActivity::class.java))
        }

    }
}

