package ni.edu.uam.inventariomanager.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import ni.edu.uam.inventariomanager.model.Equipo

@Dao
interface EquipoDao {

    @Insert
    suspend fun insertar(equipo: Equipo)

    @Update
    suspend fun actualizar(equipo: Equipo)

    @Delete
    suspend fun eliminar(equipo: Equipo)

    @Query("SELECT * FROM equipos ORDER BY nombre")
    fun obtenerTodos(): Flow<List<Equipo>>

    @Query("""
        SELECT * FROM equipos
        WHERE nombre LIKE '%' || :texto || '%'
        OR numeroSerie LIKE '%' || :texto || '%'
        ORDER BY nombre
    """)
    fun buscar(texto: String): Flow<List<Equipo>>

    @Query("""
        SELECT * FROM equipos
        WHERE categoria = :categoria
        ORDER BY nombre
    """)
    fun filtrarPorCategoria(categoria: String): Flow<List<Equipo>>

    @Query("""
        SELECT * FROM equipos
        WHERE disponible = 1
        ORDER BY nombre
    """)
    fun obtenerDisponibles(): Flow<List<Equipo>>

    @Query("""
        SELECT * FROM equipos
        WHERE id = :id
    """)
    suspend fun obtenerPorId(id: Int): Equipo?

    @Query("SELECT COUNT(*) FROM equipos")
    suspend fun totalEquipos(): Int

    @Query("""
        SELECT COUNT(*)
        FROM equipos
        WHERE disponible = 1
    """)
    suspend fun totalDisponibles(): Int

    @Query("""
        SELECT COUNT(*)
        FROM equipos
        WHERE disponible = 0
    """)
    suspend fun totalPrestados(): Int

}