package br.com.alura.todo.asynctask

import android.os.AsyncTask
import br.com.alura.todo.database.dao.NotaDao
import br.com.alura.todo.model.Nota

class BuscaNotasTask(
    private val dao: NotaDao,
    private val quandoNotasEncontradas: (notas: List<Nota>) -> Unit
) : AsyncTask<Unit, Unit, List<Nota>>() {

    override fun doInBackground(vararg p0: Unit?): List<Nota> {
        return dao.buscaTodos()
    }

    override fun onPostExecute(resultado: List<Nota>?) {
        resultado?.let { notas ->
            quandoNotasEncontradas(notas)
        }
    }

}