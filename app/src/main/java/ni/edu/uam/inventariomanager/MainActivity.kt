package ni.edu.uam.inventariomanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import ni.edu.uam.inventariomanager.database.AppDatabase
import ni.edu.uam.inventariomanager.navigation.NavGraph
import ni.edu.uam.inventariomanager.repository.*
import ni.edu.uam.inventariomanager.viewmodel.*

class MainActivity : ComponentActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {

        super.onCreate(
            savedInstanceState
        )

        setContent {

            val db =
                AppDatabase.obtenerBaseDatos(
                    applicationContext
                )

            val equipoRepository =
                EquipoRepository(
                    db.equipoDao()
                )

            val prestamoRepository =
                PrestamoRepository(
                    db.prestamoDao(),
                    db.equipoDao()
                )

            val dashboardRepository =
                DashboardRepository(
                    db.equipoDao()
                )

            val administradorRepository =
                AdministradorRepository(
                    db.administradorDao()
                )

            val factory =
                AppViewModelFactory(

                    equipoRepository,

                    prestamoRepository,

                    dashboardRepository,

                    administradorRepository

                )

            val equipoViewModel: EquipoViewModel =
                viewModel(
                    factory = factory
                )

            val prestamoViewModel: PrestamoViewModel =
                viewModel(
                    factory = factory
                )

            val dashboardViewModel: DashboardViewModel =
                viewModel(
                    factory = factory
                )

            val loginViewModel: LoginViewModel =
                viewModel(
                    factory = factory
                )

            NavGraph(

                loginViewModel =
                    loginViewModel,

                dashboardViewModel =
                    dashboardViewModel,

                equipoViewModel =
                    equipoViewModel,

                prestamoViewModel =
                    prestamoViewModel

            )

        }

    }

}