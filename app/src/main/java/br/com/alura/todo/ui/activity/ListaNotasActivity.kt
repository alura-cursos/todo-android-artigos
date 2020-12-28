package br.com.alura.todo.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.todo.asynctask.BuscaNotasTask
import br.com.alura.todo.dao.NotaDao
import br.com.alura.todo.database.AppDatabase
import br.com.alura.todo.databinding.ListaNotasActivityBinding
import br.com.alura.todo.ui.recyclerview.adapter.ListaNotasAdapter

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
        BuscaNotasTask(dao) { notas ->
            adapter.atualiza(notas)
        }.execute()
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