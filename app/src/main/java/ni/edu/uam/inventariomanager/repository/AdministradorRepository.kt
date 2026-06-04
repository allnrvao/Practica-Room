package ni.edu.uam.inventariomanager.repository

import ni.edu.uam.inventariomanager.dao.AdministradorDao
import ni.edu.uam.inventariomanager.model.Administrador

class AdministradorRepository(
    private val administradorDao: AdministradorDao
) {

    suspend fun login(
        usuario: String,
        password: String
    ): Administrador? {

        return administradorDao.login(
            usuario,
            password
        )

    }

    suspend fun insertar(
        administrador: Administrador
    ) {

        administradorDao.insertar(
            administrador
        )

    }

    suspend fun obtenerTodos(): List<Administrador> {

        return administradorDao.obtenerTodos()

    }

}