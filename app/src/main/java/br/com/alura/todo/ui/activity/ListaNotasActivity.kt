package br.com.alura.todo.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.todo.R
import br.com.alura.todo.dao.NotaDao
import br.com.alura.todo.model.Nota
import br.com.alura.todo.ui.fragment.FormularioNotaFragment
import br.com.alura.todo.ui.recyclerview.adapter.ListaNotasAdapter
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class ListaNotasActivity : AppCompatActivity(R.layout.lista_notas_activity) {

    private val adapter by lazy {
        ListaNotasAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recyclerView = findViewById<RecyclerView>(R.id.lista_notas_activity_recyclerview)
        recyclerView.adapter = adapter
        configuraFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(NotaDao().notas)
    }

    private fun configuraFab() {
        val fab = findViewById<ExtendedFloatingActionButton>(R.id.lista_notas_activity_fab)
        fab.setOnClickListener {
            Intent(this, FormularioNotasActivity::class.java)
                .run {
                    startActivity(this)
                }
        }
    }

}