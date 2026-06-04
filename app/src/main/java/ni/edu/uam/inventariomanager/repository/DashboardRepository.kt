package ni.edu.uam.inventariomanager.repository

import ni.edu.uam.inventariomanager.dao.EquipoDao

class DashboardRepository(
    private val equipoDao: EquipoDao
) {

    suspend fun totalEquipos(): Int {

        return equipoDao.totalEquipos()

    }

    suspend fun totalDisponibles(): Int {

        return equipoDao.totalDisponibles()

    }

    suspend fun totalPrestados(): Int {

        return equipoDao.totalPrestados()

    }

}