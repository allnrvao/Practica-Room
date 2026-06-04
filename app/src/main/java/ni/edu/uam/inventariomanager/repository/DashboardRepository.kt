package ni.edu.uam.inventariomanager.repository

import ni.edu.uam.inventariomanager.dao.EquipoDao
import ni.edu.uam.inventariomanager.model.Dashboard

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

    suspend fun obtenerDashboard(): Dashboard {

        return Dashboard(
            totalEquipos = totalEquipos(),
            disponibles = totalDisponibles(),
            prestados = totalPrestados()
        )

    }

}