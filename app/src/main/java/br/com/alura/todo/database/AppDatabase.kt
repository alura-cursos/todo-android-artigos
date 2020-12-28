package br.com.alura.todo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.alura.todo.database.dao.NotaDao
import br.com.alura.todo.model.Nota

private const val NOME_BANCO_DE_DADOS = "todo.db"

@Database(
    entities = [Nota::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun notaDao(): NotaDao

    companion object {
        fun getInstance(context: Context): AppDatabase =
            Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                NOME_BANCO_DE_DADOS
            ).build()
    }

}