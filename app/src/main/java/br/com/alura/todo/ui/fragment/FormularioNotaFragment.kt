package br.com.alura.todo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.alura.todo.asynctask.SalvaNotaTask
import br.com.alura.todo.dao.NotaDao
import br.com.alura.todo.database.AppDatabase
import br.com.alura.todo.databinding.FormularioNotaFragmentBinding
import br.com.alura.todo.model.Nota

class FormularioNotaFragment : Fragment() {

    private var _binding: FormularioNotaFragmentBinding? = null
    private val binding: FormularioNotaFragmentBinding get() = _binding!!
    private val dao by lazy {
        AppDatabase
            .getInstance(requireContext())
            .notaDao()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FormularioNotaFragmentBinding
            .inflate(
                inflater,
                container,
                false
            )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val botao = binding.formularioNotaBotaoSalvarFragment
        botao.setOnClickListener {
            salvaNota()
        }
    }

    private fun salvaNota() {
        val campoTitulo = binding.formularioNotaTituloFragment
        val titulo = campoTitulo.text.toString()
        val campoDescricao = binding.formularioNotaDescricaoFragment
        val descricao = campoDescricao.text.toString()
        val nota = Nota(
            titulo = titulo,
            descricao = descricao
        )
        SalvaNotaTask(dao, nota) {
            activity?.onBackPressed()
        }.execute()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}