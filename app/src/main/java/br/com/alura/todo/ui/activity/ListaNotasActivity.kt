package br.com.alura.todo.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import br.com.alura.todo.database.AppDatabase
import br.com.alura.todo.databinding.ListaNotasActivityBinding
import br.com.alura.todo.ui.recyclerview.adapter.ListaNotasAdapter
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListaNotasActivity : AppCompatActivity() {

    private val adapter by lazy {
        ListaNotasAdapter(this)
    }
    private val binding by lazy {
        ListaNotasActivityBinding.inflate(layoutInflater)
    }
    private val dao by lazy {
        AppDatabase
            .getInstance(this)
            .notaDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recyclerView = binding.listaNotasActivityRecyclerview
        recyclerView.adapter = adapter
        configuraFab()
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch(IO) {
            val notas = dao.buscaTodas()
            withContext(Main){
                adapter.atualiza(notas)
            }
        }
    }

    private fun configuraFab() {
        val fab = binding.listaNotasActivityFab
        fab.setOnClickListener {
            Intent(this, FormularioNotasActivity::class.java)
                .run {
                    startActivity(this)
                }
        }
    }

}