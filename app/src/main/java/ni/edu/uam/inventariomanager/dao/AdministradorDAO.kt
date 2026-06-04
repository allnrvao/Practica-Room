package ni.edu.uam.inventariomanager.dao

import androidx.room.*
import ni.edu.uam.inventariomanager.model.Administrador

@Dao
interface AdministradorDao {

    @Insert
    suspend fun insertar(administrador: Administrador)

    @Update
    suspend fun actualizar(administrador: Administrador)

    @Delete
    suspend fun eliminar(administrador: Administrador)

    @Query("""
        SELECT *
        FROM administradores
        WHERE usuario = :usuario
        AND password = :password
        LIMIT 1
    """)
    suspend fun login(
        usuario: String,
        password: String
    ): Administrador?

    @Query("SELECT * FROM administradores")
    suspend fun obtenerTodos(): List<Administrador>
}