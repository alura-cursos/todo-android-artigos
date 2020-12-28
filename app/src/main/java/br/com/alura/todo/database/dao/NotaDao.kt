package br.com.alura.todo.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.alura.todo.model.Nota

@Dao
interface NotaDao {

    @Query("SELECT * FROM nota")
    fun buscaTodas(): List<Nota>

    @Insert
    fun salva(vararg nota: Nota)

}