package ni.edu.uam.inventariomanager.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ni.edu.uam.inventariomanager.dao.AdministradorDao
import ni.edu.uam.inventariomanager.dao.EquipoDao
import ni.edu.uam.inventariomanager.dao.PrestamoDao
import ni.edu.uam.inventariomanager.model.Administrador
import ni.edu.uam.inventariomanager.model.Equipo
import ni.edu.uam.inventariomanager.model.Prestamo

@Database(
    entities = [
        Equipo::class,
        Prestamo::class,
        Administrador::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun equipoDao(): EquipoDao

    abstract fun prestamoDao(): PrestamoDao

    abstract fun administradorDao(): AdministradorDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun obtenerBaseDatos(
            context: Context
        ): AppDatabase {

            return INSTANCE ?: synchronized(this) {

                val instancia = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "inventario_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instancia

                instancia
            }
        }
    }
}