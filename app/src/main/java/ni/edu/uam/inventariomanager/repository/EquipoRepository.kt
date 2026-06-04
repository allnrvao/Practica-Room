package ni.edu.uam.inventariomanager.repository

import kotlinx.coroutines.flow.Flow
import ni.edu.uam.inventariomanager.dao.EquipoDao
import ni.edu.uam.inventariomanager.model.Equipo

class EquipoRepository(
    private val equipoDao: EquipoDao
) {

    val equipos: Flow<List<Equipo>> =
        equipoDao.obtenerTodos()

    fun buscar(texto: String): Flow<List<Equipo>> {
        return equipoDao.buscar(texto)
    }

    fun filtrarCategoria(categoria: String): Flow<List<Equipo>> {
        return equipoDao.filtrarPorCategoria(categoria)
    }

    fun obtenerDisponibles(): Flow<List<Equipo>> {
        return equipoDao.obtenerDisponibles()
    }

    suspend fun obtenerPorId(id: Int): Equipo? {
        return equipoDao.obtenerPorId(id)
    }

    suspend fun insertar(equipo: Equipo) {
        equipoDao.insertar(equipo)
    }

    suspend fun actualizar(equipo: Equipo) {
        equipoDao.actualizar(equipo)
    }

    suspend fun eliminar(equipo: Equipo) {
        equipoDao.eliminar(equipo)
    }
}