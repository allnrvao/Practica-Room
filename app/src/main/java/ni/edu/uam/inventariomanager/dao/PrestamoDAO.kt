package ni.edu.uam.inventariomanager.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ni.edu.uam.inventariomanager.model.Prestamo

@Dao
interface PrestamoDao {

    @Insert
    suspend fun insertar(prestamo: Prestamo)

    @Update
    suspend fun actualizar(prestamo: Prestamo)

    @Delete
    suspend fun eliminar(prestamo: Prestamo)

    @Query("""
        SELECT *
        FROM prestamos
        ORDER BY fechaPrestamo DESC
    """)
    fun obtenerHistorial(): Flow<List<Prestamo>>

    @Query("""
        SELECT *
        FROM prestamos
        WHERE fechaDevolucion IS NULL
    """)
    fun prestamosActivos(): Flow<List<Prestamo>>

    @Query("""
        SELECT *
        FROM prestamos
        WHERE id = :id
    """)
    suspend fun obtenerPorId(id: Int): Prestamo?
}