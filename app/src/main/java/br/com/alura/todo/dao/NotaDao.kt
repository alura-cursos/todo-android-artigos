package br.com.alura.todo.dao

import br.com.alura.todo.model.Nota

class NotaDao {

    val notas = Companion.notas.toList()

    fun salva(vararg nota: Nota) {
        Companion.notas.addAll(nota)
    }

    companion object {
        private val notas = mutableListOf<Nota>()
    }

}