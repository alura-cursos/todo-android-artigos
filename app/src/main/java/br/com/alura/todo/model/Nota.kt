package br.com.alura.todo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Nota(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val titulo: String,
    val descricao: String
)
