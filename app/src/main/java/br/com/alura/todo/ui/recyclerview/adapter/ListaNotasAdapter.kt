package br.com.alura.todo.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.todo.R
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
    ) = ViewHolder(
        LayoutInflater
            .from(context)
            .inflate(
                R.layout.item_nota,
                parent,
                false
            )
    )

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

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val titulo = itemView.findViewById<TextView>(R.id.item_nota_titulo)
        private val descricao = itemView.findViewById<TextView>(R.id.item_nota_descricao)

        fun vincula(nota: Nota) {
            titulo.text = nota.titulo
            descricao.text = nota.descricao
        }

    }


}
