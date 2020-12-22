package br.com.alura.todo.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.todo.databinding.ItemNotaBinding
import br.com.alura.todo.model.Nota

class ListaNotasAdapter(
    private val context: Context,
    notas: List<Nota> = listOf()
) :
    RecyclerView.Adapter<ListaNotasAdapter.ViewHolder>() {

    private val notas = notas.toMutableList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ItemNotaBinding
            .inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        posicao: Int
    ) {
        val nota = notas[posicao]
        holder.vincula(nota)
    }

    override fun getItemCount(): Int = notas.size

    fun atualiza(notas: List<Nota>) {
        this.notas.clear()
        this.notas.addAll(notas)
        notifyDataSetChanged()
    }

    class ViewHolder(binding: ItemNotaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val titulo = binding.itemNotaTitulo
        private val descricao = binding.itemNotaDescricao

        fun vincula(nota: Nota) {
            titulo.text = nota.titulo
            descricao.text = nota.descricao
        }

    }

}
