package ni.edu.uam.inventariomanager.repository

import kotlinx.coroutines.flow.Flow
import ni.edu.uam.inventariomanager.dao.EquipoDao
import ni.edu.uam.inventariomanager.dao.PrestamoDao
import ni.edu.uam.inventariomanager.model.Prestamo

class PrestamoRepository(
    private val prestamoDao: PrestamoDao,
    private val equipoDao: EquipoDao
) {

    val historial: Flow<List<Prestamo>> =
        prestamoDao.obtenerHistorial()

    fun prestamosActivos(): Flow<List<Prestamo>> {
        return prestamoDao.prestamosActivos()
    }

    suspend fun registrarPrestamo(
        prestamo: Prestamo
    ) {

        prestamoDao.insertar(prestamo)

        val equipo = equipoDao.obtenerPorId(prestamo.equipoId)

        equipo?.let {

            equipoDao.actualizar(
                it.copy(
                    disponible = false
                )
            )
        }
    }

    suspend fun registrarDevolucion(
        prestamo: Prestamo
    ) {

        prestamoDao.actualizar(prestamo)

        val equipo = equipoDao.obtenerPorId(prestamo.equipoId)

        equipo?.let {

            equipoDao.actualizar(
                it.copy(
                    disponible = true
                )
            )
        }
    }

    suspend fun eliminar(prestamo: Prestamo) {
        prestamoDao.eliminar(prestamo)
    }

}