package br.com.alura.todo.asynctask

import android.os.AsyncTask
import br.com.alura.todo.database.dao.NotaDao
import br.com.alura.todo.model.Nota

class SalvaNotaTask(
    private val dao: NotaDao,
    private val nota: Nota,
    val quandoNotaSalva: () -> Unit,
) : AsyncTask<Unit, Unit, Unit>() {

    override fun doInBackground(vararg p0: Unit?) {
        dao.salva(nota)
    }

    override fun onPostExecute(result: Unit?) {
        quandoNotaSalva()
    }

}