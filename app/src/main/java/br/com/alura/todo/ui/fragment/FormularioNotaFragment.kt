package br.com.alura.todo.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import br.com.alura.todo.R
import br.com.alura.todo.dao.NotaDao
import br.com.alura.todo.model.Nota

class FormularioNotaFragment : Fragment(R.layout.formulario_nota_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val botao = view.findViewById<Button>(R.id.formulario_nota_botao_salvar_fragment)
        botao.setOnClickListener {
            salvaNota(view)
        }
    }

    private fun salvaNota(view: View) {
        val campoTitulo = view.findViewById<TextView>(R.id.formulario_nota_titulo_fragment)
        val titulo = campoTitulo.text.toString()
        val campoDescricao = view.findViewById<TextView>(R.id.formulario_nota_descricao_fragment)
        val descricao = campoDescricao.text.toString()
        val nota = Nota(titulo, descricao)
        NotaDao().salva(nota)
        activity?.onBackPressed()
    }

}